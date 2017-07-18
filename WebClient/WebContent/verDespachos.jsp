<%@page import="dto.LoteDTO"%>
<%@page import="dto.OrdenDeProduccionDTO"%>
<%@page import="dto.ItemPedidoDTO"%>
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
<h1 align="center">Remito</h1>
<h2 align="center">Detalles</h2>
<h3 align="center">Numero de Remito: <%=rdto.getIdRemito() %></h3>
<div style="padding-left: 100px;">

<table align="center" border="1px" width="800px">
	<tr>
		<td align="center">Numero</td>
		<td align="center">Numero de Factura</td>
		<td align="center">Estado</td>

	</tr>

		<tr>
		<td align="center"><%=rdto.getIdRemito() %></td>
		<td align="center"><%=rdto.getFactura().getIdFactura()%></td>
		<td align="center"><%=rdto.getEstado() %></td>

		</tr>

</table>

</div>

<div align="center" style="padding-top: 20px;">
<input type="button" value="Volver" onclick="location.href='backend.jsp'"/>
</div>


</body>
</html>