<!DOCTYPE html>
<%@page import="com.altran.model.Session"%>
<html lang="en">
<head>
<title>MovieFlix</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="../jsp/home.jsp">MovieFlix</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="../jsp/home.jsp">Home</a></li>
				<%
					if (Session.getSessionId() == 2) {
				%>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Theater<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="../jsp/addTheater.jsp?msg=0">Add Theater</a></li>
						<li><a href="../jsp/viewtheater.jsp">Manage Theater</a></li>
					</ul></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Movies<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="../jsp/addMovie.jsp?msg=0">Add Movies</a></li>
						<li><a href="../jsp/addMovieTimings.jsp?msg=0">Add Movie
								Timings</a></li>
						<li><a href="../jsp/viewmovies.jsp">Manage Movies</a></li>
						<li><a href="../jsp/viewmovietimings.jsp">Manage Movie
								Timings</a></li>
					</ul></li>
				<%
					}
				%>
				<li>
					<form action="../jsp/filtertheatre.jsp"
						style="width: 350px; margin-left: 20px; margin-top: 8px;">
						<div class="input-group">
							<input type="text" class="form-control" placeholder="Search"
								name="movieName" style="height: 34px"
								maxlength="140" min="3">
							<div class="input-group-btn">
								<button class="btn btn-default" type="submit"
									style="height: 34px">
									<i class="glyphicon glyphicon-search"></i>
								</button>
							</div>
						</div>
					</form>
				</li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<%
					if (Session.getSessionId() == 0) {
				%>
				<li><a href="../jsp/signup.jsp"><span
						class="glyphicon glyphicon-user"></span> Sign Up</a></li>
				<li><a href="../jsp/login.jsp"><span
						class="glyphicon glyphicon-log-in"></span> Login</a></li>
			</ul>
			<%
				} else if (Session.getSessionId() == 1) {
					String userName = Session.getUserName();
			%>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"><%=userName%> <span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="../jsp/signout.jsp">Signout</a></li>
						<li><a href="../jsp/changepassword.jsp">Change Password</a></li>
					</ul></li>
			</ul>
			<%
				} else {
			%>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"><%=Session.getUserName()%> <span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="../jsp/signout.jsp">Signout</a></li>
					</ul></li>
			</ul>
			<%} %>
		</div>
	</nav>
</body>
</html>
