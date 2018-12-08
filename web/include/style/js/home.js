window.onload=function(){
    if(document.getElementById("name").innerText!=""){
        document.getElementsByClassName("statusBlock").style.display="none";
		document.getElementsByClassName("statusNone").style.display="block";
    }

};
$(function(){

	$(".buttonAddCart").click(function () { 
		var num=$(".productNum").val();
		var pid=$(".productId").attr("pid");

		num = parseInt(num);
		pid = parseInt(pid);
		$.post(
			"foreaddCart",
			{"pid":pid,"num":num}
		);

	});
})


