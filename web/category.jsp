<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@include file="include/header.jsp"%>
<%@include file="include/top.jsp"%>
<!DOCTYPE html>
<html>

<body>
  <div class="collapse bg-dark" id="navbarHeader">
    <div class="container">
      <div class="row">
        <div class="col-md-7 py-4">
          <h4>About</h4>
          <p class="text-info">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
        </div>
        <div class="col-md-3 offset-md-1 py-4">
          <h4>Contact</h4>
          <ul class="list-unstyled">
            <li>
              <a href="#" class="text-secondary">Follow on Twitter</a>
            </li>
            <li>
              <a href="#" class="text-secondary">Like on Facebook</a>
            </li>
            <li>
              <a href="#" class="text-secondary">Email me</a>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </div>
  <div class="navbar navbar-dark bg-dark">
    <div class="container d-flex justify-content-between">
      <a href="#" class="navbar-brand d-flex align-items-center"><i class="fa d-inline fa-camera mr-2"></i><strong>Album</strong> </a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarHeader"> <span class="navbar-toggler-icon"></span> </button>
    </div>
  </div>
  
  <div class="text-center py-5">
    <div class="container">
      <div class="row my-5 justify-content-center">
        <div class="col-md-9">
          <h1>分类</h1>
        </div>
      </div>
    </div>
  </div>
  <div class="py-4 bg-light">
    <div class="container">
      <div class="row">
      	<c:forEach items="${c.products}" var="p" varStatus="stc">

        <div class="col-lg-3 p-3">
          <div class="card box-shadow">
            <img class="card-img-top" src="img/productSingle/${p.firstProductImage.id}.jpg">
            
            <div class="card-body">
              <p class="card-text" ><a href="foreproduct?pid=${p.id}">${p.name}</a></p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                  <button type="button" class="btn btn-sm btn-outline-secondary">销量: ${p.saleCount}件</button>
                  <button type="button" class="btn btn-sm btn-outline-secondary">评价:${p.reviewCount}&nbsp;</button>
                </div> <small class="text-muted">￥${p.promotePrice}</small>
              </div>
            </div>
          </div>
        </div>
      
	</c:forEach>
	
      </div>
    </div>
  </div>
  <%@include file="include/foot.jsp"%></body>

</html>