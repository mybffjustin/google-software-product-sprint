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

@WebServlet("/requestCounterServlet")
public class RequestCounterServlet extends HttpServlet {
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        int count = 0;
        // save counter to the application scope
        getServletContext().setAttribute("counter", count);
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws
                                                                                   ServletException,
                                                                                   IOException {
        ServletContext servletContext = getServletContext();
        // get the counter
        Integer count = (Integer) servletContext.getAttribute("counter");

        // increment the counter
        ++count;

        // save it back the application scope
        servletContext.setAttribute("counter", count);

        // display the message "the counter is incremented"
        PrintWriter out = response.getWriter();

        response.setContentType("text/html");
        out.println("<html><head><title>Request Counter</title></head><body>");
        out.println(count);
        out.println("<p>The counter is incremented.</p>");
        out.println("</body></html>");
    }
}
