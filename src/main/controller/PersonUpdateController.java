package controller;

import com.google.gson.Gson;
import model.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class PersonUpdateController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("Access-Control-Allow-Origin", "*");

        int id = Integer.parseInt(req.getParameter("id"));
        String fname = req.getParameter("fname");
        String lname = req.getParameter("lname");
        int age = Integer.parseInt(req.getParameter("age"));

        Person modelPerson = new Person();
        modelPerson.update(new Person(id, fname, lname, age));

        String json = new Gson().toJson(new Person(id, fname, lname, age));

        resp.getWriter().write(json);
    }
}