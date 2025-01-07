<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
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
<div class="container mt-4">
    <h1> List Product</h1>
    <button class="btn btn-primary mb-3" onclick="window.location.href='/products?action=create'">Add new product
    </button>
    <h5>Top list: 3 most ordered product
        <button class="btn btn-success" type="submit">See List</button>
    </h5>

    <table class="table table-dark table-striped">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Name</th>
            <th scope="col">Price</th>
            <th scope="col">Discount</th>
            <th scope="col">Stock</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${products}" var="product">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>${product.discountRate}</td>
                <td>${product.stockQuantity}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>
