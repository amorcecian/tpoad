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

<h1 align="center">Pedidos para Despachar</h1>

<div style="padding-left: 100px;">

<table align="center" border="1px" width="600px">
	<tr>
		<td align="center">N� Pedido</td>
		<td align="center">Fecha de Generacion</td>
		<td align="center">Cliente</td>
		<td align="center">Estado</td>
		<td align="center"></td>
	</tr>
<% 
List <PedidoDTO> lstPed=BusinessDelegate.getInstancia().listarPedidos();
for(PedidoDTO pdto:lstPed){

%>	
		<tr>
		<td align="center"><a href="Controlador?action=verPedido&id=<%=pdto.getIdPedido() %>"><%=pdto.getIdPedido() %></a></td>
		<td align="center"><%=pdto.getFechaGeneracion() %></td>
		<td align="center"><%=pdto.getCliente().getNombre() %></td>
		<td align="center"><%=pdto.getEstado() %></td>
		<td align="center" width="100px">
		<a href="Controlador?action=despachar&idPedido=<%=pdto.getIdPedido()%>">
		<script type="text/javascript">		
		var estado="<%=pdto.getEstado()%>"
		if(estado == "Listo para Entregar"){
			document.write("<input type='button' value='Despachar'>");
		}
		</script>
		</a>
		</td>
		</tr>
<% }; %>
</table>

</div>

<div align="center" style="padding-top: 20px;">
<input type="button" value="Volver" onclick="location.href='backend.jsp'">

</div>


</body>
</html>