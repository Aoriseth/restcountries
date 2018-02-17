package com.leco.restcountries.Entities;

import javax.persistence.*;

@Entity
@Table(name = "currencies")
public class Currency {

    @Id
    private int id_cur;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id",nullable = false)
    private Country country;
    private String code;
    private String name;
    private String symbol;

    public int getId_cur() {
        return id_cur;
    }

    public void setId_cur(int id_cur) {
        this.id_cur = id_cur;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "id_cur=" + id_cur +
                ", country=" + country +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                '}';
    }
}
