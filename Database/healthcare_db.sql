-- MySQL dump 10.13  Distrib 8.0.46, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: healthcare_db
-- ------------------------------------------------------
-- Server version	8.0.46

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
-- Table structure for table `appointments`
--

DROP TABLE IF EXISTS `appointments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `appointments` (
  `appointment_date` date DEFAULT NULL,
  `appointment_id` int NOT NULL AUTO_INCREMENT,
  `doctor_id` int DEFAULT NULL,
  `patient_id` int DEFAULT NULL,
  `version` int DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `modified_date` datetime(6) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`appointment_id`),
  KEY `FKmujeo4tymoo98cmf7uj3vsv76` (`doctor_id`),
  KEY `FK8exap5wmg8kmb1g1rx3by21yt` (`patient_id`),
  CONSTRAINT `FK8exap5wmg8kmb1g1rx3by21yt` FOREIGN KEY (`patient_id`) REFERENCES `patients` (`patient_id`),
  CONSTRAINT `FKmujeo4tymoo98cmf7uj3vsv76` FOREIGN KEY (`doctor_id`) REFERENCES `doctors` (`doctor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointments`
--

LOCK TABLES `appointments` WRITE;
/*!40000 ALTER TABLE `appointments` DISABLE KEYS */;
INSERT INTO `appointments` VALUES ('2026-07-01',1,1,1,0,'2026-06-29 10:28:06.614929','2026-06-29 10:28:06.614929','Confirmed'),('2026-07-02',2,2,2,0,'2026-06-29 10:28:58.962988','2026-06-29 10:28:58.962988','Pending'),('2026-07-03',3,3,3,0,'2026-06-29 10:29:16.330167','2026-06-29 10:29:16.330167','Completed'),('2026-07-04',4,4,4,0,'2026-06-29 10:30:09.291822','2026-06-29 10:30:09.291822','Confirmed'),('2026-07-05',5,5,5,0,'2026-06-29 10:30:24.248142','2026-06-29 10:30:24.248142','Pending');
/*!40000 ALTER TABLE `appointments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `billing`
--

DROP TABLE IF EXISTS `billing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `billing` (
  `amount` double DEFAULT NULL,
  `appointment_id` int DEFAULT NULL,
  `bill_id` int NOT NULL AUTO_INCREMENT,
  `version` int DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `modified_date` datetime(6) DEFAULT NULL,
  `payment_status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`bill_id`),
  UNIQUE KEY `UKsyuo6cqidkvt1q4u6l1gih34e` (`appointment_id`),
  CONSTRAINT `FKvq1tb92o0n9vtd63yem1il0l` FOREIGN KEY (`appointment_id`) REFERENCES `appointments` (`appointment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `billing`
--

LOCK TABLES `billing` WRITE;
/*!40000 ALTER TABLE `billing` DISABLE KEYS */;
INSERT INTO `billing` VALUES (500,1,1,0,'2026-06-29 11:03:58.157627','2026-06-29 11:03:58.157627','Paid'),(800,2,2,0,'2026-06-29 11:06:24.225129','2026-06-29 11:06:24.225129','Pending'),(1200,3,3,0,'2026-06-29 11:06:41.380935','2026-06-29 11:06:41.380935','Paid'),(950,4,4,0,'2026-06-29 11:07:04.506882','2026-06-29 11:07:04.506882','Pending'),(1500,5,5,0,'2026-06-29 11:07:13.471868','2026-06-29 11:07:13.471868','Paid');
/*!40000 ALTER TABLE `billing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctors`
--

DROP TABLE IF EXISTS `doctors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctors` (
  `doctor_id` int NOT NULL AUTO_INCREMENT,
  `version` int DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `modified_date` datetime(6) DEFAULT NULL,
  `doctor_name` varchar(255) NOT NULL,
  `hospital` varchar(255) NOT NULL,
  `specialization` varchar(255) NOT NULL,
  PRIMARY KEY (`doctor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctors`
--

LOCK TABLES `doctors` WRITE;
/*!40000 ALTER TABLE `doctors` DISABLE KEYS */;
INSERT INTO `doctors` VALUES (1,1,'2026-06-29 10:18:54.864880','2026-06-29 11:31:14.954292','Dr. Meera1','Fortis Hospital','Dermatologist'),(2,0,'2026-06-29 10:19:22.225224','2026-06-29 10:19:22.225224','Dr. Amit','Apollo Hospital','Cardiologist'),(3,0,'2026-06-29 10:20:24.325127','2026-06-29 10:20:24.325127','Dr. karan','Apollo Hospital','Cardiologist'),(4,0,'2026-06-29 10:20:52.070169','2026-06-29 10:20:52.070169','Dr. Meera','Fortis Hospital','Dermatologist'),(5,0,'2026-06-29 10:21:30.816016','2026-06-29 10:21:30.816016','Dr. prem','Apollo Hospital','Cardiologist');
/*!40000 ALTER TABLE `doctors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medical_records`
--

DROP TABLE IF EXISTS `medical_records`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medical_records` (
  `patient_id` int DEFAULT NULL,
  `record_id` int NOT NULL AUTO_INCREMENT,
  `version` int DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `modified_date` datetime(6) DEFAULT NULL,
  `diagnosis` varchar(255) DEFAULT NULL,
  `treatment` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`record_id`),
  KEY `FKrav12h9aiw7pegjt62p8owwn3` (`patient_id`),
  CONSTRAINT `FKrav12h9aiw7pegjt62p8owwn3` FOREIGN KEY (`patient_id`) REFERENCES `patients` (`patient_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medical_records`
--

LOCK TABLES `medical_records` WRITE;
/*!40000 ALTER TABLE `medical_records` DISABLE KEYS */;
INSERT INTO `medical_records` VALUES (1,1,0,'2026-06-29 11:23:18.712487','2026-06-29 11:23:18.712487','Fever','Medication'),(2,2,0,'2026-06-29 11:24:00.240419','2026-06-29 11:24:00.240419','Skin Allergy','Cream Treatment'),(3,3,0,'2026-06-29 11:24:18.389803','2026-06-29 11:24:18.389803','Migraine','Therapy'),(4,4,0,'2026-06-29 11:24:57.242200','2026-06-29 11:24:57.242200','Knee Pain','Physiotherapy'),(5,5,0,'2026-06-29 11:25:33.515589','2026-06-29 11:25:33.515589','Cold','Tablets');
/*!40000 ALTER TABLE `medical_records` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patients`
--

DROP TABLE IF EXISTS `patients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patients` (
  `patient_id` int NOT NULL AUTO_INCREMENT,
  `version` int DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `modified_date` datetime(6) DEFAULT NULL,
  `address` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gender` varchar(255) NOT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `patient_name` varchar(255) NOT NULL,
  PRIMARY KEY (`patient_id`),
  UNIQUE KEY `UKa370hmxgv0l5c9panryr1ji7d` (`email`),
  UNIQUE KEY `UKpt0kkuqdlyln0yrck354avjpv` (`mobile`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patients`
--

LOCK TABLES `patients` WRITE;
/*!40000 ALTER TABLE `patients` DISABLE KEYS */;
INSERT INTO `patients` VALUES (1,0,'2026-06-29 10:22:13.942663','2026-06-29 10:22:13.942663','MG Road','Bangalore','darshan@gmail.com','Male','9876543210','Darshan'),(2,0,'2026-06-29 10:23:06.546492','2026-06-29 10:23:06.546492','BTM Layout','Bangalore','rahul@gmail.com','Male','9876543211','Rahul'),(3,0,'2026-06-29 10:23:21.972942','2026-06-29 10:23:21.972942','Whitefield','Bangalore','sneha@gmail.com','Female','9876543212','Sneha'),(4,0,'2026-06-29 10:23:33.324388','2026-06-29 10:23:33.324388','Rajajinagar','Mysore','priya@gmail.com','Female','9876543213','Priya'),(5,0,'2026-06-29 10:23:49.961907','2026-06-29 10:23:49.961907','Vijayanagar','Hubli','kiran@gmail.com','Male','9876543214','Kiran');
/*!40000 ALTER TABLE `patients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prescriptions`
--

DROP TABLE IF EXISTS `prescriptions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prescriptions` (
  `appointment_id` int DEFAULT NULL,
  `prescription_id` int NOT NULL AUTO_INCREMENT,
  `version` int DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `modified_date` datetime(6) DEFAULT NULL,
  `dosage` varchar(255) DEFAULT NULL,
  `medicine` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`prescription_id`),
  UNIQUE KEY `UKr0yn695qg51gn0iskc8p0h2ii` (`appointment_id`),
  CONSTRAINT `FKe2fpvlkkcgcd40k4ufyyju2al` FOREIGN KEY (`appointment_id`) REFERENCES `appointments` (`appointment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prescriptions`
--

LOCK TABLES `prescriptions` WRITE;
/*!40000 ALTER TABLE `prescriptions` DISABLE KEYS */;
INSERT INTO `prescriptions` VALUES (1,1,0,'2026-06-29 10:46:35.515735','2026-06-29 10:46:35.515735','500 mg','Paracetamol'),(2,2,0,'2026-06-29 10:48:18.570697','2026-06-29 10:48:18.570697','250 mg','Amoxicillin'),(3,3,0,'2026-06-29 10:48:31.568676','2026-06-29 10:48:31.568676','10 mg','Cetirizine'),(4,4,0,'2026-06-29 10:48:48.340946','2026-06-29 10:48:48.340946','600 IU','Vitamin D'),(5,5,0,'2026-06-29 10:49:05.535575','2026-06-29 10:49:05.535575','400 mg','Ibuprofen');
/*!40000 ALTER TABLE `prescriptions` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-06-29 17:57:25
