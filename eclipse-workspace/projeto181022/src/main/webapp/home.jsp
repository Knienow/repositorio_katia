<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Meu Primeiro JSP</title>
</head>
<body>
	<%
		String nome = "Katia";
		out.println(nome);
	%>
	<h1 style = "color: red"> 18 de outubro de 2022</h1>
	<form action="operacoes.jsp" method="post" name="calc">
		<input type="text" name="vlr1">
		<input type="text" name="vlr2">
		<br><br>
		<input type="submit" value="somar" name="btn">
		<input type="submit" value="subtrair" name="btn">
		<input type="submit" value="multiplicar" name="btn">
		<input type="submit" value="dividir" name="btn">
	</form>
	<br><br>
	<form action="imprime.jsp" method="post" name="cad">
		Nome: <input type="text" name="nome">
		Endereço: <input type="text" name="end">
		Celular: <input type="text" name="cel">
		Idade: <input type="text" name="idade">
		
		<br><br>
		<input type="reset" value="limpar" name="btn">
		<input type="submit" value="cadastrar" name="btn">
	</form>	    
</body>
</html>