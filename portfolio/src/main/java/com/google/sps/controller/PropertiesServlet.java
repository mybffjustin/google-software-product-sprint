package com.google.sps.controller;

import com.google.sps.util.PropLoader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

/**
 * [Properties Servlet] This class represents PropertiesServlet
 *
 * @author jkhoang
 */
@WebServlet(name = "propertiesServlet",
            urlPatterns = {"/propertiesServlet"})
public class PropertiesServlet extends HttpServlet implements PropLoader {
    /**
     * This declaration, "properties", is a Properties instance variable that
     * represents properties.
     */
    private Properties properties;
    /**
     * This declaration is for a String that represents the properties file
     * path.
     */
    private String     propertiesFilePath;

    /**
     * This instance method, "init", initializes.
     */
    public void init() {
        log("Is this logging? <= is from the log (PropertiesServlet.java)");
        propertiesFilePath = "/propdemo.properties";
        properties         = new Properties(load(propertiesFilePath));
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

        PrintWriter out = response.getWriter();
        log("Is this logging? <= is from the log (PropertiesServlet.java)");
        out.print("<HTML>");
        out.print("<HEAD><TITLE>Justin Hoang | Properties " +
                  "Servlet</TITLE></HEAD>");
        out.print("<BODY>");
        out.print("<h1>Properties Servlet</h1>" + "<br>");
        out.print("<a href='./'>Home</a>" + "<br>");
        out.print("<img src='./img/blog1.webp' alt='bear' " + "width='350' >" +
                  "<br>");
        out.print("<table>");
        out.print("<thead>");
        out.print("<tr>");
        out.print("<th>Author</th>");
        out.print("<th>Author Email</th>");
        out.print("<th>Program Title</th>");
        out.print("<th>Program Session</th>");
        out.print("<th>Program Dates</th>");
        out.print("<th>Talent Development Team</th>");
        out.print("<th>Curriculum Leads</th>");
        out.print("<th>Lead Project Advisors</th>");
        out.print("<th>Lead Tech Coaches</th>");
        out.print("<th>Program Managers</th>");
        out.print("<th>Cohort Lead</th>");
        out.print("<th>Project Advisor</th>");
        out.print("<th>Project Description</th>");
        out.print("</tr>");
        out.print("</thead>");
        out.print("<tbody>");
        out.print("<tr>");
        out.print("<td>" + properties.getProperty("author") + "</td>");
        out.print("<td>" + properties.getProperty("author.email.address") +
                  "</td>");
        out.print("<td>" + properties.getProperty("program.title") + "</td>");
        out.print("<td>" + properties.getProperty("program.session") + "</td>");
        out.print("<td>" + properties.getProperty("program.dates") + "</td>");
        out.print("<td>" +
                  properties.getProperty("talent.development.team.names") +
                  "</td>");
        out.print("<td>" + properties.getProperty("curriculum.lead.names") +
                  "</td>");
        out.print(
                "<td>" + properties.getProperty("lead.project.advisor.names") +
                "</td>");
        out.print("<td>" + properties.getProperty("lead.tech.coach.names") +
                  "</td>");
        out.print("<td>" + properties.getProperty("program.manager.names") +
                  "</td>");
        out.print(
                "<td>" + properties.getProperty("cohort.lead.name") + "</td>");
        out.print("<td>" + properties.getProperty("project.advisor.name") +
                  "</td>");
        out.print("<td>" + properties.getProperty("project.description") +
                  "</td>");
        out.print("</tr>");
        out.print("</tbody>");
        out.print("</table>");

        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
    }
}
