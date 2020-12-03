<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movie Ticket Booking</title>
</head>
<body>

	<%@include file="../jsp/topnavbar.jsp"%>
	<center>
		<%
			String message = request.getParameter("message");
			if (message.equals("1")) {
		%>
		<h4>Duplicate User Name</h4>
		<h4>Please enter other user name</h4>
		<%
			} else if (message.equals("2")) {
		%>
		<h3>Duplicate Email Id</h3>
		<h3>Please try with other Email id</h3>
		<%
			} else {
		%>
		<h3>Duplicate Contact Number</h3>
		<h3>Please try with other Contact Number</h3>
		<%
			}
		%>
	</center>
	<%@include file="../html/register.html"%>
</body>
</html>
