<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>用户注册</title>
</head>
<body>
<c:forEach items="${productlist}" var="product" varStatus="st">
    <img src="${contextPath}/foreimg?id=${product.id }.jpg">
    <a href="${contextPath}/foreproduct?id=${product.id }">${product.name }</a>
    <a>${product.price }</a>
</c:forEach>
</body>
</html>