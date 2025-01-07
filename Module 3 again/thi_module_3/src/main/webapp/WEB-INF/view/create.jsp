<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
    <style>
        .navbar {
            background-color: #343a40;
        }

        .navbar-brand {
            font-size: 25px;
            font-weight: bold;
            color: white;
        }

        .navbar-nav .nav-link {
            color: white;
            font-size: 16px;
            margin-right: 15px;
        }

        .navbar-nav .nav-link:hover {
            color: black;
        }

        .navbar-toggler-icon {
            background-color: white;
        }

        .container {
            margin-top: 20px;
        }

        .table th, .table td {
            text-align: center;
        }

        .table th {
            width: 10%;
        }

        .table td {
            width: 10%;
        }
    </style>

</head>
<body>
<nav class="navbar navbar-expand-lg">
    <div class="container-fluid">
        <a class="navbar-brand" href="/book">Product</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/products">Product</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Product Type</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Author</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="container mt-5">
    <h1 style="text-align: center">Create New Product</h1>
    <form action="/products" method="post" onsubmit="return validateForm();"
          style="width: 500px; margin: auto">
        <input type="hidden" name="action" value="create">
        <div class="mb-3">
            <label for="name" class="form-label">Name:</label>
            <input type="text" class="form-control" id="name" name="name" required>
        </div>
        <div class="mb-3">
            <label for="price" class="form-label">Price:</label>
            <input type="number" class="form-control" id="price" name="price" step="0.01" required>
        </div>
        <div class="mb-3" style="width: 100px">
            <label for="discountRate" class="form-label">Discount:</label>
            <select class="form-select" id="discountRate" name="discountRate" required>
                <option value="5%">5%</option>
                <option value="10%">10%</option>
                <option value="15%">15%</option>
                <option value="20%">20%</option>
            </select>
        </div>
        <div class="mb-3">
            <label for="stockQuantity" class="form-label">Stock Quantity:</label>
            <input type="number" class="form-control" id="stockQuantity" name="stockQuantity" required>
        </div>
        <button type="submit" class="btn btn-primary">Create</button>
        <a href="/products" class="btn btn-secondary">Back to Product List</a>
    </form>
</div>
<script>
    function validateForm() {
        const name = document.getElementById("name").value.trim();
        const price = parseFloat(document.getElementById("price").value.trim());
        const discount = document.getElementById("discountRate").value.trim();
        const stock = parseInt(document.getElementById("stockQuantity").value.trim());
        if (!name) {
            alert("Name is required.");
            return false;
        }
        if (isNaN(price) || price <= 100) {
            alert("Price must be greater than 100.");
            return false;
        }
        const validDiscounts = ["5%", "10%", "15%", "20%"];
        if (!validDiscounts.includes(discount)) {
            alert("Discount must be one of the following values: 5%, 10%, 15%, 20%.");
            return false;
        }
        if (isNaN(stock) || stock <= 10) {
            alert("Stock must be greater than 10.");
            return false;
        }
        return true;
    }
</script>
</body>
</html>
