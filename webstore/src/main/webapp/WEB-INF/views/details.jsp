<%--
  Created by IntelliJ IDEA.
  User: Przemek
  Date: 2016-08-09
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
            <form:form class="form-group"  modelAttribute="comment" method="post">
                <div class="form-group">
                    <textarea class="form-control" rows="5" id="commentContent" name="commentContent"></textarea>
                </div>
                <input type="submit" value="Add a Comment" class="btn btn-primary">
            </form:form>
        </sec:authorize>
        <hr>
        <ul class="media-list comments">
            <c:forEach items="${comment}" var="comment">
            <li class="media">
                <a class="pull-left" href="#">
                    <img class="media-object img-circle img-thumbnail"
                         src="/resources/images/guest.png" width="64" alt="Generic placeholder image">
                </a>
                <div class="media-body">
                    <h5 class="media-heading pull-left">${comment.commentatorName}</h5>
                    <div class="comment-info pull-left">
                        <div class="btn btn-default btn-xs"><i class="fa fa-clock-o"></i>Posted ${comment.commentDate}</div>
                    </div>
                    <br class="clearfix">
                    <p class="well">
                        ${comment.commentContent}
                    </p>
                </div>
            </li>
            </c:forEach>
        </ul>
    </div>
</div>
</section>


</body>
</html>
