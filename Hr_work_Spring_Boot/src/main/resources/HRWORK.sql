-- MySQL dump 10.13  Distrib 5.7.17, for Linux (x86_64)
--
-- Host: localhost    Database: hrworkapp
-- ------------------------------------------------------
-- Server version	5.7.18-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Contact`
--

DROP TABLE IF EXISTS `Contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Contact` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `photoUrl` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Contact`
--

LOCK TABLES `Contact` WRITE;
/*!40000 ALTER TABLE `Contact` DISABLE KEYS */;
/*!40000 ALTER TABLE `Contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Contact_emailAddress`
--

DROP TABLE IF EXISTS `Contact_emailAddress`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Contact_emailAddress` (
  `Contact_id` bigint(20) NOT NULL,
  `emailAddress` varchar(255) DEFAULT NULL,
  KEY `FK_cxoidv14ivgusynp1thbhm39x` (`Contact_id`),
  CONSTRAINT `FK_cxoidv14ivgusynp1thbhm39x` FOREIGN KEY (`Contact_id`) REFERENCES `Contact` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Contact_emailAddress`
--

LOCK TABLES `Contact_emailAddress` WRITE;
/*!40000 ALTER TABLE `Contact_emailAddress` DISABLE KEYS */;
/*!40000 ALTER TABLE `Contact_emailAddress` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Contact_phone`
--

DROP TABLE IF EXISTS `Contact_phone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Contact_phone` (
  `Contact_id` bigint(20) NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  KEY `FK_85skaomwedhs4vh4a52oa16wg` (`Contact_id`),
  CONSTRAINT `FK_85skaomwedhs4vh4a52oa16wg` FOREIGN KEY (`Contact_id`) REFERENCES `Contact` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Contact_phone`
--

LOCK TABLES `Contact_phone` WRITE;
/*!40000 ALTER TABLE `Contact_phone` DISABLE KEYS */;
/*!40000 ALTER TABLE `Contact_phone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `InAuthority`
--

DROP TABLE IF EXISTS `InAuthority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `InAuthority` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `authority` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `InAuthority`
--

LOCK TABLES `InAuthority` WRITE;
/*!40000 ALTER TABLE `InAuthority` DISABLE KEYS */;
INSERT INTO `InAuthority` VALUES (1,'ROLE_HR'),(2,'ROLE_ADMIN');
/*!40000 ALTER TABLE `InAuthority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `InUser`
--

DROP TABLE IF EXISTS `InUser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `InUser` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `age` varchar(255) DEFAULT NULL,
  `languagepreference` varchar(255) DEFAULT NULL,
  `newuser` int(11) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone_no` varchar(255) DEFAULT NULL,
  `phonenumber` varchar(255) DEFAULT NULL,
  `primaryemail` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `InUser`
--

LOCK TABLES `InUser` WRITE;
/*!40000 ALTER TABLE `InUser` DISABLE KEYS */;
INSERT INTO `InUser` VALUES (1,'chennai','23','french',2,'achu','7299200833','8989345676','achu10@live.in',NULL,'ashwin'),(2,'california','23','french',2,'achu','7299200833','8989345676','achu10@live.in',NULL,'ashwin'),(3,'chenn','45','eng',1,'achu','124564543332','44455544','drftxs@ycys.in',1,'ashwin'),(4,'hu','787','jiji',9,'uhuhu','1234567890','1234567890','syqy@hdc.ij',1,'nxjunswc');
/*!40000 ALTER TABLE `InUser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `InUser_InAuthority`
--

DROP TABLE IF EXISTS `InUser_InAuthority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `InUser_InAuthority` (
  `InUser_id` bigint(20) NOT NULL,
  `roles_id` bigint(20) NOT NULL,
  PRIMARY KEY (`InUser_id`,`roles_id`),
  KEY `FK_7i94537s41tpscal8blixc6ox` (`roles_id`),
  CONSTRAINT `FK_7i94537s41tpscal8blixc6ox` FOREIGN KEY (`roles_id`) REFERENCES `InAuthority` (`id`),
  CONSTRAINT `FK_ay7b4sop26k244w4slnbx9n4e` FOREIGN KEY (`InUser_id`) REFERENCES `InUser` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `InUser_InAuthority`
--

LOCK TABLES `InUser_InAuthority` WRITE;
/*!40000 ALTER TABLE `InUser_InAuthority` DISABLE KEYS */;
INSERT INTO `InUser_InAuthority` VALUES (1,1),(4,1),(2,2),(3,2);
/*!40000 ALTER TABLE `InUser_InAuthority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `UserLeave`
--

DROP TABLE IF EXISTS `UserLeave`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `UserLeave` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `Summary` varchar(255) DEFAULT NULL,
  `createOn` date DEFAULT NULL,
  `leaveApprovedBy` bigint(20) NOT NULL,
  `leaveFromDate` date DEFAULT NULL,
  `leaveToDate` date DEFAULT NULL,
  `leaveType` int(11) DEFAULT NULL,
  `numberOfDays` float NOT NULL,
  `status` int(11) DEFAULT NULL,
  `leaveAppliedBy_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_8p141nsuf8ylehcqk3e8f8ei8` (`leaveAppliedBy_id`),
  CONSTRAINT `FK_8p141nsuf8ylehcqk3e8f8ei8` FOREIGN KEY (`leaveAppliedBy_id`) REFERENCES `InUser` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `UserLeave`
--

LOCK TABLES `UserLeave` WRITE;
/*!40000 ALTER TABLE `UserLeave` DISABLE KEYS */;
INSERT INTO `UserLeave` VALUES (2,'cholera','2010-09-08',1,'2012-09-08','2012-09-14',2,6,2,1),(3,'cholera','2010-09-08',1,'2012-09-08','2012-09-14',3,6,2,2);
/*!40000 ALTER TABLE `UserLeave` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'hrworkapp'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-10 16:27:18
