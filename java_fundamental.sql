/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 10.4.28-MariaDB : Database - db_pub
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_pub` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;

USE `db_pub`;

/*Table structure for table `auth` */

DROP TABLE IF EXISTS `auth`;

CREATE TABLE `auth` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `id_mahasiswa` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7mmlqyj2o5il3j3i7edpoowxd` (`id_mahasiswa`),
  CONSTRAINT `FK7mmlqyj2o5il3j3i7edpoowxd` FOREIGN KEY (`id_mahasiswa`) REFERENCES `member` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `auth` */

insert  into `auth`(`id`,`password`,`role`,`username`,`id_mahasiswa`) values 
(1,'$2a$10$J3Jj6ENBwnFgz9S.c0BAqeEE1.dLEZ1MV3wvv022OjeNdH9fSh9q.','ADMIN','admin',NULL);

/*Table structure for table `chamberlain` */

DROP TABLE IF EXISTS `chamberlain`;

CREATE TABLE `chamberlain` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `balance` bigint(20) NOT NULL,
  `date` varchar(255) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `expense` bigint(20) NOT NULL,
  `income` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `chamberlain` */

/*Table structure for table `datapub` */

DROP TABLE IF EXISTS `datapub`;

CREATE TABLE `datapub` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `hafalan` varchar(255) DEFAULT NULL,
  `pointleft` int(11) NOT NULL,
  `poin` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlgeilu9ill09eg95e5kkcd202` (`poin`),
  CONSTRAINT `FKlgeilu9ill09eg95e5kkcd202` FOREIGN KEY (`poin`) REFERENCES `member` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `datapub` */

/*Table structure for table `farmacy` */

DROP TABLE IF EXISTS `farmacy`;

CREATE TABLE `farmacy` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `stock` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `farmacy` */

/*Table structure for table `food` */

DROP TABLE IF EXISTS `food`;

CREATE TABLE `food` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `menu` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `food` */

/*Table structure for table `generation` */

DROP TABLE IF EXISTS `generation`;

CREATE TABLE `generation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` text DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `generation` */

insert  into `generation`(`id`,`description`,`name`) values 
(1,'','Getch');

/*Table structure for table `kelompok` */

DROP TABLE IF EXISTS `kelompok`;

CREATE TABLE `kelompok` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `practice_group` varchar(255) DEFAULT NULL,
  `id_instruktur` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8fmhnavathxjnodldpvypxpjv` (`id_instruktur`),
  CONSTRAINT `FK8fmhnavathxjnodldpvypxpjv` FOREIGN KEY (`id_instruktur`) REFERENCES `member` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `kelompok` */

/*Table structure for table `member` */

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `nim` varchar(255) DEFAULT NULL,
  `ryear` int(11) NOT NULL,
  `id_generation` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbl7dg018tqj0f624uos1uv362` (`id_generation`),
  CONSTRAINT `FKbl7dg018tqj0f624uos1uv362` FOREIGN KEY (`id_generation`) REFERENCES `generation` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `member` */

/*Table structure for table `member_div_keasramaan` */

DROP TABLE IF EXISTS `member_div_keasramaan`;

CREATE TABLE `member_div_keasramaan` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) DEFAULT NULL,
  `id_memberdivisikeasramaan` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKb7ntu0xffo3gkk5ep6jkrol51` (`id_memberdivisikeasramaan`),
  CONSTRAINT `FKb7ntu0xffo3gkk5ep6jkrol51` FOREIGN KEY (`id_memberdivisikeasramaan`) REFERENCES `member` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `member_div_keasramaan` */

/*Table structure for table `member_div_kebersihan` */

DROP TABLE IF EXISTS `member_div_kebersihan`;

CREATE TABLE `member_div_kebersihan` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) DEFAULT NULL,
  `id_memberkebersihan` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmco3ds82f1qedndbuv7jj6ncb` (`id_memberkebersihan`),
  CONSTRAINT `FKmco3ds82f1qedndbuv7jj6ncb` FOREIGN KEY (`id_memberkebersihan`) REFERENCES `member` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `member_div_kebersihan` */

/*Table structure for table `member_div_kerohanian` */

DROP TABLE IF EXISTS `member_div_kerohanian`;

CREATE TABLE `member_div_kerohanian` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) DEFAULT NULL,
  `id_memberkerohanian` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnbpp56dyhfl1t9l65taeqxxfj` (`id_memberkerohanian`),
  CONSTRAINT `FKnbpp56dyhfl1t9l65taeqxxfj` FOREIGN KEY (`id_memberkerohanian`) REFERENCES `member` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `member_div_kerohanian` */

/*Table structure for table `member_div_kesehatan` */

DROP TABLE IF EXISTS `member_div_kesehatan`;

CREATE TABLE `member_div_kesehatan` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) DEFAULT NULL,
  `id_memberkesehatan` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnjedoc0b6vgnmlcbaq53mrp1x` (`id_memberkesehatan`),
  CONSTRAINT `FKnjedoc0b6vgnmlcbaq53mrp1x` FOREIGN KEY (`id_memberkesehatan`) REFERENCES `member` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `member_div_kesehatan` */

/*Table structure for table `member_div_kesejahteraan` */

DROP TABLE IF EXISTS `member_div_kesejahteraan`;

CREATE TABLE `member_div_kesejahteraan` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) DEFAULT NULL,
  `id_memberkesejahteraan` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKs3yf7fcfwouh1kmdynbhsvwr6` (`id_memberkesejahteraan`),
  CONSTRAINT `FKs3yf7fcfwouh1kmdynbhsvwr6` FOREIGN KEY (`id_memberkesejahteraan`) REFERENCES `member` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `member_div_kesejahteraan` */

/*Table structure for table `member_div_pelatihan_inggris` */

DROP TABLE IF EXISTS `member_div_pelatihan_inggris`;

CREATE TABLE `member_div_pelatihan_inggris` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) DEFAULT NULL,
  `id_memberdivpelatihaninggris` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKij444bj1rd5mfpdit87one63m` (`id_memberdivpelatihaninggris`),
  CONSTRAINT `FKij444bj1rd5mfpdit87one63m` FOREIGN KEY (`id_memberdivpelatihaninggris`) REFERENCES `member` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `member_div_pelatihan_inggris` */

/*Table structure for table `member_div_pendidikan` */

DROP TABLE IF EXISTS `member_div_pendidikan`;

CREATE TABLE `member_div_pendidikan` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) DEFAULT NULL,
  `id_memberpendidikan` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6kaanl7urjildniy0r73abe2r` (`id_memberpendidikan`),
  CONSTRAINT `FK6kaanl7urjildniy0r73abe2r` FOREIGN KEY (`id_memberpendidikan`) REFERENCES `member` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `member_div_pendidikan` */

/*Table structure for table `member_dormitory` */

DROP TABLE IF EXISTS `member_dormitory`;

CREATE TABLE `member_dormitory` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `dorm` varchar(255) DEFAULT NULL,
  `id_memberdormy` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK320ufka5047yf3oqf6mt033hs` (`id_memberdormy`),
  CONSTRAINT `FK320ufka5047yf3oqf6mt033hs` FOREIGN KEY (`id_memberdormy`) REFERENCES `member` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `member_dormitory` */

/*Table structure for table `member_group` */

DROP TABLE IF EXISTS `member_group`;

CREATE TABLE `member_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` text DEFAULT NULL,
  `value` int(11) NOT NULL,
  `id_grouppendidikanpelatihan` bigint(20) DEFAULT NULL,
  `id_memberpendidikanpelatihan` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKl2uuqb4rjkfvslv1n3laer17t` (`id_grouppendidikanpelatihan`),
  KEY `FKf3yhlbanhhf0jofp7tkv8d0v9` (`id_memberpendidikanpelatihan`),
  CONSTRAINT `FKf3yhlbanhhf0jofp7tkv8d0v9` FOREIGN KEY (`id_memberpendidikanpelatihan`) REFERENCES `member` (`id`),
  CONSTRAINT `FKl2uuqb4rjkfvslv1n3laer17t` FOREIGN KEY (`id_grouppendidikanpelatihan`) REFERENCES `kelompok` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `member_group` */

/*Table structure for table `piket` */

DROP TABLE IF EXISTS `piket`;

CREATE TABLE `piket` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `day` varchar(255) DEFAULT NULL,
  `week` int(11) NOT NULL,
  `id_memberpiket` bigint(20) DEFAULT NULL,
  `id_roompiket` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjpabi3pgkv2e49cm4spv7hml8` (`id_memberpiket`),
  KEY `FKe6o1qhcha7f36sohr3nc7sjrj` (`id_roompiket`),
  CONSTRAINT `FKe6o1qhcha7f36sohr3nc7sjrj` FOREIGN KEY (`id_roompiket`) REFERENCES `room` (`id`),
  CONSTRAINT `FKjpabi3pgkv2e49cm4spv7hml8` FOREIGN KEY (`id_memberpiket`) REFERENCES `member` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `piket` */

/*Table structure for table `ppmb` */

DROP TABLE IF EXISTS `ppmb`;

CREATE TABLE `ppmb` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tpa_area` varchar(255) DEFAULT NULL,
  `id_memberppmb` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKg0h4kgj9p56ddnl0knku706lp` (`id_memberppmb`),
  CONSTRAINT `FKg0h4kgj9p56ddnl0knku706lp` FOREIGN KEY (`id_memberppmb`) REFERENCES `member` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `ppmb` */

/*Table structure for table `pubbalance` */

DROP TABLE IF EXISTS `pubbalance`;

CREATE TABLE `pubbalance` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date` varchar(255) DEFAULT NULL,
  `saving_balance` bigint(20) NOT NULL,
  `total_balance` bigint(20) NOT NULL,
  `used_balance` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `pubbalance` */

/*Table structure for table `room` */

DROP TABLE IF EXISTS `room`;

CREATE TABLE `room` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `room` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `room` */

/*Table structure for table `secretary` */

DROP TABLE IF EXISTS `secretary`;

CREATE TABLE `secretary` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `agenda` text DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `description` text DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `secretary` */

/*Table structure for table `vocab` */

DROP TABLE IF EXISTS `vocab`;

CREATE TABLE `vocab` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `vocab` varchar(255) DEFAULT NULL,
  `id_pelatihaninggris` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK45c8c2oqus6qyiad839ilylmn` (`id_pelatihaninggris`),
  CONSTRAINT `FK45c8c2oqus6qyiad839ilylmn` FOREIGN KEY (`id_pelatihaninggris`) REFERENCES `member` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `vocab` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
