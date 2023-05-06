 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Aniadimos la cabecera -->
<c:import url="cabecera.jsp"/>

<!-- Listar datos del usuario -->
<h2>
    <b>${datosUsuario.nombre }, ${datosUsuario.apellidos }</b>
    <c:if test="${datosUsuario.admin }">
            <small class="text-success">(Administrador)</small>
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
            <button type="submit" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal">
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
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Cambiar la contraseña</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
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
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Cancelar</button>
        <button type="submit" class="btn btn-danger" name="cambiarPass">Cambiar</button>
      </div>
      </form>
    </div>
  </div>
</div>

<!-- Listar compras del usuario en caso de que tenga -->
<c:if test="${comprasUsuario != null && comprasUsuario.size() > 0}">
<h3>Historial compras</h3>
    <!-- Listado de compras -->
    <table class="table">
        <tr>
            <th>ID Compra</th>
            <th>Fecha</th>
            <th>Total</th>
        </tr>
            <c:forEach items="${comprasUsuario}" var="compra">
                <tr>
                    <td>${compra.idCompra}</td>
                    <td>${compra.fecha}</td>
                    <td>${compra.total} $</td>
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