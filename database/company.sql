-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Aug 24, 2021 at 05:48 PM
-- Server version: 5.7.31
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `company`
--

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
CREATE TABLE IF NOT EXISTS `employee` (
  `EmpID` varchar(100) NOT NULL,
  `EmpName` varchar(100) NOT NULL,
  `EmpSalary` varchar(100) NOT NULL,
  `EmpType` varchar(100) NOT NULL,
  PRIMARY KEY (`EmpID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`EmpID`, `EmpName`, `EmpSalary`, `EmpType`) VALUES
('E3', 'niroshan', '50000', 'Employee'),
('E2', 'hannah', '50000', 'Caretaker'),
('E1', 'malith', '80000', 'Manager');

-- --------------------------------------------------------

--
-- Table structure for table `empsalary`
--

DROP TABLE IF EXISTS `empsalary`;
CREATE TABLE IF NOT EXISTS `empsalary` (
  `SalID` varchar(100) NOT NULL,
  `EmpID` varchar(100) NOT NULL,
  `EmpName` varchar(100) NOT NULL,
  `EmpType` varchar(100) NOT NULL,
  `SalTotal` varchar(100) NOT NULL,
  `Allowance` varchar(100) NOT NULL,
  `date` timestamp(6) NOT NULL,
  PRIMARY KEY (`SalID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `empsalary`
--

INSERT INTO `empsalary` (`SalID`, `EmpID`, `EmpName`, `EmpType`, `SalTotal`, `Allowance`, `date`) VALUES
('S5', 'E3', 'niroshan', 'Employee', '140000.0', '50000', '2021-08-24 17:34:29.795000'),
('S4', 'E1', 'malith', 'Manager', '150000.0', '20000', '2021-08-24 17:25:43.350000'),
('S3', 'E2', 'hannah', 'Caretaker', '78000.0', '10000', '2021-08-24 17:20:17.475000'),
('S2', 'E2', 'hannah', 'Caretaker', '60000.0', '10000', '2021-08-24 17:16:33.079000'),
('S1', 'E1', 'malith', 'Manager', '150000.0', '20000', '2021-08-24 15:46:08.686000');

-- --------------------------------------------------------

--
-- Table structure for table `emptype`
--

DROP TABLE IF EXISTS `emptype`;
CREATE TABLE IF NOT EXISTS `emptype` (
  `EmpTypeID` varchar(100) NOT NULL,
  `EmpTypeName` varchar(100) NOT NULL,
  `EmpTypeSalary` varchar(100) NOT NULL,
  PRIMARY KEY (`EmpTypeID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `emptype`
--

INSERT INTO `emptype` (`EmpTypeID`, `EmpTypeName`, `EmpTypeSalary`) VALUES
('T3', 'Employee', '60000'),
('T2', 'Caretaker', '50000'),
('E1', 'Manager', '80000');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `FirstName` varchar(100) NOT NULL,
  `LastName` varchar(100) NOT NULL,
  `NIC` varchar(100) NOT NULL,
  `UserName` varchar(100) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `Telephone` varchar(100) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`FirstName`, `LastName`, `NIC`, `UserName`, `Password`, `Telephone`) VALUES
('Malith', 'Wijayathunga', '983472516v', 'malith', '12345', '0777599585');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
