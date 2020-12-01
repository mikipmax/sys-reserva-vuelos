-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-11-2020 a las 07:21:25
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sys-reserva-vuelos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id_cliente` int(20) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `edad` int(11) DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL,
  `direccion` varchar(50) DEFAULT NULL,
  `ruc` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id_cliente`, `nombre`, `apellido`, `edad`, `telefono`, `direccion`, `ruc`) VALUES
(7, 'Michael', 'Ponce', 24, 993085894, 'Cotocollao1', '1312960444'),
(11, 'Tania', 'Rea', 33, 999999999, 'Chillogallo', '17058457401'),
(12, 'Fred', 'Cevallos', 19, 987154515, 'Av Maestro', '17505457123'),
(13, 'Rafael', 'Cedeño', 22, 998715423, 'San Diego', '1725522211'),
(14, 'Beatriz', 'Salinas', 29, 975515110, '20 de mayo', '1312124547'),
(15, 'Betsy', 'Chalacan', 35, 99406055, 'Real Audicencia', '17854415612'),
(16, 'Raul', 'Mendoza', 17, 97895221, 'Las Lomas', '140547123'),
(17, 'Lourdes', 'Cayambe', 22, 98751278, 'Conocoto', '178951321');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compania`
--

CREATE TABLE `compania` (
  `id_compania` int(20) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `direccion` varchar(50) DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL,
  `ruc` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `compania`
--

INSERT INTO `compania` (`id_compania`, `nombre`, `direccion`, `telefono`, `ruc`) VALUES
(5, 'Tame', 'Norte-Centro', 25345654, '125454855455'),
(7, 'Aerogal', 'Sur', 251345857, '1121241315'),
(8, 'Internacional', 'Quitumbe', 231254546, '1958515151');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `destino`
--

CREATE TABLE `destino` (
  `id_destino` int(20) NOT NULL,
  `n_aeropuerto` varchar(50) NOT NULL,
  `ciudad` varchar(50) NOT NULL,
  `cod_ciudad` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `destino`
--

INSERT INTO `destino` (`id_destino`, `n_aeropuerto`, `ciudad`, `cod_ciudad`) VALUES
(5, 'Aeropuerto Eloy Alfaro', 'Manta', 'ant-01'),
(6, 'Aeropuerto N-S', 'Cuenca', 'unc-01'),
(7, 'Aeropuerto Quitumbe', 'Quito', 'uio-01'),
(8, 'Aeropuerto Sur', 'Quito', 'uio-02');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `itinerario`
--

CREATE TABLE `itinerario` (
  `id_itinerario` int(20) NOT NULL,
  `id_origen` int(20) NOT NULL,
  `id_destino` int(20) NOT NULL,
  `hora` time NOT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `itinerario`
--

INSERT INTO `itinerario` (`id_itinerario`, `id_origen`, `id_destino`, `hora`, `fecha`) VALUES
(23, 5, 5, '23:15:00', '2020-11-18'),
(24, 5, 5, '11:50:00', '2020-11-16'),
(25, 5, 6, '07:00:00', '2020-11-30'),
(26, 9, 7, '09:10:00', '2020-11-26'),
(27, 8, 8, '13:20:00', '2020-11-27'),
(28, 9, 8, '19:15:00', '2020-11-30');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `login`
--

CREATE TABLE `login` (
  `id_login` int(20) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `password` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `login`
--

INSERT INTO `login` (`id_login`, `usuario`, `password`) VALUES
(10, 'admin', 'admin'),
(11, 'mikipmax', 'admin'),
(12, 'invitado', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `origen`
--

CREATE TABLE `origen` (
  `id_origen` int(20) NOT NULL,
  `n_aeropuerto` varchar(50) NOT NULL,
  `ciudad` varchar(50) NOT NULL,
  `cod_ciudad` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `origen`
--

INSERT INTO `origen` (`id_origen`, `n_aeropuerto`, `ciudad`, `cod_ciudad`) VALUES
(5, 'Aeropuerto Quitumbe', 'Quito', 'uio-01'),
(7, 'Aeropuerto Sur', 'Quito', 'uio-02'),
(8, 'Aeropuerto N-S', 'Cuenca', 'unc-01'),
(9, 'Aeropuerto Eloy Alfaro', 'Manta', 'ant-01');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pasaje`
--

CREATE TABLE `pasaje` (
  `id_pasaje` bigint(20) UNSIGNED NOT NULL,
  `id_cliente` int(20) NOT NULL,
  `id_vuelo` int(20) NOT NULL,
  `asiento` varchar(50) NOT NULL,
  `clase` varchar(50) NOT NULL,
  `valor` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pasaje`
--

INSERT INTO `pasaje` (`id_pasaje`, `id_cliente`, `id_vuelo`, `asiento`, `clase`, `valor`) VALUES
(4, 7, 7, 'A-11', 'Primera Clase', '800'),
(5, 7, 22, 'G-15', 'Primera Clase', '750'),
(6, 11, 19, 'B-13', 'Segunda Clase', '500'),
(7, 12, 19, 'C-02', 'Segunda Clase', '500'),
(8, 13, 21, 'A-05', 'Segunda Clase', '400');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vuelo`
--

CREATE TABLE `vuelo` (
  `id_vuelo` int(20) NOT NULL,
  `id_compania` int(20) NOT NULL,
  `id_itinerario` int(20) NOT NULL,
  `capacidad` int(11) NOT NULL,
  `modelo_avion` varchar(50) NOT NULL,
  `numero_vuelo` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `vuelo`
--

INSERT INTO `vuelo` (`id_vuelo`, `id_compania`, `id_itinerario`, `capacidad`, `modelo_avion`, `numero_vuelo`) VALUES
(7, 5, 23, 200, 'Md-09', 'L-08'),
(19, 5, 24, 180, 'Sm-07', 'L-05'),
(21, 7, 25, 250, 'Big-09', 'L-010'),
(22, 5, 26, 150, 'Sm-05', 'L-01'),
(23, 7, 27, 260, 'Big-010', 'L-015'),
(24, 7, 28, 200, 'Big-011', 'L-018'),
(25, 8, 23, 300, 'Big-015', 'L-07');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id_cliente`),
  ADD UNIQUE KEY `id_cliente` (`id_cliente`);

--
-- Indices de la tabla `compania`
--
ALTER TABLE `compania`
  ADD PRIMARY KEY (`id_compania`),
  ADD UNIQUE KEY `id_compania` (`id_compania`);

--
-- Indices de la tabla `destino`
--
ALTER TABLE `destino`
  ADD PRIMARY KEY (`id_destino`),
  ADD UNIQUE KEY `id_destino` (`id_destino`);

--
-- Indices de la tabla `itinerario`
--
ALTER TABLE `itinerario`
  ADD PRIMARY KEY (`id_itinerario`),
  ADD UNIQUE KEY `id_itinerario` (`id_itinerario`),
  ADD KEY `id_origen` (`id_origen`),
  ADD KEY `hora` (`hora`),
  ADD KEY `fk_id_destino` (`id_destino`);

--
-- Indices de la tabla `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id_login`),
  ADD UNIQUE KEY `id_login` (`id_login`);

--
-- Indices de la tabla `origen`
--
ALTER TABLE `origen`
  ADD PRIMARY KEY (`id_origen`),
  ADD UNIQUE KEY `id_origen` (`id_origen`);

--
-- Indices de la tabla `pasaje`
--
ALTER TABLE `pasaje`
  ADD PRIMARY KEY (`id_pasaje`),
  ADD UNIQUE KEY `id_pasaje` (`id_pasaje`),
  ADD KEY `id_cliente` (`id_cliente`),
  ADD KEY `id_vuelo` (`id_vuelo`);

--
-- Indices de la tabla `vuelo`
--
ALTER TABLE `vuelo`
  ADD PRIMARY KEY (`id_vuelo`),
  ADD UNIQUE KEY `id_vuelo` (`id_vuelo`),
  ADD KEY `id_compania` (`id_compania`),
  ADD KEY `id_itinerario` (`id_itinerario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id_cliente` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de la tabla `compania`
--
ALTER TABLE `compania`
  MODIFY `id_compania` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `destino`
--
ALTER TABLE `destino`
  MODIFY `id_destino` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `itinerario`
--
ALTER TABLE `itinerario`
  MODIFY `id_itinerario` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT de la tabla `login`
--
ALTER TABLE `login`
  MODIFY `id_login` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `origen`
--
ALTER TABLE `origen`
  MODIFY `id_origen` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `pasaje`
--
ALTER TABLE `pasaje`
  MODIFY `id_pasaje` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `vuelo`
--
ALTER TABLE `vuelo`
  MODIFY `id_vuelo` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `itinerario`
--
ALTER TABLE `itinerario`
  ADD CONSTRAINT `fk_id_destino` FOREIGN KEY (`id_destino`) REFERENCES `destino` (`id_destino`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_id_origen` FOREIGN KEY (`id_origen`) REFERENCES `origen` (`id_origen`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `pasaje`
--
ALTER TABLE `pasaje`
  ADD CONSTRAINT `fk_id_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_id_vuelo` FOREIGN KEY (`id_vuelo`) REFERENCES `vuelo` (`id_vuelo`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `vuelo`
--
ALTER TABLE `vuelo`
  ADD CONSTRAINT `fk_id_compania` FOREIGN KEY (`id_compania`) REFERENCES `compania` (`id_compania`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_id_itinerario` FOREIGN KEY (`id_itinerario`) REFERENCES `itinerario` (`id_itinerario`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
