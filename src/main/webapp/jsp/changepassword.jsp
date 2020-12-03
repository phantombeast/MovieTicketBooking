<!DOCTYPE html>
<%@page import="com.altran.model.Session"%>
<html lang="en">
<head>
<script type='text/javascript' src='http://code.jquery.com/jquery.min.js'></script>
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
	width: 100%;
	margin: 0;
	padding: 0;
	text-align: center;
	color: #636363;
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
<%
 	if(Session.getSessionId()==0){
 		response.sendRedirect("../jsp/index.jsp");
 	}
	String username=Session.getUserName();
%>
</head>

<body>
	<%@ include file="../jsp/topnavbar.jsp"%>
	<div class="signup-form">
		<form action="../rest/register/changepassword" method="post">
			<h2>Reset Password</h2>
			<p class="hint-text">You can reset your password here</p>
			<div class="form-group">
				<input type="text" hidden="true" class="form-control"
					name="userName" value="<%=username%>">
			</div>
			<div class="form-group">
				<input type="password" class="form-control" name="oldPassword"
					placeholder="Enter old password" required>
			</div>
			<div class="form-group">
				<input type="password" class="form-control" name="newPassword" id="pass1"
				pattern="^(?=.*\d).{4,8}$"
					title="Password must be between 4 and 8 digits long and include at least one numeric digit."
					placeholder="Enter new Password" required>
			</div>
			<div class="form-group">
				<input type="password" class="form-control" name="confirmPassword" id="pass2"
				pattern="^(?=.*\d).{4,8}$"
					title="Password must be between 4 and 8 digits long and include at least one numeric digit."
					placeholder="Confirm Password" required><span id='message'></span>
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-success btn-lg btn-block" disabled='disabled' id="btn">Reset
					Password</button>
			</div>
		</form>

	</div>
<script>
$('#pass1, #pass2').on('keyup', function () {
    if ($('#pass1').val() == $('#pass2').val()) {
        $('#message').html('Password  Matched').css('color', 'green');
        $('#btn').prop('disabled', false);
    } else {
        $('#message').html('Password and Confirm Password are not same').css('color', 'red');
        $('#btn').prop('disabled', true);    
    }
});
	
</script>		
</body>
</html>