<%--
  Created by IntelliJ IDEA.
  User: aitsu
  Date: 12/11/2024
  Time: 10:17 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>Borrow Book</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h1 class="mb-4">Borrow Book</h1>
    <form action="${pageContext.request.contextPath}/borrow" method="post">
        <input type="hidden" name="bookCode" value="${book.bookCode}"/>
        <div class="mb-3">
            <label for="borrowCode" class="form-label">Book Borrow Code</label>
            <input type="text" class="form-control" id="borrowCode" name="borrowCode" value="MS-${book.bookCode}" readonly/>
        </div>
        <div class="mb-3">
            <label for="bookName" class="form-label">Book Name</label>
            <input type="text" class="form-control" id="bookName" name="bookName" value="${book.bookName}" readonly/>
        </div>
        <div class="mb-3">
            <label for="studentName" class="form-label">Student Name</label>
            <select class="form-select" id="studentName" name="studentName">
                <c:forEach var="student" items="${students}">
                    <option value="${student.studentName}">${student.studentName}</option>
                </c:forEach>
            </select>
        </div>
        <div class="mb-3">
            <label for="startDay" class="form-label">Start Day</label>
            <input type="text" class="form-control" id="startDay" name="startDay" value="<%= new java.text.SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date()) %>" readonly/>
        </div>
        <div class="mb-3">
            <label for="endDay" class="form-label">End Day</label>
            <input type="date" class="form-control" id="endDay" name="endDay" required/>
        </div>
        <button type="submit" class="btn btn-primary">Borrow Book</button>
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
