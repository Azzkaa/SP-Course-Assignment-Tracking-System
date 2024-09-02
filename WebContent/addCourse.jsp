<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="navbar.jsp"%>
<html>
<head>
<title>Add Course</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/style.css'/>">
</head>
<body>
	<div class="container">
		<header>
			<h1>Add New Course</h1>
		</header>
		<form action="${pageContext.request.contextPath}/addCourse"
			method="post" class="form-group">
			<div>
				<label for="courseId">Course ID:</label> <input type="text"
					id="courseId" name="courseId" required class="form-control" />
			</div>
			<div>
				<label for="courseName">Course Name:</label> <input type="text"
					id="courseName" name="courseName" required class="form-control" />
			</div>
			<div>
				<label for="courseCode">Course Code:</label> <input type="text"
					id="courseCode" name="courseCode" required class="form-control" />
			</div>
			<div>
				<input type="submit" value="Add Course" class="btn btn-add" />
			</div>
		</form>
	</div>

</body>
</html>