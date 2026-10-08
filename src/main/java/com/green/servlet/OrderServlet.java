package com.green.servlet;

import com.green.dao.OrderDAO;
import com.green.model.Order;
import com.green.util.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("/addOrder")
public class OrderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String customerId = request.getParameter("customerId");
        String productId = request.getParameter("productId");
        String quantity = request.getParameter("quantity");
        String totalPrice = request.getParameter("totalPrice");

        Order order = new Order();

        order.setCustomerId(Integer.parseInt(customerId));
        order.setProductId(Integer.parseInt(productId));
        order.setQuantity(Integer.parseInt(quantity));
        order.setTotalPrice(Double.parseDouble(totalPrice));
        order.setStatus("pending");

        Connection connection = DBConnection.getConnection();

        OrderDAO orderDAO = new OrderDAO(connection);

        boolean result = orderDAO.addOrder(order);

        response.setContentType("text/html");

        if (result) {

    request.getSession().setAttribute("customerId", customerId);
    request.getSession().setAttribute("productId", productId);

    response.sendRedirect("purchase-success.jsp");

}
    }
}
