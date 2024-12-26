<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <jsp:include page="/WEB-INF/partials/header.jsp" />
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="d-flex justify-content-center align-items-center" style="height: 80vh;">
        <div class="container bg-dark-subtle rounded" style="width: 37%">
            <h2 style="text-align: center"> Create new book </h2>
            <form method="post" style="margin: 10px">
                <div class="mb-3">
                    <label for="title" class="form-label">Title</label>
                    <input type="text" class="form-control" id="title" name="title">
                </div>
                <div class="mb-3">
                    <label for="pageSize" class="form-label">Page Size</label>
                    <input type="number" class="form-control" id="pageSize" name="pageSize">
                </div>
                <div class="mb-3">
                    <label for="author" class="form-label">Author</label>
                    <input type="text" class="form-control" id="author" name="author">
                </div>
                <div class="mb-3">
                    <label for="category" class="form-label">Category</label>
                    <input type="text" class="form-control" id="category" name="category">
                </div>
                <button type="submit" class="btn btn-primary">Save</button>
                <a href="/book" class="btn btn-secondary">Cancel</a>
            </form>
        </div>
    </div>
</body>
</html>
