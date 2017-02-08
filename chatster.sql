-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.1.10-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win32
-- HeidiSQL Version:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for chatster
DROP DATABASE IF EXISTS `chatster`;
CREATE DATABASE IF NOT EXISTS `chatster` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `chatster`;


-- Dumping structure for table chatster.domain
DROP TABLE IF EXISTS `domain`;
CREATE TABLE IF NOT EXISTS `domain` (
  `DOMAIN_ID` int(11) NOT NULL AUTO_INCREMENT,
  `DOMAIN_NAME` varchar(50) NOT NULL DEFAULT '0',
  `DOMAIN_CODE` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`DOMAIN_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table chatster.domain: ~0 rows (approximately)
DELETE FROM `domain`;
/*!40000 ALTER TABLE `domain` DISABLE KEYS */;
/*!40000 ALTER TABLE `domain` ENABLE KEYS */;


-- Dumping structure for table chatster.user
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `USER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(50) NOT NULL,
  `PASSWORD` varchar(50) NOT NULL,
  `FIRST_NAME` varchar(50) NOT NULL DEFAULT '0',
  `LAST_NAME` varchar(50) NOT NULL DEFAULT '0',
  `ADDRESS` varchar(50) DEFAULT NULL,
  `PHONE_NUMBER` varchar(50) DEFAULT NULL,
  `PHOTO` longblob,
  `REGISTRATION_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `DOMAIN_ID` int(11) NOT NULL,
  PRIMARY KEY (`USER_ID`),
  KEY `USER-DOMAIN` (`DOMAIN_ID`),
  CONSTRAINT `USER-DOMAIN` FOREIGN KEY (`DOMAIN_ID`) REFERENCES `domain` (`DOMAIN_ID`) ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table chatster.user: ~0 rows (approximately)
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
