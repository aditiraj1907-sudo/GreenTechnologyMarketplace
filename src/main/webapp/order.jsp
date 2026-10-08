<!DOCTYPE html>
<html>
<head>
    <title>Place Order - Green Technology Marketplace</title>
    <link rel="stylesheet" href="css/style.css">
</head>

<body>

    <h1>Place Order</h1>

    <form action="addOrder" method="post" class="order-form">

        <label>Customer ID:</label>
       <input type="number" name="customerId"
       value="<%= request.getParameter("customerId") %>"
       readonly>

        <label>Product ID:</label>
         <input type="number" name="productId"
       value="<%= request.getParameter("productId") %>"
       readonly>
        

        <label>Quantity:</label>
        <input type="number" name="quantity" min="1" required>

        <label>Total Price:</label>
        <input type="number" name="totalPrice"
       value="<%= request.getParameter("price") %>"
       step="0.01"
       readonly>


        <button type="submit">Place Order</button>

    </form>

</body>
</html>