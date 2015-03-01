/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.controller;

import com.blogspot.na5cent.service.EmployeeSearchService;
import com.blogspot.na5cent.service.SearchServiceUtils;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author anonymous
 */
@WebServlet(urlPatterns = "/employees")
public class EmployeeCtrl extends HttpServlet {

    private void query(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        String query = req.getParameter("q");
        String searchBy = req.getParameter("search_by");

        EmployeeSearchService service = SearchServiceUtils.findServiceByName(searchBy);
        req.setAttribute("employees", service.search(query));
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        query(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        query(req, resp);
    }

}
