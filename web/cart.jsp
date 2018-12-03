<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" type="text/css" media="screen" href="include\css\main.css" />
<script src="include/js/jquery.min.js"></script>

<script src="include/js/list.js">
</script>
</head>
<body>
<form action="${contextPath}/forebuy"  method="post">

<c:forEach items="${cartlist}"  var="cart" varStatus="st">
   productId ${cart.productId}
   userId ${cart.userId}
   status ${cart.status}
<br>
<div>

<input type="checkbox" selectit="false" oiid="cart.id" class="productIdSelect" name="productId" value="${cart.productId}">
<input type="number" pid="${cart.productId}"  class="orderItemNumber" name="amoun" value="${cart.number}">

</div>
    ${cart.product.name}<br>
    ${cart.product.price}<br>
   <br>
   <span class="orderItemPromotePrice" pid="${cart.product.id}">${cart.product.price}</span>
   <span class="cartProductItemSmallSumPrice" oiid="${cart.id}" pid="${cart.product.id}" >
￥<fmt:formatNumber  type="number" value="${cart.product.price*cart.number}" minFractionDigits="2"/>
</span>
<br>
<br>
</c:forEach>
<div>

<input type="submit" class="createOrderButton" value="购买">
</div>
</form>
</body>
</html>