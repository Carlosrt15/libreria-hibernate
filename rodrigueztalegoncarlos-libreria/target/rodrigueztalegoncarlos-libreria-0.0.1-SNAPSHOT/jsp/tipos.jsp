<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Tipos</title>

</head>

<body>

<h1>Tipos</h1>

<form action="/rodrigueztalegoncarlos-libreria/tipos" method="post">

ID:

<input type="text" name="idtipo">

Descripcion:

<input type="text" name="descripcion">

<input type="submit" value="Insertar">

</form>

<br>

<table border="1">

<tr>

<th>ID</th>

<th>Descripcion</th>

</tr>

<c:forEach items="${lista}" var="t">

<tr>

<td>${t.idtipo}</td>

<td>${t.descripcion}</td>

</tr>

</c:forEach>

</table>

</body>

</html>