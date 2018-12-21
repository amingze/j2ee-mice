



<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@include file="include/header.jsp"%>
<%@include file="include/nav.jsp"%>


<body>
  <!-- Navbar -->

  <!-- Cover -->
  <!-- Intro -->
  <!-- Gallery -->
  <div class=""></div>
  <!-- Menu -->
  <!-- Carousel reviews -->
  <!-- Carousel venue -->
  <div class="py-5 photo-overlay"  style="background-image: url(&quot;include/style/assets/restaurant/cover_dark.jpg&quot;);" id="venue">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <h1 class="display-4 text-center ">Mice</h1>
        </div>
      </div>
      <div class="p-4 col-md-12 align-self-center" style="">
        <form class="form-inline">
        </form>

      </div>
    </div>
  </div>
  <!-- Events -->
  <div class="py-5 bg-light">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <p class="m-0 text-center text-muted">搜索结果</p>
          
          <c:forEach items="${ps}" var="p">
          
          <h2 class="mb-4 text-primary text-center">${p.name}</h2>
          <div class="row">
       
            <div class="col-md-4 p-3">
            <a href="foreproduct?pid=${p.id}">
              <img class="img-fluid d-block w-100 mb-3 " style=" height:200px;;background-image: url(img/productSingle/${p.firstProductImage.id}.jpg);background-size: cover;background-repeat: no-repeat;background-position: center;">
              
              <p class="lead text-muted mb-1">30th August, 2017</p>
              <h5 class="">${p.name}</h5>
              </a>
              <p class="mb-3">￥${p.promotePrice}</p>
          
              <a href="foreproduct?pid=${p.id}" class="btn btn-outline-primary"><b class="">购买</b></a>
              
            </div>
      
            
            
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