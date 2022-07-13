package com.google.sps.controller;

import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/pokemon")
public class PokemonServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws
                                                                                IOException {

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Charmander");
        arrayList.add("Squirtle");
        arrayList.add("Bulbasaur");
        arrayList.add("Pikachu");

        String json = convertToJsonUsingGson(arrayList);

        response.setContentType("application/json;");
        response.getWriter().println(json);
    }

    private String convertToJsonUsingGson(ArrayList<String> arrayList) {
        return new Gson().toJson(arrayList);
    }
}
