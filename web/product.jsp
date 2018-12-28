<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"  import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<%@include file="include/nav.jsp"%>
<%@include file="include/header.jsp"%>
<script>
 
$(function(){
    var stock = ${p.stock};
    $(".productNumberSetting").keyup(function(){
        var num= $(".productNumberSetting").val();
        num = parseInt(num);
        if(isNaN(num))
            num= 1;
        if(num<=0)
            num = 1;
        if(num>stock)
            num = stock;
        $(".productNumberSetting").val(num);
    });
     
    $(".increaseNumber").click(function(){
        var num= $(".productNumberSetting").val();
        num++;

        $(".productNumberSetting").val(num);
    });
    $(".decreaseNumber").click(function(){
        var num= $(".productNumberSetting").val();
        --num;
        if(num<=0)
            num=1;
        $(".productNumberSetting").val(num);
    });
     
    $(".addCartButton").removeAttr("disabled");
    $(".addCartLink").click(function(){
        var page = "forecheckLogin";
        $.get(
                page,
                function(result){
                    if("success"==result){
                        var pid = ${p.id};
                        var num= $(".productNumberSetting").val();
                        var addCartpage = "foreaddCart";
                        $.get(
                                addCartpage,
                                {"pid":pid,"num":num},
                                function(result){
                                    if("success"==result){
                                        $(".addCartButton").val("已加入购物车");
                                        $(".addCartButton").attr("disabled","disabled");
                                        $(".addCartButton").css("background-color","lightgray")
                                        $(".addCartButton").css("border-color","lightgray")
                                        $(".addCartButton").css("color","black")
                                         
                                    }
                                    else{
                                         
                                    }
                                }
                        );                          
                    }
                    else{
                        $("#loginModal").modal('show');                     
                    }
                }
        );      
        return false;
    });
    $(".buyLink").click(function(){
        var page = "forecheckLogin";
        $.get(
                page,
                function(result){
                    if("success"==result){
                        var num = $(".productNumberSetting").val();
                        location.href= $(".buyLink").attr("href")+"&num="+num;
                    }
                    else{
                        $("#loginModal").modal('show');                     
                    }
                }
        );      
        return false;
    });
     
    $("button.loginSubmitButton").click(function(){
        var name = $("#name").val();
        var password = $("#password").val();
         
        if(0==name.length||0==password.length){
            $("span.errorMessage").html("请输入账号密码");
            $("div.loginErrorMessageDiv").show();           
            return false;
        }
         
        var page = "foreloginAjax";
        $.get(
                page,
                {"name":name,"password":password},
                function(result){
                    if("success"==result){
                        location.reload();
                    }
                    else{
                        $("span.errorMessage").html("账号密码错误");
                        $("div.loginErrorMessageDiv").show();                       
                    }
                }
        );          
         
        return true;
    });
     
    $("img.smallImage").mouseenter(function(){
        var bigImageURL = $(this).attr("bigImageURL");
        $("img.bigImg").attr("src",bigImageURL);
    });
     
    $("img.bigImg").load(
        function(){
            $("img.smallImage").each(function(){
                var bigImageURL = $(this).attr("bigImageURL");
                img = new Image();
                img.src = bigImageURL;
                 
                img.onload = function(){
                    $("div.img4load").append($(img));
                };
            });     
        }
    );
});
 
</script>
<body>
  <!-- Navbar -->
  
  <!-- Cover -->
  <!-- Intro -->
  <!-- Gallery -->
  <!-- Menu -->
  <!-- Carousel reviews -->
  <div class="p-5 text-center photo-overlay" style="background-image: url(&quot;include/style/assets/restaurant/testimonal_background_dark.jpg&quot;);">
    <div class="container">
      <div class="row">
        <div class="col-12">
          <div class="carousel slide" data-ride="carousel" id="carouselArchitecture">
            <div class="carousel-inner" role="listbox">


              <div class="carousel-item active">
                <img class="d-block img-fluid rounded-circle mx-auto" src="include/style/assets/restaurant/testimonial_3_dark.jpg" data-holder-rendered="true" width="200">
                <p class="my-3">请放心<br>这是一个不正规的店铺</p> <i class="fa fa-star d-inline"></i><i class="fa fa-star mx-1 d-inline"></i><i class="fa fa-star d-inline"></i><i class="fa fa-star-half-o mx-1 d-inline"></i><i class="fa fa-star-o d-inline"></i>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- Carousel venue -->
  <div class="py-3" id="venue">
    <div class="container">
      <div class="row my-5 bg-primary animate-in-down">
        <div class="p-4 col-md-6 align-self-center">
          <h2 class="">${p.name}</h2>
          <h5 >${p.subTitle} </h5>
           <a class="btn btn-primary increaseNumber" >
           <i class="fa fa-star fa-fw fa-1x py-1">+</i></a>
           <input type="text" value="1" class="productNumberSetting btn btn-light " ></a>
           <a class="decreaseNumber btn btn-primary"  >
           <i class=" fa fa-star fa-fw fa-1x py-1">-</i></a>
          <p class="my-3">销量:${p.saleCount }</p>
          <p class="my-3">评价: ${p.reviewCount}</p>
          <h3 class="">￥${p.promotePrice}&nbsp;<span class="badge badge-light"> New</span></h3>
          <a href="forebuyone?pid=${p.id}" class="buyLink btn-outline-light mb-3 p-2 btn">
          <input type="button" style="background:rgb(27, 32, 33);border:none;color:rgb(248, 249, 250)" value="购买">
          </a>
          
          <a href="#" class="addCartLink btn-outline-light mb-3 p-2 btn ">
          <input class="addCartButton" type="button" style="background:rgb(27, 32, 33);border:none;color:rgb(248, 249, 250)" value="加入购物车"></a>
        </div>
        <div class="p-0 col-md-6">
          <div class="carousel slide" data-ride="carousel" id="carousel1">
           <div class="carousel-inner" role="listbox">
           <c:forEach items="${p.productSingleImages}" var="pi" varStatus="ps">
            <c:if test="${ps.count<=1}">
              <div class="carousel-item active">
                <img class="d-block img-fluid w-100" src="img/productSingle/${pi.id}.jpg" atl="first slide">
                <div class="carousel-caption">
                  <h3>${p.name}</h3>
                  <p>${p.subTitle}</p>
                </div>
              </div>
             </c:if>
             <c:if test="${ps.count>1}">
              <div class="carousel-item">
                <img class="d-block img-fluid w-100" src="img/productSingle/${pi.id}.jpg" data-holder-rendered="true">
                <div class="carousel-caption">
                  <h3>${p.name}</h3>
                  <p>${p.subTitle}</p>
                </div>
              </div>
             </c:if>
              </c:forEach>
              
              


            </div>
            <a class="carousel-control-prev" href="#carousel1" role="button" data-slide="prev"> <span class="carousel-control-prev-icon" aria-hidden="true"></span> <span class="sr-only">Previous</span> </a>
            <a class="carousel-control-next" href="#carousel1" role="button" data-slide="next"> <span class="carousel-control-next-icon" aria-hidden="true"></span> <span class="sr-only">Next</span> </a>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="py-5 text-center" id="menu">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <ul class="nav nav-pills">
            <li class="nav-item">
             <a href="" class="nav-link active show" data-toggle="pill" data-target="#tabone">商品详情</a> </li>
            <li class="nav-item"> 
            <a class="nav-link" href="" data-toggle="pill" data-target="#tabtwo">评价</a> </li>
          </ul>
          <div class="tab-content mt-2">
            <div class="tab-pane fade active show" id="tabone" role="tabpanel">
              <p class="">${p.edit}</p>
            </div>
            <div class="tab-pane fade show" id="tabtwo" role="tabpanel">
              <p class="">
<c:forEach items="${reviews}" var="r">
		<div class="card pb-0 mb-1">
            <div class="card-header text-body bg-primary">${r.user.name}
            </div>
            <div class="card-body mb-1 py-2" >
              <h4 class="pb-0 mb-0">${r.content }</h4>
            </div>
        </div>
</c:forEach>
				</p>
            </div>
            
          </div>
        </div>
      </div>
    </div>
  </div>
  
  
     
  <!-- Events -->
  <!-- Dark opaque section -->
  <!-- Footer -->
  <%@include file="include/foot.jsp"%></body>









