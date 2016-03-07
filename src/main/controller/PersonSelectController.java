package controller;

import com.google.gson.Gson;
import model.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PersonSelectController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        Person modelPerson = new Person();
        String json = new Gson().toJson(modelPerson.select());

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        response.getWriter().write(json);
    }
}
