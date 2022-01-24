-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 17, 2022 at 03:25 PM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.4.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cargo`
--

-- --------------------------------------------------------

--
-- Table structure for table `cargo`
--

CREATE TABLE `cargo` (
  `cargo_id` int(11) NOT NULL,
  `cargo_name` varchar(39) DEFAULT NULL,
  `cargo_item` int(11) DEFAULT NULL,
  `nkg` int(11) DEFAULT NULL,
  `Payment` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cargo`
--

INSERT INTO `cargo` (`cargo_id`, `cargo_name`, `cargo_item`, `nkg`, `Payment`) VALUES
(1, 'Computers', 22, 40, 616),
(2, 'bariis', 100, 500, 35000),
(3, 'bariis', 100, 700, 49000),
(4, 'pasto', 100, 500, 35000),
(5, 'cocacola', 800, 60, 33600),
(6, 'pipsi', 50, 60, 2100),
(7, 'Mango', 50, 60, 2100),
(9, 'bur ', 400, 234, 65519.99999999999),
(10, 'Saliid', 50000, 500, 17500000);

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `cust_id` int(12) NOT NULL,
  `cust_name` varchar(150) NOT NULL,
  `cust_tell` int(30) NOT NULL,
  `cust_address` varchar(250) NOT NULL,
  `Gender` varchar(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`cust_id`, `cust_name`, `cust_tell`, `cust_address`, `Gender`) VALUES
(1, 'ahmed', 61555444, 'howlwadaag', 'Select One'),
(2, 'Yasin', 61355566, 'waberi', 'female'),
(3, 'abdi', 556556, 'waberi', 'Female'),
(4, 'Yahye abdi', 614556556, 'Karaan', 'Male'),
(5, 'Farxiyo', 565665, 'Hargeysa', 'Female'),
(7, 'moo', 565665, 'guriceel', 'Female');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `emp_id` int(12) NOT NULL,
  `emp_name` varchar(250) NOT NULL,
  `emp_tell` varchar(250) NOT NULL,
  `emp_address` varchar(250) NOT NULL,
  `Gender` varchar(250) NOT NULL,
  `Salary` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`emp_id`, `emp_name`, `emp_tell`, `emp_address`, `Gender`, `Salary`) VALUES
(1, 'Eenow', '61533333', 'Hodan', 'Male', 500),
(2, 'abdirahman ahmed', '0615568434', 'howl-wadaag', 'male', 40),
(3, 'abdirahman  suleiman', '0615333322', 'howl-wadaag', 'Male', 40),
(4, 'Osama  suleiman', '061368434', 'Carafaat', 'Male', 120),
(5, 'abdirahman  yasin', '0615568434', 'howl-wadaag', 'Male', 33),
(6, 'mohamed  ', '0615568434', 'howl-wadaag', 'Male', 500),
(7, 'Mohamed ', '0615568434', 'howl-wadaag', 'Male', 7000),
(9, 'ahmed', '666666666', 'km4', 'Male', 20);

-- --------------------------------------------------------

--
-- Table structure for table `port`
--

CREATE TABLE `port` (
  `port_id` int(12) NOT NULL,
  `port_name` varchar(250) NOT NULL,
  `country` varchar(250) NOT NULL,
  `region` varchar(250) NOT NULL,
  `district` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `port`
--

INSERT INTO `port` (`port_id`, `port_name`, `country`, `region`, `district`) VALUES
(1, 'Berbeaa', 'Somalia', 'W/Galbeed', 'Berbera'),
(2, 'Mogadishu ', 'Somalia', 'Banaadir', 'Xamarjajab'),
(3, 'kismaayo', 'Somalia', 'J/Hoose', 'Kismaayo'),
(4, 'Mogadishu ', 'Somalia', 'Banaadir', 'Xamarjajab'),
(5, 'Mogadishu ', 'Somalia', 'Banaadir', 'Xamarjajab'),
(6, 'Mogadishu ', 'Somalia', 'Banaadir', 'Xamarjajab'),
(7, 'Mogadis', 'Somalia', 'Banaadir', 'Xamarjajab'),
(9, 'Mogadishu ', 'Somalia', 'Banaadir', 'Xamarjajab');

-- --------------------------------------------------------

--
-- Table structure for table `ship`
--

CREATE TABLE `ship` (
  `ship_id` int(12) NOT NULL,
  `ship_name` varchar(250) NOT NULL,
  `contact` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ship`
--

INSERT INTO `ship` (`ship_id`, `ship_name`, `contact`) VALUES
(1, 'ASLINE', '646454554'),
(2, 'AA', '654545'),
(3, 'Horn africa', '45544545'),
(4, 'Horn', '45544545'),
(5, 'Jubba', '45544545'),
(6, 'Yool', '45544545'),
(7, 'Jubba', '45544545'),
(8, 'Yool', '45544545'),
(9, 'ASLINE', '646454554'),
(11, 'jubba', '61565656');

-- --------------------------------------------------------

--
-- Table structure for table `shipment`
--

CREATE TABLE `shipment` (
  `shipment_id` int(12) NOT NULL,
  `port_Source` varchar(250) NOT NULL,
  `port_Distination` varchar(250) NOT NULL,
  `custID` int(11) NOT NULL,
  `shipID` int(11) NOT NULL,
  `empID` int(11) NOT NULL,
  `cargoID` int(11) NOT NULL,
  `portID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `shipment`
--

INSERT INTO `shipment` (`shipment_id`, `port_Source`, `port_Distination`, `custID`, `shipID`, `empID`, `cargoID`, `portID`) VALUES
(1, 'sss', 'ss', 1, 1, 1, 1, 1),
(2, 'mogadishu', 'bosaaso', 2, 2, 2, 2, 2),
(3, 'mogadishu', 'kismaayo', 3, 3, 3, 3, 3),
(4, 'kismaayo', 'mogadishu', 4, 4, 4, 4, 4),
(5, 'kismaayo', 'mogadishu', 5, 5, 5, 5, 5),
(7, 'bosaaso', 'mogadishu', 7, 7, 7, 7, 7),
(8, 'kismayo', 'muqdiso', 1, 2, 4, 3, 3);

-- --------------------------------------------------------

--
-- Table structure for table `shipments`
--

CREATE TABLE `shipments` (
  `shipment_id` int(12) NOT NULL,
  `source` varchar(250) NOT NULL,
  `destination` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `shipments`
--

INSERT INTO `shipments` (`shipment_id`, `source`, `destination`) VALUES
(1, 'Mogadishu', 'Berbera'),
(2, 'Kismaayo', 'Bosaaso'),
(4, 'Mogadishu', 'Berbera'),
(5, 'Kismaayo', 'Bosaaso'),
(6, 'mogadishu', 'Bosaaso'),
(8, 'Kismaayo', 'berbera'),
(9, 'bosaaso', 'mogadishu');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cargo`
--
ALTER TABLE `cargo`
  ADD PRIMARY KEY (`cargo_id`);

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`cust_id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`emp_id`);

--
-- Indexes for table `port`
--
ALTER TABLE `port`
  ADD PRIMARY KEY (`port_id`);

--
-- Indexes for table `ship`
--
ALTER TABLE `ship`
  ADD PRIMARY KEY (`ship_id`);

--
-- Indexes for table `shipment`
--
ALTER TABLE `shipment`
  ADD PRIMARY KEY (`shipment_id`),
  ADD KEY `shipment_fk_emp` (`empID`),
  ADD KEY `shipment_fk_cargo` (`cargoID`),
  ADD KEY `shipment_fk_custom` (`custID`),
  ADD KEY `shipment_fk_ship` (`shipID`),
  ADD KEY `shipment_fk_port` (`portID`);

--
-- Indexes for table `shipments`
--
ALTER TABLE `shipments`
  ADD PRIMARY KEY (`shipment_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `shipment`
--
ALTER TABLE `shipment`
  ADD CONSTRAINT `shipment_fk_cargo` FOREIGN KEY (`cargoID`) REFERENCES `cargo` (`cargo_id`),
  ADD CONSTRAINT `shipment_fk_custom` FOREIGN KEY (`custID`) REFERENCES `customers` (`cust_id`),
  ADD CONSTRAINT `shipment_fk_emp` FOREIGN KEY (`empID`) REFERENCES `employee` (`emp_id`),
  ADD CONSTRAINT `shipment_fk_port` FOREIGN KEY (`portID`) REFERENCES `port` (`port_id`),
  ADD CONSTRAINT `shipment_fk_ship` FOREIGN KEY (`shipID`) REFERENCES `ship` (`ship_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
