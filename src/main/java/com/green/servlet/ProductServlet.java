package com.green.servlet;

import com.green.dao.ProductDAO;
import com.green.model.Product;
import com.green.util.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("/addProduct")
public class ProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String price = request.getParameter("price");
        String category = request.getParameter("category");
        String vendorId = request.getParameter("vendorId");

        Product product = new Product();

        product.setName(name);
        product.setDescription(description);
        product.setPrice(Double.parseDouble(price));
        product.setCategory(category);
        product.setVendorId(Integer.parseInt(vendorId));
        product.setStatus("pending");

        Connection connection = DBConnection.getConnection();

        ProductDAO productDAO = new ProductDAO(connection);

        boolean result = productDAO.addProduct(product);

        response.setContentType("text/html");

        if (result) {
            response.getWriter().println("<h2>Product Added Successfully!</h2>");
        } else {
            response.getWriter().println("<h2>Failed to Add Product!</h2>");
        }
    }
}
