package com.green.servlet;

import com.green.dao.ReviewDAO;
import com.green.model.Review;
import com.green.util.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("/addReview")
public class ReviewServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String customerId = request.getParameter("customerId");
        String productId = request.getParameter("productId");
        String rating = request.getParameter("rating");
        String comment = request.getParameter("comment");

        Review review = new Review();

        review.setCustomerId(Integer.parseInt(customerId));
        review.setProductId(Integer.parseInt(productId));
        review.setRating(Integer.parseInt(rating));
        review.setComment(comment);

        Connection connection = DBConnection.getConnection();

        ReviewDAO reviewDAO = new ReviewDAO(connection);

        boolean result = reviewDAO.addReview(review);

        response.setContentType("text/html");

        if (result) {
            response.getWriter().println("<h2>Review Added Successfully!</h2>");
        } else {
            response.getWriter().println("<h2>Failed to Add Review!</h2>");
        }
    }
}
