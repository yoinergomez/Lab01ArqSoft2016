-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 23-03-2016 a las 09:22:07
-- Versión del servidor: 5.5.47-0ubuntu0.14.04.1
-- Versión de PHP: 5.5.9-1ubuntu4.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `Lab01`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Cliente`
--

CREATE TABLE IF NOT EXISTS `Cliente` (
  `numeroDocumento` varchar(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `direccion` varchar(50) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`numeroDocumento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `TipoVehiculo`
--

CREATE TABLE IF NOT EXISTS `TipoVehiculo` (
  `id` varchar(10) NOT NULL,
  `marca` varchar(25) NOT NULL,
  `modelo` varchar(25) NOT NULL,
  `precio` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `imagen` longblob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Vehiculo`
--

CREATE TABLE IF NOT EXISTS `Vehiculo` (
  `placa` varchar(20) NOT NULL,
  `color` varchar(15) DEFAULT NULL,
  `tipoVehiculo` varchar(10) NOT NULL,
  `estado` int(1) NOT NULL,
  PRIMARY KEY (`placa`),
  KEY `tipoVehiculo` (`tipoVehiculo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Venta`
--

CREATE TABLE IF NOT EXISTS `Venta` (
  `fecha` date NOT NULL,
  `numeroDocumento` varchar(11) NOT NULL,
  `placa` varchar(20) NOT NULL,
  PRIMARY KEY (`numeroDocumento`,`placa`),
  KEY `placa` (`placa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `Vehiculo`
--
ALTER TABLE `Vehiculo`
  ADD CONSTRAINT `Vehiculo_ibfk_1` FOREIGN KEY (`tipoVehiculo`) REFERENCES `TipoVehiculo` (`id`);

--
-- Filtros para la tabla `Venta`
--
ALTER TABLE `Venta`
  ADD CONSTRAINT `Venta_ibfk_1` FOREIGN KEY (`placa`) REFERENCES `Vehiculo` (`placa`),
  ADD CONSTRAINT `Venta_ibfk_2` FOREIGN KEY (`numeroDocumento`) REFERENCES `Cliente` (`numeroDocumento`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
