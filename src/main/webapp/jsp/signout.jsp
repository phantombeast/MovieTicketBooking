<%@page import="com.altran.model.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
<%
Session.setSessionId(0);
Session.setUserName(null);
response.sendRedirect("../jsp/home.jsp");
%>

</body>
</html>