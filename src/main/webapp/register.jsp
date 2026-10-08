<!DOCTYPE html>
<html>
<head>
    <title>Register - Green Technology Marketplace</title>
    <link rel="stylesheet" href="css/style.css">
</head>

<body>

    <h1>Create Account</h1>

    <form action="register" method="post" class="order-form">

        <label>Name:</label>
        <input type="text" name="name" required>

        <label>Email:</label>
        <input type="email" name="email" required>

        <label>Password:</label>
        <input type="password" name="password" required>

        <label>Role:</label>
        <select name="role" required>
            <option value="customer">Customer</option>
            <option value="vendor">Vendor</option>
            <option value="admin">Admin</option>
        </select>

        <button type="submit">Create Account</button>

    </form>

</body>
</html>