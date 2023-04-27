<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Aniadimos la cabecera -->
<c:import url="cabecera.jsp"/>

<!-- Listar datos del usuario -->
<h2>
    <b>${datosUsuario.nombre }, ${datosUsuario.apellidos }</b>
    <c:if test="${datosUsuario.admin }">
            <small class="text-success">(Es admin)</small>
    </c:if>
</h2>
<table class="table">
    <tr>
        <th>Email</th>
        <th>Contraseña</th>
        <th class="hidden"></th>
    </tr>
    <tr>
        <td>${datosUsuario.email}</td>
        <td>${datosUsuario.passw}</td>
        <td>
            <!-- Button trigger modal para cambiar contraseña-->
            <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModal">
                Cambiar contraseña
            </button>
        </td>
    </tr>
</table>

<!-- Mensaje respecto operación Cambiar de contraseña-->
<c:if test="${mensaje != null}">
    <label class="form-label text-success">${mensaje}</label>
</c:if>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
    <div class="modal-content">
        <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Cambia la contraseña</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
            </button>
        </div>
        <form action="ServletPerfilUsuario" method="post">
            <div class="modal-body">
                <input type="hidden" id="email" name="email" value="${datosUsuario.email}"/>
                <div class="row">
                    <div class="col-md-6 mb-4">
                        <div class="form-outline">
                            <label class="form-label" for="pass1">Contraseña *</label>
                            <input type="password" id="pass1" name="pass1" class="form-control form-control-lg" required/>
                        </div>
                    </div>
                    <div class="col-md-6 mb-4">
                        <div class="form-outline">
                            <label class="form-label" for="pass2">Repite contraseña *</label>
                            <input type="password" id="pass2" name="pass2" class="form-control form-control-lg" required/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger btn-lg" data-dismiss="modal">Cancelar</button>
                <button type="button" class="btn btn-danger btn-lg" name="cambiarPass">Cambiar</button>
            </div>
        </form> 
    </div>
  </div>
</div>

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
    <h2 class="text-danger">Este usuario no tiene compras</h2>
</c:if>
    
<!-- Aniadimos el footer -->
<c:import url="footer.jsp"/>

<!-- Comprobar datos de Formulario para cambiar contraseña-->
<script src="./app.js"></script>