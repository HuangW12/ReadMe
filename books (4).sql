/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : books

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2018-11-12 21:01:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bcomment
-- ----------------------------
DROP TABLE IF EXISTS `bcomment`;
CREATE TABLE `bcomment` (
  `bcid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '求购信息评论ID',
  `uid` bigint(20) DEFAULT NULL COMMENT '评论用户ID',
  `buyid` bigint(20) DEFAULT NULL COMMENT '求购信息ID',
  `bctime` time DEFAULT NULL COMMENT '评论时间',
  `bc_comment` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '评论内容',
  PRIMARY KEY (`bcid`) USING BTREE,
  KEY `bc_uid` (`uid`) USING BTREE,
  KEY `bc_buyid` (`buyid`) USING BTREE,
  CONSTRAINT `bc_buyid` FOREIGN KEY (`buyid`) REFERENCES `buy` (`buyid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `bc_uid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of bcomment
-- ----------------------------

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `bid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '书籍ID',
  `author` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '作者',
  `uid` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `bname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '书籍名称',
  `btype` bigint(10) DEFAULT NULL COMMENT '书籍类型',
  `price` float DEFAULT NULL COMMENT '价格',
  `content` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '内容',
  `cover` binary(1) DEFAULT NULL COMMENT '封面图片',
  PRIMARY KEY (`bid`) USING BTREE,
  KEY `uid` (`uid`) USING BTREE,
  KEY `btype` (`btype`) USING BTREE,
  CONSTRAINT `btype` FOREIGN KEY (`btype`) REFERENCES `btype` (`btid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `uid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', '刘伟', '2016210002', '设计模式', '1', '10', null, null);

-- ----------------------------
-- Table structure for btype
-- ----------------------------
DROP TABLE IF EXISTS `btype`;
CREATE TABLE `btype` (
  `btid` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '书籍类型编号',
  `btname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '书籍类型名称',
  PRIMARY KEY (`btid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of btype
-- ----------------------------
INSERT INTO `btype` VALUES ('1', '计算机类');
INSERT INTO `btype` VALUES ('2', '文学类');
INSERT INTO `btype` VALUES ('3', '数学类');
INSERT INTO `btype` VALUES ('4', '生物学');
INSERT INTO `btype` VALUES ('5', '物理学');
INSERT INTO `btype` VALUES ('6', '化学类');
INSERT INTO `btype` VALUES ('7', '艺术类');
INSERT INTO `btype` VALUES ('8', '体育类');

-- ----------------------------
-- Table structure for buy
-- ----------------------------
DROP TABLE IF EXISTS `buy`;
CREATE TABLE `buy` (
  `buyid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '求购信息ID',
  `uid` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `btitle` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '求购信息标题（书籍名）',
  `bcontent` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '求购内容',
  `bdate` time DEFAULT NULL COMMENT '求购日期',
  PRIMARY KEY (`buyid`) USING BTREE,
  KEY `buid` (`uid`) USING BTREE,
  CONSTRAINT `buid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of buy
-- ----------------------------

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `nid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '新闻ID',
  `uid` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `ntitle` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '新闻标题',
  `ncontent` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '新闻内容',
  PRIMARY KEY (`nid`) USING BTREE,
  KEY `news_uid` (`uid`) USING BTREE,
  CONSTRAINT `news_uid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('1', '2016210001', '双十一活动', '双十一你剁手了吗？');

-- ----------------------------
-- Table structure for report
-- ----------------------------
DROP TABLE IF EXISTS `report`;
CREATE TABLE `report` (
  `rid` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '举报编号',
  `aid` bigint(10) DEFAULT NULL COMMENT '举报者id',
  `bid` bigint(10) DEFAULT NULL COMMENT '被举报者id',
  `rcomment` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '举报内容',
  `rstate` bigint(10) DEFAULT '0' COMMENT '未处理0 已处理1',
  PRIMARY KEY (`rid`) USING BTREE,
  KEY `aid` (`aid`) USING BTREE,
  KEY `bid` (`bid`) USING BTREE,
  CONSTRAINT `aid` FOREIGN KEY (`aid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `bid` FOREIGN KEY (`bid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of report
-- ----------------------------
INSERT INTO `report` VALUES ('1', '2016210002', '2016210003', null, '1');

-- ----------------------------
-- Table structure for scomment
-- ----------------------------
DROP TABLE IF EXISTS `scomment`;
CREATE TABLE `scomment` (
  `scid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '出售信息评论ID',
  `uid` bigint(20) DEFAULT NULL COMMENT '评论用户ID',
  `sid` bigint(20) DEFAULT NULL COMMENT '出售信息ID',
  `sctime` datetime NOT NULL COMMENT '评论时间',
  `sc_content` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '评论内容',
  PRIMARY KEY (`scid`) USING BTREE,
  KEY `cuid` (`uid`) USING BTREE,
  KEY `csid` (`sid`) USING BTREE,
  CONSTRAINT `cuid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `scid` FOREIGN KEY (`sid`) REFERENCES `sell` (`sid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of scomment
-- ----------------------------
INSERT INTO `scomment` VALUES ('1', '2016210003', '1', '2018-11-12 17:53:04', null);

-- ----------------------------
-- Table structure for sell
-- ----------------------------
DROP TABLE IF EXISTS `sell`;
CREATE TABLE `sell` (
  `sid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '出售信息ID',
  `uid` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `bid` bigint(20) DEFAULT NULL COMMENT '书籍ID',
  `stitle` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '出售信息标题',
  `scontent` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '出售内容',
  `sdate` datetime NOT NULL COMMENT '出售信息发布日期',
  PRIMARY KEY (`sid`) USING BTREE,
  KEY `suid` (`uid`) USING BTREE,
  KEY `sbid` (`bid`) USING BTREE,
  CONSTRAINT `sbid` FOREIGN KEY (`bid`) REFERENCES `book` (`bid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `suid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sell
-- ----------------------------
INSERT INTO `sell` VALUES ('1', '2016210002', '1', '出售《设计模式》', null, '2018-11-12 00:00:00');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` bigint(20) NOT NULL COMMENT '用户ID',
  `tname` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '真实姓名',
  `uname` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户名',
  `upass` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
  `utype` int(11) DEFAULT '0' COMMENT '管理员1  用户0',
  `ustate` bigint(10) DEFAULT '0' COMMENT '默认0 冻结状态1',
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2016210001', '张三', 'admin', 'admin', '1', '0');
INSERT INTO `user` VALUES ('2016210002', '李四', 'user1', 'user1', '0', '0');
INSERT INTO `user` VALUES ('2016210003', '王五', 'user2', 'user2', '0', '1');
