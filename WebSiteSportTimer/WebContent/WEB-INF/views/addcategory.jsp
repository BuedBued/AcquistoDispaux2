<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="header.jsp" %>
<title>Ajout d'une catégorie pour ...</title>
</head>
<body>
	<%@ include file="nav.jsp" %>
	<div class="container">
		<h2 class="col-sm-offset-1">Formulaire d'ajout d'une catégorie</h2>
	</div>
	<br/>
	<br/>
	<form class="form-horizontal" method="post" action="category">
		<div class="form-group">
			<label class="control-label col-sm-2" for="name">Nom : </label>
			<div class="col-sm-9">
				<input type="text" class="form-control" id="name" placeholder="Entrez votre prénom">
			</div>
		</div>
		<div class="form-group">
    		<div class="col-sm-offset-2 col-sm-9">
      			<button type="submit" class="btn btn-default">Enregistrer</button>
    		</div>
  		</div>
  		<div class="form-group">
  			<div class="col-sm-offset-2 col-sm-9">
   				<a href="/WebSiteSportTimer/category" class="btn btn-default" role="button">Retour</a>	
  			</div>
  		</div>
	</form>
	<br/>
	<%@ include file="footer.jsp" %>
</body>
</html>