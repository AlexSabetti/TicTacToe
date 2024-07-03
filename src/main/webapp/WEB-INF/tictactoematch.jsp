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
<script src="/TTTEndpoint.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

<head>
<meta charset="ISO-8859-1">
<title><c:out value="${game.name}"/></title>
</head>
<body class="p-3 m-0 h-100">
	<div class="container">
		<nav class="navbar navbar-dark fixed-top bg-dark">
			<div class="container-fluid">
				<a class="navbar-brand" href="/games/${game.id}/home"><c:out value="${game.name}"/></a>
				<button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasDarkNavbar" aria-controls="offcanvasDarkNavbar" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="offcanvas offcanvas-end text-bg-dark" tabindex="-1" id="offcanvasDarkNavbar" aria-labelledby="offcanvasDarkNavbarLabel">
					<div class="offcanvas-header">
						<h5 class="offcanvas-title" id="offcanvasDarkNavbarLabel">Game Website Trademarked</h5>
						<button type="button" class="btn-close btn-close-white" data-bs-dismiss="offcanvas" aria-label="Close"></button>
					</div>
					<div class="offcanvas-body">
						<ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
							<li class="nav-item">
								<a class="nav-link active" aria-current="page" href="/games">- Games</a>
							</li>
							<li class="nav-item">
								<a class="nav-link active" aria-current="page" href="/games/${game.id}/discussions">- Discussions</a>
							</li>
						</ul>
					</div>
					<div class="offcanvas-footer">
						<ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
							<li class="nav-item">
								<a class="nav-link active text-center" aria-current="page" href="/logout">Logout</a>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</nav>
	</div>
	<br><br>
	<div class="m-1 p-2 container-fluid bg-dark" style="height:100%">
		<div class="container-fluid" style="background-color:beige">
			<table class="table text-center">
				<tbody>
					<tr class="border-bottom border-black">
						<td class="border-end border-black" onClick="handleCellClicked(0)" id="cell-0"></td>
						<td class="border-end border-black" onClick="handleCellClicked(1)" id="cell-1"></td>
						<td onClick="handleCellClicked(2)" id="cell-2"></td>
					</tr>
					<tr class="border-bottom border-black">
						<td class="border-end border-black" onClick="handleCellClicked(3)" id="cell-3"></td>
						<td class="border-end border-black" onClick="handleCellClicked(4)" id="cell-4"></td>
						<td onClick="handleCellClicked(5)" id="cell-5"></td>
					</tr>
					<tr>
						<td class="border-end border-black" onClick="handleCellClicked(6)" id="cell-6"></td>
						<td class="border-end border-black" onClick="handleCellClicked(7)" id="cell-7"></td>
						<td onClick="handleCellClicked(8)" id="cell-8"></td>
					</tr>
				</tbody>
			</table>
			<div class="text-center">
				<c:if test="${match.turn == user.id}">
					<h3 class="text-center">It is your turn!</h3>
				</c:if>	
			</div>
		</div>
	</div>
	<div class="align-content-start" id="userId" style="display:none"><c:out value="${user.id}"/></div>
	<div class="align-content-start" id="turn" style="display:none"><c:out value="${match.turn}"/></div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>