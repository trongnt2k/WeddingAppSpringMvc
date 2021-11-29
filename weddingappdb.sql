-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: weddingappdb
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
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `content` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_id` int NOT NULL,
  `wedding_id` int NOT NULL,
  `created_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_comment_idx` (`user_id`),
  KEY `fk_wedding_comment_idx` (`wedding_id`),
  CONSTRAINT `fk_user_comment` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `fk_wedding_comment` FOREIGN KEY (`wedding_id`) REFERENCES `wedding` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (1,'Hay!!!',1,1,'2021-12-11 00:00:00'),(2,'Tuyệt!!',1,1,'2021-12-12 00:00:00'),(3,'Rất tuyệt !!!!!',2,8,'2021-11-29 00:00:00'),(4,'Tuyệt vời!!!!',2,10,'2021-11-29 00:00:00'),(5,'Dịch vụ tốt !!!!',2,11,'2021-11-29 00:00:00'),(6,'Dịch vụ chưa tốt',2,12,'2021-11-29 00:00:00'),(7,'Dịch vụ tuyệt vời!!!!',2,13,'2021-11-29 00:00:00'),(8,'Dịch vụ chưa tốt !!!!',2,8,'2021-11-29 00:00:00'),(9,'Dịch vụ đạt yêu cầu !!!!',2,12,'2021-11-29 00:00:00');
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dishesanddrink`
--

DROP TABLE IF EXISTS `dishesanddrink`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dishesanddrink` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `dishes_drink_images` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  `price` decimal(10,0) NOT NULL,
  `active` bit(1) DEFAULT b'1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dishesanddrink`
--

LOCK TABLES `dishesanddrink` WRITE;
/*!40000 ALTER TABLE `dishesanddrink` DISABLE KEYS */;
INSERT INTO `dishesanddrink` VALUES (2,'Súp tuyết nhĩ thịt gà xé','https://res.cloudinary.com/dzi8njrne/image/upload/v1638170816/zybbo8k3ukocahilufpz.jpg',100000,NULL),(3,'Nộm thập cẩm','https://res.cloudinary.com/dzi8njrne/image/upload/v1638170816/zybbo8k3ukocahilufpz.jpg',2000000,NULL),(4,'Súp măng cua','https://res.cloudinary.com/dzi8njrne/image/upload/v1638170816/zybbo8k3ukocahilufpz.jpg',150000,NULL),(5,'Lẩu bò','https://res.cloudinary.com/dzi8njrne/image/upload/v1638170816/zybbo8k3ukocahilufpz.jpg',300000,NULL),(6,'Gà ta rang muối','https://res.cloudinary.com/dzi8njrne/image/upload/v1638170816/zybbo8k3ukocahilufpz.jpg',2000000,NULL),(7,'Tôm sú nướng tiêu','https://res.cloudinary.com/dzi8njrne/image/upload/v1638170816/zybbo8k3ukocahilufpz.jpg',75000,_binary ''),(8,'Vịt nấu tiêu xanh – bánh mì','https://res.cloudinary.com/dzi8njrne/image/upload/v1638170816/zybbo8k3ukocahilufpz.jpg',45000,_binary ''),(9,'Cơm Thố Bào Ngư Quay','https://res.cloudinary.com/dzi8njrne/image/upload/v1638170816/zybbo8k3ukocahilufpz.jpg',35000,_binary ''),(10,'Canh bóng thập cẩm','https://res.cloudinary.com/dzi8njrne/image/upload/v1638170816/zybbo8k3ukocahilufpz.jpg',37000,_binary ''),(11,'Chè hồ đào','https://res.cloudinary.com/dzi8njrne/image/upload/v1638170816/zybbo8k3ukocahilufpz.jpg',10000,_binary '');
/*!40000 ALTER TABLE `dishesanddrink` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `menu_images` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,'Thực đơn cổ điển','https://res.cloudinary.com/dzi8njrne/image/upload/v1638170967/gysp6dcwf7bmkqfo7zlf.jpg'),(2,'Thực đơn hiện đại','https://res.cloudinary.com/dzi8njrne/image/upload/v1638170967/gysp6dcwf7bmkqfo7zlf.jpg'),(3,'Thực đơn Hàn Quốc','https://res.cloudinary.com/dzi8njrne/image/upload/v1638170967/gysp6dcwf7bmkqfo7zlf.jpg'),(4,'Thực đơn Trung Quốc','https://res.cloudinary.com/dzi8njrne/image/upload/v1638170967/gysp6dcwf7bmkqfo7zlf.jpg'),(17,'Thực đơn Châu Âu','https://res.cloudinary.com/dzi8njrne/image/upload/v1638170967/gysp6dcwf7bmkqfo7zlf.jpg'),(18,'Thực đơn bình dân','https://res.cloudinary.com/dzi8njrne/image/upload/v1638170967/gysp6dcwf7bmkqfo7zlf.jpg');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu_dishesanddrink`
--

DROP TABLE IF EXISTS `menu_dishesanddrink`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu_dishesanddrink` (
  `id` int NOT NULL AUTO_INCREMENT,
  `menu_id` int NOT NULL,
  `dishesanddrink_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_dishesanddrink_menudishesanddrink_idx` (`dishesanddrink_id`),
  KEY `fk_menu_menudishesanddrink_idx` (`menu_id`),
  CONSTRAINT `fk_dishesanddrink_menudishesanddrink` FOREIGN KEY (`dishesanddrink_id`) REFERENCES `dishesanddrink` (`id`),
  CONSTRAINT `fk_menu_menudishesanddrink` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu_dishesanddrink`
--

LOCK TABLES `menu_dishesanddrink` WRITE;
/*!40000 ALTER TABLE `menu_dishesanddrink` DISABLE KEYS */;
INSERT INTO `menu_dishesanddrink` VALUES (1,1,3),(2,2,3),(3,3,3),(4,1,2),(5,1,4),(6,2,4),(7,3,4),(8,17,2),(9,17,3),(10,17,4),(11,17,5),(12,18,8),(13,18,9),(14,18,10),(15,18,11),(21,4,6),(22,4,2),(23,4,3),(24,4,4),(25,4,5),(42,2,10),(43,2,8),(44,2,7),(45,2,5),(46,3,4),(47,3,2),(48,3,7),(49,3,8),(50,18,6);
/*!40000 ALTER TABLE `menu_dishesanddrink` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service`
--

DROP TABLE IF EXISTS `service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `service` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `service_images` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `active` bit(1) DEFAULT b'1',
  `description` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service`
--

LOCK TABLES `service` WRITE;
/*!40000 ALTER TABLE `service` DISABLE KEYS */;
INSERT INTO `service` VALUES (1,'Thiết kế thiệp cưới','https://res.cloudinary.com/dzi8njrne/image/upload/v1634484903/zeoutxnfd5gskifmq1ys.jpg',500000,NULL,'Giải tỏa căng thẳng khi tổ chức đám cưới và sáng tạo những tấm thiệp cưới tuyệt đẹp mà mọi người đều yêu thích'),(2,'Trang điểm ngày cưới','https://res.cloudinary.com/dzi8njrne/image/upload/v1634484903/zeoutxnfd5gskifmq1ys.jpg',600000,_binary '','Với dịch vụ đám cưới trọn gói bạn cũng không còn phải lo lắng nên trang điểm cô dâu ở đâu, trang điểm thế nào cho đẹp. Những chuyên gia trang điểm của cửa hàng áo cưới sẽ tư vấn và giúp bạn lựa chọn cách trang điểm phù hợp, tôn lên những nét đẹp của gương mặt, che đi những nhược điểm. Bạn sẽ trở nên xinh đẹp, thật nổi bật trước các vị quan khách.'),(3,'Phim ảnh cưới','https://res.cloudinary.com/dzi8njrne/image/upload/v1634484903/zeoutxnfd5gskifmq1ys.jpg',700000,_binary '','Bạn sẽ không cần lo lắng về việc tìm kiếm một studio chụp ảnh cưới nữa khi lựa chọn dịch vụ cưới trọn gói. Những cửa hàng áo cưới sẽ giúp bạn tìm kiếm địa điểm, concept và chọn lựa trang phục chụp ảnh phù hợp với sở thích cũng như yêu cầu của bạn.'),(4,'Trang trí tiệc cưới','https://res.cloudinary.com/dzi8njrne/image/upload/v1634484903/zeoutxnfd5gskifmq1ys.jpg',1000000,NULL,'Tùy từng phong cách mà cửa hàng áo cưới trọn gói sẽ giúp bạn sắp xếp, tổ chức tiệc cưới phù hợp. Từ việc trang trí rạp, cổng đám cưới, sắp xếp chỗ ngồi quan khách, cách để ảnh cưới, bánh kem, sâm banh chúc mừng.. sẽ được chuẩn bị chu đáo'),(5,'Vũ đoàn nhảy múa, Mc dẫn chương trình','https://res.cloudinary.com/dzi8njrne/image/upload/v1634484903/zeoutxnfd5gskifmq1ys.jpg',1500000,NULL,'Có thể nói nghề MC đám cưới là nghề làm dâu trăm họ và cũng vô cùng cần thiết trong việc tạo không khí cho tiệc cưới. Bởi nếu lời dẫn cưới có hay đến mấy nhưng rơi vào tay MC không chuyên thì mọi chuyện có thể biến thành thảm họa. Thực tế đã có không ít cặp đôi gặp tình huống dở khóc dở cười vì MC đám cưới vô duyên khiến sự trang trọng, ý nghĩa của bữa tiệc sẽ mất hết. Vì vậy, chọn MC dẫn chương trình đám cưới là một trong những khâu vô cùng quan trọng của đám cưới.'),(6,'Thuê trang phục cưới','https://res.cloudinary.com/dzi8njrne/image/upload/v1634484903/zeoutxnfd5gskifmq1ys.jpg',2000000,NULL,'Bạn thích những chiếc áo cưới lộng lẫy hay những chiếc áo cưới đơn giản mà vẫn sang trọng, thu hút? Bên cạnh việc đem đến những chiếc váy cưới đẹp, đa dạng phong cách, cửa hàng áo cưới trọn gói còn giúp bạn chọn lựa chiếc váy phù hợp với thân hình và phong cách ngày cưới, giúp bạn trở thành cô dâu xinh đẹp nhất trong ngày trọng đại ấy.'),(7,'Phụ kiện cưới','https://res.cloudinary.com/dzi8njrne/image/upload/v1634484903/zeoutxnfd5gskifmq1ys.jpg',2000000,NULL,'Những phụ kiện cưới: hoa cầm tay, hoa cài áo chú rể, trang sức cô dâu… tưởng chừng khá dễ chuẩn bị nhưng nếu lựa chọn không khéo, kết hợp với trang phục không tinh ý, có thể biến bạn thành cô dâu quá lòe loẹt hay nhạt nhòa, không mấy ấn tượng. Những cửa hàng áo cưới trọn gói sẽ giúp bạn chuẩn bị tất cả những phụ kiện phù hợp cho ngày hạnh phúc.');
/*!40000 ALTER TABLE `service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  `last_name` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  `username` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `active` bit(1) DEFAULT b'1',
  `avatar` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_role` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Nguyá»n Huy','Trá»ng','1851050160trong@ou.edu.vn',NULL,'huytrong234','$2a$10$v60LvO4EpUO9/JyIsakdHeVXRVEMi6lBTdX9Yxqj7cewqbKST3o9m',NULL,NULL,'ROLE_USER'),(2,'Nguyễn Huy','Trọng','phuongminh050@gmail.com',NULL,'admin','$2a$10$/T4djsWqvRdn2ZhJgAhMiuiViE0jma982ZFpxyaNV5ZO6hcN5QqXG',NULL,'https://res.cloudinary.com/dzi8njrne/image/upload/v1635590937/ryzzj8lea83dkmffmm9v.jpg','ROLE_ADMIN');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wedding`
--

DROP TABLE IF EXISTS `wedding`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wedding` (
  `id` int NOT NULL AUTO_INCREMENT,
  `number_desk` int NOT NULL,
  `organize_date` datetime NOT NULL,
  `total_price` decimal(10,0) NOT NULL,
  `description` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `menu_id` int DEFAULT NULL,
  `weddinghall_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_wedding_weddinghall_idx` (`weddinghall_id`),
  KEY `fk_wedding_menu_idx` (`menu_id`),
  KEY `fk_wedding_user_idx` (`user_id`),
  CONSTRAINT `fk_wedding_menu` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`id`),
  CONSTRAINT `fk_wedding_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `fk_wedding_weddinghall` FOREIGN KEY (`weddinghall_id`) REFERENCES `weddinghall` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wedding`
--

LOCK TABLES `wedding` WRITE;
/*!40000 ALTER TABLE `wedding` DISABLE KEYS */;
INSERT INTO `wedding` VALUES (1,300,'2021-09-24 00:00:00',500000,NULL,NULL,NULL,1),(8,100,'2021-10-20 00:00:00',221000000,'',1,4,NULL),(10,100,'2021-10-20 00:00:00',221000000,'test 5',1,4,2),(11,100,'2021-11-03 00:00:00',220500000,'Tiệc cưới Huy Trọng',1,4,1),(12,100,'2021-11-12 00:00:00',220500000,'Tiệc cưới ',2,5,1),(13,100,'2021-12-02 00:00:00',283400000,'Tiệc cưới new',2,5,2),(14,200,'2021-11-09 00:00:00',544400000,'Tiệc cưới mới',2,7,2),(15,300,'2021-11-04 00:00:00',670200000,'Tiệc cưới hoành tráng',18,8,2),(16,400,'2021-11-11 00:00:00',931100000,'Tiệc cưới bình dân',1,9,2);
/*!40000 ALTER TABLE `wedding` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wedding_service`
--

DROP TABLE IF EXISTS `wedding_service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wedding_service` (
  `id` int NOT NULL AUTO_INCREMENT,
  `wedding_id` int NOT NULL,
  `service_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fl_wedding_weddingservice_idx` (`wedding_id`),
  KEY `fk_service_weddingservice_idx` (`service_id`),
  CONSTRAINT `fk_service_weddingservice` FOREIGN KEY (`service_id`) REFERENCES `service` (`id`),
  CONSTRAINT `fk_wedding_weddingservice` FOREIGN KEY (`wedding_id`) REFERENCES `wedding` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wedding_service`
--

LOCK TABLES `wedding_service` WRITE;
/*!40000 ALTER TABLE `wedding_service` DISABLE KEYS */;
INSERT INTO `wedding_service` VALUES (3,8,2),(4,8,1),(7,10,1),(8,10,2),(9,11,1),(10,12,1),(11,13,3),(12,13,5),(13,13,1),(14,14,4),(15,14,1),(16,14,5),(17,15,1),(18,15,4),(19,15,2),(20,16,2),(21,16,6),(22,16,5);
/*!40000 ALTER TABLE `wedding_service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `weddinghall`
--

DROP TABLE IF EXISTS `weddinghall`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `weddinghall` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `time_wedding` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `wedding_hall_images` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `location` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  `wedding_hall_price` decimal(10,0) DEFAULT '0',
  `description` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `active` bit(1) DEFAULT b'1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `weddinghall`
--

LOCK TABLES `weddinghall` WRITE;
/*!40000 ALTER TABLE `weddinghall` DISABLE KEYS */;
INSERT INTO `weddinghall` VALUES (4,'Riverside Palace','Sáng','https://res.cloudinary.com/dzi8njrne/image/upload/v1634475638/mo9gpz0lvadzerm6zio3.jpg','362 Nguyen Van Cong, Go Vap, tp.HCM',10000000,'Với diện tích 5.000m2, Riverside Palace mang đến một không gian khoáng đạt nhưng vẫn giữ được nét ấm cúng, thân mật. Sảnh được thiết kế và ngăn nhau bằng kính trong suốt, ánh sáng được bố trí phản chiếu nhẹ nhàng và thanh dịu đã tạo cho nhà hàng tiệc cưới Riverside Palace một hiệu ứng không gian hiện đại, cuốn hút một cách liền mạch với nhau. Đây là sảnh tiệc cưới số 1 ở thành phố Hồ Chí Minh.',NULL),(5,'White Palace','Sáng','https://res.cloudinary.com/dzi8njrne/image/upload/v1634484669/eqjkzxzcjn5hlnzrkuhu.jpg','36 To Huu, q2, tp.HCM',20000000,'White Palace là sảnh cưới sang trọng bậc nhất tại Tp.HCM. Với tổng diện tích sàn 8000 m2. White Palace phủ lên mình lớp áo trắng sang trọng và lịch lãm. Ánh đèn chùm lộng lẫy nguy nga khiến cả tòa nhà về đêm mang một vẻ đẹp huyền ảo.White Palace là nhà hàng tiệc cưới nổi tiếng nhất ở Thành phố Hồ Chí Minh.',NULL),(6,'Diamond Place','Sáng','https://res.cloudinary.com/dzi8njrne/image/upload/v1634554612/o7gjncd2now1gr5gwhhk.jpg','q.Phu Nhuan tp.HCM',25000000,'Diamond Place tọa lạc tại quận Phú Nhuận, mặt tiền rộng và đẹp với diện tích hơn 4.000m2 cùng bãi đậu xe rất rộng. Diamond Place sở hữu những khán phòng sang trọng và thanh nhã. Không chỉ vậy, sảnh tiệc của Diamond Place có thể ngăn ra hoặc kết hợp với nhau thành những khán phòng rộng với tầm nhìn thoáng đãng cho những buổi tiệc cưới hay hội nghị quy mô lớn hơn 1000 khách. Đây chính là nhà hàng tiệc cưới đắt đỏ nhất ở thành phố Hồ Chí Minh.',NULL),(7,'Riverside Palace','Chiều','https://res.cloudinary.com/dzi8njrne/image/upload/v1634554612/o7gjncd2now1gr5gwhhk.jpg','362 Nguyen Van Cong, Go Vap, tp.HCM',20000000,'Với diện tích 5.000m2, Riverside Palace mang đến một không gian khoáng đạt nhưng vẫn giữ được nét ấm cúng, thân mật. Sảnh được thiết kế và ngăn nhau bằng kính trong suốt, ánh sáng được bố trí phản chiếu nhẹ nhàng và thanh dịu đã tạo cho nhà hàng tiệc cưới Riverside Palace một hiệu ứng không gian hiện đại, cuốn hút một cách liền mạch với nhau. Đây là sảnh tiệc cưới số 1 ở thành phố Hồ Chí Minh.',_binary ''),(8,'White Palace','Chiều','https://res.cloudinary.com/dzi8njrne/image/upload/v1634484669/eqjkzxzcjn5hlnzrkuhu.jpg','36 To Huu, q2, tp.HCM',30000000,'White Palace là sảnh cưới sang trọng bậc nhất tại Tp.HCM. Với tổng diện tích sàn 8000 m2. White Palace phủ lên mình lớp áo trắng sang trọng và lịch lãm. Ánh đèn chùm lộng lẫy nguy nga khiến cả tòa nhà về đêm mang một vẻ đẹp huyền ảo.White Palace là nhà hàng tiệc cưới nổi tiếng nhất ở Thành phố Hồ Chí Minh.',_binary ''),(9,'Diamond Place','Chiều','https://res.cloudinary.com/dzi8njrne/image/upload/v1634554612/o7gjncd2now1gr5gwhhk.jpg','q.Phu Nhuan tp.HCM',27000000,'Diamond Place tọa lạc tại quận Phú Nhuận, mặt tiền rộng và đẹp với diện tích hơn 4.000m2 cùng bãi đậu xe rất rộng. Diamond Place sở hữu những khán phòng sang trọng và thanh nhã. Không chỉ vậy, sảnh tiệc của Diamond Place có thể ngăn ra hoặc kết hợp với nhau thành những khán phòng rộng với tầm nhìn thoáng đãng cho những buổi tiệc cưới hay hội nghị quy mô lớn hơn 1000 khách. Đây chính là nhà hàng tiệc cưới đắt đỏ nhất ở thành phố Hồ Chí Minh.',_binary ''),(10,'Riverside Palace','Tối ','https://res.cloudinary.com/dzi8njrne/image/upload/v1634554612/o7gjncd2now1gr5gwhhk.jpg','362 Nguyen Van Cong, Go Vap, tp.HCM',35000000,'Với diện tích 5.000m2, Riverside Palace mang đến một không gian khoáng đạt nhưng vẫn giữ được nét ấm cúng, thân mật. Sảnh được thiết kế và ngăn nhau bằng kính trong suốt, ánh sáng được bố trí phản chiếu nhẹ nhàng và thanh dịu đã tạo cho nhà hàng tiệc cưới Riverside Palace một hiệu ứng không gian hiện đại, cuốn hút một cách liền mạch với nhau. Đây là sảnh tiệc cưới số 1 ở thành phố Hồ Chí Minh.',_binary ''),(11,'White Palace','Tối','https://res.cloudinary.com/dzi8njrne/image/upload/v1634484669/eqjkzxzcjn5hlnzrkuhu.jpg','36 To Huu, q2, tp.HCM',36000000,'White Palace là sảnh cưới sang trọng bậc nhất tại Tp.HCM. Với tổng diện tích sàn 8000 m2. White Palace phủ lên mình lớp áo trắng sang trọng và lịch lãm. Ánh đèn chùm lộng lẫy nguy nga khiến cả tòa nhà về đêm mang một vẻ đẹp huyền ảo.White Palace là nhà hàng tiệc cưới nổi tiếng nhất ở Thành phố Hồ Chí Minh.',_binary ''),(12,'Diamond Place','Tối','https://res.cloudinary.com/dzi8njrne/image/upload/v1634554612/o7gjncd2now1gr5gwhhk.jpg','q.Phu Nhuan tp.HCM',37000000,'Diamond Place tọa lạc tại quận Phú Nhuận, mặt tiền rộng và đẹp với diện tích hơn 4.000m2 cùng bãi đậu xe rất rộng. Diamond Place sở hữu những khán phòng sang trọng và thanh nhã. Không chỉ vậy, sảnh tiệc của Diamond Place có thể ngăn ra hoặc kết hợp với nhau thành những khán phòng rộng với tầm nhìn thoáng đãng cho những buổi tiệc cưới hay hội nghị quy mô lớn hơn 1000 khách. Đây chính là nhà hàng tiệc cưới đắt đỏ nhất ở thành phố Hồ Chí Minh.',_binary '');
/*!40000 ALTER TABLE `weddinghall` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-29 15:42:16
