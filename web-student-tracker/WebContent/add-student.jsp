<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add student</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
</head>
<body>
	<br>
	<div class="container">
		<nav class="navbar navbar-dark bg-dark">
			<span class="navbar-brand mb-0 h1">ADD STUDENT</span>
		</nav>
		<br>
		<form action="StudentController" method="get">
			<input type="hidden" name="command" value="ADD" />
			<div class="form-row">
				<div class="col">
					First Name : <input type="text" class="form-control" name="fname">
				</div>
				<div class="col">
					Last Name : <input type="text" class="form-control" name="lname">
				</div>
			</div>
			<div class="form-row">
				<div class="col">
					Email : <input type="text" class="form-control" name="email">
				</div>
			</div>
			<br><button type="submit" class="btn btn-outline-secondary">submit</button>
		</form>
		<br> <a href="StudentController">Back to List</a>
	</div>
</body>
</html>