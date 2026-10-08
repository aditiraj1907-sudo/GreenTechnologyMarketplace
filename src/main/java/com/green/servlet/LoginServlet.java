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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Connection connection = DBConnection.getConnection();

        UserDAO userDAO = new UserDAO(connection);

        User user = userDAO.getUserByEmail(email);

        response.setContentType("text/html");

        if (user != null && user.getPassword().equals(password)) {

    request.getSession().setAttribute("userId", user.getId());

    System.out.println("Logged in User ID: " + user.getId());

     response.sendRedirect("products.jsp?customerId=" + user.getId());

} else {

    response.getWriter().println("<h2>Invalid Email or Password!</h2>");
}
    }
}
