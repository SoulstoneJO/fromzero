# ************************************************************
# Sequel Ace SQL dump
# Version 20033
#
# https://sequel-ace.com/
# https://github.com/Sequel-Ace/Sequel-Ace
#
# Host: localhost (MySQL 8.0.30)
# Database: from_zero_content
# Generation Time: 2022-08-05 03:37:26 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
SET NAMES utf8mb4;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE='NO_AUTO_VALUE_ON_ZERO', SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table customer_info
# ------------------------------------------------------------

create Database from_zero_content;
use from_zero_content;

DROP TABLE IF EXISTS `customer_info`;

CREATE TABLE `customer_info` (
  `customer_info_id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `customer_id` int unsigned NOT NULL COMMENT 'customer_login表的自增ID',
  `customer_name` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户真实姓名',
  `mobile_phone` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号',
  `customer_email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '邮箱',
  `gender` tinyint(1) NOT NULL DEFAULT '0' COMMENT '性别: 1 男 2 女',
  `birthday` datetime DEFAULT NULL COMMENT '会员生日',
  `customer_level` tinyint NOT NULL DEFAULT '1' COMMENT '会员级别：1 普通会员，2 青铜，3白银，4黄金，5钻石',
  PRIMARY KEY (`customer_info_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户信息表';

LOCK TABLES `customer_info` WRITE;
/*!40000 ALTER TABLE `customer_info` DISABLE KEYS */;

INSERT INTO `customer_info` (`customer_info_id`, `customer_id`, `customer_name`, `mobile_phone`, `customer_email`, `gender`, `birthday`, `customer_level`)
VALUES
	(1,1,'tony','08019951995','tony@mail.com',0,'1995-09-15 00:00:00',1);

/*!40000 ALTER TABLE `customer_info` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
