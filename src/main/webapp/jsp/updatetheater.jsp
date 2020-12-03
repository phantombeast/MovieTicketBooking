<!DOCTYPE html>
<%@page import="com.altran.serviceimpl.TheaterInfo"%>
<%@page import="com.altran.model.Theater"%>
<html>
<head>
<style type="text/css">
body {
	color: #fff;
	background: #63738a;
	background-image: url("../Images/background.jpg");
	background-repeat: no-repeat;
	background-size: font-family: 'Roboto', sans-serif;
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
<% if(Session.getSessionId()!=2) {
	response.sendRedirect("../jsp/home.jsp");
}%>
<%@ include file="../jsp/topnavbar.jsp" %>
<% Theater theater=new TheaterInfo().getTheaterIndividual(request.getParameter("theaterId")); %>
<body style="background-image: url('../Images/background.jpg');">
	<div class="signup-form">
		<form action="../rest/admin/updateTheater" method="post">
			<h2>Theatre</h2>
			<p class="hint-text">Update Theater Details Here</p>

			<div class="form-group">
			<input type="text" hidden="true" name="theaterId" value="<%=theater.getTheaterId()%>">
				<input type="text" class="form-control" name="theaterName"
					id="theatreName" placeholder="Enter Theatre Name"
					required="required" value="<%=theater.getTheaterName()%>">
			</div>

			<div class="form-group">
				<input type="text" class="form-control" name="totalSeats"
					placeholder="Enter Theatre Capacity" required="required" pattern="^[0-9]+$" title="Enter number only" value="<%=theater.getTotalSeats() %>" >
			</div>

			<div class="form-group">
				<input type="text" class="form-control" id="address-line1"
					name="addressLine1" placeholder="Address Line 1"
					required="required" value="<%=theater.getAddressLine1()%>">
			</div>

			<div class="form-group">
				<input type="text" class="form-control" id="address-line2"
					name="addressLine2" placeholder="Address Line 2"
					 value="<%=theater.getAddressLine2()%>">
			</div>

			<div class="form-group">
				<input type="text" class="form-control" id="city" name="city"
					placeholder="City" required="required" value="<%=theater.getCity()%>">
			</div>

			<div class="form-group">
				<input type="text" class="form-control" id="region" name="region"
					placeholder="state / province / region" required="required" value="<%=theater.getRegion()%>">
			</div>

			<div class="form-group">
				<input type="text" class="form-control" id="postal-code"
					name="postalCode" placeholder="Postal Code" required="required" pattern="^[1-9][0-9]{5}$" title="Postal code should contain number only and should be of 6 digits" value="<%=theater.getPinCode()%>">
			</div>

			<div class="form-row-last">
				<input type="submit" name="register"
					class="btn btn-success btn-lg btn-block" value="Update Theaters">
			</div>
		</form>
	</div>
</body>
</html>