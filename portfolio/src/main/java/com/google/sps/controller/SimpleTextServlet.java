package com.google.sps.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "simpleServlet",
            urlPatterns = {"/simpleServlet"})
public class SimpleTextServlet extends HttpServlet {

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
        response.setContentType("text/plain");

        // set the response type before sending data
        PrintWriter out = response.getWriter();
        out.print("<HTML>");
        out.print("<HEAD><TITLE>Justin Hoang | SimpleTextServlet " +
                  "Output</TITLE></HEAD>");
        out.print("<BODY>");
        out.print("<h1> @mybffjustin SimpleTextServlet Here! :) </h1>");
        out.print("<a href='./'>Home</a>");
        out.print("<img src='./images/blog1.webp' alt='bear' width='350' >");
        //System.out.println("Is this logging? <= this is from a sout");
        log("Is this logging? <= is from the log");
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
    }

}
