<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link href="${pageContext.request.contextPath}/resources/css/my.css" rel="stylesheet">
    <link rel="icon" href="${pageContext.request.contextPath}/resources/img/mdb-favicon.ico" type="image/x-icon">
    <!-- Font Awesome -->
    <link rel="stylesheet" type="text/css" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
    <!-- Google Fonts Roboto -->
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css" >
    <!-- Material Design Bootstrap -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/mdb.min.css">
    <!-- Your custom styles (optional) -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
    <title>Edit Goods</title>

</head>
<body>
<header>
    <nav class="navbar fixed-top navbar-expand-lg navbar-dark" style="background-color: cornflowerblue">
        <div>
            <a href="https://www.javaguides.net" class="navbar-brand waves-effect"> Test Shop </a>
        </div>

        <ul class="navbar-nav mr-auto">
            <li><a href="${pageContext.request.contextPath}/GoodsManager/?id=1" class="nav-link">Goods</a></li>
            <li><a href="${pageContext.request.contextPath}/GoodsManager/?id=1" class="nav-link">Orders</a></li>
            <li><a class="nav-link" href="<c:url value="/logout" />">Logout</a></li>
        </ul>
    </nav>
    <div class="sidebar-fixed position-fixed">
        <a href="#" class="logo-wrapper waves-effect">
            <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/e/ee/Aperture_Science.svg/1200px-Aperture_Science.svg.png" alt="" class="img-fluid">
        </a>
        <div class="list-group list-group-flush">
            <a href="#" class="list-group-item active waves-effect">
                <i class="fa fa-pie-chart mr-3"></i>Dashboard
            </a>
            <a href="#" class="list-group-item waves-effect">
                <i class="fa fa-user mr-3"></i>Profile
            </a>
            <a href="#" class="list-group-item waves-effect">
                <i class="fa fa-table mr-3"></i>Tables
            </a>
            <a href="#" class="list-group-item waves-effect">
                <i class="fa fa-map mr-3"></i>Maps
            </a>
            <a href="#" class="list-group-item waves-effect">
                <i class="fa fa-money mr-3"></i>Orders
            </a>
        </div>
    </div>
</header>

<main class="pt-5 max-lg-5">
    <div class="container dark-grey-text mt-5">
        <div class="row wow fadeIn">
            <div class="col-md-6 mb-4">
                <img src="${goodsDto.imageURL}" alt="Iphone" class="img-fluid">
            </div>
            <div class="col-lg-6 mb-4">
                <div class="p-4">
                    <p class="lead font-weight-bold">Description</p>
                    <p>${goodsDto.description}</p>
                </div>
            </div>
        </div>



</div>

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
    </div>
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

</main>


            <%@ include file="/WEB-INF/pages/footer.jsp" %>



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
