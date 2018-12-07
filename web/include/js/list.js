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
        if ($(this).checked) {
            
        }
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
 