<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<link rel="stylesheet" 
href="/rodrigueztalegoncarlos-libreria/css/estilos.css">

<title>Tipos</title>

</head>

<body>

<h1>Tipos</h1>

<h2>Insertar tipo</h2>

<form action="tipos" method="post">

<input type="hidden" name="accion" value="insertar">

ID:

<input type="text" name="idtipo">

Descripcion:

<input type="text" name="descripcion">

<input type="submit" value="Insertar">

</form>

<br>

<h2>Listado tipos</h2>

<table border="1">

<tr>

<th>ID</th>

<th>Descripcion</th>

<th>Modificar</th>

</tr>

<c:forEach items="${lista}" var="t">

<tr>

<td>${t.idtipo}</td>

<td>${t.descripcion}</td>

<td>

<form action="tipos" method="post">

<input type="hidden" name="accion" value="actualizar">

<input type="hidden" name="idtipo" value="${t.idtipo}">

<input type="text" name="descripcion" value="${t.descripcion}">

<input type="submit" value="Modificar">

</form>

</td>

</tr>

</c:forEach>

</table>

</body>

</html>