<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Purchase Successful</title>
    <link rel="stylesheet" href="css/style.css">
</head>

<body>

    <div class="success-card">

        <h1>🌱 Purchase Successful!</h1>

        <p class="success-message">
            Your small effort is a big step towards a greener Earth.
        </p>

       <div class="leaf-container">
    <span class="leaf"></span>
    <span class="leaf"></span>
    <span class="leaf"></span>
    <span class="leaf"></span>
    <span class="leaf"></span>
    <span class="leaf"></span>
    <span class="leaf"></span>
    <span class="leaf"></span>
    <span class="leaf"></span>
    <span class="leaf"></span>
    <span class="leaf"></span>
    <span class="leaf"></span>
    <span class="leaf"></span>
    <span class="leaf"></span>
    <span class="leaf"></span>
</div>

       <a href="review.jsp?customerId=<%= session.getAttribute("customerId") %>&productId=<%= session.getAttribute("productId") %>" class="buy-button">
    Leave a Review ⭐
      </a>

    </div>

</body>
</html>