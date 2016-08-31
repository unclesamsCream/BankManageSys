/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : bank

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2016-08-31 23:11:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `account_number` varchar(20) NOT NULL,
  `password` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for operation
-- ----------------------------
DROP TABLE IF EXISTS `operation`;
CREATE TABLE `operation` (
  `card_number` varchar(20) NOT NULL,
  `type` bigint(255) NOT NULL,
  `residual` bigint(255) NOT NULL,
  `transaction_to` varchar(20) NOT NULL,
  `transaction_from` varchar(20) NOT NULL,
  `transaction_amount` bigint(255) NOT NULL,
  `deal_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for stuff
-- ----------------------------
DROP TABLE IF EXISTS `stuff`;
CREATE TABLE `stuff` (
  `account` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `openable` tinyint(10) NOT NULL,
  `closeable` tinyint(10) NOT NULL,
  `modifiable` tinyint(10) NOT NULL,
  `viewable` tinyint(10) NOT NULL,
  `quaryable` tinyint(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `account` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `id` varchar(20) DEFAULT NULL,
  `type` tinyint(10) DEFAULT NULL,
  `residual` bigint(255) DEFAULT NULL,
  `rate` tinyint(10) DEFAULT NULL,
  `password` varchar(6) DEFAULT NULL,
  `address` varchar(140) DEFAULT NULL,
  `telphone` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
