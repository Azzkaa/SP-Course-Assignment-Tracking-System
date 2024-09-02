<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="navbar.jsp"%>
<html>
<head>
<title>Add Teacher</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/style.css'/>">
</head>
<body>
	<div class="container">
		<header>
			<h1>Add New Teacher</h1>
		</header>
		<form action="${pageContext.request.contextPath}/addTeacher"
			method="post" class="form-group">
			<div>
				<label for="firstName">First Name:</label> <input type="text"
					id="firstName" name="firstName" required class="form-control" />
			</div>
			<div>
				<label for="lastName">Last Name:</label> <input type="text"
					id="lastName" name="lastName" required class="form-control" />
			</div>
			<div>
				<label for="email">Email:</label> <input type="email" id="email"
					name="email" required class="form-control" />
			</div>
			<div>
				<input type="submit" value="Save" class="btn btn-add" />
			</div>
		</form>
	</div>

</body>
</html>