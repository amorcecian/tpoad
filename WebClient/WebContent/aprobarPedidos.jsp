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

<h1 align="center">Pedidos Pendientes</h1>
<form action="Controlador?action=AprobarPedido" name="formulario" method="post">
<h2 align="center">Pedidos</h2>
<div style="padding-left: 100px;">

<table align="center" border="1px" width="800px">
	<tr>
		<td align="center">Nº de Pedido</td>
		<td align="center">Cliente</td>
		<td align="center">Fecha de Generación</td>
		<td align="center">Estado</td>
		<td align="center">Precio Total</td>
		<td align="center">Saldo Cliente</td>
		<td align="center"></td>
	</tr>
<% 
List <PedidoDTO> lstPed=BusinessDelegate.getInstancia().listarPedidoEstado("Para Aprobar");
for(PedidoDTO pdto:lstPed){

%>	
		<tr>
		<td align="center"><%=pdto.getIdPedido() %></td>
		<td align="center"><%=pdto.getCliente().getNombre() %></td>
		<td align="center"><%=pdto.getFechaGeneracion() %></td>
		<td align="center"><%=pdto.getEstado() %></td>
		<td align="center"><%=pdto.getValor() %></td>
		<td align="center"><%=pdto.getCliente().getCuentaCorriente().getSaldo() %></td>
		<td align="center"><input type="submit" value="Aprobar">
		<input type="hidden" value="<%=pdto.getIdPedido()%>" name="idPedido">
		</td>
		</tr>
<% }; %>
</table>

</div>

<div align="center" style="padding-top: 20px;">
<input type="button" value="Volver" onclick="location.href='backend.jsp'">
</div>
</form>

</body>
</html>