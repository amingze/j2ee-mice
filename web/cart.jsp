<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"  import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="include/header.jsp"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- PAGE settings -->

  <title>Restaurant Elegant - Pingendo template</title>
  <meta name="description" content="Free Bootstrap 4 Pingendo Elegant template for restaurant and food">
  <meta name="keywords" content="Pingendo restaurant food elegant free template bootstrap 4">
  <!-- CSS dependencies -->

  <!-- Script: Make my navbar transparent when the document is scrolled to top -->

  <!-- Script: Animated entrance -->

  
</head>
<%@include file="include/header.jsp"%>
<%@include file="include/nav.jsp"%>
<body>
	<script>
var deleteOrderItem = false;
var deleteOrderItemid = 0;
$(function(){

//	$(".deleteOrderItem").click(function(){
//		deleteOrderItem = false;
//		var oiid = $(this).attr("oiid")
//		deleteOrderItemid = oiid;
//	});
	$(".deleteConfirmButton").click(function(){
		deleteOrderItem = true;
		$("#deleteConfirmModal").modal('hide');
	});
	
	$('.deleteOrderItem').click(function(){
		var oiid = $(this).attr("oiid")
		deleteOrderItemid = oiid;
			var page="foredeleteOrderItem";
			$.post(
				    page,
				    {"oiid":deleteOrderItemid},
				    function(result){
						if("success"==result){
							$(".cartProductItemTR[oiid="+deleteOrderItemid+"]").hide();
						}
						else{
							location.href="login.jsp";
						}
				    }
				);
			
		
	})	
	
	$(".cartProductItemIfSelected").click(function(){
		var selectit = $(this).attr("selectit")
		if("selectit"==selectit){
			$(this).attr("src","img/site/cartNotSelected.png");
			$(this).attr("selectit","false")
		//	$(this).parents(".cartProductItemTR").css("background-color","#fff");
		}
		else{
			$(this).attr("src","img/site/cartSelected.png");
			$(this).attr("selectit","selectit")
			//$(this).parents("tr.cartProductItemTR").css("background-color","#FFF8E1");
		}
		syncSelect();
		syncCreateOrderButton();
		calcCartSumPriceAndNumber();
	});
	$(".selectAllItem").click(function(){
		var selectit = $(this).attr("selectit")
		if("selectit"==selectit){
			$(".selectAllItem").attr("src","img/site/cartNotSelected.png");
			$(".selectAllItem").attr("selectit","false")
			$(".cartProductItemIfSelected").each(function(){
				$(this).attr("src","img/site/cartNotSelected.png");
				$(this).attr("selectit","false");
				//$(this).parents(".cartProductItemTR").css("background-color","#fff");
			});			
		}
		else{
			$(".selectAllItem").attr("src","img/site/cartSelected.png");
			$(".selectAllItem").attr("selectit","selectit")
			$(".cartProductItemIfSelected").each(function(){
				$(this).attr("src","img/site/cartSelected.png");
				$(this).attr("selectit","selectit");
				//$(this).parents(".cartProductItemTR").css("background-color","#FFF8E1");
			});				
		}
		syncCreateOrderButton();
		calcCartSumPriceAndNumber();
		

	});
	
	$(".orderItemNumberSetting").keyup(function(){
		var pid=$(this).attr("pid");
		var stock= $(".orderItemStock[pid="+pid+"]").text();
		var price= $(".orderItemPromotePrice[pid="+pid+"]").text();
		
		var num= $(".orderItemNumberSetting[pid="+pid+"]").val();
		num = parseInt(num);
		if(isNaN(num))
			num= 1;
		if(num<=0)
			num = 1;
		if(num>stock)
			num = stock;
		
		syncPrice(pid,num,price);
	});

	$(".numberPlus").click(function(){
		
		var pid=$(this).attr("pid");
		var stock= $(".orderItemStock[pid="+pid+"]").text();
		var price= $(".orderItemPromotePrice[pid="+pid+"]").text();
		var num= $(".orderItemNumberSetting[pid="+pid+"]").val();

		num++;
		if(num>stock)
			num = stock;
		syncPrice(pid,num,price);
	});
	$(".numberMinus").click(function(){
		var pid=$(this).attr("pid");
		var stock= $(".orderItemStock[pid="+pid+"]").text();
		var price= $(".orderItemPromotePrice[pid="+pid+"]").text();
		
		var num= $(".orderItemNumberSetting[pid="+pid+"]").val();
		--num;
		if(num<=0)
			num=1;
		syncPrice(pid,num,price);
	});	
	
	$(".createOrderButton").click(function(){
		var params = "";
		$(".cartProductItemIfSelected").each(function(){
			if("selectit"==$(this).attr("selectit")){
				var oiid = $(this).attr("oiid");
				params += "&oiid="+oiid;
			}
		});
		params = params.substring(1);
		location.href="forebuy?"+params;
	});
	
	
	
})

function syncCreateOrderButton(){
	var selectAny = false;
	$(".cartProductItemIfSelected").each(function(){
		if("selectit"==$(this).attr("selectit")){
			selectAny = true;
		}
	});
	
	if(selectAny){
		//$(".createOrderButton").css("background-color","#C40000");
		$(".createOrderButton").removeAttr("disabled");
	}
	else{
		//$(".createOrderButton").css("background-color","#AAAAAA");
		$(".createOrderButton").attr("disabled","disabled");		
	}
		
}
function syncSelect(){
	var selectAll = true;
	$(".cartProductItemIfSelected").each(function(){
		if("false"==$(this).attr("selectit")){
			selectAll = false;
		}
	});
	
	if(selectAll)
		$("img.selectAllItem").attr("src","img/site/cartSelected.png");
	else
		$("img.selectAllItem").attr("src","img/site/cartNotSelected.png");
	
	
	
}
function calcCartSumPriceAndNumber(){
	var sum = 0;
	var totalNumber = 0;
	$("img.cartProductItemIfSelected[selectit='selectit']").each(function(){
		var oiid = $(this).attr("oiid");
		var price =$(".cartProductItemSmallSumPrice[oiid="+oiid+"]").text();
		price = price.replace(/,/g, "");
		price = price.replace(/￥/g, "");
		sum += new Number(price);	
		
		var num =$(".orderItemNumberSetting[oiid="+oiid+"]").val();
		totalNumber += new Number(num);	
		
	});
	
	$(".cartSumPrice").html("￥"+formatMoney(sum));
	$(".cartTitlePrice").html("￥"+formatMoney(sum));
	$(".cartSumNumber").html(totalNumber);
}
function syncPrice(pid,num,price){
	$(".orderItemNumberSetting[pid="+pid+"]").val(num);
	var cartProductItemSmallSumPrice = formatMoney(num*price); 
	$(".cartProductItemSmallSumPrice[pid="+pid+"]").html("￥"+cartProductItemSmallSumPrice);
	calcCartSumPriceAndNumber();
	
	var page = "forechangeOrderItem";
	$.post(
		    page,
		    {"pid":pid,"number":num},
		    function(result){
				if("success"!=result){
					location.href="login.jsp";
				}
		    }
		);

}
</script>
  <!-- Navbar -->
  <%@include file="include/nav.jsp"%>
  <!-- Cover -->
  <div class="align-items-center d-flex photo-overlay py-5 cover" style="background-image: url(&quot;include/style/assets/restaurant/cover_dark.jpg&quot;);">
    <div class="container">
      <div class="row">
        <div class="col-lg-12 p-3">
         
            <h4 class="mb-4 text-center">购物车</h4>
            <div class="table-responsive">
              <a class="btn btn-primary" href="#" contenteditable="true">
              <i class="fa fa-star fa-fw fa-1x py-1">+</i></a>
              <a class="btn btn-primary" href="#">
              <i class="fa fa-star fa-fw fa-1x py-1">1</i></a>
              <a class="btn btn-primary" href="#">
              <i class="fa fa-star fa-fw fa-1x py-1">-</i></a>
              <table class="table" style="text-align: center;">
                <thead>
                  <tr>
                    <th>全选</th>
                    <th contenteditable="true">图片</th>
                    <th>名称</th>
                    <th>单价</th>
                    <th>数量</th>
                    <th>金额</th>
                    <th>操作</th>
                  </tr>
                </thead>
                <tbody>
                <c:forEach items="${ois }" var="oi">
                  <tr class="cartProductItemTR"  oiid="${oi.id}">
                    <td ><br><img selectit="false" oiid="${oi.id}" class="cartProductItemIfSelected" src="img/site/cartNotSelected.png"></td>
                    <td>
                    <img class="img-fluid d-block  mb-3 " style=" height:180px;width:150px;background-image: url(img/productSingle/${oi.product.firstProductImage.id}.jpg);background-size: cover;background-repeat: no-repeat;background-position: center;">
                    </td>
                    <td>>${oi.product.name}</td>
                    <td>￥${oi.product.promotePrice}</td>
                    <td><a  pid="${oi.product.id}" class="numberMinus text-light" >
                    -<i class="fa fa-star fa-fw fa-1x py-1">-</i></a>
                    <input pid="${oi.product.id}" oiid="${oi.id}" class="orderItemNumberSetting" style="width:30%;" autocomplete="off" value="${oi.number}">
                    <a  stock="${oi.product.stock}" pid="${oi.product.id}" class="text-light numberPlus" > 
                    <i class="fa fa-star fa-fw fa-1x py-1">+
                   </i></a>
                   <span class="hidden orderItemStock " pid="${oi.product.id}"></span>
                    </td>
                    <span class="hidden orderItemStock " pid="${oi.product.id}">${oi.product.stock}</span>
								<span class="hidden orderItemPromotePrice " pid="${oi.product.id}">${oi.product.promotePrice}</span>
                    <td>￥${oi.product.promotePrice*oi.number}</td>
                    <td ><button class="deleteOrderItem fa fa-star fa-fw fa-1x py-1" 	 oiid="${oi.id}" >删除</button>
                    </td>
                  </tr>
                  
                  </c:forEach>

                </tbody>
              </table>
            </div>
            <button type="submit" style="color:rgb(222, 226, 230)"  class="createOrderButton btn mt-4 btn-block btn-outline-primary p-2"><b>结算</b></button>
          
        </div>
      </div>
    </div>
  </div>
  <!-- Intro -->
  
    <%@include file="include/foot.jsp"%>
  <!-- JavaScript dependencies -->
    <!-- Script: Smooth scrolling between anchors in the same page -->

 </body>

</html>