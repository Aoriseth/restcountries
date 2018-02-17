package com.leco.restcountries;

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
    private Set<Countrydb> countries = new HashSet<>();
    private String date;
    private Float rate;


}
