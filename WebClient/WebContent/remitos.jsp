<%@page import="dto.PedidoDTO"%>
<%@page import="businessDelegate.BusinessDelegate"%>
<%@page import="dto.RemitoDTO"%>
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
RemitoDTO rdto = (RemitoDTO) request.getAttribute("remito");

%>
<h1 align="center">Remitos</h1>

<div style="padding-left: 100px;">

<table align="center" border="1px" width="600px">
	<tr>
		<td align="center">Nº de Remito</td>
		<td align="center">Fecha de Generacion</td>
		<td align="center">Cliente</td>
		<td align="center">Estado</td>
	</tr>
	
		<tr>
		<td align="center"><%=rdto.getIdRemito() %></td>
		<td align="center"><%=rdto.getFactura().getIdFactura() %></td>
		<td align="center"></td>
		<td align="center"></td>
		</tr>

</table>

</div>

<div align="center" style="padding-top: 20px;">
<input type="button" value="Volver" onclick="location.href='backend.jsp'">

</div>


</body>
</html>