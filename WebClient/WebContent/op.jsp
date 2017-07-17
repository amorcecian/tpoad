<%@page import="dto.OrdenDeProduccionDTO"%>
<%@page import="dto.PedidoDTO"%>
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

<h1 align="center">Ordenes de Producción</h1>

<div style="padding-left: 100px;">

<table align="center" border="1px" width="600px">
	<tr>
		<td align="center">Nº de OP</td>
		<td align="center">Fecha de Generacion</td>
		<td align="center">Numero de Pedido</td>
		<td align="center">Precio de Produccion</td>
		<td align="center">Tipo</td>
	</tr>
<% 
List <OrdenDeProduccionDTO> lop=BusinessDelegate.getInstancia().listarOrdenesDeProduccion();
for(OrdenDeProduccionDTO opdto:lop){

%>	
		<tr>
		<td align="center"><a href="Controlador?action=verOP&idOP=<%=opdto.getIdOrdenDeProduccion() %>"><%=opdto.getIdOrdenDeProduccion() %></a></td>
		<td align="center"><%=opdto.getFecha() %></td>
		<td align="center"><%=opdto.getPedido().getIdPedido() %></td>
		<td align="center"><%=opdto.getPrecioProd() %></td>
		<td align="center"><%=opdto.getTipo() %></td>
		</tr>
<% }; %>
</table>

</div>

<div align="center" style="padding-top: 20px;">
<input type="button" value="Volver" onclick="location.href='backend.jsp'">

</div>


</body>
</html>