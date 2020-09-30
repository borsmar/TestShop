<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<style>
    .selected {
        background-color: grey;
    }
</style>

<head>
    <meta name="_csrf" content="${_csrf.token}"/>


    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/deleteCategory.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/getCategories.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/getItemsByCategory.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/deleteItem.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/createItem.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/createCategory.js"></script>
    <script type="text/javascript">
        $(document).ready(getItemsByCategory(1));
    </script>
    <script type="text/javascript">
        $(document).ready(getCategories());
    </script>

    <title>Add Goods</title>



    <link href="${pageContext.request.contextPath}/resources/css/my.css" rel="stylesheet">
    <link rel="icon" href="${pageContext.request.contextPath}/resources/img/mdb-favicon.ico" type="image/x-icon">
    <!-- Font Awesome -->
    <link rel="stylesheet" type="text/css" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
    <!-- Google Fonts Roboto -->
    <link rel="stylesheet" type="text/css"
          href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
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
            <img src="https://www.freelogodesign.org/file/app/client/thumb/600ebf37-f8bc-4710-addd-a16f17124f63_200x200.png?1597678551852"
                 alt="" class="img-fluid">
        </a>
        <div class="list-group list-group-flush">
            <a href="#" class="list-group-item active waves-effect">
                <i class="fa fa-pie-chart mr-3"></i>Dashboard
            </a>
            <a href="${pageContext.request.contextPath}/profile/" class="list-group-item waves-effect">
                <i class="fa fa-user mr-3"></i>Profile
            </a>
            <a href="#" class="list-group-item waves-effect">
                <i class="fa fa-table mr-3"></i>Tables
            </a>
            <a href="#" class="list-group-item waves-effect">
                <i class="fa fa-map mr-3"></i>Orders
            </a>
        </div>
    </div>
</header>

<main class="pt-5 max-lg-5">
    <div class="container-fluid mt-5">
        <div class="card mb-4 wow fadeIn">
            <div class="card-header">
                <select id="cat" onchange="getItemsByCategory(this.value)">
            </select>
            </div>
            <div id="tableContainer" class="card-body d-sm-flex justify-content-between">
            </div>
            <div class="container">


                <div class="row">
                    <div class="col-3 ">
                        <label for="name">Name</label>
                    </div>
                    <div class="col-lg mb-3">
                        <input class="form-control form-control-lg" id="name" placeholder="type name"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-3">
                        <label for="brand">Brand</label>
                    </div>
                    <div class="col-lg mb-3">
                        <input class="form-control form-control-lg" id="brand" placeholder="type brand"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-3">
                        <label for="color">Color</label>
                    </div>
                    <div class="col-lg mb-3">
                        <input class="form-control form-control-lg" id="color" placeholder="type color"/>
                    </div>
                </div>

                <div class="row">
                    <div class="col-lg">
                    <input class="col-lg mb-2" type="submit" value="Add" onclick="createItem()">
                    </div>
                </div>
            </div>
        </div>
    </div>


    <div class="container-fluid mt-5">
        <div class="card mb-4 wow fadeIn">
            <div id="TableCatContainer" class="card-body d-sm-flex justify-content-between">

            </div>
        </div>
    </div>

    <div class="container">

        <div class="row">
            <div class="col-3 ">
                <label for="namecat">Name</label>
            </div>
            <div class="col-lg">
                <input class="form-control form-control-lg" id="namecat" placeholder="type name"/>
            </div>
            <div class="col-3">
                <input type="submit" value="Add" onclick="createCategory()">
            </div>

        </div>


    </div>

</main>


<%@ include file="/WEB-INF/pages/footer.jsp" %>

</body>




<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/popper.min.js"></script>
<!-- Bootstrap core JavaScript -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<!-- MDB core JavaScript -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/mdb.min.js"></script>


</html>