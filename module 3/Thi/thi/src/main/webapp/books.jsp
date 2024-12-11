<%--
  Created by IntelliJ IDEA.
  User: aitsu
  Date: 12/11/2024
  Time: 10:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>Book List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h1 class="mb-4" style="text-align: center">Book List</h1>
    <form action="${pageContext.request.contextPath}/books" method="get" class="mb-4 d-flex">
        <input type="hidden" name="action" value="search"/>
    </form>
    <table class="table table-striped" style="border:black">
        <thead class="table-dark">
        <tr>
            <th style="width: 10%">Book Code</th>
            <th style="width: 20%">Book Name</th>
            <th>Author</th>
            <th>Description</th>
            <th style="width: 10%">Quantity</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="book" items="${books}">
            <tr>
                <td>${book.bookCode}</td>
                <td>${book.bookName}</td>
                <td>${book.author}</td>
                <td>${book.bookDescription}</td>
                <td>${book.quantity}</td>
                <td style="width: 20%">
                    <c:choose>
                        <c:when test="${book.quantity == 0}">
                            <button type="button" class="btn btn-info btn-sm" data-bs-toggle="modal" data-bs-target="#outOfStockModal${book.bookCode}">
                                Borrow
                            </button>
                        </c:when>
                        <c:otherwise>
                            <form action="${pageContext.request.contextPath}/borrow" method="get">
                                <input type="hidden" name="bookCode" value="${book.bookCode}">
                                <button type="submit" class="btn btn-info btn-sm">
                                    Borrow
                                </button>
                            </form>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>

            <div class="modal fade" id="outOfStockModal${book.bookCode}" tabindex="-1" aria-labelledby="outOfStockModalLabel${book.bookCode}" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="outOfStockModalLabel${book.bookCode}">Out of Stock</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <p>Lỗi, đã hết sách,xin vui lòng chọn sách khác</p>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
