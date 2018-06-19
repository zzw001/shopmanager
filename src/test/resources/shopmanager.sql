-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 120.79.19.57    Database: shopmanager
-- ------------------------------------------------------
-- Server version	5.7.22

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
-- Table structure for table `catagory`
--

DROP TABLE IF EXISTS `catagory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `catagory` (
  `cata_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '总分类id',
  `cata_name` varchar(15) DEFAULT NULL COMMENT '分类名',
  PRIMARY KEY (`cata_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='总分类';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `manager`
--

DROP TABLE IF EXISTS `manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `manager` (
  `mana_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品管理员id',
  `mana_name` varchar(31) DEFAULT NULL COMMENT '名字',
  `mana_password` varchar(63) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`mana_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `pro_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `pro_name` varchar(63) DEFAULT NULL COMMENT '商品名称',
  `pro_price` int(11) DEFAULT NULL COMMENT '商品价格',
  `pro_stack` int(11) DEFAULT NULL COMMENT '商品库存',
  `pro_size` varchar(31) DEFAULT NULL COMMENT '商品规格',
  `pro_desc` varchar(255) DEFAULT NULL COMMENT '商品描述',
  `pro_image` varchar(63) DEFAULT NULL,
  `sub_id` int(11) DEFAULT NULL COMMENT '子分类id',
  PRIMARY KEY (`pro_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='商品';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `shopcart`
--

DROP TABLE IF EXISTS `shopcart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shopcart` (
  `cart_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '购物车id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `pro_id` int(11) DEFAULT NULL COMMENT '商品id',
  `buy_num` int(11) DEFAULT NULL COMMENT '购买数量',
  `cart_state` int(11) DEFAULT NULL COMMENT '购买状态:0未购买，1购买,2正在配送,3收货',
  PRIMARY KEY (`cart_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='购物车';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `subcata`
--

DROP TABLE IF EXISTS `subcata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subcata` (
  `sub_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '子分类id',
  `sub_name` varchar(15) DEFAULT NULL COMMENT '子分类名',
  `cata_id` int(11) DEFAULT NULL COMMENT '总分类id',
  PRIMARY KEY (`sub_id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COMMENT='子分类';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tran_info`
--

DROP TABLE IF EXISTS `tran_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tran_info` (
  `tran_info_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '快递信息id',
  `tran_id` varchar(63) DEFAULT NULL COMMENT '快递编号',
  `tran_info_context` varchar(255) DEFAULT NULL COMMENT '快递详情',
  PRIMARY KEY (`tran_info_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='快递信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `transportation`
--

DROP TABLE IF EXISTS `transportation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transportation` (
  `tran_id` varchar(63) NOT NULL COMMENT '快递编号',
  `trer_id` int(11) DEFAULT NULL COMMENT '快递员id',
  `cart_id` int(11) DEFAULT NULL COMMENT '购物车id',
  PRIMARY KEY (`tran_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='快递';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `transporter`
--

DROP TABLE IF EXISTS `transporter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transporter` (
  `trer_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '快递员id',
  `trer_name` varchar(31) DEFAULT NULL COMMENT '快递员名称',
  `trer_password` varchar(63) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`trer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(31) DEFAULT NULL COMMENT '用户名',
  `user_password` varchar(63) DEFAULT NULL COMMENT '密码',
  `phone` varchar(15) DEFAULT NULL COMMENT '手机号',
  `address` varchar(127) DEFAULT NULL COMMENT '地址',
  `code` varchar(15) DEFAULT NULL COMMENT '邮编',
  `money` int(11) DEFAULT NULL COMMENT '余额',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-19 22:10:40
