<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.green.model.Product" %>
<%@ page import="com.green.dao.ProductDAO" %>
<%@ page import="com.green.util.DBConnection" %>

<!DOCTYPE html>
<html>
<head>
    <title>Products - Green Technology Marketplace</title>
    <link rel="stylesheet" href="css/style.css">
</head>

<body>

    <h1>Green Technology Products</h1>

    <div class="products-container">

        <%
            ProductDAO productDAO = new ProductDAO(DBConnection.getConnection());
            List<Product> products = productDAO.getAllProducts();

            for (Product product : products) {
        %>

            <div class="product-card">

                <h2><%= product.getName() %></h2>

                <p><%= product.getDescription() %></p>

                <p class="product-price">₹<%= product.getPrice() %></p>

                <p class="product-category"><%= product.getCategory() %></p>
                <a href="order.jsp?productId=<%= product.getId() %>&price=<%= product.getPrice() %>&customerId=<%= request.getParameter("customerId") %>" class="buy-button">Buy Now</a>

            </div>

        <%
            }
        %>

    </div>

</body>
</html>