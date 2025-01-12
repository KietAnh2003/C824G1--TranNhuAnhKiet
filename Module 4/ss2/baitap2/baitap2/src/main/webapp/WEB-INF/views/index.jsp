<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5" style="width: 600px">
    <h3 class="text-center">Simple Calculator</h3>
    <form action="/calculate" method="GET">
        <div class="mb-3">
            <input type="number" name="number1" placeholder="First number" class="form-control" required>
        </div>
        <div class="mb-3">
            <input type="number" name="number2" placeholder="Second number" class="form-control" required>
        </div>
        <div class="mb-3">
            <button type="submit" name="operation" value="add" class="btn btn-primary">Addition (+)</button>
            <button type="submit" name="operation" value="subtract" class="btn btn-warning">Subtraction (-)</button>
            <button type="submit" name="operation" value="multiply" class="btn btn-success">Multiplication (X)</button>
            <button type="submit" name="operation" value="divide" class="btn btn-danger">Division (/)</button>
        </div>
    </form>
    <h5 class="mt-3">Result: ${result}</h5>
    <p class="text-danger"> <strong>${error}</strong></p>
</div>

<!-- Bootstrap JS Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
