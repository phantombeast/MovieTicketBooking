<!DOCTYPE html>    
<%@page import="com.altran.serviceimpl.TheaterInfo"%>
<%@page import="com.altran.model.Theater"%>
<%@page import="java.util.List"%>
<html>  
<head>  
</head> 
<style type="text/css">
  	body, html {
	height: 100%;
	}
	td{
	style="color: #34a5eb"
	}

.bg {
	background-image:url("../Images/background.jpg");
		background-repeat:repeat;
}
  </style>
<body class="bg">
<% if(Session.getSessionId()!=2) {
	response.sendRedirect("../jsp/home.jsp");
}%>
<%@ include file="../jsp/topnavbar.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>
<%
	TheaterInfo theaterInfo=new TheaterInfo();
	List<Theater> theaters=theaterInfo.getTheater();
	request.setAttribute("theaters",theaters);
%>

<div class="table-responsive">

<table class="table" style="color: #ebae34">
<tr><th>Theater Name</th><th >Address Line 1</th><th>Address Line 2</th>
<th >City</th><th>State</th><th >Pin Code</th><th>Total Seats</th><th></th><th></th>
</tr>
<c:forEach items="${theaters}" var="t">
<tr style="color: #34a5eb"><td class="text-primary" hidden="true">${t.getTheaterId()}</td>
<td ><h4>${t.getTheaterName()}</h4></td>
<td ><h4>${t.getAddressLine1()}</h4></td>
<td ><h4>${t.getAddressLine2()}</h4></td>
<td ><h4>${t.getCity()}</h4></td>
<td ><h4>${t.getRegion()}</h4></td>
<td ><h4>${t.getPinCode()}</h4></td>
<td ><h4>${t.getTotalSeats()}</h4></td>
<td><a href="../jsp/updatetheater.jsp?theaterId=${t.getTheaterId()}" class="btn btn-primary">Edit</a></td>
<td><a href="../rest/admin/deleteTheater?theaterId=${t.getTheaterId()}" class="btn btn-primary">Delete</a></td>
</tr>
</c:forEach>
</table>
</div>
<div class="btn-group btn-group-medium" align="center">
			<a href="../jsp/addTheater.jsp?msg=0" class="btn btn-primary">Add more</a> 
		</div>
</body>
</html>