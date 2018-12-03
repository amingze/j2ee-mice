var deleteOrderItem = false;
var deleteOrderItemid = 0;
$(function(){
    $(".createOrderButton").click(function(){
        var params = "";
        $(".productIdSelect").each(function(){
            if("selectit"==$(this).attr("selectit")){
                var oiid = $(this).attr("oiid");
                params += "&oiid="+oiid;
            }
        });
        params = params.substring(1);
        location.href="forebuy?"+params;
    });

$(".orderItemNumber").on("input propertychange",function(){
    var pid=$(this).attr("pid");
   var price= $(".orderItemPromotePrice[pid="+pid+"]").text();
 
        var num= $(".orderItemNumber[pid="+pid+"]").val();
        num = parseInt(num);
        if(isNaN(num))
            num= 1;
        if(num<=0)
            num = 1;
         
        syncPrice(pid,num,price);
})
     $(".orderItemNumber").keyup(function(){
        var pid=$(this).attr("pid");
        var num= $(".orderItemNumber[pid="+pid+"]").val();
        num = parseInt(num);
        if(isNaN(num))
            num= 1;
        if(num<=0)
            num = 1;
         
        syncPrice(pid,num,price);
    });
})

function syncPrice(pid,num,price){
    $(".orderItemNumber[pid="+pid+"]").val(num);
    var cartProductItemSmallSumPrice = num*price;
    $(".cartProductItemSmallSumPrice[pid="+pid+"]").html("￥"+cartProductItemSmallSumPrice);
     
    var page = "forechangeOrderItem";

 
}