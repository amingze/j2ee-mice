<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"  import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="include/header.jsp"%>
<%@include file="include/top.jsp"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- PAGE settings -->
  <link rel="icon" href="include/style/assets/Pingendo_favicon.ico">
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
            </div>
            <!-- <div class="form-group"> <label>验证码</label>
              <div class="form-group"><input class="form-control" placeholder="输入验证码"></div>
            </div> -->
            <button type="submit" class="btn mt-4 btn-block p-2 btn-primary"><b>登录</b></button>

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
  <%@include file="include/foot.jsp"%></body>

</html>