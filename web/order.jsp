<%@include file="include/part/head.jsp"%>
<%@include file="include/part/header.jsp"%>

<c:forEach items="${orders}" var="order" varStatus="st">
    <c:forEach items="${order}" var="orderitem"> 
       ${orderitem.product.name} $${orderitem.product.price} 
    </c:forEach>
    <br>
</c:forEach>
