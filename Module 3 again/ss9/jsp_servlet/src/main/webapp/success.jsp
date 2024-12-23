<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Success</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #e9f7ef;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .success-container {
            background: white;
            padding: 2rem;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        .success-message {
            color: #28a745;
            font-weight: bold;
            margin-top: 1rem;
        }
        .btn-logout {
            margin-top: 2rem;
        }
    </style>
</head>
<body>
<div class="success-container">
    <h2>Login Successful</h2>
    <p class="success-message"><%= request.getAttribute("message") %></p>
    <a href="login.jsp" class="btn btn-danger btn-logout">Logout</a>
</div>
</body>
</html>
