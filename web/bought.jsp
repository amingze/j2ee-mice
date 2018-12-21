



<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@include file="include/header.jsp"%>

<%@include file="include/nav.jsp"%>

<!DOCTYPE html>
<html>
<body class="bg-light">

<div class="  photo-overlay py-5 cover" style="background-image: url(&quot;include/style/assets/restaurant/cover_dark.jpg&quot;);">
  <div class="pt-5 text-center" style="		background-position: top left;	background-size: 100%;	background-repeat: repeat;">
    <div class="container">
      <div class="row">
        <div class="col-md-9 mx-auto">
          <p class="lead">您的订单会显示在这里.</p>
        </div>
      </div>
    </div>
  </div>
  <div class="text-center">
    <div class="container">
      <div class="row pt-4" style="color:rgb(255,255,255);">

      <c:forEach items="${os}" var="o">
        <div class="col-md-12" style="">
          <div class="card mb-4 box-shadow " style="color:rgb(255,255,255);" >
            <div class="card-header">
            
              <h6 class="mb-0 text-left  text-white"  style=""><fmt:formatDate value="${o.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/> 订单号: ${o.orderCode} </h6>
            </div>
            <c:forEach items="${o.orderItems}" var="oi" varStatus="st">
            <div class="card-body">
              <div class="row">
                <div class="col-md-2" style="">
                <img class="img-fluid d-block" src="img/productSingle/${oi.product.firstProductImage.id}.jpg"></div>
                <div class="col-md-8" style="">
                <a  href="foreproduct?pid=${oi.product.id}">
                  <h5 class="text-left" >${oi.product.name}</h5></a>
                </div>
                <div class="col-md-2" style="">
                  <h4 class="">
                  ￥<fmt:formatNumber type="number" value="${oi.product.promotePrice}" minFractionDigits="2"/>
                  </h4>
                  <h4 class="" style="color:rgb(255,255,255);">
                  共  ${o.totalNumber} 件
                  </h4>
                  <c:if test="${o.status=='waitPay' }">
	                  <a class="btn text-white btn-block" href="forealipay?oid=${o.id}&total=${o.total}" style="background:#55acee" target="_blank">
	                  	<i class="fa fa-twitter fa-fw fa-1x py-1 hidden-sm"></i>待付款
	                  </a>
                  </c:if>
                  <c:if test="${o.status=='waitConfirm' }">
                   <a class="btn text-white btn-block" href="foreconfirmPay?oid=${o.id}" style="background:#55acee" target="_blank">
	                  	<i class="fa fa-twitter fa-fw fa-1x py-1 hidden-sm"></i>确认收货
	                  </a>
                  </c:if>
                <c:if test="${o.status=='waitDelivery' }">
                	                  <a class="btn text-white btn-block" href="#" style="background:#55acee" target="_blank">
	                  	<i class="fa fa-twitter fa-fw fa-1x py-1 hidden-sm"></i>待发货
	                  </a>
                </c:if>
                <c:if test="${o.status=='waitReview' }">
                  <a class="btn text-white btn-block" href="forereview?oid=${o.id}" style="background:#ff4500" target="_blank">
                  <i class="fa fa-reddit fa-fw fa-1x py-1 hidden-sm"></i>待评价
                  </a>
                 </c:if>
                </div>
              </div>
            </div>
            </c:forEach>
				<div class="card-footer text-white" contenteditable="true" > 共计:${o.total}元</div>
          </div>
        </div>
       </c:forEach>
      </div>
    </div>
  </div>
  <div class="py-5">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <div class="card text-center">
            <div class="card-header  text-white" style=""> 推荐</div>
            <div class="card-body">
              <h5 class="card-title">精选好货</h5>
              <p class="card-text text-muted">我们有更多好商品等着您来选购</p>
              <a href="#" class="btn btn-primary">更多商品</a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  </div>
  <%@include file="include/foot.jsp"%>

</body>

</html>