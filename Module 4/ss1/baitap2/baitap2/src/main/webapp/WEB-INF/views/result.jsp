<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Kết quả</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
  <h1 class="mt-4">Kết quả tra cứu</h1>
  <c:if test="${not empty word}">
    <p><strong>Từ:</strong> ${word}</p>
    <p><strong>Nghĩa:</strong> ${meaning}</p>
  </c:if>
  <c:if test="${not empty message}">
    <p class="text-danger">${message}</p>
  </c:if>
  <a href="/" class="btn btn-secondary mt-3">Quay lại</a>
</div>
</body>
</html>
