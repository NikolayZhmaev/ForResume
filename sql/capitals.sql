DROP DATABASE IF EXISTS `cities`;
CREATE DATABASE `cities`; 
USE `cities`;
CREATE TABLE `cities`.`capitals` (
  `idcapitals` INT NOT NULL AUTO_INCREMENT,
  `capitals_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idcapitals`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;

insert into `capitals` (`capitals_name`) 
values
 ('moskow'),
 ('oslo'),
 ('prague'),
 ('paris'),
 ('tbilisi'),
 ('rome'),
 ('tokyo'),
 ('london');
 
 select * from `capitals`;



