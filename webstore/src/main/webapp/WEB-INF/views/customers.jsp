<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Products</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Customers</h1>
				<p>All customers of our shop!</p>
			</div>
		</div>
	</section>
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">WebSiteName</a>
            </div>
            <ul class="nav navbar-nav">
                <li class="active"><a href="/">Home</a></li>
                <li class="active"><a href="/customers">Customers</a></li>
            </ul>
        </div>
    </nav>
	<section class="container">
        <a href="/customers/add"><button type="button" class="btn btn-info">Add Customer</button></a>
        <%--not ready yet--%>
        <a href="#"><button type="button" class="btn btn-info">Search Customer</button></a>
		<table class="table">
			<thead>
			<tr>
				<th>#</th>
				<th>ID</th>
				<th>Name</th>
				<th>Age</th>
				<th>Salary</th>
                <th>Acttion</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${customers}" var="customer">
				<tr>
					<th scope="row"></th>
                    <td>${customer.id}</td>
					<td>${customer.getName()}</td>
					<td>${customer.getAge()}</td>
					<td>${customer.getSalary()}</td>
                    <td><a href="/customers/delete/${customer.id}"><button type="button" class="btn btn-danger glyphicon glyphicon-trash"></button></a>
                        <a href="/customers/update/${customer.id}"><button type="button" class="btn btn-success glyphicon glyphicon-pencil"></button></a>
                    </td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</section>
</body>
</html>
