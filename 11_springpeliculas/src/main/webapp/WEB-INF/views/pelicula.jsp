<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>pelicula Page</title>
	<!--  <style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style> -->
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<h1>
	Add a pelicula
</h1>

<c:url var="addAction" value="/pelicula/add" ></c:url>

<form:form action="${addAction}" commandName="pelicula">
<table>
	<c:if test="${!empty pelicula.nombre}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="nombre">
				<spring:message text="nombre"/>
			</form:label>
		</td>
		<td>
			<form:input path="nombre" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="director">
				<spring:message text="director"/>
			</form:label>
		</td>
		<td>
			<form:input path="director" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="duracion">
				<spring:message text="duracion"/>
			</form:label>
		</td>
		<td>
			<form:input path="duracion" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="pais">
				<spring:message text="pais"/>
			</form:label>
		</td>
		<td>
			<form:input path="pais" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="categoria">
				<spring:message text="categoria"/>
			</form:label>
		</td>
		<td>
			<form:input path="categoria" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="anio">
				<spring:message text="anio" />
			</form:label>
		</td>
		<td>
			<form:input path="anio" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty pelicula.nombre}">
				<input class="btn btn-success" type="submit"
					value="<spring:message text="Edit pelicula"/>" />
			</c:if>
			<c:if test="${empty pelicula.nombre}">
				<input class="btn btn-danger" type="submit"
					value="<spring:message text="Añadir pelicula"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>peliculas List</h3>
<c:if test="${!empty listpeliculas}">
	<table class="tg">
	<tr>
		<th width="80">ID</th>
		<th width="120">Nombre</th>
		<th width="120">Director</th>
		<th width="120">Duracion</th>
		<th width="120">Pais</th>
		<th width="120">Categoria</th>
		<th width="120">anio</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listpeliculas}" var="pelicula">
		<tr>
			<td>${pelicula.id}</td>
			<td>${pelicula.nombre}</td>
			<td>${pelicula.director}</td>
			<td>${pelicula.duracion}</td>
			<td>${pelicula.pais}</td>
			<td>${pelicula.categoria}</td>
			<td>${pelicula.anio}</td>
			<td><a href="<c:url value='/edit/${pelicula.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/remove/${pelicula.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
