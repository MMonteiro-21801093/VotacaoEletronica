<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu Votante</title>
</head>
<body>
<h1>Bem vindo ao Sistema de Vota��o Eletronica(Menu Votante)</h1>
	<form method="post"   action="OpcoesVotante">
      <input type="submit" name="action" value="listar itens em vota��o">
      <input type="submit" name="action" value="listar resultados de vota��o (%)">
         <input type="submit" name="action" value="Log In">
     <p>${resultado}.</p>
	</form>
</body>
</html>