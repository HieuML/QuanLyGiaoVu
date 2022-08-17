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
-- Table structure for table `hocphan_gv`
--

DROP TABLE IF EXISTS `hocphan_gv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `hocphan_gv` (
  `MaHocPhan` varchar(10) NOT NULL,
  `MaGV` varchar(10) NOT NULL,
  `HocKi` varchar(10) NOT NULL,
  `SoLop` int(11) NOT NULL,
  PRIMARY KEY (`MaHocPhan`,`MaGV`,`HocKi`),
  KEY `Dtail_GV_idx` (`MaGV`),
  CONSTRAINT `Detail_HP` FOREIGN KEY (`MaHocPhan`) REFERENCES `hocphan` (`mahocphan`),
  CONSTRAINT `Dtail_GV` FOREIGN KEY (`MaGV`) REFERENCES `giang_vien` (`magv`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hocphan_gv`
--

LOCK TABLES `hocphan_gv` WRITE;
/*!40000 ALTER TABLE `hocphan_gv` DISABLE KEYS */;
INSERT INTO `hocphan_gv` VALUES ('ET1111','123457','20211',5),('ET1112','123456','20211',2),('ET1112','123456','20212',3),('ET1112','123457','20211',4);
/*!40000 ALTER TABLE `hocphan_gv` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-17  8:43:46
