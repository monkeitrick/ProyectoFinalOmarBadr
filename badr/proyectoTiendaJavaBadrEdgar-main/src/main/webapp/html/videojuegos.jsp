<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:if test="${param.idJuego != null}">
	<c:redirect url="../ServletJuego?idJuego=${param.idJuego}"/>
</c:if>
<!DOCTYPE html>
<!-- Idioma -->
<html lang="es" data-uw-w-loader="">

<head>
    <!-- Conjunto de caracteres -->
    <meta charset="UTF-8">
    <!-- Viewport -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Autor -->
    <meta name="author" content="Edgar Martínez Palmero" />
    <!-- Descripción -->
    <meta name="description"
        content="Gamers for Gamers es una web en la que podras encontrar toda la información necesaria sobre tus videouegos favoritos" />
    <!-- favicon -->
    <link rel="shortcut icon" sizes="any" href="../assets/img/favicon/favicon.ico">
    <!-- Titulo -->
    <c:if test="${juego != null}">
    	<title>${juego.titulo } | Gaming for Gamers</title>
    </c:if>
    <c:if test="${juego == null}">
    	<title>Juego no encontrado | Gaming for Gamers</title>
    </c:if>
    <!-- CSS -->
    <link rel="stylesheet" href="../assets/css/style.css" media="screen">
    <c:if test="${param.w4Fsb1ByZXNpZGVudGU != null}">
		<script>
			alert("Debes iniciar sesión para poder añadir al carrito");
			window.location.href = "./videojuegos.jsp?aWxsb2p1YW4gTWFuZGE";
		</script>
	</c:if>
	 <c:if test="${param.bG1kc2hvdw != null}">
		<script>
			alert("Juego añadido al carrito");
		</script>
	</c:if>
</head>
<body>
	<header>
        <a class="skip-link" href="#maincontent">Ir al contenido principal</a>
        <a href="../index.jsp" id="branding">
            <h1>Gaming4Gamers</h1>
            <img src="../assets/img/logo/logoBlancoLogitech.svg" alt="Logo de gaming4gamers" width="150">
        </a>
        <div id="navigation">
            <div id="btnMenu">
                <img src="../assets/img/icons/menu.svg" alt="Abrir menú de navegación">
            </div>
            <c:if test="${usuario != null}">
	            <div id="btnCarrito">
	            	<a href="carrito.jsp">
	            	<i class="fa-sharp fa-solid fa-cart-shopping fa-2xl"></i>
	            	</a>
	            </div>
            </c:if>
        </div>
        <div id='menu'>
            <div class="logo">
                <c:if test="${usuario.img != null}">
		            <img src="../${usuario.img.ruta }" class="imgUser" alt="${usuario.img }" width="100">
		            <p>${usuario.nombre.toUpperCase() }</p>
	            </c:if>
	            <c:if test="${usuario.img == null}">
	                <img src="../assets/img/logo/logoBlancoLogitech.svg" alt="Logo de gaming4gamers" width="150">
	            </c:if>
            </div>
            <nav>
                <ul>
                    <li>
                        <a id="pc" href="../index.jsp">Inicio</a>
                    </li>
                    <c:if test="${usuario == null}">
                    <li>
                       	<a id="play" href="login.jsp">Login</a>
                    </li>
                    <li>
                        <a id="xbox" href="registro.jsp">Registro</a>
                    </li>
                    </c:if>
					<c:if test="${usuario != null}">
	                    <li>
	                       	<a id="play" href="../ServletLogin?cerrarSesion=html/videojuegos.jsp">Cerrar Sesión</a>
	                    </li>
	                    <li>
	                    	<a id="xbox" href="perfilUsuario.jsp?idUsuario=${usuario.idUser}">Perfil de usuario</a>
	                    </li>
	                    <c:if test="${usuario.admin == true}">
		                    <li>
		                       	<a id="nintendo" href="listadoDeUsuarios.jsp">Listado de usuarios</a>
		                    </li>
		                    <li>
					        	<a id="pc" href="listadoDeCompanias.jsp">Listado de Compañías</a>
					        </li>
	                    </c:if>
                    </c:if>
                </ul>
            </nav>

            <div id="background-images">
                <div class="background-image" style='background-image: url(../assets/img/menu/pc.jpg)'></div>
                <div class="background-image" style='background-image: url(../assets/img/menu/play.jpg)'></div>
                <div class="background-image" style='background-image: url(../assets/img/menu/xbox.jpg)'></div>
                <div class="background-image" style='background-image: url(../assets/img/menu/nintendo.jpg)'></div>
                <div class="background-image" style='background-image: url(../assets/img/menu/pc.jpg)'></div>
            </div>

            <div id="close">
                <img src="../assets/img/icons/close.svg" alt="Cerrar menú de navegación">
            </div>
        </div>
    </header>
    <c:if test="${juego != null}">
	    <div class="bannerJuego">
	        <div class="imgBannerJuego" style="background-image: url(../${juego.imgBanner});"></div>
	    </div>
	    <div class="juego" id="maincontent">
	        <div class="gridJuego">
	            <div class="coverJuego">
	                <img src="../${juego.imgCover }" alt="Portada The Last of Us: Parte 1" width="250">
	            </div>
	            <div class="infoJuego">
	                <h2>${juego.titulo}</h2>
	                <h3>${juego.fecha }</h3>
	                <a href="${juego.compania.enlaceOficial }" target="_blank">${juego.compania}</a>
	                <h4>${juego.precio } €</h4>
	            </div>
	            <div class="resumen">
	                <p>${juego.descripcion}</p>
	                <div class="caracteristicasMobile">
	                    <ul>
	                        <li>Plataformas: 
		                        <span>
			                        <c:forEach var="plataforma" items="${juego.plataformas}">
			                        	<i class="${plataforma.slugIcono }"></i>
			                        </c:forEach>
		                        </span>
	                        </li>
	                        <li>Genero: 
	                        	<span>
	                        		<c:forEach var="genero" items="${juego.generos}" varStatus="loop">
		                        		${genero }<c:if test="${!loop.last}">, </c:if>
	                       			</c:forEach>
	                        	</span>
	                        </li>
	                    </ul>
	                </div>
	            </div>
	            <div class="caracteristicas">
	                <ul>
                        <li>Plataformas: 
	                        <span>
		                        <c:forEach var="plataforma" items="${juego.plataformas}">
		                        	<i class="${plataforma.slugIcono }"></i>
		                        </c:forEach>
	                        </span>
                        </li>
                        <li>Genero: 
                        	<span>
                        		<c:forEach var="genero" items="${juego.generos}" varStatus="loop">
	                        		${genero }<c:if test="${!loop.last}">, </c:if>
                       			</c:forEach>
                        	</span>
                        </li>
                    </ul>
	            </div>
	        </div>
	    </div>
	    <div class="comprar">
	    	<a href="../ServletCarritoCompra?idJuego=${juego.idJuego }" class="button-27">Añadir al carrito</a>
	    </div>
	    <div class="trailerJuego">
	        <h2>Trailer</h2>
	        <iframe src="${juego.trailer }"
	            title="Trailer ${juego.titulo }" allowfullscreen></iframe>
	    </div>
	    <c:if test="${juego.personajes.size() != 0}">
		    <div class="containerProtagonistas">
		        <h2>Protagonistas</h2>
		        <div class="protas">
			        <c:forEach var="personaje" items="${juego.personajes}" varStatus="loop">
			        	<div class="prota">
			                <img src="../${personaje.imagen}" alt="${personaje}" width="300" height="224">
			                <p>${personaje}</p>
			            </div>
			        </c:forEach>
		        </div>
		    </div>
	    </c:if>
    </c:if>
    <c:if test="${juego == null}">
	    <div class="pageContainer" id="maincontent" style="width: 80vw; height: 60vh;margin-top: 2rem;">
	    	<h2>Creo que te has perdido</h2>
	    	<p><a href="../index.jsp">Volver a Inicio</a></p>
	    </div>
    </c:if>
  
    <footer>
        <img src="../assets/img/logo/logoBlancoLogitech.svg" alt="Logo de Gaming4Gamers" width="150">
        <div class="redes">
            <a class="twitter" href="https://twitter.com/illojuan" target="_blank"
                aria-label="Ir a la página de Twitter"><i class="fa-brands fa-twitter fa-2x"></i></a>
            <a class="youtube" href="https://www.youtube.com/@IlloJuan_" target="_blank"
                aria-label="Ir al canal de YouTube"><i class="fa-brands fa-youtube fa-2x"></i></a>
            <a class="instagram" href="https://www.instagram.com/illojuan/?hl=es" target="_blank"
                aria-label="Ir al perfil de instagram"><i class="fa-brands fa-instagram fa-2x"></i></a>
        </div>
        <div>
            Edgar y Badr | 2022
        </div>
    </footer>

    <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>
    <script src="../assets/js/script.min.js"></script>
    <script src="https://kit.fontawesome.com/a5ac13e346.js" crossorigin="anonymous"></script>
</body>
</html>