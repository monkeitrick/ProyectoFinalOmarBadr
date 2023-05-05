<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
	<!-- Si no existe el array de productos lo crea-->
	<c:if test="${lstJuegos == null}">
		<jsp:forward page="ServletProductos"/>
	</c:if>
	
	<!-- Aniadimos la cabecera -->
	<c:import url="cabecera.jsp"/>
	<!-- Lista de productos -->
	<h1>Video Juegos</h1>
	
	<!-- Mensaje de error por si no introducen ningun valor al aniadir -->
	<c:if test="${mensajeError != null}">
	  		<p class="text-success"><c:out value = "${mensajeError}"/></p> 
	 </c:if>
	 <c:choose>
		<c:when test = "${esAdmin == null}">
			<form action="ServletAgregarLineaPedidos" method="post">
				<table class="table">
					<tr>
				   		<th>Nombre</th>
				   		<th>Precio</th>
				   		<th>Cantidad</th>
				   		<th>Añadir</th>
				   	</tr>
					<c:forEach items="${lstJuegos}" var="videoJuego">
						<tr>
							<td><c:out value='${videoJuego.titulo}'/></td>
							<td><c:out value='${videoJuego.precio}'/> $</td>
							<td><input type="number" name="${videoJuego.idJuego}"></td>
							<td>
					        	<button type="submit" class="btn btn-danger" name="aniadir" value="${videoJuego.idJuego}">Añadir</button>
								<button type="submit" class="btn btn-danger" name="detalles" value="${videoJuego.idJuego}">Más info</button>
							</td>
						</tr>
					</c:forEach>
				</table>
				<button type="submit" class="btn btn-danger" name="verCesta">Ver cesta</button>
		    </form>
		</c:when>
		<c:otherwise>
			<form action="ServletProductos" method="Post">
				<table class="table">
					<tr>
				   		<th>Nombre</th>
				   		<th>Precio</th>
				   		<th>Añadir</th>
				   	</tr>
					<c:forEach items="${lstJuegos}" var="videoJuego">
						<tr>
							<td><c:out value='${videoJuego.titulo}'/></td>
							<td><c:out value='${videoJuego.precio}'/> $</td>
							<td>
					        	<button type="submit" class="btn btn-danger" name="borrar" value="${videoJuego.idJuego}">Borrar</button>
							</td>
						</tr>
					</c:forEach>
				</table>
		    </form>
		</c:otherwise>
	</c:choose>
    
<!-- Aniadimos el footer -->
<c:import url="footer.jsp"/>