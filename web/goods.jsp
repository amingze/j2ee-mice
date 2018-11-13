<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品</title>
</head>
<body>
<c:forEach items="${goodslist}" var="goods" varStatus="st">
	<a href="goods/goods=${goods.id}">${goods.name}</a>
	<p>${goods.price}</p>
</c:forEach>

</body>
</html>