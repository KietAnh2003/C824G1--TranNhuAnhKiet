<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Simple Dictionary</title>
</head>
<body>
<h2>Vietnamese Dictionary</h2>
<%!
    Map<String, String> dictionary = new HashMap<>();
%>
<%
    dictionary.put("hello", "Xin chào");
    dictionary.put("how", "Thế nào");
    dictionary.put("book", "Quyển vở");
    dictionary.put("computer", "Máy tính");

%>
<%
    String search = request.getParameter("search");
    String result = dictionary.get(search);
    if (result != null) {

    } else {
        search = "Không tim thay tu";
        result = "not found ";
    }
%>
<h3>Kết quả:</h3>
<p>Từ: <strong><%= search %></strong></p>
<p>Dịch nghĩa: <strong><%= result %> </strong></p>

</body>
</html>
