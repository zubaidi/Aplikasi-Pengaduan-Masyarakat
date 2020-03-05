-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Feb 09, 2020 at 12:04 AM
-- Server version: 5.5.16
-- PHP Version: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `db_pengaduan`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbmasyarakat`
--

CREATE TABLE IF NOT EXISTS `tbmasyarakat` (
  `nik` char(16) NOT NULL,
  `nama` varchar(35) DEFAULT NULL,
  `username` varchar(25) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `telp` varchar(13) DEFAULT NULL,
  PRIMARY KEY (`nik`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbmasyarakat`
--

INSERT INTO `tbmasyarakat` (`nik`, `nama`, `username`, `password`, `telp`) VALUES
('332101010110001', 'Ninja Hatori', 'sasuke', 'sasuke', '085742605860');

-- --------------------------------------------------------

--
-- Table structure for table `tbpengaduan`
--

CREATE TABLE IF NOT EXISTS `tbpengaduan` (
  `id_pengaduan` int(11) NOT NULL,
  `tgl_pengaduan` date DEFAULT NULL,
  `nik` char(16) DEFAULT NULL,
  `isi_laporan` text,
  `foto` varchar(255) DEFAULT NULL,
  `status` enum('0','Proses','Selesai') DEFAULT NULL,
  PRIMARY KEY (`id_pengaduan`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbpengaduan`
--

INSERT INTO `tbpengaduan` (`id_pengaduan`, `tgl_pengaduan`, `nik`, `isi_laporan`, `foto`, `status`) VALUES
(758170001, '2020-02-06', '332101010110001', 'Contoh laporan', 'class.jpg', 'Proses');

-- --------------------------------------------------------

--
-- Table structure for table `tbpetugas`
--

CREATE TABLE IF NOT EXISTS `tbpetugas` (
  `id_petugas` int(11) NOT NULL,
  `nama_petugas` varchar(35) DEFAULT NULL,
  `username` varchar(25) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `telp` varchar(13) DEFAULT NULL,
  `level` enum('admin','petugas') DEFAULT NULL,
  PRIMARY KEY (`id_petugas`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbtanggapan`
--

CREATE TABLE IF NOT EXISTS `tbtanggapan` (
  `id_tanggapan` int(11) NOT NULL,
  `id_pengaduan` int(11) DEFAULT NULL,
  `tgl_tanggapan` date DEFAULT NULL,
  `tanggapan` text,
  `id_petugas` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_tanggapan`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
