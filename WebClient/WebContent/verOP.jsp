<%@page import="dto.LoteDTO"%>
<%@page import="dto.OrdenDeProduccionDTO"%>
<%@page import="dto.ItemPedidoDTO"%>
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
<%
OrdenDeProduccionDTO opdto = (OrdenDeProduccionDTO) request.getAttribute("op");

%>
<h1 align="center">Orden de Producción</h1>
<h2 align="center">Detalle</h2>
<h3 align="center">Numero de Pedido: <%=opdto.getIdOrdenDeProduccion() %></h3>
<div style="padding-left: 100px;">

<table align="center" border="1px" width="800px">
	<tr>
		<td align="center">Lote</td>
		<td align="center">Prenda</td>
		<td align="center">Talle</td>
		<td align="center">Color</td>
		<td align="center">Cantidad a Producir</td>
		<td align="center">Costo de Producción</td>
		<td align="center">Etapa del proceso</td>
	</tr>
<% 
List <LoteDTO> llpdto=opdto.getLotes();
for(LoteDTO ldto:llpdto){

%>	
		<tr>
		<td align="center"><%=ldto.getIdLote() %></td>
		<td align="center"><%=ldto.getPrenda().getDescripcion() %></td>
		<td align="center"><%=ldto.getPrenda().getTalle() %></td>
		<td align="center"><%=ldto.getPrenda().getColor() %></td>
		<td align="center"><%=ldto.getCantidadProducida()%></td>
		<td align="center"><%=ldto.getCostoProd() %></td>
		<td align="center"><%=ldto.getEstado() %></td>
		</tr>
<% }; %>
</table>

</div>

<div align="center" style="padding-top: 20px;">
<input type="button" value="Volver" onclick="location.href='op.jsp'"/>
</div>


</body>
</html>