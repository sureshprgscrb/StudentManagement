<%@page import="training.java.spring.webmvc.bean.StudentBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="training.java.spring.webmvc.bean.StudentBean" %>
	
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0 shrink-to-fit=yes">
<title>Student Management</title>
<!-- Bootstrap CSS -->
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

	<div class="container mt-6">
		<h2 class="text-center">Delete student details here</h2>

	<table class="table" border="2" align="center">
								<thead class="thead-dark">
			<tr>
			<th>Student Id</th>
			<th>Student Name</th>
			<th>Student DoB</th>
			<th>Student Gender</th>
			<th>Student Type</th>
			<th>Student City</th>
			<th>Action</th>
</tr>
</thead>
		
<%
List<StudentBean> students = (List<StudentBean>) request.getAttribute("StudentData");
for(StudentBean s:students)
{
	%>	<tr>
<td><%=s.getId() %></td>
<td><%=s.getName() %></td>
<td><%=s.getDob() %></td>
<td><%=s.getGender() %></td>
<td><%=s.getType() %></td>
<td><%=s.getCity() %></td>
<td><a href="deleteProcess/<%=s.getId() %>">Delete</a></td>

	</tr>
	<%
}

	%>

	
			
		</table>

		
		<h5 class="text-center">
			<a href="index.jsp">Go Home?</a>
		</h5>
	</div>

	<!-- Bootstrap JS and dependencies -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
