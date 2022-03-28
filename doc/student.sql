/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : localhost:3306
 Source Schema         : student

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 23/03/2022 01:41:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for avg_score
-- ----------------------------
DROP TABLE IF EXISTS `avg_score`;
CREATE TABLE `avg_score`  (
  `id` char(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'id',
  `final_exam_avg` decimal(50, 2) NULL DEFAULT NULL COMMENT '结课考试平均分',
  `usual_grade_avg` decimal(50, 2) NULL DEFAULT NULL COMMENT '平时成绩平均分',
  `unit_test_avg` decimal(50, 2) NULL DEFAULT NULL COMMENT '单元测试平均分',
  `class_behave_avg` decimal(50, 2) NULL DEFAULT NULL COMMENT '课堂表现与考勤平均分',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '平均分' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of avg_score
-- ----------------------------
INSERT INTO `avg_score` VALUES ('00000000', 80.59, 83.41, 83.41, 10.10);

-- ----------------------------
-- Table structure for class_behave
-- ----------------------------
DROP TABLE IF EXISTS `class_behave`;
CREATE TABLE `class_behave`  (
  `id` char(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'id',
  `course_target_id` char(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '课程目标id',
  `course_target_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '课程目标名称',
  `weight` decimal(50, 2) NULL DEFAULT NULL COMMENT '权重',
  `goal_grade` decimal(50, 2) NULL DEFAULT NULL COMMENT '目标分值',
  `actual_avg_grade` decimal(50, 2) NULL DEFAULT NULL COMMENT '实际平均分',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '课堂表现' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of class_behave
-- ----------------------------
INSERT INTO `class_behave` VALUES ('u1vrD7Iu', '0000000', '课程目标1', 0.33, 20.00, 2.02);

-- ----------------------------
-- Table structure for course_comment
-- ----------------------------
DROP TABLE IF EXISTS `course_comment`;
CREATE TABLE `course_comment`  (
  `id` char(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'id',
  `course_target_id` char(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '课程目标id',
  `course_target_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '课程目标名称',
  `course_comment` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '状态|枚举[CourseCommentStatusEnum]: A(\"A\", \"A\"),B(\"B\", \"B\"),C(\"C\", \"C\"),D(\"D\", \"D\"),E(\"E\", \"E\")',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '课程目标' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course_comment
-- ----------------------------
INSERT INTO `course_comment` VALUES ('0HougpGY', '0000002', '课程目标3', 'A');
INSERT INTO `course_comment` VALUES ('13P9bgfZ', '0000001', '课程目标2', 'A');
INSERT INTO `course_comment` VALUES ('1fPz9Nji', '0000001', '课程目标2', 'A');
INSERT INTO `course_comment` VALUES ('1jUeeNum', '0000001', '课程目标2', 'A');
INSERT INTO `course_comment` VALUES ('1Wvtjd2b', '0000001', '课程目标2', 'A');
INSERT INTO `course_comment` VALUES ('25SqUNZh', '0000001', '课程目标2', 'A');
INSERT INTO `course_comment` VALUES ('2sdpWHXu', '0000002', '课程目标3', 'B');
INSERT INTO `course_comment` VALUES ('2V5r4qnr', '0000001', '课程目标2', 'A');
INSERT INTO `course_comment` VALUES ('3L1Lu0L9', '0000001', '课程目标2', 'A');
INSERT INTO `course_comment` VALUES ('3mIVuEjA', '0000002', '课程目标3', 'B');
INSERT INTO `course_comment` VALUES ('3msmjUzD', '0000002', '课程目标3', 'A');
INSERT INTO `course_comment` VALUES ('431PWuKb', '0000001', '课程目标2', 'C');
INSERT INTO `course_comment` VALUES ('4fZww3hG', '0000002', '课程目标3', 'A');
INSERT INTO `course_comment` VALUES ('59VA0B9b', '0000002', '课程目标3', 'A');
INSERT INTO `course_comment` VALUES ('5gY8zUaN', '0000001', '课程目标2', 'B');
INSERT INTO `course_comment` VALUES ('5RuYAxRS', '0000001', '课程目标2', 'B');
INSERT INTO `course_comment` VALUES ('61R3SktP', '0000002', '课程目标3', 'A');
INSERT INTO `course_comment` VALUES ('66WWPt9Q', '0000002', '课程目标3', 'A');
INSERT INTO `course_comment` VALUES ('6Nu94zi5', '0000001', '课程目标2', 'A');
INSERT INTO `course_comment` VALUES ('7eA0YxlH', '0000002', '课程目标3', 'A');
INSERT INTO `course_comment` VALUES ('7fq4tQWx', '0000002', '课程目标3', 'C');
INSERT INTO `course_comment` VALUES ('7h8LyNbA', '0000001', '课程目标2', 'A');
INSERT INTO `course_comment` VALUES ('7o77d2GO', '0000002', '课程目标3', 'A');
INSERT INTO `course_comment` VALUES ('7sIV0fbh', '0000002', '课程目标3', 'B');
INSERT INTO `course_comment` VALUES ('8Hi1rP2x', '0000002', '课程目标3', 'B');
INSERT INTO `course_comment` VALUES ('8IdFqw1V', '0000001', '课程目标2', 'B');
INSERT INTO `course_comment` VALUES ('8kl97QfI', '0000002', '课程目标3', 'B');
INSERT INTO `course_comment` VALUES ('9eNlzXEB', '0000002', '课程目标3', 'A');
INSERT INTO `course_comment` VALUES ('A9JG9K46', '0000002', '课程目标3', 'A');
INSERT INTO `course_comment` VALUES ('Aev5Mo4l', '0000002', '课程目标3', 'B');
INSERT INTO `course_comment` VALUES ('AGOGQ3yL', '0000002', '课程目标3', 'A');
INSERT INTO `course_comment` VALUES ('AjIA8fck', '0000001', '课程目标2', 'A');
INSERT INTO `course_comment` VALUES ('aKMZJzXX', '0000002', '课程目标3', 'C');
INSERT INTO `course_comment` VALUES ('aP8XFzP5', '0000001', '课程目标2', 'B');
INSERT INTO `course_comment` VALUES ('aZMFRxqd', '0000001', '课程目标2', 'A');
INSERT INTO `course_comment` VALUES ('B082qF4y', '0000002', '课程目标3', 'C');
INSERT INTO `course_comment` VALUES ('B1SI51yo', '0000002', '课程目标3', 'B');
INSERT INTO `course_comment` VALUES ('B5c9Tkfy', '0000001', '课程目标2', 'A');
INSERT INTO `course_comment` VALUES ('baDiLvc7', '0000002', '课程目标3', 'A');
INSERT INTO `course_comment` VALUES ('BJJoKxLk', '0000002', '课程目标3', 'A');
INSERT INTO `course_comment` VALUES ('bORxw5l4', '0000002', '课程目标3', 'B');
INSERT INTO `course_comment` VALUES ('C0IkKE4w', '0000002', '课程目标3', 'B');
INSERT INTO `course_comment` VALUES ('C7jfRuVR', '0000001', '课程目标2', 'A');
INSERT INTO `course_comment` VALUES ('c8LFjaFn', '0000001', '课程目标2', 'B');
INSERT INTO `course_comment` VALUES ('Cdb7ytHE', '0000001', '课程目标2', 'B');
INSERT INTO `course_comment` VALUES ('cpOl2mT8', '0000001', '课程目标2', 'A');
INSERT INTO `course_comment` VALUES ('CxhYa7aR', '0000001', '课程目标2', 'A');
INSERT INTO `course_comment` VALUES ('D5PBC7Z3', '0000001', '课程目标2', 'A');
INSERT INTO `course_comment` VALUES ('Db6ppodM', '0000001', '课程目标2', 'B');
INSERT INTO `course_comment` VALUES ('dveD7aSt', '0000002', '课程目标3', 'B');
INSERT INTO `course_comment` VALUES ('e70vgXnJ', '0000002', '课程目标3', 'C');
INSERT INTO `course_comment` VALUES ('EAaqPeiS', '0000001', '课程目标2', 'A');
INSERT INTO `course_comment` VALUES ('eCmjkn5z', '0000001', '课程目标2', 'B');
INSERT INTO `course_comment` VALUES ('eS5A35RW', '0000001', '课程目标2', 'C');
INSERT INTO `course_comment` VALUES ('F9z4SzPj', '0000002', '课程目标3', 'B');
INSERT INTO `course_comment` VALUES ('FCLfANnf', '0000002', '课程目标3', 'A');
INSERT INTO `course_comment` VALUES ('fjnZfODC', '0000001', '课程目标2', 'A');
INSERT INTO `course_comment` VALUES ('Flerf1ik', '0000002', '课程目标3', 'A');
INSERT INTO `course_comment` VALUES ('fqQNU6O7', '0000002', '课程目标3', 'B');
INSERT INTO `course_comment` VALUES ('fW4wFsqI', '0000002', '课程目标3', 'A');
INSERT INTO `course_comment` VALUES ('GeWzgViq', '0000001', '课程目标2', 'B');
INSERT INTO `course_comment` VALUES ('Geyx59UR', '0000001', '课程目标2', 'A');
INSERT INTO `course_comment` VALUES ('ghzp2PNu', '0000001', '课程目标2', 'C');
INSERT INTO `course_comment` VALUES ('GO0JLmDz', '0000001', '课程目标2', 'A');
INSERT INTO `course_comment` VALUES ('Goc2Bvgt', '0000002', '课程目标3', 'A');
INSERT INTO `course_comment` VALUES ('gPtaCsyo', '0000001', '课程目标2', 'B');
INSERT INTO `course_comment` VALUES ('HIiVdRRr', '0000001', '课程目标2', 'A');
INSERT INTO `course_comment` VALUES ('hOHGTl7V', '0000001', '课程目标2', 'A');
INSERT INTO `course_comment` VALUES ('hoZqmc6T', '0000001', '课程目标2', 'A');
INSERT INTO `course_comment` VALUES ('HSq85YSp', '0000002', '课程目标3', 'B');
INSERT INTO `course_comment` VALUES ('hV7AmzMa', '0000002', '课程目标3', 'A');
INSERT INTO `course_comment` VALUES ('hWC7zMLF', '0000001', '课程目标2', 'A');
INSERT INTO `course_comment` VALUES ('HZBoxwGW', '0000002', '课程目标3', 'A');
INSERT INTO `course_comment` VALUES ('ia9FUtq2', '0000001', '课程目标2', 'A');
INSERT INTO `course_comment` VALUES ('ID3L8K3L', '0000002', '课程目标3', 'A');
INSERT INTO `course_comment` VALUES ('ItVlcWuX', '0000001', '课程目标2', 'A');
INSERT INTO `course_comment` VALUES ('iWZcuT07', '0000001', '课程目标2', 'C');
INSERT INTO `course_comment` VALUES ('IZ4ulVoi', '0000001', '课程目标2', 'A');
INSERT INTO `course_comment` VALUES ('iZl5rAMd', '0000001', '课程目标2', 'A');
INSERT INTO `course_comment` VALUES ('j8h1qmBt', '0000001', '课程目标2', 'B');
INSERT INTO `course_comment` VALUES ('Jof5bdCC', '0000002', '课程目标3', 'B');
INSERT INTO `course_comment` VALUES ('jpEs4Y8T', '0000002', '课程目标3', 'B');
INSERT INTO `course_comment` VALUES ('jPwqMxhA', '0000002', '课程目标3', 'B');
INSERT INTO `course_comment` VALUES ('jqzc8gVT', '0000002', '课程目标3', 'A');
INSERT INTO `course_comment` VALUES ('k3YWs1Ni', '0000001', '课程目标2', 'B');
INSERT INTO `course_comment` VALUES ('kaChTTTM', '0000002', '课程目标3', 'B');
INSERT INTO `course_comment` VALUES ('kCimynnl', '0000001', '课程目标2', 'A');
INSERT INTO `course_comment` VALUES ('KCNnH6rC', '0000001', '课程目标2', 'A');
INSERT INTO `course_comment` VALUES ('knnaxgMj', '0000002', '课程目标3', 'C');
INSERT INTO `course_comment` VALUES ('KpwQ0Mvr', '0000002', '课程目标3', 'A');
INSERT INTO `course_comment` VALUES ('kryCDddX', '0000001', '课程目标2', 'A');
INSERT INTO `course_comment` VALUES ('KXocW8jE', '0000001', '课程目标2', 'A');
INSERT INTO `course_comment` VALUES ('LNvyhfDb', '0000001', '课程目标2', 'B');
INSERT INTO `course_comment` VALUES ('lx2pfGsn', '0000001', '课程目标2', 'A');
INSERT INTO `course_comment` VALUES ('lyDK24yn', '0000001', '课程目标2', 'A');
INSERT INTO `course_comment` VALUES ('lyMpWiZ1', '0000001', '课程目标2', 'A');
INSERT INTO `course_comment` VALUES ('Mad69JjK', '0000001', '课程目标2', 'B');
INSERT INTO `course_comment` VALUES ('mbarxYvQ', '0000001', '课程目标2', 'B');
INSERT INTO `course_comment` VALUES ('Mcr3DC0d', '0000002', '课程目标3', 'A');
INSERT INTO `course_comment` VALUES ('mea82Sy1', '0000002', '课程目标3', 'A');
INSERT INTO `course_comment` VALUES ('mhRcxEbp', '0000001', '课程目标2', 'A');
INSERT INTO `course_comment` VALUES ('Mmb6am04', '0000001', '课程目标2', 'A');
INSERT INTO `course_comment` VALUES ('MwT42bl4', '0000001', '课程目标2', 'A');
INSERT INTO `course_comment` VALUES ('N0TAdReC', '0000001', '课程目标2', 'A');
INSERT INTO `course_comment` VALUES ('NPJY24Ks', '0000002', '课程目标3', 'A');
INSERT INTO `course_comment` VALUES ('NyggYfWl', '0000001', '课程目标2', 'A');
INSERT INTO `course_comment` VALUES ('NyIFlEie', '0000001', '课程目标2', 'A');
INSERT INTO `course_comment` VALUES ('NZ1SF32t', '0000002', '课程目标3', 'A');
INSERT INTO `course_comment` VALUES ('OJcs3rHU', '0000002', '课程目标3', 'A');
INSERT INTO `course_comment` VALUES ('OZR2XIzr', '0000002', '课程目标3', 'B');
INSERT INTO `course_comment` VALUES ('pAfQTPgc', '0000002', '课程目标3', 'A');
INSERT INTO `course_comment` VALUES ('pBQxdiRQ', '0000002', '课程目标3', 'A');
INSERT INTO `course_comment` VALUES ('pF4ZSQYR', '0000002', '课程目标3', 'A');
INSERT INTO `course_comment` VALUES ('PRNAx2uF', '0000001', '课程目标2', 'B');
INSERT INTO `course_comment` VALUES ('PT5wWUsr', '0000001', '课程目标2', 'A');
INSERT INTO `course_comment` VALUES ('q1kzqwlE', '0000002', '课程目标3', 'A');
INSERT INTO `course_comment` VALUES ('qE89EgAy', '0000002', '课程目标3', 'A');
INSERT INTO `course_comment` VALUES ('QewZ9OBf', '0000001', '课程目标2', 'A');
INSERT INTO `course_comment` VALUES ('qoZfrt2C', '0000001', '课程目标2', 'A');
INSERT INTO `course_comment` VALUES ('r3b8q4kI', '0000001', '课程目标2', 'B');
INSERT INTO `course_comment` VALUES ('RhOBNLiC', '0000002', '课程目标3', 'A');
INSERT INTO `course_comment` VALUES ('ri6HjKK0', '0000002', '课程目标3', 'B');
INSERT INTO `course_comment` VALUES ('S16KoxaX', '0000002', '课程目标3', 'A');
INSERT INTO `course_comment` VALUES ('S7iIPgcV', '0000002', '课程目标3', 'B');
INSERT INTO `course_comment` VALUES ('sddvQgy2', '0000002', '课程目标3', 'A');
INSERT INTO `course_comment` VALUES ('sdG7vweX', '0000002', '课程目标3', 'A');
INSERT INTO `course_comment` VALUES ('snxAdk1U', '0000001', '课程目标2', 'A');
INSERT INTO `course_comment` VALUES ('sQb1pmrS', '0000001', '课程目标2', 'B');
INSERT INTO `course_comment` VALUES ('sTIliTJV', '0000002', '课程目标3', 'A');
INSERT INTO `course_comment` VALUES ('TRAsPpnS', '0000002', '课程目标3', 'A');
INSERT INTO `course_comment` VALUES ('U9dbXfbB', '0000002', '课程目标3', 'B');
INSERT INTO `course_comment` VALUES ('uEIOFtDu', '0000002', '课程目标3', 'A');
INSERT INTO `course_comment` VALUES ('Ufmbhd7q', '0000001', '课程目标2', 'B');
INSERT INTO `course_comment` VALUES ('UjcvCBTN', '0000001', '课程目标2', 'C');
INSERT INTO `course_comment` VALUES ('UmwT52sH', '0000002', '课程目标3', 'A');
INSERT INTO `course_comment` VALUES ('UqLIjVzL', '0000001', '课程目标2', 'A');
INSERT INTO `course_comment` VALUES ('uyLiK85c', '0000002', '课程目标3', 'A');
INSERT INTO `course_comment` VALUES ('VELBzIdT', '0000001', '课程目标2', 'B');
INSERT INTO `course_comment` VALUES ('vM2EAJwh', '0000002', '课程目标3', 'A');
INSERT INTO `course_comment` VALUES ('VVM8Tn5O', '0000001', '课程目标2', 'A');
INSERT INTO `course_comment` VALUES ('VZz6UJe4', '0000001', '课程目标2', 'A');
INSERT INTO `course_comment` VALUES ('w94bSIvx', '0000002', '课程目标3', 'A');
INSERT INTO `course_comment` VALUES ('WFAIHad8', '0000001', '课程目标2', 'B');
INSERT INTO `course_comment` VALUES ('wga4YDA7', '0000002', '课程目标3', 'B');
INSERT INTO `course_comment` VALUES ('Wt4vnTGq', '0000001', '课程目标2', 'A');
INSERT INTO `course_comment` VALUES ('x1CCSuWc', '0000002', '课程目标3', 'A');
INSERT INTO `course_comment` VALUES ('xbTkMxPi', '0000002', '课程目标3', 'A');
INSERT INTO `course_comment` VALUES ('xEOatQOE', '0000001', '课程目标2', 'B');
INSERT INTO `course_comment` VALUES ('XSHy4bCG', '0000001', '课程目标2', 'A');
INSERT INTO `course_comment` VALUES ('XUzYrslX', '0000002', '课程目标3', 'B');
INSERT INTO `course_comment` VALUES ('xwJtI3pF', '0000002', '课程目标3', 'A');
INSERT INTO `course_comment` VALUES ('XXeGfClE', '0000002', '课程目标3', 'B');
INSERT INTO `course_comment` VALUES ('XZvzVIEb', '0000001', '课程目标2', 'A');
INSERT INTO `course_comment` VALUES ('z36UiLKN', '0000002', '课程目标3', 'A');
INSERT INTO `course_comment` VALUES ('z66YHbWM', '0000002', '课程目标3', 'A');
INSERT INTO `course_comment` VALUES ('zB6sNsdC', '0000002', '课程目标3', 'A');
INSERT INTO `course_comment` VALUES ('ZdwAYBul', '0000002', '课程目标3', 'A');
INSERT INTO `course_comment` VALUES ('ZgUKXarb', '0000002', '课程目标3', 'A');
INSERT INTO `course_comment` VALUES ('Zn3cagTh', '0000002', '课程目标3', 'A');
INSERT INTO `course_comment` VALUES ('ZP2s3uvO', '0000001', '课程目标2', 'B');
INSERT INTO `course_comment` VALUES ('ZV4O8b0c', '0000001', '课程目标2', 'B');
INSERT INTO `course_comment` VALUES ('zZ9lTYkE', '0000001', '课程目标2', 'A');

-- ----------------------------
-- Table structure for course_target
-- ----------------------------
DROP TABLE IF EXISTS `course_target`;
CREATE TABLE `course_target`  (
  `id` char(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'id',
  `target` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '课程目标',
  `teacher_evaluate` decimal(50, 2) NULL DEFAULT NULL COMMENT '老师评价',
  `student_evaluate` decimal(50, 2) NULL DEFAULT NULL COMMENT '学生评价',
  `goal_score` decimal(50, 2) NULL DEFAULT NULL COMMENT '目标分支',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '课程目标' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course_target
-- ----------------------------
INSERT INTO `course_target` VALUES ('0000000', '课程目标1', 0.62, 0.00, 0.57);
INSERT INTO `course_target` VALUES ('0000001', '课程目标2', 0.70, 18.55, 0.46);
INSERT INTO `course_target` VALUES ('0000002', '课程目标3', 0.80, 18.55, 0.58);
INSERT INTO `course_target` VALUES ('tTFr9ZXc', '课程目标4', 0.70, 0.00, 0.02);

-- ----------------------------
-- Table structure for course_target_low
-- ----------------------------
DROP TABLE IF EXISTS `course_target_low`;
CREATE TABLE `course_target_low`  (
  `id` char(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'id',
  `teacher_evaluate` decimal(50, 2) NULL DEFAULT NULL COMMENT '老师评价',
  `student_evaluate` decimal(50, 2) NULL DEFAULT NULL COMMENT '学生评价',
  `goal_grade` decimal(50, 2) NULL DEFAULT NULL COMMENT '目标达成评价值',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '课程目标' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course_target_low
-- ----------------------------
INSERT INTO `course_target_low` VALUES ('00000000', 0.62, 0.00, 0.02);

-- ----------------------------
-- Table structure for final_exam
-- ----------------------------
DROP TABLE IF EXISTS `final_exam`;
CREATE TABLE `final_exam`  (
  `id` char(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'id',
  `course_target_id` char(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '课程目标id',
  `course_target_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '课程目标名称',
  `weight` decimal(50, 2) NULL DEFAULT NULL COMMENT '权重',
  `goal_grade` decimal(50, 2) NULL DEFAULT NULL COMMENT '目标分值',
  `actual_avg_grade` decimal(50, 2) NULL DEFAULT NULL COMMENT '实际平均分',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '结课考试' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of final_exam
-- ----------------------------
INSERT INTO `final_exam` VALUES ('b2SSBLuB', '0000000', '课程目标1', 0.33, 20.00, 16.12);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` char(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'id',
  `class_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '班级',
  `student_number` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '学号',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '姓名',
  `gender` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '状态|枚举[GenderStatusEnum]:MALE(\"1\", \"男性\"),FEMALE(\"0\", \"女性\")',
  `school_system` int(0) NULL DEFAULT NULL COMMENT '学制',
  `final_exam` decimal(50, 0) NULL DEFAULT NULL COMMENT '结课考试',
  `usual_grade` decimal(50, 0) NULL DEFAULT NULL COMMENT '平时成绩',
  `unit_test` decimal(50, 0) NULL DEFAULT NULL COMMENT '单元测试',
  `class_behave` decimal(50, 0) NULL DEFAULT NULL COMMENT '课堂表现与考勤',
  `final_result` decimal(50, 0) NULL DEFAULT NULL COMMENT '综合成绩',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '学生' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('0lNPJtCD', '中文202', '20201314210', '孔德璇', '女', 4, 76, 85, 85, 8, 72);
INSERT INTO `student` VALUES ('0QX5EAs2', '中文202', '20201314215', '王泷', '女', 4, 79, 85, 90, 12, 75);
INSERT INTO `student` VALUES ('3Nf4U1Hh', '中文202', '20201314226', '彭娜娜', '女', 4, 82, 85, 90, 10, 77);
INSERT INTO `student` VALUES ('3UPQav9Y', '中文202', '20201314205', '孙梦源', '女', 4, 82, 85, 90, 10, 77);
INSERT INTO `student` VALUES ('43UxB17M', '中文203', '20201314317', '王依帆', '女', 4, 81, 85, 90, 10, 76);
INSERT INTO `student` VALUES ('4MplZlQP', '中文202', '20201314214', '王书凝', '女', 4, 90, 85, 90, 10, 82);
INSERT INTO `student` VALUES ('5FL24qCM', '中文201', '20201314121', '常梦雯', '女', 4, 93, 85, 85, 10, 82);
INSERT INTO `student` VALUES ('5XDjEz5f', '中文203', '20201314322', '李颖', '女', 4, 86, 85, 90, 10, 79);
INSERT INTO `student` VALUES ('66dEhlL5', '中文202', '20201314202', '郭英豪', '男', 4, 74, 85, 78, 10, 70);
INSERT INTO `student` VALUES ('7IpPZBsi', '中文202', '20201314222', '张文琦', '女', 4, 84, 85, 90, 10, 78);
INSERT INTO `student` VALUES ('93cBvzXD', '中文202', '20201314221', '高芷若', '女', 4, 93, 85, 90, 10, 83);
INSERT INTO `student` VALUES ('9EEHZddV', '中文201', '20201314103', '谭连海', '男', 4, 48, 66, 70, 11, 51);
INSERT INTO `student` VALUES ('AxO5VZVn', '中文201', '20201314105', '罗美薇', '女', 4, 93, 85, 90, 10, 83);
INSERT INTO `student` VALUES ('B52JSZal', '中文201', '20201314124', '陈冉', '女', 4, 89, 85, 85, 10, 80);
INSERT INTO `student` VALUES ('BBZMwjq3', '中文201', '20201314102', '孙浩硯', '男', 4, 85, 90, 91, 10, 79);
INSERT INTO `student` VALUES ('BFV66Tek', '中文203', '20201314318', '刘晨雨', '女', 4, 96, 85, 88, 10, 85);
INSERT INTO `student` VALUES ('bjKTfvV5', '中文203', '20201314304', '王耀康', '男', 4, 74, 85, 92, 10, 72);
INSERT INTO `student` VALUES ('C9GDBYVj', '中文202', '20201314227', '苗昱芳', '女', 4, 93, 85, 89, 10, 83);
INSERT INTO `student` VALUES ('CWv5wkQt', '中文203', '20201314320', '邢保珠', '女', 4, 87, 85, 90, 13, 80);
INSERT INTO `student` VALUES ('DaW4PKh9', '中文202', '20201314201', '张宇琦', '男', 4, 98, 85, 90, 10, 86);
INSERT INTO `student` VALUES ('dIyjxa69', '中文201', '20201314123', '王思影', '女', 4, 90, 85, 90, 11, 82);
INSERT INTO `student` VALUES ('DLHASQ4V', '中文203', '20201314301', '段江湖', '男', 4, 65, 85, 91, 12, 67);
INSERT INTO `student` VALUES ('dprXK0PK', '中文201', '20201314104', '王高强', '男', 4, 48, 65, 75, 9, 51);
INSERT INTO `student` VALUES ('dwiErDJp', '中文202', '20201314208', '王灿晨', '女', 4, 84, 85, 90, 10, 78);
INSERT INTO `student` VALUES ('E1q4GsEC', '中文202', '20201314217', '刘冰', '女', 4, 95, 85, 90, 10, 85);
INSERT INTO `student` VALUES ('esLxqsMP', '中文202', '20201314224', '熊延姝', '女', 4, 90, 85, 93, 10, 82);
INSERT INTO `student` VALUES ('f1MNmhPJ', '中文203', '20201314316', '张睿', '女', 4, 87, 85, 90, 10, 80);
INSERT INTO `student` VALUES ('fNlYojMI', '中文201', '20201314116', '邢鹏宇', '女', 4, 81, 85, 90, 10, 76);
INSERT INTO `student` VALUES ('ftWrEZGq', '中文201', '20201314114', '陈羽霏', '女', 4, 89, 85, 90, 10, 81);
INSERT INTO `student` VALUES ('G0cPCzsf', '中文203', '20201314306', '卢晓文', '女', 4, 78, 85, 90, 10, 74);
INSERT INTO `student` VALUES ('GOh7IC60', '中文202', '20201314219', '彭美琦', '女', 4, 99, 85, 90, 10, 87);
INSERT INTO `student` VALUES ('H9bqmsmD', '中文203', '20201314303', '李恒源', '男', 4, 68, 85, 90, 10, 68);
INSERT INTO `student` VALUES ('hT8zNgHi', '中文201', '20201314107', '魏洁', '女', 4, 73, 85, 79, 13, 69);
INSERT INTO `student` VALUES ('jEGIMq25', '中文201', '20201314110', '吕宝利', '女', 4, 87, 85, 90, 10, 80);
INSERT INTO `student` VALUES ('JgozaVRi', '中文202', '20201314216', '袁晨', '女', 4, 72, 85, 90, 10, 71);
INSERT INTO `student` VALUES ('jOYPuBiB', '中文202', '20201314213', '赵芮', '女', 4, 97, 85, 90, 10, 86);
INSERT INTO `student` VALUES ('ka6a2AmX', '中文203', '20201314310', '郝苗苗', '女', 4, 83, 85, 87, 9, 77);
INSERT INTO `student` VALUES ('khfMMDWF', '中文201', '20201314119', '杜笑竽', '女', 4, 70, 85, 90, 10, 70);
INSERT INTO `student` VALUES ('KPbICDSH', '中文203', '20201314323', '王歆蕾', '女', 4, 98, 85, 92, 10, 87);
INSERT INTO `student` VALUES ('L3h3Powl', '中文201', '20201314106', '张迪', '女', 4, 50, 77, 74, 10, 54);
INSERT INTO `student` VALUES ('LwrJdpIf', '中文202', '20201314211', '胡梦淇', '女', 4, 85, 85, 90, 10, 79);
INSERT INTO `student` VALUES ('LxNtsb9p', '中文202', '20201314207', '李娜', '女', 4, 69, 85, 80, 10, 67);
INSERT INTO `student` VALUES ('M3BWrNnQ', '中文203', '20201314309', '胡子卓', '女', 4, 80, 85, 90, 10, 76);
INSERT INTO `student` VALUES ('mOMybLs9', '中文201', '20201314108', '孟小涵', '女', 4, 87, 85, 90, 10, 80);
INSERT INTO `student` VALUES ('MoXejA04', '中文202', '20201314203', '刘佳男', '男', 4, 60, 85, 79, 10, 61);
INSERT INTO `student` VALUES ('MuomZnUb', '中文201', '20201314111', '黄义萌', '女', 4, 51, 73, 76, 9, 54);
INSERT INTO `student` VALUES ('Ng6OI2Hb', '中文202', '20201314209', '吴雨迎', '女', 4, 74, 85, 79, 10, 70);
INSERT INTO `student` VALUES ('nQnJXhcT', '中文201', '20201314126', '胡若冰', '女', 4, 85, 85, 83, 10, 77);
INSERT INTO `student` VALUES ('NwxR50gy', '中文201', '20201314120', '徐梦灿', '女', 4, 86, 85, 90, 10, 79);
INSERT INTO `student` VALUES ('NxNh63n9', '中文202', '20201314225', '王梦洁', '女', 4, 46, 70, 78, 10, 51);
INSERT INTO `student` VALUES ('OQpNHxYU', '中文203', '20201314319', '封彦艺', '女', 4, 81, 85, 90, 10, 76);
INSERT INTO `student` VALUES ('PJdDtt3j', '中文202', '20201314220', '黄蓣瑾', '女', 4, 79, 85, 70, 10, 71);
INSERT INTO `student` VALUES ('PPqw96rL', '中文203', '20201314326', '牛瑶', '女', 4, 86, 85, 90, 10, 79);
INSERT INTO `student` VALUES ('qfeHJLHp', '中文202', '20201314228', '贾爽', '女', 4, 86, 85, 90, 10, 79);
INSERT INTO `student` VALUES ('qPpJOLlG', '中文201', '20201314125', '杨宇霞', '女', 4, 82, 85, 90, 10, 77);
INSERT INTO `student` VALUES ('QWpAwYx2', '中文203', '20201314311', '曾雨欣', '女', 4, 80, 85, 90, 10, 76);
INSERT INTO `student` VALUES ('QwrcuMHj', '中文201', '20201314127', '冯茁', '女', 4, 66, 79, 76, 8, 64);
INSERT INTO `student` VALUES ('Rlv5JOjS', '中文202', '20201314223', '王好好', '女', 4, 91, 85, 90, 8, 82);
INSERT INTO `student` VALUES ('rMBvuUdz', '中文203', '20201314307', '杨巧', '女', 4, 81, 85, 86, 13, 76);
INSERT INTO `student` VALUES ('rpMvM4JC', '中文201', '20201314122', '唐欣然', '女', 4, 95, 85, 90, 10, 85);
INSERT INTO `student` VALUES ('rQesGqY3', '中文201', '20181314101', '赵利明', '男', 4, 4, 4, 4, 4, 4);
INSERT INTO `student` VALUES ('SDkGwWZb', '中文202', '20201314218', '邢雨', '女', 4, 98, 85, 93, 10, 87);
INSERT INTO `student` VALUES ('SGXyxPBZ', '中文201', '20201314101', '屈明坤', '男', 4, 87, 81, 90, 10, 79);
INSERT INTO `student` VALUES ('sJRgNvvr', '中文203', '20201314324', '安若绮', '女', 4, 92, 90, 90, 10, 83);
INSERT INTO `student` VALUES ('T28J42Wn', '中文201', '20201314128', '滑梦格', '女', 4, 90, 85, 90, 10, 82);
INSERT INTO `student` VALUES ('T5TbGn1S', '中文203', '20201314321', '丁培燕', '女', 4, 100, 95, 90, 10, 89);
INSERT INTO `student` VALUES ('tFj7zXms', '中文203', '20201314328', '刘颍', '女', 4, 65, 85, 90, 10, 67);
INSERT INTO `student` VALUES ('tPO0gacr', '中文201', '20201314112', '董裕', '女', 4, 83, 85, 90, 10, 77);
INSERT INTO `student` VALUES ('TSrOxp7E', '中文202', '20201314212', '姬雅璇', '女', 4, 70, 85, 90, 10, 70);
INSERT INTO `student` VALUES ('TZpHeJHe', '中文202', '20201314204', '李相龙', '男', 4, 93, 85, 90, 10, 83);
INSERT INTO `student` VALUES ('UAHjKUQP', '中文203', '20201314329', '时奕霖', '女', 4, 70, 85, 93, 13, 70);
INSERT INTO `student` VALUES ('uBvZ8R0Y', '中文201', '20201314109', '王惠', '女', 4, 79, 85, 92, 10, 75);
INSERT INTO `student` VALUES ('uCMwBOQl', '中文203', '20201314315', '孙鋺鎡', '女', 4, 71, 85, 90, 10, 70);
INSERT INTO `student` VALUES ('uh5whSi5', '中文201', '20201314117', '丁洁', '女', 4, 77, 85, 74, 10, 71);
INSERT INTO `student` VALUES ('UOPMr1CC', '中文203', '20201314308', '叶小瑞', '女', 4, 82, 85, 90, 10, 77);
INSERT INTO `student` VALUES ('Vb559rdx', '中文202', '20201314229', '王亚浦', '女', 4, 96, 85, 90, 10, 85);
INSERT INTO `student` VALUES ('VM7l5vFW', '中文201', '20201314113', '任薪源', '女', 4, 91, 85, 94, 10, 83);
INSERT INTO `student` VALUES ('vt4DJ5ck', '中文201', '20201314129', '张亚鑫', '女', 4, 77, 85, 85, 10, 73);
INSERT INTO `student` VALUES ('vXD4vOfs', '中文201', '20201314115', '李小蝶', '女', 4, 74, 85, 90, 10, 72);
INSERT INTO `student` VALUES ('w3BES3XM', '中文202', '20201314206', '李响', '女', 4, 84, 85, 90, 12, 78);
INSERT INTO `student` VALUES ('WFqsIWNe', '中文203', '20201314327', '李青颂', '女', 4, 64, 80, 90, 10, 65);
INSERT INTO `student` VALUES ('WWBmEXWT', '中文203', '20201314325', '赵安然', '女', 4, 90, 85, 86, 12, 81);
INSERT INTO `student` VALUES ('xaOUlaw5', '中文203', '20201314302', '郑棕豪', '男', 4, 78, 85, 90, 10, 74);
INSERT INTO `student` VALUES ('XJ1Tu8aS', '中文201', '20201314118', '刘子硕', '女', 4, 70, 85, 90, 10, 70);
INSERT INTO `student` VALUES ('xVnrcGbb', '中文203', '20201314312', '李育颖', '女', 4, 89, 85, 87, 10, 80);
INSERT INTO `student` VALUES ('Y3wnfINk', '中文203', '20201314314', '黄颖轩', '女', 4, 100, 90, 88, 10, 88);
INSERT INTO `student` VALUES ('Ys5FnL0B', '中文203', '20201314305', '叶倩', '女', 4, 81, 85, 90, 10, 76);
INSERT INTO `student` VALUES ('zSyBAe92', '中文203', '20201314313', '马文慧', '女', 4, 100, 90, 90, 12, 88);

-- ----------------------------
-- Table structure for usual_grade
-- ----------------------------
DROP TABLE IF EXISTS `usual_grade`;
CREATE TABLE `usual_grade`  (
  `id` char(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'id',
  `course_target_id` char(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '课程目标id',
  `course_target_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '课程目标名称',
  `weight` decimal(50, 2) NULL DEFAULT NULL COMMENT '权重',
  `goal_grade` decimal(50, 2) NULL DEFAULT NULL COMMENT '目标分值',
  `actual_avg_grade` decimal(50, 2) NULL DEFAULT NULL COMMENT '实际平均分',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '平时作业' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of usual_grade
-- ----------------------------
INSERT INTO `usual_grade` VALUES ('mQQaz65O', '0000000', '课程目标1', 0.33, 20.00, 16.68);

SET FOREIGN_KEY_CHECKS = 1;
