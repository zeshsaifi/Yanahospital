-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 29, 2022 at 11:47 AM
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
-- Database: `yana_hospital`
--

-- --------------------------------------------------------

--
-- Table structure for table `history`
--

CREATE TABLE `history` (
  `username` varchar(255) NOT NULL,
  `time` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `history`
--

INSERT INTO `history` (`username`, `time`) VALUES
('zeeshan', '2022-10-10 05:16:14'),
('zeeshan', '2022-10-10 05:16:39'),
('zeeshan', '2022-10-10 05:18:33'),
('abhishek', '2022-10-10 05:20:19'),
('zeeshan', '2022-10-10 05:21:11'),
('shadik', '2022-10-10 05:53:58'),
('rahul12', '2022-10-10 06:14:22'),
('zeeshan', '2022-10-11 01:57:50'),
('iics12', '2022-10-11 01:59:16'),
('zeeshan', '2022-10-11 02:02:32'),
('zeeshan', '2022-10-11 02:10:42'),
('zeeshan', '2022-10-11 02:11:23'),
('zeeshan', '2022-10-11 03:42:57'),
('zeeshan', '2022-10-11 03:47:12'),
('popcorn', '2022-10-11 03:48:14'),
('popcorn', '2022-10-11 03:50:12'),
('pop1234', '2022-10-11 03:50:30'),
('pop1234', '2022-10-11 03:50:39'),
('pop12345', '2022-10-11 03:50:46'),
('pop123', '2022-10-11 03:50:50'),
('zeeshan', '2022-10-11 05:35:14'),
('zeeshan', '2022-10-12 04:59:46'),
('zeeshan', '2022-10-12 05:00:51'),
('zeeshan', '2022-10-20 03:01:29'),
('zeeshan', '2022-10-20 03:04:53'),
('zeeshan', '2022-10-20 03:18:10'),
('zeeshan', '2022-10-20 04:04:27'),
('zeeshan', '2022-10-22 01:54:29'),
('zeeshan', '2022-10-22 01:58:45'),
('zeeshan', '2022-10-22 02:00:17'),
('vishal', '2022-10-22 02:01:22'),
('zeeshan', '2022-10-22 02:02:27'),
('zeeshan', '2022-10-29 10:27:21'),
('zeeshan', '2022-10-29 10:28:00'),
('zeeshan', '2022-11-28 04:51:45'),
('atulbhat', '2022-11-28 04:52:41'),
('zeeshan', '2022-11-28 04:53:09'),
('zeeshan', '2022-11-28 04:53:18'),
('zeeshan', '2022-11-28 04:54:17'),
('atulbhat', '2022-11-28 04:55:52');

-- --------------------------------------------------------

--
-- Table structure for table `patient_information`
--

CREATE TABLE `patient_information` (
  `patient_id` bigint(255) NOT NULL,
  `pateint_name` varchar(255) NOT NULL,
  `patient_father's_name` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `phone` bigint(255) NOT NULL,
  `diseases` varchar(255) NOT NULL,
  `ward` varchar(255) NOT NULL,
  `time_of_admit` datetime NOT NULL,
  `time_of_discharge` datetime NOT NULL,
  `amount` int(11) NOT NULL,
  `payment` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `patient_information`
--

INSERT INTO `patient_information` (`patient_id`, `pateint_name`, `patient_father's_name`, `address`, `phone`, `diseases`, `ward`, `time_of_admit`, `time_of_discharge`, `amount`, `payment`) VALUES
(10245852, 'dfdxfxcd9888', 'dfesrxvd', 'dfsef', 4152789545, 'ghfvthg', '20', '2022-10-10 09:00:00', '2023-10-10 08:00:00', 52103, 'done'),
(12345678, 'aaditi varma', 'sanjay varma', 'noida, delhi', 12345678, 'heart block', '50', '2022-07-22 19:54:54', '2022-10-10 09:00:00', 150000, 'done'),
(12458175, 'shiva', 'arun', 'haryana', 8547126458, 'apendis', '87', '2022-09-10 22:00:00', '2022-10-25 08:00:00', 80000, 'done'),
(27698432, 'abhijeet sharma', 'vikash sharma', 'delhi', 9684572156, 'normal fever', '06', '2022-10-06 09:00:00', '2022-10-06 09:30:00', 200, 'done'),
(87654321, 'abhishek', 'cr', 'soniya vihar,delhi', 8800593210, 'heavy feaver', '10', '2022-10-10 10:00:00', '2022-10-11 19:00:00', 8000, 'done');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone` bigint(255) NOT NULL,
  `key_value` bigint(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`username`, `password`, `phone`, `key_value`) VALUES
('zeeshan', 'zesh1234', 9876543210, 1234567887654321),
('abhishek', 'maurya1234', 9876543298, 1234567890123456),
('atulbhat', 'atul1234', 5214879652, 1929159261888895),
('vishal', 'vish1234', 7485965847, 5912494048297273),
('atulbhat', 'atul1234', 5416545455, 6498425392656759);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `patient_information`
--
ALTER TABLE `patient_information`
  ADD PRIMARY KEY (`patient_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`key_value`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
