<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false"%>

<%@include file="include/part/head.jsp"%>
<%@include file="include/part/header.jsp"%>
<script>
// $(".buttonAddCart").click(function () { 
//     var num=$("#productNum").var
//     var id=$("#productId").var

//     $.post(
//         foreaddCart,
//         {"productId":id,"productAmount":num},
//     );
    
// });

</script>
<a>${name}</a>
<a>${price}</a>

<input type="number" name="productNum"  class="productNum" value="1">
<div type="number" name="productId" class="productId" value="${productId}" pid="${productId}">
<button class="buttonAddCart"  pid="${productId}" value ="${productId}">加入购物车</button>


