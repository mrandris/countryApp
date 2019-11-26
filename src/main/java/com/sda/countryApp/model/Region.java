package com.sda.countryApp.model;

import java.util.ArrayList;
import java.util.List;

public class Region {
    private int idRegion;
    private String name;
    private List<Country> countryList = new ArrayList<>();

    public Region(int idRegion, String name) {
        this.idRegion = idRegion;
        this.name = name;
    }

    public int getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(int idRegion) {
        this.idRegion = idRegion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Country> getCountryList() {
        return countryList;
    }

    public void addCountry(Country country) {
        countryList.add(country);
    }

    public void removeCountry(Country country) {
        countryList.remove(country);
    }
}
