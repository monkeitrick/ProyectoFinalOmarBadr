<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<section class=" gradient-custom">

	<!-- A�adimos la cabecera -->
	<c:import url="cabecera.jsp"/>
		
    <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
    	<div class="card-body p-4 p-md-5">
        	<h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Formulario de Registro</h3>
        	<form action="ServletRegistro" method="post">

          		<div class="row">
            		<div class="col-md-6 mb-4">

              			<div class="form-outline">
              				<label class="form-label" for="nombre">Nombre *</label>
                			<input type="text" id="nombre" name="nombre" class="form-control form-control-lg" required />       
              			</div>

            		</div>
            		<div class="col-md-6 mb-4">

              			<div class="form-outline">
              				<label class="form-label" for="apellidos">Apellidos *</label>
                			<input type="text" id="apellidos" name="apellidos" class="form-control form-control-lg" required/>
              			</div>

            		</div>
          		</div>
          
          		<div class="row">
            		<div class="col-md-6 mb-4">

              			<div class="form-outline">
              				<label class="form-label" for="email">Email *</label>
                			<input type="text" id="email" name="email" class="form-control form-control-lg" required/>
              			</div>

            		</div>
            		<div class="col-md-6 mb-4">
						<div class="form-outline">
              				<label class="form-label" for="pass1">Contrase�a *</label>
                			<input type="password" id="pass1" name="pass1" class="form-control form-control-lg" required/>
              			</div>
            		</div>
          		</div>
          		
          		<div class="row">
            		<div class="col-md-6 mb-4">

              			<div class="form-outline">
              				<label class="form-label" for="pass2">Repetir contrase�a *</label>
                			<input type="password" id="pass2" name="pass2" class="form-control form-control-lg" required/>
              			</div>

            		</div>
            		<div class="col-md-6 mb-4">
						<div class="form-outline">
              				<div class="mt-4 pt-2">
          					<button class="btn btn-danger btn-lg" type="submit" name="registrarse">Registrarse</button>
          				</div>
              			</div>
            		</div>
        		</div>

        	</form>
        	<c:if test="${mensajeError != null}">
				<script type='text/javascript'>alert("${mensajeError}");</script>
			</c:if>
    	</div>
	</div>
</section>
<%session.invalidate();%>

<!-- A�adimos el footer -->
<c:import url="footer.jsp"/>

<!-- Comprobar datos de Formulario para registrarse -->
<script src="./app.js"></script>