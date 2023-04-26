<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Añadimos la cabecera -->
<c:import url="cabecera.jsp"/>

	<!-- Si no existe el array de usuarios lo crea-->
	<c:if test="${lstUsuarios == null}">
		<jsp:forward page="ServletUsuarios"/>
	</c:if>

	<!-- Lista de usuario -->
	<h1>Lista de Usuarios</h1>
	<c:if test="${mensaje != null}">
		<label class="form-label" style="color: green">${mensaje}</label>
	</c:if>
	
	<!-- Si hay ususarios registrados en la web se listan -->
	<c:if test="${lstUsuarios.size() > 0}">
		<table class="table mb-5">
			<tr>
		   		<th>Email</th>
		   		<th>Nombre</th>
		   		<th class="hidden"></th>
		   	</tr>
			<c:forEach items="${lstUsuarios}" var="usuario">
				<tr>
					<td><c:out value="${usuario.email}"/> </td>
					<td><c:out value="${usuario.nombre}"/> <c:out value="${usuario.apellidos}"/> </td>
					<td><a class="btn btn-danger" href="ServletUsuarios?BorrarUsuario=${usuario.idUser}">Borrar</a></td>
				</tr>
			</c:forEach> 
		</table>
	</c:if>
	
	<!-- En caso de que no haya ususarios registrados-->
	<c:if test="${lstUsuarios.size() <= 0}">
    	<span class="text-danger m-5">No hay usuarios registrados</span>
	</c:if>
	
	<!-- Lista de administradores -->
	<h1>Lista de Administradores</h1>
	<table class="table">
		<tr>
	   		<th>Email</th>
	   		<th>Nombre</th>
	   		<th class="hidden"></th>
	   	</tr>
		<c:forEach items="${lstAdmins}" var="admin">
			<tr>
				<td><c:out value="${admin.email}"/> </td>
				<td><c:out value="${admin.nombre}"/> <c:out value="${admin.apellidos}"/> </td>
				<td><a class="btn btn-danger" href="ServletUsuarios?BorrarUsuario=${usuario.idUser}">Borrar</a></td>
			</tr>
		</c:forEach> 
	</table>

<!-- Añadimos el footer -->
<c:import url="footer.jsp"/>