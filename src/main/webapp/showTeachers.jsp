<%@ page language="java" import="com.entity.Admin,java.util.*,com.entity.Teacher" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<%	List<Teacher> viewTeacher=(List<Teacher>)session.getAttribute("viewTeacher"); %>
		<table>
	<% for(Teacher t:viewTeacher){ 
		if(t==null){
			continue;
		}
		else{
		%>
		<tr>
			<td><%t.getId(); %></td>
			<td><%t.getName(); %></td>
			<td><%t.getPhno(); %></td>
			<td><%t.getSubject(); %></td>
			<td><%t.getExperience(); %></td>
			<td><%t.getQualification(); %></td>
			<td><%t.getEmail(); %></td>
			<td><%t.getClassTeacher(); %></td>
			<td><%t.getAddress(); %></td>
		</tr>
	<%}} %>
		</table>
</body>
</html>