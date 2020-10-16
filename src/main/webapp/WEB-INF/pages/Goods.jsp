<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Goods</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/GoodsPage.js"></script>



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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/mystyle.css">
    <style>
        html,
        body,
        /*header,*/
        .carousel{
            height: 60vh;
        }
        @media (min-width: 740px){
            html,
            body,
            /*header,*/
            .carousel{
                height: 100vh;
            }
            @media (min-width: 800px) and (max-width: 850px){
                html,
                body,
                /*header,*/
                .carousel{
                    height: 100vh;
                }

            }
        }
    </style>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.0.0/animate.min.css"/>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/wow/1.1.2/wow.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/wow/1.1.2/wow.js"></script>



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
            <li><a href="${pageContext.request.contextPath}/Goods/?id=1/sortedByPrice" class="nav-link">Orders</a></li>
        </ul>
    </nav>

<div id="carousel-ex" class="carousel slide carousel-fade pt-4" data-ride="carousel">
    <ol class="carousel-indicators">
        <li class="active" data-target="#carousel-ex" data-slide-to="0"></li>
        <li data-target="#carousel-ex" data-slide-to="1"></li>
        <li data-target="#carousel-ex" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner" role="listbox">

        <div class="carousel-item active">
            <div class="view" style="background-image: url('https://images.pexels.com/photos/905336/pexels-photo-905336.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940');
                background-repeat: no-repeat; background-size: cover; ">
                <div class="mask rgba-black-strong d-flex
                justify-content-center align-items-center">
                    <div class="text-center white-text mx-5 wow fadeIn">

                        <h1 class="mb-4">
                            <strong>Test Shop Project</strong>
                        </h1>

                        <p>
                            <strong>lorem ipsum dolor set amet consectur adispicing elituse omus sanctis alea eacta aeterna</strong>
                        </p>

                        <p class="mb-4 d-none d-md-block">
                            <strong>lorem ipsum dolor set amet consectur adispicing elituse omus sanctis alea eacta aeterna</strong>
                        </p>

                        <a href="#" class="btn btn-outline-white btn-lg">
                            Lorem, ipsum dolor. <i class="fa fa-graduation-cap ml-2"></i>
                        </a>

                    </div>
                </div>
        </div>
        </div>

        <div class="carousel-item">
            <div class="view" style="background-image: url('https://images.pexels.com/photos/1454164/pexels-photo-1454164.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940');
background-repeat: no-repeat; background-size: cover; ">
                <div class="mask rgba-black-strong d-flex
                justify-content-center align-items-center">
                    <div class="text-center white-text mx-5 wow fadeIn">
                        <h1 class="mb-4">
                            <strong>Test Shop Project</strong>
                        </h1>

                        <p>
                            <strong>lorem ipsum dolor set amet consectur adispicing elituse omus sanctis alea eacta aeterna</strong>
                        </p>

                        <p class="mb-4 d-none d-md-block">
                            <strong>lorem ipsum dolor set amet consectur adispicing elituse omus sanctis alea eacta aeterna</strong>
                        </p>

                        <a href="#" class="btn btn-outline-white btn-lg">
                            Lorem, ipsum dolor. <i class="fa fa-graduation-cap ml-2"></i>
                        </a>

                    </div>
                </div>
            </div>
        </div>

        <div class="carousel-item">
            <div class="view" style="background-image: url('https://images.pexels.com/photos/3841338/pexels-photo-3841338.jpeg?auto=compress&cs=tinysrgb&dpr=3&h=750&w=1260');
                background-repeat: no-repeat; background-size: cover; ">
                <div class="mask rgba-black-strong d-flex
                justify-content-center align-items-center">
                    <div class="text-center white-text mx-5 wow fadeIn">
                        <h1 class="mb-4">
                            <strong>Test Shop Project</strong>
                        </h1>

                        <p>
                            <strong>lorem ipsum dolor set amet consectur adispicing elituse omus sanctis alea eacta aeterna</strong>
                        </p>

                        <p class="mb-4 d-none d-md-block">
                            <strong>lorem ipsum dolor set amet consectur adispicing elituse omus sanctis alea eacta aeterna</strong>
                        </p>

                        <a href="#" class="btn btn-outline-white btn-lg">
                            Lorem, ipsum dolor. <i class="fa fa-graduation-cap ml-2"></i>
                        </a>

                    </div>
                </div>
            </div>
        </div>



    </div>
</div>



</header>

<main>
    <div class="container-fluid">
        <div class="row mt-5">
            <div class="col-md-3">
                <div class="card mt-3">
                    <article class="card-group-item">
                        <header class="card-header">
                            <h6 class="title">Range input </h6>
                        </header>
                        <div class="filter-content">
                            <div class="card-body">
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label>Min</label>
                                        <input type="number" class="form-control" id="inputEmail4"  placeholder="$0">
                                    </div>
                                    <div class="form-group col-md-6 text-right">
                                        <label>Max</label>
                                        <input type="number" class="form-control" id="inputEmail5" onchange="localStorage.setItem('inputEmail5', $('#inputEmail5').val())" placeholder="$1,0000">
                                    </div>
                                </div>
                            </div> <!-- card-body.// -->
                        </div>
                    </article> <!-- card-group-item.// -->
                    <article class="card-group-item">
                        <header class="card-header">
                            <h6 class="title">Selection </h6>
                        </header>
                        <div class="filter-content">
                            <div id="brands" class="card-body">

                            </div> <!-- card-body.// -->
                        </div>
                    </article> <!-- card-group-item.// -->
                    <article class="card-group-item">
                        <div class="card-body">

                            <button type="submit" id="sub" onclick="FilterSubmitButtonClick()" class="btn btn-primary">Submit</button>

                        </div>
                    </article>
                </div> <!-- card.// -->
            </div>

 <div class="col-md-9">

      <nav class="navbar navbar-expand-lg navbar-dark mdb-color lighten-3 mt-3 mb-2 ">
        <span class="navbar-brand">Categories:</span>

          <button class="navbar-toggler" type="button"
                  data-toggle="collapse" data-target="#nextNav"
                  aria-controls="nextNav" aria-expanded="false" aria-label="Toggle navigation">

              <span class="navbar-toggler-icon"></span>

          </button>

          <div class="collapse navbar-collapse" id="nextNav">
              <ul id="CategoriesContainer" class="navbar-nav mr-auto">

              </ul>

              <input id="hid" class="hid" type="hidden" value="1">

              <form class="form-inline">
                  <div class="md-form my-0">
                      <input type="text" class="form-control mr-sm-2"
                             placeholder="Search" aria-label="Search">
                  </div>
              </form>

          </div>

            </nav>

        <nav class="navbar navbar-expand-lg navbar-dark blue lighten-5 mb-5">
            <span class="navbar-brand black-text">Sort by:</span>

            <button class="navbar-toggler" type="button"
                    data-toggle="collapse" data-target="#nextNav2"
                    aria-controls="nextNav" aria-expanded="false" aria-label="Toggle navigation">

                <span class="navbar-toggler-icon"></span>

            </button>

            <div class="collapse navbar-collapse" id="nextNav2">
                <ul id="SortContainer" class="navbar-nav mr-auto">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle black-text" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Price: Low to High
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <a class="dropdown-item"  onclick="$('#priceMenu').val('price_asc');dropdownItemClick(); $('#navbarDropdownMenuLink').text('Price: Low to High');localStorage.setItem('priceMenu', 'price_asc');localStorage.setItem('navbarDropdownMenuLink','Price: Low to High');" >Price: Low to High</a>
                            <a class="dropdown-item "  onclick="$('#priceMenu').val('price_desc'); dropdownItemClick();$('#navbarDropdownMenuLink').text('Price: High to Low');localStorage.setItem('priceMenu', 'price_desc');localStorage.setItem('navbarDropdownMenuLink','Price: High to Low')">Price: High to Low</a>
                            <a class="dropdown-item"  onclick="$('#priceMenu').val('newer_first');dropdownItemClick(); $('#navbarDropdownMenuLink').text('New');localStorage.setItem('priceMenu', 'newer_first');localStorage.setItem('navbarDropdownMenuLink','New')" >New</a>

                            <input id="priceMenu" type="hidden" value="price_asc">
                        </div>
                    </li>

                </ul>
            </div>


        </nav>

        <section class="text-center mb-4">
            <div id="showItems" class="row wow fadeInDown">

    </div>
        </section>
        <nav class="d-flex justify-content-center wow fadeInDown">
            <ul class="pagination pg-blue">
                <li id="first" class="page-item ">
                    <a class="page-link" aria-label="Previous" onclick="LeftArrowClick()">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>


                <li id="last" class="page-item " onclick="RightArrowClick()">
                    <a   class="page-link" aria-label="Next">
                        <span id="RightArrow"  aria-hidden="true">&raquo;</span>
                    </a>
                </li>

            </ul>



        </nav>
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
<script type="text/javascript">
    $(document).ready(pageOnLoad());
</script>






<!-- jQuery -->
<!-- Bootstrap tooltips -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/popper.min.js"></script>
<!-- Bootstrap core JavaScript -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<!-- MDB core JavaScript -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/mdb.min.js"></script>
<!-- Your custom scripts (optional) -->
<script type="text/javascript"> wow = new WOW();
wow.init(); </script>


</html>
