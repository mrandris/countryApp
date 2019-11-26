package com.sda.countryApp.servlet.region_servlet;

import com.sda.countryApp.model.Region;
import com.sda.countryApp.repository.RegionRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/region/list")
public class ListRegionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // calling regionList from RegionRepository
        List<Region> regionList = RegionRepository.getRegionList();
        // sending regionList to the request
        req.setAttribute("regionList", regionList);
        // sending request to JSP
        req.getRequestDispatcher("/regionListView.jsp").forward(req, resp);
    }
}
