<!DOCTYPE html>
<%@page import="com.altran.model.Movie"%>
<%@page import="com.altran.serviceimpl.MovieInfo"%>
<%@page import="com.altran.serviceimpl.TheaterInfo"%>
<%@page import="com.altran.model.Theater"%>
<%@page import="java.util.List"%>
<html>
<head>

</head>
<style type="text/css">
body, html {
	height: 100%;
}

.bg {
	background-image: url("../Images/background.jpg");
	background-repeat: repeat;
	background-position: center;
	background-size: cover;
}
</style>
<body class="bg">
<% if(Session.getSessionId()!=2) {
	response.sendRedirect("../jsp/home.jsp");
}%>
	<%@ include file="../jsp/topnavbar.jsp"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@page isELIgnored="false"%>
	<%
		MovieInfo movieInfo = new MovieInfo();
		List<Movie> movies = movieInfo.getMovie();
		request.setAttribute("movies", movies);
	%>

	<div class="table-responsive">
		<table class="table">
			<tr style="color: #9dd3e3">
				<th>Movie Id</th>
				<th>Movie Name</th>
				<th>Synopsis</th>
				<th>Release Date</th>
				<th>Movie Duration</th>
				<th>Poster Image</th>
				<th>Slider Image</th>
				<th></th>
				<th></th>
			</tr>
			<c:forEach items="${movies}" var="m">
				<tr style="color: #d9a71e">
					<td><h4>${m.getMovieId()}</h4></td>
					<td>${m.getMovieName()}</td>
					<td>${m.getMovieSynopsis()}</td>
					<td>${m.getMovieReleaseDate()}</td>
					<td>${m.getMovieDuration()}</td>
					<td><img src="../Images/img${m.getPosterImagePath()}"
						alt="${m.getPosterImagePath()}" height="100" width="100"></td>
					<td><img src="../Images/img${m.getSliderImagePath()}"
						alt="${m.getSliderImagePath()}" height="50" width="100"></td>
					<td><a href="../jsp/updatemovie.jsp?id=${m.getMovieId()}"
						class="btn btn-primary">Edit</a></td>
					<td><a
						href="../rest/movie/deleteMovie?movieId=${m.getMovieId()}"
						class="btn btn-primary">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div class="btn-group btn-group-medium" align="center">
		<a href="../jsp/addMovie.jsp?msg=0" class="btn btn-primary">Add more</a>
	</div>
</body>
</html>