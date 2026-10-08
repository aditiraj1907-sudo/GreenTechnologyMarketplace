package com.green.servlet;

import com.green.util.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/adminProduct")
public class AdminServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String productId = request.getParameter("productId");
        String action = request.getParameter("action");

        String status;

        if ("approve".equals(action)) {
            status = "approved";
        } else {
            status = "rejected";
        }

        try {
            Connection connection = DBConnection.getConnection();

            String sql = "UPDATE products SET status = ? WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, status);
            statement.setInt(2, Integer.parseInt(productId));

            int result = statement.executeUpdate();

            response.setContentType("text/html");

            if (result > 0) {
                response.getWriter().println(
                    "<h2>Product " + status + " successfully!</h2>"
                );
            } else {
                response.getWriter().println(
                    "<h2>Product not found!</h2>"
                );
            }

            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println(
                "<h2>Error while updating product!</h2>"
            );
        }
    }
}
