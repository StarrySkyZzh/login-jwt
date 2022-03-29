/*
SQLyog Trial v13.1.8 (64 bit)
MySQL - 8.0.27 : Database - jwt
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`jwt` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `jwt`;

/*Table structure for table `score` */

DROP TABLE IF EXISTS `score`;

CREATE TABLE `score` (
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `course` varchar(20) DEFAULT NULL,
  `time` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `number` varchar(20) DEFAULT NULL,
  `subject` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `score` */

insert  into `score`(`name`,`course`,`time`,`number`,`subject`) values 
('lord stark77','40','2022-03-04 :07:02:15','202031722101','数学分析'),
('lord stark77','20','2022-03-04 :07:07:42','202031722101','数学分析'),
('lord stark77','20','2022-03-04 :08:45:07','202031722101','数学分析'),
('lord stark77','30','2022-03-04 :08:46:42','202031722101','数学分析'),
('lord stark77','0','2022-03-04 :08:49:57','202031722101','数学分析'),
('lord stark77','30','2022-03-06 :03:59:01','202031722101','数学分析'),
('lord stark77','0','2022-03-06 :04:04:13','202031722101','数学分析');

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `sex` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `id` varchar(20) DEFAULT NULL,
  `lessons` varchar(100) DEFAULT NULL,
  `college` varchar(20) DEFAULT NULL,
  `iid` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`iid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `student` */

insert  into `student`(`name`,`sex`,`phone`,`id`,`lessons`,`college`,`iid`) values 
('kkkkyrie123','男','158','2020310220','计算机操作系统,数据库,数学分析','理学院','101'),
('csy','123123','1','111','1','1','102');

/*Table structure for table `teacher` */

DROP TABLE IF EXISTS `teacher`;

CREATE TABLE `teacher` (
  `name` varchar(20) DEFAULT NULL,
  `id` varchar(20) DEFAULT NULL,
  `iid` varchar(20) NOT NULL,
  `sex` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `college` varchar(20) DEFAULT NULL,
  `lessons` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`iid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `teacher` */

insert  into `teacher`(`name`,`id`,`iid`,`sex`,`phone`,`college`,`lessons`) values 
('zzzzzz','2020310111111','101','男','1546','信息学院','计算机操作系统,数学分析,数据库');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` varchar(10) DEFAULT NULL,
  `name` varchar(20) NOT NULL,
  `password` varchar(20) DEFAULT NULL,
  `capacity` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`password`,`capacity`) values 
('2','ccy','123','学生'),
('1','zzh','123','老师');

/*Table structure for table `work` */

DROP TABLE IF EXISTS `work`;

CREATE TABLE `work` (
  `topic` varchar(20) DEFAULT NULL,
  `answer` varchar(20) DEFAULT NULL,
  `id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `score` varchar(20) DEFAULT NULL,
  `ans` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `work` */

insert  into `work`(`topic`,`answer`,`id`,`score`,`ans`) values 
('1+7 = ?','8','1','0',NULL),
('2*8 = ?','16','2','0',NULL),
('9%3 = ?','0','3','0',NULL),
('2+3 = ?','5','4','0',''),
('1+1 = ?','2','5','0','');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
