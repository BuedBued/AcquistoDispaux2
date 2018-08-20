<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="be.website.beans.*" %>
<nav class="navbar navbar-default">
  	<div class="container-fluid">
		<%
			if( (BUser) session.getAttribute("user") != null ) {
		%>
		<div class="navbar-header">
      		<a class="navbar-brand" href="/WebSiteSportTimer/profile">Time Record</a>
    	</div>
		<ul class="nav navbar-nav">
			<li><a href="/WebSiteSportTimer/profile">Profil</a></li>
			<li><a href="/WebSiteSportTimer/disconnect">Disconnect</a></li>
		</ul>
		<% 			} 			else { 		%>
		<div class="navbar-header">
      		<a class="navbar-brand" href="/WebSiteSportTimer/home">Time Record</a>
    	</div>
		<%		} 			
		%>
	</div>
</nav>
