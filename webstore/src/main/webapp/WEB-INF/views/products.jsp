<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet"	type="text/css" href="/resources/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="/resources/js/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="/resources/js/bootstrap.min.js"></script>
    <title>Products</title>

   <style>
       p.price {
           font-size: 300%;
           text-align: right;
       }
   </style>
</head>
<body>
<%@include file="template/navigation.jsp"%>
<section  style="padding-top: 50px">
    <div class="jumbotron">
        <div class="container">
            <h1>Products</h1>
            <p>All products of our shop!</p>
        </div>
    </div>
</section>
<section class="container">
    <sec:authorize access="hasRole('ADMIN')">
        <a href="#"><button type="button" class="btn btn-info">Add product</button></a>
        <%--not ready yet--%>
        <a href="#"><button type="button" class="btn btn-info">Search product</button></a>
    </sec:authorize>

    <div class="row">

<c:forEach items="${products}" var="product">
        <div class="col-xs-6 col-sm-3">
            <div class="thumbnail">
                <img src="http://mikielis.pl/sample-scripts/products/images/product.png" alt="">
                <div class="caption">
                    <h4><a href="#">${product.productName}</a></h4>

                    <div style="padding-bottom: 5px">
                    <i class="glyphicon glyphicon-ok" style="font-size: 130%"></i>
                    <span><i class="pull-right icon-chevron-right"></i>Product is available!<br></span>
                    </div>

                    <div style="padding-bottom: 5px">
                    <i class="glyphicon glyphicon glyphicon-info-sign" style="font-size: 130%"></i>
                    <span><i class="pull-right icon-chevron-right"></i>Delivery within 24 hours!<br></span>
                    </div>

                    <p>${product.productDescription}</p>

                    <p style="text-align: right"><del>${product.productPrice}</del></p>

                    <p style="font-size: 300%">
                        <a href="#"><i class="glyphicon glyphicon-shopping-cart" style="font-size: 130%"></i></a>
                        <span class="pull-right">${product.productPrice}</span>
                    </p>

                    <div class="ratings">
                        <p class="pull-right">31 reviews</p>
                        <p>
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star-empty"></span>
                        </p>
                    </div>

                </div>
            </div>
        </div>
    </c:forEach>



    </div>


</section>
</body>
</html>
