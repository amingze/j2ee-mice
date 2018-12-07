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
<c:forEach items="${orders}" var="order" varStatus="st">
    <c:forEach items="${order}" var="orderitem"> 
        ${orderitem.id} ${orderitem.product.name} ${orderitem.product.price} <br>
    </c:forEach>
    <br><br>
</c:forEach>
</body>
</html>