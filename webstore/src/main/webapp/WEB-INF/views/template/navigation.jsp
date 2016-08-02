<%--
  Created by IntelliJ IDEA.
  User: Przemek
  Date: 2016-07-24
  Time: 00:39
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <ul class="nav navbar-nav">
            <li class="active"><a href="/">Home</a></li>
            <li class="active"><a href="/customers">Customers</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <sec:authorize access="isAnonymous()">
                <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Log out</a></li>
            </sec:authorize>
        </ul>
    </div>
</nav>
