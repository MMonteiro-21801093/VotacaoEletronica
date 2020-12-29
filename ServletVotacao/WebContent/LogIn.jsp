<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log In</title>
</head>
<body>
<h1>Bem vindo ao Sistema de Votação Eletronica(Log In)</h1>
	<form method="post" id="isTitles" name="isTitles" action="Votacao">
	  <label for="fname">Utilizador:</label>
      <input type="text" id="fname" name="uname"><br><br>
     <label for="lname">Password:</label>
     <input type="password" id="lname" name="password"><br><br>
      <input type="submit" value="Submit">
 
	</form>
</body>
</html>