-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Mar 10, 2023 at 11:32 AM
-- Server version: 5.7.36
-- PHP Version: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tiendajuegos`
--

-- --------------------------------------------------------

--
-- Table structure for table `compania`
--

DROP TABLE IF EXISTS `compania`;
CREATE TABLE IF NOT EXISTS `compania` (
  `idCompania` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `enlaceOficial` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `idImagen` int(11) NOT NULL DEFAULT '133',
  PRIMARY KEY (`idCompania`),
  KEY `FK_COMP_IMG` (`idImagen`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `compania`
--

INSERT INTO `compania` (`idCompania`, `nombre`, `enlaceOficial`, `idImagen`) VALUES
(1, 'Naughty Dog', 'https://www.naughtydog.com/', 143),
(2, 'Rockstar Games', 'https://www.rockstargames.com/es/', 144),
(3, 'Valve', 'https://www.valvesoftware.com/es/', 145),
(4, 'Santa Monica Studio', 'https://sms.playstation.com/', 146),
(5, 'Riot Games', 'https://www.riotgames.com/es', 147),
(6, 'Insomniac Games', 'https://insomniac.games/', 148),
(7, 'Annapurna Interactive', 'https://annapurnainteractive.com/en', 149),
(8, 'Kojima Productions', 'https://www.kojimaproductions.jp/', 157),
(9, 'Konami', 'https://www.konami.com/', 150),
(10, 'FromSoftware', 'https://www.fromsoftware.jp/ww/', 151),
(11, 'Playstation Studios', 'https://www.playstation.com/es-es/corporate/playstation-studios/', 152),
(12, 'Xbox Game Studios', 'https://www.xbox.com/es-ES/xbox-game-studios', 153),
(13, 'Nintendo', 'https://www.nintendo.es/', 154),
(14, 'Playground Games', 'https://playground-games.com/', 155),
(15, 'BattleState Games', 'https://www.battlestategames.com/', 156);

-- --------------------------------------------------------

--
-- Table structure for table `compra`
--

DROP TABLE IF EXISTS `compra`;
CREATE TABLE IF NOT EXISTS `compra` (
  `idCompra` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `total` double NOT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`idCompra`),
  KEY `FK_Us_Compra` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `compra`
--

INSERT INTO `compra` (`idCompra`, `fecha`, `total`, `id_usuario`) VALUES
(1, '2023-02-10', 200, 3),
(2, '2023-02-10', 200, 3),
(3, '2023-02-10', 600, 3),
(4, '2023-02-14', 180, 3);

-- --------------------------------------------------------

--
-- Table structure for table `genero`
--

DROP TABLE IF EXISTS `genero`;
CREATE TABLE IF NOT EXISTS `genero` (
  `idGenero` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`idGenero`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `genero`
--

INSERT INTO `genero` (`idGenero`, `nombre`) VALUES
(1, 'Acción'),
(2, 'Simulación'),
(3, 'Horror'),
(4, 'Aventura'),
(5, 'Soulslike'),
(6, 'FPS'),
(7, 'Multijugador'),
(8, 'Un Jugador'),
(9, 'Mundo abierto'),
(10, 'MOBA'),
(11, 'Supervivencia'),
(12, 'Arcade'),
(13, 'Deportes'),
(14, 'Estrategia'),
(15, 'MMO'),
(16, 'RPG'),
(17, 'Superhéroes');

-- --------------------------------------------------------

--
-- Table structure for table `gen_jue`
--

DROP TABLE IF EXISTS `gen_jue`;
CREATE TABLE IF NOT EXISTS `gen_jue` (
  `id_gen` int(11) NOT NULL,
  `id_juego` int(11) NOT NULL,
  PRIMARY KEY (`id_gen`,`id_juego`),
  KEY `FK_JUE_GEN_JUE` (`id_juego`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `gen_jue`
--

INSERT INTO `gen_jue` (`id_gen`, `id_juego`) VALUES
(1, 1),
(3, 1),
(4, 1),
(1, 2),
(3, 2),
(4, 2),
(1, 3),
(6, 3),
(7, 3),
(1, 4),
(4, 4),
(1, 5),
(4, 5),
(1, 6),
(4, 6),
(1, 7),
(4, 7),
(1, 8),
(4, 8),
(1, 9),
(4, 9),
(1, 10),
(4, 10),
(2, 11),
(7, 11),
(8, 11),
(9, 11),
(1, 12),
(4, 12),
(8, 12);

-- --------------------------------------------------------

--
-- Table structure for table `imagen`
--

DROP TABLE IF EXISTS `imagen`;
CREATE TABLE IF NOT EXISTS `imagen` (
  `idImagen` int(11) NOT NULL AUTO_INCREMENT,
  `ruta` varchar(150) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`idImagen`)
) ENGINE=InnoDB AUTO_INCREMENT=158 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `imagen`
--

INSERT INTO `imagen` (`idImagen`, `ruta`) VALUES
(1, 'assets/img/users/defaultUser.jpg'),
(2, 'assets/img/juegos/covers/defaultCover.jpg'),
(3, 'assets/img/juegos/covers/coversMobile/defaultCoverMobile.jpg'),
(4, 'assets/img/juegos/banners/defaultBanner.jpg'),
(5, 'assets/img/personajes/defaultPersonaje.jpg'),
(6, 'assets/img/juegos/covers/coversNormal/eldenRing.webp'),
(7, 'assets/img/juegos/covers/coversNormal/gow.webp'),
(8, 'assets/img/juegos/covers/coversNormal/miles.webp'),
(9, 'assets/img/juegos/covers/coversNormal/outerWilds.webp'),
(10, 'assets/img/juegos/covers/coversNormal/ragnarok.webp'),
(11, 'assets/img/juegos/covers/coversNormal/rdr2.webp'),
(12, 'assets/img/juegos/covers/coversNormal/spiderman.webp'),
(13, 'assets/img/juegos/covers/coversNormal/TLoU1.webp'),
(14, 'assets/img/juegos/covers/coversNormal/TLoU2.webp'),
(15, 'assets/img/juegos/covers/coversNormal/uncharted1.webp'),
(16, 'assets/img/juegos/covers/coversNormal/uncharted2.webp'),
(17, 'assets/img/juegos/covers/coversNormal/uncharted3.webp'),
(18, 'assets/img/juegos/covers/coversNormal/uncharted4.webp'),
(19, 'assets/img/juegos/covers/coversNormal/unchartedTheLostLegacy.webp'),
(20, 'assets/img/juegos/covers/coversMobile/eldenRing.webp'),
(21, 'assets/img/juegos/covers/coversMobile/ForzaHorizont5.webp'),
(22, 'assets/img/juegos/covers/coversMobile/gow.webp'),
(23, 'assets/img/juegos/covers/coversMobile/Halo.webp'),
(24, 'assets/img/juegos/covers/coversMobile/miles.webp'),
(25, 'assets/img/juegos/covers/coversMobile/outerWilds.webp'),
(26, 'assets/img/juegos/covers/coversMobile/Ragnarok.webp'),
(27, 'assets/img/juegos/covers/coversMobile/rdr2.webp'),
(28, 'assets/img/juegos/covers/coversMobile/spiderman.webp'),
(29, 'assets/img/juegos/covers/coversMobile/TLoU1.webp'),
(30, 'assets/img/juegos/covers/coversMobile/TLoU2.webp'),
(31, 'assets/img/juegos/covers/coversMobile/uncharted1.webp'),
(32, 'assets/img/juegos/covers/coversMobile/uncharted2.webp'),
(33, 'assets/img/juegos/covers/coversMobile/uncharted3.webp'),
(34, 'assets/img/juegos/covers/coversMobile/uncharted4.webp'),
(35, 'assets/img/juegos/covers/coversMobile/unchartedTheLostLegacy.webp'),
(36, 'assets/img/juegos/covers/coversMobile/csgo.webp'),
(37, 'assets/img/juegos/covers/coversNormal/csgo.webp'),
(38, 'assets/img/juegos/banners/gow.webp'),
(39, 'assets/img/juegos/banners/ragnarok.webp'),
(40, 'assets/img/juegos/banners/tlou.webp'),
(41, 'assets/img/juegos/banners/tlou2.webp'),
(42, 'assets/img/juegos/banners/uncharted.webp'),
(43, 'assets/img/juegos/banners/uncharted2.webp'),
(44, 'assets/img/juegos/banners/uncharted3.webp'),
(45, 'assets/img/juegos/banners/uncharted4.webp'),
(46, 'assets/img/juegos/banners/uncharted5.webp'),
(47, 'assets/img/juegos/banners/csgo.webp'),
(90, 'assets/img/personajes/gow/atreus.webp'),
(91, 'assets/img/personajes/gow/kratos.webp'),
(92, 'assets/img/personajes/gow/mimir.webp'),
(93, 'assets/img/personajes/gow/baldur.webp'),
(94, 'assets/img/personajes/ragnarok/kratos.webp'),
(95, 'assets/img/personajes/ragnarok/atreus.webp'),
(96, 'assets/img/personajes/ragnarok/mimir.webp'),
(97, 'assets/img/personajes/ragnarok/freya.webp'),
(98, 'assets/img/personajes/ragnarok/odin.webp'),
(99, 'assets/img/personajes/ragnarok/tyr.webp'),
(100, 'assets/img/personajes/ragnarok/thor.webp'),
(101, 'assets/img/personajes/ragnarok/brok.webp'),
(102, 'assets/img/personajes/ragnarok/sindri.webp'),
(103, 'assets/img/personajes/uncharted5/chloe.webp'),
(104, 'assets/img/personajes/uncharted5/samuel.webp'),
(105, 'assets/img/personajes/uncharted4/nathan.webp'),
(106, 'assets/img/personajes/uncharted4/samuel.webp'),
(107, 'assets/img/personajes/uncharted4/sully.webp'),
(108, 'assets/img/personajes/uncharted4/elena.webp'),
(109, 'assets/img/personajes/uncharted3/nathan.webp'),
(110, 'assets/img/personajes/uncharted3/sully.webp'),
(111, 'assets/img/personajes/uncharted3/elena.webp'),
(112, 'assets/img/personajes/uncharted3/chloe.webp'),
(113, 'assets/img/personajes/uncharted3/charlie.webp'),
(114, 'assets/img/personajes/uncharted2/nathan.webp'),
(115, 'assets/img/personajes/uncharted2/sully.webp'),
(116, 'assets/img/personajes/uncharted2/elena.webp'),
(117, 'assets/img/personajes/uncharted2/chloe.webp'),
(118, 'assets/img/personajes/uncharted/nathan.webp'),
(119, 'assets/img/personajes/uncharted/sully.webp'),
(120, 'assets/img/personajes/uncharted/elena.webp'),
(121, 'assets/img/personajes/csgo/terrorista.webp'),
(122, 'assets/img/personajes/csgo/antiTerrorista.webp'),
(123, 'assets/img/personajes/tlou2/joel.webp'),
(124, 'assets/img/personajes/tlou2/ellie.webp'),
(125, 'assets/img/personajes/tlou2/dina.webp'),
(126, 'assets/img/personajes/tlou2/abby.webp'),
(127, 'assets/img/personajes/tlou2/tommy.webp'),
(128, 'assets/img/personajes/tlou/joel.webp'),
(129, 'assets/img/personajes/tlou/ellie.webp'),
(130, 'assets/img/personajes/tlou/marlene.webp'),
(131, 'assets/img/personajes/tlou/bill.webp'),
(132, 'assets/img/personajes/gow/freya.webp'),
(133, 'assets/img/compania/defaultCompania.jpg'),
(134, 'assets/img/juegos/covers/coversNormal/ForzaHorizont5.webp'),
(135, 'assets/img/juegos/covers/coversMobile/ForzaHorizont5.webp'),
(136, 'assets/img/juegos/banners/ForzaHorizont5.webp'),
(137, 'assets/img/juegos/covers/coversNormal/rdr2.webp'),
(138, 'assets/img/juegos/covers/coversMobile/rdr2.webp'),
(139, 'assets/img/juegos/banners/rdr2.webp'),
(140, 'assets/img/personajes/rdr2/arthur.webp'),
(141, 'assets/img/personajes/rdr2/dutch.webp'),
(142, 'assets/img/personajes/rdr2//john.webp'),
(143, 'assets/img/compania/naughtyDog.webp'),
(144, 'assets/img/compania/rockstarGames.webp'),
(145, 'assets/img/compania/valve.webp'),
(146, 'assets/img/compania/santaMonicaStudio.webp'),
(147, 'assets/img/compania/riotGames.webp'),
(148, 'assets/img/compania/insomniacGames.webp'),
(149, 'assets/img/compania/annapurnaInteractive.webp'),
(150, 'assets/img/compania/konami.webp'),
(151, 'assets/img/compania/fromSoftware.webp'),
(152, 'assets/img/compania/playStationStudios.webp'),
(153, 'assets/img/compania/xboxGameStudios.webp'),
(154, 'assets/img/compania/nintendo.webp'),
(155, 'assets/img/compania/playgroundGames.webp'),
(156, 'assets/img/compania/battleStateGames.webp'),
(157, 'assets/img/compania/kojimaProductions.webp');

-- --------------------------------------------------------

--
-- Table structure for table `lineapedido`
--

DROP TABLE IF EXISTS `lineapedido`;
CREATE TABLE IF NOT EXISTS `lineapedido` (
  `idLineaPedido` int(11) NOT NULL AUTO_INCREMENT,
  `cantidad` int(11) NOT NULL,
  `id_juego` int(11) NOT NULL,
  `id_compra` int(11) NOT NULL,
  PRIMARY KEY (`idLineaPedido`),
  KEY `FK_LinPed_Vidjue` (`id_juego`),
  KEY `FK_LinPed_Compra` (`id_compra`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `lineapedido`
--

INSERT INTO `lineapedido` (`idLineaPedido`, `cantidad`, `id_juego`, `id_compra`) VALUES
(11, 1, 1, 1),
(12, 6, 9, 1),
(13, 6, 9, 2),
(14, 1, 10, 2),
(15, 6, 9, 3),
(16, 6, 10, 3),
(17, 2, 1, 4),
(18, 1, 7, 4);

-- --------------------------------------------------------

--
-- Table structure for table `personaje`
--

DROP TABLE IF EXISTS `personaje`;
CREATE TABLE IF NOT EXISTS `personaje` (
  `idPersonaje` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `id_juego` int(11) NOT NULL,
  `id_imagen` int(11) DEFAULT '5',
  PRIMARY KEY (`idPersonaje`),
  KEY `FK_Per_Vidjue` (`id_juego`),
  KEY `FK_Img_Per` (`id_imagen`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `personaje`
--

INSERT INTO `personaje` (`idPersonaje`, `nombre`, `id_juego`, `id_imagen`) VALUES
(1, 'Joel Miller', 1, 128),
(2, 'Ellie Williams', 1, 129),
(3, 'Marlene', 1, 130),
(4, 'Bill', 1, 131),
(5, 'Joel Miller', 2, 123),
(6, 'Ellie Williams', 2, 124),
(7, 'Dina', 2, 125),
(8, 'Abby Anderson', 2, 126),
(9, 'Tommy Miller', 2, 127),
(10, 'Fuerza Terrorista', 3, 121),
(11, 'Fuerza Antiterrorista', 3, 122),
(12, 'Nathan Drake', 4, 118),
(13, 'Victor Sullivan', 4, 119),
(14, 'Elena Fisher', 4, 120),
(15, 'Nathan Drake', 5, 114),
(16, 'Victor Sullivan', 5, 115),
(17, 'Elena Fisher', 5, 116),
(18, 'Chloe Frazer', 5, 117),
(19, 'Nathan Drake', 6, 109),
(20, 'Victor Sullivan', 6, 110),
(21, 'Elena Fisher', 6, 111),
(22, 'Chloe Frazer', 6, 112),
(23, 'Charlie Cutter', 6, 113),
(24, 'Nathan Drake', 7, 105),
(25, 'Samuel Drake', 7, 106),
(26, 'Victor Sullivan', 7, 107),
(27, 'Elena Fisher', 7, 108),
(28, 'Chloe Frazer', 8, 103),
(29, 'Samuel Drake', 8, 104),
(30, 'Kratos', 9, 91),
(31, 'Atreus', 9, 90),
(32, 'Mimir', 9, 92),
(33, 'Freya', 9, 132),
(34, 'Baldur', 9, 93),
(35, 'Kratos', 10, 94),
(36, 'Atreus', 10, 95),
(37, 'Mimir', 10, 96),
(38, 'Freya', 10, 97),
(39, 'Odin', 10, 98),
(40, 'Tyr', 10, 90),
(41, 'Thor', 10, 100),
(42, 'Brok', 10, 101),
(43, 'Sindri', 10, 102),
(44, 'Arthur Morgan', 12, 140),
(45, 'Dutch van der Linde', 12, 141),
(46, 'John Marston', 12, 142);

-- --------------------------------------------------------

--
-- Table structure for table `plataforma`
--

DROP TABLE IF EXISTS `plataforma`;
CREATE TABLE IF NOT EXISTS `plataforma` (
  `idPlataforma` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `enlaceOficial` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `slugIcono` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`idPlataforma`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `plataforma`
--

INSERT INTO `plataforma` (`idPlataforma`, `nombre`, `enlaceOficial`, `slugIcono`) VALUES
(1, 'Steam', 'https://store.steampowered.com/?l=spanish', 'fa-brands fa-steam'),
(2, 'Playstation Studios', 'https://www.playstation.com/es-es/', 'fa-brands fa-playstation'),
(3, 'Xbox Game Studios', 'https://www.xbox.com/es-ES/', 'fa-brands fa-xbox'),
(4, 'Nintendo', 'https://www.nintendo.es/', 'fa-solid fa-game-console-handheld');

-- --------------------------------------------------------

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `apellidos` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `admin` tinyint(1) NOT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `usuario`
--

INSERT INTO `usuario` (`idUsuario`, `nombre`, `apellidos`, `email`, `password`, `admin`) VALUES
(1, 'Omar', 'Eiyana', 'omaradm@omar.com', 'omar', 1),
(2, 'Badr', 'Jebari', 'badradm@badr.com', 'badr', 1),
(3, 'Admin', 'Admin', 'admin@admin.com', 'admin', 1),
(6, 'Pedro', 'García', 'pedro@gmail.com', 'pedro', 0),
(7, 'Jesus', 'Gabarre', 'jesus@gmail.com', 'jesus', 0),
(8, 'Yeray', 'Oro', 'yeray@gmail.com', 'yeray', 0),
(9, 'Iker', 'Murgia', 'iker@gmail.com', 'iker', 0),
(10, 'Teo', 'Stefanescu', 'teo@gmail.com', 'teo', 0),
(11, 'Ander', 'Arocena', 'ander@gmail.com', 'ander', 0),
(12, 'Juan', 'López', 'juan@gmail.com', 'juan', 0),
(13, 'Luis', 'Henrique', 'luis@gmail.com', 'luis', 0);

-- --------------------------------------------------------

--
-- Table structure for table `videojuegos`
--

DROP TABLE IF EXISTS `videojuegos`;
CREATE TABLE IF NOT EXISTS `videojuegos` (
  `idJuego` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `fecha` date DEFAULT NULL,
  `descripcion` varchar(1000) COLLATE utf8mb4_unicode_ci NOT NULL,
  `trailer` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `precio` double NOT NULL,
  `id_compania` int(11) NOT NULL,
  `id_imgCover` int(11) DEFAULT '2',
  `id_imgCoverMobile` int(11) DEFAULT '3',
  `id_imgBanner` int(11) DEFAULT '4',
  PRIMARY KEY (`idJuego`),
  KEY `FK_Comp_Vidjue` (`id_compania`),
  KEY `FK_Img_Vid` (`id_imgCover`),
  KEY `FK_Img_Vid2` (`id_imgBanner`),
  KEY `FK_Img_Vid3` (`id_imgCoverMobile`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `videojuegos`
--

INSERT INTO `videojuegos` (`idJuego`, `titulo`, `fecha`, `descripcion`, `trailer`, `precio`, `id_compania`, `id_imgCover`, `id_imgCoverMobile`, `id_imgBanner`) VALUES
(1, 'The Last of Us: Parte 1', '2013-06-14', 'La historia de \'The Last of Us\' tiene lugar veinte años después de que la civilización moderna haya sido destruida. Joel, un superviviente de carácter recio, es contratado para sacar de contrabando a Ellie, una niña de 14 años, fuera de una opresiva zona de cuarentena. Lo que comienza como un pequeño trabajo pronto se convierte en un viaje brutal y desgarrador, ya que ambos deben atravesar los EE. UU. y depender el uno del otro para sobrevivir.', 'https://www.youtube.com/embed/Mel8DZBEJTo', 80, 1, 13, 29, 40),
(2, 'The Last of Us: Parte 2', '2020-06-19', 'Ellie y Joel se han asentado en Jackson. Vivir en una próspera comunidad de supervivientes les ha otorgado paz y estabilidad a pesar de la amenaza constante que suponen los infectados y otros viajeros más desesperados. A raíz de unos acontecimientos que truncan esa paz, Ellie se embarca en un viaje sin descanso para hacer justicia y pasar página. Tendrá que enfrentarse a las devastadoras consecuencias físicas y emocionales de sus actos.', 'https://www.youtube.com/embed/BO1HAm_XYS8', 80, 1, 14, 30, 41),
(3, 'Counter Strike: Global Offensive', '2012-08-21', 'Cuarta entrega de la saga de Valve, CSGO repite el planteamiento de siempre: dos equipos, terroristas y antiterroristas, luchando entre sí por cumplir objetivos como plantar/ desactivar una bomba.', 'https://www.youtube.com/embed/edYCtaNueQY', 12, 3, 37, 36, 47),
(4, 'Uncharted', '2007-11-19', 'Nathan Drake es un cazarrecompensas que acaba de encontrar algo que llevaba años buscando: el ataúd de su antepasado Sir Francis Drake. Le acompaña la periodista Elena Fisher, quién ha decidido grabar un documental de la expedición. Pero, todo cambia cuando dentro del ataúd únicamente hay un diario y en él se encuentra la ruta hacia El Dorado.', 'https://www.youtube.com/embed/lwwnN5kmD1A', 5, 1, 15, 31, 42),
(5, 'Uncharted 2', '2009-10-13', 'Nathan Drake está dentro de un tren destrozado, a punto de caer por un acantilado, en China. ¿Cómo ha llegado hasta allí? Cinco meses antes, junto a Harry Flynn y Chloe Frazer, planeó el robo de una lámpara en un museo de Estambul. Allí, escondido, estaba un mapa realizado por Marco Polo que señalaba la ruta hacia la mítica ciudad de Shambala. Tras ser traicionado por uno de ellos, Nathan se embarca en una aventura para encontrar la ciudad antes que sus enemigos.', 'https://www.youtube.com/embed/M4S1as7d8lY', 5, 1, 16, 32, 43),
(6, 'Uncharted 3', '2011-11-01', 'Nathan Drake y Sully negocian la compra del anillo de Nathan (que perteneció a Sir Francis Drake) por parte de Talbot. Pero, este les tiende una emboscada y los cazarrecompensas descubren que está a las órdenes de Katherine Marlowe, una vieja conocida. Al parecer, el anillo funciona como un descodificador del astrolabio que marca la ruta a la ciudad perdida de Ubar.', 'https://www.youtube.com/embed/5yP3R8SwraQ', 10, 1, 17, 33, 44),
(7, 'Uncharted 4', '2016-05-10', 'Cronológicamente el juego toma lugar alrededor del año 2014, entre tres y cinco años después de Uncharted 3: La traición de Drake. El retirado cazafortunas Nathan Drake vive felizmente su vida junto con su esposa Elena Fisher, pero todo se derrumba cuando aparece su hermano Sam, el que Nathan pensaba que estaba muerto. Sam necesita su ayuda para desenmascarar una conspiración histórica del famoso pirata aventurero Henry Avery y su legendario tesoro. Además, no son los únicos que buscan el tesoro.', 'https://www.youtube.com/embed/hh5HV4iic1Y', 20, 1, 18, 34, 45),
(8, 'Uncharted 5', '2017-08-22', 'Para recuperar un antiguo artefacto y evitar que caiga en manos de un despiadado caudillo, Chloe necesitará a la famosa mercenaria Nadine Ross y tendrá que viajar hasta los Ghats occidentales de la India en busca del Colmillo de Ganesh de oro.', 'https://www.youtube.com/embed/Q7_7Y471qHk', 40, 1, 19, 35, 46),
(9, 'God of War', '2018-04-20', 'Han pasado años desde que Kratos tomó su venganza contra los Dioses Olímpicos. Habiendo sobrevivido la pelea final contra su padre Zeus, Kratos vive ahora con su joven hijo Atreus en el mundo de los Dioses Nórdicos, una tierra hostil habitada por feroces monstruos y guerreros.', 'https://www.youtube.com/embed/lRhzFqA1f7o', 20, 4, 7, 22, 38),
(10, 'God of War: Ragnarök', '2029-11-09', 'Kratos y Atreus viajarán por los Nueve Reinos en una nueva aventura épica donde no faltarán los dioses ni los monstruos.', 'https://www.youtube.com/embed/jb0LtQBNqhY', 80, 4, 10, 26, 39),
(11, 'Forza Horizon 5', '2021-11-01', 'Forza Horizon 5 es la nueva entrega de la saga de conducción en mundo abierto de Microsoft. El título, que llegará a Xbox One, Xbox Series X/S y PC, se ambientará en México y contará con un sistema de condiciones meteorológicas que incluirá desde leves tormentas de polvo, hasta tormentas tropicales más fuertes y otro tipo de eventos climáticos grandes y masivos. Además de la nueva información aportada a nivel de jugabilidad, los modos The Eliminator y Super 7 estarán de regreso. Forza Horizon 5 también contará con un conjunto de herramientas que permitirán crear nuestras propias carreras, modos de juego y experiencias.', 'https://www.youtube.com/embed/FYH9n37B7Yw', 80, 14, 134, 135, 136),
(12, 'Red Dead Redemption 2', '2018-10-26', 'Tras un asalto fallido en el pueblo de Blackwater, Arthur Morgan y la pandilla de Van der Linde se ven forzados a huir. Con agentes federales y los mejores cazarrecompensas pisando sus talones, la pandilla deberá asaltar, robar y hacerse camino a través de una América despiadada para poder sobrevivir.', 'https://www.youtube.com/embed/BkEXJk6ZAf0', 40, 2, 137, 138, 139);

-- --------------------------------------------------------

--
-- Table structure for table `vid_pla`
--

DROP TABLE IF EXISTS `vid_pla`;
CREATE TABLE IF NOT EXISTS `vid_pla` (
  `id_juego` int(11) NOT NULL,
  `id_plataforma` int(11) NOT NULL,
  PRIMARY KEY (`id_juego`,`id_plataforma`),
  KEY `FK_PLA_PLA_JUE` (`id_plataforma`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `vid_pla`
--

INSERT INTO `vid_pla` (`id_juego`, `id_plataforma`) VALUES
(1, 1),
(3, 1),
(7, 1),
(8, 1),
(9, 1),
(11, 1),
(12, 1),
(1, 2),
(2, 2),
(4, 2),
(5, 2),
(6, 2),
(7, 2),
(8, 2),
(9, 2),
(10, 2),
(12, 2),
(11, 3),
(12, 3);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `compania`
--
ALTER TABLE `compania`
  ADD CONSTRAINT `FK_COMP_IMG` FOREIGN KEY (`idImagen`) REFERENCES `imagen` (`idImagen`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `compra`
--
ALTER TABLE `compra`
  ADD CONSTRAINT `FK_Us_Compra` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`idUsuario`);

--
-- Constraints for table `gen_jue`
--
ALTER TABLE `gen_jue`
  ADD CONSTRAINT `FK_GEN_GEN_JUE` FOREIGN KEY (`id_gen`) REFERENCES `genero` (`idGenero`),
  ADD CONSTRAINT `FK_JUE_GEN_JUE` FOREIGN KEY (`id_juego`) REFERENCES `videojuegos` (`idJuego`);

--
-- Constraints for table `lineapedido`
--
ALTER TABLE `lineapedido`
  ADD CONSTRAINT `FK_LinPed_Compra` FOREIGN KEY (`id_compra`) REFERENCES `compra` (`idCompra`),
  ADD CONSTRAINT `FK_LinPed_Vidjue` FOREIGN KEY (`id_juego`) REFERENCES `videojuegos` (`idJuego`);

--
-- Constraints for table `personaje`
--
ALTER TABLE `personaje`
  ADD CONSTRAINT `FK_Img_Per` FOREIGN KEY (`id_imagen`) REFERENCES `imagen` (`idImagen`),
  ADD CONSTRAINT `FK_Per_Vidjue` FOREIGN KEY (`id_juego`) REFERENCES `videojuegos` (`idJuego`);

--
-- Constraints for table `videojuegos`
--
ALTER TABLE `videojuegos`
  ADD CONSTRAINT `FK_Comp_Vidjue` FOREIGN KEY (`id_compania`) REFERENCES `compania` (`idCompania`),
  ADD CONSTRAINT `FK_Img_Vid` FOREIGN KEY (`id_imgCover`) REFERENCES `imagen` (`idImagen`),
  ADD CONSTRAINT `FK_Img_Vid2` FOREIGN KEY (`id_imgBanner`) REFERENCES `imagen` (`idImagen`),
  ADD CONSTRAINT `FK_Img_Vid3` FOREIGN KEY (`id_imgCoverMobile`) REFERENCES `imagen` (`idImagen`);

--
-- Constraints for table `vid_pla`
--
ALTER TABLE `vid_pla`
  ADD CONSTRAINT `FK_JUE_PLA_JUE` FOREIGN KEY (`id_juego`) REFERENCES `videojuegos` (`idJuego`),
  ADD CONSTRAINT `FK_PLA_PLA_JUE` FOREIGN KEY (`id_plataforma`) REFERENCES `plataforma` (`idPlataforma`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
