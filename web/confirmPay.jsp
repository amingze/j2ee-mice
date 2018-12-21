
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@include file="include/header.jsp"%>
<!DOCTYPE html>
<html>



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
          
            <h4 class="mb-4 text-center">确认收货</h4>
           
            <p class="my-4">请核对:共￥${o.total}元<br></p>
            <a href="foreorderConfirmed?oid=${o.id}">
            <button type="submit" class="btn mt-4 btn-block p-2 btn-outline-primary">确认收货</button><button type="submit" class="btn mt-4 btn-block p-2 btn-outline-primary"><b>返回我的订单</b></button>
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
  <%@include file="include/foot.jsp"%>
  </body>

</html>