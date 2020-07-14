<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<footer id="footer" style="margin-bottom:0">


    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
    <div class="section">
        <div class="container">
            <div class="row">
                <div class="col-md-3 col-xs-6">
                    <div class="footer">
                        <h3 class="footer-title">T-Shop</h3>
                        <p>Make clothes great again! <br> With us, of course. </p>
                        <ul class="footer-links">
                            <li><a href="tel: +78005553535"><i class="fa fa-phone"></i> +7 (800) 555-35-35</a></li>
                            <li><a href="mailto: contact@t-shop"><i class="fa fa-envelope-o"></i> contact@t-shop</a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col-md-3 col-xs-6">
                    <div class="footer">
                        <h3 class="footer-title">Categories</h3>
                        <ul class="footer-links" id="bottom-cats">
                        </ul>
                    </div>
                </div>
                <div class="clearfix visible-xs"></div>
                <div class="col-md-3 col-xs-6">
                    <div class="footer">
                        <h3 class="footer-title">Information</h3>
                        <ul class="footer-links">
                            <li><a href="#">About Us</a></li>
                            <li><a href="#">Shipping & Payment</a></li>
                            <li id="easter"><i class="fa fa-rocket"></i></li>
                        </ul>
                    </div>
                </div>
                <div class="col-md-3 col-xs-6">
                    <div class="footer">
                        <h3 class="footer-title">Account</h3>
                        <ul class="footer-links">
                                <li><a href="#">Login</a></li>
                                <li><a href="#">Registration</a></li>

                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div id="bottom-footer" class="section">
        <div class="container">
            <div class="col-md-12 text-center">
                    <span class="copyright">
								Copyright &copy;2018 All rights reserved | This template is based on <a
                            href="https://colorlib.com"
                            target="_blank">Colorlib</a>
							</span>
            </div>
        </div>
    </div>
</footer>

</body>
