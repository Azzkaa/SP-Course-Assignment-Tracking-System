<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="navbar.jsp"%>
<html>
<head>
<title>Course List</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/style.css'/>">

</head>
<body>
	<div class="container">
		<header>
			<h1>Courses</h1>
		</header>
		<table>
			<thead>
				<tr>
					<th>Course ID</th>
					<th>Course Name</th>
					<th>Course Code</th>
					<th>Teacher Assigned</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${courses}" var="course">
					<tr>
						<td>${course.courseId}</td>
						<td>${course.courseName}</td>
						<td>${course.courseCode}</td>
						<td>${course.teacherName != null ? course.teacherName : 'None'}</td>
						<td>
							<form action="${pageContext.request.contextPath}/deleteCourse"
								method="post">
								<input type="hidden" name="courseId" value="${course.courseId}" />
								<input type="submit" value="Delete" class="btn btn-delete" />
							</form> <a
							href="${pageContext.request.contextPath}/showAssignTeacherForm?courseId=${course.courseId}"
							class="btn btn-default">Assign</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<p>
			<a href="${pageContext.request.contextPath}/addCourse"
				class="btn btn-add">Add Course</a>
		</p>
	</div>

</body>
</html>