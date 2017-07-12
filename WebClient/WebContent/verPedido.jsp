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
Integer cliente=(Integer)session.getAttribute("cliente");
PedidoDTO pdto = (PedidoDTO) request.getAttribute("pedido");
%>
<h1 align="center">Pedido</h1>
<h2 align="center">Detalle Pedido</h2>
<h3 align="center">Numero de Pedido: <%=pdto.getIdPedido() %></h3>
<div style="padding-left: 100px;">

<table align="center" border="1px" width="600px">
	<tr>
		<td align="center">Prenda</td>
		<td align="center">Talle</td>
		<td align="center">Color</td>
		<td align="center">Cantidad Pedida</td>
	</tr>
<% 
List <ItemPedidoDTO> lipdto=pdto.getItems();
for(ItemPedidoDTO ipdto:lipdto){

%>	
		<tr>
		<td align="center"><%=ipdto.getPrenda().getDescripcion() %></td>
		<td align="center"><%=ipdto.getPrenda().getTalle()%></td>
		<td align="center"><%=ipdto.getPrenda().getColor() %></td>
		<td align="center"><%=ipdto.getCantidad() %></td>
		</tr>
<% }; %>
</table>

</div>

<div align="center" style="padding-top: 20px;">
<input type="button" value="Volver" onclick="location.href='backend.jsp'"/>
</div>


</body>
</html>