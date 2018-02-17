package com.leco.restcountries;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "countries")
public class Country {

    @Id
    private int country_id;
    private String name;
    private String capital;
    private String population;
    private String flag;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "country")
    private Set<Currency> currencies;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "country")
    private Set<Currency> CallingCodes;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "countrycodes",joinColumns = @JoinColumn(name = "country_id"),inverseJoinColumns = @JoinColumn(name = "base"))
    private Set<Rates> rates = new HashSet<>();


    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Set<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(Set<Currency> currencies) {
        this.currencies = currencies;
    }

    public Set<Currency> getCallingCodes() {
        return CallingCodes;
    }

    public void setCallingCodes(Set<Currency> callingCodes) {
        CallingCodes = callingCodes;
    }

    public Set<Rates> getRates() {
        return rates;
    }

    public void setRates(Set<Rates> rates) {
        this.rates = rates;
    }

    @Override
    public String toString() {
        return "Country{" +
                "country_id=" + country_id +
                ", name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", population='" + population + '\'' +
                ", flag='" + flag + '\'' +
                ", currencies=" + currencies +
                ", CallingCodes=" + CallingCodes +
                ", rates=" + rates +
                '}';
    }
}
