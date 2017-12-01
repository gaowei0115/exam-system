/*
Navicat MySQL Data Transfer

Source Server         : exam
Source Server Version : 50625
Source Host           : localhost:3306
Source Database       : shiro_db

Target Server Type    : MYSQL
Target Server Version : 50625
File Encoding         : 65001

Date: 2017-12-01 17:05:34
*/

DROP database IF EXISTS `shiro_db`;
create database shiro_db;
use shiro_db;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_privilege`
-- ----------------------------
DROP TABLE IF EXISTS `t_privilege`;
CREATE TABLE `t_privilege` (
  `privilege_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '权限编号',
  `privilege_name` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '权限文字名称',
  `privilege_flag` varchar(32) CHARACTER SET utf8 NOT NULL COMMENT '权限标识（权限英文简称）',
  `is_available` char(2) CHARACTER SET utf8 NOT NULL COMMENT '权限是否可用标识（0：可用、1：不可用）',
  `description` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `creator` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `modifior` bigint(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`privilege_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='用户权限表';

-- ----------------------------
-- Records of t_privilege
-- ----------------------------

-- ----------------------------
-- Table structure for `t_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色编号',
  `role_name` varchar(32) CHARACTER SET utf8 NOT NULL COMMENT '角色名称（全称，文字描述）',
  `role_flag` varchar(32) CHARACTER SET utf8 NOT NULL COMMENT '角色标识（英文标识，唯一）',
  `description` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '描述',
  `is_available` char(2) CHARACTER SET utf8 NOT NULL COMMENT '是否可用（0：可用、1：不可用）',
  `creator` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间(yyyy-MM-dd HH:mi:ss)',
  `modifior` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间(yyyy-MM-dd HH:mi:ss)',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='用户角色信息表';

-- ----------------------------
-- Records of t_role
-- ----------------------------

-- ----------------------------
-- Table structure for `t_role_privilege`
-- ----------------------------
DROP TABLE IF EXISTS `t_role_privilege`;
CREATE TABLE `t_role_privilege` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增序列',
  `role_id` bigint(20) NOT NULL COMMENT '角色编号',
  `privilege_id` bigint(20) NOT NULL COMMENT '权限编号',
  `operator` bigint(20) DEFAULT NULL COMMENT '操作员',
  `effect_time` datetime DEFAULT NULL COMMENT '生效时间（yyyy-MM-dd HH:mm:ss）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='用户角色拥有权限信息表';

-- ----------------------------
-- Records of t_role_privilege
-- ----------------------------

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `real_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户真实姓名',
  `login_name` varchar(64) CHARACTER SET utf8 NOT NULL COMMENT '登录用户名(唯一性)',
  `nick_name` varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '用户昵称',
  `user_psw` varchar(100) CHARACTER SET utf8 NOT NULL COMMENT '用户登录密码（加密存储）',
  `cell_phone` varchar(11) CHARACTER SET utf8 DEFAULT NULL COMMENT '用户联系方式（手机号）',
  `is_lock` char(2) CHARACTER SET utf8 NOT NULL COMMENT '是否锁定（0：未锁定、1：锁定）',
  `salt` varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '用户密码加密使用盐值（salt）',
  `creator` bigint(20) DEFAULT NULL,
  `creat_time` datetime DEFAULT NULL,
  `modifior` bigint(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `login_name_unique` (`login_name`) USING HASH,
  UNIQUE KEY `login_id_unique` (`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='用户信息表';

-- ----------------------------
-- Records of t_user
-- ----------------------------

-- ----------------------------
-- Table structure for `t_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `role_id` bigint(20) NOT NULL COMMENT '角色编号',
  `operator` bigint(20) DEFAULT NULL COMMENT '操作员',
  `effect_time` datetime DEFAULT NULL COMMENT '生效时间（yyyy-MM-dd HH:mm:ss）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='用户拥有的角色信息表';

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
