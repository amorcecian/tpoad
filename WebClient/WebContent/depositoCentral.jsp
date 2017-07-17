<%@page import="dto.PedidoDTO"%>
<%@page import="businessDelegate.BusinessDelegate"%>
<%@page import="dto.LoteDTO"%>
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

<h1 align="center">Deposito Central</h1>

<div style="padding-left: 100px;">

<table align="center" border="1px" width="600px">
	<tr>
		<td align="center">Nº de Lote</td>
		<td align="center">Prenda</td>
		<td align="center">Talle</td>
		<td align="center">Color</td>
		<td align="center">Cantidad Producida</td>
		<td align="center">Almacenamiento</td>
	</tr>
<% 
List <LoteDTO> lldto=BusinessDelegate.getInstancia().listarLotesTerminadosDeProducir();
for(LoteDTO ldto:lldto){

%>	
		<tr>
		<td align="center"><%=ldto.getIdLote() %></td>
		<td align="center"><%=ldto.getPrenda().getDescripcion() %></td>
		<td align="center"><%=ldto.getPrenda().getTalle() %></td>
		<td align="center"><%=ldto.getPrenda().getColor() %></td>
		<td align="center"><%=ldto.getCantidadProducida() %></td>
		<td align="center"><a href="Controlador?action=verAlmacenamiento&idAlmacenamiento=<%=ldto.getUbicacion().getIdAlmacenamiento() %>"><%=ldto.getUbicacion().getIdAlmacenamiento() %></a></td>
		</tr>
<% }; %>
</table>

</div>

<div align="center" style="padding-top: 20px;">
<input type="button" value="Volver" onclick="location.href='backend.jsp'">

</div>


</body>
</html>