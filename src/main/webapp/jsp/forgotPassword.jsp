<!DOCTYPE html>
<html lang="en">
<head>
<style type="text/css">
body {
	color: #fff;
	background-image: url("../Images/background.jpg");
	background-repeat: no-repeat;
	font-family: 'Roboto', sans-serif;
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
	width: 500px;
	margin: 0 auto;
	padding: 30px 0;
}

.signup-form h2 {
	color: #636363;
	margin: 0 0 15px;
	position: relative;
	text-align: center;
}

.signup-form h2:after {
	display: inline-block;
	margin: 0 0 8px 20px;
	height: 3px;
	content: " ";
	text-shadow: none;
	background-color: #999;
	width: 85px;
}

.signup-form h2:before {
	display: inline-block;
	margin: 0 20px 8px 0;
	height: 3px;
	content: " ";
	text-shadow: none;
	background-color: #999;
	width: 85px;
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
</style>
</head>
<%
	int message = Integer.parseInt(request.getParameter("message"));
%>
<body>
	<%@include file="../jsp/topnavbar.jsp"%>
	<div class="signup-form">
		<form action="../rest/register/resetPassword" method="post">
			<%
				if (message == 1) {
			%>
			<h4>You have Entered wrong email id or password, Please enter
				the correct one</h4>
			<%
				}
			%>
			<h2>Forgot Password</h2>
			<p class="hint-text">You can reset your password here</p>
			<div class="form-group">
				<input type="text" class="form-control" name="email"
					placeholder="Enter your email" required="required">
			</div>
			<div class="form-group">
				<input type="text" class="form-control" name="contactNumber"
					placeholder="Enter your registered contact number"
					required="required" pattern="[0-9]{10}"
					title="Contact number should contain digits only and should be of 10 in length">
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-success btn-lg btn-block">Reset
					Password</button>
			</div>

		</form>

	</div>
</body>
</html>
