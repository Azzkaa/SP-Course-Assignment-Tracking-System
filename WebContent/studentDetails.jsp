<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="navbar.jsp"%>
<html>
<head>
<title>Student Details</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/style.css'/>">
</head>
<body>
	<div class="container detail-view">
		<header>
			<h1 class="detail-heading">Student Details</h1>
		</header>
		<p class="detail-item">ID: ${student.studentId}</p>
		<p class="detail-item">First Name: ${student.firstName}</p>
		<p class="detail-item">Last Name: ${student.lastName}</p>
		<p class="detail-item">Email: ${student.email}</p>
		<!-- Display other details as needed -->
		<a href="${pageContext.request.contextPath}/students"
			class="btn btn-default">Back to List</a>
	</div>
</body>
</html>
