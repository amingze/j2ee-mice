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
<script>

</script>
</head>
<body>


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
   <br>
   <span class="orderItemPromotePrice" pid="${cart.product.id}">${cart.product.price}</span>
   <span class="cartProductItemSmallSumPrice" oiid="${cart.id}" pid="${cart.product.id}" >
<%-- ￥<fmt:formatNumber  type="number" value="${cart.product.price*cart.number}" minFractionDigits="2"/> --%>
</span>
<br>
<br>
</c:forEach>
<div>

<button class="createOrder"  >结  算</button>
<%-- disabled="disabled" --%>
</div>

</body>
</html>