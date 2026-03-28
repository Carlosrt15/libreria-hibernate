<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<link rel="stylesheet" 
href="/rodrigueztalegoncarlos-libreria/css/estilos.css">

<title>Publicaciones</title>

</head>

<body>

<h1>Publicaciones</h1>

<h2>Insertar publicacion</h2>

<form action="publicaciones" method="post">

<input type="hidden" name="accion" value="insertar">

ID:

<input type="text" name="idpublicacion">

Titulo:

<input type="text" name="titulo">

Autor:

<input type="text" name="autor">

Edicion:

<input type="text" name="nroedicion">

Precio:

<input type="text" name="precio">

Stock:

<input type="text" name="stock">

Tipo:

<select name="idtipo">

<c:forEach items="${tipos}" var="t">

<option value="${t.idtipo}">

${t.descripcion}

</option>

</c:forEach>

</select>

<input type="submit" value="Insertar">

</form>

<br>


<h2>Listado publicaciones</h2>

<table border="1">

<tr>

<th>ID</th>

<th>Titulo</th>

<th>Autor</th>

<th>Edicion</th>

<th>Precio</th>

<th>Stock</th>

<th>Tipo</th>

<th>Modificar</th>

</tr>

<c:forEach items="${lista}" var="p">

<tr>

<td>${p.idpublicacion}</td>

<td>${p.titulo}</td>

<td>${p.autor}</td>

<td>${p.nroedicion}</td>

<td>${p.precio}</td>

<td>${p.stock}</td>

<td>${p.tipo.descripcion}</td>

<td>

<form action="publicaciones" method="post">

<input type="hidden" name="accion" value="actualizar">

<input type="hidden" name="idpublicacion"

value="${p.idpublicacion}">

<input type="text" name="titulo"

value="${p.titulo}">

<input type="text" name="autor"

value="${p.autor}">

<input type="text" name="nroedicion"

value="${p.nroedicion}">

<input type="text" name="precio"

value="${p.precio}">

<input type="text" name="stock"

value="${p.stock}">

<select name="idtipo">

<c:forEach items="${tipos}" var="t">

<option value="${t.idtipo}">

${t.descripcion}

</option>

</c:forEach>

</select>

<input type="submit" value="Modificar">

</form>

</td>

</tr>

</c:forEach>

</table>

</body>

</html>