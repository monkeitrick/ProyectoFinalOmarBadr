<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Aniadimos la cabecera -->
<c:import url="cabecera.jsp"/>

	<c:if test="${juego != null}">
        <h2>${juego.titulo}</h2>
	    <h3>${juego.fecha }</h3>
        <a href="${juego.compania.enlaceOficial }" target="_blank">${juego.compania}</a>
        <h4>${juego.precio } €</h4>
        <img src="${juego.imgCover}" alt="Portada" width="350">
	</c:if>
<!-- Aniadimos el footer -->
<c:import url="footer.jsp"/>