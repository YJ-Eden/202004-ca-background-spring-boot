-- MySQL dump 10.13  Distrib 5.6.10, for Win64 (x86_64)
--
-- Host: localhost    Database: user
-- ------------------------------------------------------
-- Server version	5.6.10

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
-- Table structure for table `basic_data`
--

DROP TABLE IF EXISTS `basic_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `basic_data` (
  `type` smallint(10) NOT NULL COMMENT '基础数据类型',
  `name` varchar(50) DEFAULT NULL COMMENT '基础类型名称',
  `basic_code` varchar(50) NOT NULL COMMENT '基础数据编号',
  `basic_name` varchar(50) DEFAULT NULL COMMENT '基础编号名称',
  PRIMARY KEY (`type`,`basic_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `basic_data`
--

LOCK TABLES `basic_data` WRITE;
/*!40000 ALTER TABLE `basic_data` DISABLE KEYS */;
INSERT INTO `basic_data` VALUES (1,'教学科目','1','语文'),(1,'教学科目','10','音乐'),(1,'教学科目','11','美术'),(1,'教学科目','12','体育'),(1,'教学科目','13','社科'),(1,'教学科目','14','伦理'),(1,'教学科目','15','生理'),(1,'教学科目','2','数学'),(1,'教学科目','3','英语'),(1,'教学科目','4','物理'),(1,'教学科目','5','化学'),(1,'教学科目','6','生物'),(1,'教学科目','7','政治'),(1,'教学科目','8','历史'),(1,'教学科目','9','地理'),(2,'学生类型','1','专科'),(2,'学生类型','2','本科'),(2,'学生类型','3','研究生'),(2,'学生类型','4','留学生'),(2,'学生类型','5','交换生'),(2,'学生类型','6','国防生'),(3,'学生状态','1','待审批'),(3,'学生状态','2','已注册'),(3,'学生状态','3','已锁定'),(4,'日志类型','1','学生'),(4,'日志类型','2','教师'),(4,'日志类型','3','超级管理员');
/*!40000 ALTER TABLE `basic_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log`
--

DROP TABLE IF EXISTS `log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `log` (
  `id` bigint(40) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `content` varchar(40) DEFAULT NULL COMMENT '日志内容',
  `type` tinyint(2) DEFAULT NULL COMMENT '日志类型（1：学生；2：教师；3：超级管理员）',
  `person_id` bigint(40) DEFAULT NULL COMMENT '对应的人员ID',
  `person_name` varchar(40) DEFAULT NULL COMMENT '对应的人员姓名',
  `log_time` datetime DEFAULT NULL COMMENT '日志时间',
  `remark` varchar(40) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log`
--

LOCK TABLES `log` WRITE;
/*!40000 ALTER TABLE `log` DISABLE KEYS */;
INSERT INTO `log` VALUES (1,'系统登录',3,1,'admin','2019-09-18 15:52:03',NULL),(2,'系统登录',3,1,'admin','2019-09-18 15:54:23',NULL),(3,'审核学生注册通过',3,1,'admin','2019-09-18 16:05:44',NULL),(4,'系统登录',1,2,'wangpan','2019-09-18 16:10:29',NULL),(5,'系统登录',1,2,'wangpan','2019-09-18 16:12:50',NULL),(6,'系统登录',1,2,'wangpan','2019-09-18 16:16:51',NULL),(7,'系统退出',1,2,'wangpan','2019-09-18 16:16:57',NULL),(8,'系统登录',1,2,'wangpan','2019-09-18 16:22:07',NULL),(9,'系统退出',1,2,'wangpan','2019-09-18 16:25:41',NULL),(10,'系统登录',1,2,'wangpan','2019-09-18 16:25:43',NULL),(11,'系统退出',1,2,'wangpan','2019-09-18 16:29:37',NULL),(12,'系统登录',1,2,'wangpan','2019-09-18 16:29:40',NULL),(13,'系统退出',1,2,'wangpan','2019-09-18 16:35:34',NULL),(14,'系统登录',3,1,'admin','2019-09-18 16:35:39',NULL),(15,'系统退出',3,1,'admin','2019-09-18 16:36:27',NULL),(16,'系统登录',2,2,'teacher','2019-09-18 16:36:30',NULL),(17,'系统登录',3,1,'admin','2019-09-18 16:37:49',NULL),(18,'系统登录',3,1,'admin','2019-09-18 16:43:32',NULL),(19,'系统退出',3,1,'admin','2019-09-18 16:44:42',NULL),(20,'系统登录',1,2,'wangpan','2019-09-18 16:44:47',NULL),(21,'系统退出',1,2,'wangpan','2019-09-18 16:45:10',NULL),(22,'系统登录',3,1,'admin','2019-09-18 16:45:12',NULL),(23,'系统退出',3,1,'admin','2019-09-18 16:46:03',NULL),(24,'系统登录',3,1,'admin','2019-09-18 16:46:05',NULL),(25,'系统退出',3,1,'admin','2019-09-18 16:46:11',NULL),(26,'系统登录',1,2,'wangpan','2019-09-18 16:46:19',NULL),(27,'系统退出',1,2,'wangpan','2019-09-18 16:46:23',NULL),(28,'系统登录',3,1,'admin','2019-09-18 16:46:26',NULL),(29,'系统退出',3,1,'admin','2019-09-18 17:02:31',NULL),(30,'系统登录',1,2,'wangpan','2019-09-18 17:02:32',NULL),(31,'系统退出',1,2,'wangpan','2019-09-18 17:07:22',NULL),(32,'系统登录',3,1,'admin','2019-09-18 17:07:25',NULL),(33,'系统退出',3,1,'admin','2019-09-18 17:17:37',NULL),(34,'系统登录',1,2,'wangpan','2019-09-18 17:17:39',NULL),(35,'系统退出',1,2,'wangpan','2019-09-18 17:20:11',NULL),(36,'系统登录',3,1,'admin','2019-09-18 17:20:13',NULL),(37,'系统退出',3,1,'admin','2019-09-18 17:20:54',NULL),(38,'系统登录',1,2,'wangpan','2019-09-18 17:20:56',NULL),(39,'系统退出',1,2,'wangpan','2019-09-18 17:20:59',NULL),(40,'系统登录',2,2,'teacher','2019-09-18 17:21:07',NULL),(41,'系统退出',2,2,'teacher','2019-09-18 17:22:16',NULL),(42,'系统登录',1,2,'wangpan','2019-09-18 17:22:18',NULL),(43,'系统退出',1,2,'wangpan','2019-09-18 17:22:22',NULL),(44,'系统登录',2,2,'teacher','2019-09-18 17:22:29',NULL),(45,'系统退出',2,2,'teacher','2019-09-18 17:22:33',NULL),(46,'系统登录',3,1,'admin','2019-09-18 17:22:36',NULL),(47,'系统退出',3,1,'admin','2019-09-18 17:30:44',NULL),(48,'系统登录',2,2,'teacher','2019-09-18 17:30:52',NULL),(49,'系统登录',2,2,'teacher','2019-09-19 11:15:22',NULL),(50,'系统登录',2,2,'teacher','2019-09-20 11:24:09',NULL),(51,'系统退出',2,2,'teacher','2019-09-20 16:19:07',NULL),(52,'系统登录',2,2,'teacher','2019-09-20 16:23:46',NULL),(53,'系统登录',3,1,'admin','2019-11-12 23:37:57',NULL),(54,'系统登录',3,1,'admin','2019-11-13 00:05:14',NULL),(55,'修改学生xiaowangxi的信息',3,1,'admin','2019-11-13 00:06:31',NULL),(56,'添加学生lby的信息',3,1,'admin','2019-11-13 00:08:39',NULL),(57,'审核学生注册通过',3,1,'admin','2019-11-13 00:09:41',NULL),(58,'系统退出',3,1,'admin','2019-11-13 00:10:27',NULL),(59,'系统登录',3,1,'admin','2019-11-13 21:41:58',NULL),(60,'添加教师james的信息',3,1,'admin','2019-11-13 22:55:36',NULL),(61,'添加学生成绩',3,1,'admin','2019-11-13 22:56:11',NULL),(62,'删除学生lby的成绩',3,1,'admin','2019-11-13 23:02:48',NULL),(63,'添加学生成绩',3,1,'admin','2019-11-13 23:04:53',NULL),(64,'修改学生成绩',3,1,'admin','2019-11-13 23:05:23',NULL),(65,'修改学生成绩',3,1,'admin','2019-11-13 23:21:05',NULL),(66,'系统登录',1,15,'lby','2019-11-14 16:38:39',NULL),(67,'系统退出',1,15,'lby','2019-11-14 16:39:23',NULL),(68,'系统登录',2,3,'james','2019-11-14 16:39:36',NULL),(69,'添加学生成绩',2,3,'james','2019-11-14 16:40:04',NULL),(70,'系统退出',2,3,'james','2019-11-14 16:40:33',NULL),(71,'系统登录',3,1,'admin','2019-11-14 16:40:42',NULL),(72,'系统退出',3,1,'admin','2019-11-14 16:50:54',NULL),(73,'系统登录',3,1,'admin','2019-11-14 18:15:18',NULL);
/*!40000 ALTER TABLE `log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `score`
--

DROP TABLE IF EXISTS `score`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `score` (
  `id` bigint(40) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `student_id` bigint(40) NOT NULL COMMENT '学生id',
  `project` tinyint(4) DEFAULT NULL COMMENT '教学科目（对应基础数据表type=1）',
  `score` decimal(5,0) DEFAULT NULL COMMENT '分数',
  `ranking` smallint(5) DEFAULT NULL COMMENT '排名',
  `unit` varchar(40) DEFAULT NULL COMMENT '单位',
  `teacher_id` bigint(40) NOT NULL COMMENT '教师id',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(40) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `score`
--

LOCK TABLES `score` WRITE;
/*!40000 ALTER TABLE `score` DISABLE KEYS */;
INSERT INTO `score` VALUES (1,7,3,90,111,'分',1,'2019-09-18 11:24:14','111'),(3,14,1,97,1,'分',1,'2019-11-13 23:21:05','undefined'),(4,2,10,100,1,'分',3,'2019-11-14 16:40:04','测试');
/*!40000 ALTER TABLE `score` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `id` bigint(40) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(40) DEFAULT NULL COMMENT '姓名',
  `password` varchar(40) DEFAULT NULL COMMENT '密码md5加密',
  `code` varchar(40) DEFAULT NULL COMMENT '学号',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `sex` tinyint(2) DEFAULT '1' COMMENT '性别（1：男；2：女）',
  `nation` varchar(40) DEFAULT NULL COMMENT '民族',
  `college` varchar(40) DEFAULT NULL COMMENT '学院',
  `major` varchar(40) DEFAULT NULL COMMENT '专业',
  `nationality` varchar(40) DEFAULT NULL COMMENT '国籍',
  `entrance_date` date DEFAULT NULL COMMENT '入学日期',
  `student_type` tinyint(2) DEFAULT '2' COMMENT '学生类型（1：专科；2：本科；3：研究生；4：留学生；5：交换生；6：国防生）',
  `identity` varchar(18) DEFAULT NULL COMMENT '身份证',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话',
  `native_place` varchar(40) DEFAULT NULL COMMENT '籍贯',
  `status` tinyint(2) DEFAULT '1' COMMENT '状态（1:待审批；2：已注册；3：已锁定）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (2,'xiaomidou','14e1b600b1fd579f47433b88e8d85291','DB1001','1987-09-11',1,'汉族','信息技术学院','计算机与技术','中国','2018-09-11',2,'462198188511170011','18598764556','北京市海淀区',2),(7,'xiaoabu','14e1b600b1fd579f47433b88e8d85291','DB1002','1990-11-13',2,'汉族','信息管理学院','计算机应用科学','中国','2018-09-20',2,'110786199011130012','18609876882','黑龙江省哈尔滨市',2),(14,'xiaowangxi','14e1b600b1fd579f47433b88e8d85291','DB1003','2003-05-02',1,'汉族','信息管理学院','计算机应用科学','中国','2019-09-09',2,'110786199011130012','18744523665','湖北省武汉市',1),(15,'lby','14e1b600b1fd579f47433b88e8d85291','3220190963','1995-11-12',1,'汉','计算机学院','软件工程','中国','2019-09-01',3,'150430199511120754','18210080586','内蒙古',2);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher` (
  `id` bigint(40) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(40) DEFAULT NULL COMMENT '姓名',
  `password` varchar(40) DEFAULT NULL COMMENT '密码md5加密',
  `code` varchar(40) DEFAULT NULL COMMENT '教师编号',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `sex` tinyint(4) DEFAULT '1' COMMENT '性别（1：男；2：女）',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话',
  `identity` varchar(18) DEFAULT NULL COMMENT '身份证',
  `nation` varchar(40) DEFAULT NULL COMMENT '民族',
  `nationality` varchar(40) DEFAULT NULL COMMENT '国籍',
  `native_place` varchar(40) DEFAULT NULL COMMENT '籍贯',
  `major` varchar(40) DEFAULT NULL COMMENT '教师科目',
  `entrance_date` date DEFAULT NULL COMMENT '来校时间',
  `remark` varchar(40) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (1,'admin','14e1b600b1fd579f47433b88e8d85291',NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,'teacher','14e1b600b1fd579f47433b88e8d85291','DBT001','1982-09-21',1,'18500698774','420111177712140456','汉族','中国','湖北省安陆市','计算机应用','2015-06-09',NULL),(3,'james','14e1b600b1fd579f47433b88e8d85291','002','1990-11-01',1,'18210080586','123456789011250000','美国','美国','美国加州','英语','2015-11-01',NULL);
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-14 18:37:55
