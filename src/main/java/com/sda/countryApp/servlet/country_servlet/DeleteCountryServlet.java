package com.sda.countryApp.servlet.country_servlet;

import com.sda.countryApp.model.Country;
import com.sda.countryApp.repository.CountryRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;

@WebServlet ("/country/delete")
public class DeleteCountryServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
/*        Iterator<Country> i = CountryRepository.getCountryList().iterator();
        Country country;
        String countryName = req.getParameter("name");
        while (i.hasNext()) {
            country = i.next();
            if(country.getName().equals(countryName)) {
                i.remove();
                break;
            }
        }*/

        String countryName = req.getParameter("name");
        Country country = CountryRepository.getCountryByName(countryName);
        CountryRepository.getCountryList().remove(country);

        resp.sendRedirect("http://localhost:8080/CountryApp/country/list");
    }
}
