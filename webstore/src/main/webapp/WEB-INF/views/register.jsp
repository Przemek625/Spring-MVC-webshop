<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org">
<head>
    <title>login page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet"	type="text/css" href="/resources/css/bootstrap.min.css">
    <link href="/resources/css/signin.css" rel="stylesheet">
</head>

<body>
<div id="container">

    <form:form class="form-signin" modelAttribute="user" enctype="">

        <h2 class="form-signin-heading">Register form</h2>

        <c:if test="${usernameExist != null}">
            <div class="alert alert-danger">
                    ${usernameExist}
            </div>
        </c:if>

        <label for="username" class="sr-only">Username</label>
        <form:input type="text" id="username" path="username" name="username" class="form-control" placeholder="Username"/>
        <label for="password" class="sr-only">Password</label>
        <form:input type="password" path="password" id="password" name="password" class="form-control" placeholder="Password"/>
        <input type="submit" id="btnAdd" class="btn btn-primary" value ="Sign in"/>
    </form:form>

</div>
</body>

</html>
