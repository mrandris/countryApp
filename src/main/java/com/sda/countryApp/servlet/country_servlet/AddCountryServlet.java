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
import java.util.List;

@WebServlet ("/country/add")
public class AddCountryServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // setting countryId - what if i delete a country? to modify countryId to match list size
        int countryId = CountryRepository.getCounter()+1;
        // getting country parameters from JSP
        String countryName = req.getParameter("name");
        int regionId = Integer.parseInt(req.getParameter("region"));
        // getting country's region by ID from RegionRepository
        Region region = RegionRepository.getRegionById(regionId);

        Country newCountry = new Country(countryId, countryName);

        newCountry.setRegion(region);
        region.addCountry(newCountry); // !!!! may produce null pointer exception if region is null

        // adding new country to CountryRepository
        CountryRepository.getCountryList().add(newCountry);
        CountryRepository.setCounter(CountryRepository.getCounter()+1);
        resp.sendRedirect("http://localhost:8080/CountryApp/country/list");
    }
}
