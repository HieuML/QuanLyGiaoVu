-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: studentmanager
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `sinh_vien`
--

DROP TABLE IF EXISTS `sinh_vien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `sinh_vien` (
  `MaSv` varchar(10) NOT NULL,
  `HoTen` varchar(45) NOT NULL,
  `NgaySinh` varchar(45) NOT NULL,
  `GioiTinh` int(11) NOT NULL,
  `DiaChi` varchar(45) NOT NULL,
  `MaLop` varchar(10) NOT NULL,
  `TenDN` varchar(45) NOT NULL,
  PRIMARY KEY (`MaSv`),
  UNIQUE KEY `TenDN_UNIQUE` (`TenDN`),
  KEY `SV_Login_idx` (`TenDN`),
  KEY `SV_Lop_idx` (`MaLop`),
  CONSTRAINT `SV_Login` FOREIGN KEY (`TenDN`) REFERENCES `login` (`tendn`),
  CONSTRAINT `SV_Lop` FOREIGN KEY (`MaLop`) REFERENCES `lop` (`malop`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sinh_vien`
--

LOCK TABLES `sinh_vien` WRITE;
/*!40000 ALTER TABLE `sinh_vien` DISABLE KEYS */;
INSERT INTO `sinh_vien` VALUES ('20182510','Phương','',0,'','IT06','Khanh'),('20182511','Vinh','01/01/2000',0,'','IT06','Vinh'),('20182512','Trường','01/01/2000',0,'','IT06','Truong'),('20182514','Lương','01/01/2000',0,'','ĐT07','Lương'),('20182515','Cương','01/01/2000',0,'','ĐT07','Cương'),('20182517','Hiếu','30/05/2000',0,'Hưng Yên','ĐT07','Oanh'),('20182518','Trang','22/01/2000',0,'','ĐT06','Trang'),('20182519','Tuan','01/01/2000',0,'','ĐT06','Tuan'),('20182520','QUy','01/01/2000',0,'','ĐT06','Quy');
/*!40000 ALTER TABLE `sinh_vien` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-17  8:43:44
