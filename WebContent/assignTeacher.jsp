<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="navbar.jsp"%>
<html>
<head>
<title>Assign Teacher</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/style.css'/>">
</head>
<body>
	<div class="container">
		<header>
			<h1>Assign Teacher to Course: ${course.courseName}
				(${course.courseId})</h1>
		</header>
		<form action="${pageContext.request.contextPath}/assignTeacher"
			method="post" class="form-group">
			<input type="hidden" name="courseId" value="${course.courseId}" />
			<div>
				<label for="teacherId">Select Teacher:</label> <select
					name="teacherId" id="teacherId" required class="form-control">
					<option value="">-- Select a Teacher --</option>
					<c:forEach items="${teachers}" var="teacher">
						<option value="${teacher.teacherId}">${teacher.firstName}
							${teacher.lastName}</option>
					</c:forEach>
				</select>
			</div>
			<div>
				<input type="submit" value="Assign Teacher" class="btn btn-add" />
			</div>
		</form>
	</div>

</body>
</html>