<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet"	type="text/css" href="/resources/css/bootstrap.min.css">
	<!-- jQuery library -->
	<script src="/resources/js/jquery.min.js"></script>

	<!-- Latest compiled JavaScript -->
	<script src="/resources/js/bootstrap.min.js"></script>
<title>Welcome</title>
</head>
<body>
	<section>
		<div class="jumbotron" style="margin: 0%">
			<div class="container">
				<h1> ${greeting} </h1>
				<p> ${tagline} </p>
				<spring:message code="welcome.message"/>
			</div>
		</div>
	</section>
	<%@include file="template/navigation.jsp"%>
</body>
</html>
