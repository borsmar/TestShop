<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Пример на bootstrap 4: Checkout - пользовательская форма заказа, показывающая компоненты формы и функции проверки. Версия v4.0.0">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">

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
        header,
        .carousel{
            height: 60vh;
        }
        @media (min-width: 740px){
            html,
            body,
            header,
            .carousel{
                height: 100vh;
            }
            @media (min-width: 800px) and (max-width: 850px){
                html,
                body,
                header,
                .carousel{
                    height: 100vh;
                }

            }
        }
    </style>
</head>

<body class="bg-light">



<script defer>
    (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
        (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
        m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
    })(window,document,'script','https://www.google-analytics.com/analytics.js','ga');

    ga('create', 'UA-4481610-59', 'auto');
    ga('send', 'pageview');

</script>

<!-- Yandex.Metrika counter --> <script type="text/javascript" > (function(m,e,t,r,i,k,a){m[i]=m[i]||function(){(m[i].a=m[i].a||[]).push(arguments)}; m[i].l=1*new Date();k=e.createElement(t),a=e.getElementsByTagName(t)[0],k.async=1,k.src=r,a.parentNode.insertBefore(k,a)}) (window, document, "script", "https://mc.yandex.ru/metrika/tag.js", "ym"); ym(39705265, "init", { clickmap:true, trackLinks:true, accurateTrackBounce:true, webvisor:true }); </script> <noscript><div><img src="https://mc.yandex.ru/watch/39705265" style="position:absolute; left:-9999px;" alt="" /></div></noscript> <!-- /Yandex.Metrika counter -->

<script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
<script>
    (adsbygoogle = window.adsbygoogle || []).push({
        google_ad_client: "ca-pub-8588635311388465",
        enable_page_level_ads: true
    });
</script>

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


<div class="container">
    <div class="py-5 text-center">
        <img class="d-block mx-auto mb-4" src="https://upload.wikimedia.org/wikipedia/commons/thumb/e/ee/Aperture_Science.svg/1200px-Aperture_Science.svg.png" alt="" width="72" height="72">
        <h2>Checkout form</h2>
        <p class="lead">Below is an example form built entirely with Bootstrap's form controls. Each required form group has a validation state that can be triggered by attempting to submit the form without completing it.</p>
    </div>

    <div class="row">
        <div class="col-md-4 order-md-2 mb-4">
            <h4 class="d-flex justify-content-between align-items-center mb-3">
                <span class="text-muted">Your cart</span>
                <span class="badge badge-secondary badge-pill">3</span>
            </h4>
            <ul class="list-group mb-3">
                <li class="list-group-item d-flex justify-content-between lh-condensed">
                    <div>
                        <h6 class="my-0">Product name</h6>
                        <small class="text-muted">Brief description</small>
                    </div>
                    <span class="text-muted">$12</span>
                </li>
                <li class="list-group-item d-flex justify-content-between lh-condensed">
                    <div>
                        <h6 class="my-0">Second product</h6>
                        <small class="text-muted">Brief description</small>
                    </div>
                    <span class="text-muted">$8</span>
                </li>
                <li class="list-group-item d-flex justify-content-between lh-condensed">
                    <div>
                        <h6 class="my-0">Third item</h6>
                        <small class="text-muted">Brief description</small>
                    </div>
                    <span class="text-muted">$5</span>
                </li>
                <li class="list-group-item d-flex justify-content-between bg-light">
                    <div class="text-success">
                        <h6 class="my-0">Promo code</h6>
                        <small>EXAMPLECODE</small>
                    </div>
                    <span class="text-success">-$5</span>
                </li>
                <li class="list-group-item d-flex justify-content-between">
                    <span>Total (USD)</span>
                    <strong>$20</strong>
                </li>
            </ul>

            <form class="card p-2">
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="Promo code">
                    <div class="input-group-append">
                        <button type="submit" class="btn btn-secondary">Redeem</button>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-md-8 order-md-1">
            <h4 class="mb-3">Billing address</h4>
            <form class="needs-validation" novalidate>
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="firstName">First name</label>
                        <input type="text" class="form-control" id="firstName" placeholder="" value="" required>
                        <div class="invalid-feedback">
                            Valid first name is required.
                        </div>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="lastName">Last name</label>
                        <input type="text" class="form-control" id="lastName" placeholder="" value="" required>
                        <div class="invalid-feedback">
                            Valid last name is required.
                        </div>
                    </div>
                </div>

                <div class="mb-3">
                    <label for="username">Username</label>
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text">@</span>
                        </div>
                        <input type="text" class="form-control" id="username" placeholder="Username" required>
                        <div class="invalid-feedback" style="width: 100%;">
                            Your username is required.
                        </div>
                    </div>
                </div>

                <div class="mb-3">
                    <label for="email">Email <span class="text-muted">(Optional)</span></label>
                    <input type="email" class="form-control" id="email" placeholder="you@example.com">
                    <div class="invalid-feedback">
                        Please enter a valid email address for shipping updates.
                    </div>
                </div>

                <div class="mb-3">
                    <label for="address">Address</label>
                    <input type="text" class="form-control" id="address" placeholder="1234 Main St" required>
                    <div class="invalid-feedback">
                        Please enter your shipping address.
                    </div>
                </div>

                <div class="mb-3">
                    <label for="address2">Address 2 <span class="text-muted">(Optional)</span></label>
                    <input type="text" class="form-control" id="address2" placeholder="Apartment or suite">
                </div>

                <div class="row">
                    <div class="col-md-5 mb-3">
                        <label for="country">Country</label>
                        <select class="custom-select d-block w-100" id="country" required>
                            <option value="">Choose...</option>
                            <option>United States</option>
                        </select>
                        <div class="invalid-feedback">
                            Please select a valid country.
                        </div>
                    </div>
                    <div class="col-md-4 mb-3">
                        <label for="state">State</label>
                        <select class="custom-select d-block w-100" id="state" required>
                            <option value="">Choose...</option>
                            <option>California</option>
                        </select>
                        <div class="invalid-feedback">
                            Please provide a valid state.
                        </div>
                    </div>
                    <div class="col-md-3 mb-3">
                        <label for="zip">Zip</label>
                        <input type="text" class="form-control" id="zip" placeholder="" required>
                        <div class="invalid-feedback">
                            Zip code required.
                        </div>
                    </div>
                </div>
                <hr class="mb-4">
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="same-address">
                    <label class="custom-control-label" for="same-address">Shipping address is the same as my billing address</label>
                </div>
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="save-info">
                    <label class="custom-control-label" for="save-info">Save this information for next time</label>
                </div>
                <hr class="mb-4">

                <h4 class="mb-3">Payment</h4>

                <div class="d-block my-3">
                    <div class="custom-control custom-radio">
                        <input id="credit" name="paymentMethod" type="radio" class="custom-control-input" checked required>
                        <label class="custom-control-label" for="credit">Credit card</label>
                    </div>
                    <div class="custom-control custom-radio">
                        <input id="debit" name="paymentMethod" type="radio" class="custom-control-input" required>
                        <label class="custom-control-label" for="debit">Debit card</label>
                    </div>
                    <div class="custom-control custom-radio">
                        <input id="paypal" name="paymentMethod" type="radio" class="custom-control-input" required>
                        <label class="custom-control-label" for="paypal">Paypal</label>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="cc-name">Name on card</label>
                        <input type="text" class="form-control" id="cc-name" placeholder="" required>
                        <small class="text-muted">Full name as displayed on card</small>
                        <div class="invalid-feedback">
                            Name on card is required
                        </div>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="cc-number">Credit card number</label>
                        <input type="text" class="form-control" id="cc-number" placeholder="" required>
                        <div class="invalid-feedback">
                            Credit card number is required
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-3 mb-3">
                        <label for="cc-expiration">Expiration</label>
                        <input type="text" class="form-control" id="cc-expiration" placeholder="" required>
                        <div class="invalid-feedback">
                            Expiration date required
                        </div>
                    </div>
                    <div class="col-md-3 mb-3">
                        <label for="cc-expiration">CVV</label>
                        <input type="text" class="form-control" id="cc-cvv" placeholder="" required>
                        <div class="invalid-feedback">
                            Security code required
                        </div>
                    </div>
                </div>
                <hr class="mb-4">
                <button class="btn btn-primary btn-lg btn-block" type="submit">Continue to checkout</button>
            </form>
        </div>
    </div>
</div>
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

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<%--<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>--%>
<%--<script>window.jQuery || document.write('<script src="/docs/4.0/assets/js/vendor/jquery-slim.min.js"><\/script>')</script>--%>
<%--<script src="/docs/4.0/assets/js/vendor/popper.min.js"></script>--%>
<%--<script src="/docs/4.0/dist/js/bootstrap.min.js"></script>--%>
<%--<script src="/docs/4.0/assets/js/vendor/holder.min.js"></script>--%>
<!-- jQuery -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
<!-- Bootstrap tooltips -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/popper.min.js"></script>
<!-- Bootstrap core JavaScript -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<!-- MDB core JavaScript -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/mdb.min.js"></script>
<!-- Your custom scripts (optional) -->
<script type="text/javascript"></script>

<script>
    // Example starter JavaScript for disabling form submissions if there are invalid fields
    (function() {
        'use strict';

        window.addEventListener('load', function() {
            // Fetch all the forms we want to apply custom Bootstrap validation styles to
            var forms = document.getElementsByClassName('needs-validation');

            // Loop over them and prevent submission
            var validation = Array.prototype.filter.call(forms, function(form) {
                form.addEventListener('submit', function(event) {
                    if (form.checkValidity() === false) {
                        event.preventDefault();
                        event.stopPropagation();
                    }
                    form.classList.add('was-validated');
                }, false);
            });
        }, false);
    })();
</script>
</body>

