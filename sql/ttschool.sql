DROP DATABASE IF EXISTS `ttschool`;
CREATE DATABASE `ttschool`;
USE `ttschool`;
CREATE TABLE `subject` (
idSubject INT(11) NOT NULL AUTO_INCREMENT,
nameSubject VARCHAR(50) NOT NULL,
PRIMARY KEY (idSubject),
KEY name (nameSubject)) ENGINE=INNODB DEFAULT CHARSET=utf8;
CREATE TABLE school (
idSchool INT(11) NOT NULL AUTO_INCREMENT,
nameSchool VARCHAR(50) NOT NULL,
year INT(11),
PRIMARY KEY (idSchool),
KEY name (nameSchool),
KEY year (year),
UNIQUE KEY school (nameSchool, year)) ENGINE=INNODB DEFAULT CHARSET=utf8;
CREATE TABLE `group` (
idGroup INT(11) NOT NULL AUTO_INCREMENT,
nameGroup VARCHAR(50) NOT NULL,
room VARCHAR(50) NOT NULL,
schoolid INT(11) NOT NULL,
PRIMARY KEY (idGroup),
KEY name (nameGroup),
KEY room (room),
FOREIGN KEY (schoolid) REFERENCES school (idSchool) ON DELETE CASCADE) ENGINE=INNODB DEFAULT CHARSET=utf8;
CREATE TABLE trainee (
idTrainee INT(11) NOT NULL AUTO_INCREMENT,
firstName VARCHAR(50) NOT NULL,
lastName VARCHAR(50) NOT NULL,
rating INT(11),
groupid INT(11) DEFAULT NULL,
PRIMARY KEY (idTrainee),
KEY firstname (firstname),
KEY lastname (lastname),
KEY rating (rating),
FOREIGN KEY (groupid) REFERENCES `group` (idGroup) ON DELETE SET NULL) ENGINE=INNODB DEFAULT CHARSET=utf8;
CREATE TABLE subject_group (
id INT(11) NOT NULL AUTO_INCREMENT,
subjectid INT(11) NOT NULL,
groupid INT(11) DEFAULT NULL,
PRIMARY KEY (id),
UNIQUE KEY subject_group (subjectid, groupid),
FOREIGN KEY (subjectid) REFERENCES `subject` (idSubject) ON DELETE CASCADE,
FOREIGN KEY (groupid) REFERENCES `group` (idGroup) ON DELETE CASCADE) ENGINE=INNODB DEFAULT CHARSET=utf8; 