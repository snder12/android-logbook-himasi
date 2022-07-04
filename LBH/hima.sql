-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jul 04, 2022 at 09:08 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hima`
--

-- --------------------------------------------------------

--
-- Table structure for table `anggota`
--

CREATE TABLE `anggota` (
  `no_anggota` varchar(5) NOT NULL,
  `npm` varchar(10) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `no_hp` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `anggota`
--

INSERT INTO `anggota` (`no_anggota`, `npm`, `nama`, `no_hp`) VALUES
('A-001', '111001', 'Kevin', '081234567890'),
('A-002', '111002', 'Mustadi', '081234567891'),
('A-003', '111003', 'Judi', '081234567892'),
('A-004', '111004', 'Junaidi', '123456');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `no_hp` varchar(255) NOT NULL,
  `jenis_kelamin` varchar(255) NOT NULL,
  `angkatan` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `email`, `password`, `no_hp`, `jenis_kelamin`, `angkatan`) VALUES
(38, 'sandi', 'sandi123@gmail.com', '$2y$10$xnbg3SnJfbW3z2OebRt4gOUVuDwWZjaXFcuPUNdgZkJDHBs7Y2GIi', '123456', 'LK', '2019'),
(39, 'sandi', 'sandi123@gmail.com', '$2y$10$9sY67IbCFDeoWLKtF5A7KuOWxR/wYJROHteceifgTKft7gXGuHUiW', '123456', 'LK', '2019'),
(40, 'sandi1', 'sandie@gmail.com', '$2y$10$hgIKxWGEzTjRAGkp1S7/TOaMFs5aMqCZTlksleSFWeDDCnNJts/I.', '1', '1', '2019'),
(41, 'budi', 'budi@gmail.com', '$2y$10$.OXlTMQ9/pM3d4Qq2BZ/g.m64lTdp.RELijK/6voFeOnRX8.qefu.', '1', '1', '2019');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `anggota`
--
ALTER TABLE `anggota`
  ADD PRIMARY KEY (`no_anggota`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
