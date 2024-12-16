<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>Product List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h1 class="mb-4">Product List</h1>
    <form action="${pageContext.request.contextPath}/product" method="get" class="mb-4 d-flex">
        <input type="hidden" name="action" value="search"/>
        <input type="text" name="query" placeholder="Search by name" class="form-control me-2" required/>
        <button type="submit" class="btn btn-primary">Search</button>
    </form>
    <button class="btn btn-success mb-3" type="button" onclick="window.location.href='/product?action=add'">Create New Product</button>

    <!-- Start of Card Grid -->
    <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 g-4">
        <c:forEach var="product" items="${products}">
            <div class="col">
                <div class="card" style="width: 12rem;">
                    <!-- Placeholder image or product image -->
                    <img src="https://via.placeholder.com/150" class="card-img-top" alt="${product.productName}">
                    <div class="card-body p-2">
                        <h5 class="card-title fs-6">${product.productName}</h5>
                        <p class="card-text fs-7">${product.description}</p>
                        <p class="card-text fs-6"><strong>Price:</strong> $${product.price}</p>
                    </div>
                    <div class="card-footer text-center">
                        <button class="btn btn-info btn-sm" data-bs-toggle="modal" data-bs-target="#viewModal${product.idProduct}">View</button>
                        <button class="btn btn-warning btn-sm" onclick="window.location.href='/product?action=update&idProduct=${product.idProduct}'">Edit</button>
                        <button class="btn btn-danger btn-sm" onclick="window.location.href='/product?action=remove&idProduct=${product.idProduct}'">Delete</button>
                    </div>
                </div>
            </div>

            <!-- Modal for Product Details -->
            <div class="modal fade" id="viewModal${product.idProduct}" tabindex="-1" aria-labelledby="viewModalLabel${product.idProduct}" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="viewModalLabel${product.idProduct}">Product Details</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <p><strong>ID:</strong> ${product.idProduct}</p>
                            <p><strong>Name:</strong> ${product.productName}</p>
                            <p><strong>Price:</strong> ${product.price}</p>
                            <p><strong>Description:</strong> ${product.description}</p>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <!-- End of Card Grid -->
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
