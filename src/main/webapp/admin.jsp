<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard - Green Technology Marketplace</title>
    <link rel="stylesheet" href="css/style.css">
</head>

<body>

    <div class="hero">

        <h1>🌿 Admin Dashboard</h1>

        <p>
            Manage and review products submitted by vendors.
        </p>

        <h2>Product Management</h2>

        <form action="adminProduct" method="post" class="order-form">

            <label>Product ID:</label>
            <input type="number" name="productId" required>

            <button type="submit" name="action" value="approve">
                ✓ Approve Product
            </button>

            <button type="submit" name="action" value="reject">
                ✕ Reject Product
            </button>

        </form>

    </div>

</body>
</html>