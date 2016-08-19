<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org">
<head>
    <title>login page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet"	type="text/css" href="/resources/css/bootstrap.min.css">
    <link href="/resources/css/signin.css" rel="stylesheet">
    <!-- jQuery library -->
    <script src="/resources/js/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="/resources/js/bootstrap.min.js"></script>
</head>

<body>
<div id="container">

    <c:url value="/login" var="loginUrl"/>
    <form class="form-signin" action="${loginUrl}" method="post">
        <h2 class="form-signin-heading">Please log in</h2>
            <c:if test="${param.error != null}">
                <div class="alert alert-danger">
                    Invalid username or password.
                </div>
            </c:if>
            <c:if test="${param.logout != null}">
                <div class="alert alert-success">
                    You have been logged out.
                </div>
             </c:if>
            <label for="username" class="sr-only">Username</label>
            <input type="text" id="username" name="username" class="form-control" placeholder="Username" required autofocus/>
            <label for="password" class="sr-only">Password</label>
            <input type="password" id="password" name="password" class="form-control" placeholder="Password" required autofocus/>
        <button type="submit" class="btn btn-lg btn-primary btn-block">Log in</button>
    </form>
    </div>
</body>
</html>
