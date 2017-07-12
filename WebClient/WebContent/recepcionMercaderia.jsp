<%@page import="dto.ItemOCMPDTO"%>
<%@page import="dto.ordenCMPDTO"%>
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

<h1 align="center">Compras</h1>
<h2 align="center">Recepción de Mercaderias</h2>

<div style="padding-left: 100px;">

<table align="center" border="1px" width="600px">
	<tr>
		<td align="center">Nº Orden de Compra</td>
		<td align="center">Fecha de Pedido</td>
		<td align="center">Color</td>
		<td align="center">Tipo de Orden de Produccion</td>
		<td align="center"></td>
	</tr>
<% 
List <ordenCMPDTO> locpdto=BusinessDelegate.getInstancia().ObtenerOCPendientes();
for(ordenCMPDTO ocdto:locpdto){
List<ItemOCMPDTO> liocdto=ocdto.getItemPedidoInsumo();
%>	
		<tr>
		<td align="center"><%=ocdto.getIdODCM()%></td>
		<td align="center"><%=ocdto.getFechaPedido() %></td>
		<td align="center"><a href="Controlador?action=recibirMercaderia&id="><input type="button" value="Recibido"></a></td>
		</tr>
<% 
for(ItemOCMPDTO iocdto:liocdto){
%>
		<tr>
		<td align="center"><%=iocdto.getMaterial().getNombre()%></td>
		<td align="center"><%=iocdto.getCantidad() %></td>
		<td align="center"><%=iocdto.getPrecio() %></td>
		</tr>
<%
	};
}; 

%>
</table>

</div>

<div align="center" style="padding-top: 20px;">
<input type="button" value="Volver" onclick="location.href='backend.jsp'">

</div>


</body>
</html>