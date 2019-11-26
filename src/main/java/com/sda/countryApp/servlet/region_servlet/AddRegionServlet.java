package com.sda.countryApp.servlet.region_servlet;

import com.sda.countryApp.model.Region;
import com.sda.countryApp.repository.RegionRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet ("/region/add")
public class AddRegionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        int regionId = Integer.parseInt(req.getParameter("id"));
        int regionId = RegionRepository.getCounter()+1;
        String regionName = req.getParameter("name");

        Region newRegion = new Region(regionId, regionName);
        RegionRepository.getRegionList().add(newRegion);
        RegionRepository.setCounter(RegionRepository.getCounter()+1);
        resp.sendRedirect("http://localhost:8080/CountryApp/region/list");
    }
}
