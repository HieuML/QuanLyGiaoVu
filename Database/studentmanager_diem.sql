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
-- Table structure for table `diem`
--

DROP TABLE IF EXISTS `diem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `diem` (
  `MaSv` varchar(10) NOT NULL,
  `MaHocPhan` varchar(10) NOT NULL,
  `HocKi` varchar(10) NOT NULL,
  `DiemGK` float DEFAULT NULL,
  `DiemCK` float DEFAULT NULL,
  `DiemTong` float DEFAULT NULL,
  `DiemChu` varchar(2) DEFAULT NULL,
  `GhiChu` text,
  PRIMARY KEY (`MaSv`,`MaHocPhan`,`HocKi`),
  KEY `Diem_SV_idx` (`MaSv`),
  KEY `Diem_HP_idx` (`MaHocPhan`),
  CONSTRAINT `Diem_HP` FOREIGN KEY (`MaHocPhan`) REFERENCES `hocphan` (`mahocphan`),
  CONSTRAINT `Diem_SV` FOREIGN KEY (`MaSv`) REFERENCES `sinh_vien` (`masv`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diem`
--

LOCK TABLES `diem` WRITE;
/*!40000 ALTER TABLE `diem` DISABLE KEYS */;
INSERT INTO `diem` VALUES ('20182510','IT1111','20211',8,9,8.7,'A',''),('20182510','IT1112','20211',5,5,5,'D+',''),('20182510','IT1114','20212',5,5,5,'D+',''),('20182511','IT1111','20211',9,9,9,'A',''),('20182511','IT1112','20211',9,9,9,'A',''),('20182511','IT1114','20212',2,4,3.4,'F',''),('20182512','IT1111','20211',8,8,8,'B+',''),('20182512','IT1112','20211',5,5,5,'D+',''),('20182512','IT1114','20212',7,8,7.7,'B',''),('20182517','ET1112','20211',1,1,1,'F',''),('20182517','ET1113','20212',5,6,5.7,'C',''),('20182517','ET4041','20212',9,10,9.7,'A+',''),('20182517','ET4430','20211',4,5,4.7,'D',''),('20182518','ET1112','20211',4,5,4.7,'D',''),('20182518','ET1112','20212',9,9,9,'A',''),('20182519','ET1111','20211',10,10,10,'A+',''),('20182519','ET1112','20211',5,5,5,'D+',''),('20182519','ET1112','20212',9,8,8.3,'B+','');
/*!40000 ALTER TABLE `diem` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-17  8:43:45
