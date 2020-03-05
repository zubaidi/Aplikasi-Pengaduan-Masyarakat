-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 05, 2020 at 01:53 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_pengaduan`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbmasyarakat`
--

CREATE TABLE `tbmasyarakat` (
  `nik` int(16) NOT NULL,
  `nama` varchar(20) NOT NULL,
  `username` varchar(15) NOT NULL,
  `password` varchar(15) NOT NULL,
  `telp` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbmasyarakat`
--

INSERT INTO `tbmasyarakat` (`nik`, `nama`, `username`, `password`, `telp`) VALUES
(2147483647, 'Ninja Hatori', 'sasuke', 'sasuke', '085742605860');

-- --------------------------------------------------------

--
-- Table structure for table `tbpengaduan`
--

CREATE TABLE `tbpengaduan` (
  `id_pengaduan` int(11) NOT NULL,
  `tgl_pengaduan` date DEFAULT NULL,
  `nik` char(16) DEFAULT NULL,
  `isi_laporan` text DEFAULT NULL,
  `foto` varchar(255) DEFAULT NULL,
  `status` enum('0','Proses','Selesai') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbpengaduan`
--

INSERT INTO `tbpengaduan` (`id_pengaduan`, `tgl_pengaduan`, `nik`, `isi_laporan`, `foto`, `status`) VALUES
(752470002, '2020-02-28', '2147483647', 'laporan pertama saya gffhfgfh', 'template.png', 'Selesai'),
(754440003, '2020-02-28', '2147483647', 'laporan kedua saya', 'Desert.jpg', 'Proses');

-- --------------------------------------------------------

--
-- Table structure for table `tbpetugas`
--

CREATE TABLE `tbpetugas` (
  `id_petugas` int(11) NOT NULL,
  `nama_petugas` varchar(35) DEFAULT NULL,
  `username` varchar(25) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `telp` varchar(13) DEFAULT NULL,
  `level` enum('admin','petugas') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbpetugas`
--

INSERT INTO `tbpetugas` (`id_petugas`, `nama_petugas`, `username`, `password`, `telp`, `level`) VALUES
(1, 'admin', 'admin', 'admin', '088888888', 'admin'),
(2, 'arifin', 'petugas', 'petugas', '099999999', 'petugas'),
(3, 'arifin', 'arifin', 'arifin', '0888888877', 'petugas'),
(4, 'bejo', 'bejo', 'bejo', '8888585585', 'petugas');

-- --------------------------------------------------------

--
-- Table structure for table `tbtanggapan`
--

CREATE TABLE `tbtanggapan` (
  `id_tanggapan` int(11) NOT NULL,
  `id_pengaduan` int(11) DEFAULT NULL,
  `tgl_tanggapan` date DEFAULT NULL,
  `tanggapan` text DEFAULT NULL,
  `id_petugas` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbtanggapan`
--

INSERT INTO `tbtanggapan` (`id_tanggapan`, `id_pengaduan`, `tgl_tanggapan`, `tanggapan`, `id_petugas`) VALUES
(1001432, 752470002, '2020-03-01', 'oke masukan sangat bagus sekali', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbmasyarakat`
--
ALTER TABLE `tbmasyarakat`
  ADD PRIMARY KEY (`nik`);

--
-- Indexes for table `tbpengaduan`
--
ALTER TABLE `tbpengaduan`
  ADD PRIMARY KEY (`id_pengaduan`);

--
-- Indexes for table `tbpetugas`
--
ALTER TABLE `tbpetugas`
  ADD PRIMARY KEY (`id_petugas`);

--
-- Indexes for table `tbtanggapan`
--
ALTER TABLE `tbtanggapan`
  ADD PRIMARY KEY (`id_tanggapan`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
