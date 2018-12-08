<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@include file="include/part/head.jsp"%>
<%@include file="include/part/header.jsp"%>
<form action="${contextPath}/forelogin" method="post" enctype="application/x-www-form-urlencoded">
	账号:<input type="text" name="name"><br>
	密码:<input type="password" name="passwd"><br>
	<input type="submit"  value ="login">
	<p>${status}</p>
</form>
