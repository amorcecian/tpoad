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
<div align="center" style="padding-top: 100px">
<form action="Controlador?action=login" method="post">
<table>
	<tr>
		<td>Usuario:</td>
		<td><input type="text" style="width: 150px;" name="usuario"></td>
	</tr>
		<tr>
		<td>Contraseña:</td>
		<td><input type="password" style="width: 150px;" name="contraseña"></td>
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