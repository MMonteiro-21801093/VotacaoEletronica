<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu Administrador</title>
</head>
<body>
<h1>Bem vindo ao Sistema de Vota��o Eletronica</h1>
	<form method="post"   action="Opcoes">
      <input type="submit" name="action" value="listar itens em vota��o">
      <input type="submit" name="action" value="listar resultados de vota��o (%)">
       <input type="submit" name="action" value="Log In">
     <p>${resultado}.<br></p>
	</form>
</body>
</html>