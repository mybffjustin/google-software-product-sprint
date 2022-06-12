package com.google.sps.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "http-request",
            urlPatterns = {"/http-request"})
public class HttpRequestServlet extends HttpServlet {

    /**
     * Handles HTTP GET requests.
     *
     * @param request
     *         the HttpServletRequest object
     * @param response
     *         the HttpServletResponse object
     *
     * @throws ServletException
     *         if there is a Servlet failure
     * @throws IOException
     *         if there is an IO failure
     */
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws
                                                                                ServletException,
                                                                                IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        System.out.println("Is this logging? (HttpRequestServlet.java) (bad " +
                           "log version)");
        log("Is this logging? (HttpRequestServlet.java)");
        out.print("<html>");
        out.print("<head><title>Justin Hoang | HTTP Request</title></head>");
        out.print("<BODY>");
        out.print("<h1> HTTP Request</h1>" + "<br>");
        out.print("<a href='./'>Home</a>" + "<br>");
        out.print("<img src='./resources/img/index/blog1.webp' alt='bear' " +
                  "width='350' >" + "<br>");
        out.print("<ul>");
        out.print("<li> The current Locale of the request: " +
                  request.getLocale() + "</li>");
        out.print("<li> The Context Path of the request: " +
                  request.getServletContext() + "</li>");
        out.print(
                "<li> The Local Name of the server: " + request.getLocalName() +
                "</li>");
        out.print("<li> The Scheme used to make the request: " +
                  request.getScheme() + "</li>");
        out.print("</ul>");
        out.print("</body>");
        out.print("</html>");
        out.close();
    }
}
