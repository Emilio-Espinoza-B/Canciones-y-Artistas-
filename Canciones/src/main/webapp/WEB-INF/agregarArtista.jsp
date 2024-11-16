<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Agregar Artista</title>
</head>
<body>
    <h1>Agregar Artista</h1>
    <form:form modelAttribute="artista" action="/artistas/procesa/agregar" method="post">
        <form:label path="nombre">Nombre:</form:label>
        <form:input path="nombre"/>
        <form:errors path="nombre" cssClass="error"/>
        <br/>

        <form:label path="apellido">Apellido:</form:label>
        <form:input path="apellido"/>
        <form:errors path="apellido" cssClass="error"/>
        <br/>

        <form:label path="biografia">Biografía:</form:label>
        <form:textarea path="biografia"/>
        <form:errors path="biografia" cssClass="error"/>
        <br/>

        <button type="submit">Agregar</button>
    </form:form>
    <a href="/artistas">Volver a lista de artistas</a>
</body>
</html>
