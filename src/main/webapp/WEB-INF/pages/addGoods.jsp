<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<style>
    .selected { background-color: grey; }
</style>

<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
        $(document).ready(function(){
            $('tr').click(function(){
                $('tr').removeClass();
                $(this).toggleClass('selected');
            });
        });
        $(document).ready(function(){$('.btn-danger').click(function(){
           $(".selected").remove();
        });
        });





    </script>
    <script>
        $(document).ready(function(){
            $("tr").click(function(){
                    $("button").toggle('slow');
            });
        });
    $(document).ready(function () {
        $("tr").click(function () {
            let clickId = $(this).prop('id');
        });
    });

    </script>


    <title>Add Goods</title>
<%--    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">--%>

<%--    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"--%>
<%--          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">--%>
<%--    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">--%>
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
    <div class="container-fluid mt-5">
        <div class="card mb-4 wow fadeIn">
            <div class="card-header"><form:select id="category" path="id" onchange="if (this.value) window.location.href = this.value">
                <option value="">SELECT CATEGORY</option>
                <c:forEach var="category" items="${categories}">
                    <option value="${pageContext.request.contextPath}/GoodsManager/?id=<c:out value='${category.id}' />">${category.name}</option>
                </c:forEach>
            </form:select></div>
                <div class="card-body d-sm-flex justify-content-between">
                    <table id="data1" class="table table-dark table-hover">
                        <c:forEach var="goo" items="${goods}">
                            <tr id="${goo.id}">
                                <td>${goo.id}</td>
                                <td>${goo.name}</td>
                                <td>${goo.brand}</td>
                                <td>${goo.color}</td>
                                <td><a class="btn btn-primary btn-list" href="${pageContext.request.contextPath}/GoodsManager/edit?id=<c:out value='${goo.id}' />" >EDIT</a></td>
                                <td><a class="btn btn-danger btn-list" href="${pageContext.request.contextPath}/GoodsManager/delete?id=<c:out value='${goo.id}' />" >DELETE</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
    </div>
<div class="container">
    <c:url value="/GoodsManager/add" var="add"/>
    <form:form action="${add}" method="post" modelAttribute="goodsDto">

        <div class="row">
            <div class="col-3 ">
                <label for="name1">Name</label>
            </div>
            <div class="col-lg">
                <form:input path="name" id="name1" placeholder="type name"/>
            </div>
        </div>
        <div class="row">
            <div class="col-3">
                <label for="brand1">Brand</label>
            </div>
            <div class="col-lg">
                <form:input path="brand" id="brand1" placeholder="type brand"/>
            </div>
        </div>
        <div class="row">
            <div class="col-3">
                <label for="color1">Color</label>
            </div>
            <div class="col-lg">
                <form:input path="color" id="color1" placeholder="type color"/>
            </div>
        </div>

        <div class="row">
            <input type="submit" value="Add">
        </div>
    </form:form>
</div>

    <div class="container-fluid mt-5">
        <div class="card mb-4 wow fadeIn">
<%--            <div class="card-header"><form:select id="category" path="id" onchange="if (this.value) window.location.href = this.value">--%>
<%--                <option value="">SELECT CATEGORY</option>--%>
<%--                <c:forEach var="category" items="${categories}">--%>
<%--                    <option value="${pageContext.request.contextPath}/GoodsManager/?id=<c:out value='${category.id}' />">${category.name}</option>--%>
<%--                </c:forEach>--%>
<%--            </form:select></div>--%>
            <div class="card-body d-sm-flex justify-content-between">
                <table id="data2" class="table table-dark table-hover">
                    <c:forEach var="cat" items="${categories}">
                        <tr>
                            <td>${cat.id}</td>
                            <td>${cat.name}</td>
                            <td><a class="btn btn-primary btn-list" href="#" >EDIT</a></td>
                            <td><a class="btn btn-danger btn-list" href="#" >DELETE</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>

    <div class="container">
        <c:url value="/GoodsManager/categoryAdd" var="categoryAdd"/>
        <form:form action="${categoryAdd}" method="post" modelAttribute="category">

        <div class="row">
            <div class="col-3 ">
                <label for="name1">Name</label>
            </div>
            <div class="col-lg">
                <form:input path="name" id="name1" placeholder="type name"/>
            </div>
            <div class="col-3">
                <input type="submit" value="Add">
            </div>
            </form:form>
        </div>


        </div>

</main>





<%--<div class="container">--%>
<%--    <div class="row">--%>
<%--        <div class="col-3">--%>
<%--    <button type="button" style="display: none" class="btn btn-primary">UPDATE</button>--%>
<%--     <button  type="button" style="display: none" class="btn btn-danger" >DELETE</button>--%>


<%--        </div>--%>
<%--        <div class="col-6">--%>
<%--        </div>--%>
<%--            <div class="col-3">--%>
<%--    <button type="button" style="display: none" class="btn btn-light">CANCEL</button>--%>
<%--            </div>--%>
<%--    </div>--%>
<%--    </div>--%>

<%--<div class="container">--%>
<%--    <c:url value="/GoodsManager/add" var="add"/>--%>
<%--    <form:form action="${add}" method="post" modelAttribute="goodsDto">--%>

<%--        <div class="row">--%>
<%--            <div class="col-25">--%>
<%--                <label for="name1">Name</label>--%>
<%--            </div>--%>
<%--            <div class="col-75">--%>
<%--                <form:input path="name" id="name1" placeholder="type name"/>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="row">--%>
<%--            <div class="col-25">--%>
<%--                <label for="brand1">Brand</label>--%>
<%--            </div>--%>
<%--            <div class="col-75">--%>
<%--                <form:input path="brand" id="brand1" placeholder="type brand"/>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="row">--%>
<%--            <div class="col-25">--%>
<%--                <label for="color1">Color</label>--%>
<%--            </div>--%>
<%--            <div class="col-75">--%>
<%--                <form:input path="color" id="color1" placeholder="type color"/>--%>
<%--            </div>--%>
<%--        </div>--%>

<%--        <div class="row">--%>
<%--            <input type="submit" value="Add">--%>
<%--        </div>--%>
<%--    </form:form>--%>
<%--</div>--%>

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