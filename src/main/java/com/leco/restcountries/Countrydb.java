package com.leco.restcountries;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "countries")
public class Countrydb {

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


}
