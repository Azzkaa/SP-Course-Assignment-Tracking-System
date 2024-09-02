<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="navbar.jsp"%>
<html>
<head>
    <title>Teacher List</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/style.css'/>">
</head>
<body>
    <div class="container">
        <header>
            <h1>Teachers</h1>
        </header>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${teachers}" var="teacher">
                    <tr>
                        <td>${teacher.teacherId}</td>
                        <td><a href="${pageContext.request.contextPath}/teacherDetails?teacherId=${teacher.teacherId}">${teacher.firstName} ${teacher.lastName}</a></td>
                        <td>${teacher.email}</td>
                        <td>
                            <form action="${pageContext.request.contextPath}/deleteTeacher" method="post">
                                <input type="hidden" name="teacherId" value="${teacher.teacherId}" />
                                <input type="submit" value="Delete" class="btn btn-delete" />
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p>
            <a href="${pageContext.request.contextPath}/addTeacher" class="btn btn-add">Add Teacher</a>
        </p>
    </div>
</body>
</html>
F