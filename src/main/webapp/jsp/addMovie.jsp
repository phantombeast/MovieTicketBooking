<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
<%
if(Session.getSessionId()!=2){
	response.sendRedirect("../jsp/home.jsp");
}
%>
<%@ include file="../jsp/topnavbar.jsp" %>
<%String msg=request.getParameter("msg");
if(msg.equals("1")) {%>
<h3 align="center">Duplicate Movie Details</h3><%} %>
<%@ include file="../html/newMovie.html" %>
</body>
</html>