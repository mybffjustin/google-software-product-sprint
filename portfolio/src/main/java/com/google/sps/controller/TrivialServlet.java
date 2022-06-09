package com.google.sps.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "trivialServlet",
            urlPatterns = {"/trivialServlet"})
public class TrivialServlet extends HttpServlet {

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

        // set the response type before sending data
        PrintWriter out = response.getWriter();
        out.print("<HTML>");
        out.print("<HEAD><TITLE> Justin Hoang | Trivial Servlet " + "</TITLE" +
                  "></HEAD>");
        out.print("<BODY>");
        out.print("<h1> Trivial Servlet</h1>");
        out.print("<h1> @mybffjustin TrivialServlet Here! :) </h1>");
        out.print("<a href='./'>Home</a>");
        out.print("<br>");
        out.print("<img src='./img/blog1.webp' alt='bear' width='350' >");
        System.out.println("Is this logging?");
        log("Is this logging?");
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
    }

}
