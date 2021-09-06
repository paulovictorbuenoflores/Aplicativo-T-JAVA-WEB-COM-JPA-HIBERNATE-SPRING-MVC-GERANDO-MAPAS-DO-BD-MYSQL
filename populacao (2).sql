-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: 04-Mar-2020 às 16:53
-- Versão do servidor: 5.7.23
-- versão do PHP: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `populacao`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `estados`
--
DROP DATABASE IF EXISTS POPULACAO;
CREATE DATABASE POPULACAO;
USE POPULACAO;

DROP TABLE IF EXISTS `estados`;
CREATE TABLE IF NOT EXISTS `estados` (
  `codigo` char(4) NOT NULL,
  `nome` char(30) DEFAULT NULL,
  `populacao` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `estados`
--

INSERT INTO `estados` (`codigo`, `nome`, `populacao`) VALUES
('sp', 'São Paulo', 45919049),
('mg', 'Minas Gerais', 21168791),
('rj', 'Rio de Janeiro', 17264943),
('ba', 'Bahia', 14873064),
('pr', 'Paraná', 11433957),
('rs', 'Rio Grande do Sul', 11377239),
('pe', 'Pernambuco', 9557071),
('ce', ' Ceará', 9132078),
('pa', 'Pará', 8602865),
('sc', ' Santa Catarina', 716488),
('ma', 'Maranhão', 7075181),
('go', 'Goiás', 7018354),
('am', 'Amazonas', 4144597),
('es', 'Espírito Santo', 4018650),
('pb', 'Paraíba', 4018127),
('rn', 'Rio Grande do Norte', 3506853),
('mt', 'Mato Grosso', 3484466),
('al', 'Alagoas', 3337357),
('pi', 'Piauí', 3273227),
('df', 'Distrito Federal', 3015268),
('ms', 'Mato Grosso do Sul', 2778986),
('se', 'Sergipe', 2298696),
('ro', 'Rondônia', 1777225),
('to', 'Tocantins', 1572866),
('ac', 'Acre', 881935),
('ap', 'Amapá', 845731),
('rr', 'Roraima', 605761);

-- --------------------------------------------------------

--
-- Estrutura da tabela `gastos`
--

DROP TABLE IF EXISTS `gastos`;
CREATE TABLE IF NOT EXISTS `gastos` (
  `cidade` varchar(255) NOT NULL,
  `valor` decimal(10,0) NOT NULL,
  `empresa` varchar(255) NOT NULL,
  `estado` char(2) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `gastos`
--

INSERT INTO `gastos` (`cidade`, `valor`, `empresa`, `estado`, `id`) VALUES
('urutai', '100000', 'avex', 'go', 1),
('pires do rio', '416512', 'joa', 'go', 2),
('catalão', '321321321', 'aça', 'go', 3),
('uberlândia', '5132131', 'lal', 'mg', 4),
('uberaba', '321313213', 'lal', 'mg', 5),
('urutai', '321312', 'jax', 'go', 6),
('ipameri', '321313', 'jax', 'go', 7),
('ipameri', '6511321321', 'lal', 'go', 8),
('urutai', '50000', 'avax', 'go', 9),
('catalao', '4000000', 'avax', 'go', 10),
('rio de janeiro', '50000', 'avax', 'rj', 11),
('sao paulo', '4000000', 'joa', 'sp', 12),
('vitoria', '50000', 'avax', 'es', 13),
('salvador', '4000', 'avax', 'ba', 14),
('urutai', '50000', 'avax', 'go', 15),
('catalao', '400', 'avax', 'go', 16),
('dianópolis', '50000', 'avax', 'to', 17),
('flores', '4000', 'lal', 'go', 18),
('curitiba', '50000', 'avax', 'pr', 19),
('catalao', '40000', 'avax', 'go', 20),
('fortaleza', '50000', 'avax', 'ce', 21),
('catalao', '40000', 'avax', 'go', 22),
('urutai', '50000', 'avax', 'go', 23),
('ipameri', '400000', 'avax', 'go', 24),
('urutai', '50000', 'avax', 'go', 25),
('catalao', '400000', 'vox', 'go', 26);

-- --------------------------------------------------------

--
-- Estrutura da tabela `locais`
--

DROP TABLE IF EXISTS `locais`;
CREATE TABLE IF NOT EXISTS `locais` (
  `lat` decimal(8,4) NOT NULL,
  `lng` decimal(8,2) NOT NULL,
  PRIMARY KEY (`lat`,`lng`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `locais`
--

INSERT INTO `locais` (`lat`, `lng`) VALUES
('-30.0000', '100.00'),
('-25.0000', '130.00'),
('-24.0000', '80.00'),
('-23.0000', '-130.00'),
('-15.6000', '-47.28'),
('-15.4000', '-47.27'),
('-15.3000', '-47.58'),
('-15.1740', '-47.27'),
('-15.1740', '-47.17'),
('-15.1740', '-47.16'),
('-15.1400', '-47.16'),
('-15.1000', '-47.10'),
('-10.0000', '100.00');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
