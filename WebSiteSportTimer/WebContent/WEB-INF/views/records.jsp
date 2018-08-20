<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="be.website.beans.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="header.jsp" %>
<title>Temps pour ...</title>
</head>
<body>
	<%@ include file="nav.jsp" %>
<div class="container">
  <h2>Temps pour la catégorie - <% BCategory currentCategory = (BCategory)request.getAttribute("category"); out.print(currentCategory.getName());%></h2>
  <br/>          
  <table class="table table-striped">
    <thead>
      <tr>
        <th>Nom</th>
        <th>Prénom</th>
        <th>Temps</th>
        <th>Date</th>
      </tr>
    </thead>
    <tbody>
    	<%
    	ArrayList<BRecord> listRecord = (ArrayList<BRecord>) request.getAttribute("listRecord");
		for(BRecord b : listRecord) {
		%>
			<tr>
        	<td><%out.print(b.getUser().getFirstName());%></td>
        	<td><%out.print(b.getUser().getLastName());%></td>
        	<td><%out.print(b.getTime());%></td>
        	<td><%out.print(b.getCreated());%></td>
      	</tr>
		<%}%>
    </tbody>
  </table>
  
  <a href="/WebSiteSportTimer/history" class="btn btn-default" role="button">Records personnels</a>
  <a href="/WebSiteSportTimer/addrecord" class="btn btn-default">Nouveau Record</a>
  	<br/>
	<br/>
</div>
	<%@ include file="footer.jsp" %>
</body>
</html>