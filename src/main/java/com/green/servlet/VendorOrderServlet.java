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
import java.sql.ResultSet;

@WebServlet("/vendorOrders")
public class VendorOrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String vendorId = request.getParameter("vendorId");

        response.setContentType("text/html;charset=UTF-8");

        try {
            Connection connection = DBConnection.getConnection();

            String sql = "SELECT o.id, o.customer_id, o.product_id, " +
                         "o.quantity, o.total_price, o.order_date, o.status " +
                         "FROM orders o " +
                         "JOIN products p ON o.product_id = p.id " +
                         "WHERE p.vendor_id = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, Integer.parseInt(vendorId));

            ResultSet resultSet = statement.executeQuery();

            response.getWriter().println("<h1>Vendor Orders</h1>");

            while (resultSet.next()) {

                response.getWriter().println(
                    "<p>Order ID: " + resultSet.getInt("id") + "</p>"
                );

                response.getWriter().println(
                    "<p>Customer ID: " + resultSet.getInt("customer_id") + "</p>"
                );

                response.getWriter().println(
                    "<p>Product ID: " + resultSet.getInt("product_id") + "</p>"
                );

                response.getWriter().println(
                    "<p>Quantity: " + resultSet.getInt("quantity") + "</p>"
                );

                response.getWriter().println(
                    "<p>Total Price: ₹" + resultSet.getDouble("total_price") + "</p>"
                );

                response.getWriter().println(
                    "<p>Status: " + resultSet.getString("status") + "</p>"
                );

                response.getWriter().println("<hr>");
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();

            response.getWriter().println(
                "<h2>Error while fetching vendor orders!</h2>"
            );
        }
    }
}
