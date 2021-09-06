-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: 19-Nov-2019 às 12:42
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
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
