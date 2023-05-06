<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Aniadimos la cabecera -->
<c:import url="cabecera.jsp"/>
	<h2>Carrito de la compra</h2>
	
	<c:if test="${carro == null}">
		<p>¡Tu carrito está vacío!</p>
		<span>Empieza a añadir artículos a tu carrito.</span>
	</c:if>
	
	<!-- En caso de que el carrito no este vacio, lista los articulos que tiene -->
	<c:if test="${carro != null}">
        <form action="ServletPago" method="post">
				<table class="table">
					<tr>
				   		<th>Artículo</th>
				   		<th>Precio</th>
				   		<th>Cantidad</th>
				   		<th>Total</th>
				   	</tr>
					<c:forEach items="${carro}" var="videoJuego">
						<tr>
							<td><c:out value='${videoJuego.titulo}'/></td>
							<td><c:out value='${videoJuego.precio}'/> $</td>
							<td><c:out value='${videoJuego.cantidad}'/> und</td>
							<td><c:out value='${videoJuego.cantidad*videoJuego.precio}'/></td>
						</tr>
					</c:forEach>
				</table>
				<button type="submit" class="btn btn-danger" name="pagar">Pagar</button>
		    </form>
	</c:if>
	
	<br><a href="listadoProductos.jsp" class="btn btn-danger">Seguir comprando</a>
	
<!-- Aniadimos el footer -->
<c:import url="footer.jsp"/>