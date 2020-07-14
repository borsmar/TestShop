<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta charset="windows-1252">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TestShop</title>
    <link rel="stylesheet"
          href="<c:url value="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"/>"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<header>
    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: cornflowerblue">
        <div>
            <a href="https://www.javaguides.net" class="navbar-brand"> TestShop </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="${pageContext.request.contextPath}/GoodsManager/" class="nav-link">Events</a></li>
            <li><a class="nav-link" href="<c:url value="/logout" />">Logout</a></li>
        </ul>
    </nav>
</header>
<h1 style="text-align: center">
    <br>
    <br>
    Access Denied!
    <br>
    <br>
    ${msg}
</h1>
</body>
</html>
