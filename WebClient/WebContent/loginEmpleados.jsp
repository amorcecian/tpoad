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
<h1 align="center">Bienvenidos a GutGekleidetWurst</h1>
<h2 align="center">Ingreso Empleados</h2>
<div align="center" style="padding-top: 10px">
<form action="Controlador?action=loginEmpleados" method="post">
<table>
	<tr>
		<td>Usuario:</td>
		<td><input type="text" style="width: 150px;" name="usuario"></td>
	</tr>
		<tr>
		<td>Contraseņa:</td>
		<td><input type="password" style="width: 150px;" name="contraseņa"></td>
	</tr>
	<tr>
		<td ></td>	
		<td align="center"> <input type="submit" value="Login"></td>
	</tr>
	
</table>
</form>
</div>

</body>
</html>