package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class IndexController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        response.getWriter().write(String.valueOf(calc(request)));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        response.getWriter().write(String.valueOf(calc(request)));
    }

    private Integer calc(HttpServletRequest request){
        int num1 = Integer.valueOf(request.getParameter("num1"));
        int num2 = Integer.valueOf(request.getParameter("num2"));
        String op = request.getParameter("op");

        int result = 0;

        if (op.equals("+")) {
            result = num1 + num2;

        } else if (op.equals("-")) {
            result = num1 - num2;

        } else if (op.equals("*")) {
            result = num1 * num2;

        } else if (op.equals("/")) {
            result = num1 / num2;
        }

        return result;
    }
}
