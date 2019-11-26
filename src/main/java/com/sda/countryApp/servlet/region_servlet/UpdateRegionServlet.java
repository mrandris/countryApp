package com.sda.countryApp.servlet.region_servlet;

import com.sda.countryApp.model.Region;
import com.sda.countryApp.repository.RegionRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@WebServlet ("/region/update")
public class UpdateRegionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // calling regionList from RegionRepository
        List<Region> regionList = RegionRepository.getRegionList();

        int regionId = Integer.parseInt(req.getParameter("id"));
        for(Region r : regionList) {
            if(r.getIdRegion() == regionId) {
                // send region to request
                req.setAttribute("r", r);
                // send request to update
                req.getRequestDispatcher("/regionUpdate.jsp").forward(req, resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String regionName = req.getParameter("name");
        List<Region> regionList = RegionRepository.getRegionList();

        int regionId = Integer.parseInt(req.getParameter("id"));
        for(Region r : regionList) {
            if (r.getIdRegion() == regionId) {
                r.setName(regionName);
            }
        }

        resp.sendRedirect("http://localhost:8080/CountryApp/region/list");
    }
}
