/*
Navicat MySQL Data Transfer

Source Server         : exam
Source Server Version : 50625
Source Host           : localhost:3306
Source Database       : exam_db

Target Server Type    : MYSQL
Target Server Version : 50625
File Encoding         : 65001

Date: 2017-11-14 10:10:02
*/
DROP DATABASE IF EXISTS `exam_db`;
CREATE DATABASE `exam_db` CHARACTER SET utf8 COLLATE utf8_general_ci;

USE exam_db;
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_collect_record`
-- ----------------------------
DROP TABLE IF EXISTS `t_collect_record`;
CREATE TABLE `t_collect_record` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增序列ID',
  `library_id` bigint(20) NOT NULL COMMENT '题库编号',
  `user_id` varchar(32) COLLATE utf8_general_ci NOT NULL COMMENT '用户编号',
  `creat_time` date DEFAULT NULL COMMENT '创建时间（yyyy-MM-dd HH:mm:ss）',
  `creator` varchar(32) COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `update_time` date DEFAULT NULL COMMENT '更新时间（yyyy-MM-dd HH:mm:ss）',
  `modifier` varchar(32) COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改人',
  `Column_1` char(10) COLLATE utf8_general_ci DEFAULT NULL,
  `Column_2` char(10) COLLATE utf8_general_ci DEFAULT NULL,
  `Column_3` char(10) COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='用户收藏记录表';

-- ----------------------------
-- Records of t_collect_record
-- ----------------------------

-- ----------------------------
-- Table structure for `t_course_ques_type`
-- ----------------------------
DROP TABLE IF EXISTS `t_course_ques_type`;
CREATE TABLE `t_course_ques_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增序列',
  `ques_type` bigint(20) DEFAULT NULL COMMENT '题库类型编号',
  `ques_sp` double DEFAULT NULL COMMENT '科目考试题库类型所占比重',
  `ques_state` varchar(2) COLLATE utf8_general_ci DEFAULT NULL COMMENT '科目考试题目类型状态（0：生效、1：失效）',
  `course_id` bigint(20) DEFAULT NULL COMMENT '科目编号',
  `creat_time` date DEFAULT NULL COMMENT '创建时间（yyyy-MM-dd HH:mm:ss）',
  `creator` varchar(32) COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `update_time` date DEFAULT NULL COMMENT '修改时间（yyyy-MM-dd HH:mm:ss）',
  `modifier` varchar(32) COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改人',
  `Column_11` char(10) COLLATE utf8_general_ci DEFAULT NULL,
  `Column_12` char(10) COLLATE utf8_general_ci DEFAULT NULL,
  `Column_13` char(10) COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='科目与题库类型关联表';

-- ----------------------------
-- Records of t_course_ques_type
-- ----------------------------

-- ----------------------------
-- Table structure for `t_exam_course`
-- ----------------------------
DROP TABLE IF EXISTS `t_exam_course`;
CREATE TABLE `t_exam_course` (
  `course_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '科目编号',
  `course_name` varchar(32) COLLATE utf8_general_ci NOT NULL COMMENT '科目名称',
  `state` varchar(2) COLLATE utf8_general_ci NOT NULL COMMENT '科目状态（0：生效、1：失效）',
  `course_type` varchar(2) COLLATE utf8_general_ci NOT NULL COMMENT '科目类别（0：公开课、1：专业课）',
  `course_pic` varchar(100) COLLATE utf8_general_ci DEFAULT NULL COMMENT '科目封面图片地址（uri）',
  `course_location` varchar(100) COLLATE utf8_general_ci DEFAULT NULL COMMENT '科目教材地址（uri）',
  `exam_time` date DEFAULT NULL COMMENT '科目考试时间（yyyy-MM-dd HH:mm:ss）',
  `course_version` varchar(100) COLLATE utf8_general_ci DEFAULT NULL COMMENT '科目教材版本信息',
  `course_desc` varchar(100) COLLATE utf8_general_ci DEFAULT NULL COMMENT '科目描述',
  `creat_time` date DEFAULT NULL COMMENT '创建时间（yyyy-MM-dd HH:mm:ss）',
  `creator` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_time` date DEFAULT NULL COMMENT '修改时间（yyyy-MM-dd HH:mm:ss）',
  `modifier` bigint(20) DEFAULT NULL COMMENT '修改人',
  `Column_1` char(10) COLLATE utf8_general_ci DEFAULT NULL,
  `Column_2` char(10) COLLATE utf8_general_ci DEFAULT NULL,
  `Column_3` char(10) COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`course_id`),
  UNIQUE KEY `exam_course_index` (`course_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='考试科目信息表--描述考试科目信息';

-- ----------------------------
-- Records of t_exam_course
-- ----------------------------

-- ----------------------------
-- Table structure for `t_exam_course_chapter`
-- ----------------------------
DROP TABLE IF EXISTS `t_exam_course_chapter`;
CREATE TABLE `t_exam_course_chapter` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增序列',
  `chapter_code` bigint(20) NOT NULL COMMENT '章节编号',
  `chapter_name` varchar(32) COLLATE utf8_general_ci NOT NULL COMMENT '章节名称',
  `chapter_desc` varchar(100) COLLATE utf8_general_ci DEFAULT NULL COMMENT '章节描述',
  `chapter_sp` double DEFAULT NULL COMMENT '章节比重（百分比）',
  `course_id` bigint(20) DEFAULT NULL COMMENT '科目编号',
  `creat_time` date DEFAULT NULL COMMENT '创建时间（yyyy-MM-dd HH:mm:ss）',
  `creator` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_time` date DEFAULT NULL COMMENT '修改时间（yyyy-MM-dd HH:mm:ss）',
  `modifier` bigint(20) DEFAULT NULL COMMENT '修改人',
  `Column_11` char(10) COLLATE utf8_general_ci DEFAULT NULL,
  `Column_12` char(10) COLLATE utf8_general_ci DEFAULT NULL,
  `Column_13` char(10) COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `f_exam_course_key` (`course_id`),
  CONSTRAINT `f_exam_course_key` FOREIGN KEY (`course_id`) REFERENCES `t_exam_course` (`course_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='科目章节信息表';

-- ----------------------------
-- Records of t_exam_course_chapter
-- ----------------------------

-- ----------------------------
-- Table structure for `t_exam_kind`
-- ----------------------------
DROP TABLE IF EXISTS `t_exam_kind`;
CREATE TABLE `t_exam_kind` (
  `kind_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '专业编号',
  `kind_name` varchar(32) COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '专业名称',
  `kind_effect` varchar(2) COLLATE utf8_general_ci NOT NULL COMMENT '专业生效标识（0：生效、1：失效）',
  `exam_id` bigint(20) NOT NULL COMMENT '考试类型编号',
  `create_time` date DEFAULT NULL COMMENT '创建时间（yyyy-MM-dd HH:mm:ss）',
  `creator` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_time` date DEFAULT NULL COMMENT '修改时间（yyyy-MM-dd HH:mm:ss）',
  `modifier` bigint(20) DEFAULT NULL COMMENT '修改人',
  `Column_1` char(10) COLLATE utf8_general_ci DEFAULT NULL,
  `Column_2` char(10) COLLATE utf8_general_ci DEFAULT NULL,
  `Column_3` char(10) COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`kind_id`),
  UNIQUE KEY `exam_kind_index` (`kind_id`) USING BTREE,
  KEY `f_exam_id_key` (`exam_id`),
  CONSTRAINT `f_exam_id_key` FOREIGN KEY (`exam_id`) REFERENCES `t_exam_type` (`exam_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='考试专业信息表';

-- ----------------------------
-- Records of t_exam_kind
-- ----------------------------

-- ----------------------------
-- Table structure for `t_exam_kind_course`
-- ----------------------------
DROP TABLE IF EXISTS `t_exam_kind_course`;
CREATE TABLE `t_exam_kind_course` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `kind_id` bigint(20) NOT NULL COMMENT '专业编号',
  `course_id` int(20) NOT NULL COMMENT '科目编号',
  `state` varchar(2) COLLATE utf8_general_ci NOT NULL COMMENT '生效状态（0：生效、1：失效）',
  `creat_time` date DEFAULT NULL COMMENT '创建时间（yyyy-MM-dd HH:mm:ss）',
  `creator` varchar(32) COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `update_time` date DEFAULT NULL COMMENT '修改时间（yyyy-MM-dd HH:mm:ss）',
  `modifier` varchar(32) COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改人',
  `Column_9` char(10) COLLATE utf8_general_ci DEFAULT NULL,
  `Column_10` char(10) COLLATE utf8_general_ci DEFAULT NULL,
  `Column_11` char(10) COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `exam_kind_course_index` (`id`) USING BTREE,
  KEY `f_exam_kind_id` (`kind_id`),
  CONSTRAINT `f_exam_kind_id` FOREIGN KEY (`kind_id`) REFERENCES `t_exam_kind` (`kind_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='考试专业科目表 -- 专业表与科目关联表';

-- ----------------------------
-- Records of t_exam_kind_course
-- ----------------------------

-- ----------------------------
-- Table structure for `t_exam_library`
-- ----------------------------
DROP TABLE IF EXISTS `t_exam_library`;
CREATE TABLE `t_exam_library` (
  `library_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '题库编号',
  `source_code` bigint(20) DEFAULT NULL COMMENT '题库来源编号（章节ID、试卷ID 与题库来源组合使用）',
  `source_type` bigint(20) DEFAULT NULL COMMENT '题库来源类别（参照T_EXAM_SOURCE表）',
  `library_type` varchar(2) COLLATE utf8_general_ci DEFAULT NULL COMMENT '题库类型（参照T_EXAM_LIBRARY_TYPE表）',
  `course_id` bigint(20) DEFAULT NULL COMMENT '科目编号',
  `state` varchar(2) COLLATE utf8_general_ci DEFAULT NULL COMMENT '题库状态（0：生效、1：失效）',
  `title` varchar(1000) COLLATE utf8_general_ci DEFAULT NULL COMMENT '题库标题',
  `select_content` varchar(1000) COLLATE utf8_general_ci DEFAULT NULL COMMENT '题库选项内容（简答内容）',
  `result` varchar(1000) COLLATE utf8_general_ci DEFAULT NULL COMMENT '题库正确答案',
  `analysis` varchar(1000) COLLATE utf8_general_ci DEFAULT NULL COMMENT '答案解析（说明）',
  `creat_time` date DEFAULT NULL COMMENT '创建时间（yyyy-MM-dd HH:mm:ss）',
  `creator` varchar(32) COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `update_time` date DEFAULT NULL COMMENT '修改时间（yyyy-MM-dd HH:mm:ss）',
  `modifier` varchar(32) COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改人',
  `Column_1` char(10) COLLATE utf8_general_ci DEFAULT NULL,
  `Column_2` char(10) COLLATE utf8_general_ci DEFAULT NULL,
  `Column_3` char(10) COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`library_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='考试题库表';

-- ----------------------------
-- Records of t_exam_library
-- ----------------------------

-- ----------------------------
-- Table structure for `t_exam_library_type`
-- ----------------------------
DROP TABLE IF EXISTS `t_exam_library_type`;
CREATE TABLE `t_exam_library_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增序列',
  `type_id` bigint(20) NOT NULL COMMENT '题库类型编号',
  `kind_simple_name` varchar(100) COLLATE utf8_general_ci NOT NULL COMMENT '题库类型简称',
  `kind_full_name` varchar(100) COLLATE utf8_general_ci NOT NULL COMMENT '题库类型全称',
  `creat_time` date DEFAULT NULL COMMENT '创建时间（yyyy-MM-dd HH:mm:ss）',
  `creator` varchar(32) COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `update_time` date DEFAULT NULL COMMENT '修改时间（yyyy-MM-dd HH:mm:ss）',
  `modifier` varchar(32) COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改人',
  `Column_1` char(10) COLLATE utf8_general_ci DEFAULT NULL,
  `Column_2` char(10) COLLATE utf8_general_ci DEFAULT NULL,
  `Column_4` char(10) COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='题库类型表';

-- ----------------------------
-- Records of t_exam_library_type
-- ----------------------------

-- ----------------------------
-- Table structure for `t_exam_paper`
-- ----------------------------
DROP TABLE IF EXISTS `t_exam_paper`;
CREATE TABLE `t_exam_paper` (
  `paper_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '试卷编号',
  `paper_name` varchar(32) COLLATE utf8_general_ci NOT NULL COMMENT '试卷名称',
  `paper_date` date NOT NULL COMMENT '试卷年份（yyyyMMdd）',
  `state` varchar(2) COLLATE utf8_general_ci NOT NULL COMMENT '试卷状态（0：生效、1：失效）',
  `paper_type` varchar(2) COLLATE utf8_general_ci NOT NULL COMMENT '试卷类型（1：真题、2：模拟）',
  `course_id` bigint(20) NOT NULL COMMENT '科目编号',
  `creat_time` date DEFAULT NULL COMMENT '创建时间（yyyy-MM-dd HH:mm:ss）',
  `creator` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_time` date DEFAULT NULL COMMENT '修改时间（yyyy-MM-dd HH:mm:ss）',
  `modifier` bigint(20) DEFAULT NULL COMMENT '修改人',
  `Column_1` char(10) COLLATE utf8_general_ci DEFAULT NULL,
  `Column_2` char(10) COLLATE utf8_general_ci DEFAULT NULL,
  `Column_3` char(10) COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`paper_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='考试试卷表';

-- ----------------------------
-- Records of t_exam_paper
-- ----------------------------

-- ----------------------------
-- Table structure for `t_exam_source`
-- ----------------------------
DROP TABLE IF EXISTS `t_exam_source`;
CREATE TABLE `t_exam_source` (
  `source_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '题库来源编号',
  `source_name` varchar(32) COLLATE utf8_general_ci NOT NULL COMMENT '题库来源名称',
  `creat_time` date DEFAULT NULL COMMENT '创建时间（yyyy-MM-dd HH:mm:ss）',
  `creator` varchar(32) COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `update_time` date DEFAULT NULL COMMENT '修改时间（yyyy-MM-dd HH:mm:ss）',
  `modifier` varchar(32) COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改人',
  `Column_1` char(10) COLLATE utf8_general_ci DEFAULT NULL,
  `Column_2` char(10) COLLATE utf8_general_ci DEFAULT NULL,
  `Column_4` char(10) COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`source_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='题库来源表';

-- ----------------------------
-- Records of t_exam_source
-- ----------------------------

-- ----------------------------
-- Table structure for `t_exam_type`
-- ----------------------------
DROP TABLE IF EXISTS `t_exam_type`;
CREATE TABLE `t_exam_type` (
  `exam_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '考试类型编号',
  `exam_name` varchar(20) COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '考试类型名称',
  `exam_effect` varchar(2) COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '考试类型生效标识（0：生效、1：失效）',
  `create_time` date DEFAULT NULL COMMENT '创建时间（yyyy-MM-dd HH:mm:ss）',
  `creator` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_time` date DEFAULT NULL COMMENT '更新时间（yyyy-MM-dd HH:mm:ss）',
  `modifier` bigint(20) DEFAULT NULL COMMENT '修改人',
  `Column_1` char(10) COLLATE utf8_general_ci DEFAULT NULL,
  `Column_2` char(10) COLLATE utf8_general_ci DEFAULT NULL,
  `Column_3` char(10) COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`exam_id`),
  UNIQUE KEY `exam_type_index` (`exam_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='考试类型表';

-- ----------------------------
-- Records of t_exam_type
-- ----------------------------

-- ----------------------------
-- Table structure for `t_kind_course_record`
-- ----------------------------
DROP TABLE IF EXISTS `t_kind_course_record`;
CREATE TABLE `t_kind_course_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增序列',
  `user_id` varchar(32) COLLATE utf8_general_ci NOT NULL COMMENT '用户编号',
  `exam_id` bigint(20) NOT NULL COMMENT '考试类型编号',
  `kind_id` bigint(20) NOT NULL COMMENT '专业类型编号',
  `course_id` bigint(20) NOT NULL COMMENT '科目类型编号',
  `state` varchar(2) COLLATE utf8_general_ci NOT NULL COMMENT '状态（0：已报、1：通过）',
  `creat_time` date DEFAULT NULL COMMENT '创建时间（yyyy-MM-dd HH:mm:ss）',
  `creator` varchar(32) COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `update_time` date DEFAULT NULL COMMENT '更新时间（yyyy-MM-dd HH:mm:ss）',
  `modifier` varchar(32) COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改时间',
  `Column_1` char(10) COLLATE utf8_general_ci DEFAULT NULL,
  `Column_2` char(10) COLLATE utf8_general_ci DEFAULT NULL,
  `Column_3` char(10) COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='用户专业科目记录表';

-- ----------------------------
-- Records of t_kind_course_record
-- ----------------------------

-- ----------------------------
-- Table structure for `t_login_log`
-- ----------------------------
DROP TABLE IF EXISTS `t_login_log`;
CREATE TABLE `t_login_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增序列',
  `user_id` varchar(32) COLLATE utf8_general_ci NOT NULL COMMENT '用户编号',
  `login_time` date DEFAULT NULL COMMENT '登录时间（yyyy-MM-dd HH:mm:ss）',
  `leave_time` date DEFAULT NULL COMMENT '离开时间（yyyy-MM-dd HH:mm:ss）',
  `operation` varchar(10) COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户操作',
  `creat_time` date DEFAULT NULL COMMENT '创建时间（yyyy-MM-dd HH:mm:ss）',
  `creator` varchar(32) COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `update_time` date DEFAULT NULL COMMENT '更新时间（yyyy-MM-dd HH:mm:ss）',
  `modifier` varchar(32) COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改人',
  `Column_1` char(10) COLLATE utf8_general_ci DEFAULT NULL,
  `Column_2` char(10) COLLATE utf8_general_ci DEFAULT NULL,
  `Column_3` char(10) COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='用户登录日志表';

-- ----------------------------
-- Records of t_login_log
-- ----------------------------

-- ----------------------------
-- Table structure for `t_share_record`
-- ----------------------------
DROP TABLE IF EXISTS `t_share_record`;
CREATE TABLE `t_share_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增序列',
  `title` varchar(100) COLLATE utf8_general_ci DEFAULT NULL COMMENT '分享标题',
  `content` varchar(1000) COLLATE utf8_general_ci DEFAULT NULL COMMENT '分享内容',
  `location` varchar(100) COLLATE utf8_general_ci DEFAULT NULL COMMENT '分享内容地址',
  `user_id` varchar(32) COLLATE utf8_general_ci NOT NULL COMMENT '用户编号',
  `creat_time` date DEFAULT NULL COMMENT '创建时间（yyyy-MM-dd HH:mm:ss）',
  `creator` varchar(32) COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `update_time` date DEFAULT NULL COMMENT '更新时间（yyyy-MM-dd HH:mm:ss）',
  `modifier` varchar(32) COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改人',
  `Column_1` char(10) COLLATE utf8_general_ci DEFAULT NULL,
  `Column_2` char(10) COLLATE utf8_general_ci DEFAULT NULL,
  `Column_3` char(10) COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='用户分享学习资料表';

-- ----------------------------
-- Records of t_share_record
-- ----------------------------

-- ----------------------------
-- Table structure for `t_study_record`
-- ----------------------------
DROP TABLE IF EXISTS `t_study_record`;
CREATE TABLE `t_study_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增序列',
  `library_id` bigint(20) NOT NULL COMMENT '题库编号',
  `user_answer` varchar(1000) COLLATE utf8_general_ci NOT NULL COMMENT '用户做题答案',
  `state` varchar(2) COLLATE utf8_general_ci NOT NULL COMMENT '做题状态（0：成功、1：失败）',
  `start_time` date DEFAULT NULL COMMENT '做题开始时间（yyyy-MM-dd HH:mm:ss）',
  `end_time` date DEFAULT NULL COMMENT '做题结束时间（yyyy-MM-ss HH:mm:ss）',
  `cost_time` longblob COMMENT '做题花费时间（单位：ms）',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `creat_time` date DEFAULT NULL COMMENT '创建时间（yyyy-MM-dd HH"mm:ss）',
  `creator` varchar(32) COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `update_time` date DEFAULT NULL COMMENT '修改时间（yyyy-MM-dd HH:mm:ss）',
  `modifier` varchar(32) COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改人',
  `Column_1` char(10) COLLATE utf8_general_ci DEFAULT NULL,
  `Column_2` char(10) COLLATE utf8_general_ci DEFAULT NULL,
  `Column_3` char(10) COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='用户做题记录表';

-- ----------------------------
-- Records of t_study_record
-- ----------------------------

-- ----------------------------
-- Table structure for `t_user_base`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_base`;
CREATE TABLE `t_user_base` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `real_name` varchar(32) COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户真实姓名',
  `login_code` varchar(11) COLLATE utf8_general_ci DEFAULT NULL COMMENT '登录账号',
  `nick_name` varchar(32) COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户昵称',
  `password` varchar(32) COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码（加密保存）',
  `logo` varchar(100) COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户头像（URI）',
  `register_time` date DEFAULT NULL COMMENT '注册时间（yyyy-MM-dd HH:mm:ss）',
  `role` varchar(2) COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色',
  `creat_time` date DEFAULT NULL COMMENT '创建时间（yyyy-MM-dd HH:mm:ss）',
  `creator` varchar(32) COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `update_time` date DEFAULT NULL COMMENT '更新时间（yyyy-MM-dd HH:mm:ss）',
  `modifier` varchar(32) COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改人',
  `Column_1` char(10) COLLATE utf8_general_ci DEFAULT NULL,
  `Column_2` char(10) COLLATE utf8_general_ci DEFAULT NULL,
  `Column_3` char(10) COLLATE utf8_general_ci DEFAULT NULL,
  UNIQUE KEY `user_base_id_index` (`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='用户基础信息表';

-- ----------------------------
-- Records of t_user_base
-- ----------------------------

-- ----------------------------
-- Table structure for `t_user_error_library`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_error_library`;
CREATE TABLE `t_user_error_library` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增序列',
  `library_id` bigint(20) NOT NULL COMMENT '题库编号',
  `state` varchar(2) COLLATE utf8_general_ci NOT NULL COMMENT '题目状态（0：错误、1：正确）',
  `user_answer` varchar(1000) COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户选择题库答案',
  `user_id` varchar(32) COLLATE utf8_general_ci NOT NULL COMMENT '用户编号',
  `creat_time` date DEFAULT NULL COMMENT '创建时间（yyyy-MM-dd HH:mm:ss）',
  `creator` varchar(32) COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `update_time` date DEFAULT NULL COMMENT '更新时间（yyyy-MM-dd HH:mm:ss）',
  `modifier` varchar(32) COLLATE utf8_general_ci DEFAULT NULL COMMENT '更新时间',
  `Column_1` char(10) COLLATE utf8_general_ci DEFAULT NULL,
  `Column_2` char(10) COLLATE utf8_general_ci DEFAULT NULL,
  `Column_3` char(10) COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='用户错题表';

-- ----------------------------
-- Records of t_user_error_library
-- ----------------------------

-- ----------------------------
-- Table structure for `t_user_extend`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_extend`;
CREATE TABLE `t_user_extend` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增序号',
  `qq` varchar(15) COLLATE utf8_general_ci DEFAULT NULL COMMENT 'qq号码',
  `web_chat` varchar(32) COLLATE utf8_general_ci DEFAULT NULL COMMENT '微信号码',
  `rank` varchar(32) COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户排名',
  `star` varchar(32) COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户等级',
  `star_logo` varchar(100) COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户等级图标',
  `share_time` bigint(20) DEFAULT NULL COMMENT '此用户已推广/分享次数',
  `share_success_time` bigint(20) DEFAULT NULL COMMENT '成功推广/分享次数',
  `userId` bigint(20) NOT NULL COMMENT '用户编号',
  `creat_time` date DEFAULT NULL COMMENT '创建时间（yyyy-MM-dd HH:mm:ss）',
  `creator` varchar(32) COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `update_time` date DEFAULT NULL COMMENT '更新时间（yyyy-MM-dd HH:mm:ss）',
  `modifier` varchar(32) COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改人',
  `Column_1` char(10) COLLATE utf8_general_ci DEFAULT NULL,
  `Column_2` char(10) COLLATE utf8_general_ci DEFAULT NULL,
  `Column_3` char(10) COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='用户扩展表';

-- ----------------------------
-- Records of t_user_extend
-- ----------------------------
