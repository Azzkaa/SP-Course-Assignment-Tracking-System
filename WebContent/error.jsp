<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Error</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/style.css'/>">
</head>
<body>
	<div class="container">
		<header>
			<h1>An Error Occurred</h1>
		</header>
		<p>We are sorry, but there was an unexpected error. Please try
			again later.</p>
		<p>
			<a href="${pageContext.request.contextPath}/" class="btn btn-default">Return
				to Home Page</a>
		</p>
	</div>
</body>
</html>
