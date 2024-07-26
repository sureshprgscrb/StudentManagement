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
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<h3 class="text-center">Fetch Student Details</h3>
						<form action="fetchStudent">

							<div class="form-group">
								<label for="exampleInputEmail">Student Id</label> <input
									name="id" type="text" class="form-control"
									id="exampleInputEmail" aria-describedby="emailhelp"
									placeholder="Enter ID">
							</div>

							<div class="container text-center">
								<button type="submit" class="btn btn-primary">Fetch</button>
							</div>

						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
	<br>
	<br>
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

















