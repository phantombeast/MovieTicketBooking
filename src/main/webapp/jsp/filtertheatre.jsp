
<%@page import="java.util.Calendar"%>
<%@page import="java.sql.Date"%>
<%@page import="java.util.List"%>
<%@page import="com.altran.serviceimpl.MovieInfo"%>
<%@page import="com.altran.model.Movie"%>
<%@page import="com.altran.serviceimpl.MovieTimingInfo"%>
<%
	String movieName = request.getParameter("movieName");
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
</head>
<style type="text/css">
.h {
	margin-top: 50px;
}

.col-md-8 {
	margin-top: 10px;
}

.col-md-4 {
	margin-top: 30px;
}

select {
	-webkit-appearance: button;
	-moz-appearance: button;
	-webkit-user-select: none;
	-moz-user-select: none;
	-webkit-padding-end: 20px;
	-moz-padding-end: 20px;
	-webkit-padding-start: 2px;
	-moz-padding-start: 2px;
	background-color: #CD6155;
	box-shadow: 0px 1px 3px rgba(0, 0, 0, 0.1);
	color: #555;
	font-size: inherit;
	margin: 0;
	overflow: hidden;
	padding-top: 2px;
	padding-bottom: 2px;
	text-overflow: ellipsis;
	white-space: nowrap;
}
</style>
<body>
	<%@ include file="../jsp/topnavbar.jsp"%>
	<div class="row">
		<div class="col-md-4">
			<form action="movieCitySearch.jsp" method="post">
				<select name="city" id="styledSelect" class="h">
					<option value="">Please choose your City</option>
					<%
						List<String> city = new MovieTimingInfo().getCity();
						for (String city1 : city) {
					%>
					<option name="city"><%=city1%></option>
					<%
						}
					%>
				</select><br> <br>
				<button type="submit" value="Submit">Search</button>
			</form>
			<form action="movieCitySearch.jsp" method="post">
				<select name="time" class="h">
					<option value="">Please choose your Movie slot</option>
					<%
						List<String> time = new MovieTimingInfo().getTime();
						for (String time1 : time) {
					%>
					<option name="time"><%=time1%></option>
					<%
						}
					%>
				</select><br> <br>
				<button type="submit" value="Submit">Search</button>
			</form>
		</div>
		<div class="col-md-8">
			<%
				Movie movie = new MovieInfo().getMovie(movieName);
				if (movie != null && !movieName.equals("")) {
			%>
			<div class="container" align="left">
				<div class="card text-left">
					<div class="card-body">
						<form action="../jsp/movie.jsp">
							<img class="card-img-top"
								src="../Images/img<%=movie.getSliderImagePath()%>"
								alt="Card image" style="width: 200px; height: 300px"> <br>
							<br>
							<h4 class="card-title">Movie Name</h4>
							<p class="card-text" id="releaseDate"><%=movie.getMovieName()%></p>
							<h4 class="card-title">Release Date</h4>
							<p class="card-text" id="releaseDate"><%=movie.getMovieReleaseDate()%></p>
							<h4 class="card-title">Synopsis</h4>
							<p class="card-text" id="synopsis"><%=movie.getMovieSynopsis()%></p>
							<h4 class="card-title">Duration(in hours)</h4>
							<p class="card-text" id="duration"><%=movie.getMovieDuration()%></p>
							<%
								Date currentDate = new Date(Calendar.getInstance().getTime().getTime());
							%>
							<input type="text" value="<%=movie.getMovieId()%>" hidden="true">
							<label for="date">Date:</label> <input type="date" id="date"
								name="moviedate" min="<%=currentDate%>" required="required"><br>
							<br>
							<%
								if (movie.getMovieReleaseDate().compareTo(currentDate) <= 0) {
							%>
							<input type="submit" value="Book Ticket" class="btn btn-primary">
							<%
								} else {
							%>
							<h2>
								<mark>Coming Soon</mark>
							</h2>
							<%
								}
							%>
						</form>
					</div>
				</div>
			</div>
			<%
				} else {
			%>
			<div class="container" align="left">
				<h3>No Movies found</h3>
			</div>
			<%
				}
			%>
		</div>
	</div>
</body>
</html>