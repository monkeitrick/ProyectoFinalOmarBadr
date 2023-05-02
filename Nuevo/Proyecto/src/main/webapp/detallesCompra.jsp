<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Aniadimos la cabecera -->
<c:import url="cabecera.jsp"/>

<!-- Si no existe el array de lineasPedido lo crea-->
<c:if test="${lineasPedido == null || lineasPedido.size() == 0}">
    <c:redirect url="ServletDetallesCompra?vacio=si" />
</c:if>

<!-- Listamos los datos de la lineaPedido-->
<c:if test="${lineasPedido != null && lineasPedido.size() != 0}">
    <h1>Detalles Compra</h1>
    <table class="table">
        <tr>
            <th>Imagen</th>
            <th>Producto</th>
            <th>Cantidad</th>
            <th>Precio Unitario</th>
            <th>Precio Total</th>
        </tr>
        <c:set var="precioTotal" value="${0}" />
        <c:forEach items="${lineasPedido}" var="linea">
            <tr>
                <td>
                    <img src="/${linea.juego.imgCover}" alt="imagen de Producto" />
                </td>
                <td>${linea.juego.titulo}</td>
                <td>
                    ${linea.cantidad}
                </td>
                <td>${linea.juego.precio} €</td>
                <td>${linea.juego.precio * linea.cantidad} €</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<!-- Boton para volver atras-->
<a class="btn btn-danger" href="perfilUsuario.jsp">Volver</a>
    
<!-- Aniadimos el footer -->
<c:import url="footer.jsp"/>