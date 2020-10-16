<%--
  Created by IntelliJ IDEA.
  User: Boris
  Date: 15.10.2020
  Time: 23:35
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>cart</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

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
    <script src="${pageContext.request.contextPath}/resources/js/additemtocart.js"></script>
    <script type="text/javascript">
        $(document).ready(showItemsInCart());
    </script>
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


<!--Section: Block Content-->
<main>
    <div class="container">

        <!--Section: Block Content-->
        <section class="mt-5 mb-4">

            <!--Grid row-->
            <div class="row">

                <!--Grid column-->
                <div class="col-lg-8">

                    <!-- Card -->
                    <div class="card wish-list mb-4">
                        <div class="card-body">

                            <h5 id="number" class="mb-4">Cart (<span>2</span> items)</h5>

                            <div class="row mb-4">
                                <div class="col-md-5 col-lg-3 col-xl-3">
                                    <div class="view zoom overlay z-depth-1 rounded mb-3 mb-md-0">
                                        <img class="img-fluid w-100" src="https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/12a.jpg" alt="Sample">
                                        <a href="#!">
                                            <div class="mask waves-effect waves-light">
                                                <img class="img-fluid w-100" src="https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/12.jpg">
                                                <div class="mask rgba-black-slight waves-effect waves-light"></div>
                                            </div>
                                        </a>
                                    </div>
                                </div>
                                <div class="col-md-7 col-lg-9 col-xl-9">
                                    <div>
                                        <div class="d-flex justify-content-between">
                                            <div>
                                                <h5>Blue denim shirt</h5>
                                                <p class="mb-3 text-muted text-uppercase small">Shirt - blue</p>
                                                <p class="mb-2 text-muted text-uppercase small">Color: blue</p>
                                                <p class="mb-3 text-muted text-uppercase small">Size: M</p>
                                            </div>
                                            <div>
                                                <div class="def-number-input number-input safari_only mb-0 w-100">
                                                    <button onclick="this.parentNode.querySelector('input[type=number]').stepDown()" class="minus"></button>
                                                    <input class="quantity" min="0" name="quantity" value="1" type="number">
                                                    <button onclick="this.parentNode.querySelector('input[type=number]').stepUp()" class="plus"></button>
                                                </div>
                                                <small id="passwordHelpBlock" class="form-text text-muted text-center">
                                                    (Note, 1 piece)
                                                </small>
                                            </div>
                                        </div>
                                        <div class="d-flex justify-content-between align-items-center">
                                            <div>
                                                <a href="#!" type="button" class="card-link-secondary small text-uppercase mr-3"><i class="fas fa-trash-alt mr-1"></i> Remove item </a>
                                                <a href="#!" type="button" class="card-link-secondary small text-uppercase"><i class="fas fa-heart mr-1"></i> Move to wish list </a>
                                            </div>
                                            <p class="mb-0"><span><strong>$17.99</strong></span></p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <hr class="mb-4">
                            <div class="row mb-4">
                                <div class="col-md-5 col-lg-3 col-xl-3">
                                    <div class="view zoom overlay z-depth-1 rounded mb-3 mb-md-0">
                                        <img class="img-fluid w-100" src="https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/13a.jpg" alt="Sample">
                                        <a href="#!">
                                            <div class="mask waves-effect waves-light">
                                                <img class="img-fluid w-100" src="https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/13.jpg">
                                                <div class="mask rgba-black-slight waves-effect waves-light"></div>
                                            </div>
                                        </a>
                                    </div>
                                </div>
                                <div class="col-md-7 col-lg-9 col-xl-9">
                                    <div>
                                        <div class="d-flex justify-content-between">
                                            <div>
                                                <h5>Red hoodie</h5>
                                                <p class="mb-3 text-muted text-uppercase small">Hoodie - red</p>
                                                <p class="mb-2 text-muted text-uppercase small">Color: red</p>
                                                <p class="mb-3 text-muted text-uppercase small">Size: M</p>
                                            </div>
                                            <div>
                                                <div class="def-number-input number-input safari_only mb-0 w-100">
                                                    <button onclick="this.parentNode.querySelector('input[type=number]').stepDown()" class="minus"></button>
                                                    <input class="quantity" min="0" name="quantity" value="1" type="number">
                                                    <button onclick="this.parentNode.querySelector('input[type=number]').stepUp()" class="plus"></button>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="d-flex justify-content-between align-items-center">
                                            <div>
                                                <a href="#!" type="button" class="card-link-secondary small text-uppercase mr-3"><i class="fas fa-trash-alt mr-1"></i> Remove item </a>
                                                <a href="#!" type="button" class="card-link-secondary small text-uppercase"><i class="fas fa-heart mr-1"></i> Move to wish list </a>
                                            </div>
                                            <p class="mb-0"><span><strong>$35.99</strong></span></p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <p class="text-primary mb-0"><i class="fas fa-info-circle mr-1"></i> Do not delay the purchase, adding
                                items to your cart does not mean booking them.</p>

                        </div>
                    </div>
                    <!-- Card -->

                    <!-- Card -->
                    <div class="card mb-4">
                        <div class="card-body">

                            <h5 class="mb-4">Expected shipping delivery</h5>

                            <p class="mb-0"> Thu., 12.03. - Mon., 16.03.</p>
                        </div>
                    </div>
                    <!-- Card -->

                    <!-- Card -->
                    <div class="card mb-4">
                        <div class="card-body">

                            <h5 class="mb-4">We accept</h5>

                            <img class="mr-2" width="45px" src="https://mdbootstrap.com/wp-content/plugins/woocommerce-gateway-stripe/assets/images/visa.svg" alt="Visa">
                            <img class="mr-2" width="45px" src="https://mdbootstrap.com/wp-content/plugins/woocommerce-gateway-stripe/assets/images/amex.svg" alt="American Express">
                            <img class="mr-2" width="45px" src="https://mdbootstrap.com/wp-content/plugins/woocommerce-gateway-stripe/assets/images/mastercard.svg" alt="Mastercard">
                            <img class="mr-2" width="45px" src="https://z9t4u9f6.stackpathcdn.com/wp-content/plugins/woocommerce/includes/gateways/paypal/assets/images/paypal.png" alt="PayPal acceptance mark">
                        </div>
                    </div>
                    <!-- Card -->

                </div>
                <!--Grid column-->

                <!--Grid column-->
                <div class="col-lg-4">

                    <!-- Card -->
                    <div class="card mb-4">
                        <div class="card-body">

                            <h5 class="mb-3">The total amount of</h5>

                            <ul class="list-group list-group-flush">
                                <li class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 pb-0">
                                    Temporary amount
                                    <span>$53.98</span>
                                </li>
                                <li class="list-group-item d-flex justify-content-between align-items-center px-0">
                                    Shipping
                                    <span>Gratis</span>
                                </li>
                                <li class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 mb-3">
                                    <div>
                                        <strong>The total amount of</strong>
                                        <strong>
                                            <p class="mb-0">(including VAT)</p>
                                        </strong>
                                    </div>
                                    <span><strong>$53.98</strong></span>
                                </li>
                            </ul>

                            <button type="button" class="btn btn-primary btn-block waves-effect waves-light">go to
                                checkout</button>

                        </div>
                    </div>
                    <!-- Card -->

                    <!-- Card -->
                    <div class="card mb-4">
                        <div class="card-body">

                            <a class="dark-grey-text d-flex justify-content-between" data-toggle="collapse" href="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
                                Add a discount code (optional)
                                <span><i class="fas fa-chevron-down pt-1"></i></span>
                            </a>

                            <div class="collapse" id="collapseExample">
                                <div class="mt-3">
                                    <div class="md-form md-outline mb-0">
                                        <input type="text" id="discount-code" class="form-control font-weight-light" placeholder="Enter discount code">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Card -->

                </div>
                <!--Grid column-->

            </div>
            <!--Grid row-->

        </section>
        <!--Section: Block Content-->

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
<!--Section: Block Content-->
</body>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/popper.min.js"></script>
<!-- Bootstrap core JavaScript -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<!-- MDB core JavaScript -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/mdb.min.js"></script>
<!-- Your custom scripts (optional) -->
<script type="text/javascript"></script>

</html>
