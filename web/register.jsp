<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"  import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<<<<<<< HEAD
<%@include file="include/header.jsp"%>


<body>
  <!-- Navbar -->
  <%@include file="include/nav.jsp"%>
=======
<html>

  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- PAGE settings -->
    <link rel="icon" href="style/style/assets/Pingendo_favicon.ico">
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
            <a class="nav-link" href="${contextPath}/foreregister"><b>注册</b></a>
          </li>
        </ul>
        <a class="btn navbar-btn btn-secondary mx-2" href="${contextPath}/forelogin"><b>登录</b></a>
      </div>
    </div>
  </nav>
>>>>>>> c0687b9101aa3aad2a25d30c163cca51017aa544
  <!-- Cover -->
  <!-- Intro -->
  <!-- Gallery -->
  <!-- Menu -->
  <!-- Carousel reviews -->
  <!-- Carousel venue -->
  <!-- Events -->
  <!-- Parallax section -->
<<<<<<< HEAD
  <div class="py-5 photo-overlay section-parallax" id="book" style="background-image: url(include/style/assets/restaurant/cover_dark.jpg);">
    <div class="container">
      <div class="row my-5">
        <div class="col-lg-6 mx-auto p-3 animate-in-down">
          <form class="p-4 bg-light" method="post" action="foreregister">
            <h4 class="mb-4 text-center text-info">加入Mice</h4>
            <p class="my-4 text-muted">加入全球最没有牌面的个人超市,享受最没人权的服务</p>
           <p class="text-center text-info"> 我们在这等你加入</p>
            <div class="form-group text-info"> <label>账号</label>
              <input class="form-control" placeholder="输入账号"  name="name" value=""> </div>
            <div class="form-group text-info" name="password"> <label>密码</label>
              <div class="form-group"><input name="password" type="password" class="form-control"  placeholder="确认密码"  value=""></div>
            </div>
             <p class="text-center text-info"> ${msg}</p>
=======
  <div class="py-5 photo-overlay section-parallax" id="book" style="background-image: url(&quot;assets/restaurant/makereservation_light.jpg&quot;);">
    <div class="container">
      <div class="row my-5">
        <div class="col-lg-6 mx-auto p-3 animate-in-down">
          <form class="p-4 bg-light" action="${contextPath}/foreregister" method="post" enctype="application/x-www-form-urlencoded">
            <h4 class="mb-4 text-center">加入Mice</h4>
            <p class="my-4 text-muted">加入全球最没有牌面的个人超市,享受最没人权的服务,我们在这等你加入</p>
            <div class="form-group"> <label>账号</label>
              <input class="form-control" placeholder="输入账号"  name="name"> </div>
            <div class="form-group" name="passwd"> <label>密码</label>
              <div class="form-group"><input class="form-control" placeholder="输入密码"></div>
            </div>
            <div class="form-group"> <label>确认密码</label>
              <div class="form-group"><input class="form-control" placeholder="确认密码"></div>
            </div>
>>>>>>> c0687b9101aa3aad2a25d30c163cca51017aa544
            <button type="submit" class="btn mt-4 btn-block p-2 btn-primary"><b>注册</b></button>
          </form>
        </div>
      </div>
    </div>
  </div>
  <!-- Footer -->
<<<<<<< HEAD
  <%@include file="include/foot.jsp"%></body>
=======
  <div class="text-center bg-dark pt-5">
    <div class="container">
      <div class="row">
        <div class="col-md-4 p-3 text-muted">
          <h2 class="mb-4">&nbsp;弱小</h2>
          <p class="m-0">ε=( o｀ω′)ノ</p>
        </div>
        <div class="col-md-4 p-3 text-muted">
          <h2 class="mb-4">可怜</h2>
          <p>o((&gt;ω&lt; ))o</p>
        </div>
        <div class="col-md-4 p-3 text-muted">
          <h2 class="mb-4">无助</h2>
          <p>(⊙﹏⊙)</p>
        </div>
      </div>
      <div class="row">
        <div class="col-md-12 mt-3">
          <p class="text-center text-muted">© Copyright 2018 OK ,ffffm</p>
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