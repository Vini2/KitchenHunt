/*
SQLyog Job Agent Version 9.51 Copyright(c) Webyog Inc. All Rights Reserved.


MySQL - 5.7.7-rc-log : Database - kitchenhunttest6
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`kitchenhunttest6` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `kitchenhunttest6`;

/*Table structure for table `comment` */

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `idcomment` int(11) NOT NULL AUTO_INCREMENT,
  `comment_desc` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `time` time DEFAULT NULL,
  `recipe_idrecipe` int(11) NOT NULL,
  `user_iduser` int(11) NOT NULL,
  PRIMARY KEY (`idcomment`),
  KEY `fk_comment_recipe1_idx` (`recipe_idrecipe`),
  KEY `fk_comment_user1_idx` (`user_iduser`),
  CONSTRAINT `fk_comment_recipe1` FOREIGN KEY (`recipe_idrecipe`) REFERENCES `recipe` (`idrecipe`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_comment_user1` FOREIGN KEY (`user_iduser`) REFERENCES `user` (`iduser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `comment` */

/*Table structure for table `cuisine_category` */

DROP TABLE IF EXISTS `cuisine_category`;

CREATE TABLE `cuisine_category` (
  `idcuisine_category` int(11) NOT NULL AUTO_INCREMENT,
  `cuisine_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idcuisine_category`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `cuisine_category` */

insert  into `cuisine_category` values (1,'General'),(2,'French'),(3,'Italian'),(4,'Swiss');

/*Table structure for table `food_category` */

DROP TABLE IF EXISTS `food_category`;

CREATE TABLE `food_category` (
  `idfood_category` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idfood_category`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `food_category` */

insert  into `food_category` values (1,'Breakfast'),(2,'Lunch'),(3,'Dinner'),(4,'Dessert'),(5,'Beverages'),(6,'Snacks');

/*Table structure for table `health_category` */

DROP TABLE IF EXISTS `health_category`;

CREATE TABLE `health_category` (
  `idhealth_category` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idhealth_category`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `health_category` */

insert  into `health_category` values (1,'Healthy'),(2,'Low Sugar');

/*Table structure for table `image` */

DROP TABLE IF EXISTS `image`;

CREATE TABLE `image` (
  `idimage` int(11) NOT NULL AUTO_INCREMENT,
  `image_data` longblob,
  `path` varchar(255) DEFAULT NULL,
  `recipe_idrecipe` int(11) NOT NULL,
  PRIMARY KEY (`idimage`),
  KEY `fk_images_recipe1_idx` (`recipe_idrecipe`),
  CONSTRAINT `fk_images_recipe1` FOREIGN KEY (`recipe_idrecipe`) REFERENCES `recipe` (`idrecipe`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8;

/*Data for the table `image` */

/*Table structure for table `ingredient` */

DROP TABLE IF EXISTS `ingredient`;

CREATE TABLE `ingredient` (
  `idingredient` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idingredient`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

/*Data for the table `ingredient` */

insert  into `ingredient` values (1,'pineapple'),(2,'cherries'),(3,'banana'),(4,'mango'),(13,'strawberry ice cream'),(14,'strawberries'),(15,'milk'),(16,'vanilla'),(17,'coconut milk'),(18,'ice'),(19,'butter'),(20,'sugar'),(21,'honey'),(22,'cornflakes'),(23,'mini pitta bread'),(24,'salmon'),(25,'creme fraiche'),(26,'dill');

/*Table structure for table `login_session` */

DROP TABLE IF EXISTS `login_session`;

CREATE TABLE `login_session` (
  `idlogin_session` int(11) NOT NULL AUTO_INCREMENT,
  `in_time` timestamp NULL DEFAULT NULL,
  `out_time` timestamp NULL DEFAULT NULL,
  `ip_address` varchar(255) DEFAULT NULL,
  `user_login_iduser_login` int(11) NOT NULL,
  PRIMARY KEY (`idlogin_session`),
  KEY `fk_login_session_user_login1_idx` (`user_login_iduser_login`),
  CONSTRAINT `fk_login_session_user_login1` FOREIGN KEY (`user_login_iduser_login`) REFERENCES `user_login` (`iduser_login`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `login_session` */

/*Table structure for table `my_kitchen` */

DROP TABLE IF EXISTS `my_kitchen`;

CREATE TABLE `my_kitchen` (
  `idmy_kitchen` int(11) NOT NULL AUTO_INCREMENT,
  `user_iduser` int(11) NOT NULL,
  `recipe_idrecipe` int(11) NOT NULL,
  PRIMARY KEY (`idmy_kitchen`),
  KEY `fk_my_kitchen_user1_idx` (`user_iduser`),
  KEY `fk_my_kitchen_recipe1_idx` (`recipe_idrecipe`),
  CONSTRAINT `fk_my_kitchen_recipe1` FOREIGN KEY (`recipe_idrecipe`) REFERENCES `recipe` (`idrecipe`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_my_kitchen_user1` FOREIGN KEY (`user_iduser`) REFERENCES `user` (`iduser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `my_kitchen` */

/*Table structure for table `notification` */

DROP TABLE IF EXISTS `notification`;

CREATE TABLE `notification` (
  `idnotification` int(11) NOT NULL AUTO_INCREMENT,
  `notification` varchar(255) DEFAULT NULL,
  `notificationcol` datetime DEFAULT NULL,
  `user_iduser` int(11) NOT NULL,
  PRIMARY KEY (`idnotification`),
  KEY `fk_notification_user1_idx` (`user_iduser`),
  CONSTRAINT `fk_notification_user1` FOREIGN KEY (`user_iduser`) REFERENCES `user` (`iduser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `notification` */

/*Table structure for table `rating` */

DROP TABLE IF EXISTS `rating`;

CREATE TABLE `rating` (
  `idrating` int(11) NOT NULL AUTO_INCREMENT,
  `stars` double DEFAULT NULL,
  `recipe_idrecipe` int(11) NOT NULL,
  `user_iduser` int(11) NOT NULL,
  PRIMARY KEY (`idrating`),
  KEY `fk_rating_recipe1_idx` (`recipe_idrecipe`),
  KEY `fk_rating_user1_idx` (`user_iduser`),
  CONSTRAINT `fk_rating_recipe1` FOREIGN KEY (`recipe_idrecipe`) REFERENCES `recipe` (`idrecipe`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_rating_user1` FOREIGN KEY (`user_iduser`) REFERENCES `user` (`iduser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `rating` */

/*Table structure for table `recipe` */

DROP TABLE IF EXISTS `recipe`;

CREATE TABLE `recipe` (
  `idrecipe` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `directions` longtext,
  `serving_quantity` int(11) DEFAULT NULL,
  `notes` longtext,
  `skill_level` varchar(255) DEFAULT NULL,
  `preparing_time` varchar(255) DEFAULT NULL,
  `overall_rating` double DEFAULT NULL,
  `rated_count` int(11) DEFAULT NULL,
  `user_iduser` int(11) NOT NULL,
  `food_category_idfood_category` int(11) NOT NULL,
  `health_category_idhealth_category` int(11) NOT NULL,
  `cuisine_category_idcuisine_category` int(11) NOT NULL,
  PRIMARY KEY (`idrecipe`),
  KEY `fk_recipe_user1_idx` (`user_iduser`),
  KEY `fk_recipe_food_category1_idx` (`food_category_idfood_category`),
  KEY `fk_recipe_health_category1_idx` (`health_category_idhealth_category`),
  KEY `fk_recipe_cuisine_category1_idx` (`cuisine_category_idcuisine_category`),
  CONSTRAINT `fk_recipe_cuisine_category1` FOREIGN KEY (`cuisine_category_idcuisine_category`) REFERENCES `cuisine_category` (`idcuisine_category`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_recipe_food_category1` FOREIGN KEY (`food_category_idfood_category`) REFERENCES `food_category` (`idfood_category`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_recipe_health_category1` FOREIGN KEY (`health_category_idhealth_category`) REFERENCES `health_category` (`idhealth_category`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_recipe_user1` FOREIGN KEY (`user_iduser`) REFERENCES `user` (`iduser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `recipe` */

/*Table structure for table `recipe_has_ingredient` */

DROP TABLE IF EXISTS `recipe_has_ingredient`;

CREATE TABLE `recipe_has_ingredient` (
  `idrecipe_has_ingredient` int(11) NOT NULL AUTO_INCREMENT,
  `recipe_idrecipe` int(11) NOT NULL,
  `ingredient_idingredient` int(11) NOT NULL,
  `unit_idunit` int(11) NOT NULL,
  `quantity` double DEFAULT NULL,
  `main_ingredient` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idrecipe_has_ingredient`),
  KEY `fk_recipe_has_ingredient_ingredient1_idx` (`ingredient_idingredient`),
  KEY `fk_recipe_has_ingredient_recipe1_idx` (`recipe_idrecipe`),
  KEY `fk_recipe_has_ingredient_unit1_idx` (`unit_idunit`),
  CONSTRAINT `fk_recipe_has_ingredient_ingredient1` FOREIGN KEY (`ingredient_idingredient`) REFERENCES `ingredient` (`idingredient`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_recipe_has_ingredient_recipe1` FOREIGN KEY (`recipe_idrecipe`) REFERENCES `recipe` (`idrecipe`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_recipe_has_ingredient_unit1` FOREIGN KEY (`unit_idunit`) REFERENCES `unit` (`idunit`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

/*Data for the table `recipe_has_ingredient` */

/*Table structure for table `supermarket` */

DROP TABLE IF EXISTS `supermarket`;

CREATE TABLE `supermarket` (
  `idsupermarket` int(11) NOT NULL AUTO_INCREMENT,
  `supermarket_name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `telephone` varchar(13) DEFAULT NULL,
  PRIMARY KEY (`idsupermarket`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `supermarket` */

/*Table structure for table `supermarket_has_ingredient` */

DROP TABLE IF EXISTS `supermarket_has_ingredient`;

CREATE TABLE `supermarket_has_ingredient` (
  `idsupermarket_has_ingredientc` int(11) NOT NULL AUTO_INCREMENT,
  `supermarket_idsupermarket` int(11) NOT NULL,
  `ingredient_idingredient` int(11) NOT NULL,
  `quantity` varchar(45) DEFAULT NULL,
  `price` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idsupermarket_has_ingredientc`),
  KEY `fk_supermarket_has_ingredient_ingredient1_idx` (`ingredient_idingredient`),
  KEY `fk_supermarket_has_ingredient_supermarket1_idx` (`supermarket_idsupermarket`),
  CONSTRAINT `fk_supermarket_has_ingredient_ingredient1` FOREIGN KEY (`ingredient_idingredient`) REFERENCES `ingredient` (`idingredient`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_supermarket_has_ingredient_supermarket1` FOREIGN KEY (`supermarket_idsupermarket`) REFERENCES `supermarket` (`idsupermarket`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `supermarket_has_ingredient` */

/*Table structure for table `system_status` */

DROP TABLE IF EXISTS `system_status`;

CREATE TABLE `system_status` (
  `idsystem_status` int(11) NOT NULL AUTO_INCREMENT,
  `status_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idsystem_status`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `system_status` */

insert  into `system_status` values (1,'Pending'),(2,'Active'),(3,'Deactivated');

/*Table structure for table `unit` */

DROP TABLE IF EXISTS `unit`;

CREATE TABLE `unit` (
  `idunit` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idunit`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `unit` */

insert  into `unit` values (1,'none'),(2,'g'),(3,'tbls'),(4,'cup(s)'),(5,'l');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `iduser` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(255) DEFAULT NULL,
  `lname` varchar(255) DEFAULT NULL,
  `mobile` varchar(15) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `register_date` date DEFAULT NULL,
  `user_type_iduser_type` int(11) NOT NULL,
  PRIMARY KEY (`iduser`),
  KEY `fk_user_user_type_idx` (`user_type_iduser_type`),
  CONSTRAINT `fk_user_user_type` FOREIGN KEY (`user_type_iduser_type`) REFERENCES `user_type` (`iduser_type`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user` values (1,'Vijini Mallawaarachchi',NULL,'0719479919',NULL,'2016-05-12',2);

/*Table structure for table `user_login` */

DROP TABLE IF EXISTS `user_login`;

CREATE TABLE `user_login` (
  `iduser_login` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_iduser` int(11) NOT NULL,
  `system_status_idsystem_status` int(11) NOT NULL,
  PRIMARY KEY (`iduser_login`),
  KEY `fk_user_login_user1_idx` (`user_iduser`),
  KEY `fk_user_login_system_status1_idx` (`system_status_idsystem_status`),
  CONSTRAINT `fk_user_login_system_status1` FOREIGN KEY (`system_status_idsystem_status`) REFERENCES `system_status` (`idsystem_status`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_login_user1` FOREIGN KEY (`user_iduser`) REFERENCES `user` (`iduser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `user_login` */

insert  into `user_login` values (1,'viji.mallawaarachchi@gmail.com','dvKQSq2wsCM=',1,2);

/*Table structure for table `user_type` */

DROP TABLE IF EXISTS `user_type`;

CREATE TABLE `user_type` (
  `iduser_type` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`iduser_type`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `user_type` */

insert  into `user_type` values (1,'Admin'),(2,'User');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
