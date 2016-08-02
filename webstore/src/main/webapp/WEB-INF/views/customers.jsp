<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet"	type="text/css" href="/resources/css/bootstrap.min.css">
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
	<%@include file="template/navigation.jsp"%>
	<section class="container">
		<sec:authorize access="hasRole('ADMIN')">
        <a href="/customers/add"><button type="button" class="btn btn-info">Add Customer</button></a>
        <%--not ready yet--%>
        <a href="#"><button type="button" class="btn btn-info">Search Customer</button></a>
		</sec:authorize>
		<table class="table">
			<thead>
			<tr>
				<th>#</th>
				<th>Picture</th>
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
					<td><img src="<c:url value="/resource/images/${customer.id}.jpg"></c:url>" alt="image"  height="42" width="42"/></td>
                    <td>${customer.id}</td>
					<td>${customer.getName()}</td>
					<td>${customer.getAge()}</td>
					<td>${customer.getSalary()}</td>
                    <td>
						<sec:authorize access="hasRole('ADMIN')">
						<a href="/customers/delete/${customer.id}"><button type="button" class="btn btn-danger glyphicon glyphicon-trash"></button></a>
                        <a href="/customers/update/${customer.id}"><button type="button" class="btn btn-success glyphicon glyphicon-pencil"></button></a>
						</sec:authorize>
                    </td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</section>
</body>
</html>
