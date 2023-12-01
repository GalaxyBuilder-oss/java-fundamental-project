-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Dec 01, 2023 at 10:45 PM
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
(0xbdcf16fb08a0421b8b0106d433c53bf0, 'Pekan Baru', '', 'Arya Segara', '02032211072', 2022, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

--
-- Indexes for dumped tables
--

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
-- Constraints for dumped tables
--

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
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
