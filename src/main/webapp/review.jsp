<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.green.util.DBConnection" %>

<%
    Integer userId = (Integer) session.getAttribute("userId");

    int customerId = 0;
    int productId = 0;

    if (userId != null) {

        Connection connection = DBConnection.getConnection();

        String sql = "SELECT customer_id, product_id " +
                     "FROM orders " +
                     "WHERE customer_id = ? " +
                     "ORDER BY id DESC LIMIT 1";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, userId);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            customerId = resultSet.getInt("customer_id");
            productId = resultSet.getInt("product_id");
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Add Review - Green Technology Marketplace</title>
    <link rel="stylesheet" href="css/style.css">
</head>

<body>

    <h1>Share Your Experience</h1>

    <form action="addReview" method="post" class="order-form">

        <label>Customer ID:</label>
        <input type="number"
               name="customerId"
               value="<%= customerId %>"
               readonly>

        <label>Product ID:</label>
        <input type="number"
               name="productId"
               value="<%= productId %>"
               readonly>

        <label>Rating:</label>
        <select name="rating" required>
            <option value="">Select Rating</option>
            <option value="1">⭐ 1 Star</option>
            <option value="2">⭐ 2 Stars</option>
            <option value="3">⭐ 3 Stars</option>
            <option value="4">⭐ 4 Stars</option>
            <option value="5">⭐ 5 Stars</option>
        </select>

        <label>Comment:</label>
        <textarea name="comment" rows="5" required></textarea>

        <button type="submit">Submit Review</button>

    </form>

</body>
</html>