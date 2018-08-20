<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="header.jsp" %>
<title>Temps pour ...</title>
</head>
<body>
	<%@ include file="nav.jsp" %>
<div class="container">
  <h2>Temps pour la catégorie ...</h2>
  <br/>          
  <table class="table table-striped">
    <thead>
      <tr>
        <th>Nom</th>
        <th>Prénom</th>
        <th>Temps</th>
        <th>Date</th>
        <th></th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>John</td>
        <td>Doe</td>
        <td>john@example.com</td>
        <td></td>
        <td></td>
      </tr>
      <tr>
        <td>Mary</td>
        <td>Moe</td>
        <td>mary@example.com</td>
        <td></td>
        <td></td>
      </tr>
      <tr>
        <td>July</td>
        <td>Dooley</td>
        <td>july@example.com</td>        
        <td></td>
        <td></td>
      </tr>
    </tbody>
  </table>
  
  <a href="/WebSiteSportTimer/history" class="btn btn-default" role="button">Records personnels</a>	
</div>
	<%@ include file="footer.jsp" %>
</body>
</html>