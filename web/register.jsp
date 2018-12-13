<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@include file="include/part/head.jsp"%>
<%@include file="include/part/header.jsp"%>
<%-- <form action="${contextPath}/foreregister" method="post" enctype="application/x-www-form-urlencoded">
	账号:<input type="text" name="name"><br>
	密码:<input type="password" name="passwd"><br>
	<input type="submit"  value ="注册">
	<p>${status}</p>
			</form> --%>

    <link rel="stylesheet" href="include/style/css/register.css" />
<body>
<div id="login1">
			<form action="${contextPath}/foreregister" method="post" enctype="application/x-www-form-urlencoded">
				<a>用户名:</a>
				<input type="text" name="name"></input>
				<a> 密码:</a>
				<input type="password" name="passwd"></input>
				<%-- <a>确认密码:</a>
				<input type="password" required></input> --%>
				<input class="tijiao" type="submit"  value ="注册">
<p>${status}</p>
</form>
</div>
</body>