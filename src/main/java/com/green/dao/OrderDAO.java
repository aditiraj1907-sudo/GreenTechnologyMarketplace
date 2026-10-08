package com.green.dao;
import com.green.model.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class OrderDAO {
     private Connection connection;

    public OrderDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean addOrder(Order order) {

        String sql = "INSERT INTO orders " +
                     "(customer_id, product_id, quantity, total_price, status) " +
                     "VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, order.getCustomerId());
            ps.setInt(2, order.getProductId());
            ps.setInt(3, order.getQuantity());
            ps.setDouble(4, order.getTotalPrice());
            ps.setString(5, order.getStatus());

            ps.executeUpdate();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
    

