<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Aniadimos la cabecera -->
<c:import url="cabecera.jsp"/>

	<c:if test="${carro != null}">
        <form action="ServletPago" method="post">
				<table class="table">
					<tr>
				   		<th>Nombre</th>
				   		<th>Precio</th>
				   		<th>Cantidad</th>
				   		<th>Total</th>
				   	</tr>
					<c:forEach items="${carro}" var="videoJuego">
						<tr>
							<td><c:out value='${videoJuego.titulo}'/></td>
							<td><c:out value='${videoJuego.precio}'/> $</td>
							<td><c:out value='${videoJuego.cantidad}'/></td>
							<td><c:out value='${videoJuego.cantidad*videoJuego.precio}'/></td>
						</tr>
					</c:forEach>
				</table>
				<button type="submit" class="btn btn-danger" name="pagar">Pagar</button>
		    </form>
	</c:if>
<!-- Aniadimos el footer -->
<c:import url="footer.jsp"/>