<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>商品管理</title>
    <title>完整demo</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>

</head>
<body>
<p>----搜索----</p>
<form action="${contextPath}/admin_product_serch" method="get"  >
	商品名称:<input type="text" name="productName" >
	<input type="submit" value="搜索">
	${status}
</form>
<br>
<p>----添加----</p>
<form action="${contextPath}/admin_product_add" method="post" enctype='multipart/form-data' >
	商品名称:<input type="text" name="name">
	商品价格:<input type="number" name="price">
	<input id="fileId1" type="file" accept="image/png,image/gif" name="file"  />
	<input type="submit" value="添加">
	${status}
</form>
<br>
<p>----修改----</p>
<form action="${contextPath}/admin_product_updata" method="post">

<c:forEach items="${productList}" var="product" varStatus="st">
	<input type="radio" name="id" value="${product.id }">
	<img src="${contextPath}/admin_product_getimg?id=${product.id }.jpg">
	<a href="product/id=${product.id}">${product.name}</a>
	<a href="${contextPath}/admin_product_delete?id=${product.id} ">删除</a>
	<p>${product.price}</p>
</c:forEach>

	<input type="text" name="name">
	<input type="number" name="price">
	<input type="submit" value="修改">
	${status}
</form>
这里写你的初始化内容
<!-- 加载编辑器的容器 -->
 <script id="container" name="content" type="text/plain">
        
    </script>

    <!-- 配置文件 -->
    <script type="text/javascript" src="${contextPath}/admin/ueditor/ueditor.config.js"></script>
    <!-- 编辑器源码文件 -->
    <script type="text/javascript" src="${contextPath}/admin/ueditor/ueditor.all.js"></script>
    <!-- 实例化编辑器 -->
    <script type="text/javascript" charset="utf-8" src="${contextPath}/admin/ueditor/lang/zh-cn/zh-cn.js"></script>
    <script type="text/javascript" id="ed">
		var ue = UE.getEditor('container');
    </script>
	
<button onclick="getContent()">获得内容</button>
<script type="text/javascript">    
function getContent() {
        var arr = [];
        arr.push("使用editor.getContent()方法可以获得编辑器的内容");
        arr.push("内容为：");
        arr.push(UE.getEditor('container').getContent());
        alert(arr.join("\n"));
	}
	</script>

</body>
</html>