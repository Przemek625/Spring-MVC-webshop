
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Products</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Customers</h1>
            <p>Add Customer</p>
        </div>
    </div>
</section>
<%@include file="template/navigation.jsp"%>
<section class="container">
    <form:form  modelAttribute="customer" class="form-horizontal" enctype="multipart/form-data">
        <fieldset>
            <legend>Add new Customer</legend>

            <div class="form-group">
                <label class="control-label col-lg-2" for="name">Name</label>
                <div class="col-lg-10">
                    <form:input id="name" path="name" type="text" class="form:input-large" />
                    <form:errors path="name" cssClass="text-danger"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2" for="age">Age</label>
                <div class="col-lg-10">
                    <div class="form:input-prepend">
                        <form:input id="age" path="age" type="text" class="form:input-large"/>
                        <form:errors path="age" cssClass="text-danger"/>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2" for="salary">Salary</label>
                <div class="col-lg-10">
                    <form:input id="salary" path="salary" type="text" class="form:input-large"/>
                    <form:errors path="salary" cssClass="text-danger"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2" for="salary">Choose file</label>
                <div class="col-lg-10">
                    <form:input id="image" path="image" type="file" class="form:input-large" />
                </div>
            </div>
            <div class="form-group">
                <div class="col-lg-offset-2 col-lg-10">
                    <input type="submit" id="btnAdd" class="btn btn-primary" value ="Add"/>
                </div>
            </div>

        </fieldset>
    </form:form>
</section>
</body>
</html>

