<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quản lý Sách</title>
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
        <a class="navbar-brand" href="/book">Library</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/book">Book</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Book Type</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Author</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<h1> Danh Sách Sản Phẩm</h1>
<div class="container mt-4">
    <button class="btn btn-primary mb-3" onclick="window.location.href='/book?action=create'">Add new books</button>
    <div class="d-flex align-items-center mb-4">
        <form action="/book" method="get" class="d-flex w-100">
            <input type="hidden" name="action" value="search">
            <input class="form-control w-50 me-2" type="search" name="title" placeholder="Search by title" aria-label="Search">
            <button class="btn btn-success" type="submit">Search</button>
        </form>
    </div>

    <table class="table table-dark table-striped">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Title</th>
            <th scope="col">Page Size</th>
            <th scope="col">Author</th>
            <th scope="col">Category</th>
            <th scope="col" colspan="2" class="text-center">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${books}" var="book">
            <tr>
                <td>${book.id}</td>
                <td>${book.title}</td>
                <td>${book.pageSize}</td>
                <td>${book.author}</td>
                <td>${book.category}</td>
                <td class="text-center">
                    <button class="btn btn-warning btn-sm" onclick="window.location.href='/book?action=update&id=${book.id}'">Update</button>
                </td>
                <td class="text-center">
                    <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#confirmDeleteModal${book.id}">
                        Delete
                    </button>

                    <!-- modal xoá-->
                    <div class="modal fade" id="confirmDeleteModal${book.id}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title text-danger" id="exampleModalLabel">Confirm Delete</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body text-dark">
                                    Do you want to delete the book titled "${book.title}" ?
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                                    <a href="/book?action=delete&id=${book.id}" class="btn btn-danger">Delete</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
