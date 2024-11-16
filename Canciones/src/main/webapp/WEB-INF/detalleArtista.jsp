<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Detalle del Artista</h1> 
	<p>Nombre: ${artista.nombre}</p> 
	<p>Apellido: ${artista.apellido}</p> 
	<p>Biografía: ${artista.biografia}</p> 
	<h2>Canciones</h2> 
	<ul> 
		<c:forEach var="cancion" items="${artista.canciones}"> 
			<li>${cancion.titulo}</li> 
		</c:forEach> 
	</ul> 
	<a href="/artistas">Volver a lista de artistas</a>
</body>
</html>