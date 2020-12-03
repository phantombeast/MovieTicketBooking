<!DOCTYPE html>
<%@page import="com.altran.model.MovieTimings"%>
<%@page import="com.altran.serviceimpl.MovieTimingInfo"%>
<%@page import="java.util.List"%>
<html lang="en">
<head>
<style type="text/css">
body {
	color: #fff;
	background: #63738a;
	background-image: url("../Images/background.jpg");
	background-repeat: no-repeat;
	font-family: 'Roboto', sans-serif;
	background-repeat: no-repeat;
}

.form-control {
	height: 40px;
	box-shadow: none;
	color: #969fa4;
}

.form-control:focus {
	border-color: #5cb85c;
}

.form-control, .btn {
	border-radius: 3px;
}

.signup-form {
	width: 400px;
	margin: 0 auto;
	padding: 30px 0;
}

.signup-form h2 {
	color: #636363;
	margin: 0 0 15px;
	position: relative;
	text-align: center;
}

.signup-form h2:before, .signup-form h2:after {
	content: "";
	height: 2px;
	width: 30%;
	background: #d4d4d4;
	position: absolute;
	top: 50%;
	z-index: 2;
}

.signup-form h2:before {
	left: 0;
}

.signup-form h2:after {
	right: 0;
}

.signup-form .hint-text {
	color: #999;
	margin-bottom: 30px;
	text-align: center;
}

.signup-form form {
	color: #999;
	border-radius: 3px;
	margin-bottom: 15px;
	background: #f2f3f7;
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	padding: 30px;
}

.signup-form .form-group {
	margin-bottom: 20px;
}

.signup-form input[type="checkbox"] {
	margin-top: 3px;
}

.signup-form .btn {
	font-size: 16px;
	font-weight: bold;
	min-width: 140px;
	outline: none !important;
}

.signup-form .row div:first-child {
	padding-right: 10px;
}

.signup-form .row div:last-child {
	padding-left: 10px;
}

.signup-form a {
	color: #fff;
	text-decoration: underline;
}

.signup-form a:hover {
	text-decoration: none;
}

.signup-form form a {
	color: #5cb85c;
	text-decoration: none;
}

.signup-form form a:hover {
	text-decoration: underline;
}
</style>
</head>
<body>
	<%
		if (Session.getSessionId() != 2) {
			response.sendRedirect("../jsp/home.jsp");
		}
		MovieTimings movieTimings = new MovieTimingInfo()
				.getMovieTimings(Integer.parseInt(request.getParameter("movieTimingsId")));
	%>
	<%@ include file="../jsp/topnavbar.jsp"%>
	<div class="signup-form">
		<form action="../rest/movie/updatetime" method="get">
			<h2>Movie</h2>
			<p class="hint-text">Add Movie Timings Here!!!</p>
			<div class="form-group">
				<select name="theatreId" class="form-control ">

					<option selected="selected"><%=movieTimings.getTheatreId()%></option>
					<%
						List<String> theatreId = new MovieTimingInfo().getTheatreId();
						for (String thId : theatreId) {
					%>
					<option class="form-control"><%=thId%></option>
					<%
						}
					%>
				</select> <br>
			</div>
			<div class="form-group">
				<select name="movieId" class="form-control">
					<option selected="selected"><%=movieTimings.getMovieId()%></option>
					<%
						List<String> movieId = new MovieTimingInfo().getMovieId();
						for (String movId : movieId) {
					%>
					<option><%=movId%></option>
					<%
						}
					%>
				</select> <br>
			</div>
			<div class="form-group">
				<input type="text" name="movieDate" placeholder="Moviedate"
					onfocus="(this.type='date')" class="form-control"
					value="<%=movieTimings.getMovieDate()%>" required="required">
			</div>
			<div class="form-group">
				<input type="text" name="movieTime" placeholder="MovieTime"
					onfocus="(this.type='time')" class="form-control"
					value="<%=movieTimings.getMovieTiming()%>">
			</div>
			<div class="form-group">
				<input type="number" step="0.01" name="ticketCost"
					placeholder="TicketCost" class="form-control"
					value="<%=movieTimings.getMovieTicketCost()%>" min="0">
			</div>
			<div class="form-group">
				<input type="number" step="1" name="ticketBooked"
					placeholder="Total Ticket Booked" class="form-control"
					value="<%=movieTimings.getTicketBooked()%>" min="0">
			</div>
			<input type="text" hidden="true"
				value="<%=movieTimings.getMovieTimingId()%>" name="movieTimingId">
			<div class="form-group">
				<button type="submit" class="btn btn-success btn-lg btn-block">Update
					Details</button>
			</div>
		</form>
	</div>
</body>
</html>
