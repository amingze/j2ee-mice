<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
    <a>${user.name }</a>
    <a href="${contextPath}/forelogout">logout</a>
    <a href="${contextPath}/login.jsp">login</a>
    <a href="${contextPath}/register.jsp">register</a>
    <a>${name}</a>
    <a>${price}</a>
    <a>加入购物车</a>
    <form action="${contextPath}/foreaddCart" method="post" enctype="application/x-www-form-urlencoded">
        <input type="number" name="num" value="1">
        <input type="number" name="productId"  value="${productId}">
        <input type="submit"  value ="加入购物车">

    </form>
</body>
</html>