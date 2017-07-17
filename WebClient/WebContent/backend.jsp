<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GutGekleidetWurst</title>
<link href="css/styles.css" rel="stylesheet" type="text/css">
</head>
<body onload="cargar()">
<h1 align="center">Bienvenidos a GutGekleidetWurst</h1>
<h2 align="center">Bienvenido: <%=session.getAttribute("nombreUsuario") %></h2>
<div style="padding-top: 10px;" align="center">
<a href="aprobarPedidos.jsp"><input type="button" value="Aprobar Pedidos"></a>
<a href="verificarStock.jsp"><input type="button" value="Verificar Stock"></a>
<a href="pedidos.jsp"><input type="button" value="Pedidos"></a>
</div>
<div style="padding-top: 20px;" align="center">
<a href="op.jsp"><input type="button" value="Ordenes de Producción"></a>
<a href="avanzarEtapa.jsp"><input type="button" value="Avanzar Etapa Productiva"></a>
<!--<a href="recepcionMercaderia.jsp"><input type="button" value="Recepción de Mercaderia"></a>-->

</div>
<div style="padding-top: 20px;" align="center">
<a href="depositoCentral.jsp"><input type="button" value="Depósito"></a>
<!--<a href="avanzarEtapa.jsp"><input type="button" value="Avanzar Etapa Productiva"></a>-->
<a href="recepcionMercaderia.jsp"><input type="button" value="Recepción de Mercaderia"></a>

</div>
<div align="right" style="padding-top: 20px;">
<a href="Controlador?action=logout"><input type="button" value="Cerrar Sesion"></a>
</div>
</body>
</html>