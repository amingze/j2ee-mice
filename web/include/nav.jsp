<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar-expand-md navbar-dark bg-dark navbar fixed-top">
    <div class="container">
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbar3SupportedContent" aria-controls="navbar3SupportedContent" aria-expanded="false" aria-label="Toggle navigation"> <span class="navbar-toggler-icon"></span> </button>
      <div class="collapse navbar-collapse text-center justify-content-center" id="navbar3SupportedContent">
        <ul class="navbar-nav">
          <li class="nav-item mx-3">
            <a class="nav-link text-light" href="forehome"><b>Mice</b></a>
          </li>
          <c:if test="${!empty user}">
          <li class="nav-item mx-2">
          
          <a class="nav-link" href="forebought">欢迎您:<b>${user.name}</b></a></li>
            <a class="nav-link" href="forebought"><b>我的订单</b></a></li>
            </ul>
             <a class="btn navbar-btn btn-secondary mx-2" href="forecart"><b>购物车</b></a>
          <a class="nav-link" href="forelogout"><b>登出</b></a></li>
          
          </c:if>
          
          
          
          <c:if test="${empty user}">
          <li class="nav-item mx-2">
            <a class="nav-link" href="foreregister"><b>注册</b></a></li>
            </ul>
            <a class="btn navbar-btn btn-secondary mx-2" href="forelogin"><b>登录</b></a>
          
          </c:if>
          
        
        
      </div>
    </div>
  </nav>