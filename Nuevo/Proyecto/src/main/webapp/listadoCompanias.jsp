<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Aniadimos la cabecera -->
<c:import url="cabecera.jsp"/>

	<!-- Si no existe el array de companias lo crea-->
	<c:if test="${lstCompanias == null}">
		<jsp:forward page="ServletCompanias"/>
	</c:if>

	<!-- Lista de productos -->
	<h1>Listado de Compañias</h1>
	  
	<form action="ServletCompanias" method="post">
		<table class="table">
			<tr>
		   		<th>Imagen</th>
		   		<th>Nombre</th>
		   		<th>Página oficial</th>
		   		<th>Modificar</th>
		   	</tr>
			<c:forEach items="${lstCompanias}" var="compania">
				<tr>
					<td><img src="${compania.getImg().getRuta()}" alt="Imagen Compania" width="250"></td>
					<td><c:out value='${compania.nombre}'/></td>
					<td><a href="${compania.enlaceOficial}" target="_blank">Visitar</a></td>
					<td><button type="submit" class="btn btn-danger" name="editar" value="${compania.id}">Editar</button></td>
				</tr>
			</c:forEach>
		</table>
    </form>
    
<!-- Aniadimos el footer -->
<c:import url="footer.jsp"/>