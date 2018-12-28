-- phpMyAdmin SQL Dump
-- version 4.0.4.2
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2018 年 12 月 28 日 01:23
-- 服务器版本: 5.6.13
-- PHP 版本: 5.4.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- 数据库: `mice`
--
CREATE DATABASE IF NOT EXISTS `mice` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `mice`;

-- --------------------------------------------------------

--
-- 表的结构 `category`
--

CREATE TABLE IF NOT EXISTS `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`,`name`),
  KEY `id_2` (`id`,`name`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=13 ;

--
-- 转存表中的数据 `category`
--

INSERT INTO `category` (`id`, `name`) VALUES
(9, '我是小明1'),
(10, '我是小明'),
(12, '超级内裤');

-- --------------------------------------------------------

--
-- 表的结构 `orderitem`
--

CREATE TABLE IF NOT EXISTS `orderitem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL,
  `oid` int(11) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_orderitem_user` (`uid`),
  KEY `fk_orderitem_product` (`pid`),
  KEY `id` (`id`,`pid`,`oid`,`uid`,`number`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=43 ;

--
-- 转存表中的数据 `orderitem`
--

INSERT INTO `orderitem` (`id`, `pid`, `oid`, `uid`, `number`) VALUES
(37, 23, 21, 3, 1),
(38, 23, 22, 3, 1),
(39, 22, 23, 3, 1),
(40, 23, -1, 3, 3),
(41, 21, -1, 3, 1),
(42, 23, 24, 20, 3);

-- --------------------------------------------------------

--
-- 表的结构 `order_`
--

CREATE TABLE IF NOT EXISTS `order_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderCode` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `post` varchar(255) DEFAULT NULL,
  `receiver` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `userMessage` varchar(255) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `payDate` datetime DEFAULT NULL,
  `deliveryDate` datetime DEFAULT NULL,
  `confirmDate` datetime DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_order_user` (`uid`),
  KEY `id` (`id`,`createDate`,`payDate`,`deliveryDate`,`confirmDate`,`uid`,`status`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=25 ;

--
-- 转存表中的数据 `order_`
--

INSERT INTO `order_` (`id`, `orderCode`, `address`, `post`, `receiver`, `mobile`, `userMessage`, `createDate`, `payDate`, `deliveryDate`, `confirmDate`, `uid`, `status`) VALUES
(21, '201812201237280451636', 'CUYAHOGA COMMUNITY COLLEGE 700 CARNEGIE AVENUE, CLEVELAND, OHIO 44115', '44115', 'CLINTON', '3012591475', NULL, '2018-12-20 12:37:28', '2018-12-20 12:37:29', '2018-12-20 12:37:50', '2018-12-20 12:37:58', 3, 'finish'),
(22, '201812201559562396900', 'CUYAHOGA COMMUNITY COLLEGE 700 CARNEGIE AVENUE, CLEVELAND, OHIO 44115', '44115', 'CLINTON', '3012591475', NULL, '2018-12-20 15:59:56', NULL, NULL, NULL, 3, 'waitPay'),
(23, '201812201609089558114', 'CUYAHOGA COMMUNITY COLLEGE 700 CARNEGIE AVENUE, CLEVELAND, OHIO 44115', '44115', 'CLINTON', '3012591475', NULL, '2018-12-20 16:09:09', '2018-12-20 16:09:11', NULL, NULL, 3, 'waitDelivery'),
(24, '201812201927055847413', 'CUYAHOGA COMMUNITY COLLEGE 700 CARNEGIE AVENUE, CLEVELAND, OHIO 44115', '44115', 'CLINTON', '3012591475', NULL, '2018-12-20 19:27:06', '2018-12-20 19:27:08', '2018-12-20 19:27:31', '2018-12-20 19:27:42', 20, 'waitReview');

-- --------------------------------------------------------

--
-- 表的结构 `product`
--

CREATE TABLE IF NOT EXISTS `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `subTitle` varchar(255) DEFAULT NULL,
  `promotePrice` float DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `editor` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci,
  PRIMARY KEY (`id`),
  KEY `fk_product_category` (`cid`),
  KEY `id` (`id`,`name`,`subTitle`,`promotePrice`,`stock`,`cid`,`createDate`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=25 ;

--
-- 转存表中的数据 `product`
--

INSERT INTO `product` (`id`, `name`, `subTitle`, `promotePrice`, `stock`, `cid`, `createDate`, `editor`) VALUES
(19, '我是小明', '震惊,居然有这种东西', 100, 125, 10, NULL, '<p style="text-align: center;">Hi</p><p style="text-align: center;"><img src="/ueditor/jsp/upload/image/20181220/1545277951798094641.gif" title="1545277951798094641.gif" alt="0daeeacba5b3267c7e3e6f6c.gif"/></p>'),
(21, '我是小明', '震惊,居然有这种东西', 100, 100, 10, NULL, '<p style="text-align: center;">Hi<img src="/ueditor/jsp/upload/image/20181220/1545278813305050154.jpg" title="1545278813305050154.jpg" alt="1455334846228.jpg"/></p>'),
(22, '我是小明', '震惊,居然有这种东西', 100, 125, 10, NULL, '<p><img src="/ueditor/jsp/upload/image/20181220/1545279819882008122.jpg" title="1545279819882008122.jpg" alt="Py89bT.jpg" width="747" height="433"/>Hi</p>'),
(23, '小新牌内裤', '震惊,居然有这种东西', 100, 125, 12, NULL, '<p>Hi<img src="/ueditor/jsp/upload/image/20181220/1545305305676080433.jpg" title="1545305305676080433.jpg" alt="333.jpg"/></p>'),
(24, '我是小明', '震惊,居然有这种东西', 100, 100, 9, NULL, '<p>Hi</p>');

-- --------------------------------------------------------

--
-- 表的结构 `productimage`
--

CREATE TABLE IF NOT EXISTS `productimage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_productimage_product` (`pid`),
  KEY `id` (`id`,`pid`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=43 ;

--
-- 转存表中的数据 `productimage`
--

INSERT INTO `productimage` (`id`, `pid`) VALUES
(17, 11),
(18, 12),
(23, 12),
(19, 13),
(20, 13),
(21, 13),
(22, 14),
(24, 16),
(30, 19),
(29, 20),
(31, 21),
(32, 22),
(33, 22),
(34, 22),
(35, 23),
(42, 23),
(39, 24);

-- --------------------------------------------------------

--
-- 表的结构 `review`
--

CREATE TABLE IF NOT EXISTS `review` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(4000) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_review_product` (`pid`),
  KEY `fk_review_user` (`uid`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=13 ;

--
-- 转存表中的数据 `review`
--

INSERT INTO `review` (`id`, `content`, `uid`, `pid`, `createDate`) VALUES
(1, '56', 3, 7, '2018-12-19 03:05:31'),
(2, '555555555', 3, 7, '2018-12-19 03:05:39'),
(3, '5', 3, 7, '2018-12-19 03:06:59'),
(4, '好评', 3, 11, '2018-12-19 13:30:55'),
(5, '好评呀', 3, 11, '2018-12-19 13:32:24'),
(6, '好b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　b（￣▽￣）d　', 3, 11, '2018-12-19 16:56:11'),
(7, '1223', 10, 12, '2018-12-19 19:51:17'),
(8, '123', 3, 13, '2018-12-20 10:58:28'),
(9, '你好哇\r\n&lt;script&gt;alert(&quot;a&quot;)&lt;/script&gt;', 3, 13, '2018-12-20 11:13:11'),
(10, '前', 3, 21, '2018-12-20 12:09:41'),
(11, '哇,好棒啊', 3, 22, '2018-12-20 12:24:50'),
(12, '我的妈呀,这内裤,这感觉,就像回到了老家一样', 3, 23, '2018-12-20 12:38:36');

-- --------------------------------------------------------

--
-- 表的结构 `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=21 ;

--
-- 转存表中的数据 `user`
--

INSERT INTO `user` (`id`, `name`, `password`) VALUES
(3, '0', '0'),
(6, NULL, NULL),
(7, NULL, NULL),
(8, NULL, NULL),
(9, '1', '1'),
(10, '2', '2'),
(11, '5', '5'),
(12, '7', '7'),
(13, '9', '9'),
(14, '11', '11'),
(15, '55', '55'),
(16, '我是小明', '0'),
(17, '', '0'),
(18, '1233', '1233'),
(19, '12344', '12344'),
(20, 'fangming', 'fangming');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
