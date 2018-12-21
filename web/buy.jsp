



<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="include/header.jsp"%>
<%@include file="include/nav.jsp"%>


<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- PAGE settings -->
  <link rel="icon" href="https://templates.pingendo.com/assets/Pingendo_favicon.ico">
  <title>Checkout</title>
  <meta name="description" content="Wireframe design of a checkout form by Pingendo">
  <meta name="keywords" content="Pingendo bootstrap example template wireframe checkout form">
  <meta name="author" content="Pingendo">
  <!-- CSS dependencies -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
  <link rel="stylesheet" href="wireframe.css">
</head>

<body class="bg-light">
  <div class="py-5">
    <div class="container">
      <div class="row">
        <div class="text-center col-md-7 mx-auto"> <i class="fa d-block fa-bullseye fa-5x mb-4 text-info"></i>
          <h2><b>Mice</b></h2>
        </div>
      </div>
    </div>
  </div>
  <div class="">
  
    <div class="container">
      <div class="row">
      
        <div class="col-md-4 order-md-2">
          <h4 class="d-flex justify-content-between mb-3"> <span class="text-muted">下订单</span> </h4>
          <ul class="list-group">
            <li class="list-group-item d-flex justify-content-between">
              <div>
                <h6 class="my-0"><b>评价</b></h6>
              </div>
            </li>
            <li class="list-group-item d-flex justify-content-between">
              <div>
                <h6 class="my-0"><b>确认收货</b></h6>
              </div>
            </li>
            <li class="list-group-item d-flex justify-content-between">
              <div>
                <h6 class="my-0"><b>付款</b></h6>
              </div>
            </li>
            <li class="list-group-item d-flex justify-content-between bg-light">
              <div class="text-success">
                <h6 class="my-0"><b>拍下商品</b></h6> <small></small>
              </div>
            </li>
            <li class="list-group-item d-flex justify-content-between"> <span>查看购物车</span> </li>
          </ul>
        </div>
        <div class="col-md-8 order-md-1">
          <h4 class="mb-3"><b>详细地址</b></h4>
          <form class="needs-validation" action="forecreateOrder" method="post">
            <div class="row">
              <div class="col-md-6 mb-3"> <label for="firstName">省</label>
                <input type="text" class="form-control" id="firstName" placeholder="" value="" required="">
                <div class="invalid-feedback"> Valid first name is required. </div>
              </div>
              <div class="col-md-6 mb-3"> <label for="lastName">市</label>
                <input type="text" class="form-control" id="lastName" placeholder="" value="" required="">
                <div class="invalid-feedback"> Valid last name is required. </div>
              </div>
            </div>
            <div class="mb-3"> <label for="username" >详细地址</label>
              <div class="input-group">
                <div class="input-group-prepend" > <span class="input-group-text">@</span> </div>
                <input type="text" class="form-control" id="username" required="" name="address">
                <div class="invalid-feedback" style="width: 100%;"> Your username is required. </div>
              </div>
            </div>
            <div class="row">
              <div class="col-md-4 mb-3"> <label for="cc-expiration">邮编</label>
                <input type="text" class="form-control" id="cc-expiration" placeholder="" required=""  name="post">
                <div class="invalid-feedback"> Expiration date required </div>
              </div>
              <div class="col-md-4 mb-3"> <label for="cc-expiration">姓名</label>
                <input type="text" class="form-control" id="cc-cvv" placeholder="" required="" name="receiver">
                <div class="invalid-feedback"> Security code required </div>
              </div>
              <div class="col-md-4 mb-3"> <label for="cc-number">手机号</label>
                <input type="text" class="form-control" id="cc-number" placeholder="" required="" name="mobile" >
                <div class="invalid-feedback"> Credit card number is required </div>
              </div>
            </div>
            <hr class="mb-4">
            <div class="custom-control custom-checkbox">
              <input type="checkbox" class="custom-control-input" id="same-address" value="on">
               <label class="custom-control-label" for="same-address">运险费</label> </div>
            <hr class="mb-4">
            <div class="col-md-12">
              <div class="table-responsive">
                <table class="table table-bordered ">
                  <thead class="thead-info">
                    <tr>
                      <th>图片</th>
                      <th>名称</th>
                      <th>单价</th>
                      <th>数量</th>
                      <th contenteditable="true">总共</th>
                    </tr>
                  </thead>
                  <tbody>
                  <c:forEach items="${ois}" var="oi" varStatus="st" >
                    <tr>
                    
                      <th><img width="120" height="100"  style="background-image:url(img/productSingle/${oi.product.firstProductImage.id}.jpg);background-size:cover;background-repart:no-repart;">
                      
                      </th>
    
                      <td>${oi.product.name}</td>
                      <td>${oi.product.promotePrice}</td>
                      <td>${oi.number}</td>
                     <td> ￥<fmt:formatNumber type="number" value="${oi.number*oi.product.promotePrice}" minFractionDigits="2"/></td>
                    </tr>
                    </c:forEach>

                  </tbody>
                </table>
              </div>
            </div>
            <hr class="mb-4">
            
            <button class="btn btn-primary btn-lg btn-block " type="submit">下单</button>
          </form>
          <div class="pb-5"></div>
        </div>
       
      </div>
    </div>
  </div>
  <%@include file="include/foot.jsp"%></body>

</html>