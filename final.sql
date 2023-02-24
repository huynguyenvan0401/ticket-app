-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: ec2-18-141-168-81.ap-southeast-1.compute.amazonaws.com    Database: ticket_management
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `_user`
--

DROP TABLE IF EXISTS `_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `_user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `car_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKo8b9oglcr80ww4l8wq6bqrajl` (`car_id`),
  CONSTRAINT `FKo8b9oglcr80ww4l8wq6bqrajl` FOREIGN KEY (`car_id`) REFERENCES `car` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `_user`
--

LOCK TABLES `_user` WRITE;
/*!40000 ALTER TABLE `_user` DISABLE KEYS */;
INSERT INTO `_user` VALUES (1,'duonghk','Duong','Hoang Khanh','$2a$10$FFKwmzWpHQJtWuwPEv5NgeT3dUyQxXLsTJYFAPdSTgOBOlsPE5vUq',1),(2,'doanhnd6','Doanh','Nguyen','$2a$10$FFKwmzWpHQJtWuwPEv5NgeT3dUyQxXLsTJYFAPdSTgOBOlsPE5vUq',2),(3,'dokd','Do','Khuong','$2a$10$FFKwmzWpHQJtWuwPEv5NgeT3dUyQxXLsTJYFAPdSTgOBOlsPE5vUq',3),(4,'giangbh3','Giang','Doan','$2a$10$FFKwmzWpHQJtWuwPEv5NgeT3dUyQxXLsTJYFAPdSTgOBOlsPE5vUq',4),(5,'tuyendv6','Tuyen','Doan','$2a$10$FFKwmzWpHQJtWuwPEv5NgeT3dUyQxXLsTJYFAPdSTgOBOlsPE5vUq',5),(6,'haltt5','Ha','Doan','$2a$10$FFKwmzWpHQJtWuwPEv5NgeT3dUyQxXLsTJYFAPdSTgOBOlsPE5vUq',6),(7,'tiendv2','Tien','Doan','$2a$10$FFKwmzWpHQJtWuwPEv5NgeT3dUyQxXLsTJYFAPdSTgOBOlsPE5vUq',NULL),(8,'anhvt12','Anh','Thuy','$2a$10$FFKwmzWpHQJtWuwPEv5NgeT3dUyQxXLsTJYFAPdSTgOBOlsPE5vUq',NULL),(9,'anhptt4','Anh','Thuy','$2a$10$FFKwmzWpHQJtWuwPEv5NgeT3dUyQxXLsTJYFAPdSTgOBOlsPE5vUq',NULL);
/*!40000 ALTER TABLE `_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `car`
--

DROP TABLE IF EXISTS `car`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `car` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `capacity` bigint NOT NULL,
  `license_plate` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car`
--

LOCK TABLES `car` WRITE;
/*!40000 ALTER TABLE `car` DISABLE KEYS */;
INSERT INTO `car` VALUES (1,16,'Xe 1- DuongHk'),(2,16,'Xe 2 - DoanhND6'),(3,16,'Xe 3 - DoKD'),(4,16,'Xe 4 - GiangBH3'),(5,16,'Xe 5 - TuyenDv6'),(6,16,'Xe 6 - HaLTT5');
/*!40000 ALTER TABLE `car` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `checkin`
--

DROP TABLE IF EXISTS `checkin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `checkin` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `car_id` bigint DEFAULT NULL,
  `code_id` bigint DEFAULT NULL,
  `people_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKq6spnr6647cokcc2ltoaspbx6` (`car_id`),
  KEY `FKt6ays8u533dlpfkhl353nsace` (`code_id`),
  KEY `FK2e3dekxnkl9iyalfxbjn6fv7t` (`people_id`),
  CONSTRAINT `FK2e3dekxnkl9iyalfxbjn6fv7t` FOREIGN KEY (`people_id`) REFERENCES `people` (`id`),
  CONSTRAINT `FKq6spnr6647cokcc2ltoaspbx6` FOREIGN KEY (`car_id`) REFERENCES `car` (`id`),
  CONSTRAINT `FKt6ays8u533dlpfkhl353nsace` FOREIGN KEY (`code_id`) REFERENCES `code` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=162 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `checkin`
--

LOCK TABLES `checkin` WRITE;
/*!40000 ALTER TABLE `checkin` DISABLE KEYS */;
/*!40000 ALTER TABLE `checkin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `code`
--

DROP TABLE IF EXISTS `code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `code` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `code` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `code`
--

LOCK TABLES `code` WRITE;
/*!40000 ALTER TABLE `code` DISABLE KEYS */;
INSERT INTO `code` VALUES (1,'abcxyz','Travel Checkin');
/*!40000 ALTER TABLE `code` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `people`
--

DROP TABLE IF EXISTS `people`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `people` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `account` varchar(255) NOT NULL,
  `note` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `phone_number` varchar(255) NOT NULL,
  `is_room_master` tinyint(1) NOT NULL DEFAULT '0',
  `is_hold_room_key` tinyint(1) NOT NULL DEFAULT '0',
  `car_id` bigint DEFAULT NULL,
  `room_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKoi9xscn0n2cm6k9iow9rwstwu` (`car_id`),
  KEY `FK52rcvyx8jrudjcm5mh135ray0` (`room_id`),
  CONSTRAINT `FK52rcvyx8jrudjcm5mh135ray0` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`),
  CONSTRAINT `FKoi9xscn0n2cm6k9iow9rwstwu` FOREIGN KEY (`car_id`) REFERENCES `car` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=191 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `people`
--

LOCK TABLES `people` WRITE;
/*!40000 ALTER TABLE `people` DISABLE KEYS */;
INSERT INTO `people` VALUES (1,'ThuHT3','','0333897200',1,0,1,40),(2,'GiangVN1','','0399434998',1,0,1,47),(3,'CungNH','','0969816120',1,0,1,32),(4,'KyNV1','','0328220112',1,0,1,35),(5,'HieuVM12','','0385886411',0,0,1,35),(6,'LongTD9','','0339966432',0,0,1,33),(7,'HungNQ23','','0965694366',1,0,1,33),(8,'AnhPT65','','0886146199',0,0,1,32),(9,'HuanNV4','','033338223',0,0,1,32),(10,'LinhNV33','','0374108447',0,0,1,47),(11,'NhungNTH12','','0359003655',1,0,1,7),(12,'LinhNT49','','0969298979',0,0,1,33),(13,'AnNHT2','','0828633737',0,0,1,47),(14,'ThangLV11','','0975305444',1,0,1,8),(15,'AnhPTT4','','0943457086',1,0,1,1),(16,'tanbm','','0912950058',0,0,1,62),(17,'HungNP16','','0399541039',1,0,1,30),(18,'DuongHK','','0915250205',1,0,1,42),(19,'AnhVT12','','0902034489',0,0,1,1),(20,'ThangLQ4','','0364384662',0,0,1,70),(21,'HungNN14','','0934653489',1,0,1,62),(22,'DatPT52','','0354080257',1,0,1,31),(23,'DuND2','','0335359992',0,0,1,31),(24,'LongDT21','','0365383060',0,0,1,31),(25,'Maodx','','0393298686',1,0,1,25),(26,'KhienPC','','0931665343',1,0,1,61),(27,'LamPV','','0973867701',0,0,1,61),(28,'VanTT13','','0327825723',0,0,1,16),(29,'TinhVV1','','0975893152',0,0,1,8),(30,'QuynhLT8','','0364420687',1,0,2,14),(31,'QuyNV5','','0988186029',1,0,2,56),(32,'ThoDT5','','096097134',0,0,2,14),(33,'PhongVV1','','0395436290',0,0,2,35),(34,'DoanhND6','','0989296761',1,0,2,71),(35,'DucNL','','0978115394',0,0,2,71),(36,'ThomTT1','','0326200393',1,0,2,15),(37,'HieuTT26','','0358569171',1,0,2,39),(38,'AnNX5','','0904585640',0,0,2,45),(39,'LocDX6','','0376163559',0,0,2,60),(40,'ChamPTH','','0396411097',0,0,2,15),(41,'ManhND16','','0984622396',1,0,2,59),(42,'DangNH27','','0839621234',0,0,2,59),(43,'ThaoTTT21','','0889417095',0,0,2,40),(44,'NamNV47','','0987893023',0,0,NULL,45),(45,'DungPK','','0988817318',1,0,2,16),(46,'MyDV','','0934561419',0,0,2,39),(47,'HoangPM10','','0395248232',1,0,2,17),(48,'NhatNV3','','0366577738',0,0,2,17),(49,'GiangVT1','','0915648802',0,0,2,39),(50,'PhongTH4','','0868911316',1,0,2,60),(51,'TungVV3','','0367633120',0,0,2,17),(52,'VuPV1','','0971200033',1,0,2,45),(53,'NhuHQ','','0396140147',0,0,2,40),(54,'AnhNDN3','','0962396877',1,0,3,50),(55,'GiangDM','','0356106334',0,0,3,50),(56,'NghiaTV8','','0362967272',1,0,3,51),(57,'ThuanTV4','','038868408',0,0,NULL,51),(58,'PhuongTD7','','0327914665',0,0,3,24),(59,'SonMN2','','0989432504',1,0,3,22),(60,'KhanhTV7','','0337529272',0,0,3,26),(62,'HoangVV19','','0898712653',0,0,3,27),(63,'TrungDD17','','0388483406',0,0,3,27),(64,'SonHV9','','0977970523',1,0,3,26),(65,'HuongLT31','','0364443842',1,0,3,2),(66,'HaiNV42','','0383037956',0,0,NULL,34),(67,'HuynhDX','','0965266856',1,0,3,34),(68,'PhongTV9','','0979293402',0,0,3,34),(69,'MinhNQ43','','0982056336',0,0,3,36),(70,'ChienPS','','0328773342',1,0,3,36),(71,'DoKD','','0343657370',1,0,3,38),(72,'HauDT3','','0965476583',0,0,3,36),(73,'ThaoNV13','','0393264411',0,0,3,38),(74,'AnhLT78','','0336010591',1,0,3,44),(75,'VuBN','','0972382678',1,0,4,55),(76,'HoanNV2','','0961486356',0,0,4,55),(77,'HungND85','','0828991799',0,0,4,70),(78,'KienNT76','','0968366715',1,0,4,64),(79,'AnhBV10','','0394668699',0,0,4,64),(80,'DaoHT5','','0963004510',0,0,4,2),(81,'GiangBH3','','0855230399',0,0,4,64),(82,'ThaoNT55','','0342539524',1,0,4,3),(83,'QuyLC','','0388351463',1,0,4,28),(84,'NhungTT7','','098879627',0,0,4,3),(85,'NamVH5','','0915332386',1,0,4,24),(86,'AnhTQ25','','0858816730',0,0,4,22),(87,'TrungNT65','','0376916373',0,0,4,50),(88,'NguyenLT11','','0398088987',0,0,4,4),(89,'ManhDT7','','0393375466',1,0,4,65),(90,'TungTL','','0941778397',0,0,4,65),(91,'QuangNH26','','0342708999',0,0,4,65),(92,'TanNV13','','0334443416',0,0,4,65),(93,'DucNX14','','0904912207',0,0,4,51),(94,'DungCT2','','0358102626',0,0,4,64),(95,'TrangTTH8','','0975561517',1,0,4,9),(96,'HoangND10','','0359842567',0,0,4,28),(97,'ChinhND11','','0392690567',0,0,4,44),(98,'TuyenDV6','','0347270055',1,0,5,46),(99,'DiuNT2','','0988526601',1,0,5,5),(100,'DangDA','','0862203970',0,0,5,46),(101,'HungLQ16','','0979127480',1,0,5,69),(102,'TaiLT4','','0936677660',0,0,5,46),(103,'ThanhVD9','','0911647203',1,0,5,19),(105,'ThanhNT48','','0967902169',0,0,5,9),(106,'HungDC2','','0962319900',1,0,5,21),(107,'VietHM1','','0963275501',0,0,5,25),(108,'KhanhNV110','','0971656598',0,0,5,69),(109,'TrangNT97','','0912670080',1,0,5,11),(110,'ThuanDT3','','0345689004',1,0,5,29),(111,'QuanND5','','0914855785',1,0,5,43),(112,'HoangNN104','','0824864688',1,0,5,41),(113,'HuyNV21','','0373210699',0,0,5,41),(114,'SonTV15','','0398882391',0,0,5,25),(115,'HaDT21','','0342066836',0,0,5,10),(116,'ThanhDT13','','0984032286',1,0,5,53),(117,'TiepNK1','','0903254130',0,0,5,53),(118,'HungNT31','','0839400071',0,0,5,58),(119,'VietH4','','0395558546',1,0,5,58),(120,'ThanhDV20','','0326700938',0,0,5,67),(121,'HuongNTL13','','0397671837',1,0,5,10),(122,'KhanhTT7','','0969345358',0,0,5,11),(123,'TrangNT125','','0966470350',1,0,5,12),(124,'NgoanPTP','','0946724129',1,0,5,4),(125,'HieuNV41','','0387039951',1,0,5,67),(126,'TienDV2','','0377730006',0,0,5,67),(127,'HuongNTT27','','0972081991',1,0,5,13),(128,'LinhNX5','','0965218986',1,0,5,70),(129,'KienNV12','','0865343826',0,0,5,41),(130,'LongPN4','','0858086606',0,0,5,69),(131,'CuongLH6','','0364063866',0,0,5,43),(132,'ThanhPY','','0336041996',0,0,5,19),(133,'TienNV5','','0356064615',0,0,5,71),(134,'nhungnth3','','0986557605',0,0,5,13),(135,'DucNH3','','0907489789',0,0,5,71),(136,'DatPTM','','0972291907',0,0,5,43),(137,'HuongNT20','','0973932628',0,0,5,12),(138,'ThaoCN','','0964303432',1,0,6,48),(139,'AnhLH','','0778330369',0,0,6,48),(140,'ThaoLT10','','0336607846',1,0,6,6),(141,'BachNH2','','0393879530',0,0,6,52),(142,'HoaTTT4','','0368158511',0,0,6,6),(143,'HoangHD3','','0774372121',0,0,6,23),(144,'HiepDV5','','0388542186',1,0,6,49),(145,'haltt5','','0339856504',0,0,6,5),(146,'TrungVQ8','','0388536261',1,0,6,20),(147,'HoanTD','','0964531350',0,0,6,20),(148,'AnhVH6','','0388493568',0,0,6,23),(149,'SonTSH','','0904697036',0,0,6,18),(150,'TuND1','','0968257028',1,0,6,18),(151,'HieuPV14','','0965930913',0,0,6,49),(153,'AnhNV32','','0943970481',1,0,6,37),(155,'ThangTV28','','0346815300',0,0,6,30),(156,'QuyetVV6','','0386577239',0,0,6,52),(157,'VinhNK2','','0364308484',0,0,6,54),(158,'PhucNM9','','0889934347',1,0,6,23),(159,'VinhNT50','','0966038934',0,0,6,48),(160,'LongTT20','','0982501077',1,0,6,54),(161,'TuLX','','0787395999',0,0,6,57),(162,'NgocPT7','','0968409197',0,0,6,7),(163,'LongNKN1','','0348125599',0,0,6,63),(164,'NgocVQ','','0904099677',0,0,6,63),(165,'DatNT160','','0969935445',1,0,6,66),(166,'NamTV4','','0989288156',0,0,6,66),(167,'KhoiVT2','','0704109578',0,0,6,68),(168,'VietND20','','0969094297',0,0,6,63),(169,'NghiaHV5','','0823221040',1,0,6,68),(170,'LongPT26','','0975450829',0,0,6,68),(171,'ChungTT5','','0942359987',0,0,6,49),(172,'HoanVN1','','0339099862',0,0,6,18),(173,'VyNND','','0328700341',0,0,6,68),(174,'NgocDQ1','','0366136864',0,0,6,66),(175,'NghiaDT13','','0988479697',0,0,6,20),(176,'NamHD3','','0386266886',0,0,6,30),(177,'TuanNM74','','0397851852',0,0,6,37),(178,'GiangH2','','0989344513',1,0,6,52),(179,'CuongPK2','','0389156496',1,0,6,63),(180,'DaiNV4','','',0,0,NULL,NULL),(181,'DatHT15','','0964697689',0,0,NULL,69),(182,'DuyPQ3','','0914532528',0,0,NULL,24),(183,'HaiDD1','','0984197099',0,0,NULL,21),(184,'KhoiNV6','','0868920091',0,0,NULL,42),(185,'LongLH6','','097508380',0,0,NULL,56),(186,'LongMV2','','0344287032',0,0,NULL,28),(187,'MinhTC8','','0354506119',0,0,NULL,29),(188,'TrungNT34','','0915012193',0,0,NULL,42),(189,'LuanNT25',NULL,'0327751717',0,0,NULL,67),(190,'ThanhPV31',NULL,'0989007197',0,0,NULL,29);
/*!40000 ALTER TABLE `people` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'USER'),(2,'ADMIN'),(3,'DRIVER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `number` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (1,'101','Khu Xóm Nhỏ'),(2,'102','Khu Xóm Nhỏ'),(3,'103','Khu Xóm Nhỏ'),(4,'104','Khu Xóm Nhỏ'),(5,'105','Khu Xóm Nhỏ'),(6,'106','Khu Xóm Nhỏ'),(7,'107','Khu Xóm Nhỏ'),(8,'108','Khu Xóm Nhỏ'),(9,'109','Khu Xóm Nhỏ'),(10,'110','Khu Xóm Nhỏ'),(11,'111','Khu Xóm Nhỏ'),(12,'112','Khu Xóm Nhỏ'),(13,'113','Khu Xóm Nhỏ'),(14,'114','Khu Xóm Nhỏ'),(15,'115','Khu Xóm Nhỏ'),(16,'116','Khu Xóm Nhỏ'),(17,'216','Khu Xóm Đồi'),(18,'203','Khu Xóm Đồi'),(19,'204','Khu Xóm Đồi'),(20,'207','Khu Xóm Đồi'),(21,'208','Khu Xóm Đồi'),(22,'211','Khu Xóm Đồi'),(23,'212','Khu Xóm Đồi'),(24,'213','Khu Xóm Đồi'),(25,'801','Khu Vườn Hồng'),(26,'802','Khu Vườn Hồng'),(27,'803','Khu Vườn Hồng'),(28,'804','Khu Vườn Hồng'),(29,'805','Khu Vườn Hồng'),(30,'806','Khu Vườn Hồng'),(31,'807','Khu Vườn Hồng'),(32,'808','Khu Vườn Hồng'),(33,'809','Khu Vườn Hồng'),(34,'810','Khu Vườn Hồng'),(35,'811','Khu Vườn Hồng'),(36,'812','Khu Vườn Hồng'),(37,'813','Khu Vườn Hồng'),(38,'814','Khu Vườn Hồng'),(39,'815','Khu Vườn Hồng'),(40,'816','Khu Vườn Hồng'),(41,'817','Khu Vườn Hồng'),(42,'818','Khu Vườn Hồng'),(43,'301','Khu Nhà Nổi'),(44,'302','Khu Nhà Nổi'),(45,'303','Khu Nhà Nổi'),(46,'304','Khu Nhà Nổi'),(47,'305','Khu Nhà Nổi'),(48,'306','Khu Nhà Nổi'),(49,'307','Khu Nhà Nổi'),(50,'308','Khu Nhà Nổi'),(51,'309','Khu Nhà Nổi'),(52,'310','Khu Nhà Nổi'),(53,'501','Khu Phố Nhỏ'),(54,'502','Khu Phố Nhỏ'),(55,'504','Khu Phố Nhỏ'),(56,'506','Khu Phố Nhỏ'),(57,'508','Khu Phố Nhỏ'),(58,'510','Khu Phố Nhỏ'),(59,'512','Khu Phố Nhỏ'),(60,'514','Khu Phố Nhỏ'),(61,'516','Khu Phố Nhỏ'),(62,'518','Khu Phố Nhỏ'),(63,'503','Khu Phố Nhỏ 3G'),(64,'505','Khu Phố Nhỏ 3G'),(65,'507','Khu Phố Nhỏ 3G'),(66,'509','Khu Phố Nhỏ 3G'),(67,'511','Khu Phố Nhỏ 3G'),(68,'513','Khu Phố Nhỏ 3G'),(69,'515','Khu Phố Nhỏ 3G'),(70,'517','Khu Phố Nhỏ 3G'),(71,'519','Khu Phố Nhỏ 3G');
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `ticket_num` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FKniaqoclrvx138sjw9hsollqav` FOREIGN KEY (`user_id`) REFERENCES `_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (7,2),(8,2),(9,2),(1,3),(2,3),(3,3),(4,3),(5,3),(6,3);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-24  0:43:20
