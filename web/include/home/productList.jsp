<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>


<div class="background"></div>
    <div class="bd">
        <div class="bd-logo" style="background-image: url(include/style/img/1.jpg);"></div>
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