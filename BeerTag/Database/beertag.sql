
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `beertag` DEFAULT CHARACTER SET utf8mb4 ;
USE `beertag` ;

CREATE TABLE IF NOT EXISTS `beertag`.`beer_origin_country` (
  `country_id` INT NOT NULL AUTO_INCREMENT,
  `country_code` VARCHAR(2) NOT NULL,
  `country_name` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`country_id`),
  UNIQUE INDEX `country_code_UNIQUE` (`country_code` ASC) ,
  UNIQUE INDEX `country_name_UNIQUE` (`country_name` ASC) )
ENGINE = InnoDB
AUTO_INCREMENT = 737
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `beertag`.`beer_styles` (
  `styles_id` INT NOT NULL AUTO_INCREMENT,
  `style_type` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`styles_id`),
  UNIQUE INDEX `style_type_UNIQUE` (`style_type` ASC) )
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `beertag`.`beer` (
  `beer_id` INT NOT NULL AUTO_INCREMENT,
  `picture_url` VARCHAR(300) NULL DEFAULT NULL,
  `name` VARCHAR(60) NOT NULL,
  `abv` FLOAT NOT NULL,
  `brewery` VARCHAR(60) NOT NULL,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  `beer_style_id` INT NOT NULL,
  `beer_origin_country_id` INT NOT NULL,
  PRIMARY KEY (`beer_id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) ,
  INDEX `fk_beer_beer_origin_country1` (`beer_origin_country_id` ASC) ,
  INDEX `fk_beer_beer_styles1` (`beer_style_id` ASC) ,
  CONSTRAINT `fk_beer_beer_origin_country1`
    FOREIGN KEY (`beer_origin_country_id`)
    REFERENCES `beertag`.`beer_origin_country` (`country_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_beer_beer_styles1`
    FOREIGN KEY (`beer_style_id`)
    REFERENCES `beertag`.`beer_styles` (`styles_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `beertag`.`login` (
  `login_id` INT NOT NULL AUTO_INCREMENT,
  `username_login` VARCHAR(60) NOT NULL,
  `password` VARCHAR(128) NOT NULL,
  PRIMARY KEY (`login_id`),
  UNIQUE INDEX `username_UNIQUE` (`username_login` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `beertag`.`user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(20) NOT NULL,
  `last_name` VARCHAR(20) NOT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `avatar_url` LONGTEXT NULL DEFAULT NULL,
  `user_login_id` INT NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `user_email_UNIQUE` (`email` ASC) ,
  INDEX `login_id_idx` (`user_login_id` ASC) ,
  CONSTRAINT `login_id`
    FOREIGN KEY (`user_login_id`)
    REFERENCES `beertag`.`login` (`login_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `beertag`.`beer_rating` (
  `rating_id` INT NOT NULL AUTO_INCREMENT,
  `rating` INT NOT NULL,
  `user_id_rating` INT NOT NULL,
  `beer_id_rating` INT NOT NULL,
  PRIMARY KEY (`rating_id`),
  INDEX `fk_beer_rating_user1` (`user_id_rating` ASC) ,
  INDEX `fk_beer_rating_beer1` (`beer_id_rating` ASC) ,
  CONSTRAINT `fk_beer_rating_beer1`
    FOREIGN KEY (`beer_id_rating`)
    REFERENCES `beertag`.`beer` (`beer_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_beer_rating_user1`
    FOREIGN KEY (`user_id_rating`)
    REFERENCES `beertag`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `beertag`.`tag` (
  `tag_id` INT NOT NULL AUTO_INCREMENT,
  `tag_content` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`tag_id`),
  UNIQUE INDEX `tag_content_UNIQUE` (`tag_content` ASC) )
ENGINE = InnoDB
AUTO_INCREMENT = 37
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `beertag`.`beer_tags_relationship` (
  `beer_id` INT NOT NULL,
  `tag_id` INT NOT NULL,
  `beer_tags_relationship_id` INT NOT NULL AUTO_INCREMENT,
  INDEX `fk_beer_tags_relationship_beer1` (`beer_id` ASC) ,
  INDEX `fk_beer_tags_relationship_tag1` (`tag_id` ASC) ,
  PRIMARY KEY (`beer_tags_relationship_id`),
  CONSTRAINT `fk_beer_tags_relationship_beer1`
    FOREIGN KEY (`beer_id`)
    REFERENCES `beertag`.`beer` (`beer_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_beer_tags_relationship_tag1`
    FOREIGN KEY (`tag_id`)
    REFERENCES `beertag`.`tag` (`tag_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


CREATE TABLE IF NOT EXISTS `beertag`.`status` (
  `status_id` INT NOT NULL AUTO_INCREMENT,
  `status_type` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`status_id`),
  UNIQUE INDEX `status_type_UNIQUE` (`status_type` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `beertag`.`beer_user_status_relationship` (
  `beer_id_status` INT NOT NULL,
  `user_id` INT NOT NULL,
  `beer_id` INT NOT NULL,
  `beer_user_status_relationship_id` INT NOT NULL AUTO_INCREMENT,
  INDEX `fk_beer_status_user` (`user_id` ASC) ,
  INDEX `fk_beer_status_beer1` (`beer_id` ASC) ,
  INDEX `fk_status_beer_user_idx` (`beer_id_status` ASC) ,
  PRIMARY KEY (`beer_user_status_relationship_id`),
  CONSTRAINT `fk_beer_status_beer1`
    FOREIGN KEY (`beer_id`)
    REFERENCES `beertag`.`beer` (`beer_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_beer_status_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `beertag`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_status_beer_user`
    FOREIGN KEY (`beer_id_status`)
    REFERENCES `beertag`.`status` (`status_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;
CREATE TABLE IF NOT EXISTS `beertag`.`user_roles` (
  `role_id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE INDEX `user_role_name_UNIQUE` (`type` ASC) )
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8mb4;
CREATE TABLE IF NOT EXISTS `beertag`.`login_userRoles` (
  `login_id` INT NOT NULL,
  `role_id` INT NOT NULL,
  `login_userRoles_id` INT NOT NULL AUTO_INCREMENT,
  INDEX `login_id_idx` (`login_id` ASC) ,
  INDEX `role_id_idx` (`role_id` ASC) ,
  PRIMARY KEY (`login_userRoles_id`),
  CONSTRAINT `fk_login_id`
    FOREIGN KEY (`login_id`)
    REFERENCES `beertag`.`login` (`login_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_role_id`
    FOREIGN KEY (`role_id`)
    REFERENCES `beertag`.`user_roles` (`role_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;