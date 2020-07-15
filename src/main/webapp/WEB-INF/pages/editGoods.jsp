<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Edit Goods</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/my.css" rel="stylesheet">
</head>
<body>
<header>
    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: cornflowerblue">
        <div>
            <a href="https://www.javaguides.net" class="navbar-brand"> Test Shop </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="${pageContext.request.contextPath}/GoodsManager/" class="nav-link">Goods</a></li>
            <li><a class="nav-link" href="<c:url value="/logout" />">Logout</a></li>
        </ul>
    </nav>
</header>
<div class="container">
    <h1>Goods Table</h1>
    <table id="data" class="table table-dark table-hover" >

            <tr id="${goodsDto.id}">
                <td>${goodsDto.id}</td>
                <td>${goodsDto.name}</td>
                <td>${goodsDto.brand}</td>
                <td>${goodsDto.color}</td>
            </tr>
    </table>
    <div class="container">
        <c:url value="/GoodsManager/edit" var="edit"/>
        <form:form action="${edit}" method="post" modelAttribute="goodsDto">

            <div class="row">
                <div class="col-25">
                    <label for="name1">Name</label>
                </div>
                <div class="col-75">
                    <form:input path="name" id="name1" placeholder="type name"/>
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="brand1">Brand</label>
                </div>
                <div class="col-75">
                    <form:input path="brand" id="brand1" placeholder="type brand"/>
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="color1">Color</label>
                </div>
                <div class="col-75">
                    <form:input path="color" id="color1" placeholder="type color"/>
                </div>
            </div>

            <div class="row">
                <input type="submit" value="UPDATE">
            </div>
        </form:form>
</div>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</html>
