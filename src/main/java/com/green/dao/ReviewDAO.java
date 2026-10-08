package com.green.dao;
import com.green.model.Review;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class ReviewDAO {
     private Connection connection;

    public ReviewDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean addReview(Review review) {

        String sql = "INSERT INTO reviews " +
                     "(customer_id, product_id, rating, comment) " +
                     "VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, review.getCustomerId());
            ps.setInt(2, review.getProductId());
            ps.setInt(3, review.getRating());
            ps.setString(4, review.getComment());

            ps.executeUpdate();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
    

