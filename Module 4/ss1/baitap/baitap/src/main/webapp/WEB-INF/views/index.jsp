<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Chuyển đổi tiền tệ</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<form action="/convert" method="get" style="width: 350px; margin: 20px auto">
  <h1>Chuyển đổi tiền tệ </h1>
  <div class="mb-3">
    <label for="rate" class="form-label">Tỉ giá (1 USD sang VND): </label>
    <input type="text" class="form-control" id="rate" name="rate" required>
  </div>
  <div class="mb-3">
    <label for="usd" class="form-label">Số tiền USD:</label>
    <input type="text" class="form-control" id="usd" name="usd" required>
  </div>
  <button type="submit" class="btn btn-primary">Chuyển đổi</button>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
