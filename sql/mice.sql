-- phpMyAdmin SQL Dump
-- version 4.0.4.2
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2018 年 12 月 07 日 04:50
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
CREATE DATABASE IF NOT EXISTS `mice` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_520_ci;
USE `mice`;

-- --------------------------------------------------------

--
-- 表的结构 `address`
--

CREATE TABLE IF NOT EXISTS `address` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `address` varchar(256) COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `phonenume` int(20) NOT NULL,
  `u_id` int(12) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `category`
--

CREATE TABLE IF NOT EXISTS `category` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `t_id` int(12) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `goods`
--

CREATE TABLE IF NOT EXISTS `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_unicode_520_ci NOT NULL,
  `price` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_520_ci AUTO_INCREMENT=56 ;

--
-- 转存表中的数据 `goods`
--

INSERT INTO `goods` (`id`, `name`, `price`) VALUES
(55, '红酒', 2);

-- --------------------------------------------------------

--
-- 表的结构 `image`
--

CREATE TABLE IF NOT EXISTS `image` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `p_id` int(12) NOT NULL,
  `type` varchar(256) COLLATE utf8mb4_unicode_520_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `order`
--

CREATE TABLE IF NOT EXISTS `order` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `u_id` int(12) DEFAULT NULL,
  `o_id` int(12) DEFAULT NULL,
  `datetime` datetime DEFAULT CURRENT_TIMESTAMP,
  `a_id` int(12) DEFAULT NULL,
  `a_name` varchar(256) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `a_address` varchar(256) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `a_phone` int(20) DEFAULT NULL,
  `a_userid` int(12) DEFAULT NULL,
  `total` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci AUTO_INCREMENT=7 ;

--
-- 转存表中的数据 `order`
--

INSERT INTO `order` (`id`, `u_id`, `o_id`, `datetime`, `a_id`, `a_name`, `a_address`, `a_phone`, `a_userid`, `total`) VALUES
(1, 16, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(2, 16, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(3, 16, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(4, 16, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(5, 16, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(6, 16, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- 表的结构 `orderitem`
--

CREATE TABLE IF NOT EXISTS `orderitem` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `u_id` int(12) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `remake` text COLLATE utf8mb4_unicode_520_ci,
  `p_id` int(12) DEFAULT NULL,
  `p_name` varchar(256) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `p_price` float DEFAULT NULL,
  `i_id` int(12) DEFAULT NULL,
  `i_type` varchar(256) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `i_productid` int(12) DEFAULT NULL,
  `o_id` int(12) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci AUTO_INCREMENT=8 ;

--
-- 转存表中的数据 `orderitem`
--

INSERT INTO `orderitem` (`id`, `u_id`, `number`, `status`, `remake`, `p_id`, `p_name`, `p_price`, `i_id`, `i_type`, `i_productid`, `o_id`) VALUES
(1, 16, 3, 4, NULL, 31, NULL, NULL, NULL, NULL, NULL, 2),
(2, 16, 1, 4, NULL, 29, NULL, NULL, NULL, NULL, NULL, 2),
(3, 16, 1, 4, NULL, 32, NULL, NULL, NULL, NULL, NULL, 4),
(4, 16, 1, 4, NULL, 33, NULL, NULL, NULL, NULL, NULL, 6),
(5, 16, 1, 4, NULL, 35, NULL, NULL, NULL, NULL, NULL, 6),
(6, 16, 1, 3, NULL, 33, NULL, NULL, NULL, NULL, NULL, 7),
(7, 16, 1, 2, NULL, 31, NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- 表的结构 `product`
--

CREATE TABLE IF NOT EXISTS `product` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_520_ci NOT NULL DEFAULT 'null',
  `price` float unsigned zerofill NOT NULL DEFAULT '000000000.01',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci AUTO_INCREMENT=36 ;

--
-- 转存表中的数据 `product`
--

INSERT INTO `product` (`id`, `name`, `price`) VALUES
(29, '纸币', 000000000003),
(31, '女装大佬', 000000000233),
(32, '红酒', 000000000123),
(33, '233', 000000000123),
(35, 'J', 000000000001);

-- --------------------------------------------------------

--
-- 表的结构 `productimage`
--

CREATE TABLE IF NOT EXISTS `productimage` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) COLLATE utf8_unicode_520_ci NOT NULL,
  `type` varchar(256) COLLATE utf8_unicode_520_ci NOT NULL,
  `p_id` int(12) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_520_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `productitem`
--

CREATE TABLE IF NOT EXISTS `productitem` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) COLLATE utf8mb4_unicode_520_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `property`
--

CREATE TABLE IF NOT EXISTS `property` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) COLLATE utf8_unicode_520_ci NOT NULL,
  `c_id` int(12) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_520_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `propertyvalue`
--

CREATE TABLE IF NOT EXISTS `propertyvalue` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `p_id` int(12) NOT NULL,
  `pt_id` int(12) NOT NULL,
  `value` varchar(256) COLLATE utf8_unicode_520_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_520_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `review`
--

CREATE TABLE IF NOT EXISTS `review` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `u_id` int(12) NOT NULL,
  `p_id` int(12) NOT NULL,
  `content` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `createtime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_520_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) COLLATE utf8_unicode_520_ci NOT NULL,
  `passwd` varchar(256) COLLATE utf8_unicode_520_ci NOT NULL,
  `creatdate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_520_ci AUTO_INCREMENT=17 ;

--
-- 转存表中的数据 `user`
--

INSERT INTO `user` (`id`, `name`, `passwd`, `creatdate`) VALUES
(14, 'admin', 'admin', '2018-11-02 21:29:44'),
(15, '123', '123', '2018-11-27 11:09:03'),
(16, '0', '0', '2018-12-02 10:23:04');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
