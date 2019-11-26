package com.sda.countryApp.servlet.country_servlet;

import com.sda.countryApp.model.Country;
import com.sda.countryApp.model.Region;
import com.sda.countryApp.repository.CountryRepository;
import com.sda.countryApp.repository.RegionRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@WebServlet("/region/country/list")
public class ListCountryByRegion extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //
        List<Region> regionList = RegionRepository.getRegionList();
        req.setAttribute("regionList", regionList);

        int regionId = Integer.parseInt(req.getParameter("id"));
        Region region = RegionRepository.getRegionById(regionId);

        List<Country> countryList = region.getCountryList();
        req.setAttribute("countryList", countryList);


/*        Iterator<Region> i = regionList.iterator();
        while (i.hasNext()) {
            region = i.next();
            if(region.getIdRegion() == Integer.parseInt(req.getParameter("id"))) {
                for(Country country: region.getCountryList()) {
                    System.out.println(country.getName());
                }
                List<Country> countryList = region.getCountryList();
                req.setAttribute("countryList", countryList);
            }
        }*/

        req.getRequestDispatcher("/countryListView.jsp").forward(req, resp);
    }
}
