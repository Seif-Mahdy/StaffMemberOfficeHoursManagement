-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: officehoursmangementsystem
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
-- Table structure for table `appointment`
--

DROP TABLE IF EXISTS `appointment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `appointment` (
  `AppointmentId` int NOT NULL AUTO_INCREMENT,
  `OfficeHourId` int DEFAULT NULL,
  `StudentId` varchar(8) DEFAULT NULL,
  `StaffId` varchar(8) DEFAULT NULL,
  `isCanceled` tinyint DEFAULT NULL,
  PRIMARY KEY (`AppointmentId`),
  KEY `OfficeHourId` (`OfficeHourId`),
  KEY `StudentId` (`StudentId`),
  KEY `StaffId` (`StaffId`),
  CONSTRAINT `appointment_ibfk_1` FOREIGN KEY (`OfficeHourId`) REFERENCES `officehour` (`ID`),
  CONSTRAINT `appointment_ibfk_2` FOREIGN KEY (`StudentId`) REFERENCES `student` (`StudentId`),
  CONSTRAINT `appointment_ibfk_3` FOREIGN KEY (`StaffId`) REFERENCES `staffmember` (`StaffId`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointment`
--

LOCK TABLES `appointment` WRITE;
/*!40000 ALTER TABLE `appointment` DISABLE KEYS */;
/*!40000 ALTER TABLE `appointment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `CourseId` int NOT NULL AUTO_INCREMENT,
  `CourseName` varchar(40) NOT NULL,
  PRIMARY KEY (`CourseId`),
  UNIQUE KEY `CourseName` (`CourseName`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'Cs'),(2,'Ds'),(5,'IS'),(3,'IT'),(4,'ML');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coursetostaff`
--

DROP TABLE IF EXISTS `coursetostaff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `coursetostaff` (
  `CourseId` int NOT NULL AUTO_INCREMENT,
  `StaffId` varchar(8) NOT NULL,
  PRIMARY KEY (`CourseId`,`StaffId`),
  KEY `StaffId` (`StaffId`),
  CONSTRAINT `coursetostaff_ibfk_1` FOREIGN KEY (`StaffId`) REFERENCES `staffmember` (`StaffId`),
  CONSTRAINT `coursetostaff_ibfk_2` FOREIGN KEY (`CourseId`) REFERENCES `course` (`CourseId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coursetostaff`
--

LOCK TABLES `coursetostaff` WRITE;
/*!40000 ALTER TABLE `coursetostaff` DISABLE KEYS */;
INSERT INTO `coursetostaff` VALUES (1,'20170000'),(2,'20170000');
/*!40000 ALTER TABLE `coursetostaff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coursetostudents`
--

DROP TABLE IF EXISTS `coursetostudents`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `coursetostudents` (
  `CourseId` int NOT NULL AUTO_INCREMENT,
  `StudentId` varchar(8) NOT NULL,
  PRIMARY KEY (`CourseId`,`StudentId`),
  KEY `StudentId` (`StudentId`),
  CONSTRAINT `coursetostudents_ibfk_1` FOREIGN KEY (`StudentId`) REFERENCES `student` (`StudentId`),
  CONSTRAINT `coursetostudents_ibfk_2` FOREIGN KEY (`CourseId`) REFERENCES `course` (`CourseId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coursetostudents`
--

LOCK TABLES `coursetostudents` WRITE;
/*!40000 ALTER TABLE `coursetostudents` DISABLE KEYS */;
/*!40000 ALTER TABLE `coursetostudents` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `message` (
  `MessageID` int NOT NULL AUTO_INCREMENT,
  `SenderId` varchar(8) DEFAULT NULL,
  `ReceiverId` varchar(8) DEFAULT NULL,
  `MessageContent` varchar(250) NOT NULL,
  `Subject` varchar(40) DEFAULT NULL,
  `MessageDate` datetime NOT NULL,
  PRIMARY KEY (`MessageID`),
  KEY `message_student__fk` (`ReceiverId`),
  KEY `message_staffmember__fk` (`SenderId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` VALUES (10,'20170144','20170000','ezayk ya m3lm ','Test','2021-01-14 17:27:33');
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `officehour`
--

DROP TABLE IF EXISTS `officehour`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `officehour` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `From_Date` datetime NOT NULL,
  `To_Date` datetime NOT NULL,
  `IsOffline` tinyint(1) NOT NULL,
  `Location` varchar(50) DEFAULT NULL,
  `StaffId` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `officehour_staffmember_StaffId_fk` (`StaffId`),
  CONSTRAINT `officehour_staffmember_StaffId_fk` FOREIGN KEY (`StaffId`) REFERENCES `staffmember` (`StaffId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `officehour`
--

LOCK TABLES `officehour` WRITE;
/*!40000 ALTER TABLE `officehour` DISABLE KEYS */;
/*!40000 ALTER TABLE `officehour` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staffmember`
--

DROP TABLE IF EXISTS `staffmember`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staffmember` (
  `StaffId` varchar(8) NOT NULL,
  `StaffName` varchar(40) NOT NULL,
  `StaffNumber` varchar(11) NOT NULL,
  `Staffemail` varchar(40) NOT NULL,
  `StaffPassword` varchar(80) NOT NULL,
  `StaffRole` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`StaffId`),
  UNIQUE KEY `StaffNumber` (`StaffNumber`),
  UNIQUE KEY `Staffemail` (`Staffemail`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staffmember`
--

LOCK TABLES `staffmember` WRITE;
/*!40000 ALTER TABLE `staffmember` DISABLE KEYS */;
INSERT INTO `staffmember` VALUES ('20170000','seif alaa eldin','01018236358','seifalaa143@gmail.com','123456789','Doctor');
/*!40000 ALTER TABLE `staffmember` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `StudentId` varchar(8) NOT NULL,
  `StudentName` varchar(40) NOT NULL,
  `StudentNumber` varchar(11) NOT NULL,
  `StudentEmail` varchar(40) NOT NULL,
  `StudentPassword` varchar(80) NOT NULL,
  PRIMARY KEY (`StudentId`),
  UNIQUE KEY `StudentNumber` (`StudentNumber`),
  UNIQUE KEY `StudentEmail` (`StudentEmail`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('20170144','Abdelrhman hosny awad','01018236359','body.hosny111@gmail.com','123456789'),('20210144','omir hosny awad','01148258062','omir.hosny1212@gmail.com','123456789');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-14 20:17:19
