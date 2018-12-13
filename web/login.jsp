<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@include file="include/part/head.jsp"%>
<%@include file="include/part/header.jsp"%>
    <link rel="stylesheet" href="include/style/css/login.css" />
    <%-- <link rel="stylesheet" href="include/style/css/register.css" /> --%>
<%-- 
<form action="${contextPath}/forelogin" method="post" enctype="application/x-www-form-urlencoded">
	账号:<input type="text" name="name"><br>
	密码:<input type="password" name="passwd"><br>
	<input type="submit"  value ="login">
	<p>${status}</p>
</form> --%>


<div id="login">
            <form action="${contextPath}/forelogin" method="post" enctype="application/x-www-form-urlencoded">
                <input type="text" required placeholder="用户名" name="name">
                <input type="password" required placeholder="密码" name="passwd"> 
                <input class="denglu" type="submit" value="登陆">
                <button class="zhuce" type="button"><a href="register.jsp">注册</a></button>
            </form>
</div>