<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GutGekleidetWurst</title>
<link href="css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<h1 align="center">Bienvenidos a GutGekleidetWurst</h1>
<h2 align="center">Bienvenido: <%=session.getAttribute("usuario") %></h2>
<div style="padding-top: 10px;" align="center">
<a href="pedidos.jsp"><input type="button" value="Realizar un pedido"></a>
<a href="pendientes.jsp"><input type="button" value="Pedidos Pendientes"></a>

</div>
</body>
</html>