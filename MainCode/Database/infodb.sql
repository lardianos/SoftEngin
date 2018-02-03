/*
Navicat MySQL Data Transfer

Source Server         : lardianos
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : infodb

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-02-01 19:37:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for Categories
-- ----------------------------
DROP TABLE IF EXISTS `Categories`;
CREATE TABLE `Categories` (
  `Category_ID` int(100) unsigned NOT NULL AUTO_INCREMENT,
  `Category` varchar(255) NOT NULL,
  PRIMARY KEY (`Category_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of Categories
-- ----------------------------
INSERT INTO `Categories` VALUES ('2', 'Monument');
INSERT INTO `Categories` VALUES ('3', 'Archeological Area');
INSERT INTO `Categories` VALUES ('4', 'Museum');
INSERT INTO `Categories` VALUES ('5', 'Cave');
INSERT INTO `Categories` VALUES ('6', 'Lake');
INSERT INTO `Categories` VALUES ('8', 'kati allo');
INSERT INTO `Categories` VALUES ('9', 'Beach');
INSERT INTO `Categories` VALUES ('10', 'Canyon');
INSERT INTO `Categories` VALUES ('37', 'Church');
INSERT INTO `Categories` VALUES ('38', 'abcd');
INSERT INTO `Categories` VALUES ('39', 'dddd');
INSERT INTO `Categories` VALUES ('42', 'castle');
INSERT INTO `Categories` VALUES ('51', 'New');

-- ----------------------------
-- Table structure for login
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of login
-- ----------------------------
INSERT INTO `login` VALUES ('admin', '1234');

-- ----------------------------
-- Table structure for Points
-- ----------------------------
DROP TABLE IF EXISTS `Points`;
CREATE TABLE `Points` (
  `Point_ID` int(100) NOT NULL AUTO_INCREMENT,
  `Point` varchar(255) NOT NULL,
  `Point_Description` varchar(1000) NOT NULL,
  `Popularity` int(100) NOT NULL,
  `Category_ID` int(100) unsigned NOT NULL,
  `Area` varchar(255) NOT NULL,
  PRIMARY KEY (`Point_ID`),
  KEY `Category_ID` (`Category_ID`),
  CONSTRAINT `Category_ID` FOREIGN KEY (`Category_ID`) REFERENCES `Categories` (`Category_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of Points
-- ----------------------------
INSERT INTO `Points` VALUES ('2', 'Arxea Falasarna', 'H arxaia Falassarna htan arxaia polh-kratos sth boreiodytikh Krhth. H Falassarna htan enas apo tous shmantikoterous limenes ths Krhths kai akmase kyriws sthn ellhnistikh periodo. H perioxh katoikh8hke apo th Mesominwikh mexri ta mesa tou 1ou ai. p.X.. Konta sthn arxaia polh brisketai organwmenh paralia, gnwsth ws Paxia Ammos.', '0', '3', 'Falasarna');
INSERT INTO `Points` VALUES ('5', 'Faraggi Tolpolion', 'To faraggi twn Topoliwn brisketai sthn endoxwra tou Kissamou, sto dytiko tmhma tou N. Xaniwn. KSekinaei apo to omwnymo xwrio kai meta apo peripou 1500 metra katalhgei se katafyth koilada dipla sto xwrio Koutsomatados. Gia th diasxish tou, h opoia den parousiazei idiaitero bathmo dyskolias, apaiteitai peripou mia wra. An kai mikro sxetika se mhkos, to faraggi einai epiblhtiko kai to topio agrio. Ta katakoryfa toixwmata tou ftanoun ta 300 metra se ypsos kai to platos sthn koith tou kymainetai apo 5 ews 50 metra.', '0', '10', 'Topolia');
INSERT INTO `Points` VALUES ('6', 'Mousio Kasteliou', 'To mouseio ksekinhse tis drasthriothtes tou to 2005 kai stegazetai sto enetotourkiko mnhmeio to opoio einai gnwsto ws «Dioikhthrio». Ta ekthemata tou parexoun mia diaxronikh eikona ths istorias ths perioxhs apo thn proistorikh epoxh mexri kai thn ysterh arxaiothta, dhladh tous palaioxristianikous xronous.', '0', '4', 'Kasteli');
INSERT INTO `Points` VALUES ('7', 'Paralia Kedrodasos', ' To Kedrodasos einai mia kataplhktikh paralia pou brisketai 76km notiodytika twn Xaniwn kai 1km dytika apo th diashmh limnothalassa sto Elafonhsi. H paralia einai gemath me dentra arkeuthou, pou moiazoun me kedrous, kai ammothines, pou thymizoun tis tropikes paralies tou Libanou. Oi mikroi kedroi anhkoun sta eidh Juniperus oxycedrus kai Juniperus phoenicea. An bretheite sthn paralia, tha prepei na thymaste oti ta dentra einai poly euthrausta kai einai apaitoun to sebasmo sas, gi\'auto frontiste na mhn ta plhsiazete.', '0', '9', 'Elafonisi');
INSERT INTO `Points` VALUES ('8', 'Limnothalasa Mpalos', 'H diashmh limnothalassa tou Mpalou brisketai peripou 56 xlm boreiodytika twn Xaniwn kai 17 xlm boreiodytika ths Kissamou. Einai mia rhxh ammouderh paralia pou sxhmatizetai anamesa sto Akrwthrio ths Grambousas kai to mikrotero akrwthrio Thgani, katw apo ton oreino ogko tou Platyskinou. O Mpalos apotelei sigoura thn pio polyfwtografhmenh paralia ths Krhths, ena poly agaphmeno thema olwn twn touristikwn odhgwn ths Elladas. Malista den einai tyxaio oti akomh kai o Karolos me thn Ntaiana eixan erthei edw me to idiwtiko tous giwt arketa xronia prin.', '0', '9', 'Mpalos');
INSERT INTO `Points` VALUES ('9', 'Paralia Falasarna', 'H mageutikh paralia ths Falasarnas brisketai 59 xlm dytika twn Xaniwn kai 17 xlm dytika ths Kissamou. Brisketai sto dytiko tmhma ths Xersonhsou ths Grambousas. Sto boreio terma ths paralias briskontai ereipia ths arxaias Rwmaikhs polhs ths Falasarnas.', '0', '9', 'Falasarna');
INSERT INTO `Points` VALUES ('19', 'arkalotripa', 'O saronitis einai enas potamos stin kissamo', '0', '5', 'saronitis');
INSERT INTO `Points` VALUES ('20', 'masta', 'limni kerkinis', '0', '6', 'abudabi');
