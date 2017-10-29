-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Oct 29, 2017 at 02:37 PM
-- Server version: 10.1.25-MariaDB
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `supermarket_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `account_tb`
--

CREATE TABLE `account_tb` (
  `id` int(11) NOT NULL,
  `user_name` varchar(200) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `account_tb`
--

INSERT INTO `account_tb` (`id`, `user_name`, `password`) VALUES
(1, 'minh1996bk', 'husterk59'),
(14, 'Nguyen Dinh Thang', 'Nguyen Dinh Thang'),
(15, 'Nguyen Thi Duyen', 'Nguyen Thi Duyen');

-- --------------------------------------------------------

--
-- Table structure for table `bill_tb`
--

CREATE TABLE `bill_tb` (
  `code_bill` int(11) NOT NULL,
  `id` int(11) DEFAULT NULL,
  `code` int(11) DEFAULT NULL,
  `amount` varchar(10) DEFAULT NULL,
  `time` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bill_tb`
--

INSERT INTO `bill_tb` (`code_bill`, `id`, `code`, `amount`, `time`) VALUES
(1, 1, 1, '1', '21-11-2017');

-- --------------------------------------------------------

--
-- Table structure for table `employeeinfo_tb`
--

CREATE TABLE `employeeinfo_tb` (
  `id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `ages` int(11) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `birth_date` varchar(20) DEFAULT NULL,
  `hire_date` varchar(20) DEFAULT NULL,
  `salary` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employeeinfo_tb`
--

INSERT INTO `employeeinfo_tb` (`id`, `name`, `ages`, `sex`, `birth_date`, `hire_date`, `salary`) VALUES
(1, 'Nguyen Dinh Minh', 20, 'nu', '20-11-1996', '20-11-2017', 10000),
(14, 'Nguyen Dinh Thang', 20, 'nam', '20-10-2030', '20-11-2059', 10000),
(15, 'Nguyen Thi Duyen', 20, 'nu', '20-10-1997', '20-10-2018', 10000);

-- --------------------------------------------------------

--
-- Table structure for table `goods_tb`
--

CREATE TABLE `goods_tb` (
  `code` int(11) NOT NULL,
  `name` varchar(200) DEFAULT NULL,
  `price` varchar(11) DEFAULT NULL,
  `producer` varchar(200) DEFAULT NULL,
  `produce_date` varchar(20) DEFAULT NULL,
  `expire_date` varchar(20) DEFAULT NULL,
  `remain_amount` int(11) DEFAULT NULL,
  `sold_amount` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `goods_tb`
--

INSERT INTO `goods_tb` (`code`, `name`, `price`, `producer`, `produce_date`, `expire_date`, `remain_amount`, `sold_amount`) VALUES
(1, 'pepsi', '10000', 'pesi Ltd', '20-11-2016', '20-11-2017', 0, 10),
(2, 'coca', '11000', 'coca Ltd', '20-11-2016', '20-11-2018', 2, 100),
(4, 'banh mi', '100', 'Quan banh', '20-11-2201', '22-11-2231', 10, 0),
(5, 'keo cay', '100', 'unknown', '20-11-2017', '20-11-2018', 10, 0);

-- --------------------------------------------------------

--
-- Table structure for table `import_bill_tb`
--

CREATE TABLE `import_bill_tb` (
  `code_import` int(11) NOT NULL,
  `id_nha_cung_cap` int(11) DEFAULT NULL,
  `code` int(11) DEFAULT NULL,
  `time` varchar(20) DEFAULT NULL,
  `sold_price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `import_bill_tb`
--

INSERT INTO `import_bill_tb` (`code_import`, `id_nha_cung_cap`, `code`, `time`, `sold_price`) VALUES
(1, 1, 1, '20-10-2017', 0),
(2, 2, 2, '02-11-2017', 0),
(3, 2, 5, '28-10-2017', 100);

-- --------------------------------------------------------

--
-- Table structure for table `nha_cung_cap_tb`
--

CREATE TABLE `nha_cung_cap_tb` (
  `id` int(11) NOT NULL,
  `name` varchar(200) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `mail` varchar(200) DEFAULT NULL,
  `phone_no` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `nha_cung_cap_tb`
--

INSERT INTO `nha_cung_cap_tb` (`id`, `name`, `address`, `mail`, `phone_no`) VALUES
(1, 'Pepsi Ltd', 'America', 'pepsi@mail.com', '001234567'),
(2, 'Coca Ltd', 'America', 'coca-cola@mail.com', '013423740'),
(3, 'ncc1', 'ha noi, viet nam', 'ncc1@mail.com', '015409234823');

-- --------------------------------------------------------

--
-- Table structure for table `save`
--

CREATE TABLE `save` (
  `check_save` varchar(11) NOT NULL,
  `user_name` varchar(200) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `save`
--

INSERT INTO `save` (`check_save`, `user_name`, `password`, `id`) VALUES
('1', 'minh1996bk', 'husterk59', 2);

-- --------------------------------------------------------

--
-- Table structure for table `work_time_tb`
--

CREATE TABLE `work_time_tb` (
  `id` int(11) NOT NULL,
  `begin_date` varchar(20) NOT NULL,
  `end_date` varchar(20) DEFAULT NULL,
  `session_count` int(10) DEFAULT NULL,
  `salary` int(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `work_time_tb`
--

INSERT INTO `work_time_tb` (`id`, `begin_date`, `end_date`, `session_count`, `salary`) VALUES
(1, '20-11-2017', '20-12-2017', 19, 300000),
(1, '21-01-2018', '25-10-2017', 10, 10000),
(1, '21-12-2017', '20-01-2018', 25, 500000),
(1, '25-10-2017', '29-10-2017', 0, 10000),
(1, '29-10-2017', '99-99-9999', 0, 10000),
(14, '25-10-2017', '99-99-9999', 0, 10000),
(14, '29-10-2017', '23-32-1323', 0, 10000),
(15, '25-10-2017', '29-10-2017', 0, 10000),
(15, '29-10-2017', '99-99-9999', 0, 10000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account_tb`
--
ALTER TABLE `account_tb`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `user_name` (`user_name`);

--
-- Indexes for table `bill_tb`
--
ALTER TABLE `bill_tb`
  ADD PRIMARY KEY (`code_bill`),
  ADD KEY `code` (`code`),
  ADD KEY `id` (`id`);

--
-- Indexes for table `employeeinfo_tb`
--
ALTER TABLE `employeeinfo_tb`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `goods_tb`
--
ALTER TABLE `goods_tb`
  ADD PRIMARY KEY (`code`);

--
-- Indexes for table `import_bill_tb`
--
ALTER TABLE `import_bill_tb`
  ADD PRIMARY KEY (`code_import`),
  ADD KEY `code` (`code`),
  ADD KEY `id_nha_cung_cap` (`id_nha_cung_cap`);

--
-- Indexes for table `nha_cung_cap_tb`
--
ALTER TABLE `nha_cung_cap_tb`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `save`
--
ALTER TABLE `save`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `work_time_tb`
--
ALTER TABLE `work_time_tb`
  ADD PRIMARY KEY (`id`,`begin_date`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bill_tb`
--
ALTER TABLE `bill_tb`
  MODIFY `code_bill` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `employeeinfo_tb`
--
ALTER TABLE `employeeinfo_tb`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `goods_tb`
--
ALTER TABLE `goods_tb`
  MODIFY `code` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `import_bill_tb`
--
ALTER TABLE `import_bill_tb`
  MODIFY `code_import` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `nha_cung_cap_tb`
--
ALTER TABLE `nha_cung_cap_tb`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `account_tb`
--
ALTER TABLE `account_tb`
  ADD CONSTRAINT `account_tb_ibfk_1` FOREIGN KEY (`id`) REFERENCES `employeeinfo_tb` (`id`);

--
-- Constraints for table `bill_tb`
--
ALTER TABLE `bill_tb`
  ADD CONSTRAINT `bill_tb_ibfk_1` FOREIGN KEY (`code`) REFERENCES `goods_tb` (`code`),
  ADD CONSTRAINT `bill_tb_ibfk_2` FOREIGN KEY (`id`) REFERENCES `employeeinfo_tb` (`id`);

--
-- Constraints for table `import_bill_tb`
--
ALTER TABLE `import_bill_tb`
  ADD CONSTRAINT `import_bill_tb_ibfk_1` FOREIGN KEY (`code`) REFERENCES `goods_tb` (`code`),
  ADD CONSTRAINT `import_bill_tb_ibfk_2` FOREIGN KEY (`id_nha_cung_cap`) REFERENCES `nha_cung_cap_tb` (`id`);

--
-- Constraints for table `work_time_tb`
--
ALTER TABLE `work_time_tb`
  ADD CONSTRAINT `work_time_tb_ibfk_1` FOREIGN KEY (`id`) REFERENCES `employeeinfo_tb` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
