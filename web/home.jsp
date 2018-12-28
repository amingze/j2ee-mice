<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@include file="include/header.jsp"%>

<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- PAGE settings -->

</head>

<body>
  <!-- Navbar -->
<%@include file="include/nav.jsp"%>
  <!-- Cover -->
  <!-- Intro -->
  <!-- Gallery -->
  <div class=""></div>
  <!-- Menu -->
  <!-- Carousel reviews -->
  <!-- Carousel venue -->
  <div class="py-5 photo-overlay" style="background-image: url(&quot;include/style/assets/restaurant/cover_dark.jpg&quot;);" id="venue">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <h1 class="display-4 text-center text-light">Mice</h1>
        </div>
      </div>
      <div class="p-4 col-md-12 align-self-center" style="">
          <form  action="foresearch" method="post" style="width:100%">	
        <div class="form-group">
          <div class="input-group text-center" style="">

            <input name="keyword" type="text" value="${param.keyword}" class="form-control" placeholder="搜索一下" style="max-width:700px;text-align: center;border-radius: 30px;width: 100%;margin :0 auto;">
            <div class="col-md-12 w-25 mx-auto"><button type="submit" class="btn btn-primary text-center my-3 mx-auto" type="button" style="margin: 0px auto; text-align: center; border-radius: 30px;">搜索</button></div>
          	
          </div>
          <div class="row">
          </div>
        </div>
        </form>	
      </div>
    </div>
  </div>
  <!-- Events -->
  <div class="py-5 bg-light">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <p class="m-0 text-center text-muted">推荐</p>
          
          <c:forEach items="${cs}" var="c" varStatus="stc">
          
          <h2 class="mb-4 text-primary text-center">${c.name}</h2>
          <div class="row">
       <c:forEach items="${c.products}" var="p" varStatus="st">
            <div class="col-md-4 p-3">
            <a href="foreproduct?pid=${p.id}">
              <img class="img-fluid d-block w-100 mb-3 " style=" height:200px;;background-image: url(img/productSingle/${p.firstProductImage.id}.jpg);background-size: cover;background-repeat: no-repeat;background-position: center;">
              
              <p class="lead text-muted mb-1">30th August, 2017</p>
              <h5 class="" style="color:black">${p.name}</h5>
              </a>
              <p class="mb-3"  style="color:black">￥${p.promotePrice}</p>
          
              <a href="foreproduct?pid=${p.id}" class="btn btn-outline-primary"><b class="">购买</b></a>
              
            </div>
        </c:forEach>
            
            
          </div>
          
          
          </c:forEach>
        </div>
      </div>
    </div>
  </div>
  <!-- Parallax section -->
  <!-- Footer -->
<%@include file="include/foot.jsp"%>
</body>

</html>