package com.google.sps.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Servlet Practice
 *
 * @author jkhoang
 */
@WebServlet(name = "practice",
            urlPatterns = {"/practice"})
public class PracticeServlet extends HttpServlet {
    private int hitCounter = 0;

    /**
     * This instance method, "init", initializes.
     */
    public void init() {
        hitCounter = 1;
        log("Is this logging? <= is from the log (PracticeServlet.java)");
    }

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

        Date        date    = new Date();
        HttpSession session = request.getSession();
        hitCounter++;

        PrintWriter out = response.getWriter();
        System.out.println("Is this logging? (PracticeServlet.java) (bad " +
                           "log version)");
        log("Is this logging? (PracticeServlet.java) (better log version)");
        out.print("<HTML>");
        out.print("<HEAD><TITLE>Servlet Practice</TITLE></HEAD>");
        out.print("<BODY>");
        out.print("<h1> Servlet Practice </h1>" + "<br>");
        out.print("<h1> @mybffjustin :) </h1>" + "<br>");
        out.print("<a href='./'>Home</a>" + "<br>");
        out.print("<img src='./img/blog1.webp' alt='bear' width='300' >" +
                  "<br>");

        out.print("<h2> Servlet Data</h2>");
        out.print("<table>");
        out.print("<thead>");
        out.print("<tr>");
        out.print("<th>HIT COUNTER</th>");
        out.print("<th>FIRST ACCESS</th>");
        out.print("<th>CURRENT DATE/TIME</th>");
        out.print("</tr>");
        out.print("</thead>");
        out.print("<tbody>");
        out.print("<tr>");
        out.print("<td>" + hitCounter + "</td>");
        out.print("<td>" + new Date(session.getCreationTime()) + "</td>");
        out.print("<td>" + date.toString() + "</td>");
        out.print("</tr>");
        out.print("</tbody>");
        out.print("</table>");
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
    }
}


