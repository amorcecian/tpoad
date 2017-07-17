<%@page import="dto.LoteDTO"%>
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

<h1 align="center">Produccion</h1>
<h2 align="center">Etapas Productivas</h2>

<div style="padding-left: 100px;">

<table align="center" border="1px" width="800px">
	<tr>
		<td align="center">Id Lote</td>
		<td align="center">Prenda</td>
		<td align="center">Cantidad a producir</td>
		<td align="center">Etapa Productiva / Total Etapas Productivas</td>
		<td align="center">Operación</td>
	</tr>
<% 
List <OrdenDeProduccionDTO> lopdto=BusinessDelegate.getInstancia().listarOrdenesDeProduccion();
for(OrdenDeProduccionDTO opdto:lopdto){
for(LoteDTO ldto:opdto.getLotes()){
%>	
		<tr>
		<td align="center"><%=ldto.getIdLote()%></td>
		<td align="center"><%=ldto.getPrenda().getDescripcion()%></td>	
		<td align="center"><%=ldto.getCantidadProducida() %></td>
		<td align="center">0/3</td>
		<td align="center"><a href="Controlador?action=finalizarEtapa&idLote="<%=ldto.getIdLote() %>><input type="button" value="Avanzar Etapa"></a></td>
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