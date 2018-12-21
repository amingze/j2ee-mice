
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>

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
          <h1 class="display-4">商品列表</h1>
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
            <li class="breadcrumb-item"> <a href="admin">Mice后台</a> </li>
            <li class="breadcrumb-item active">产品管理</li>
 
          </ul>
          <div class="card mb-4 box-shadow">
            <div class="card-header">
              <h4 class="my-0 font-weight-normal">分类列表</h4>
            </div>
            <div class="card-body text-center">
              <div class="table-responsive">
                <table class="table table-striped table-borderless">
                  <thead>
                    <tr>
                      <th scope="col">#</th>
                      <th scope="col">图片</th>
                      <th scope="col">名称</th>
                      <th scope="col">操作</th>
                    </tr>
                  </thead>
                  <tbody>
                  <c:forEach items="${ps}" var="p">
                    <tr>
                      <th scope="row">1</th>
                      <td><br><img width="40px" src="img/productSingle/${p.firstProductImage.id}.jpg"></i></td>
                      <td>名称:${p.name}<br>价格:￥${p.promotePrice}<br>库存:${p.stock}</td> 
                      <td>
                        <ul class="list-group list-group-flush">
                        <a href="admin_productImage_list?pid=${p.id}">
                          <li class="list-group-item"><i class="fa fa-cloud text-primary mr-2"></i>图片管理</li>
                          </a>
                          <a href="admin_product_edit?id=${p.id}">
                          	<li class="list-group-item"><i class="fa fa-bookmark text-primary mr-2"></i>编辑商品</li>
                          </a>
                          <a deleteLink="true"
							href="admin_product_delete?id=${p.id}">
                          <li class="list-group-item"><i class="fa fa-paper-plane text-primary mr-2"></i><span style="font-size: 1rem; text-align: center;">删除商品</span></li>
                        </a>
                        </ul>
                      </td>
                    </tr>
                    </c:forEach>
                   
                    
                  </tbody>
                </table>
              </div>
              <ul class="pagination mx-auto" style="width:200px">
                <li class="page-item"> <a class="page-link" href="#"> <span>«</span></a> </li>
                <li class="page-item active"> <a class="page-link" href="#">1</a> </li>
                <li class="page-item"> <a class="page-link" href="#">2</a> </li>
                <li class="page-item"> <a class="page-link" href="#">3</a> </li>
                <li class="page-item"> <a class="page-link" href="#">4</a> </li>
                <li class="page-item"> <a class="page-link" href="#"> <span>»</span></a> </li>
              </ul>
            </div>
          </div>
          <form method="post" id="addForm" action="admin_product_add">
          <div class="col-md-12 text-center">
            <div class="card text-center">
              <div class="card-header"> 添加商品</div>
              <div class="card-body text-center">
                <h5 class="card-title text-center">商品名称</h5>
                
                  <div class="input-group text-center">
                  </div>
                
                <div class="form-group">
                <input type="text"  name="name" class="form-control text-center mx-auto" id="inlineFormInputGroup" placeholder="Search">
                  <div class="form-group"><label>标题</label>
                  <input type="text" name="subTitle"  class="form-control text-center mx-auto" id="inlineFormInputGroup" placeholder="Search">
                    <div class="form-group"><label>价格</label>
                    <input type="text" 	name="promotePrice" class="form-control text-center mx-auto" id="inlineFormInputGroup" placeholder="Search">
                      <div class="form-group">
                      <label>库存</label>
                      
                      <input type="text" name="stock" class="form-control text-center mx-auto" id="inlineFormInputGroup" placeholder="Search"></div>
                  <input type="hidden" name="cid" value="${c.id}">
                    </div>
                  </div>
                </div>
                <button type="submit" class="btn btn-lg btn-block btn-primary">提交</button>
              </div>
              <div class="card-footer text-muted"></div>
            </div>
          </div>
          </form>
        </div>
      </div>
    </div>
  </div>

  <%@include file="../include/admin/footer.jsp"%>
</body>

</html>