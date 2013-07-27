<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar Personas</title>
</head>
<body>
	<h1>Listado de Personas</h1>
	<table>
		<tr>
			<th>DNI</th>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>Email</th>
			<th>Telefono</th>
			
			<c:forEach items="${personas }" var="persona">
			<tr>
				<td>${persona.perDni }</td>
				<td>${persona.perNombre }</td>
				<td>${persona.perApellido }</td>
				<td>${persona.perEmail }</td>
				<td>${persona.perTelefono }</td>
			</tr>
			</c:forEach>
		</tr>
	</table>
</body>
</html>