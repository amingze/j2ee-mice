<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>用户管理</title>
</head>
<body>
<table>
	<tr>
		<td>id</td>
		<td>name</td>
		<td>password</td>
		<td>create date</td>
		<td>操作<td>
	</tr>
<c:forEach items="${users}" var="user" varStatus="st">
	
	<tr>
		<td>${user.id}</td>
		<td>${user.name}</td>
		<td>${user.passwd}</td>
		<td>${user.creatDate}</td>
		<td><a href="delete_user?id=${user.id}">删除</a></td>
	</tr>
</c:forEach>
</table>
<a href="register.jsp">注册</a>
</body>
</html>