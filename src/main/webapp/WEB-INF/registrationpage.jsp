<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri= "http://www.springframework.org/tags/form" %>
<%@ page isErrorPage ="true" %>
<!DOCTYPE html>
<html>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/style.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<div class="container text-center">
	<div>
		<h1 style="color:Purple">Tic-Tac-Toe</h1>
		<p>TicTacToe by Post</p>
		<h4 style="color:red"><c:out value="${warning}"/></h4>
	</div>
	<div class="col">
			<h1>Register</h1>
			<form:form action="/register" method="post" modelAttribute="newRegister">
				<div>
					<form:label path="userName">User Name</form:label>
					<div>
							<form:errors path="userName" style="color:red"/>
						<br>
					</div>
					<form:input path="userName"/>
				</div>
				<br>
				<div>
					<form:label path="email">Email:</form:label>
					<div>
							<form:errors path="email" style="color:red"/>
						<br>
					</div>
					<form:input path="email"/>
				</div>
				<br>
				<div>
					<form:label path="password">Password:</form:label>
					<div>
						<form:errors path="password" style="color:red"/>
						<br>
					</div>
					<form:input type="password" path="password"/>
				</div>
				<br>
				<div>
					<form:label path="confirm">Confirm Password</form:label>
					<div>
							<form:errors path="confirm" style="color:red"/>
						<br>
					</div>
					
					<form:input type="password" path="confirm"/>
				</div>
				<div class="self-align-end">
					<input type="submit" value="Submit">
				</div>
			</form:form>
			<div>
				<span>Already have an account? <a href="/">click here</a></span>
			</div>
		</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>