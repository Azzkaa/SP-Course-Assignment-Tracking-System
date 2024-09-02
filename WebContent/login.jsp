<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Login</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/style.css'/>">
</head>
<body>
	<div class="container">
		<header>
			<h2>Login</h2>
		</header>
		<form action="${pageContext.request.contextPath}/login" method="post"
			class="form-group">
			<div class="input-group">
				<label for="username">Username:</label> <input type="text"
					id="username" name="username" required="required"
					class="form-control" />
			</div>
			<div class="input-group">
				<label for="password">Password:</label><input type="password"
					id="password" name="password" required="required"
					class="form-control" />
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-add">Login</button>
			</div>
			<%
				if (request.getAttribute("error") != null) {
			%>
			<p class="error-message"><%=request.getAttribute("error")%></p>
			<%
				}
			%>
		</form>
	</div>
</body>
</html>