<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title style="text-align: center">Product Discount Calculator</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<h1>Product Discount Calculator</h1>
<form action="display-discount" method="post">
    <label for="productDescription">Product Description:</label>
    <input type="text" id="productDescription" name="productDescription" required><br><br>

    <label for="listPrice">List Price:</label>
    <input type="number" id="listPrice" name="listPrice" step="0.01" required><br><br>

    <label for="discountPercent">Discount Percent:</label>
    <input type="number" id="discountPercent" name="discountPercent" step="0.01" required><br><br>

    <button type="submit">Calculate Discount</button>
</form>
</body>
</html>