<!DOCTYPE html>
<%@page import="com.altran.model.Movie"%>
<%@page import="java.util.List"%>
<%@page import="com.altran.serviceimpl.MovieInfo"%>
<html>
<head>
 <link rel="stylesheet" href="../css/styles.css">
<style>

</style>
</head>
<body>
<div style="height:400px;" id="myCarousel" class="carousel slide" data-ride="carousel" >
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
  </ol>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@page isELIgnored="false"%>
	<%
		MovieInfo movieInfo=new MovieInfo();
		List<Movie> movies = movieInfo.getMovie();
		request.setAttribute("movies", movies);
		String[] url=new String[movies.size()];
		int i=0;
		for(Movie movie:movies){
			url[i++]="img"+""+movie.getSliderImagePath();
		}
		int length=movies.size();
	%>

<!-- Wrapper for slides -->
<% if(url.length>=3) {%>
  <div class="carousel-inner">
    <div class="item active">
      <img style="height:400px;width:100%" src="../Images/<%=url[length-1] %>" alt="../Images/${url[0]}">
    </div>
	
    <div class="item">
      <img style="height:400px;width:100%" src="../Images/<%=url[length-2] %>" alt="Chicago">
    </div>

    <div class="item">
      <img style="height:400px;width:100%" src="../Images/<%=url[length-3] %>" alt="New York">
    </div>
  </div> 
  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
    <span class="sr-only">Next</span>
  </a>
</div>	
<%} %>						
</body>
</html>
