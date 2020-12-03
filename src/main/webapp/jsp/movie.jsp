<!DOCTYPE html>
<%@page import="java.sql.Date"%>
<%@page import="com.altran.model.MovieTimings"%>
<%@page import="com.altran.serviceimpl.MovieTimingInfo"%>
<%@page import="com.altran.serviceimpl.MovieInfo"%>
<%@page import="com.altran.serviceimpl.TheaterInfo"%>
<%@page import="com.altran.model.Theater"%>
<%@page import="java.util.List"%>
<html lang="en">
<head>
</head>
<style>
.col-md-8 {
   
    column-gap: 20px;
    justify-content: space-between;
}

</style>
<%
if(Session.getSessionId()==0){
	response.sendRedirect("../jsp/login.jsp");
}
String movieId=request.getParameter("movieId");
String date=request.getParameter("moviedate");
List<Theater> theaters=new TheaterInfo().getTheaterList(movieId, date);
%>
<body>
<%@include file="../jsp/topnavbar.jsp" %> 
 <div class="container">
 <h3>Date : <%=date%></h3>
<%
	for(Theater theater:theaters){
%>
	<div class="row">
	<hr>
	<div class="col-md-4">
	<p id="theatreName"><%=theater.getTheaterName()%></p>
	<p id="theatreAddress"><%=theater.getAddressLine1()+" "+theater.getAddressLine2()+
	","+theater.getCity()+","+theater.getRegion()%></p>
	</div>
  <div class="col-md-8">
  <h6>Show Timings </h6>
  <%
  	List<MovieTimings> timings=new MovieTimingInfo().getTiming(theater.getTheaterId(),date);
    for(MovieTimings movieTimings:timings){
  %>
  <a href="../jsp/bookmovie.jsp?movieTimeId=<%=movieTimings.getMovieTimingId()%>&message=0" type="button" class="btn btn-primary" data-toggle="tooltip" data-placement="top"
   title="Rs <%=movieTimings.getMovieTicketCost()%>" style="background-color: ">
<%=movieTimings.getMovieTiming() %>
</a>
<%} %>

  </div>
</div>
<%} %>
 </div>
</body>
</html>