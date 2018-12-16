<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"  import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
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
  <!-- Cover -->
  <!-- Intro -->
  <!-- Gallery -->
  <div class=""></div>
  <!-- Menu -->
  <!-- Carousel reviews -->
  <!-- Carousel venue -->
  <div class="py-5" style="background-image: url(&quot;style/assets/restaurant/cover_light_2.jpg&quot;);" id="venue">
    <div class="container">
      <div class="row bg-primary animate-in-down">
        <div class="p-4 col-md-6 align-self-center">
          <p class="m-0">报新价</p>
          <h2>加宽凳子</h2>
          <p class="my-4">只要<br>￥245.00元<br>还不来抢购</p>
          <a href="#" class="btn mb-3 p-2 btn-light">了解更多</a>
        </div>
        <div class="p-0 col-md-6">
          <div class="carousel slide" data-ride="carousel" id="carousel1">
            <div class="carousel-inner" role="listbox">
              <div class="carousel-item">
                <img class="d-block img-fluid w-100" src="style/assets/restaurant/venue_1_light.jpg" alt="first slide">
                <div class="carousel-caption">
                  <h3>Dining room</h3>
                  <p>Good architecture, better food</p>
                </div>
              </div>
              <div class="carousel-item active">
                <img class="d-block img-fluid w-100" src="style/assets/restaurant/venue_3_light.jpg"
                  data-holder-rendered="true">
                <div class="carousel-caption">
                  <h3>价款凳子</h3>
                  <p>￥235.00</p>
                </div>
              </div>
              <div class="carousel-item">
                <img class="d-block img-fluid w-100" src="style/assets/restaurant/venue_2_light.jpg"
                  data-holder-rendered="true">
                <div class="carousel-caption">
                  <h3>Show cooking</h3>
                  <p>Tastes better</p>
                </div>
              </div>
              <div class="carousel-item">
                <img class="d-block img-fluid w-100" src="style/assets/restaurant/venue_4_light.jpg"
                  data-holder-rendered="true">
                <div class="carousel-caption">
                  <h3>Relax area</h3>
                  <p>Take the time to chill</p>
                </div>
              </div>
            </div>
            <a class="carousel-control-prev" href="#carousel1" role="button" data-slide="prev"> <span class="carousel-control-prev-icon"
                aria-hidden="true"></span> <span class="sr-only">Previous</span> </a>
            <a class="carousel-control-next" href="#carousel1" role="button" data-slide="next"> <span class="carousel-control-next-icon"
                aria-hidden="true"></span> <span class="sr-only">Next</span> </a>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- Events -->
  <div class="py-5 bg-light">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <p class="m-0 text-center text-muted">推荐</p>
          <h2 class="mb-4 text-primary text-center">小提琴</h2>
          <div class="row">
            <c:forEach items="${productList}" var="product" varStatus="st">
              <div class="col-md-4 p-3">
                <a href="${contextPath}/foreproduct?id=${product.id }">
                  <img class="img-fluid d-block w-100 mb-3 bg" style="background-image: url(${contextPath}/foreimg?id=${product.id }.jpg);">
                  <p class="lead text-muted mb-1">26th July, 2017</p>
                  <h5 class="text-dark"><b>${product.name}</b></h5>
                </a>
                <p class="mb-3">￥${product.price}</p>
                <a href="${contextPath}/foreproduct?id=${product.id }" class="btn btn-outline-primary"><b class="">购买</b></a>
              </div>
            </c:forEach>

          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- Parallax section -->
  <!-- Footer -->
  <div class="text-center bg-dark pt-5">
    <div class="container">
      <div class="row">
        <div class="col-md-4 p-3">
          <h2 class="mb-4">（づ￣3￣）づ╭❤～</h2>
          <p class="m-0"></p>
          <p></p>
        </div>
        <div class="col-md-4 p-3">
          <h2 class="mb-4">O(∩_∩)O</h2>
          <p></p>
        </div>
        <div class="col-md-4 p-3">
          <h2 class="mb-4">（づ￣3￣）づ╭❤～</h2>
          <p></p>
        </div>
      </div>
      <div class="row">
        <div class="col-md-12 mt-3">
          <p class="text-center text-muted">© Copyright 2018 Pingendo - fafamila</p>
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

</html>