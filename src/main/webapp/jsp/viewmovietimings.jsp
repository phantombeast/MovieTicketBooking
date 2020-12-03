<!DOCTYPE html>
<%@page import="com.altran.model.MovieTimings"%>
<%@page import="com.altran.serviceimpl.MovieTimingInfo"%>
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
	background-repeat: no-repeat;
	background-repeat:repeat;
	background-position: center;
	background-size: cover;
}
</style>
<body class="bg">
	<%
		if (Session.getSessionId() != 2) {
			response.sendRedirect("../jsp/home.jsp");
		}
	%>
	<%@ include file="../jsp/topnavbar.jsp"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@page isELIgnored="false"%>
	<%
		MovieInfo movieInfo = new MovieInfo();
		List<MovieTimings> movieTimings = new MovieTimingInfo().getTiming();
	%>

	<div class="table-responsive">
		<table class="table">
			<tr style="color: #9dd3e3">
				<th>Theater Name</th>
				<th>Movie Name</th>
				<th>Show Date</th>
				<th>Show Time</th>
				<th>Ticket Cost</th>
				<th>Total ticket booked</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (MovieTimings movieTime : movieTimings) {
			%>
			<tr style="color: #d9a71e">
				<td><%=new TheaterInfo().getTheaterIndividual(movieTime.getTheatreId()).getTheaterName()%></td>
				<td><%=new MovieInfo().getIndividualMovie(movieTime.getMovieId()).getMovieName()%></td>
				<td><%=movieTime.getMovieDate()%></td>
				<td><%=movieTime.getMovieTiming()%></td>
				<td><%=movieTime.getMovieTicketCost()%></td>
				<td><%=movieTime.getTicketBooked()%></td>
				<td><a
					href="../jsp/updateMovieTimings.jsp?movieTimingsId=<%=movieTime.getMovieTimingId()%>"
					class="btn btn-primary">Edit</a></td>
				<td><a
					href="../rest/movie/deletetime?movieTimingId=<%=movieTime.getMovieTimingId()%>"
					class="btn btn-primary">Delete</a></td>
			</tr>
			<%
				}
			%>
		</table>
	</div>
	<div class="btn-group btn-group-medium" align="center">
		<a href="../jsp/addMovieTimings.jsp?msg=0" class="btn btn-primary">Add
			more</a>
	</div>
</body>
</html>