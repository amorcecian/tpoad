<%@page import="dto.AlmacenamientoDTO"%>
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
AlmacenamientoDTO adto = (AlmacenamientoDTO) request.getAttribute("almacenamiento");
%>
<h1 align="center">Almacenamiento</h1>
<h2 align="center">Detalles del Almacenamiento</h2>
<div style="padding-left: 100px;">

<table align="center" border="1px" width="600px">
	<tr>
		<td align="center">Calle</td>
		<td align="center">Bloque</td>
		<td align="center">Estante</td>
		<td align="center">Posicion</td>
	</tr>

		<tr>
		<td align="center"><%=adto.getCalle() %></td>
		<td align="center"><%=adto.getBloque()%></td>
		<td align="center"><%=adto.getEstante() %></td>
		<td align="center"><%=adto.getPosicion() %></td>
		</tr>

</table>

</div>

<div align="center" style="padding-top: 20px;">
<input type="button" value="Volver" onclick="location.href='depositoCentral.jsp'"/>
</div>


</body>
</html>