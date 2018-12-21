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
          <h1 class="display-4">编辑商品信息</h1>
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
          <ul class="breadcrumb">
            <li class="breadcrumb-item"> <a href="#">分类</a> </li>
            <li class="breadcrumb-item active" ><a >产品管理</a></li>
            <li class="breadcrumb-item active">编辑商品</li>
          </ul>
          <div class="card mb-4 box-shadow">
            <div class="card-header">
              <h4 class="my-0 font-weight-normal">编辑商品信息</h4>
            </div>
            <div class="card-body text-center">
              <form id="c_form-h" class=""  action="admin_product_update">
                <div class="form-group row"> <label for="inputmailh" class="col-2 col-form-label">商品名称</label>
                  <div class="col-10">
                    <input name="name" type="text" class="form-control" id="inputmailh" placeholder="商品名称" value="${p.name}"> </div>
                </div>
                <div class="form-group row"> <label for="inputpasswordh" class="col-2 col-form-label">商品小标题</label>
                  <div class="col-10">
                    <input name="subTitle" type="text" class="form-control" id="inputpasswordh" placeholder="小标题" ${p.subTitle}> </div>
                </div>
                <div class="form-group row"> <label for="inputpasswordh" class="col-2 col-form-label">价格</label>
                  <div class="col-10">
                    <input  name="promotePrice" type="text" class="form-control" id="inputpasswordh" placeholder="价格" value="${p.promotePrice}"> </div>
                </div>
                <div class="form-group row"> <label for="inputpasswordh" class="col-2 col-form-label">库存</label>
                  <div class="col-10">
                    <input name="stock" type="text" class="form-control" id="inputpasswordh" placeholder="库存" value="${p.stock}"> </div>
                </div>
                <input type="hidden" name="id" value="${p.id}">
						<input type="hidden" name="cid" value="${p.category.id}">
                <button type="submit" class="btn btn-primary">提交</button>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <%@include file="../include/admin/footer.jsp"%>
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  <pingendo onclick="window.open('https://pingendo.com/', '_blank')" style="cursor:pointer;position: fixed;bottom: 20px;right:20px;padding:4px;background-color: #00b0eb;border-radius: 8px; width:220px;display:flex;flex-direction:row;align-items:center;justify-content:center;font-size:14px;color:white">Made with Pingendo Free&nbsp;&nbsp;<img src="https://pingendo.com/site-assets/Pingendo_logo_big.png" class="d-block" alt="Pingendo logo" height="16"></pingendo>
</body>

</html>