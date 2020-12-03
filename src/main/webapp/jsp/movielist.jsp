<!DOCTYPE html>
<%@page import="com.altran.serviceimpl.MovieInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.altran.model.Movie"%>
<%@page import="java.util.List"%>
<html>
<head>
</head>
<body>
<%
MovieInfo movieInfo1=new MovieInfo();
List<Movie> movies1=movieInfo1.getMovie();

%>

	<a href="../jsp/home.jsp" type="button" class="link" >Movies</a>
	<div class="container" id="nowshowing">
		<div class="row">
		<%for (Movie movie1:movies1) { %>
			<div class="col-md-4">
				<div class="card" style="width: 400px">
				
					<a href="../jsp/movieDetails.jsp?movieId=<%=movie1.getMovieId()%>" style="margin-right: 20px">
					<img class="card-img-top"
						src="../Images/img<%= movie1.getPosterImagePath() %>"
						alt="../Images/img"<%= movie1.getPosterImagePath() %> style="width: 100% " ></a>
					<div class="card-body"></div>
				</div>
			</div>
			<%} %>
		</div>

	</div>
</body>
</html>
