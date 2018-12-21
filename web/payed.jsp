



<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@include file="include/header.jsp"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- PAGE settings -->
  <link rel="icon" href="https://templates.pingendo.com/assets/Pingendo_favicon.ico">
  <title>Restaurant Elegant - Pingendo template</title>
  <meta name="description" content="Free Bootstrap 4 Pingendo Elegant template for restaurant and food">
  <meta name="keywords" content="Pingendo restaurant food elegant free template bootstrap 4">
  <!-- CSS dependencies -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
  <link rel="stylesheet" href="elegant.css" type="text/css">
  <!-- Script: Make my navbar transparent when the document is scrolled to top -->
  <script src="js/navbar-ontop.js"></script>
  <!-- Script: Animated entrance -->
  <script src="js/animate-in.js"></script>
</head>

<body>
  <!-- Navbar -->
<%@include file="include/nav.jsp"%>
  <!-- Cover -->
  <div class="align-items-center d-flex photo-overlay py-5 cover" style="background-image: url(&quot;assets/restaurant/cover_dark.jpg&quot;);">
    <div class="container">
      <div class="row">
        <div class="col-md-3"> </div>
        <div class="col-lg-6 p-3 animate-in-down">
          <div class="p-4 bg-dark-opaque" >
            <h4 class="mb-4 text-center">付款成功</h4>
            <h1>付款金额:￥${param.total }元</h1>
            <a href="forehome">
            <button type="submit" class="btn mt-4 btn-block p-2 btn-outline-primary"><b>继续购物</b></button>
          </a>
          </div>
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
  <!-- Dark opaque section -->
  <!-- Footer -->
  <%@include file="include/foot.jsp"%></body>

</html>