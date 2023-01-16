<%@ page import="com.entity.Admin" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Menu</title>
</head>
<body>
	<%Admin admin=(Admin)session.getAttribute("admin"); %>
	<%if(admin!=null){ %>
	<h1>Hello Welcome Admin</h1>
	<button><a href="adminLogout.jsp">Logout</a></button>
	<form action="showTeachers" method="post">
		<button type="submit">Show Teachers</button>
	</form>
	<button><a href="showStudents.jsp">View Students</a></button>
	<button><a href="showNotices.jsp">View Notices</a></button>
	<%}else{ %>
	Please provide valid user and password
	<button><a href="adminLogin.jsp">Login</a></button>
	<%} %>
</body>
</html>