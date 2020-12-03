<%@page import="java.util.ArrayList"%>
<%@page import="com.altran.serviceimpl.MovieInfo"%>
<%@page import="com.altran.model.Movie"%>
<%@page import="com.altran.daoimpl.MovieTimingsDataInfo"%>
<%@page import="com.altran.serviceimpl.MovieTimingInfo"%>
<%@page import="java.util.List"%>
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
	margin-top: 50px;
}

.col-md-4 {
	margin-top: 40px;
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
	/* Fallback color if gradients are not supported */
	background-image: url(../images/select-arrow.png),
		-webkit-linear-gradient(top, #E5E5E5, #F4F4F4);
	background-image: url(../images/select-arrow.png),
		-moz-linear-gradient(top, #E5E5E5, #F4F4F4);
	background-image: url(../images/select-arrow.png),
		-ms-linear-gradient(top, #E5E5E5, #F4F4F4);
	background-image: url(../images/select-arrow.png),
		-o-linear-gradient(top, #E5E5E5, #F4F4F4);
	background-image: url(../images/select-arrow.png),
		linear-gradient(to bottom, #E5E5E5, #F4F4F4);
	background-position: center right;
	background-repeat: no-repeat;
	border: 1px solid #AAA;
	border-radius: 2px;
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
	<%@include file="../jsp/topnavbar.jsp"%>
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
		<div class="col-md-8" style="width: 10px">

			<div class="row">
				<%
					String cityName = request.getParameter("city");
					String movieTime = request.getParameter("time");
					List<Movie> movies = new ArrayList<>();
					if (cityName != null) {
						movies = new MovieInfo().getMovieByCity(cityName);
					} else {
						movies = new MovieInfo().getMovieByTime(movieTime);
					}
				%>
				<div class="container" id="nowshowing">
					<div class="row">
						<%
							for (Movie movie1 : movies) {
						%>
						<div class="col-md-4">
							<div class="card">

								<a
									href="../jsp/movieDetails.jsp?movieId=<%=movie1.getMovieId()%>"><img
									class="card-img-top"
									src="../Images/img<%=movie1.getPosterImagePath()%>"
									alt="../Images/img" <%=movie1.getPosterImagePath()%>
									style="width: 70%"></a>
							</div>
						</div>
						<%
							}
						%>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>