package com.leco.restcountries.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "rates")
class Rates {

    @Id
    private String base;
    @ManyToMany(mappedBy = "rates")
    private Set<Country> countries = new HashSet<>();
    private String date;
    private Float rate;

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Set<Country> getCountries() {
        return countries;
    }

    public void setCountries(Set<Country> countries) {
        this.countries = countries;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Rates{" +
                "base='" + base + '\'' +
                ", countries=" + countries +
                ", date='" + date + '\'' +
                ", rate=" + rate +
                '}';
    }
}
