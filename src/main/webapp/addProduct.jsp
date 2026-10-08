<!DOCTYPE html>
<html>
<head>
    <title>Add Product - Green Technology Marketplace</title>
    <link rel="stylesheet" href="css/style.css">
</head>

<body>

    <h1>Add Green Technology Product</h1>

    <form action="addProduct" method="post" class="order-form">

        <label>Product Name:</label>
        <input type="text" name="name" required>

        <label>Description:</label>
        <textarea name="description" required></textarea>

        <label>Price:</label>
        <input type="number" name="price" step="0.01" min="0" required>

        <label>Category:</label>
        <input type="text" name="category" required>

        <label>Vendor ID:</label>
        <input type="number" name="vendorId" required>

        <button type="submit">Add Product</button>

    </form>

</body>
</html>