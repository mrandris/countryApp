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

@WebServlet ("/country/update")
public class UpdateCountryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // calling countryList from CountryRepository
        List<Country> countryList = CountryRepository.getCountryList();
        List<Region> regionList = RegionRepository.getRegionList();
        // sending regionList to the request
        req.setAttribute("regionList", regionList);

        int countryId = Integer.parseInt(req.getParameter("id"));
        for(Country country : countryList) {
            if(country.getIdCountry() == countryId) {
                // send country to request
                req.setAttribute("country", country);
                // send request to update
                req.getRequestDispatcher("/countryUpdate.jsp").forward(req, resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // get list of countries
        List<Country> countryList = CountryRepository.getCountryList();

        // receive new country name
/*        String countryName = req.getParameter("name");
        int regionId = Integer.parseInt(req.getParameter("region"));

        int countryId = Integer.parseInt(req.getParameter("id"));
        for(Country country : countryList) {
            if (country.getIdCountry() == countryId) {
                country.setName(countryName);
                for(Region r : RegionRepository.getRegionList()) {
                    if(r.getIdRegion() == regionId) {
                        country.getRegion().removeCountry(country);
                        country.setRegion(r);
                        r.addCountry(country);
                    }
                }
            }
        }*/

        //or:

        String countryName = req.getParameter("name");
        int countryId = Integer.parseInt(req.getParameter("id"));
        Country country = CountryRepository.getCountryById(countryId);

        int regionId = Integer.parseInt(req.getParameter("region"));
        Region r = RegionRepository.getRegionById(regionId);

        country.setName(countryName);
        country.getRegion().removeCountry(country);
        country.setRegion(r);
        r.addCountry(country);

/*        for(Country country : countryList) {
            if (country.getIdCountry() == countryId) {
                country.setName(countryName);
                country.getRegion().removeCountry(country);
                country.setRegion(r);
                r.addCountry(country);
            }
        }*/

        resp.sendRedirect("http://localhost:8080/CountryApp/country/list");
    }
}
