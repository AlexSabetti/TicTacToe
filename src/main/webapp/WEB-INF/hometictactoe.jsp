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
<body>
	<div class="container-lg border border-black" style="display:flex; background-color:lightgrey">
		<div class="col container-md text-center" style="display:flex; flex-direction:column">
			<h1 style="text-style:italic"><c:out value="${game.name}"/></h1>
			<br> <br> <br>
			<div style="background-color:beige; display:flex; flex-direction:column" class="container-sm">
				<h2 class="text-center">Open Matches</h2>
				<table class="align-text-center">
					<thead>
						<tr>
							<th scope="col" class="text-center">Challenger</th>
							<th scope="col" class="text-center">Challenger's Wins</th>
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
			<br> <br> <br>
			<div>
			
			</div>
			<br><br><br>
			<div style="background-color:beige" class="container-sm text-center">
				<h2 class="text-center">Your Matches</h2>
				<table class="align-center">
					<thead>
						<tr>
							<th scope="col" class="text-center">Other Player</th>
							<th scope="col" class="text-center">Turn Counter</th>
							<th scope="col" class="text-center">Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="match" items="${matches}">
							<c:if test="${match.challengee.id == user.id || match.challenger.id == user.id && match.challengee != null}">
								<tr>
									<c:if test="${match.challenger.id == user.id}">
									
										<td class="text-center">${match.challengee.userName}</td>
									</c:if>
									<c:if test="${match.challengee.id == user.id}">
										<td class="text-center">${match.challenger.userName}</td>
									</c:if>
									<td class="text-center">${match.turnCounter}</td>
									<td class="text-center"><a href="/games/${match.game.id}/home/matches/${match.id}">View</a>
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