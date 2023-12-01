-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Dec 01, 2023 at 10:46 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_pub`
--

-- --------------------------------------------------------

--
-- Table structure for table `auth`
--

CREATE TABLE `auth` (
  `id` binary(16) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `auth`
--

INSERT INTO `auth` (`id`, `password`, `role`, `username`) VALUES
(0x27bc520711e14a6f9d2d2408bf43b20f, '$2y$10$EamaaUac5FkaUO1iWEhtaeT13Jq2c36Uk0zSpxN1zJXxdiA4.RIhy', 'ADMIN', 'admin'),
(0x7608c860780a43089d03d99ef5cca7af, '$2a$10$Gx/kAgOH9CxPDKizI7ONkul413jMCWhCWqFYixY/Mlg1tmy3ojwe.', 'BENDAHARA', 'bendahara'),
(0xb67ff711ded84684954c3c95e01a240d, '$2a$10$dzgkE8sZWDmjdvRv79lGc.2bwOZD.zgPAVh6PcONJ71FBiG.NCmqO', 'USER', 'user');

-- --------------------------------------------------------

--
-- Table structure for table `chamberlain`
--

CREATE TABLE `chamberlain` (
  `id` bigint(20) NOT NULL,
  `date` varchar(255) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `expense` bigint(20) NOT NULL,
  `income` bigint(20) NOT NULL,
  `balance` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `chamberlain`
--

INSERT INTO `chamberlain` (`id`, `date`, `description`, `expense`, `income`, `balance`) VALUES
(352, '2023-12-01', 'tes', 1000, 1000, 0),
(502, '2023-12-02', 'tes2', 100, 500, 0),
(503, '2023-12-03', 'tes3', 0, 1400, 0);

-- --------------------------------------------------------

--
-- Table structure for table `chamberlain_seq`
--

CREATE TABLE `chamberlain_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `chamberlain_seq`
--

INSERT INTO `chamberlain_seq` (`next_val`) VALUES
(601);

-- --------------------------------------------------------

--
-- Table structure for table `group_seq`
--

CREATE TABLE `group_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `group_seq`
--

INSERT INTO `group_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `kelompok`
--

CREATE TABLE `kelompok` (
  `id` bigint(20) NOT NULL,
  `practice_group` varchar(255) DEFAULT NULL,
  `total` int(11) NOT NULL,
  `id_grouppendidikanpelatihan` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `kelompok_seq`
--

CREATE TABLE `kelompok_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `kelompok_seq`
--

INSERT INTO `kelompok_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE `member` (
  `id` binary(16) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `nim` varchar(255) DEFAULT NULL,
  `ryear` int(11) NOT NULL,
  `id_member` bigint(20) DEFAULT NULL,
  `id_memberpendidikanpelatihan` bigint(20) DEFAULT NULL,
  `id_memberpendidikan` bigint(20) DEFAULT NULL,
  `id_memberpeltihaninggris` bigint(20) DEFAULT NULL,
  `id_memberkesejahteraan` bigint(20) DEFAULT NULL,
  `id_memberkesehatan` bigint(20) DEFAULT NULL,
  `id_memberkerohanian` bigint(20) DEFAULT NULL,
  `id_memberkebersihan` bigint(20) DEFAULT NULL,
  `id_memberkeasramaan` bigint(20) DEFAULT NULL,
  `id_memberppmb` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`id`, `address`, `description`, `name`, `nim`, `ryear`, `id_member`, `id_memberpendidikanpelatihan`, `id_memberpendidikan`, `id_memberpeltihaninggris`, `id_memberkesejahteraan`, `id_memberkesehatan`, `id_memberkerohanian`, `id_memberkebersihan`, `id_memberkeasramaan`, `id_memberppmb`) VALUES
(0x040487707e9d46289b990b03eaa92e69, 'Sibolga', '', 'Radja Salsabila A', '02042211017', 2022, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(0x062e184550724796ae14610e85240837, 'Kawali, Ciamis', '', 'Salim hidayat', '02032211085', 2022, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(0x0ccaf21a79be4517acd308aaf8e6e903, 'Sibolga', '', 'Aisyah Romaito S', '02042211002', 2022, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(0x13ab26b0eb0841628f296412a3f6796e, 'Banjar', '', 'Riri Triana', '02', 2022, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(0x166b8d8e4c8141c9a1e4cbb6f690e05e, 'Salatiga', '', 'Hilwa Isnaini M', '04', 2022, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1),
(0x1a0eaf2879fb4776830fdf805c830240, 'Sibolga', '', 'Siti Nurhaliza S', '02042211020', 2022, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(0x1c38cee7bdd048e2ba0e54caf191e8f8, 'Banjar', '', 'Ades Roydatul A', '02042211001', 2022, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 103),
(0x234bd264cf7e4fd19f73b20a81483a99, 'Kawali, Ciamis', '', 'Yanti Nurhayati', '02042211025', 2022, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(0x35928a8cc097415d8d787819197e3434, 'Nias', '', 'Teguh Ahmadi Z', '02032211088', 2022, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(0x38493ec3f4d24050a9eb6893a9596ba5, 'KBB', '', 'Nur Jamilah', '03', 2022, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(0x56529519e65848838b9677f61e283267, 'KBB', '', 'Siti Pitriani', '01', 2022, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(0x579f31f777ca46e8ba50d69b8a680332, 'Cilacap', '', 'Hanif Fauzan N', '02032311025', 2022, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(0x5af64d60f76b4749adb84a4d812d6d42, 'Banjar', '', 'Tisatun Riza F', '00', 2022, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(0x606ecee4f4544687a0266a30300a7c52, 'Sipirok', '', 'Fadly Ariansyah P', '02032211077', 2022, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(0x632ce09d21fa4e6eb8c8c02095d5f52d, 'Kebumen', '', 'Fadillah Aulia M', '02042211008', 2022, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(0x672c3f7d307c43f98cd4e227ffceec14, 'Rancaengkek, Bandung', '', 'Rifqi Ikbal A', '02032311036', 2022, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(0x6a7d8a86202c4b84b38c7de3bc79c799, 'Balige', '', 'Susi Haryati H', '02042211023', 2022, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(0x6e066ce154274524a598d4a69924c22e, 'Sipirok/Batam', '', 'Annisa Alawiyah', '02042211005', 2022, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(0x82500885650748b390ab81692a44a298, 'Gununghalu KBB', '', 'Ajang Irhas R', '02032311015', 2022, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(0x871e9dfece1f484bbfa57fce55e50dd6, 'Sibolga', '', 'Sandi Adrian N T', '02042211019', 2022, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(0x8d08f3ea8dae4fb996760e817d65e044, 'Padang Sidimpuan', '', 'Anwar Juniansyah H', '02032211070', 2022, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(0x94ef37712a03408bbab7c8ea1a32eade, 'Sipirok', '', 'Almia Kusnariati H', '02042211004', 2022, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2),
(0xb12156db71f24b04b4bec1ffd15c6a16, 'Sibolga', '', 'Anggi Nouval T', '02032211069', 2022, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(0xb8d52d30fcd54a488821f2ee4855a022, 'Padang Panjang', '', 'Fajri Khairan M', '02032311021', 2022, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(0xbdcf16fb08a0421b8b0106d433c53bf0, 'Pekan Baru', '', 'Arya Segara', '02032211072', 2022, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(0xc7696899fe3c43a1a273caa7fac24da2, 'Banjar', '', 'Adittia Nurrahman', '05102311078', 2022, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 52),
(0xd4a47d8aad8f47efb8f13f201d2764e0, 'Pameungpeuk, Garut', '', 'Raksa Aryasatya', '02032211084', 2022, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(0xdb339d9ae7cd4621b4b732819c1cb237, 'Rongga, KBB', '', 'Lira Rahmawati', '02042211015', 2022, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(0xeb4c6f8099cc4244871404de8f6b1b91, 'Danau Toba', '', 'Imran Sihaloho', '02042211013', 2022, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(0xef9a1030390548f88c339a61562ea08e, 'Sibolga', '', 'Ragil Sadewa P', '02032311034', 2022, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `member_div_keasramaan`
--

CREATE TABLE `member_div_keasramaan` (
  `id` bigint(20) NOT NULL,
  `role` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `member_div_keasramaan_seq`
--

CREATE TABLE `member_div_keasramaan_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `member_div_keasramaan_seq`
--

INSERT INTO `member_div_keasramaan_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `member_div_kebersihan`
--

CREATE TABLE `member_div_kebersihan` (
  `id` bigint(20) NOT NULL,
  `role` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `member_div_kebersihan_seq`
--

CREATE TABLE `member_div_kebersihan_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `member_div_kebersihan_seq`
--

INSERT INTO `member_div_kebersihan_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `member_div_kerohanian`
--

CREATE TABLE `member_div_kerohanian` (
  `id` bigint(20) NOT NULL,
  `role` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `member_div_kerohanian_seq`
--

CREATE TABLE `member_div_kerohanian_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `member_div_kerohanian_seq`
--

INSERT INTO `member_div_kerohanian_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `member_div_kesehatan`
--

CREATE TABLE `member_div_kesehatan` (
  `id` bigint(20) NOT NULL,
  `role` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `member_div_kesehatan_seq`
--

CREATE TABLE `member_div_kesehatan_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `member_div_kesehatan_seq`
--

INSERT INTO `member_div_kesehatan_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `member_div_kesejahteraan`
--

CREATE TABLE `member_div_kesejahteraan` (
  `id` bigint(20) NOT NULL,
  `role` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `member_div_kesejahteraan_seq`
--

CREATE TABLE `member_div_kesejahteraan_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `member_div_kesejahteraan_seq`
--

INSERT INTO `member_div_kesejahteraan_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `member_div_pelatihan_inggris`
--

CREATE TABLE `member_div_pelatihan_inggris` (
  `id` bigint(20) NOT NULL,
  `role` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `member_div_pelatihan_inggris_seq`
--

CREATE TABLE `member_div_pelatihan_inggris_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `member_div_pelatihan_inggris_seq`
--

INSERT INTO `member_div_pelatihan_inggris_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `member_div_pendidikan`
--

CREATE TABLE `member_div_pendidikan` (
  `id` bigint(20) NOT NULL,
  `role` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `member_div_pendidikan_seq`
--

CREATE TABLE `member_div_pendidikan_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `member_div_pendidikan_seq`
--

INSERT INTO `member_div_pendidikan_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `member_group`
--

CREATE TABLE `member_group` (
  `id` bigint(20) NOT NULL,
  `description` text DEFAULT NULL,
  `value` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `member_group_seq`
--

CREATE TABLE `member_group_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `member_group_seq`
--

INSERT INTO `member_group_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `ppmb`
--

CREATE TABLE `ppmb` (
  `id` bigint(20) NOT NULL,
  `id_pel` binary(16) DEFAULT NULL,
  `tpa_area` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `ppmb_id_pel`
--

CREATE TABLE `ppmb_id_pel` (
  `ppmb_id` bigint(20) NOT NULL,
  `id_pel_id` binary(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `ppmb_seq`
--

CREATE TABLE `ppmb_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ppmb_seq`
--

INSERT INTO `ppmb_seq` (`next_val`) VALUES
(201);

-- --------------------------------------------------------

--
-- Table structure for table `pubbalance`
--

CREATE TABLE `pubbalance` (
  `id` bigint(20) NOT NULL,
  `date` varchar(255) DEFAULT NULL,
  `saving_balance` bigint(20) NOT NULL,
  `total_balance` bigint(20) NOT NULL,
  `used_balance` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pubbalance`
--

INSERT INTO `pubbalance` (`id`, `date`, `saving_balance`, `total_balance`, `used_balance`) VALUES
(152, '2023-12-01', 1000, 0, 1000),
(302, '2023-12-02', 500, 400, 100),
(303, '2023-12-03', 1400, 1800, 0);

-- --------------------------------------------------------

--
-- Table structure for table `pubbalance_seq`
--

CREATE TABLE `pubbalance_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pubbalance_seq`
--

INSERT INTO `pubbalance_seq` (`next_val`) VALUES
(401);

-- --------------------------------------------------------

--
-- Table structure for table `secretary`
--

CREATE TABLE `secretary` (
  `id` bigint(20) NOT NULL,
  `agenda` text DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `description` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `secretary_seq`
--

CREATE TABLE `secretary_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `secretary_seq`
--

INSERT INTO `secretary_seq` (`next_val`) VALUES
(1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `auth`
--
ALTER TABLE `auth`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `chamberlain`
--
ALTER TABLE `chamberlain`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `kelompok`
--
ALTER TABLE `kelompok`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKj0go0p16r6tj92cgvpujyh1wu` (`id_grouppendidikanpelatihan`);

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKy911e1ub98h0k0aide9ytji` (`id_member`),
  ADD KEY `FKm6ic1ot4i0lr9owmj95dmtt68` (`id_memberpendidikanpelatihan`),
  ADD KEY `FKqsv6m6v5t4466963xexunl5g5` (`id_memberpendidikan`),
  ADD KEY `FK26hbj7wl2yff3x4mdg5t0to53` (`id_memberpeltihaninggris`),
  ADD KEY `FKoa70km4vre4rvim5ii8ywn14o` (`id_memberkesejahteraan`),
  ADD KEY `FKoaayl1dccnc9fbwlmtxkyou2l` (`id_memberkesehatan`),
  ADD KEY `FK5qn1b6upeecnlqy9037xd8p7e` (`id_memberkerohanian`),
  ADD KEY `FKmlt59aavxovid4g9et2w6kdiu` (`id_memberkebersihan`),
  ADD KEY `FK2st8y1y5hocllb3h7lc2rn5lf` (`id_memberkeasramaan`),
  ADD KEY `FKe7c5qkwuffqbk2rohxtu7o78f` (`id_memberppmb`);

--
-- Indexes for table `member_div_keasramaan`
--
ALTER TABLE `member_div_keasramaan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `member_div_kebersihan`
--
ALTER TABLE `member_div_kebersihan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `member_div_kerohanian`
--
ALTER TABLE `member_div_kerohanian`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `member_div_kesehatan`
--
ALTER TABLE `member_div_kesehatan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `member_div_kesejahteraan`
--
ALTER TABLE `member_div_kesejahteraan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `member_div_pelatihan_inggris`
--
ALTER TABLE `member_div_pelatihan_inggris`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `member_div_pendidikan`
--
ALTER TABLE `member_div_pendidikan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `member_group`
--
ALTER TABLE `member_group`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ppmb`
--
ALTER TABLE `ppmb`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ppmb_id_pel`
--
ALTER TABLE `ppmb_id_pel`
  ADD PRIMARY KEY (`ppmb_id`,`id_pel_id`),
  ADD KEY `FKkox8tr6onwpwxia1p6lsuf917` (`id_pel_id`);

--
-- Indexes for table `pubbalance`
--
ALTER TABLE `pubbalance`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `secretary`
--
ALTER TABLE `secretary`
  ADD PRIMARY KEY (`id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `kelompok`
--
ALTER TABLE `kelompok`
  ADD CONSTRAINT `FKj0go0p16r6tj92cgvpujyh1wu` FOREIGN KEY (`id_grouppendidikanpelatihan`) REFERENCES `member_group` (`id`);

--
-- Constraints for table `member`
--
ALTER TABLE `member`
  ADD CONSTRAINT `FK26hbj7wl2yff3x4mdg5t0to53` FOREIGN KEY (`id_memberpeltihaninggris`) REFERENCES `member_div_pelatihan_inggris` (`id`),
  ADD CONSTRAINT `FK2st8y1y5hocllb3h7lc2rn5lf` FOREIGN KEY (`id_memberkeasramaan`) REFERENCES `member_div_keasramaan` (`id`),
  ADD CONSTRAINT `FK5qn1b6upeecnlqy9037xd8p7e` FOREIGN KEY (`id_memberkerohanian`) REFERENCES `member_div_kerohanian` (`id`),
  ADD CONSTRAINT `FKe7c5qkwuffqbk2rohxtu7o78f` FOREIGN KEY (`id_memberppmb`) REFERENCES `ppmb` (`id`),
  ADD CONSTRAINT `FKm6ic1ot4i0lr9owmj95dmtt68` FOREIGN KEY (`id_memberpendidikanpelatihan`) REFERENCES `member_group` (`id`),
  ADD CONSTRAINT `FKmlt59aavxovid4g9et2w6kdiu` FOREIGN KEY (`id_memberkebersihan`) REFERENCES `member_div_kebersihan` (`id`),
  ADD CONSTRAINT `FKoa70km4vre4rvim5ii8ywn14o` FOREIGN KEY (`id_memberkesejahteraan`) REFERENCES `member_div_kesejahteraan` (`id`),
  ADD CONSTRAINT `FKoaayl1dccnc9fbwlmtxkyou2l` FOREIGN KEY (`id_memberkesehatan`) REFERENCES `member_div_kesehatan` (`id`),
  ADD CONSTRAINT `FKqsv6m6v5t4466963xexunl5g5` FOREIGN KEY (`id_memberpendidikan`) REFERENCES `member_div_pendidikan` (`id`),
  ADD CONSTRAINT `FKy911e1ub98h0k0aide9ytji` FOREIGN KEY (`id_member`) REFERENCES `member_group` (`id`);

--
-- Constraints for table `ppmb_id_pel`
--
ALTER TABLE `ppmb_id_pel`
  ADD CONSTRAINT `FKhkfji8uacrw3is8lwnhwd4ns8` FOREIGN KEY (`ppmb_id`) REFERENCES `ppmb` (`id`),
  ADD CONSTRAINT `FKkox8tr6onwpwxia1p6lsuf917` FOREIGN KEY (`id_pel_id`) REFERENCES `member` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
