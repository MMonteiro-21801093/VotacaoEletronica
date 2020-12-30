<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu Administrador</title>
</head>
<body>
<h1>Bem vindo ao Sistema de Votação Eletronica(Menu Admin)</h1>
	<form method="post"   action="OpcoesAdmin">
      <input type="submit" name="action" value="listar itens em votação">
      <input type="submit" name="action" value="listar resultados de votação (%)">
      <input type="submit" name="action" value="listar utilizadores registados">
       <input type="submit" name="action" value="Log In">
     <p>${resultado}.<br></p>
	</form>
</body>
</html>