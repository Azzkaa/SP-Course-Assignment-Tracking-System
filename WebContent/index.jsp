<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Welcome to the Student Portal</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/style.css'/>">
</head>
<body>
	<div class="container">
		<header>
			<h1>Welcome to the Student Portal</h1>
		</header>
		<p class="welcome-message">
			This is the home page of our student portal. Please <a
				href="<c:url value='/login'/>" class="btn btn-default">login</a> to
			access your account.
		</p>
	</div>

</body>
</html>