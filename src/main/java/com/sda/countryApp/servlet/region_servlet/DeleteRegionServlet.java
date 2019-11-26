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

@WebServlet ("/region/delete")
public class DeleteRegionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
/*        Iterator<Region> i = RegionRepository.getRegionList().iterator();
        Region region;
        String regionName = req.getParameter("name");
        while (i.hasNext()) {
            region = i.next();
            if(region.getName().equals(regionName)) {
                i.remove();
                break;
            }
        }*/

        String regionName = req.getParameter("name");
        Region region = RegionRepository.getRegionByName(regionName);
        RegionRepository.getRegionList().remove(region);

        resp.sendRedirect("http://localhost:8080/CountryApp/region/list");
    }
}
