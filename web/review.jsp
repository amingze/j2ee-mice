



<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>




<!DOCTYPE html>
<html>
<%@include file="include/header.jsp"%>

<body>
  <!-- Navbar -->
<%@include file="include/nav.jsp"%>
  <!-- Cover -->
  <!-- Intro -->
  <!-- Gallery -->
  <!-- Menu -->
  <!-- Carousel reviews -->
  <!-- Carousel venue -->
  <div class="py-3" id="venue">
    <div class="container">
      <div class="row my-5 bg-primary animate-in-down">
        <div class="p-0 col-md-6" style="">
          <div class="carousel slide" data-ride="carousel" id="carousel1">
            <div class="carousel-inner" role="listbox">
              <div class="carousel-item active">
                <img class="d-block img-fluid w-100" src="include/style/assets/restaurant/venue_1_dark.jpg" atl="first slide">
                <div class="carousel-caption">
                  <h3>请填写你的评价</h3>
                
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="p-4 col-md-6 align-self-center" style="">
        <c:if test="${param.fine!=true}">
        
        <form method="post" action="foredoreview">
          <h2 class="">评价</h2>  <textarea name="content" class="w-100" style="height:250px; background-color: rgb(59, 59, 59);color: rgb(219, 219, 219);"></textarea>
          <button type="submit" class="btn-outline-light mb-3 p-2 btn">提交评价</button>
          		<input type="hidden" name="oid" value="${o.id}">
				<input type="hidden" name="pid" value="${p.id}">
          </form>
        
        </c:if>
        <c:if test="${param.fine==true}">
        
        <h2 class="">完成评价</h2>  
          <a href="forebought" type="submit" class="btn-outline-light mb-3 text-info p-2 btn">返回订单页</a>
        </c:if>
        </div>
      </div>
    </div>
  </div>
  <!-- Events -->
  <!-- Dark opaque section -->
  <div class="py-5 photo-overlay" id="book" style="background-image: url(&quot;include/style/assets/restaurant/makereservation_dark.jpg&quot;);">
    <div class="container">
      <div class="row">
        <div class="col-md-3"> </div>
        <div class="col-lg-6 p-3 animate-in-down"></div>
      </div>
    </div>
  </div>
  <!-- Footer -->
  <%@include file="include/foot.jsp"%></body>

</html>