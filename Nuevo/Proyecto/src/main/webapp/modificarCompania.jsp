<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!-- Añadimos la cabecera -->
<c:import url="cabecera.jsp"/>	

<h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Modifica la Compania <b>${compania.nombre}</b></h3>
<form action="ServletCompanias" method="post">
    <input type="hidden" id="idCompania" name="idCompania" value="${compania.id}"/>
    <input type="hidden" id="idImagen" name="idImagen" value="${imagen.idImagen}"/>      

    <div class="row">
        <div class="col-12 mb-4">
            <div class="form-outline">
                <label class="form-label" for="ruta">Ruta imagen *</label>
                <input type="text" id="ruta" name="ruta" value="${imagen.ruta}" class="form-control form-control-lg" required />       
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-12 mb-4">
            <div class="form-outline">
                <label class="form-label" for="nombre">Nombre *</label>
                <input type="text" id="nombre" name="nombre" value="${compania.nombre}" class="form-control form-control-lg" required />       
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-12 mb-4">
            <div class="form-outline">
                <label class="form-label" for="enlace">P�gina oficial *</label>
                <input type="text" id="enlace" name="enlace" value="${compania.enlaceOficial}" class="form-control form-control-lg" required />       
            </div>
        </div>
    </div>

    <div class="mt-4 pt-2">
        <button class="btn btn-danger btn-lg" type="submit" name="modificar">Modificar</button>
    </div>

</form>

 
<%session.invalidate();%>

<!-- Añadimos el footer -->
<c:import url="footer.jsp"/>