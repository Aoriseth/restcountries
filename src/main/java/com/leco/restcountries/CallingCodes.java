package com.leco.restcountries;

import javax.persistence.*;

@Entity
@Table(name = "callingcodes")
public class CallingCodes {
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    @Id
    private String code;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", nullable = false)
    private Countrydb country;


}
