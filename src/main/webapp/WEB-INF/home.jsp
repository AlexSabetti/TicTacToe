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
<title>Insert title here</title>
</head>
<body>
	<div class="container text-center">
		<div class="row row-sm-1 border border-black border-4 p-2" style="background-color:lightgrey">
			<h1 class="col col-md-4">Welcome, <c:out value="${user.userName}"/></h1>
			<a href="/logout" class="col col-md-4">Logout</a>
		</div>
		
		<br><br>
		
		<div class="row">
			<h2>Games</h2>
		</div>
		<div class="row border border-2 border-black">
			<table>
				<thead class="border border-black">
					<tr>
						<th scope="col">Game</th>
						<th scope="col">Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="game" items="${games}">
						<tr>
							<td>
								<c:out value="${game.name}"/>
							</td>
							<td>
								<a href="/games/${game.id}/home">Play</a>	
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>