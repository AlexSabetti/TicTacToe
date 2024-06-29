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
<title><c:out value="${game.name}"/></title>
</head>
<body class="p-3 m-0">
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
								<a class="nav-link active" aria-current="page" href="/games">Games</a>
							</li>
							<li class="nav-item">
								<a class="nav-link active" aria-current="page" href="/games/${game.id}/discussions">Discussions</a>
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
			<div style="background-color:beige;">
				<h3 class="text-center">Open Matches</h3>
				<table class="container-sm">
					<thead>
						<tr>
							<th scope="col" class="text-start">Challenger</th>
							<th scope="col" class="text-start">Challenger's Wins</th>
							<th scope="col" class="text-center">Join?</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="match" items="${matches}">
							<c:if test="${match.challengee == null && match.challenger.id != user.id}">
								<tr>
									<td class="text-center">${match.challenger.userName}</td>
									<td class="text-center">${match.challenger.wins}</td>
									<td class="text-center"><a href="/games/${match.game.id}/home/matches/${match.id}/join">Yes</a>
								</tr>
							</c:if>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<br>
			<div style="background-color:beige">
				<h2 class="text-center">Your Matches</h2>
				<table class="container-sm">
					<thead>
						<tr>
							<th scope="col" class="text-center">Other Player</th>
							<th scope="col" class="text-center">Turn Counter</th>
							<th scope="col" class="text-center">Started:</th>
							<th scope="col" class="text-center">Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="match" items="${matches}">
							<c:if test="${match.challengee.id == user.id || match.challenger.id == user.id}">
								<tr>
									<c:if test="${match.challenger.id == user.id}">
										<c:if test="${match.challengee == null}">
											<td class="text-center">N/A</td>
											<td class="text-center">N/A</td>
										</c:if>
										<c:if test="${match.challengee != null}">
											<td class="text-center">${match.challengee.userName}</td>
											<td class="text-center">${match.turnCounter}</td>
										</c:if>
									</c:if>
									<c:if test="${match.challengee.id == user.id}">
										<td class="text-center">${match.challenger.userName}</td>
										<td class="text-center">${match.turnCounter}</td>
									</c:if>
									<td><c:out value="${match.createdAt}"/></td>
									<c:if test="${match.challengee == null}">
										<td class="text-center"><span><a href="/games/${match.game.id}/home/matches/${match.id}/delete">Cancel</a> | <a href="/games/${match.game.id}/home/matches/${match.id}?userId=${user.id}">View</a></span>
									</c:if>
									<c:if test="${match.challengee != null}">
										<td class="text-center"><span><a href="/games/${match.game.id}/home/matches/${match.id}/forfeit">Forfeit</a> | <a href="/games/${match.game.id}/home/matches/${match.id}?userId=${user.id}">View</a></span>
									</c:if>
									
								</tr>
							</c:if>  
						</c:forEach>
					</tbody>
				</table>
			</div>
			<br> <br> <br>
			<div style="background-color:beige" class="container-sm text-center">
				<form:form action="/games/${game.id}/home/matches/new" method="post" modelAttribute="newMatch">
					<input type="submit" value="Start a Match"/>
				</form:form>
			</div>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>