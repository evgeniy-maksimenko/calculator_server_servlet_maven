package controller;

import com.google.gson.Gson;
import model.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class PersonViewController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("Access-Control-Allow-Origin", "*");


        int id = Integer.parseInt(req.getParameter("id"));

        Person modelPerson = new Person();
        String json = new Gson().toJson(modelPerson.view(id));

        resp.getWriter().write(json);
    }
}