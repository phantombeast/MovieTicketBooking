<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
	<%
		if (Session.getSessionId() == 0) {
			response.sendRedirect("../jsp/home.jsp");
		}
	%>
	<%@include file="../jsp/topnavbar.jsp"%>
	<h4>Registration Successful</h4>
	<h4>
		Welcome
		<%=Session.getUserName()%></h4>
	<%@include file="../jsp/slider.jsp"%>
	<%@include file="../jsp/movielist.jsp"%>
</body>
</html>