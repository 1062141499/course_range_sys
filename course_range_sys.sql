CREATE DATABASE IF NOT EXISTS `course_range_sys` default charset utf8 COLLATE utf8_general_ci;

USE `course_range_sys`;
drop TABLE if EXISTS `admin_info`;
CREATE TABLE IF NOT EXISTS `admin_info` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `name` varchar(255) DEFAULT NULL COMMENT '登录名',
 `pass_word` varchar(255) DEFAULT NULL COMMENT '登录密码',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='管理员';


drop TABLE if EXISTS `teacher_info`;
CREATE TABLE IF NOT EXISTS `teacher_info` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `tno` varchar(255) DEFAULT NULL COMMENT '工号',
 `pass_word` varchar(255) DEFAULT NULL COMMENT '登录密码',
 `real_name` varchar(255) DEFAULT NULL COMMENT '姓名',
 `sex` int(11) DEFAULT NULL COMMENT '性别',
 `cel_phone` varchar(255) DEFAULT NULL COMMENT '联系电话',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='教师';

drop TABLE if EXISTS `student_info`;
CREATE TABLE IF NOT EXISTS `student_info` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `stu_no` varchar(255) DEFAULT NULL COMMENT '学号',
 `password` varchar(255) DEFAULT NULL COMMENT '密码',
 `sex` int(11) DEFAULT NULL COMMENT '性别',
 `real_name` varchar(255) DEFAULT NULL COMMENT '姓名',
 `major_id` int(11) DEFAULT NULL COMMENT '所属学科',
 `direct_id` int(11) DEFAULT NULL COMMENT '方向',
 `class_id` int(11) DEFAULT NULL COMMENT '班级',
 `cel_phone` varchar(255) DEFAULT NULL COMMENT '联系电话',
 `enter_year` int(11) DEFAULT NULL COMMENT '入学年份',
 `term_id` int(11) DEFAULT NULL COMMENT '学期id',
 `family_address` varchar(255) DEFAULT NULL COMMENT '家庭住址',
 `parent_cel` varchar(255) DEFAULT NULL COMMENT '家长联系方式',
 `create_time` varchar(30) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='学生';


drop TABLE if EXISTS `major_info`;
CREATE TABLE IF NOT EXISTS `major_info` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `major_name` varchar(255) DEFAULT NULL COMMENT '专业名',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='专业';


drop TABLE if EXISTS `major_direct_info`;
CREATE TABLE IF NOT EXISTS `major_direct_info` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `direct_name` varchar(255) DEFAULT NULL COMMENT '方向名',
 `major_id` int(11) DEFAULT NULL COMMENT '所属专业',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='专业方向';


drop TABLE if EXISTS `class_info`;
CREATE TABLE IF NOT EXISTS `class_info` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `class_name` varchar(255) DEFAULT NULL COMMENT '班级名',
 `major_id` int(11) DEFAULT NULL COMMENT '所属专业',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='班级';


drop TABLE if EXISTS `term_info`;
CREATE TABLE IF NOT EXISTS `term_info` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `term_name` varchar(255) DEFAULT NULL COMMENT '学期名',
 `term_intro` varchar(255) DEFAULT NULL COMMENT '学期说明',
 `end_time` varchar(30) DEFAULT NULL COMMENT '学期排课截止时间',
 `week_num` int(11) DEFAULT NULL COMMENT '周数',
 `enter_year` int(11) DEFAULT NULL COMMENT '入学年份',
 `is_setting` int(11) DEFAULT NULL COMMENT '是否可修改空闲时间',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='学期';


drop TABLE if EXISTS `room_info`;
CREATE TABLE IF NOT EXISTS `room_info` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `room_name` varchar(255) DEFAULT NULL COMMENT '教室名',
 `max_num` int(11) DEFAULT NULL COMMENT '可容纳人数',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='教室';


drop TABLE if EXISTS `course_info`;
CREATE TABLE IF NOT EXISTS `course_info` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `course_name` varchar(255) DEFAULT NULL COMMENT '课程名',
 `major_id` int(11) DEFAULT NULL COMMENT '专业',
 `direct_id` int(11) DEFAULT NULL COMMENT '专业方向',
 `term_id` int(11) DEFAULT NULL COMMENT '学期',
 `room_ids` varchar(255) DEFAULT NULL COMMENT '可上课教室',
 `course_times` int(11) DEFAULT NULL COMMENT '上课次数',
  `is_bx` int(11) DEFAULT NULL COMMENT '课程类型',
 `teacher_id` int(11) DEFAULT NULL COMMENT '负责教师',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='课程';


drop TABLE if EXISTS `teacher_time_info`;
CREATE TABLE IF NOT EXISTS `teacher_time_info` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `week_day` int(11) DEFAULT NULL COMMENT '星期几',
 `js` int(11) DEFAULT NULL COMMENT '第几节',
 `teacher_id` int(11) DEFAULT NULL COMMENT '教师id',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='教师空闲时间设置';


drop TABLE if EXISTS `student_time_info`;
CREATE TABLE IF NOT EXISTS `student_time_info` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `week_day` int(11) DEFAULT NULL COMMENT '星期几',
 `js` int(11) DEFAULT NULL COMMENT '第几节',
 `stu_id` int(11) DEFAULT NULL COMMENT '学生id',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='学生空闲时间设置';


drop TABLE if EXISTS `course_range_info`;
CREATE TABLE IF NOT EXISTS `course_range_info` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `teacher_id` int(11) DEFAULT NULL COMMENT '教师id',
 `course_id` int(11) DEFAULT NULL COMMENT '课程id',
 `course_name` varchar(255) DEFAULT NULL COMMENT '课程名',
 `major_id` int(11) DEFAULT NULL COMMENT '专业',
 `direct_id` int(11) DEFAULT NULL COMMENT '方向',
 `room_id` int(11) DEFAULT NULL COMMENT '教室',
 `week_no` int(11) DEFAULT NULL COMMENT '第几周',
 `week_day` int(11) DEFAULT NULL COMMENT '星期几',
 `js` int(11) DEFAULT NULL COMMENT '第几节',
 `term_id` int(11) DEFAULT NULL COMMENT '学期',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='课程表';


drop TABLE if EXISTS `stu_range_info`;
CREATE TABLE IF NOT EXISTS `stu_range_info` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `range_id` int(11) DEFAULT NULL COMMENT '安排课程',
 `class_id` int(11) DEFAULT NULL COMMENT '班级',
 `course_id` int(11) DEFAULT NULL COMMENT '课程id',
 `stu_id` int(11) DEFAULT NULL COMMENT '学生id',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='课程学生安排';
 
 drop TABLE if EXISTS `course_apply`;
CREATE TABLE IF NOT EXISTS `course_apply` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `course_name` varchar(255) DEFAULT NULL COMMENT '课程名',
 `reason` varchar(1000) DEFAULT NULL COMMENT '调停原因',
 `apply_status` int(11) DEFAULT NULL COMMENT '申请状态',
 `check_remark` varchar(255) DEFAULT NULL COMMENT '管理员备注',
 `teacher_id` int(11) DEFAULT NULL COMMENT '申请教师',
 `create_time` varchar(30) DEFAULT NULL COMMENT '申请时间',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='调停课申请';
 
 
 drop TABLE if EXISTS `xk_log`;
CREATE TABLE IF NOT EXISTS `xk_log` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `course_id` int(11) DEFAULT NULL COMMENT '课程',
 `stu_id` int(11) DEFAULT NULL COMMENT '选课学生',
 `create_time` varchar(30) DEFAULT NULL COMMENT '选课时间',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='选课记录';



INSERT INTO `course_range_sys`.`admin_info` (`id`,`name`,`pass_word`)  VALUES('1','admin','123');
