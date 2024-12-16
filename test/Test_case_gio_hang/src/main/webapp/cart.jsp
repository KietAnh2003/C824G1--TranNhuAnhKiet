<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.test_case_gio_hang.CartItem" %>
<%
  List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
  double total = 0;
  if (cart != null) {
    for (CartItem item : cart) {
      total += item.getSubtotal();
    }
  }
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Shopping Cart</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
  <div class="row">
    <!-- Left Table: Cart -->
    <div class="col-md-8">
      <h3>Giỏ Hàng</h3>
      <table class="table table-bordered">
        <thead>
        <tr>
          <th>Sản phẩm</th>
          <th>Giá</th>
          <th>Số lượng</th>
          <th>Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <% if (cart != null) {
          for (int i = 0; i < cart.size(); i++) {
            CartItem item = cart.get(i);
        %>
        <tr>
          <td><%= item.getProductName() %></td>
          <td><%= item.getPrice() %> VND</td>
          <td><%= item.getQuantity() %></td>
          <td>
            <form method="post" action="cart">
              <input type="hidden" name="index" value="<%= i %>">
              <button name="action" value="increase" class="btn btn-success btn-sm">+</button>
              <button name="action" value="decrease" class="btn btn-danger btn-sm">-</button>
            </form>
          </td>
        </tr>
        <% }} %>
        </tbody>
      </table>
    </div>

    <!-- Right Table: Summary -->
    <div class="col-md-4">
      <h3>Thanh Toán</h3>
      <table class="table table-bordered">
        <tr>
          <td>Tạm tính</td>
          <td><%= total %> VND</td>
        </tr>
        <tr>
          <td>Phí vận chuyển</td>
          <td>20,000 VND</td>
        </tr>
        <tr>
          <th>Tổng cộng</th>
          <th><%= total + 20000 %> VND</th>
        </tr>
      </table>
    </div>
  </div>
</div>
</body>
</html>

