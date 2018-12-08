<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<script>
var deleteOrderItem = false;
var deleteOrderItemid = 0;
$(function(){
$(".orderItemNumber").keyup(function(){
    var oiid=$(this).attr("oiid");
    // var stock= $("orderItemStock[pid="+pid+"]").text();
    // var price= $("orderItemPromotePrice[pid="+pid+"]").text();
    var page="forechangeAmount";
    var num= $(".orderItemNumber[oiid="+oiid+"]").val();
    num = parseInt(num);
    if(isNaN(num))
        num= 1;
    if(num<=0)
        num = 1;
    $.post(
        page,
        {"orderItemId":oiid,"orderItemAmount":num},
    );
    
});
$(".selectOrderItem").each(
    function(){
   
    }
)
$(".buttonDeleteOrder").click(
    function () {
        var oiid=$(this).attr("oiid");
        var page="foredeleteCart";
        $.post(
            page,
            {"oiid":oiid},
        );
    }

)
$(".createOrder").click(
    function () {
        var params = "";
        $(".selectOrderItem").each(function(){
            if($(this).is(':checked')==true){
                var oiid = $(this).attr("oiid");
                params += "&oiid="+oiid;
            }
        });
        params = params.substring(1);
        location.href="forebuy?"+params;
    }
)

})

function setPost(oiid,price,num) {
    
} 
</script>
<c:forEach items="${cartlist}"  var="cart" varStatus="st">
   productId ${cart.productId}
   userId ${cart.userId}
   status ${cart.status}
<br>
<div>

<input type="checkbox" pid="${cart.productId}" selectit="false" oiid="${cart.id}" class="selectOrderItem" name="productId" value="${cart.productId}">
<input type="number" oiid="${cart.id}"  class="orderItemNumber" name="amoun" value="${cart.amount}">

</div>
    ${cart.product.name}<br>
    ${cart.product.price}<br>
    <button class="buttonDeleteOrder" oiid="${cart.id}">删除</button>
   <br>
   <span class="orderItemPromotePrice" pid="${cart.product.id}">${cart.product.price}</span>
   <span class="cartProductItemSmallSumPrice" oiid="${cart.id}" pid="${cart.product.id}" >
<%-- ￥<fmt:formatNumber  type="number" value="${cart.product.price*cart.number}" minFractionDigits="2"/> --%>
</span>
<br>

</c:forEach>
<div>

<button class="createOrder"  >结  算</button>
<%-- disabled="disabled" --%>
</div>