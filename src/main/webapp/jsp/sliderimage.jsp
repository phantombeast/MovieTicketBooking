<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

</head>
<body>
	<% if(Session.getSessionId()!=2){
	response.sendRedirect("../jsp/home.jsp");	
}
	%>
	<%@include file="../jsp/topnavbar.jsp"%>
	<%@include file="../html/addSlider.html"%>
</body>
</html>