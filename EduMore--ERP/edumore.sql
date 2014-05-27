/*
SQLyog Community v11.5 (64 bit)
MySQL - 5.5.30 : Database - edumore
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`edumore` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `edumore`;

/*Table structure for table `address_details` */

DROP TABLE IF EXISTS `address_details`;

CREATE TABLE `address_details` (
  `address_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `house_number` varchar(30) DEFAULT NULL,
  `building_name` varchar(30) DEFAULT NULL,
  `street` varchar(60) DEFAULT NULL,
  `area` varchar(90) DEFAULT NULL,
  `city` varchar(30) DEFAULT NULL,
  `state` varchar(30) DEFAULT NULL,
  `country` varchar(30) DEFAULT 'India',
  `pincode` varchar(20) DEFAULT NULL,
  `enquiry_number` bigint(20) unsigned NOT NULL,
  `address_type` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`address_id`),
  KEY `enquiry_id` (`enquiry_number`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=latin1;

/*Data for the table `address_details` */

insert  into `address_details`(`address_id`,`house_number`,`building_name`,`street`,`area`,`city`,`state`,`country`,`pincode`,`enquiry_number`,`address_type`) values (1,'',NULL,NULL,NULL,'','','India','',1399302439019,'current'),(2,'',NULL,NULL,NULL,'','','India','',1399302439019,'permanent'),(3,'',NULL,NULL,NULL,'','','India','',1399302463206,'current'),(4,'',NULL,NULL,NULL,'','','India','',1399302463206,'permanent'),(5,'',NULL,NULL,NULL,'','','India','',1399302495506,'current'),(6,'',NULL,NULL,NULL,'','','India','',1399302495506,'permanent'),(7,'',NULL,NULL,NULL,'','','India','',1399302517494,'current'),(8,'',NULL,NULL,NULL,'','','India','',1399302517494,'permanent'),(9,'',NULL,NULL,NULL,'','','India','',1399302589246,'current'),(10,'',NULL,NULL,NULL,'','','India','',1399302589246,'permanent'),(11,'',NULL,NULL,NULL,'','','India','',1399302638746,'current'),(12,'',NULL,NULL,NULL,'','','India','',1399302638746,'permanent'),(13,'',NULL,NULL,NULL,'','','India','',1399302668114,'current'),(14,'',NULL,NULL,NULL,'','','India','',1399302668114,'permanent'),(15,'',NULL,NULL,NULL,'','','India','',1399302715507,'current'),(16,'',NULL,NULL,NULL,'','','India','',1399302715507,'permanent'),(17,'',NULL,NULL,NULL,'','','India','',1399302743132,'current'),(18,'',NULL,NULL,NULL,'','','India','',1399302743132,'permanent'),(19,'',NULL,NULL,NULL,'','','India','',1399302753562,'current'),(20,'',NULL,NULL,NULL,'','','India','',1399302753562,'permanent'),(21,'',NULL,NULL,NULL,'','','India','',1399302839522,'current'),(22,'',NULL,NULL,NULL,'','','India','',1399302839522,'permanent'),(23,'',NULL,NULL,NULL,'','','India','',1399302880136,'current'),(24,'',NULL,NULL,NULL,'','','India','',1399302880136,'permanent'),(25,'',NULL,NULL,NULL,'','','India','',1399302894261,'current'),(26,'',NULL,NULL,NULL,'','','India','',1399302894261,'permanent'),(27,'jh',NULL,NULL,NULL,'kj','hk','India','jh',1399342244768,'current'),(28,'kj',NULL,NULL,NULL,'kj','hk','India','jh',1399342244768,'permanent'),(29,'',NULL,NULL,NULL,'','','India','',1399342323719,'current'),(30,'',NULL,NULL,NULL,'','','India','',1399342323719,'permanent'),(31,'',NULL,NULL,NULL,'','','India','',1399342441182,'current'),(32,'',NULL,NULL,NULL,'','','India','',1399342441182,'permanent'),(33,'jhg',NULL,NULL,NULL,'hjg','jhj','India','hg',1399342483749,'current'),(34,'hj',NULL,NULL,NULL,'g','g','India','hg',1399342483749,'permanent'),(35,'',NULL,NULL,NULL,'','','India','',1400597715049,'current'),(36,'',NULL,NULL,NULL,'','','India','',1400597715049,'permanent');

/*Table structure for table `admin_login_details` */

DROP TABLE IF EXISTS `admin_login_details`;

CREATE TABLE `admin_login_details` (
  `admin_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `admin_username` varchar(20) DEFAULT NULL,
  `admin_password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `admin_login_details` */

insert  into `admin_login_details`(`admin_id`,`admin_username`,`admin_password`) values (1,'admin','admin');

/*Table structure for table `counsellor_login_details` */

DROP TABLE IF EXISTS `counsellor_login_details`;

CREATE TABLE `counsellor_login_details` (
  `counsellor_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `counsellor_username` varchar(20) DEFAULT NULL,
  `counsellor_password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`counsellor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `counsellor_login_details` */

insert  into `counsellor_login_details`(`counsellor_id`,`counsellor_username`,`counsellor_password`) values (1,'counsellor1','counsellor1');

/*Table structure for table `course_details` */

DROP TABLE IF EXISTS `course_details`;

CREATE TABLE `course_details` (
  `course_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `course_name` varchar(60) DEFAULT NULL,
  `course_duration` int(10) unsigned DEFAULT NULL,
  `admin_id` bigint(20) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`course_id`),
  KEY `FK_course_details` (`admin_id`),
  CONSTRAINT `FK_course_details` FOREIGN KEY (`admin_id`) REFERENCES `admin_login_details` (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `course_details` */

insert  into `course_details`(`course_id`,`course_name`,`course_duration`,`admin_id`) values (3,'JAVA',NULL,1),(4,'Fast Track JAVA',NULL,1),(5,'Asp.Net',NULL,1);

/*Table structure for table `enquiry_details` */

DROP TABLE IF EXISTS `enquiry_details`;

CREATE TABLE `enquiry_details` (
  `enquiry_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) NOT NULL,
  `middle_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `residence_number` varchar(20) DEFAULT NULL,
  `mobile_number` varchar(20) DEFAULT NULL,
  `email_id` varchar(50) DEFAULT NULL,
  `date_of_birth` varchar(50) DEFAULT NULL,
  `gender` varchar(6) DEFAULT NULL,
  `father_first_name` varchar(25) DEFAULT NULL,
  `father_middle_name` varchar(50) DEFAULT NULL,
  `father_last_name` varchar(50) DEFAULT NULL,
  `father_mobile_number` varchar(20) DEFAULT NULL,
  `father_residence_number` varchar(20) DEFAULT NULL,
  `current_address` bigint(20) unsigned zerofill DEFAULT NULL,
  `permanent_address` bigint(20) unsigned zerofill DEFAULT NULL,
  `counsellor_id` bigint(20) unsigned NOT NULL,
  `enquiry_number` bigint(20) unsigned NOT NULL,
  `enquiry_status` varchar(20) DEFAULT 'open',
  `admission_status` varchar(20) NOT NULL DEFAULT 'hold',
  PRIMARY KEY (`enquiry_id`),
  KEY `FK_enquiry_details` (`counsellor_id`),
  KEY `enquiry_details_ibfk_2` (`current_address`),
  KEY `enquiry_id` (`enquiry_id`),
  CONSTRAINT `enquiry_details_ibfk_1` FOREIGN KEY (`counsellor_id`) REFERENCES `counsellor_login_details` (`counsellor_id`),
  CONSTRAINT `enquiry_details_ibfk_2` FOREIGN KEY (`current_address`) REFERENCES `address_details` (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `enquiry_details` */

insert  into `enquiry_details`(`enquiry_id`,`first_name`,`middle_name`,`last_name`,`residence_number`,`mobile_number`,`email_id`,`date_of_birth`,`gender`,`father_first_name`,`father_middle_name`,`father_last_name`,`father_mobile_number`,`father_residence_number`,`current_address`,`permanent_address`,`counsellor_id`,`enquiry_number`,`enquiry_status`,`admission_status`) values (1,'Sachit Kesri',NULL,NULL,'9971840843',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,00000000000000000000,1,0,'close','notinterested'),(2,'ssss','','','','',NULL,'','','','','null','null','null',00000000000000000031,00000000000000000032,1,1399342441182,'open','hold'),(3,'asd','hgj','gjh','gjh','gjh',NULL,'g','jh','g','jhg','jh','g','ghj',00000000000000000033,00000000000000000034,1,1399342483749,'open','hold'),(4,'','','','','',NULL,'','','','','','','',00000000000000000035,00000000000000000036,1,1400597715049,'open','hold');

/*Table structure for table `followup_details` */

DROP TABLE IF EXISTS `followup_details`;

CREATE TABLE `followup_details` (
  `followup_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `remarks` varchar(100) DEFAULT NULL,
  `enquiry_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`followup_id`),
  KEY `enquiry_id` (`enquiry_id`),
  CONSTRAINT `followup_details_ibfk_1` FOREIGN KEY (`enquiry_id`) REFERENCES `enquiry_details` (`enquiry_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Data for the table `followup_details` */

insert  into `followup_details`(`followup_id`,`date`,`remarks`,`enquiry_id`) values (1,'2013-12-09','test remark',1),(2,'2013-12-09','sda',1),(3,'2013-12-06','Close this',1),(4,'2013-12-06','Close this 234',1),(5,'2013-12-06','Close this 23478',1),(6,'2013-12-06','Close this enquiry',1),(7,'2013-12-06','Close this enquiry again',1),(8,'2013-12-06','Close this enquiry yyy',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
