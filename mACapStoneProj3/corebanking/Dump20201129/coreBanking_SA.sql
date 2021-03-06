-- MySQL dump 10.13  Distrib 8.0.22, for macos10.15 (x86_64)
--
-- Host: 127.0.0.1    Database: coreBanking
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `SA`
--

DROP TABLE IF EXISTS `SA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `SA` (
  `idSA` int NOT NULL AUTO_INCREMENT,
  `accNo` varchar(45) NOT NULL,
  `balance` double DEFAULT '1000',
  `intRate` double DEFAULT '0.05',
  `accOpenDate` date DEFAULT NULL,
  `accClosedDate` date DEFAULT NULL,
  `minBal` double DEFAULT '200',
  PRIMARY KEY (`idSA`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SA`
--

LOCK TABLES `SA` WRITE;
/*!40000 ALTER TABLE `SA` DISABLE KEYS */;
INSERT INTO `SA` VALUES (1,'123-456-789-0',7200,0.05000000074505806,'2010-11-19','2020-11-20',200),(2,'098-765-432-1',1000,0.029999999329447746,'2011-09-09','2022-01-01',100),(3,'123-456-789-1',1001,0.03999999910593033,'2010-11-20',NULL,300),(4,'123-456-789-2',2001,0.03999999910593033,'2010-11-20',NULL,300),(5,'111-222-333-4',1250,0.09,'2000-10-02',NULL,500),(6,'555-666-777-8',10000,0.07500000298023224,'2020-11-20',NULL,500),(7,'112-666-777-8',3456,0.07,'2020-11-20',NULL,500),(8,'112-666-777-9',5200,0.075,'2020-11-20',NULL,200),(9,'555-666-777-9',1800,0.075,'2020-11-11',NULL,300),(12,'555-555-555-5',0,2,'2020-11-28',NULL,555),(16,'888-888-888-7',0,1,'2020-11-28',NULL,222),(17,'222-222-222-2',700,1,'2020-11-28',NULL,500);
/*!40000 ALTER TABLE `SA` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-29 11:50:19
