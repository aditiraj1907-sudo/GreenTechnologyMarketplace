package com.green.servlet;

import com.green.dao.UserDAO;
import com.green.model.User;
import com.green.util.DBConnection;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        User user = new User();

        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(role);

    Connection connection = DBConnection.getConnection();

      System.out.println("Connection: " + connection);
      System.out.println("REGISTER SERVLET HIT");

    UserDAO userDAO = new UserDAO(connection);

        boolean result = userDAO.addUser(user);

        response.setContentType("text/html");

        if (result) {
            response.getWriter().println("<h2>Registration Successful!</h2>");
        } else {
            response.getWriter().println("<h2>Registration Failed!</h2>");
        }
    }
}