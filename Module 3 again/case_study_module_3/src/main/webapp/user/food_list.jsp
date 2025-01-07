<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="/partials/head.jsp"/>
<body>
<!-- Sidebar -->
<div class="collapse d-md-block sidebar" id="sidebar">
    <div>
        <!-- Logo -->
        <div class="logo">
            <img src="/img/logo.jpg" alt="logo" class="img-logo">
        </div>
        <!-- Navigation -->
        <nav>
            <a class="nav-link" href="/">TRANG CHỦ</a>
            <a class="nav-link" href="/thuc-don">THỰC ĐƠN</a>
            <a class="nav-link" href="/khuyen-mai">KHUYẾN MÃI</a>
            <a class="nav-link" href="/lien-he">LIÊN HỆ</a>
            <a class="nav-link" href="/gioi-thieu">GIỚI THIỆU</a>
        </nav>
    </div>
    <!-- Contact Info -->
    <div class="contact-info">
        <p><i class="fas fa-phone-alt"></i> 0901234567</p>
        <a href="https://facebook.com" target="_blank">
            <i class="fab fa-facebook" style="color: blue;"></i> Facebook
        </a>
        <a href="https://instagram.com" target="_blank">
            <i class="fab fa-instagram" style="color: #912b42"></i> Instagram
        </a>
    </div>
</div>
<!-- Main Content -->
    <div class="main-content">
        <div class="banner">
            <h1 style="font-size: 30px">THỰC ĐƠN HÔM NAY</h1>
        </div>
        <div class="food-menu">
            <div class="container">
                <h2>THỰC ĐƠN</h2>

                <div class="row">
                    <c:forEach var="food" items="${foods}">
                        <div class="col-md-4 mb-4">
                            <div class="card">
                                <div class="card-body">
                                    <h5 class="card-title">${food.foodName}</h5>
                                    <p class="card-text">${food.foodDescription}</p>
                                    <p class="card-text">Giá: ${food.foodPrice} VND</p>
                                    <button class="btn btn-primary w-100">Thêm</button>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>

        <div class="cart-icon">
            <i class="bi bi-cart"></i>
        </div>
        <jsp:include page="/partials/footer.jsp" />
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
