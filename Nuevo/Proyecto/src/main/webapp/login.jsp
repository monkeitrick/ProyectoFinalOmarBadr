<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%! int i; %>
<!-- A�adimos la cabecera -->
<c:import url="cabecera.jsp"/>

	<form action="ServletLogin" method="post">
	  <!-- Email input -->
	  <div class="form-outline mb-4">
	  	<label class="form-label" for="email">Email</label>
	    <input type="email" id="email" name="email" class="form-control"/>
	  </div>
	
	  <!-- Password input -->
	  <div class="form-outline mb-4">
	  	<label class="form-label" for="password">Contrase�a</label>
	    <input type="password" id="password" class="form-control" name="password"/>
	  </div>
		<c:if test="${mensaje != null}">
			<label class="form-label" style="color: green">${mensaje}</label>
		</c:if>
	
	   <div class="col">
	     <!-- Simple link -->
		<a href="recuperarPass.jsp">�Olvidaste tu contrase�a?</a>
		<a href="registro.jsp">�No tienes cuenta? Registrate</a>
	   </div>
	  
	  <!-- Submit button -->
	  <button type="submit" class="btn btn-danger btn-block mb-4" name="login">Entrar</button>
	  <c:if test="${mensajeError != null}">
	  		<div>
			  <c:out value = "${mensajeError}"/>
			</div> 
	  </c:if>
	</form>

<%session.invalidate();%>

<!-- A�adimos el footer -->
<c:import url="footer.jsp"/>
