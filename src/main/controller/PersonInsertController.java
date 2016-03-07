package controller;

import com.google.gson.Gson;
import model.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class PersonInsertController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("Access-Control-Allow-Origin", "*");

        String fname = req.getParameter("fname");
        String lname = req.getParameter("lname");
        int age = Integer.parseInt(req.getParameter("age"));

        Person modelPerson = new Person();
        modelPerson.insert(new Person(0, fname, lname, age));

        String json = new Gson().toJson(new Person(0, fname, lname, age));

        resp.getWriter().write(json);
    }
}