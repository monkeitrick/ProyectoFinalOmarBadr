<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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
    <title>Registro | Gaming for Gamers</title>
    <!-- CSS -->
    <link rel="stylesheet" href="../assets/css/style.css" media="screen">
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
	                       	<a id="play" href="../ServletLogin?cerrarSesion=html/registro.jsp">Cerrar Sesión</a>
	                    </li>
	                    <li>
	                    	<a id="xbox" href="perfilUsuario.jsp?idUsuario=${usuario.idUser}">Perfil de usuario</a>
	                    </li>
	                    <c:if test="${usuario.admin == true}">
		                    <li>
		                       	<a id="nintendo" href="listadoDeUsuarios.jsp?idUsuario="${usuario.idUser}">Listado de usuarios</a>
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
    <div class="pageContainer" id="maincontent">
    
    	<form action="../ServletRegistro" method="post" class="contacto">
	    	<input type="hidden" id="todoOk" name="todoOk" value="todoOk">
	        	<c:if test="${param.error!=null}">
	        	<!-- estilo mal hecho falta retocar-->
			    	<script>
					    alert("Campos Vacios");
					</script>
	       		</c:if>
	       		<c:if test="${param.usuario!=null}">
	        	<!-- estilo mal hecho falta retocar-->
	        		<script>
					    alert("Usuario existente");
					</script>
	       		</c:if>
	        	<!-- Nombre de usuario -->
	        	<div class="form-input">
	                <label for="usuario">Nombre de usuario:</label>
	                <input type="text" name="usuario" id="usuario" placeholder="Nombre de usuario" aria-labelledby="nombre de usuario">
	            </div>
	            
	            <!-- Apellidos -->
	        	<div class="form-input">
	                <label for="apellidos">Apellidos:</label>
	                <input type="text" name="apellidos" id="apellidos" placeholder="Apellido/s" aria-labelledby="apellidos">
	            </div>
	            
	            <!-- Contraseña -->
	            <div class="form-input">
	                <label for="password">Contraseña:</label>
	                <input type="password" name="password" id="contraseña" placeholder="Contraseña" aria-labelledby="Contraseña">
	            </div>
	            
	            <!-- Dirección -->
	            <div class="form-input">
	                <label for="direccion">Dirección:</label>
	                <input type="text" name="direccion" id="direccion" placeholder="Dirección" aria-labelledby="Dirección">
	            </div>
	            
	            <!-- Código Postal -->
	            <div class="form-input">
	                <label for="codigoPostal">Codigo Postal:</label>
	                <input type="text" name="codigoPostal" id="codigoPostal" placeholder="Código Postal" aria-labelledby="Código Postal">
	            </div>
	            
	            <!-- Municipio -->
	            <div class="form-input">
	                <label for="municipio">Municipio:</label>
	                <input type="text" name="municipio" id="municipio" placeholder="Municipio" aria-labelledby="Municipio">
	            </div>
	            
	            <!-- Provincia -->
	            <div class="form-input">
	                <label for="provincia">Provincia:</label>
	                <input type="text" name="provincia" id="provincia" placeholder="Provincia" aria-labelledby="Provincia">
	            </div>
	            
	            <!-- País -->
	            <div class="form-input">
	                <label for="pais">País:</label>
	                <input type="text" name="pais" id="pais" placeholder="País" aria-labelledby="País">
	            </div>
	            
	            <!-- Teléfono -->
	            <div class="form-input">
	                <label for="telefono">Teléfono:</label>
	                <input type="text" name="telefono" id="telefono" placeholder="Teléfono" aria-labelledby="Teléfono">
	            </div>
	            
	            <!-- Email -->
	            <div class="form-input">
	                <label for="email">Email:</label>
	                <input type="text" name="email" id="email" placeholder="Email" aria-labelledby="Email">
	            </div>
	            
	            <!-- Descripción -->
	        	<div class="form-input descripcion">
                	<label for="descripcion">Descripción:</label>
                	<textarea name="descripcion" id="descripcion" cols="30" rows="50"></textarea>
            	</div>
            	
            	<!-- Imagen -->
	        	<div class="form-input">
                	<label for="imagen">Imagen:</label>
                	<input type="file" name="imagen" accept="image/*" />
            	</div>
	            
	            <!-- Es admin -->
	            <div class="form-input">
	                <label for="admin">Es admin
	                <input type="checkbox" name="admin" id="admin" aria-labelledby="admin"></label>
	            </div>
	            
	            <!-- Enviar -->
	        	<div class="form-input enviar">
	                <button type="submit">
	                    Enviar! <i class="fa-solid fa-paper-plane"></i>
	                </button>
	            </div>
	            <div>
	            	<label><a href="login.jsp">Pulsa aquí para iniciar sesión</a></label>
	            </div>
	            <!-- <td colspan="2"><a href="registro.jsp">Registrarse</a></td> -->
	    	</form>
	    	
    
    </div>
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