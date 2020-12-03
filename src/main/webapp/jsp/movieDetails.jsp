<!DOCTYPE html>
<%@page import="java.util.Calendar"%>
<%@page import="org.codehaus.jackson.map.ser.StdSerializers.UtilDateSerializer"%>
<%@page import="java.sql.Date"%>
<%@page import="com.altran.serviceimpl.MovieInfo"%>
<%@page import="com.altran.model.Movie"%>
<html lang="en">
<head>
<title>MovieFlix</title>
<!-- <meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1"> -->
</head>
<body>

	<%
		String movieId = request.getParameter("movieId");
		Movie movie = new MovieInfo().getIndividualMovie(movieId);
	%>
	<%@include file="../jsp/topnavbar.jsp" %> 
	<div class="container">
		<div class="card text-center">
			<div class="card-header"><%=movie.getMovieName()%></div>
			<div class="card-body">
			<form action="../jsp/movie.jsp?movieId=<%=movieId%>">
				<img class="card-img-top"
					src="../Images/img<%=movie.getSliderImagePath()%>"
					alt="Card image" style="width: 200px; height: 300px"> <br>
				<br>
				<h3 class="card-title">Release Date</h3>
				<p class="card-text" id="releaseDate"><%=movie.getMovieReleaseDate()%></p>
				<h3 class="card-title">Synopsis</h3>
				<p class="card-text" id="synopsis"><%=movie.getMovieSynopsis()%></p>
				<h3 class="card-title">Duration(in hours)</h3>
				<p class="card-text" id="duration"><%=movie.getMovieDuration()%></p>
				<%Date currentDate=new Date(Calendar.getInstance().getTime().getTime()); %>
					<label for="date">Date:</label> <input type="date"
						id="date" name="moviedate" min="<%=currentDate %>" required="required"><br><br>
						<input type="text" name="movieId" value="<%=movieId %>" hidden="true">
						<%
							if(movie.getMovieReleaseDate().compareTo(currentDate)<=0) {
						%>
						<input type="submit" value="Book Ticket" class="btn btn-primary" >
						<%} else { %>
						<h2 ><mark>Coming Soon</mark></h2>
						<%}%>
				</form>
			</div>
		</div>
	</div>
</body>
</html>