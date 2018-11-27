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
<c:forEach items="${productlist}" var="product" varStatus="st">
    <img src="${contextPath}/foreimg?id=${product.id }.jpg">
    <a href="${contextPath}/foreproduct?id=${product.id }">${product.name }</a>
    <a>${product.price }</a>
</c:forEach>

</body>
</html>