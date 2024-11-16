<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>artistas</title>
</head>
<body>
	<h1>Lista de Artistas</h1>
		<ul> 
			<c:forEach var="artista" items="${artistas}"> 
			<li> 
				<a href="/artistas/detalle/${artista.id}">${artista.nombre} ${artista.apellido}</a> 
			</li> 
			</c:forEach> 
		</ul> 
	<a href="/canciones">Ir a canciones</a>
	<a href="/artistas/formulario/agregar">crear artista</a>
</body>
</html>