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
<title><c:out value="${user.userName}'s Profile"/></title>
</head>
<body class="p-3 m-0">
	<div class="container">
		<nav class="navbar navbar-dark fixed-top bg-dark">
			<div class="container-fluid">
				<h3 class="navbar-brand"><c:out value="${user.userName}'s Profile"/></h3>
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
								<a class="nav-link active" aria-current="page" href="/games">Games</a>
							</li>
							<li class="nav-item">
								<a class="nav-link active" aria-current="page" href="/games/${game.id}/discussions">Discussions</a>
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
	<br> <br>
	<div class="container-fluid border border-black py-3 px-0 bg-dark">
		<div class="col container-fluid text-center m-0">
			<div style="background-color:beige;" class="p-2">
				<div>
					<h3 class="text-start bold ft-2"><c:out value="> Total Wins: ${user.wins}"/></h3>
				</div>
				<div>
					<h3 class="text-start bold ft-2"><c:out value=">> Total Losses: ${user.losses}"/></h3>
				</div>
				<br>
			</div>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>