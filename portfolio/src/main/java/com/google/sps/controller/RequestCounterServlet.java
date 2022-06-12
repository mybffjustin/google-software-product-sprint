package com.google.sps.controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "request-counter",
            urlPatterns = {"/request-counter"})
public class RequestCounterServlet extends HttpServlet {
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        int count = 0;

        getServletContext().setAttribute("counter", count);
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws
                                                                                   ServletException,
                                                                                   IOException {
        ServletContext servletContext = getServletContext();

        Integer count = (Integer) servletContext.getAttribute("counter");

        ++count;

        servletContext.setAttribute("counter", count);

        PrintWriter out = response.getWriter();

        response.setContentType("text/html");
        out.println("<html><head><title>Request Counter</title></head><body>");
        out.print("<a href='./'>Home</a>");
        out.println(count);
        out.println("<p>The counter is incremented.</p>");
        out.println("</body></html>");
    }
}
