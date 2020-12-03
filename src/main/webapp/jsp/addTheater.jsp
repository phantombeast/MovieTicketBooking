<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<%
		if (Session.getSessionId() != 2) {
			response.sendRedirect("../jsp/home.jsp");
		}
	%>
	<%@ include file="../jsp/topnavbar.jsp"%>
	<%
		if (request.getParameter("msg").equals("1")) {
	%>
	<h3 align="center">Duplicate Theater Details</h3>
	<%
		}
	%>
	<%@ include file="../html/addtheater.html"%>

</body>
</html>