-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: electrogrid
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `power_technician`
--

DROP TABLE IF EXISTS `power_technician`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `power_technician` (
  `TechnicianID` int NOT NULL AUTO_INCREMENT,
  `TechnicianName` varchar(50) DEFAULT NULL,
  `TechnicianAddress` varchar(100) DEFAULT NULL,
  `TechnicianEmail` varchar(50) DEFAULT NULL,
  `TechnicianPhone` int DEFAULT NULL,
  `Type` varchar(1) DEFAULT NULL,
  `ContractTech_Salary` decimal(10,2) DEFAULT NULL,
  `HourlyTech_HourlyWages` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`TechnicianID`),
  CONSTRAINT `type_constraint` CHECK (((`Type` = _utf8mb4'C') or (`Type` = _utf8mb4'c') or (`Type` = _utf8mb4'H') or (`Type` = _utf8mb4'h')))
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `power_technician`
--

LOCK TABLES `power_technician` WRITE;
/*!40000 ALTER TABLE `power_technician` DISABLE KEYS */;
INSERT INTO `power_technician` VALUES (1,'Avishka Hashenu','Iswetiya,Pahala Diyadora, Kuliyapitiya','avishkahashenui@gmail.com',788459878,'H',0.00,5000.00),(2,'Rick Hansen','Baytown, 2011 Pulliam Street','rickhansen@gmail.com',788459878,'C',20000.00,0.00),(3,'Justin Ritter','Columbus 1700 James Bowie Drive','justinritter@gmail.com',1234567890,'C',30000.00,0.00),(6,'Craig Reiter','Dayton, 349 Olde Ridenour Road','craigreiter@gmail.com',123456789,'C',23000.00,0.00),(7,'Katherine Murraya','Boardman, One Childrens Plaza','katherine@gmail.com',788459878,'H',0.00,4000.00),(8,'Rick','Shawnee, One Elizabeth Place,E3 Suite A','rickhansen@gmail.com',372345789,'H',0.00,3000.00),(9,'Jim Mitchum','Coalgate, 1900 Gordon Cooper Drive,2Nd Floor','jimmitchum@gmail.com',788459878,'C',100000.00,0.00),(10,'Toby Swindell','Minot, 6 North Covington Avenue','tobyswindell@gmail',123456789,'C',27000.00,0.00),(11,'Mick Brown','Danbury, 1 W Burdick Expy','mickbrown@gmail',788459878,'C',44000.00,0.00),(12,'Jane Waco','Danbury, 1 W Burdick Expy','janewaco@gmail',115678373,'H',0.00,6000.00),(14,'Zuschuss Carroll','Fargo, 312 Custer Street','zuschuss@gmail',111547895,'C',70000.00,0.00),(15,'Michelle Ellison','Woodstock, 16000 Johnston Memorial Drive','michelleellison@gmail',111597862,'C',90000.00,0.00),(16,'john keels','Woodstock, Johnston, Memoria Drive','michelleellison@gmail.com',111597862,'C',90000.00,0.00);
/*!40000 ALTER TABLE `power_technician` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-15 19:54:22
