-- MySQL dump 10.13  Distrib 5.7.23, for Linux (x86_64)
--
-- Host: localhost    Database: getwindb
-- ------------------------------------------------------
-- Server version	5.7.23-0ubuntu0.18.04.1

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
-- Table structure for table `Cart`
--

DROP TABLE IF EXISTS `Cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Cart` (
  `username` varchar(255) NOT NULL,
  `pid` int(11) NOT NULL,
  `qincart` int(11) DEFAULT NULL,
  `price` double(10,2) DEFAULT NULL,
  PRIMARY KEY (`username`,`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Cart`
--

LOCK TABLES `Cart` WRITE;
/*!40000 ALTER TABLE `Cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `Cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Customer`
--

DROP TABLE IF EXISTS `Customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Customer` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `pincode` int(11) DEFAULT NULL,
  `phone_no` bigint(20) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`customer_id`),
  KEY `username` (`username`),
  CONSTRAINT `Customer_ibfk_1` FOREIGN KEY (`username`) REFERENCES `Userdata` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Customer`
--

LOCK TABLES `Customer` WRITE;
/*!40000 ALTER TABLE `Customer` DISABLE KEYS */;
INSERT INTO `Customer` VALUES (8,'Abhinav','Room No 59 CV Raman Hostel IIT (BHU)','Varanasi','Uttar Pradesh',221005,7206823623,'abhigupta768@gmail.com','abhinav'),(9,'Divyansh','H-8 Nehind Nagar Palika Park','Kotputli','Rajasthan',303108,9783817572,'kittudon@gmail.com','kittu');
/*!40000 ALTER TABLE `Customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Deliveryentry`
--

DROP TABLE IF EXISTS `Deliveryentry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Deliveryentry` (
  `invid` int(11) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `pincode` int(11) DEFAULT NULL,
  `phno` bigint(20) DEFAULT NULL,
  `dsid` int(11) DEFAULT NULL,
  `dod` date DEFAULT NULL,
  `isdelivered` varchar(255) DEFAULT NULL,
  KEY `invid` (`invid`),
  KEY `dsid` (`dsid`),
  CONSTRAINT `Deliveryentry_ibfk_1` FOREIGN KEY (`invid`) REFERENCES `Invoice` (`invid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Deliveryentry_ibfk_2` FOREIGN KEY (`dsid`) REFERENCES `Deliveryservice` (`sid`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Deliveryentry`
--

LOCK TABLES `Deliveryentry` WRITE;
/*!40000 ALTER TABLE `Deliveryentry` DISABLE KEYS */;
INSERT INTO `Deliveryentry` VALUES (34,'H12 Mahesh Nagar','Ambala Cantt','Haryana',133001,7206823623,NULL,NULL,'No'),(35,'Room No 59 CV Raman Hostel IIT (BHU)','Varanasi','Uttar Pradesh',221005,7206823623,9,'2018-10-06','Yes'),(36,'H12 Mahesh Nagar','Ambala Cantt','Haryana',133001,7206823623,NULL,NULL,'No'),(37,'Room No 59 CV Raman Hostel IIT (BHU)','Varanasi','Uttar Pradesh',221005,9783817572,NULL,NULL,'No');
/*!40000 ALTER TABLE `Deliveryentry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Deliveryservice`
--

DROP TABLE IF EXISTS `Deliveryservice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Deliveryservice` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `phno` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Deliveryservice`
--

LOCK TABLES `Deliveryservice` WRITE;
/*!40000 ALTER TABLE `Deliveryservice` DISABLE KEYS */;
INSERT INTO `Deliveryservice` VALUES (8,'DTDC',7894561231),(9,'Gati',7894561232);
/*!40000 ALTER TABLE `Deliveryservice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Employee`
--

DROP TABLE IF EXISTS `Employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Employee` (
  `emp_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `pincode` int(11) DEFAULT NULL,
  `phone_no` bigint(20) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `shift_timings` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`emp_id`),
  KEY `username` (`username`),
  CONSTRAINT `Employee_ibfk_1` FOREIGN KEY (`username`) REFERENCES `Userdata` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Employee`
--

LOCK TABLES `Employee` WRITE;
/*!40000 ALTER TABLE `Employee` DISABLE KEYS */;
INSERT INTO `Employee` VALUES (10,'Sunil','121, Prabhu Prem Puram','Ambala Cantt','Haryana',133001,7894561233,'sunil','9am-4pm'),(11,'Prem','7, Shastri Colony','Amabala Cantt','Haryana',133001,7894561234,'prem','3pm-9pm');
/*!40000 ALTER TABLE `Employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Invoice`
--

DROP TABLE IF EXISTS `Invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Invoice` (
  `invid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `dog` date DEFAULT NULL,
  `amount` double(10,2) DEFAULT NULL,
  PRIMARY KEY (`invid`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Invoice`
--

LOCK TABLES `Invoice` WRITE;
/*!40000 ALTER TABLE `Invoice` DISABLE KEYS */;
INSERT INTO `Invoice` VALUES (34,'abhinav','2018-10-01',16080.00),(35,'abhinav','2018-10-01',1128.00),(36,'abhinav','2018-10-01',13000.00),(37,'kittu','2018-10-01',1256.00);
/*!40000 ALTER TABLE `Invoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `InvoiceEntry`
--

DROP TABLE IF EXISTS `InvoiceEntry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `InvoiceEntry` (
  `invid` int(11) NOT NULL,
  `pid` int(11) NOT NULL,
  `qinentry` int(11) DEFAULT NULL,
  `price` double(10,2) DEFAULT NULL,
  PRIMARY KEY (`invid`,`pid`),
  CONSTRAINT `InvoiceEntry_ibfk_1` FOREIGN KEY (`invid`) REFERENCES `Invoice` (`invid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `InvoiceEntry`
--

LOCK TABLES `InvoiceEntry` WRITE;
/*!40000 ALTER TABLE `InvoiceEntry` DISABLE KEYS */;
INSERT INTO `InvoiceEntry` VALUES (34,15,10,128.00),(34,17,2,7000.00),(34,18,1,800.00),(35,15,1,128.00),(35,16,1,1000.00),(36,16,13,1000.00),(37,15,2,128.00),(37,16,1,1000.00);
/*!40000 ALTER TABLE `InvoiceEntry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Manufacturer`
--

DROP TABLE IF EXISTS `Manufacturer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Manufacturer` (
  `manufacturer_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `website` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `pincode` int(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone_no` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`manufacturer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Manufacturer`
--

LOCK TABLES `Manufacturer` WRITE;
/*!40000 ALTER TABLE `Manufacturer` DISABLE KEYS */;
INSERT INTO `Manufacturer` VALUES (8,'Havells','Industrial Area','havells.com','Chandigarh','',133004,'pr@havells.com',7894561230),(9,'Lloyd','Industrial Area','lloyd.in','Ambala','Haryana',133001,'pr@lloyd.in',7894561230);
/*!40000 ALTER TABLE `Manufacturer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PayLog`
--

DROP TABLE IF EXISTS `PayLog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PayLog` (
  `payid` int(11) NOT NULL AUTO_INCREMENT,
  `emp_id` int(11) DEFAULT NULL,
  `man_id` int(11) DEFAULT NULL,
  `dop` date DEFAULT NULL,
  `ptype` varchar(255) DEFAULT NULL,
  `amount` double(10,2) DEFAULT NULL,
  PRIMARY KEY (`payid`),
  KEY `emp_id` (`emp_id`),
  KEY `man_id` (`man_id`),
  CONSTRAINT `PayLog_ibfk_1` FOREIGN KEY (`emp_id`) REFERENCES `Employee` (`emp_id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `PayLog_ibfk_2` FOREIGN KEY (`man_id`) REFERENCES `Manufacturer` (`manufacturer_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PayLog`
--

LOCK TABLES `PayLog` WRITE;
/*!40000 ALTER TABLE `PayLog` DISABLE KEYS */;
INSERT INTO `PayLog` VALUES (7,NULL,9,'2018-09-18','Manufacturer',10000.00),(8,11,NULL,'2018-10-01','Employee',5000.00);
/*!40000 ALTER TABLE `PayLog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Product`
--

DROP TABLE IF EXISTS `Product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `mid` int(11) DEFAULT NULL,
  `type` varchar(255) NOT NULL,
  `hsncode` varchar(255) NOT NULL,
  `qinstock` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `cap` int(11) DEFAULT NULL,
  `pcksize` int(11) DEFAULT NULL,
  `swpsize` int(11) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `carea` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `wid` int(11) DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  KEY `mid` (`mid`),
  KEY `wid` (`wid`),
  CONSTRAINT `Product_ibfk_1` FOREIGN KEY (`mid`) REFERENCES `Manufacturer` (`manufacturer_id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `Product_ibfk_2` FOREIGN KEY (`wid`) REFERENCES `Warehouse` (`wid`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Product`
--

LOCK TABLES `Product` WRITE;
/*!40000 ALTER TABLE `Product` DISABLE KEYS */;
INSERT INTO `Product` VALUES (15,8,'Lighting','HVL001',187,128,NULL,8,NULL,'White',NULL,'LED Bulb',10),(16,9,'Cables','LLC001',485,1000,NULL,10,NULL,'Red',10,'Conductor Cables',11),(17,8,'Appliance','HVA001',8,7000,10,NULL,NULL,'Mehroon',NULL,'Air Cooler',12),(18,8,'Fans','HVF001',99,800,NULL,NULL,4,'Black',NULL,'Stark Fan',10);
/*!40000 ALTER TABLE `Product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Userdata`
--

DROP TABLE IF EXISTS `Userdata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Userdata` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Userdata`
--

LOCK TABLES `Userdata` WRITE;
/*!40000 ALTER TABLE `Userdata` DISABLE KEYS */;
INSERT INTO `Userdata` VALUES ('abhinav','12qwaszx','ROLE_USER'),('admin','admin123','ROLE_ADMIN'),('kittu','12qwaszx','ROLE_USER'),('prem','12qwaszx','ROLE_EMPLOYEE'),('sunil','12qwaszx','ROLE_EMPLOYEE');
/*!40000 ALTER TABLE `Userdata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Warehouse`
--

DROP TABLE IF EXISTS `Warehouse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Warehouse` (
  `wid` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `pincode` int(11) DEFAULT NULL,
  PRIMARY KEY (`wid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Warehouse`
--

LOCK TABLES `Warehouse` WRITE;
/*!40000 ALTER TABLE `Warehouse` DISABLE KEYS */;
INSERT INTO `Warehouse` VALUES (10,'Anaaj Mandi','Ambala Cantt','Haryana',133001),(11,'Gandhi Market','Ambala Cantt','Haryana',133001),(12,'Sector 22','Chandigarh','',133002);
/*!40000 ALTER TABLE `Warehouse` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-01 16:27:14
