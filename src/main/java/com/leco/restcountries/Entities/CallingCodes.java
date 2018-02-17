package com.leco.restcountries.Entities;

import javax.persistence.*;

@Entity
@Table(name = "callingcodes")
public class CallingCodes {

    @Id
    private String code;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "CallingCodes{" +
                "code='" + code + '\'' +
                ", country=" + country +
                '}';
    }
}
