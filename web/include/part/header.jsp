<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<script>
window.onload=function(){
    if($("#name").text()!=""){
        $(".statusBlock").css("display","none");
        $(".statusNone").css("display","block");
    }
}
</script>
<header>
    <div class="header-mid">
        <nav>
            <ul class="hd-left">
                <li><a href="${contextPath}/forehome">首页</a></li>
                <li><a>分类</a></li>
                <li id="paper" style="display:none" class="statusNone"><a href="${contextPath}/foreshowOrder">个人中心</a></li>
            </ul>
            <ul class="hd-right">
                <li id="cart" style="display:none" class="statusNone"><a  href="${contextPath}/forecart">购物车</a></li>
                <li id="name"><a>${userBean.name }</a><li>
                <li id="login" class="statusBlock"><a  href="${contextPath}/login.jsp">登录</a></li>
                <li id="register" class="statusBlock"> <a href="${contextPath}/register.jsp">注册</a></li>
                <li id="logout" style="display:none"  class="statusNone"> <a href="${contextPath}/forelogout">登出</a></li>

            </ul>
        </nav>
    </div>
</header>
<div style="height:50px"></div>
