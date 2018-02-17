package com.leco.restcountries;

import javax.persistence.*;

@Entity
@Table(name = "currencies")
public class Currency {

    @Id
    private int id_cur;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id",nullable = false)
    private Countrydb country;
    private String code;
    private String name;
    private String symbol;

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
        return ""+name+" - "+code+" "+symbol;

    }
}
