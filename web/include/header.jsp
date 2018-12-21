



<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 


<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- PAGE settings -->
  <title>Restaurant Elegant - Pingendo template</title>
  <!-- CSS dependencies -->
 
  <link rel="stylesheet" href="include/style/css/elegant.css" type="text/css">

  <!-- Script: Make my navbar transparent when the document is scrolled to top -->

  <!-- Script: Animated entrance -->

  <script src="include/style/js/navbar-ontop.js"></script>
  <script src="include/style/js/animate-in.js"></script>
  <script src="include/style/js/jquery/2.0.0/jquery.min.js"></script>
  

	<script src="include/style/js/bootstrap4.1.3.min.js"></script>
	<script src="include/style/js/popper.min.js"></script>
	<script src="include/style/js/smooth-scroll.js"></script>

 <!--   <link rel="stylesheet" href="include/style/css/bootstrap/3.3.6/bootstrap.css" type="text/css">-->
<script>

function formatMoney(num){
	num = num.toString().replace(/\$|\,/g,'');  
	if(isNaN(num))  
	    num = "0";  
	sign = (num == (num = Math.abs(num)));  
	num = Math.floor(num*100+0.50000000001);  
	cents = num%100;  
	num = Math.floor(num/100).toString();  
	if(cents<10)  
	cents = "0" + cents;  
	for (var i = 0; i < Math.floor((num.length-(1+i))/3); i++)  
	num = num.substring(0,num.length-(4*i+3))+','+  
	num.substring(num.length-(4*i+3));  
	return (((sign)?'':'-') + num + '.' + cents);  
}
function checkEmpty(id, name){
	var value = $("#"+id).val();
	if(value.length==0){
		
		$("#"+id)[0].focus();
		return false;
	}
	return true;
}


$(function(){

	
	$("a.productDetailTopReviewLink").click(function(){
		$("div.productReviewDiv").show();
		$("div.productDetailDiv").hide();
	});
	$("a.productReviewTopPartSelectedLink").click(function(){
		$("div.productReviewDiv").hide();
		$("div.productDetailDiv").show();		
	});
	
	$("span.leaveMessageTextareaSpan").hide();
	$("img.leaveMessageImg").click(function(){
		
		$(this).hide();
		$("span.leaveMessageTextareaSpan").show();
		$("div.orderItemSumDiv").css("height","100px");
	});

	

});

</script>	
</head>

<body>

