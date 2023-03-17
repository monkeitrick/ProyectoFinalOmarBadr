<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <c:if test="${juegos == null}">
            <c:redirect url="ServletInicio" />
        </c:if>
        <c:if test="${Z2FycmlMb3ZlVQ != null}">
            <script>
                alert("El carrito se ha vaciado correctamente");
            </script>
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
            <link rel="shortcut icon" sizes="any" href="assets/img/favicon/favicon.ico">
            <!-- Titulo -->
            <title>Inicio | Gaming for Gamers</title>
            <!-- CSS -->
            <link rel="stylesheet" href="assets/css/style.css" media="screen">
        </head>

        <body>
            <header>
                <a class="skip-link" href="#maincontent">Ir al contenido principal</a>
                <a href="#" id="branding">
                    <h1>Gaming4Gamers</h1>
                    <img src="assets/img/logo/logoBlancoLogitech.svg" alt="Logo de gaming4gamers" width="150">
                </a>
                <div id="navigation">
                    <div id="btnMenu">
                        <img src="assets/img/icons/menu.svg" alt="Abrir menú de navegación">
                    </div>
                    <c:if test="${usuario != null}">
                        <div id="btnCarrito">
                            <a href="html/carrito.jsp">
                                <i class="fa-sharp fa-solid fa-cart-shopping fa-2xl"></i>
                            </a>
                        </div>
                    </c:if>
                </div>
                <div id='menu'>
                    <div class="logo">
                        <c:if test="${usuario.img != null}">
                            <img src="${usuario.img.ruta }" class="imgUser" alt="${usuario.img }" width="100">
                            <p>${usuario.nombre.toUpperCase() }</p>
                        </c:if>
                        <c:if test="${usuario.img == null}">
                            <img src="assets/img/logo/logoBlancoLogitech.svg" alt="Logo de gaming4gamers" width="150">
                        </c:if>
                    </div>
                    <nav>
                        <ul>
                            <li>
                                <a id="pc" href="./index.jsp">Inicio</a>
                            </li>
                            <c:if test="${usuario == null}">
                                <li>
                                    <a id="play" href="html/login.jsp">Login</a>
                                </li>
                                <li>
                                    <a id="xbox" href="html/registro.jsp">Registro</a>
                                </li>
                            </c:if>
                            <c:if test="${usuario != null}">
                                <li>
                                    <a id="play" href="ServletLogin?cerrarSesion=index.jsp">Cerrar Sesión</a>
                                </li>
                                <li>
                                    <a id="xbox" href="html/perfilUsuario.jsp?idUsuario=${usuario.idUser}">Perfil de
                                        usuario</a>
                                </li>
                                <c:if test="${usuario.admin == true}">
                                    <li>
                                        <a id="nintendo" href="html/listadoDeUsuarios.jsp">Listado de usuarios</a>
                                    </li>
                                    <li>
                                        <a id="pc" href="html/listadoDeCompanias.jsp">Listado de Compañías</a>
                                    </li>
                                </c:if>
                            </c:if>
                        </ul>
                    </nav>

                    <div id="background-images">
                        <div class="background-image" style='background-image: url(assets/img/menu/pc.jpg)'></div>
                        <div class="background-image" style='background-image: url(assets/img/menu/play.jpg)'></div>
                        <div class="background-image" style='background-image: url(assets/img/menu/xbox.jpg)'></div>
                        <div class="background-image" style='background-image: url(assets/img/menu/nintendo.jpg)'></div>
                        <div class="background-image" style='background-image: url(assets/img/menu/pc.jpg)'></div>
                    </div>

                    <div id="close">
                        <img src="assets/img/icons/close.svg" alt="Cerrar menú de navegación">
                    </div>
                </div>
            </header>

            <div class="pageContainer" id="maincontent">
                <!--
        <div class="videoJuegosDestacados">
            
	        <div class="videoJuegoCarrusel carrusel1 active">
                <div class="sombra"></div>
                <div class="label">
                    <div class="icon">
                        <i class="fa-brands fa-playstation fa-lg play"></i>
                    </div>
                    <div class="info">
                        <div class="main">The Last of Us</div>
                        <div class="sub"><a href="https://www.youtube.com/watch?v=Mel8DZBEJTo" target="_blank"><i
                                    class="fa-solid fa-play trailer"></i> Ver Trailer</a></div>
                    </div>
                </div>
            </div>
        </div>
            -->
                <div class="videojuegos">
                    <!-- JUEGO -->
                    <c:forEach var="juego" items="${juegos}">
                        <div>
                            <a href="html/videojuegos.jsp?idJuego=${juego.idJuego }">
                                <picture>
                                    <source media="(max-width: 424px)" srcset="${juego.imgCoverMobile.ruta }">
                                    <source media="(min-width: 600px)" srcset="${juego.imgCover.ruta }">
                                    <img src="${juego.imgCoverMobile.ruta }"
                                        alt="Cover del videojuego ${juego.titulo }">
                                </picture>
                            </a>
                            <div class="plataformas">
                                <c:forEach var="plataforma" items="${juego.plataformas}">
                                    <a href="${plataforma.enlaceOficial }" target="_blank"
                                        aria-label="Enlace a la página oficial de ${plataforma.nombre }"><i
                                            class="${plataforma.slugIcono }"></i></a>
                                </c:forEach>
                            </div>
                            <div class="detalles">
                                <a href="html/videojuegos.jsp?idJuego=${juego.idJuego }">
                                    <div class="titulo">${juego.titulo}</div>
                                </a>
                                <a href="${juego.compania.enlaceOficial}" target="_blank">
                                    <div class="Company">${juego.compania.nombre}</div>
                                </a>
                            </div>
                        </div>
                    </c:forEach>

                </div>
            </div>

            <!-- Cookies -->
            <div id="cookiePopup">
                <strong>Legalidad y RGPD</strong>
                <p>Debes aceptar la <a href="#">Legalidad y RGPD</a></p>
                <button id="acceptCookie">Aceptar</button>
            </div>
            <!-- Footer -->
            <footer>
                <img src="assets/img/logo/logoBlancoLogitech.svg" alt="Logo de Gaming4Gamers" width="150">
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
            <script src="assets/js/script.min.js"></script>
            <script src="https://kit.fontawesome.com/a5ac13e346.js" crossorigin="anonymous"></script>
        </body>

        </html>
        <!-- 
	“Si de alguna manera Dios me diera una segunda oportunidad... Lo haria todo de nuevo ”
				- Joel Miller
	https://www.youtube.com/watch?v=-zOjVJgIVHA 
-->