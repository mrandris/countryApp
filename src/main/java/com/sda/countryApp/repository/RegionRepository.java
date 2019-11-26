package com.sda.countryApp.repository;

import com.sda.countryApp.model.Region;

import java.util.ArrayList;
import java.util.List;

public class RegionRepository {
    private static List<Region> regionList = null;
    private static int counter = 0;

    public static List<Region> getRegionList() {
        if (regionList == null) {
            regionList = new ArrayList<>();
            regionList.add(new Region(1, "Europe"));
            counter++;
            regionList.add(new Region(2, "Asia"));
            counter++;
            regionList.add(new Region(3, "Africa"));
            counter++;
        }
        return regionList;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        RegionRepository.counter = counter;
    }

    public static Region getRegionById(int id) {
        for(Region r : regionList) {
            if(id == r.getIdRegion()) {
                return r;
            }
        }
        return null;
    }

    public static Region getRegionByName(String name) {
        for(Region r : regionList) {
            if(r.getName().equals(name)) {
                return r;
            }
        }
        return null;
    }
}
