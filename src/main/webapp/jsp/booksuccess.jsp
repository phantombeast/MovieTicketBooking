<!DOCTYPE html>
<%@page import="com.altran.serviceimpl.MovieTimingInfo"%>
<%@page import="com.altran.model.MovieTimings"%>
<%@page import="com.altran.serviceimpl.TheaterInfo"%>
<%@page import="com.altran.model.Theater"%>
<%@page import="com.altran.serviceimpl.MovieInfo"%>
<%@page import="com.altran.model.Movie"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<%@include file="../jsp/topnavbar.jsp" %>
	<%
		String movieTimeId = request.getParameter("movieTimeId");
		String cost = request.getParameter("cost");
		MovieTimings movieTimings = new MovieTimingInfo().getMovieTimings(Integer.parseInt(movieTimeId));
		Movie movie = new MovieInfo().getIndividualMovie(movieTimings.getMovieId());
		Theater theater = new TheaterInfo().getTheaterIndividual(movieTimings.getTheatreId());
	%>
	<div class="container">
		<div class="card text-center">
			<div class="card-body">
				<img class="card-img-top"
					src="../Images/img<%=movie.getSliderImagePath()%>"
					alt="Card image" style="width: 200px; height: 300px"> <br>
				<br>
				<p class="card-text">Congratulations..... Your Ticket has been
					booked</p>
					<h3 class="card-title">Date</h3>
				<p class="card-text"><%=movieTimings.getMovieDate()%></p>
				<h3 class="card-title">Time</h3>
				<p class="card-text"><%=movieTimings.getMovieTiming()%></p>
				<h3 class="card-title">Duration(in hours)</h3>
				<p class="card-text" id="movietime"><%=movie.getMovieDuration()%></p>
				<h3 class="card-title">Total Cost</h3>
				<p class="card-text"><%=cost%></p>
				<h3 class="card-title">Theater Details</h3>
				<p class="card-text"><%=theater.getTheaterName()%>
					<br>
					<%=theater.getAddressLine1() + " " + theater.getAddressLine2() + " " + theater.getCity() + " "
					+ theater.getRegion()%></p>
			</div>
		</div>
	</div>
</body>
</html>