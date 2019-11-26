package com.sda.countryApp.model;

public class Country {
    private int idCountry;
    private String name;
    private Region region;

    public Country(int idCountry, String name) {
        this.idCountry = idCountry;
        this.name = name;
    }

    public int getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(int idCountry) {
        this.idCountry = idCountry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

}
