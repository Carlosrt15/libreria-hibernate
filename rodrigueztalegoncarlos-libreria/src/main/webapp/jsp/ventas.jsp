<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<link rel="stylesheet" 
href="/rodrigueztalegoncarlos-libreria/css/estilos.css">

<title>Ventas</title>

</head>

<body>

<h1>Ventas</h1>

<a href="/rodrigueztalegoncarlos-libreria">
Volver menu
</a>

<br><br>

<h2>Filtrar ventas</h2>

<form action="ventas" method="get">

ID venta:

<input type="text" name="idventa">

Cliente:

<input type="text" name="cliente">

Empleado:

<select name="idempleado">

<option value="">Todos</option>

<c:forEach items="${empleados}" var="e">

<option value="${e.idempleado}">

${e.idempleado}

</option>

</c:forEach>

</select>

<input type="submit" value="Buscar">

</form>

<br>

<h2>Registrar venta</h2>

<form action="ventas" method="post">

ID venta:

<input type="text" name="idventa">

Cliente:

<input type="text" name="cliente">

Cantidad:

<input type="text" name="cantidad">

Publicacion:

<select name="idpublicacion">

<c:forEach items="${publicaciones}" var="p">

<option value="${p.idpublicacion}">

${p.titulo} (Stock: ${p.stock})

</option>

</c:forEach>

</select>

Empleado:

<select name="idempleado">

<c:forEach items="${empleados}" var="e">

<option value="${e.idempleado}">

${e.idempleado}

</option>

</c:forEach>

</select>

<input type="submit" value="Registrar">

</form>

<br>

<h2>Listado ventas</h2>

<table border="1">

<tr>

<th>ID</th>

<th>Cliente</th>

<th>Publicacion</th>

<th>Empleado</th>

<th>Cantidad</th>

<th>Precio</th>

<th>Descuento</th>

<th>Impuesto</th>

<th>Fecha</th>

</tr>

<c:forEach items="${ventas}" var="v">

<tr>

<td>${v.idventa}</td>

<td>${v.cliente}</td>

<td>${v.publicacion.titulo}</td>

<td>${v.empleado.idempleado}</td>

<td>${v.cantidad}</td>

<td>${v.precio}</td>

<td>${v.dcto}</td>

<td>${v.impuesto}</td>

<td>${v.fecha}</td>

</tr>

</c:forEach>

</table>

</body>

</html>