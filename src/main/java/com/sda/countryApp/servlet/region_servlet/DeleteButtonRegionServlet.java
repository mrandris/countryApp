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

@WebServlet("/region/deleteButton")
public class DeleteButtonRegionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
/*        Iterator<Region> i = RegionRepository.getRegionList().iterator();
        Region region;
        int regionId = Integer.parseInt(req.getParameter("id"));
        while (i.hasNext()) {
            region = i.next();
            if(region.getIdRegion() == regionId) {
                i.remove();
            }
        }*/

        int regionId = Integer.parseInt(req.getParameter("id"));
        Region region = RegionRepository.getRegionById(regionId);
        RegionRepository.getRegionList().remove(region);

        resp.sendRedirect("http://localhost:8080/CountryApp/region/list");
    }
}
