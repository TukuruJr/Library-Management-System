-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jul 10, 2022 at 05:28 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library`
--

-- --------------------------------------------------------

--
-- Table structure for table `admins`
--

CREATE TABLE `admins` (
  `idno` int(100) NOT NULL,
  `username` text NOT NULL,
  `fullname` text NOT NULL,
  `mobile` text NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `location` text NOT NULL,
  `qualification` text NOT NULL,
  `date_employed` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admins`
--

INSERT INTO `admins` (`idno`, `username`, `fullname`, `mobile`, `email`, `password`, `location`, `qualification`, `date_employed`) VALUES
(1234, 'franc', 'francis', '+22474884', 'demo@gmail.com', 'pass', 'kagumo', 'BSc.', '22/11/1122');

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `ISBN` varchar(100) NOT NULL,
  `bookname` text NOT NULL,
  `writer` text NOT NULL,
  `publisher` text NOT NULL,
  `edition` int(100) NOT NULL,
  `quantity` int(100) NOT NULL,
  `date_in` varchar(100) NOT NULL,
  `price` float NOT NULL,
  `total` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`ISBN`, `bookname`, `writer`, `publisher`, `edition`, `quantity`, `date_in`, `price`, `total`) VALUES
('77', ' m', 'bnm,', 'nm', 8, 11, '2022-07-08', 8, 88);

-- --------------------------------------------------------

--
-- Table structure for table `issuebook`
--

CREATE TABLE `issuebook` (
  `date` text NOT NULL,
  `bookname` text NOT NULL,
  `ISBN` varchar(100) NOT NULL,
  `writer` text NOT NULL,
  `publisher` text NOT NULL,
  `studentname` text NOT NULL,
  `adm` varchar(100) NOT NULL,
  `mobile` varchar(100) NOT NULL,
  `year` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `issuebook`
--

INSERT INTO `issuebook` (`date`, `bookname`, `ISBN`, `writer`, `publisher`, `studentname`, `adm`, `mobile`, `year`) VALUES
('2022-07-09', ' m', '77', 'bnm,', 'nm', 'djrewruei', '45', '+25476666454', '323:20:46.370452');

-- --------------------------------------------------------

--
-- Table structure for table `librarians`
--

CREATE TABLE `librarians` (
  `idno` int(100) NOT NULL,
  `username` text NOT NULL,
  `fullname` text NOT NULL,
  `mobile` text NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `location` text NOT NULL,
  `qualification` text NOT NULL,
  `date_employed` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `librarians`
--

INSERT INTO `librarians` (`idno`, `username`, `fullname`, `mobile`, `email`, `password`, `location`, `qualification`, `date_employed`) VALUES
(123, 'lib', 'library', '+2534337', 'demo@gmail.com', 'pass', 'kianduku', 'Bsc', '2022-07-08');

-- --------------------------------------------------------

--
-- Table structure for table `newlib`
--

CREATE TABLE `newlib` (
  `libid` int(11) NOT NULL,
  `name` text NOT NULL,
  `location` text NOT NULL,
  `admin` text NOT NULL,
  `seats` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `newlib`
--

INSERT INTO `newlib` (`libid`, `name`, `location`, `admin`, `seats`) VALUES
(676, 'Gwa Kenda Lib', 'gatwe', 'Munge', 777);

-- --------------------------------------------------------

--
-- Table structure for table `returnbook`
--

CREATE TABLE `returnbook` (
  `issue_date` text NOT NULL,
  `bookname` text NOT NULL,
  `ISBN` varchar(100) NOT NULL,
  `writer` text NOT NULL,
  `publisher` text NOT NULL,
  `studentname` text NOT NULL,
  `adm` varchar(100) NOT NULL,
  `mobile` varchar(100) NOT NULL,
  `year` int(100) NOT NULL,
  `return_date` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `returnbook`
--

INSERT INTO `returnbook` (`issue_date`, `bookname`, `ISBN`, `writer`, `publisher`, `studentname`, `adm`, `mobile`, `year`, `return_date`) VALUES
('2022-07-09', ' m', '77', 'bnm,', 'nm', 'francis njiraini', '1234', '+2547777746535', 3, '2022-07-09');

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `adm` varchar(100) NOT NULL,
  `fullname` text NOT NULL,
  `course` text NOT NULL,
  `year` varchar(100) NOT NULL,
  `mobile` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `ethnicity` text NOT NULL,
  `gender` text NOT NULL,
  `location` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`adm`, `fullname`, `course`, `year`, `mobile`, `email`, `ethnicity`, `gender`, `location`) VALUES
('1234', 'francis njiraini', 'CSE', '3', '+2547777746535', 'njirain@gmail.com', 'kikuyu', 'male', 'Kirinyaga'),
('45', 'djrewruei', 'CSE', '3', '+25476666454', 'demo@gmail.com', 'kiuk', 'MALE', 'Karatina');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admins`
--
ALTER TABLE `admins`
  ADD PRIMARY KEY (`idno`);

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`ISBN`);

--
-- Indexes for table `issuebook`
--
ALTER TABLE `issuebook`
  ADD KEY `adm` (`adm`),
  ADD KEY `ISBN` (`ISBN`);

--
-- Indexes for table `newlib`
--
ALTER TABLE `newlib`
  ADD PRIMARY KEY (`libid`);

--
-- Indexes for table `returnbook`
--
ALTER TABLE `returnbook`
  ADD KEY `ISBN` (`ISBN`),
  ADD KEY `adm` (`adm`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`adm`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `issuebook`
--
ALTER TABLE `issuebook`
  ADD CONSTRAINT `issuebook_ibfk_1` FOREIGN KEY (`adm`) REFERENCES `students` (`adm`),
  ADD CONSTRAINT `issuebook_ibfk_2` FOREIGN KEY (`adm`) REFERENCES `students` (`adm`),
  ADD CONSTRAINT `issuebook_ibfk_3` FOREIGN KEY (`ISBN`) REFERENCES `books` (`ISBN`);

--
-- Constraints for table `returnbook`
--
ALTER TABLE `returnbook`
  ADD CONSTRAINT `returnbook_ibfk_1` FOREIGN KEY (`ISBN`) REFERENCES `books` (`ISBN`),
  ADD CONSTRAINT `returnbook_ibfk_2` FOREIGN KEY (`adm`) REFERENCES `students` (`adm`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
