<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" type="text/css" media="screen" href="include\css\main.css" />

</head>
<body>
<form action="${contextPath}/forebuy" method="post">

<c:forEach items="${cartlist}" var="cart" varStatus="st">
   productId ${cart.productId}
   userId ${cart.userId}
    
   status ${cart.status}
<br>
<div>

<input type="checkbox"  name="productId" value="${cart.product.id}">
<input type="number"  name="amoun" value="${cart.number}">

</div>
    ${cart.product.name}<br>
    ${cart.product.price}<br>
   <br>
</c:forEach>
<div>
<input type="submit" value="购买">
</div>
</form>
</body>
</html>