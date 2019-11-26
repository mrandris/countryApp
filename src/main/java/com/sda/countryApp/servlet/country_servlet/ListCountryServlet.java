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

@WebServlet ("/country/list")
public class ListCountryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Region> regionList = RegionRepository.getRegionList();

        List<Country> countryList = CountryRepository.getCountryList();
        req.setAttribute("countryList", countryList);

        req.setAttribute("regionList", regionList);
        req.getRequestDispatcher("/countryListView.jsp").forward(req, resp);
    }
}
