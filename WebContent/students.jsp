<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="navbar.jsp"%>
<html>
<head>
<title>Student List</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/style.css'/>">
</head>
<body>
	<div class="container">
		<header>
			<h1>Students</h1>
		</header>
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${students}" var="student">
					<tr>
						<td>${student.studentId}</td>
						<td><a
							href="${pageContext.request.contextPath}/studentDetails?studentId=${student.studentId}">${student.firstName}</a></td>
						<td>${student.lastName}</td>
						<td>${student.email}</td>
						<td>
							<form action="${pageContext.request.contextPath}/deleteStudent"
								method="post">
								<input type="hidden" name="studentId"
									value="${student.studentId}" /> <input type="submit"
									value="Delete" class="btn btn-delete" />
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<p>
			<a href="${pageContext.request.contextPath}/addStudent"
				class="btn btn-add">Add Student</a>
		</p>
	</div>
</body>
</html>
