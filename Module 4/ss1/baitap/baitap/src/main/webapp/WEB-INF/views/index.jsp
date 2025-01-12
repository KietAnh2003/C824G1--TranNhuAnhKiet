<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Chuyển đổi tiền tệ</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
  <form action="/convert" method="get" style="width: 350px; margin: 0 auto;">
    <h1>Chuyển đổi tiền tệ</h1>
    <c:if test="${not empty error}">
      <div class="alert alert-danger">
        <strong>Lỗi:</strong> ${error}
      </div>
    </c:if>
    <div class="mb-3">
      <label for="rate" class="form-label">Tỉ giá (1 USD sang VND): </label>
      <input type="number" class="form-control" id="rate" name="rate" required>
    </div>
    <div class="mb-3">
      <label for="usd" class="form-label">Số tiền USD:</label>
      <input type="number" class="form-control" id="usd" name="usd" required>
    </div>
    <button type="submit" class="btn btn-primary">Chuyển đổi</button>
  </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
