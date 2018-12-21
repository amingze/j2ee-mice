<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"  import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<<<<<<< HEAD
<%@include file="include/header.jsp"%>
<%@include file="include/top.jsp"%>
=======
>>>>>>> c0687b9101aa3aad2a25d30c163cca51017aa544
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- PAGE settings -->
<<<<<<< HEAD
  <link rel="icon" href="include/style/assets/Pingendo_favicon.ico">
=======
  <link rel="icon" href="style/style/assets/Pingendo_favicon.ico">
>>>>>>> c0687b9101aa3aad2a25d30c163cca51017aa544
  <title>Mice</title>
  <meta name="description" content="Free Bootstrap 4 Pingendo Aquamarine template for restaurant and food">
  <meta name="keywords" content="Pingendo restaurant food aquamarine free template bootstrap 4">
  <!-- CSS dependencies -->
  <link rel="stylesheet" href="style/css/font-awesome.min.css" type="text/css">
  <link rel="stylesheet" href="style/css/aquamarine.css" type="text/css">
  <!-- Script: Make my navbar transparent when the document is scrolled to top -->
  <script src="style/js/navbar-ontop.js"></script>
  <!-- Script: Animated entrance -->
  <script src="style/js/animate-in.js"></script>
</head>

<body>
  <!-- Navbar -->
<<<<<<< HEAD
<%@include file="include/nav.jsp"%>
  <!-- Cover -->
  <div class="align-items-center d-flex cover py-5 text-muted  photo-overlay" style="	background-image: url(include/style/assets/restaurant/cover_dark.jpg);	background-position: top left;	background-size: 100%;	background-repeat: repeat;">
    <div class="container">
      <div class="row">
        <div class="col-lg-7 align-self-center text-lg-left text-center">
          <h1 class="mb-0 mt-5 display-4 ">Mice</h1>
          <p class="mb-5">老鼠网-全球最小的购物中心</p>
        </div>
        <div class="col-lg-5 p-3">
          <form class="p-4 bg-light" action="forelogin" method="post" ">
            <h4 class="mb-4 text-center text-info">登录Mice</h4>
            <div class="form-group"> <label>账号</label>
              <input class="form-control" placeholder="输入账号"  name="name"> </div>
            <div class="form-group" > <label>密码</label>
              <div class="form-group"><input class="form-control" placeholder="输入密码" type="password" name="password"></div>
=======
  <nav class="navbar navbar-expand-md navbar-dark bg-primary fixed-top">
    <div class="container">
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbar3SupportedContent"
        aria-controls="navbar3SupportedContent" aria-expanded="false" aria-label="Toggle navigation"> <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse text-center justify-content-center" id="navbar3SupportedContent">
        <ul class="navbar-nav">
          <li class="nav-item mx-3">
            <a class="nav-link text-light" href="${contextPath}/forehome"><b>Mice</b></a>
          </li>
          <li class="nav-item mx-2">
            <a class="nav-link" href="#menu"><b>菜单</b></a>
          </li>
          <li class="nav-item mx-2">
            <a class="nav-link" href="${contextPath}/forelogin"><b>注册</b></a>
          </li>
        </ul>
        <a class="btn navbar-btn btn-secondary mx-2" href="${contextPath}/foreregister"><b>注册</b></a>
      </div>
    </div>
  </nav>
  <!-- Cover -->
  <div class="align-items-center d-flex cover py-5 text-muted" style="	background-image: url(../../../Pictures/20180622201252-7l8fzBAdSj.jpg);	background-position: top left;	background-size: 100%;	background-repeat: repeat;">
    <div class="container">
      <div class="row">
        <div class="col-lg-7 align-self-center text-lg-left text-center">
          <h1 class="mb-0 mt-5 display-4">Mice</h1>
          <p class="mb-5">老鼠网-全球最小的购物中心</p>
        </div>
        <div class="col-lg-5 p-3">
          <form class="p-4 bg-light" method="post" action="${contextPath}/forelogin" enctype="application/x-www-form-urlencoded">
            <h4 class="mb-4 text-center">登录Mice</h4>
            <div class="form-group"> <label>账号</label>
              <input class="form-control" placeholder="输入账号"  name="name"> </div>
            <div class="form-group" > <label>密码</label>
              <div class="form-group"><input class="form-control" placeholder="输入密码" type="password" name="passwd"></div>
>>>>>>> c0687b9101aa3aad2a25d30c163cca51017aa544
            </div>
            <!-- <div class="form-group"> <label>验证码</label>
              <div class="form-group"><input class="form-control" placeholder="输入验证码"></div>
            </div> -->
            <button type="submit" class="btn mt-4 btn-block p-2 btn-primary"><b>登录</b></button>
<<<<<<< HEAD

=======
>>>>>>> c0687b9101aa3aad2a25d30c163cca51017aa544
          </form>
        </div>
      </div>
    </div>
  </div>
  <!-- Intro -->
  <!-- Gallery -->
  <!-- Menu -->
  <!-- Carousel reviews -->
  <!-- Carousel venue -->
  <!-- Events -->
  <!-- Parallax section -->
  <!-- Footer -->
<<<<<<< HEAD
  <%@include file="include/foot.jsp"%></body>
=======
  <div class="text-center bg-dark pt-5">
    <div class="container">
      <div class="row">
        <div class="col-md-4 p-3">
          <h2 class="mb-4 text-muted">孤独</h2>
          <p class="m-0 text-muted">
            <a href="tel:+246 - 542 550 5462" class="text-white">@</a>github/amingze</p>
        </div>
        <div class="col-md-4 p-3">
          <h2 class="mb-4 text-muted">寂寞</h2>
          <p class="text-muted">24 hours working</p>
        </div>
        <div class="col-md-4 p-3">
          <h2 class="mb-4 text-muted">无奈</h2>
          <p class="text-muted">3:00 - 11:00&nbsp; sleep</p>
        </div>
      </div>
      <div class="row">
        <div class="col-md-12 mt-3">
          <p class="text-center text-muted">© Copyright 2018 wtf i call&nbsp;<br></p>
        </div>
      </div>
    </div>
  </div>
  <!-- JavaScript dependencies -->
  <script src="style/js/jquery-3.3-1.min.js"></script>
  <script src="style/js/bootstrap.min.js" ></script>
  <script src="style/js/popper.min.js" ></script>
  <!-- Script: Smooth scrolling between anchors in the same page -->
  <script src="style/js/smooth-scroll.js"></script>
</body>
>>>>>>> c0687b9101aa3aad2a25d30c163cca51017aa544

</html>