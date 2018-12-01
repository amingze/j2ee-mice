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


    <header>
    <div class="header-mid">
        <nav>
            <ul class="hd-left">
                <li><a>首页</a></li>
                <li><a>分类</a></li>
                <li><a>个人中心</a></li>
            </ul>
            <ul class="hd-right">
                <li><a  href="${contextPath}/forecart">购物车</a></li>
                <li><a>${user.name }</a><li>
                <li><a  href="${contextPath}/login.jsp">登录</a></li>
                <li> <a href="${contextPath}/register.jsp">注册</a></li>
                <li> <a href="${contextPath}/forelogout">登出</a></li>

            </ul>
        </nav>
    </div>
</header>

<div class="background"></div>
    <div class="bd">
        <div class="bd-logo" style="background-image: url(include/img/1.jpg);"></div>
        <div class="bd-list">

        <c:forEach items="${productlist}" var="product" varStatus="st">
            <div class="product">
                <div class="pd-img" style="background-image: url(${contextPath}/foreimg?id=${product.id }.jpg);"></div>
                <div class="pd-log">
                    <div class="pd-name">
                    <a href="${contextPath}/foreproduct?id=${product.id }">${product.name}</a>
                    </div>
                    <div class="pd-price">${product.price}</div>
                </div>
            </div>
        </c:forEach>
    </div>
        <div class="bd-back"></div>
</div>
<footer></footer>
</body>
</html>