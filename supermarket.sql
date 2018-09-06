-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 09, 2017 at 05:25 AM
-- Server version: 10.1.26-MariaDB
-- PHP Version: 7.1.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `supermarket`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `id_barang` int(20) NOT NULL,
  `nama_barang` varchar(20) NOT NULL,
  `harga_beli` int(20) NOT NULL,
  `harga_jual` int(11) NOT NULL,
  `expired` date NOT NULL,
  `stok` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`id_barang`, `nama_barang`, `harga_beli`, `harga_jual`, `expired`, `stok`) VALUES
(13, 'oreo', 8000, 8500, '2000-09-09', 35),
(15, 'aqua', 2500, 3000, '2000-09-09', 100),
(16, 'sari roti', 9000, 10000, '2000-09-09', 16);

-- --------------------------------------------------------

--
-- Table structure for table `karyawan`
--

CREATE TABLE `karyawan` (
  `id_karyawan` int(11) NOT NULL,
  `nama_karyawan` varchar(20) NOT NULL,
  `jabatan` varchar(20) NOT NULL,
  `ttl` date NOT NULL,
  `alamat` varchar(40) NOT NULL,
  `username` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `karyawan`
--

INSERT INTO `karyawan` (`id_karyawan`, `nama_karyawan`, `jabatan`, `ttl`, `alamat`, `username`, `password`) VALUES
(7, 'ybnunung', 'Manajer', '2000-02-02', 'bandung', 'yb', '123'),
(9, 'nia', 'Kasir', '2000-02-02', 'bandung', 'nia', '123'),
(10, 'Sari', 'Admin', '2000-02-02', 'cirebon', 'sari', '123');

-- --------------------------------------------------------

--
-- Table structure for table `order_barang`
--

CREATE TABLE `order_barang` (
  `id_order` int(11) NOT NULL,
  `id_karyawan` int(11) NOT NULL,
  `id_barang` int(11) NOT NULL,
  `id_supplier` int(11) NOT NULL,
  `tgl_order` date NOT NULL,
  `jumlah` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `order_barang`
--

INSERT INTO `order_barang` (`id_order`, `id_karyawan`, `id_barang`, `id_supplier`, `tgl_order`, `jumlah`) VALUES
(9, 9, 13, 9, '2017-08-01', 10),
(10, 9, 15, 9, '2017-09-05', 10),
(11, 9, 13, 9, '2017-09-05', 10),
(12, 9, 13, 9, '2017-07-10', 9),
(13, 9, 15, 9, '2017-09-05', 2),
(14, 9, 16, 9, '2017-06-12', 10),
(15, 9, 16, 9, '2017-09-05', 6);

--
-- Triggers `order_barang`
--
DELIMITER $$
CREATE TRIGGER `tambah_stok` AFTER INSERT ON `order_barang` FOR EACH ROW BEGIN
	UPDATE barang SET stok=stok+new.jumlah WHERE id_barang = new.id_barang;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `id_supplier` int(11) NOT NULL,
  `nama_supplier` varchar(20) NOT NULL,
  `alamat` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`id_supplier`, `nama_supplier`, `alamat`) VALUES
(9, 'uro', 'solo jateng');

-- --------------------------------------------------------

--
-- Table structure for table `temp_transaksi`
--

CREATE TABLE `temp_transaksi` (
  `id_transaksi` varchar(11) NOT NULL,
  `id_barang` int(11) NOT NULL,
  `id_karyawan` int(11) NOT NULL,
  `tgl` date NOT NULL,
  `jml` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `temp_transaksi`
--

INSERT INTO `temp_transaksi` (`id_transaksi`, `id_barang`, `id_karyawan`, `tgl`, `jml`) VALUES
('T1', 13, 9, '2017-09-05', 7),
('T7', 15, 7, '2017-09-05', 2),
('T6', 15, 7, '2017-11-05', 4),
('T5', 13, 7, '2017-12-06', 2),
('T5', 13, 7, '2017-12-06', 2);

--
-- Triggers `temp_transaksi`
--
DELIMITER $$
CREATE TRIGGER `kurang_stok` AFTER INSERT ON `temp_transaksi` FOR EACH ROW BEGIN
	UPDATE barang SET stok=stok-new.jml WHERE id_barang = new.id_barang;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `id_transaksi` varchar(20) NOT NULL,
  `id_barang` int(11) NOT NULL,
  `id_karyawan` int(11) NOT NULL,
  `tgl` date NOT NULL,
  `jml` int(11) NOT NULL,
  `total_harga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`id_transaksi`, `id_barang`, `id_karyawan`, `tgl`, `jml`, `total_harga`) VALUES
('T1', 13, 9, '2017-09-05', 7, 59500),
('T7', 15, 7, '2017-09-05', 2, 6000),
('T6', 15, 7, '2017-11-05', 4, 12000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`id_barang`);

--
-- Indexes for table `karyawan`
--
ALTER TABLE `karyawan`
  ADD PRIMARY KEY (`id_karyawan`);

--
-- Indexes for table `order_barang`
--
ALTER TABLE `order_barang`
  ADD PRIMARY KEY (`id_order`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`id_supplier`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `barang`
--
ALTER TABLE `barang`
  MODIFY `id_barang` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT for table `karyawan`
--
ALTER TABLE `karyawan`
  MODIFY `id_karyawan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `order_barang`
--
ALTER TABLE `order_barang`
  MODIFY `id_order` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `supplier`
--
ALTER TABLE `supplier`
  MODIFY `id_supplier` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
