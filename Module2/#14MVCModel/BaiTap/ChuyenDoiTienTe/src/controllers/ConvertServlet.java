package controllers;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(name = "ConvertServlet", urlPatterns = "/result")
public class ConvertServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
         String value = request.getParameter("inputValue");
         String rate = request.getParameter("typeConvert");
         request.setAttribute("value", value);
         request.setAttribute("rate", rate);
        request.setAttribute("result", Integer.parseInt(rate)*Integer.parseInt(value));
         request.getRequestDispatcher("/views/index.jsp").forward(request, response);
    }
}
