<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<%@include file="../include/admin/header.jsp"%>
<%@include file="../include/admin/nav.jsp"%>

<html>


<body class="bg-light">

  <div class="pt-5 text-center">
    <div class="container">
      <div class="row">
        <div class="col-md-9 mx-auto">
          <h1 class="display-4">编辑分类信息</h1>
        </div>
      </div>
    </div>
  </div>
  
  <div class="text-center" style="">
    <div class="container text-center">
      <div class="row pt-4 text-center">
        <div class="col-md-3" style="">
          <div class="card mb-4 box-shadow">
            <div class="card-header">
              <h4 class="my-0 font-weight-normal">菜单</h4>
            </div>
            <div class="card-body" style="">
              <ul class="list-group">
                 <a href="admin_category_list"><li class=" border-0 list-group-item d-flex justify-content-between align-items-center"> 分类管理<i class="fa fa-list text-muted fa-lg"></i></li></a>
                <a href="admin_user_list"><li class=" border-0 list-group-item d-flex justify-content-between align-items-center"> 用户管理<i class="fa fa-pie-chart text-muted fa-lg"></i></li></a>
                <a href="admin_order_list"><li class=" border-0 list-group-item d-flex justify-content-between align-items-center"> 订单管理<i class="fa fa-cog text-muted fa-lg"></i></li></a>
                <a href="admin_category_list"><li class=" border-0 list-group-item d-flex justify-content-between align-items-center"> 退出<i class="fa fa-sign-out text-muted fa-lg"></i></li></a>
              </ul>
            </div>
          </div>
          <div class="row">
          </div>
        </div>
        <div class="col-md-9 text-center" style="">
          <div class="row">
            <div class="col-md-12">
              <ul class="breadcrumb">
                            <li class="breadcrumb-item"> <a href="#">分类</a> </li>
            <li class="breadcrumb-item active" ><a >编辑分类</a></li>
  
              </ul>
            </div>
          </div>
          <div class="card text-center">
            <div class="card-header" contenteditable="true">编辑分类</div>
            <div class="card-body">
              <form method="post" id="editForm" action="admin_category_update"  enctype="multipart/form-data">
                <div class="form-group row"> <label for="inputmailh" class="col-2 col-form-label">分类名称</label>
                  <div class="col-10">
                    <input type="text" name="name" value="${c.name}"class="form-control" id="inputmailh"> </div>
                    <input type="hidden" name="id" value="${c.id}">
                </div>
                <div class="form-group row"> <label for="inputpasswordh" class="col-2 col-form-label">分类图片</label>
                  <div class="col-10">
                    <input id="categoryPic" accept="image/*" type="file" name="filepath" /> </div>
                </div>
                <button type="submit" class="btn btn-primary">提交</button>
              </form>
            </div>
            <div class="card-footer text-muted"> 2 days ago </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <%@include file="../include/admin/footer.jsp"%>
</body>

</html>