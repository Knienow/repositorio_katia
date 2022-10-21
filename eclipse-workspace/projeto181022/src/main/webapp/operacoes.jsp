<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Meu primeiro JSP</title>
</head>
<body>
	<%
		float num1 = Float.parseFloat(request.getParameter("vlr1"));
		float num2 = Float.parseFloat(request.getParameter("vlr2"));
		float total = 0f;
		
		String operacao = request.getParameter("btn");
		
			if(operacao.equals("somar"))
				total = num1 + num2;
				else if(operacao.equals("subtrair"))
					total = num1 - num2;
				else if(operacao.equals("multiplicar"))
					total = num1 * num2;
				else if(operacao.equals("dividir"))
					total = num1 / num2;
			out.println("<div class 'resultado'><h2 style = 'color: red'>O resultado da operação é: " + total + "</h2></div>");
	%>
</body>
</html>