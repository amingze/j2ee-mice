<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"  import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
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
  <!-- Events -->
  <!-- Parallax section -->
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
            <button type="submit" class="btn mt-4 btn-block p-2 btn-primary"><b>注册</b></button>
          </form>
        </div>
      </div>
    </div>
  </div>
  <!-- Footer -->
  <%@include file="include/foot.jsp"%></body>

</html>