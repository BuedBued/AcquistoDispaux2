<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="be.website.beans.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="header.jsp" %>
<title>Catégories</title>
</head>
<body>
	<%@ include file="nav.jsp" %>
	<div class="container">
		<h2 class="col-sm-offset-1">Liste des catégories - <% BSport currentSport = (BSport)request.getAttribute("sport"); out.print(currentSport.getName());%></h2>
	</div>
	<br/>
	<br/>
	<div class="list-group">
		<%
		ArrayList<BCategory> listCat = (ArrayList<BCategory>) request.getAttribute("listCat");
		for(BCategory b : listCat){
		%>
		<a href="/WebSiteSportTimer/records?id=<%out.print(b.getId());%>" class="list-group-item"><%out.print(b.getName()); %></a>
		<%}%>
	</div> 
	<br/>
	<a href="/WebSiteSportTimer/addcategory" class="btn btn-default">Nouvelle Catégorie</a>
	<br/>
	<br/>
	<%@ include file="footer.jsp" %>
</body>
</html>