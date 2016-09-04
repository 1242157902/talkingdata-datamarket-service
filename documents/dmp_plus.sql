/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50022
Source Host           : localhost:3306
Source Database       : dmp_plus

Target Server Type    : MYSQL
Target Server Version : 50099
File Encoding         : 65001

Date: 2016-08-30 15:11:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `app_access_info`
-- ----------------------------
DROP TABLE IF EXISTS `app_access_info`;
CREATE TABLE `app_access_info` (
`app_id`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`auth_type`  tinyint(1) NOT NULL DEFAULT 1 COMMENT '连接第三方系统认证方式 1-无认证' ,
`redirect_url`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
PRIMARY KEY (`app_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Table structure for `app_bussiness_mapping`
-- ----------------------------
DROP TABLE IF EXISTS `app_bussiness_mapping`;
CREATE TABLE `app_bussiness_mapping` (
`app_id`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`business_id`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
PRIMARY KEY (`app_id`, `business_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Table structure for `app_info`
-- ----------------------------
DROP TABLE IF EXISTS `app_info`;
CREATE TABLE `app_info` (
`id`  int(32) NOT NULL AUTO_INCREMENT COMMENT '主键，自增' ,
`name`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '应用名' ,
`name_en`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '应用名 英文 ' ,
`version`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '版本号' ,
`rating`  int(1) NULL DEFAULT NULL COMMENT '评级1------5 ' ,
`supplier`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '供应商' ,
`icon_url`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '背景图片地址' ,
`logo_url`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公司Logo地址' ,
`description`  text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '简介' ,
`tag`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '应用分类：新品new，推荐recommend' ,
`pricing`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '计费方式' ,
`trial`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '可否试用' ,
`access_date`  date NULL DEFAULT NULL COMMENT '接入时间' ,
`deploy`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部署方式' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
/*!50003 AUTO_INCREMENT=16 */

;

-- ----------------------------
-- Table structure for `app_introduction`
-- ----------------------------
DROP TABLE IF EXISTS `app_introduction`;
CREATE TABLE `app_introduction` (
`id`  int(64) NOT NULL AUTO_INCREMENT COMMENT '主键，自增' ,
`app_id`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '应用ID ' ,
`title`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '产品介绍标题' ,
`context`  text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '产品介绍标题正文 ' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
/*!50003 AUTO_INCREMENT=47 */

;

-- ----------------------------
-- Table structure for `app_media_info`
-- ----------------------------
DROP TABLE IF EXISTS `app_media_info`;
CREATE TABLE `app_media_info` (
`id`  int(64) NOT NULL AUTO_INCREMENT COMMENT '主键，自增' ,
`app_id`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '应用ID' ,
`media_url`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '视频/图片地址 ' ,
`media_type`  tinyint(1) NULL DEFAULT NULL COMMENT '视频/图片/主要客户 标记 0/1/2' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
/*!50003 AUTO_INCREMENT=135 */

;

-- ----------------------------
-- Table structure for `business_info`
-- ----------------------------
DROP TABLE IF EXISTS `business_info`;
CREATE TABLE `business_info` (
`id`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`name`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Table structure for `user_app_mapping`
-- ----------------------------
DROP TABLE IF EXISTS `user_app_mapping`;
CREATE TABLE `user_app_mapping` (
`id`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键，自增 ' ,
`user_id`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户ID' ,
`app_id`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '应用ID ' ,
`purchase_date`  date NULL DEFAULT NULL COMMENT '购买时间 ' ,
`expire_date`  date NULL DEFAULT NULL COMMENT '过期时间' ,
`status`  tinyint(1) NOT NULL DEFAULT 1 COMMENT '状态 1：有效，0：失效' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
`id`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`account`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`password`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`status`  tinyint(1) NOT NULL ,
`register_time`  datetime NOT NULL ,
`login_time`  datetime NULL DEFAULT NULL ,
`picture_url`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`company`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`name`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`phone`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`qq`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`access_token`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Auto increment value for `app_info`
-- ----------------------------
ALTER TABLE `app_info` AUTO_INCREMENT=16;

-- ----------------------------
-- Auto increment value for `app_introduction`
-- ----------------------------
ALTER TABLE `app_introduction` AUTO_INCREMENT=47;

-- ----------------------------
-- Auto increment value for `app_media_info`
-- ----------------------------
ALTER TABLE `app_media_info` AUTO_INCREMENT=135;
