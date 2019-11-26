package com.sda.countryApp.repository;

import com.sda.countryApp.model.Country;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountryRepository {
    private static List<Country> countryList = new ArrayList<>();
    private static int counter = 0;

    public static List<Country> getCountryList() {
        return countryList;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        CountryRepository.counter = counter;
    }

    public static Country getCountryById(int id) {
        for(Country c : countryList) {
            if(id == c.getIdCountry()) {
                return c;
            }
        }
        return null;
    }

    public static Country getCountryByName(String name) {
        for(Country c : countryList) {
            if(c.getName().equals(name)) {
                return c;
            }
        }
        return null;
    }
}
