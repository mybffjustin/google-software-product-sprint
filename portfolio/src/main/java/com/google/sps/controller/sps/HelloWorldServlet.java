package com.google.sps.controller.sps;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Handles requests sent to the /hello URL. Try running a server and navigating
 * to /hello!
 */
@WebServlet(name = "hello",
            urlPatterns = {"/hello"})
public class HelloWorldServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws
                                                                                IOException {
        System.out.println("Is this logging? (HelloWorldServlet.java) (bad " +
                           "log version)");
        log("Is this logging? (HelloWorldServlet.java) (better log version)");
        response.setContentType("text/html;");
        response.getWriter().println("<h1>Hello, friend!</h1>");
    }
}
