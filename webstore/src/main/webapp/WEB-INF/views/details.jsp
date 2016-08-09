<%--
  Created by IntelliJ IDEA.
  User: Przemek
  Date: 2016-08-09
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <link rel="stylesheet"	type="text/css" href="/resources/css/comment-theme.css">
    <link rel="stylesheet"	type="text/css" href="/resources/css/bootstrap.min.css">
    <title>Title</title>
</head>
<body>

<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Customers</h1>
            <p>Details of a Customer!</p>
        </div>
    </div>
</section>

<%@include file="template/navigation.jsp"%>

<section class="container">
<div class="row">
    <div class="col-lg-8 col-sm-8 col-xs-12">
        <h4 id="addComment">Leave a Comment:</h4>

        <sec:authorize access="isAnonymous()">
        <p class="well">Please <a href="#">sign in</a> to add comments!</p>
        </sec:authorize>

        <sec:authorize access="isAuthenticated()">
        <div class="form-group">
            <textarea class="form-control" rows="5" id="comment"></textarea>
        </div>
        </sec:authorize>

        <button type="button" class="btn btn-primary">Add a Comment</button>
        <hr>
        <ul class="media-list comments">
            <li class="media">
                <a class="pull-left" href="#">
                    <img class="media-object img-circle img-thumbnail"
                         src="/resources/images/guest.png" width="64" alt="Generic placeholder image">
                </a>
                <div class="media-body">
                    <h5 class="media-heading pull-left">loneswan</h5>
                    <div class="comment-info pull-left">
                        <div class="btn btn-default btn-xs"><i class="fa fa-clock-o"></i> Posted 3 weeks ago</div>
                    </div>
                    <br class="clearfix">
                    <p class="well">
                        Awesome comment box! Awesome comment box!
                        Awesome comment box! Awesome comment box!
                        Awesome comment box! Awesome comment box!
                        Awesome comment box! Awesome comment box!
                        Awesome comment box! Awesome comment box!
                        Awesome comment box! Awesome comment box!
                    </p>
                </div>
            </li>
        </ul>
    </div>
</div>
</section>


</body>
</html>
