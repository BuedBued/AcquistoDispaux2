<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList" %>
<%@ page import="be.website.beans.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="header.jsp" %>
<title>Historique</title>
</head>
<body>
	<%@ include file="nav.jsp" %>
<div class="container">
  <h2>Records personnels de USER</h2>
  <br/>          
  <table class="table table-striped">
    <thead>
      <tr>
        <th>Sport</th>
        <th>Catégorie</th>
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
        	<td><%out.print(b.getCategory().getSport().getName());%></td>
        	<td><%out.print(b.getUser().getLastName());%></td>
        	<td><%out.print(b.getTime());%></td>
        	<td><%out.print(b.getCreated());%></td>
      	</tr>
		<%}%>
    </tbody>
  </table>
</div>
	<%@ include file="footer.jsp" %>
</body>
</html>