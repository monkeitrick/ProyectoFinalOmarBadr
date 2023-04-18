<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Aniadimos la cabecera -->
<c:import url="cabecera.jsp"/>

<!-- Listar datos del usuario -->
<h2>
    <b>${datosUsuario.nombre }, ${datosUsuario.apellidos } 👋</b>
    <c:if test="${datosUsuario.admin }">
            <span>(Es admin)</span>
    </c:if>
</h2>

<!-- Listar compras del usuario en caso de que tenga -->
<c:if test="${comprasUsuario != null && comprasUsuario.size() > 0}">
    <!-- Listado de compras -->
    <table class="table">
        <tr>
            <th>ID Compra</th>
            <th>Fecha</th>
            <th>Total</th>
            <th>Ver detalles</th>
        </tr>
            <c:forEach items="${comprasUsuario}" var="compra">
                <tr>
                    <td>${compra.idCompra}</td>
                    <td>${compra.fecha}</td>
                    <td>${compra.total}</td>
                    <td>
                        <a href="ServletDetallesCompra?id=${compra.idCompra}">Detalles compra</a>
                    </td>
                </tr>
            </c:forEach>
    </table>
</c:if>

<!-- En caso de que no tenga compras aparece un texto-->
<c:if test="${comprasUsuario == null || comprasUsuario.size() <= 0}">
    <h2 class=".text-danger">Este usuario no tiene compras</h2>
</c:if>
    
<!-- Aniadimos el footer -->
<c:import url="footer.jsp"/>