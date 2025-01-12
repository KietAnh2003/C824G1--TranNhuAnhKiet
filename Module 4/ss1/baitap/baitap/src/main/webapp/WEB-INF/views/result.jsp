<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Kết quả Chuyển đổi Tiền tệ</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <div class="card" style="width: 350px; margin: 20px auto">
        <div class="card-header bg-primary text-white">
            <h1 class="h3">Kết quả Chuyển đổi tiền tệ</h1>
        </div>
        <div class="card-body">
            <p><strong>Tỉ giá:</strong> ${rate} VND/USD</p>
            <p><strong>Số tiền USD:</strong> ${usd}</p>
            <p><strong>Số tiền sau khi chuyển đổi:</strong> ${vnd} VND</p>
            <a href="/" class="btn btn-secondary mt-3">Quay lại</a>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
