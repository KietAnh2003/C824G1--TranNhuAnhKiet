<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Currency Converter</title>
</head>
<body>
<h2>Currency Converter</h2>
<form action="${pageContext.request.contextPath}/convert" method="post">
    <label>Rate: </label><br/>
    <label>
        <input type="text" name="rate" placeholder="RATE" value="22000"/>
    </label><br/>
    <label>USD: </label><br/>
    <label>
        <input type="text" name="usd" placeholder="USD" value="0"/>
    </label><br/>
    <input type = "submit" id = "submit" value = "Converter"/>
</form>
</body>
</html>