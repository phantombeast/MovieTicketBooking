<!DOCTYPE html>
<%@page import="com.altran.serviceimpl.MovieTimingInfo"%>
<%@page import="com.altran.model.MovieTimings"%>
<%@page import="com.altran.serviceimpl.MovieInfo"%>
<%@page import="com.altran.model.Movie"%>
<html lang="en">
<head>
<title>MovieFlix</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
</head>
<%
	if (Session.getSessionId() == 0) {
		response.sendRedirect("../jsp/home.jsp");
	}
int message = Integer.parseInt(request.getParameter("message"));
%>
<body>
	<%@include file="../jsp/topnavbar.jsp"%>
	<%
		String movieTimeId = request.getParameter("movieTimeId");
		MovieTimings movieTimings = new MovieTimingInfo().getMovieTimings(Integer.parseInt(movieTimeId));
		Movie movie = new MovieInfo().getIndividualMovie(movieTimings.getMovieId());
	%>
	<div class="container">
		<div class="card text-center">
			<%
				if (message == 1) {
			%>
			<h3>Your request can not be completed as number of tickets
				exceeds the availability</h3>
			<%
				}
			%>
			<div class="card-body">
				<img class="card-img-top"
					src="../Images/img<%=movie.getSliderImagePath()%>" alt="Card image"
					style="width: 200px; height: 300px"> <br> <br>
				<form action="../rest/movie/bookticket">
					<h5 class="card-title">Date</h5>
					<p class="card-text"><%=movieTimings.getMovieDate()%>
					<h5 class="card-title">Time</h5>
					<p class="card-text"><%=movieTimings.getMovieTiming()%>
					<h5 class="card-title">Duration(in hours)</h5>
					<p class="card-text" id="movietime"><%=movie.getMovieDuration()%></p>
					<input type="number" name="movieTimeId" value="<%=movieTimeId%>"
						hidden="true"> <input type="number" min="1" id="seats"
						class="input-text" placeholder="Enter Total Seats" name="quantity"
						title="Qty" size="4" pattern="[0-9]*" required="required"><br> <br>
					<input type="submit" class="btn btn-primary" value="Book Tickets">
				</form>
			</div>
		</div>
	</div>
</body>
</html>