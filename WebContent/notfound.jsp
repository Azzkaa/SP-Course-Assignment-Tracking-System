<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Not Found</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/style.css'/>">
</head>
<body>
	<div class="container">
		<header>
			<h1>Page Not Found</h1>
		</header>
		<p>The page you are looking for might have been removed, had its
			name changed, or is temporarily unavailable.</p>
		<p>
			<a href="${pageContext.request.contextPath}/" class="btn btn-default">Return
				to Home Page</a>
		</p>
	</div>
</body>
</html>
