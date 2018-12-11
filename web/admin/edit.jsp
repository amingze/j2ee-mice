<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<script src="../include/style/js/jquery.min.js"></script>
<script src="../include/style/js/ckeditor2/ckeditor.js"></script>

<meta charset="UTF-8">
<title>商品管理</title>
</head>
<body>

<textarea name="editor1"></textarea>
    <script>
        CKEDITOR.replace( 'editor1' );
    </script>
</body>
</html>