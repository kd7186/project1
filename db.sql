-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        10.5.8-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- test 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `test` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `test`;

-- 테이블 test.lc_answer 구조 내보내기
CREATE TABLE IF NOT EXISTS `lc_answer` (
  `a_idx` int(11) NOT NULL AUTO_INCREMENT,
  `q_idx` int(11) DEFAULT NULL,
  `a` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`a_idx`),
  KEY `q_idx` (`q_idx`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- 테이블 데이터 test.lc_answer:~9 rows (대략적) 내보내기
/*!40000 ALTER TABLE `lc_answer` DISABLE KEYS */;
INSERT INTO `lc_answer` (`a_idx`, `q_idx`, `a`) VALUES
	(1, 4, '다리우스'),
	(2, 4, '가렌'),
	(3, 4, '이렐리아'),
	(4, 5, '리 신'),
	(5, 5, '니달리'),
	(6, 5, '엘리스'),
	(7, 6, '빅토르'),
	(8, 6, '아리'),
	(9, 6, '카타리나'),
	(10, 9, '부대찌개'),
	(11, 9, '닭갈비'),
	(12, 10, '초밥'),
	(13, 10, '돈가스');
/*!40000 ALTER TABLE `lc_answer` ENABLE KEYS */;

-- 테이블 test.lc_auth 구조 내보내기
CREATE TABLE IF NOT EXISTS `lc_auth` (
  `u_id` varchar(50) DEFAULT NULL,
  `u_auth` varchar(50) DEFAULT NULL,
  KEY `FK_lc_auth_lc_user` (`u_id`),
  CONSTRAINT `FK_lc_auth_lc_user` FOREIGN KEY (`u_id`) REFERENCES `lc_user` (`u_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 test.lc_auth:~7 rows (대략적) 내보내기
/*!40000 ALTER TABLE `lc_auth` DISABLE KEYS */;
INSERT INTO `lc_auth` (`u_id`, `u_auth`) VALUES
	('tontonjeong', 'ROLE_USER'),
	('saram', 'ROLE_USER'),
	('leesin', 'ROLE_USER'),
	('graves', 'ROLE_USER'),
	('darius', 'ROLE_USER'),
	('admin', 'ROLE_USER'),
	('admin', 'ROLE_ADMIN');
/*!40000 ALTER TABLE `lc_auth` ENABLE KEYS */;

-- 테이블 test.lc_board 구조 내보내기
CREATE TABLE IF NOT EXISTS `lc_board` (
  `b_id` int(11) NOT NULL AUTO_INCREMENT,
  `b_title` varchar(50) DEFAULT NULL,
  `b_content` text DEFAULT NULL,
  `b_writer` varchar(50) DEFAULT NULL,
  `b_datetime` datetime DEFAULT current_timestamp(),
  `b_brdhit` int(11) DEFAULT NULL,
  `b_group` int(11) DEFAULT NULL,
  `b_order` int(11) DEFAULT NULL,
  `b_depth` int(11) DEFAULT NULL,
  PRIMARY KEY (`b_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- 테이블 데이터 test.lc_board:~6 rows (대략적) 내보내기
/*!40000 ALTER TABLE `lc_board` DISABLE KEYS */;
INSERT INTO `lc_board` (`b_id`, `b_title`, `b_content`, `b_writer`, `b_datetime`, `b_brdhit`, `b_group`, `b_order`, `b_depth`) VALUES
	(1, 'asdf', 'wwwwwwwww', 'admin', '2022-05-09 09:38:45', 8, 1, 1, 0),
	(2, 'qqqq', 'sdqwewqrewqe', 'saram', '2022-05-11 09:57:52', 18, 2, 1, 0),
	(3, 'asdasdssaf', 'ggywqtsacfdfd', 'admin', '2022-05-24 09:59:34', 3, 3, 1, 0),
	(4, 'qfdfafewrewtqewtqwerwer', 'wqeqweeqwr', 'admin', '2022-05-24 10:12:17', 1, 4, 1, 0),
	(5, 'qfdfafewrewtqewtqwerwer', 'wqeqweeqwr', 'admin', '2022-05-24 10:12:24', 2, 5, 1, 0),
	(6, NULL, NULL, 'admin', '2022-05-24 10:12:26', 1, 6, 1, 0),
	(7, NULL, NULL, 'admin', '2022-05-24 10:14:29', 1, 7, 1, 0);
/*!40000 ALTER TABLE `lc_board` ENABLE KEYS */;

-- 테이블 test.lc_comment 구조 내보내기
CREATE TABLE IF NOT EXISTS `lc_comment` (
  `c_num` int(11) NOT NULL AUTO_INCREMENT,
  `b_id` int(11) DEFAULT NULL,
  `c_content` varchar(255) DEFAULT NULL,
  `c_writer` varchar(50) DEFAULT NULL,
  `c_group` int(11) DEFAULT NULL,
  `c_order` int(11) DEFAULT NULL,
  `c_depth` int(11) DEFAULT NULL,
  PRIMARY KEY (`c_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 test.lc_comment:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `lc_comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `lc_comment` ENABLE KEYS */;

-- 테이블 test.lc_file 구조 내보내기
CREATE TABLE IF NOT EXISTS `lc_file` (
  `f_id` int(11) NOT NULL AUTO_INCREMENT,
  `b_id` int(11) DEFAULT NULL,
  `fileName` varchar(1000) DEFAULT NULL,
  `fileRealName` varchar(1000) DEFAULT NULL,
  `fileUrl` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`f_id`),
  KEY `b_id` (`b_id`),
  CONSTRAINT `FK_lc_file_lc_board` FOREIGN KEY (`b_id`) REFERENCES `lc_board` (`b_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 test.lc_file:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `lc_file` DISABLE KEYS */;
/*!40000 ALTER TABLE `lc_file` ENABLE KEYS */;

-- 테이블 test.lc_item 구조 내보내기
CREATE TABLE IF NOT EXISTS `lc_item` (
  `i_idx` int(11) NOT NULL AUTO_INCREMENT,
  `q_idx` int(11) DEFAULT NULL,
  `i_item` varchar(50) DEFAULT NULL,
  `s_idx` int(11) DEFAULT NULL,
  PRIMARY KEY (`i_idx`),
  KEY `q_idx` (`q_idx`),
  KEY `s_idx` (`s_idx`),
  CONSTRAINT `FK_lc_item_lc_question_2` FOREIGN KEY (`s_idx`) REFERENCES `lc_question` (`s_idx`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 test.lc_item:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `lc_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `lc_item` ENABLE KEYS */;

-- 테이블 test.lc_question 구조 내보내기
CREATE TABLE IF NOT EXISTS `lc_question` (
  `q_idx` int(11) NOT NULL AUTO_INCREMENT,
  `s_idx` int(11) NOT NULL,
  `q` mediumtext DEFAULT NULL,
  `t` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`q_idx`),
  KEY `s_idx` (`s_idx`),
  CONSTRAINT `FK_lc_question_lc_survey` FOREIGN KEY (`s_idx`) REFERENCES `lc_survey` (`s_idx`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- 테이블 데이터 test.lc_question:~5 rows (대략적) 내보내기
/*!40000 ALTER TABLE `lc_question` DISABLE KEYS */;
INSERT INTO `lc_question` (`q_idx`, `s_idx`, `q`, `t`) VALUES
	(4, 1, '탑', 'RadioQ'),
	(5, 1, '정글', 'CheckQ'),
	(6, 1, '미드', 'DropQ'),
	(7, 1, '원딜', 'ShortQ'),
	(8, 1, '서폿', 'LongQ'),
	(9, 2, '한식', 'RadioQ'),
	(10, 2, '일식', 'CheckQ');
/*!40000 ALTER TABLE `lc_question` ENABLE KEYS */;

-- 테이블 test.lc_survey 구조 내보내기
CREATE TABLE IF NOT EXISTS `lc_survey` (
  `s_idx` int(11) NOT NULL AUTO_INCREMENT,
  `s_title` varchar(50) DEFAULT NULL,
  `s_writer` varchar(50) DEFAULT NULL,
  `s_description` longtext DEFAULT NULL,
  `s_datetime` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`s_idx`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- 테이블 데이터 test.lc_survey:~1 rows (대략적) 내보내기
/*!40000 ALTER TABLE `lc_survey` DISABLE KEYS */;
INSERT INTO `lc_survey` (`s_idx`, `s_title`, `s_writer`, `s_description`, `s_datetime`) VALUES
	(1, '좋아하는 라인별 챔프', 'admin', '티모충 유미충 꺼져', '2022-05-31 10:11:39'),
	(2, '좋아하는 요리', 'admin', '기래요', '2022-06-03 10:21:22');
/*!40000 ALTER TABLE `lc_survey` ENABLE KEYS */;

-- 테이블 test.lc_user 구조 내보내기
CREATE TABLE IF NOT EXISTS `lc_user` (
  `u_id` varchar(50) NOT NULL,
  `u_password` varchar(200) DEFAULT NULL,
  `u_name` varchar(50) DEFAULT NULL,
  `u_phone` varchar(50) DEFAULT NULL,
  `u_datetime` datetime DEFAULT current_timestamp(),
  `u_isAccountNonExpired` tinyint(4) DEFAULT NULL,
  `u_isAccountNonLocked` tinyint(4) DEFAULT NULL,
  `u_isCredentialNonExpired` tinyint(4) DEFAULT NULL,
  `u_isEnabled` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 test.lc_user:~5 rows (대략적) 내보내기
/*!40000 ALTER TABLE `lc_user` DISABLE KEYS */;
INSERT INTO `lc_user` (`u_id`, `u_password`, `u_name`, `u_phone`, `u_datetime`, `u_isAccountNonExpired`, `u_isAccountNonLocked`, `u_isCredentialNonExpired`, `u_isEnabled`) VALUES
	('admin', '$2a$10$5uERQP9U555RPnVT/IfuJenzgDQqLnFS3iV.Cxmljjl6Rqyxjo.fC', 'admin', '01024653634', '2022-04-28 11:26:16', 1, 1, 1, 1),
	('darius', '$2a$10$4XpZIUqlnMzofdJlHFmtGuZ23jn7IYKDU4elNPIke.SpTkIbJXmlC', '다리우스', '01020204982', '2022-04-27 09:42:15', 1, 1, 1, 1),
	('graves', '$2a$10$fvhoSjl/Wif1cZpu4G9gbO13JZfCUfTLz0ZDPVMPJEwVeTV0myFHy', '그레이브즈', '01030203020', '2022-04-26 11:30:51', 1, 1, 1, 1),
	('leesin', '$2a$10$.lD6n0EeDDQ0sHONiuNaj.BHRSbZGNLpbN0oPAtSZZg2.RoiVNFf.', '리신', '01000000000', '2022-04-26 11:19:58', 1, 1, 1, 1),
	('saram', '$2a$10$S.aEnRnt6zLbF2GPmazIB.OqM4SwV0k/kMjScE826343Z.Q/LveWi', '엄준식', '01044444444', '2022-02-15 09:19:38', 1, 1, 1, 1),
	('tontonjeong', '$2a$10$z.NRJaYaQ.jQZa8g/KiXbOaFHHXkfiGxkMKVe.Vt8MpGgI/Gf6OKG', '톤톤', '01012345678', '2022-02-14 10:07:45', 1, 1, 1, 1);
/*!40000 ALTER TABLE `lc_user` ENABLE KEYS */;

-- 테이블 test.spring_session 구조 내보내기
CREATE TABLE IF NOT EXISTS `spring_session` (
  `PRIMARY_ID` char(36) NOT NULL,
  `SESSION_ID` char(36) NOT NULL,
  `CREATION_TIME` bigint(20) NOT NULL,
  `LAST_ACCESS_TIME` bigint(20) NOT NULL,
  `MAX_INACTIVE_INTERVAL` int(11) NOT NULL,
  `EXPIRY_TIME` bigint(20) NOT NULL,
  `PRINCIPAL_NAME` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`PRIMARY_ID`),
  UNIQUE KEY `SPRING_SESSION_IX1` (`SESSION_ID`),
  KEY `SPRING_SESSION_IX2` (`EXPIRY_TIME`),
  KEY `SPRING_SESSION_IX3` (`PRINCIPAL_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- 테이블 데이터 test.spring_session:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `spring_session` DISABLE KEYS */;
/*!40000 ALTER TABLE `spring_session` ENABLE KEYS */;

-- 테이블 test.spring_session_attributes 구조 내보내기
CREATE TABLE IF NOT EXISTS `spring_session_attributes` (
  `SESSION_PRIMARY_ID` char(36) NOT NULL,
  `ATTRIBUTE_NAME` varchar(200) NOT NULL,
  `ATTRIBUTE_BYTES` blob NOT NULL,
  PRIMARY KEY (`SESSION_PRIMARY_ID`,`ATTRIBUTE_NAME`),
  CONSTRAINT `SPRING_SESSION_ATTRIBUTES_FK` FOREIGN KEY (`SESSION_PRIMARY_ID`) REFERENCES `spring_session` (`PRIMARY_ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- 테이블 데이터 test.spring_session_attributes:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `spring_session_attributes` DISABLE KEYS */;
/*!40000 ALTER TABLE `spring_session_attributes` ENABLE KEYS */;

-- 테이블 test.vue_reanswers 구조 내보내기
CREATE TABLE IF NOT EXISTS `vue_reanswers` (
  `s_idx` int(11) DEFAULT NULL,
  `q_idx` int(11) DEFAULT NULL,
  `r_idx` int(11) DEFAULT NULL,
  `a` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 test.vue_reanswers:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `vue_reanswers` DISABLE KEYS */;
/*!40000 ALTER TABLE `vue_reanswers` ENABLE KEYS */;

-- 테이블 test.vue_response 구조 내보내기
CREATE TABLE IF NOT EXISTS `vue_response` (
  `sub_idx` int(11) DEFAULT NULL,
  `q_idx` int(11) DEFAULT NULL,
  `r_idx` int(11) DEFAULT NULL,
  `t` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 test.vue_response:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `vue_response` DISABLE KEYS */;
/*!40000 ALTER TABLE `vue_response` ENABLE KEYS */;

-- 테이블 test.vue_submission 구조 내보내기
CREATE TABLE IF NOT EXISTS `vue_submission` (
  `s_idx` int(11) DEFAULT NULL,
  `sub_idx` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 test.vue_submission:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `vue_submission` DISABLE KEYS */;
/*!40000 ALTER TABLE `vue_submission` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
