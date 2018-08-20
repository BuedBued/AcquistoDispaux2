<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="header.jsp" %>
<title>Profil</title>
</head>
<body>
	<%@ include file="nav.jsp" %>
	<div class="container">
		<h2 class="col-sm-offset-1">Profil</h2>
	</div>
	<br/>
	<br/>
	<form class="form-horizontal" method="post" action="register">
		<div class="form-group">
			<label class="control-label col-sm-2" for="fname">Prénom : </label>
			<div class="col-sm-9">
				<input type="text" class="form-control" id="fname" value="">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="lname">Nom : </label>
			<div class="col-sm-9">
				<input type="text" class="form-control" id="lname" value="">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="login">Login : </label>
			<div class="col-sm-9">
				<input type="text" class="form-control" id="login" value="" disabled="disabled">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="pw">Mot de passe : </label>
			<div class="col-sm-9">
				<input type="text" class="form-control" id="pw" placeholder="Entrez votre nouveau mot de passe">
			</div>
		</div>
		<div class="form-group">
    		<div class="col-sm-offset-2 col-sm-9">
      			<button type="submit" class="btn btn-default">Enregistrer</button>
    		</div>
  		</div>
  		<div class="form-group">
  			<div class="col-sm-offset-2 col-sm-9">
   				<a href="/WebSiteSportTimer/sport" class="btn btn-default" role="button">Retour</a>	
  			</div>
  		</div>
	</form>
	<br/>
	<%@ include file="footer.jsp" %>
</body>
</html>