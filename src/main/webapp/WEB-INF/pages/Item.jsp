<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<%--    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">--%>
    <title>Item</title>
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
</header>
<main class="pt-5 max-lg-5">
    <div class="container dark-grey-text mt-5">
        <div class="row wow fadeIn">
            <div class="col-md-6 mb-4">
                <img src="${item.imageURL}" alt="Iphone" class="img-fluid">
            </div>
            <div class="col-lg-6 mb-4 pt-5">
                <div class="p-4 pt-5">
                    <p class="lead font-weight-bold pt-5">Description</p>
                    <p>${item.description}</p>
                    <form action="" class="d-flex justify-content-center-left">
                        <input type="number" value="1" aria-label="Search"
                        style="width: 100px;" class="form-control">
                        <button type="submit" class="btn btn-primary btn-md my-0 p">
                            Add to cart <i class="fa fa-shopping-cart ml-1"></i>
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </div>



</main>
<footer class="page-footer text-center font-small mt-4 wow fadeIn" style="background-color: cornflowerblue">
    <div class="pt-4">
        <a href="#" role="button" class="btn btn-outline-white">TestShop
            <i class="fa fa-graduation-cap ml-2"></i></a>
        <a href="#" role="button" class="btn btn-outline-white">Catalog
            <i class="fa fa-graduation-cap ml-2"></i></a>
    </div>
    <hr class="my-4">
    <%--    <div class="pb-4">--%>
    <%--        <a href="#">--%>
    <%--        <i class="fa fa-facebook mr-3"></i>--%>
    <%--        </a>--%>
    <%--        <a href="#">--%>
    <%--            <i class="fa fa-twitter mr-3"></i>--%>
    <%--        </a>--%>
    <%--        <a href="#">--%>
    <%--            <i class="fa fa-youtube mr-3"></i>--%>
    <%--        </a>--%>
    <%--    </div>--%>

    <div class="footer-copyright py-3">
        TestShop Project
    </div>

</footer>

</body>
</html>
