<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <style>
        .custom-w-80{
            width: 90%;
        }
        .nav.text-light .nav-link {
            color: #f8f9fa !important;
        }
    </style>
</head>
<body>
<ul class="nav bg-dark text-light p-2 d-flex align-items-center">
    <li class="nav-item">
        <a class="nav-link active fw-bold fs-2" href="#">Codegym</a>
    </li>
    <li class="nav-item">
        <a class="nav-link " href="#">Học viên</a>
    </li>
    <li class="nav-item">
        <a class="nav-link " href="#">Điểm</a>
    </li>
    <li class="nav-item">
        <a class="nav-link " href="#">Xếp hạng</a>
    </li>
</ul>

<table class="table table-dark table-striped-columns m-4 custom-w-80">
    <thead>
    <tr>
        <th scope="col">Mã học viên</th>
        <th scope="col">Tên</th>
        <th scope="col">Giới tính</th>
        <th scope="col">Điểm số</th>
        <th scope="col">Xếp loại</th>
        <th colspan="2">Chức năng</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${not empty students}">
        <c:forEach items="${students}" var="student">
            <tr>
                <td>${student.maHocVien}</td>
                <td>${student.ten}</td>
                <td>${student.gioiTinh}</td>
                <td>${student.diemSo}</td>
                <td>${student.xepLoai}</td>
                <td><button class="btn btn-warning">Cập nhật</button></td>
                <td><button class="btn btn-danger">Xóa</button></td>
            </tr>
        </c:forEach>
    </c:if>

    <c:if test="${empty students}">
        <tr>
            <td colspan="7" class="text-center text-light">Danh sách rỗng.. </td>
        </tr>
    </c:if>
    </tbody>
</table>


</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</html>
