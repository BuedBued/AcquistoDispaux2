<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="be.website.beans.BSport" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="header.jsp" %>
<title>Sports</title>
</head>
<body>
	<%@ include file="nav.jsp" %>
	<div class="container">
		<h2 class="col-sm-offset-1">Liste des sports</h2>
	</div>
	<br/>
	<br/>
	<div class="list-group">
		<%
		ArrayList<BSport> listSport = (ArrayList<BSport>) request.getAttribute("listSport");
		for(BSport b : listSport){
		%>
		<a href="/WebSiteSportTimer/category" class="list-group-item"><%out.print(b.getName()); %> <span class="badge">12</span></a>
		<%}%>
	</div> 
	<br/>
	<%@ include file="footer.jsp" %>
</body>
</html>