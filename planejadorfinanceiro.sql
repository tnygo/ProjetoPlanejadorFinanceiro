-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 22/06/2023 às 03:55
-- Versão do servidor: 10.4.28-MariaDB
-- Versão do PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `planejadorfinanceiro`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `categoria`
--

CREATE TABLE `categoria` (
  `id` int(8) NOT NULL,
  `categoria` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Despejando dados para a tabela `categoria`
--

INSERT INTO `categoria` (`id`, `categoria`) VALUES
(44, 'Salário'),
(45, 'Venda'),
(46, 'Automóvel'),
(47, 'Educação'),
(48, 'Moradia'),
(49, 'Alimentação');

-- --------------------------------------------------------

--
-- Estrutura para tabela `despesas`
--

CREATE TABLE `despesas` (
  `despesa_id` int(11) NOT NULL,
  `despesa` varchar(64) NOT NULL,
  `categoria_id` int(11) NOT NULL,
  `mensal` double DEFAULT NULL,
  `ocasional` double DEFAULT NULL,
  `total_ano` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Despejando dados para a tabela `despesas`
--

INSERT INTO `despesas` (`despesa_id`, `despesa`, `categoria_id`, `mensal`, `ocasional`, `total_ano`) VALUES
(10, 'Combustível', 46, 800, 0, 9600),
(11, 'IPVA', 46, 0, 3500, 3500),
(12, 'Seguro', 46, 0, 4500, 4500),
(13, 'Mensalidade Escolar', 47, 2500, 0, 30000),
(14, 'Material Escolar', 47, 0, 1000, 1000),
(15, 'Aluguel', 48, 2500, 0, 30000),
(16, 'Mercado', 49, 1040, 0, 12480);

-- --------------------------------------------------------

--
-- Estrutura para tabela `fundo_ocasional`
--

CREATE TABLE `fundo_ocasional` (
  `fundo_ocasional_id` int(11) NOT NULL,
  `fundo_ocasional` varchar(64) NOT NULL,
  `mensal` double DEFAULT NULL,
  `ocasional` double DEFAULT NULL,
  `total_ano` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Despejando dados para a tabela `fundo_ocasional`
--

INSERT INTO `fundo_ocasional` (`fundo_ocasional_id`, `fundo_ocasional`, `mensal`, `ocasional`, `total_ano`) VALUES
(4, 'IPVA', 300, 0, 3600),
(5, 'Seguro', 375, 0, 4500),
(6, 'Material Escolar', 85, 0, 1020);

-- --------------------------------------------------------

--
-- Estrutura para tabela `investimento`
--

CREATE TABLE `investimento` (
  `investimento_id` int(11) NOT NULL,
  `investimento` varchar(64) NOT NULL,
  `mensal` double DEFAULT NULL,
  `ocasional` double DEFAULT NULL,
  `total_ano` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Despejando dados para a tabela `investimento`
--

INSERT INTO `investimento` (`investimento_id`, `investimento`, `mensal`, `ocasional`, `total_ano`) VALUES
(4, 'Poupança', 2200, 0, 26400),
(5, 'Poupança', 0, 7000, 7000);

-- --------------------------------------------------------

--
-- Estrutura para tabela `rendimento`
--

CREATE TABLE `rendimento` (
  `rendimento_id` int(8) NOT NULL,
  `rendimento` varchar(64) NOT NULL,
  `categoria_id` int(11) NOT NULL,
  `mensal` double DEFAULT NULL,
  `ocasional` double DEFAULT NULL,
  `total_ano` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Despejando dados para a tabela `rendimento`
--

INSERT INTO `rendimento` (`rendimento_id`, `rendimento`, `categoria_id`, `mensal`, `ocasional`, `total_ano`) VALUES
(7, 'Salário Mensal', 44, 10000, 0, 120000),
(8, '13º Salário', 44, 0, 8000, 8000),
(9, 'Férias', 44, 0, 8000, 8000),
(10, 'Notebook', 45, 0, 5000, 5000);

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `despesas`
--
ALTER TABLE `despesas`
  ADD PRIMARY KEY (`despesa_id`),
  ADD KEY `categoria_id_fk` (`categoria_id`);

--
-- Índices de tabela `fundo_ocasional`
--
ALTER TABLE `fundo_ocasional`
  ADD PRIMARY KEY (`fundo_ocasional_id`);

--
-- Índices de tabela `investimento`
--
ALTER TABLE `investimento`
  ADD PRIMARY KEY (`investimento_id`);

--
-- Índices de tabela `rendimento`
--
ALTER TABLE `rendimento`
  ADD PRIMARY KEY (`rendimento_id`),
  ADD KEY `categoria_id_fk` (`categoria_id`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;

--
-- AUTO_INCREMENT de tabela `despesas`
--
ALTER TABLE `despesas`
  MODIFY `despesa_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de tabela `fundo_ocasional`
--
ALTER TABLE `fundo_ocasional`
  MODIFY `fundo_ocasional_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela `investimento`
--
ALTER TABLE `investimento`
  MODIFY `investimento_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `rendimento`
--
ALTER TABLE `rendimento`
  MODIFY `rendimento_id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
