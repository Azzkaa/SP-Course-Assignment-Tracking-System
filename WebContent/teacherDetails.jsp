<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="navbar.jsp"%>
<html>
<head>
<title>Teacher Details</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/style.css'/>">
</head>
<body>
	<div class="container detail-view">
		<header>
			<h1 class="detail-heading">Teacher Details</h1>
		</header>
		<p class="detail-item">ID: ${teacher.teacherId}</p>
		<p class="detail-item">First Name: ${teacher.firstName}</p>
		<p class="detail-item">Last Name: ${teacher.lastName}</p>
		<p class="detail-item">Email: ${teacher.email}</p>
		<!-- Display other details as needed -->
		<a href="${pageContext.request.contextPath}/teachers"
			class="btn btn-default">Back to List</a>
	</div>

</body>
</html>