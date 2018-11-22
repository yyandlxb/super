/*
SQLyog Ultimate v8.32 
MySQL - 8.0.12 : Database - super
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`super` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `super`;

/*Table structure for table `brand` */

DROP TABLE IF EXISTS `brand`;

CREATE TABLE `brand` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '品牌id',
  `name` varchar(50) NOT NULL COMMENT '品牌名称',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `enabled` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

/*Data for the table `brand` */

insert  into `brand`(`id`,`name`,`created_at`,`updated_at`,`enabled`) values (2,'双汇77','2018-10-24 14:43:32','2018-11-07 10:51:06',''),(9,'4455','2018-10-24 18:53:59','2018-10-24 18:53:59',''),(10,'6543','2018-10-24 18:54:02','2018-11-07 11:36:31',''),(11,'我去','2018-10-24 18:54:08','2018-11-07 11:36:31',''),(14,'333','2018-11-07 10:57:56','2018-11-07 11:36:31',''),(16,'双汇234','2018-11-07 10:58:06','2018-11-07 11:02:24','\0'),(17,'双汇23','2018-11-07 18:25:39','2018-11-07 18:25:39','');

/*Table structure for table `brand_classify` */

DROP TABLE IF EXISTS `brand_classify`;

CREATE TABLE `brand_classify` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商标与类别',
  `brand_id` int(11) NOT NULL COMMENT '品牌id',
  `classify` int(11) NOT NULL COMMENT '类别id',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `brand_classify` */

/*Table structure for table `goods` */

DROP TABLE IF EXISTS `goods`;

CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `name` varchar(50) NOT NULL COMMENT '商品名称',
  `classify_id` int(11) NOT NULL COMMENT '分类id',
  `describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品简介',
  `enabled` bit(1) NOT NULL DEFAULT b'1' COMMENT '0-上架，1-下架',
  `picture` varchar(255) DEFAULT NULL COMMENT '商品图片',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `merchant_id` int(11) DEFAULT NULL COMMENT '供应商id',
  `sale_total` int(9) DEFAULT NULL COMMENT '销售量',
  `details` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '审核结果',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0-待审核，1-审核成功，2-审核失败',
  `price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '商品价格',
  `producer` varchar(100) NOT NULL COMMENT '生产厂商',
  `weight` double NOT NULL COMMENT '重量',
  `cost_price` decimal(10,0) NOT NULL DEFAULT '10' COMMENT '进货价',
  `brand_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `goods` */

insert  into `goods`(`id`,`name`,`classify_id`,`describe`,`enabled`,`picture`,`created_at`,`updated_at`,`merchant_id`,`sale_total`,`details`,`status`,`price`,`producer`,`weight`,`cost_price`,`brand_id`) values (2,'aYao',555,'555','','15427068600302345_image_file_copy_32.jpg','2018-11-20 17:41:07','2018-11-21 15:26:27',NULL,NULL,NULL,0,'12.00','555',5,'55',2),(3,'aYao',17,'3','','15427085252062345_image_file_copy_32.jpg','2018-11-20 18:08:59','2018-11-21 15:26:33',NULL,NULL,NULL,0,'12.00','3333',4,'4',9),(4,'aYao',21,'4','','15427087399952345_image_file_copy_31.jpg','2018-11-20 18:12:28','2018-11-21 15:26:38',NULL,NULL,NULL,0,'12.00','3333',4,'4',2);

/*Table structure for table `goods_classify` */

DROP TABLE IF EXISTS `goods_classify`;

CREATE TABLE `goods_classify` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品分类',
  `name` varchar(50) NOT NULL COMMENT '分类名称',
  `p_id` int(11) NOT NULL COMMENT '父分类id',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `enabled` bit(1) NOT NULL DEFAULT b'1' COMMENT '是否可用',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

/*Data for the table `goods_classify` */

insert  into `goods_classify`(`id`,`name`,`p_id`,`created_at`,`updated_at`,`enabled`) values (2,'hl',0,'2018-11-07 19:08:47','2018-11-08 19:04:42','\0'),(3,'ggg',2,'2018-11-08 18:13:59','2018-11-08 19:04:42','\0'),(4,'hh',0,'2018-11-08 18:14:07','2018-11-08 19:04:29',''),(7,'aYao',0,'2018-11-08 18:26:07','2018-11-08 18:26:07',''),(10,'双汇77',0,'2018-11-08 18:37:13','2018-11-08 19:04:29',''),(11,'goku2017',0,'2018-11-08 19:04:50','2018-11-15 18:29:59','\0'),(13,'ddd',11,'2018-11-09 15:14:23','2018-11-09 15:18:31','\0'),(14,'ffff',13,'2018-11-09 15:14:48','2018-11-09 15:18:25','\0'),(15,'fffddd',11,'2018-11-09 15:15:02','2018-11-09 15:23:08','\0'),(17,'555',7,'2018-11-09 15:31:11','2018-11-15 18:30:52',''),(18,'双汇234',0,'2018-11-15 18:31:09','2018-11-15 18:31:09',''),(20,'vvvvlll',7,'2018-11-15 18:31:35','2018-11-15 18:35:40',''),(21,'lkfldklfk',20,'2018-11-15 18:52:36','2018-11-15 18:52:36','');

/*Table structure for table `permission` */

DROP TABLE IF EXISTS `permission`;

CREATE TABLE `permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `code` varchar(50) NOT NULL COMMENT '权限码',
  `name` varchar(50) DEFAULT NULL COMMENT '权限名',
  `description` varchar(100) DEFAULT NULL COMMENT '权限描述',
  `system_id` int(11) NOT NULL COMMENT '系统id',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_code_system` (`code`,`system_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `permission` */

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品库存',
  `product_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '产品id',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `pass_time` timestamp NULL DEFAULT NULL COMMENT '过期时间',
  `commodity_id` int(11) NOT NULL COMMENT '商品id',
  `product_date` timestamp NULL DEFAULT NULL COMMENT '生产日期',
  `status` tinyint(1) DEFAULT NULL COMMENT '0-待出售，1-已售出，2-已过期',
  `batch_code` varchar(50) DEFAULT NULL COMMENT '批次号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `product` */

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `name` varchar(50) NOT NULL COMMENT '角色名称',
  `department_id` int(11) NOT NULL COMMENT '部门id',
  `enabled` bit(1) NOT NULL DEFAULT b'1',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `role` */

/*Table structure for table `role_permission` */

DROP TABLE IF EXISTS `role_permission`;

CREATE TABLE `role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色权限id',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `permission_id` int(11) NOT NULL COMMENT '权限id',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `role_permission` */

/*Table structure for table `system` */

DROP TABLE IF EXISTS `system`;

CREATE TABLE `system` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '系统id',
  `code` varchar(50) NOT NULL COMMENT '系统码',
  `name` varchar(50) NOT NULL COMMENT '系统名称',
  `enabled` bit(1) NOT NULL DEFAULT b'1',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_system_code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `system` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `account` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL COMMENT '用户名称',
  `password` varchar(50) NOT NULL COMMENT '用户密码',
  `address` varchar(255) DEFAULT NULL COMMENT '用户地址',
  `enabled` bit(1) NOT NULL DEFAULT b'1',
  `type` tinyint(4) NOT NULL COMMENT '用户身份(1-超级管理员，2-部门管理员，3-普通用户)',
  `picture` varchar(100) DEFAULT NULL COMMENT '用户头像',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `business_license` varchar(100) NOT NULL COMMENT '营业执照',
  `id_card_photo` varchar(100) NOT NULL COMMENT '身份证照片',
  `store_picture` varchar(100) DEFAULT NULL COMMENT '门店图片',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_account` (`account`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`account`,`name`,`password`,`address`,`enabled`,`type`,`picture`,`created_at`,`updated_at`,`business_license`,`id_card_photo`,`store_picture`) values (2,'admin','ayao','e10adc3949ba59abbe56e057f20f883e',NULL,'',1,NULL,'2018-10-15 16:00:18','2018-10-15 16:00:30','1234','543',NULL);

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户角色id',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `create_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_role` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
