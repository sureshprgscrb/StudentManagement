<%@page import="training.java.spring.webmvc.bean.StudentBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="training.java.spring.webmvc.bean.StudentBean"%>

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
	<div class="container mt-4">

		<div class="row">
			<div class="col-md-10 offset-md-2">
				<div class="card">
					<div class="card-body">
						

						<div class="container mt-6">
							<h2 class="text-center">Details of the student is here</h2>
<br>
<br>

<!-- USING EL-->
<table class="table" border="2" align="center">
								<thead class="thead-dark">
								<tr>
									<th>Student Id</th>
									<th>Student Name</th>
									<th>Student DoB</th>
									<th>Student Gender</th>
									<th>Student Type</th>
									<th>Student City</th>
									</tr>
									</thead>


																	
								<tr>
									<td>${studentDetails.id }</td>
									<td>${studentDetails.name }</td>
									<td>${studentDetails.dob }</td>
									<td>${studentDetails.gender }</td>
									<td>${studentDetails.type }</td>
									<td>${studentDetails.city }</td>

								</tr>
							



							</table>
							

<br>
<br>

<!-- USING Java -->

							<table class="table" border="2" align="center">
								<thead class="thead-dark">
								<tr>
									<th>Student Id</th>
									<th>Student Name</th>
									<th>Student DoB</th>
									<th>Student Gender</th>
									<th>Student Type</th>
									<th>Student City</th>

								</tr>
								</thead>
									<%
									StudentBean student = (StudentBean) request.getAttribute("StudentInfo");
																		%>
								
								<tr>
									<td><%=student.getId()%></td>
									<td><%=student.getName()%></td>
									<td><%=student.getDob()%></td>
									<td><%=student.getGender()%></td>
									<td><%=student.getType()%></td>
									<td><%=student.getCity()%></td>

								</tr>
							



							</table>
<br>
<br>

							<h5 class="text-center">
								<a href="index.jsp">Go Home?</a>
							</h5>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap JS and dependencies -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>

















