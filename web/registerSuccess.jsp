



<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>




<!DOCTYPE html>
<html>
<%@include file="include/header.jsp"%>

<body>
  <!-- Navbar -->
  <%@include file="include/nav.jsp"%>
  <!-- Cover -->
  <div class="align-items-center d-flex photo-overlay py-5 cover" style="background-image: url(&quot;assets/restaurant/cover_dark.jpg&quot;);">
    <div class="container">
      <div class="row">
        <div class="col-lg-7 align-self-center text-lg-left text-center">
          <h1 class="mb-0 mt-4 display-3">恭喜你,完成注册</h1>
          <p class="mb-5 lead" contenteditable="true">登录以继续</p>
        </div>
        <div class="col-lg-5 p-3">
          <div class="p-4 bg-dark-opaque" >
            <h4 class="mb-4 text-center">注册完毕</h4>
            <div class="form-group"> <label>ok</label>
            </div><a href="forehome">
            <button type="submit" class="btn mt-4 btn-block btn-outline-primary p-2"><b>去登录</b></button>
         </a> </div>
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