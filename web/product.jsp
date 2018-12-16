<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"  import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- PAGE settings -->
  <link rel="icon" href="style/Pingendo_favicon.ico">
  <title>Restaurant Aquamarine - Pingendo template</title>
  <meta name="description" content="Free Bootstrap 4 Pingendo Aquamarine template for restaurant and food">
  <meta name="keywords" content="Pingendo restaurant food aquamarine free template bootstrap 4">
  <!-- CSS dependencies -->
  <link rel="stylesheet" href="style/css/font-awesome.min.css" type="text/css">
  <link rel="stylesheet" href="style/css/aquamarine-product.css" type="text/css">
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
<div class="py-5 text-center photo-overlay" style="	background-image: linear-gradient(to bottom, rgba(0, 0, 0, 0.6), rgba(0, 0, 0, 0.8));	background-position: top left;	background-size: 100%;	background-repeat: repeat;" >
<div class="container">
      <div class="row" >
        <div class="mx-auto col-12 p-3 section-light col-lg-5">
          <div class="carousel slide" data-ride="carousel" id="carouselTestimonial">
            <div class="carousel-inner" role="listbox">
              <div class="carousel-item">
                <img class="d-block img-fluid rounded-circle mx-auto" src="assets/restaurant/testimonial_1_light.jpg" data-holder-rendered="true" width="200">
                <p class="my-3">So good and super staff. <br>Go for the shrimps!.</p> <i class="fa fa-star d-inline"></i><i class="fa fa-star mx-1 d-inline"></i><i class="fa fa-star d-inline"></i><i class="fa fa-star mx-1 d-inline"></i><i class="fa fa-star-o d-inline"></i>
              </div>
              <div class="carousel-item">
                <img class="d-block img-fluid rounded-circle mx-auto" src="assets/restaurant/testimonial_2_light.jpg" data-holder-rendered="true" width="200">
                <p class="my-3">Super enthusiastic about food. <br>They play live music every now and then.</p> <i class="fa fa-star d-inline"></i><i class="fa fa-star mx-1 d-inline"></i><i class="fa fa-star d-inline"></i><i class="fa fa-star mx-1 d-inline"></i> <i class="fa fa-star d-inline"></i>
              </div>
              <div class="carousel-item active">
                <p class="my-3">It was since a while that I ate that good. <br>Definitely recommended.</p> <i class="fa fa-star d-inline"></i><i class="fa fa-star mx-1 d-inline"></i><i class="fa fa-star d-inline"></i><i class="fa fa-star-half-o mx-1 d-inline"></i><i class="fa fa-star-o d-inline"></i>
              </div>
            </div>
          </div>
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
  <div class="py-2 shadow-lg" style="	background-image: linear-gradient(to bottom, rgba(0, 0, 0, 0.3), rgba(0, 0, 0, 1)), url(&quot;${contextPath}/foreimg?id=${productBean.id }.jpg&quot;);	background-position: top left, top left;	background-size: 100%, cover;	background-repeat: repeat, no-repeat;	box-shadow: 0px 0px 4px  black;">
    <div class="container">
      <div class="row">
        <div class="col-md-10 mx-auto" style="">
          <div class="carousel slide" data-ride="carousel" id="carousel">
            <div class="carousel-inner">
              <div class="carousel-item active"> <img class="d-block w-100 img-fluid mx-auto" src="${contextPath}/foreimg?id=${productBean.id }.jpg">
                <div class="carousel-caption pt-3 pb-1" style="	background-image: linear-gradient(to bottom, rgba(0, 0, 0, 0.2), rgba(0, 0, 0, 1));	background-position: top left;	background-size: 100%;	background-repeat: repeat;">
                  <h4 class="text-center">${productBean.name}<small class="text-muted">subtitle</small></h4>
                  <h3 class="text-center text-danger">￥${productBean.price}&nbsp;<span class="badge badge-light"> New</span></h3>
                </div>
              </div>
              <div class="carousel-item" style="	background-image: url(${contextPath}/foreimg?id=${productBean.id }.jpg);	background-position: top left;	background-size: 100%;	background-repeat: repeat;"> <img class="d-block img-fluid w-100" src="${contextPath}/foreimg?id=${productBean.id }.jpg">
                <div class="carousel-caption">
                  <h5 class="m-0">Carousel</h5>
                  <p>with controls</p>
                </div>
              </div>
              <div class="carousel-item" style="	background-image: url(${contextPath}/foreimg?id=${productBean.id }.jpg);	background-position: top left;	background-size: 100%;	background-repeat: repeat;"> <img class="d-block img-fluid w-100" src="${contextPath}/foreimg?id=${productBean.id }.jpg">
                <div class="carousel-caption">
                  <h5 class="m-0">Carousel</h5>
                  <p>with controls</p>
                </div>
              </div>
            </div> <a class="carousel-control-prev" href="#carousel" role="button" data-slide="prev"> <span class="carousel-control-prev-icon"></span> <span class="sr-only">Previous</span> </a> <a class="carousel-control-next" href="#carousel" role="button" data-slide="next"> <span class="carousel-control-next-icon"></span> <span class="sr-only">Next</span> </a>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="py-2" style="">
    <div class="container">
      <div class="row" style="">
        <div class="col-md-7 offset-md-2" style="">
          <div class="row" style="">
            <div class="col-md-4 text-right"><a class="btn text-right btn-outline-primary" href="#">-</a></div>
            <div class="col-md-4" style="">
              <div class="form-group"><input type="number" class="form-control text-center mx-0" placeholder="1"></div>
            </div>
            <div class="col-md-4" style=""><a class="btn btn-outline-primary" href="#" contenteditable="true">+</a></div>
          </div>
          <div class="row">
            <div class="col-md-6 text-right"><a class="btn btn-secondary text-right" href="#">加入购物车</a></div>
            <div class="col-md-6"><a class="btn btn-primary" href="#">立刻购买</a></div>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col-md-12">
          <div class="tab-content mt-2">
            <div class="tab-pane fade" id="tabthree" role="tabpanel">
              <p class="">When, while the lovely valley teems with vapour around me, and the meridian sun strikes the upper surface.</p>
            </div>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col-md-12">
          <ul class="nav nav-tabs">
            <li class="nav-item"> <a href="" class="active nav-link" data-toggle="tab" data-target="#tabone">商品详情</a> </li>
            <li class="nav-item"> <a class="nav-link" href="" data-toggle="tab" data-target="#tabtwo">评价</a> </li>
            <li class="nav-item"> <a class="nav-link" href="" data-toggle="tab" data-target="#tabtwo">属性</a> </li>
          </ul>
          <div class="tab-content mt-2">
            <div class="tab-pane fade show active" id="tabone" role="tabpanel">
              <p class="">商品详情</p>
            </div>
            <div class="tab-pane fade" id="tabtwo" role="tabpanel">
              <p class="">Who formed us in his own image, and the breath of that universal love which bears and sustains us. And then, my friend.</p>
            </div>
            <div class="tab-pane fade" id="tabthree" role="tabpanel">
              <p class="">In my soul and absorb its power, like the form of a beloved mistress, then I often think with longing.</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- Parallax section -->
  <div class="py-5 bg-light">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <p class="m-0 text-center">等待你来发现</p>
          <h2 class="mb-4 text-primary text-center">更多物品</h2>
          <div class="row">
            <div class="col-md-4 p-3">
              <img class="img-fluid d-block w-100 mb-3" src="style/assets/restaurant/event_1_light.jpg">
              <p class="lead text-muted mb-1">末日单车</p>
              <h5 class="text-dark"><b>￥254.00</b><br></h5>
              <p class="mb-3">买买买</p>
              <a href="#" class="btn btn-outline-primary"><b class="">购买</b></a>
            </div>
            <div class="col-md-4 p-3">
              <img class="img-fluid d-block w-100 mb-3" src="style/assets/restaurant/event_2_light.jpg">
              <p class="lead text-muted mb-1">悲伤小提琴</p>
              <h5 class=""><b>￥521.00</b></h5>
              <p class="mb-3">买买买</p>
              <a href="#" class="btn btn-outline-primary"><b class="">购买</b></a>
            </div>
            <div class="col-md-4 p-3">
              <img class="img-fluid d-block w-100 mb-3" src="style/assets/restaurant/event_3_light.jpg">
              <p class="lead text-muted mb-1">1st October, 2017 </p>
              <h5 class=""><b>￥123.00</b></h5>
              <p class="mb-3">买买买</p>
              <a href="#" class="btn btn-outline-primary">购买<br></a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- Footer -->
  <div class="text-center bg-dark pt-5">
    <div class="container">
      <div class="row">
        <div class="col-md-4 p-3">
          <h2 class="mb-4">(●'◡'●)</h2>
          <p class="m-0">
            <a href="tel:+246 - 542 550 5462" class="text-white">1</a>23</p>
          <p>
            <a href="mailto:info@pingendo.com" class="text-white">1</a>23</p>
        </div>
        <div class="col-md-4 p-3">
          <h2 class="mb-4">O(∩_∩)O</h2>
          <p>123</p>
        </div>
        <div class="col-md-4 p-3">
          <h2 class="mb-4">♪(^∇^*)</h2>
          <p>123</p>
        </div>
      </div>
      <div class="row">
        <div class="col-md-12 mt-3">
          <p class="text-center text-muted">© Copyright 2018 123</p>
        </div>
      </div>
    </div>
  </div>
  <!-- JavaScript dependencies -->
  <script src="style/js/jquery-3.3-1.min.js"></script>
  <script src="style/js/bootstrap.min.js" ></script>
  <script src="style/js/popper.min.js" ></script>
  <!-- Script: Smooth scrolling between anchors in the same page -->
  <!-- <script src="style/js/smooth-scroll.js" style=""></script> -->
</body>

</html>