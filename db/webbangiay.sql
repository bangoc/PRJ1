-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 05, 2017 at 03:38 PM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `webbangiay`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(10) NOT NULL,
  `username` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `username`, `password`) VALUES
(1, 'id', 'id');

-- --------------------------------------------------------

--
-- Table structure for table `donhang`
--

CREATE TABLE `donhang` (
  `iddonhang` int(50) NOT NULL,
  `iduser` int(10) NOT NULL,
  `hoten` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `phone` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `address` varchar(120) COLLATE utf8mb4_unicode_ci NOT NULL,
  `hinhthucthanhtoan` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `tongtien` int(20) NOT NULL,
  `id_thanhtoan` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `donhang`
--

INSERT INTO `donhang` (`iddonhang`, `iduser`, `hoten`, `phone`, `email`, `address`, `hinhthucthanhtoan`, `tongtien`, `id_thanhtoan`) VALUES
(12, 3, 'Ngô Thúy Hoa', '91234567', 'hoa@gmail.com', 'hà nam', 'khi nhận hàng', 2345, 0),
(14, 2, 'hoang minh duc', '95786432', 'hoangduc@gmail.com', 'ha nội', 'online', 2000, 1),
(15, 1, 'hoa', '961931696', 'hoa ngo 1048', 'ha nam', 'Thanh toán COD', 0, 1),
(16, 6, 'cường', '98762342', 'cuong@gmail.com', 'hà nội', 'khi nhận hàbg', 4000, 1),
(17, 6, 'bang', '113', 'bang@gmail.com', 'hn', 'Thanh toán COD', 6000, 1),
(18, 6, 'bang', '113', 'abc@gmail.com', 'hn', 'Thanh toán trực tuyến', 6000, 1),
(19, 7, 'ngo thuy hoa', '0961931696', 'hoa@gmail.com', 'hà nam', 'Thanh toán COD', 14000, 0);

-- --------------------------------------------------------

--
-- Table structure for table `loaisp`
--

CREATE TABLE `loaisp` (
  `idloaisp` int(10) NOT NULL,
  `loaisp` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `loaisp`
--

INSERT INTO `loaisp` (`idloaisp`, `loaisp`) VALUES
(1, 'Nam'),
(2, 'Nữ'),
(3, 'All');

-- --------------------------------------------------------

--
-- Table structure for table `qlchitietdonhang`
--

CREATE TABLE `qlchitietdonhang` (
  `STT` int(10) NOT NULL,
  `iddonhang` int(50) NOT NULL,
  `idsanpham` int(50) NOT NULL,
  `soluong` int(50) NOT NULL,
  `size` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `qlchitietdonhang`
--

INSERT INTO `qlchitietdonhang` (`STT`, `iddonhang`, `idsanpham`, `soluong`, `size`) VALUES
(18, 17, 37, 6, ''),
(19, 19, 39, 1, ''),
(20, 19, 36, 2, ''),
(21, 19, 37, 5, '');

-- --------------------------------------------------------

--
-- Table structure for table `sanpham`
--

CREATE TABLE `sanpham` (
  `idsanpham` int(50) NOT NULL,
  `tensanpham` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `gia` int(20) NOT NULL,
  `mota` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `hinhanh` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `soluong` int(50) NOT NULL,
  `mausac` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `xuatxu` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `size` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `idtenhang` int(10) NOT NULL,
  `idloaisp` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `sanpham`
--

INSERT INTO `sanpham` (`idsanpham`, `tensanpham`, `gia`, `mota`, `hinhanh`, `soluong`, `mausac`, `xuatxu`, `size`, `idtenhang`, `idloaisp`) VALUES
(36, 'fhffh', 1000, 'fhffh', 'adidas.jpg', 1, 'vcbc', 'cbcb', '25,26,27,28,29', 1, 3),
(37, 'giày thể thao', 2000, 'đẹp', 'giaypuma.jpg', 4, 'xanh', 'vn', '25,26,27,28,29', 2, 3),
(38, 'Giày cao gót', 3000, 'đẹp', 'caogot.jpg', 4, 'đỏ', 'vn', '25,26,27,28', 1, 3),
(39, 'giay nike', 2000, 'rất đẹp', 'giay nike.jpg', 5, 'đỏ', 'mỹ', '25,26,27,28,29', 1, 3);

-- --------------------------------------------------------

--
-- Table structure for table `tenhang`
--

CREATE TABLE `tenhang` (
  `idtenhang` int(10) NOT NULL,
  `tenhang` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `tenhang`
--

INSERT INTO `tenhang` (`idtenhang`, `tenhang`) VALUES
(1, 'Nike'),
(2, 'Puma'),
(3, 'Adidas'),
(4, 'Converse');

-- --------------------------------------------------------

--
-- Table structure for table `thanhtoan`
--

CREATE TABLE `thanhtoan` (
  `id_thanhtoan` int(10) NOT NULL,
  `thanhtoan` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `thanhtoan`
--

INSERT INTO `thanhtoan` (`id_thanhtoan`, `thanhtoan`) VALUES
(0, 'Chưa thanh toán'),
(1, 'Đã thanh toán');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `iduser` int(50) NOT NULL,
  `username` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `phone` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=COMPACT;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`iduser`, `username`, `password`, `phone`, `address`) VALUES
(3, 'bangte97', '123', '0', 'hn'),
(5, 'hoa', '123456', '961931696', 'ha nam'),
(6, 'bang', '123', '0', ''),
(7, 'ngohoa', '12345', '', 'hÃ  nam');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `donhang`
--
ALTER TABLE `donhang`
  ADD PRIMARY KEY (`iddonhang`);

--
-- Indexes for table `loaisp`
--
ALTER TABLE `loaisp`
  ADD PRIMARY KEY (`idloaisp`);

--
-- Indexes for table `qlchitietdonhang`
--
ALTER TABLE `qlchitietdonhang`
  ADD PRIMARY KEY (`STT`);

--
-- Indexes for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`idsanpham`);

--
-- Indexes for table `tenhang`
--
ALTER TABLE `tenhang`
  ADD PRIMARY KEY (`idtenhang`);

--
-- Indexes for table `thanhtoan`
--
ALTER TABLE `thanhtoan`
  ADD PRIMARY KEY (`id_thanhtoan`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`iduser`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `donhang`
--
ALTER TABLE `donhang`
  MODIFY `iddonhang` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
--
-- AUTO_INCREMENT for table `loaisp`
--
ALTER TABLE `loaisp`
  MODIFY `idloaisp` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `qlchitietdonhang`
--
ALTER TABLE `qlchitietdonhang`
  MODIFY `STT` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
--
-- AUTO_INCREMENT for table `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `idsanpham` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;
--
-- AUTO_INCREMENT for table `tenhang`
--
ALTER TABLE `tenhang`
  MODIFY `idtenhang` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `iduser` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
