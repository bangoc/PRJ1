-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Nov 08, 2017 at 04:34 PM
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
-- Database: `supermarket`
--
create database supermarket;
use supermarket;
-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `id_employee` int(11) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`id_employee`, `user_name`, `password`) VALUES
(1, 'minh1996bk', 'husterk59');

-- --------------------------------------------------------

--
-- Table structure for table `costs_incurred`
--

CREATE TABLE `costs_incurred` (
  `id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `total` int(11) NOT NULL,
  `paid_date` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `costs_incurred`
--

INSERT INTO `costs_incurred` (`id`, `name`, `total`, `paid_date`) VALUES
(1, 'tien dien', 100000, '06/20/2017'),
(2, 'tien dien', 100000, '07/24/2017');

-- --------------------------------------------------------

--
-- Table structure for table `default_salary`
--

CREATE TABLE `default_salary` (
  `default_salary` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `sex` varchar(10) NOT NULL,
  `birth_date` varchar(11) NOT NULL,
  `address` varchar(200) NOT NULL,
  `phone_no` varchar(20) NOT NULL,
  `coefficient_salary` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id`, `name`, `sex`, `birth_date`, `address`, `phone_no`, `coefficient_salary`) VALUES
(1, 'Nguyen Dinh Minh', 'nam', '28/09/1996', 'phung chau - chuong my - ha noi', '0974066924', 10),
(2, 'Nguyen Dinh Thang', 'nam', '20/10/1997', 'ha noi', '0163258320', 11),
(3, 'Nguyen Dinh Minh', 'nam', '28/09/1996', 'phung chau - chuong my - ha noi', '0974066924', 10),
(4, 'Nguyen Dinh Thang', 'nam', '20/10/1997', 'Ha noi', '10392023', 10),
(5, 'aa', 'nam', '06/33/2017', 'adafsfas', '030304309', 10),
(6, 'minh', 'nam', '06/47/2017', 'ha noi', '0101010', 10);

-- --------------------------------------------------------

--
-- Table structure for table `employee_manager`
--

CREATE TABLE `employee_manager` (
  `id_manager` int(11) NOT NULL,
  `commission` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee_manager`
--

INSERT INTO `employee_manager` (`id_manager`, `commission`) VALUES
(1, 10000000),
(6, 100000);

-- --------------------------------------------------------

--
-- Table structure for table `employee_salesman`
--

CREATE TABLE `employee_salesman` (
  `id_salesman` int(11) NOT NULL,
  `subsidy` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee_salesman`
--

INSERT INTO `employee_salesman` (`id_salesman`, `subsidy`) VALUES
(2, 10000000);

-- --------------------------------------------------------

--
-- Table structure for table `export_receipt`
--

CREATE TABLE `export_receipt` (
  `id_receipt` int(11) NOT NULL,
  `id_product` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `export_receipt`
--

INSERT INTO `export_receipt` (`id_receipt`, `id_product`, `amount`, `price`) VALUES
(1, 3, 2, 100000),
(1, 4, 2, 5000),
(3, 5, 2, 111),
(4, 1, 2, 22222),
(4, 2, 2, 10000);

-- --------------------------------------------------------

--
-- Table structure for table `import_receipt`
--

CREATE TABLE `import_receipt` (
  `id_receipt` int(11) NOT NULL,
  `id_product` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `market`
--

CREATE TABLE `market` (
  `name` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `price` int(11) NOT NULL,
  `producer` varchar(200) NOT NULL,
  `produce_date` varchar(11) NOT NULL,
  `expire_date` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `name`, `price`, `producer`, `produce_date`, `expire_date`) VALUES
(1, 'banh my', 100000, 'thanh ha', '21/11/2017', '21/12/2017'),
(2, 'sfasdf', 10000, 'sfasfa', '06/14/2017', '06/14/2017'),
(3, 'banh my', 100000, 'thanh ha', '21/11/2017', '21/12/2017'),
(4, 'sfasdf', 10000, 'sfasfa', '06/14/2017', '06/14/2017'),
(5, 'sfasdf', 10000, 'sfasfa', '06/14/2017', '06/14/2017');

-- --------------------------------------------------------

--
-- Table structure for table `receipt_manager_supplier`
--

CREATE TABLE `receipt_manager_supplier` (
  `id_receipt` int(11) NOT NULL,
  `id_manager` int(11) NOT NULL,
  `id_supplier` int(11) NOT NULL,
  `date` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `receipt_salesman`
--

CREATE TABLE `receipt_salesman` (
  `id_receipt` int(11) NOT NULL,
  `id_salesman` int(11) NOT NULL,
  `date` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `receipt_salesman`
--

INSERT INTO `receipt_salesman` (`id_receipt`, `id_salesman`, `date`) VALUES
(1, 2, '07/35/2017'),
(2, 2, '08/18/2017'),
(3, 2, '08/21/2017'),
(4, 2, '08/29/2017');

-- --------------------------------------------------------

--
-- Table structure for table `save`
--

CREATE TABLE `save` (
  `check_save` int(11) NOT NULL,
  `user_name` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `save`
--

INSERT INTO `save` (`check_save`, `user_name`, `password`, `id`) VALUES
(1, 'minh1996bk', 'husterk59', 2);

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `address` varchar(200) NOT NULL,
  `mail` varchar(200) NOT NULL,
  `phone_no` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`id`, `name`, `address`, `mail`, `phone_no`) VALUES
(1, 'sfasd', 'sdfasf', 'sdfasd', 'sdfsfs'),
(2, 'ncc1', 'america', 'maicc', '2190'),
(3, 'ncsdaf', 'sfajl', 'dlfjsal', 'ldljfsslfj');

-- --------------------------------------------------------

--
-- Table structure for table `work_history`
--

CREATE TABLE `work_history` (
  `id_employee` int(11) NOT NULL,
  `paid_date` varchar(11) NOT NULL,
  `salary` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id_employee`);

--
-- Indexes for table `costs_incurred`
--
ALTER TABLE `costs_incurred`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `default_salary`
--
ALTER TABLE `default_salary`
  ADD PRIMARY KEY (`default_salary`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `employee_manager`
--
ALTER TABLE `employee_manager`
  ADD PRIMARY KEY (`id_manager`);

--
-- Indexes for table `employee_salesman`
--
ALTER TABLE `employee_salesman`
  ADD PRIMARY KEY (`id_salesman`);

--
-- Indexes for table `export_receipt`
--
ALTER TABLE `export_receipt`
  ADD PRIMARY KEY (`id_receipt`,`id_product`),
  ADD KEY `id_product` (`id_product`);

--
-- Indexes for table `import_receipt`
--
ALTER TABLE `import_receipt`
  ADD PRIMARY KEY (`id_receipt`,`id_product`),
  ADD KEY `id_product` (`id_product`);

--
-- Indexes for table `market`
--
ALTER TABLE `market`
  ADD PRIMARY KEY (`name`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `receipt_manager_supplier`
--
ALTER TABLE `receipt_manager_supplier`
  ADD PRIMARY KEY (`id_receipt`),
  ADD KEY `id_manager` (`id_manager`),
  ADD KEY `id_supplier` (`id_supplier`);

--
-- Indexes for table `receipt_salesman`
--
ALTER TABLE `receipt_salesman`
  ADD PRIMARY KEY (`id_receipt`),
  ADD KEY `id_salesman` (`id_salesman`);

--
-- Indexes for table `save`
--
ALTER TABLE `save`
  ADD PRIMARY KEY (`check_save`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `work_history`
--
ALTER TABLE `work_history`
  ADD PRIMARY KEY (`id_employee`,`paid_date`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `costs_incurred`
--
ALTER TABLE `costs_incurred`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `receipt_manager_supplier`
--
ALTER TABLE `receipt_manager_supplier`
  MODIFY `id_receipt` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `receipt_salesman`
--
ALTER TABLE `receipt_salesman`
  MODIFY `id_receipt` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `supplier`
--
ALTER TABLE `supplier`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `account`
--
ALTER TABLE `account`
  ADD CONSTRAINT `account_ibfk_1` FOREIGN KEY (`id_employee`) REFERENCES `employee` (`id`),
  ADD CONSTRAINT `out_key` FOREIGN KEY (`id_employee`) REFERENCES `employee` (`id`);

--
-- Constraints for table `employee_manager`
--
ALTER TABLE `employee_manager`
  ADD CONSTRAINT `employee_manager_ibfk_1` FOREIGN KEY (`id_manager`) REFERENCES `employee` (`id`);

--
-- Constraints for table `employee_salesman`
--
ALTER TABLE `employee_salesman`
  ADD CONSTRAINT `employee_salesman_ibfk_1` FOREIGN KEY (`id_salesman`) REFERENCES `employee` (`id`);

--
-- Constraints for table `export_receipt`
--
ALTER TABLE `export_receipt`
  ADD CONSTRAINT `export_receipt_ibfk_1` FOREIGN KEY (`id_receipt`) REFERENCES `receipt_salesman` (`id_receipt`),
  ADD CONSTRAINT `export_receipt_ibfk_2` FOREIGN KEY (`id_product`) REFERENCES `product` (`id`);

--
-- Constraints for table `import_receipt`
--
ALTER TABLE `import_receipt`
  ADD CONSTRAINT `import_receipt_ibfk_1` FOREIGN KEY (`id_receipt`) REFERENCES `receipt_manager_supplier` (`id_receipt`),
  ADD CONSTRAINT `import_receipt_ibfk_2` FOREIGN KEY (`id_product`) REFERENCES `product` (`id`);

--
-- Constraints for table `receipt_manager_supplier`
--
ALTER TABLE `receipt_manager_supplier`
  ADD CONSTRAINT `receipt_manager_supplier_ibfk_1` FOREIGN KEY (`id_manager`) REFERENCES `employee_manager` (`id_manager`),
  ADD CONSTRAINT `receipt_manager_supplier_ibfk_2` FOREIGN KEY (`id_supplier`) REFERENCES `supplier` (`id`);

--
-- Constraints for table `receipt_salesman`
--
ALTER TABLE `receipt_salesman`
  ADD CONSTRAINT `receipt_salesman_ibfk_1` FOREIGN KEY (`id_salesman`) REFERENCES `employee_salesman` (`id_salesman`);

--
-- Constraints for table `work_history`
--
ALTER TABLE `work_history`
  ADD CONSTRAINT `work_history_ibfk_1` FOREIGN KEY (`id_employee`) REFERENCES `employee` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
