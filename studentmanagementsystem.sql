-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 17, 2016 at 04:43 AM
-- Server version: 5.6.24
-- PHP Version: 5.5.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `studentmanagementsystem`
--
CREATE DATABASE IF NOT EXISTS `studentmanagementsystem` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `studentmanagementsystem`;

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE IF NOT EXISTS `student` (
  `id` int(11) NOT NULL,
  `stid` varchar(80) DEFAULT NULL,
  `firstname` varchar(80) DEFAULT NULL,
  `lastname` varchar(80) DEFAULT NULL,
  `course` varchar(80) DEFAULT NULL,
  `section` varchar(80) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`id`, `stid`, `firstname`, `lastname`, `course`, `section`) VALUES
(6, 'a1', 'Rabindra', 'Dahal', 'CSIT', 'A'),
(7, 'a2', 'Ramesh', 'Panta', 'CSIT', 'A'),
(8, 'a3', 'Mohan', 'Sharma', 'CSIT', 'A'),
(10, '56', 'Rabin', 'Dahal', 'abc', '123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
