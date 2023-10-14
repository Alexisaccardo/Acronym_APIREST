-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 14-10-2023 a las 15:38:59
-- Versión del servidor: 8.0.31
-- Versión de PHP: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `product_acronym`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `acronym`
--

DROP TABLE IF EXISTS `acronym`;
CREATE TABLE IF NOT EXISTS `acronym` (
  `id` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL,
  `expiration_days` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `acronym`
--

INSERT INTO `acronym` (`id`, `name`, `expiration_days`) VALUES
('123', 'JAC', 20);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `id` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL,
  `status` varchar(30) NOT NULL,
  `creation_date` varchar(30) NOT NULL,
  `name_acronym` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `product`
--

INSERT INTO `product` (`id`, `name`, `status`, `creation_date`, `name_acronym`) VALUES
('10065', 'Pc gamer MSI', 'inactivo', '2023-09-14T08:42:55.092833400', 'JAC'),
('1006560', 'Iphone 15pro', 'inactivo', '2023-09-14T09:16:49.276811400', 'JAC');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
