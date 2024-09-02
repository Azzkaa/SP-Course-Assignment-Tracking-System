<!-- navbar.jsp in /WEB-INF/views/ directory -->
<nav>
	<ul>
		<li><a href="${pageContext.request.contextPath}/students">Students
				Management</a></li>
		<li><a href="${pageContext.request.contextPath}/teachers">Teachers
				Management</a></li>
		<li><a href="${pageContext.request.contextPath}/courses">Course
				Management</a></li>
	</ul>
</nav>

<!-- Optional: Add CSS for styling the navigation bar -->
<style>
nav ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #333;
}

nav ul li {
	float: left;
}

nav ul li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

nav ul li a:hover {
	background-color: #111;
}
</style>
