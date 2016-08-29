<%--
  Created by IntelliJ IDEA.
  User: Przemek
  Date: 2016-07-24
  Time: 00:39
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-inverse navbar-fixed-top"  role="navigation">
    <div class="container-fluid">
        <ul class="nav navbar-nav">
            <li><a href="/">Home</a></li>
            <li><a href="/customers">Customers</a></li>
            <li><a href="#">Products</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Select Language<span class="caret"></span></a>
            <ul class="dropdown-menu">
                <li><a href="?lang=en">English</a></li>
                <li><a href="?lang=pl">Polish</a></li>

            </ul>
            </li>
            <sec:authorize access="isAnonymous()">
                <li><a href="/register"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                 <li><p class="navbar-text">Signed in as
                     <sec:authentication property="principal.username" />
                 </p></li>
                <li><a href="/logout"><span class="glyphicon glyphicon-log-in"></span> Log out</a></li>
            </sec:authorize>
        </ul>
    </div>
</nav>