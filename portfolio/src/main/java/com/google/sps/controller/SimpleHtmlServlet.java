package com.google.sps.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "simple-html",
            urlPatterns = {"/simple-html"})
public class SimpleHtmlServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws
                                                                                ServletException,
                                                                                IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println(
                "<html><body><a href='./'>Home</a><br/>Hello, friend :)</body></html>");

    }

}
