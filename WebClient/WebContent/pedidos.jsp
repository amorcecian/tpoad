<%@page import="businessDelegate.BusinessDelegate"%>
<%@page import="dto.PrendaDTO"%>
<%@page import="java.util.*"%> 
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

<h1 align="center">Realizar un Pedido</h1>
<form action="Controlador?action=CargarPedido" name="formulario" method="post">
<h2 align="center">Prendas</h2>
<div style="padding-left: 100px;">

<table align="center" border="1px" width="600px">
	<tr>
		<td align="center">Prenda</td>
		<td align="center">Talle</td>
		<td align="center">Color</td>
		<td align="center">Precio</td>
		<td align="center">Cantidad</td>
	</tr>
<% 
List <PrendaDTO> lstPre=BusinessDelegate.getInstancia().listarPrendas();
for(PrendaDTO pdto:lstPre){

%>	
		<tr>
		<td align="center"><%=pdto.getDescripcion() %></td>
		<td align="center"><%=pdto.getTalle() %></td>
		<td align="center"><%=pdto.getColor() %></td>
		<td align="center"><%=pdto.getPrecioVenta() %></td>
		<td align="center"><input type="text" name="cantidadPrenda<%=pdto.getIdPrenda()%>" style="width: 40px;"></td>
		</tr>
<% }; %>
</table>

</div>

<div align="center" style="padding-top: 20px;">
<input type="button" value="Volver" onclick="location.href='index.jsp'">
<input type="submit" value="Cargar Pedido">
</div>
</form>

</body>
</html>