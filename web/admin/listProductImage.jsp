<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<%@include file="../include/admin/header.jsp"%>
<%@include file="../include/admin/nav.jsp"%>
<html>

<head>
  <meta charset="utf-8">

   <script>
$(function() {
	$(".postEditor").click(function(){
		var html = ue.getContent();
		$.post(
			"admin_productImage_edit",{"edit":html,"pid":${p.id} }
		);
	});
	
	
});
</script>
</head>

<body class="bg-light">

  <div class="pt-5 text-center">
    <div class="container">
      <div class="row">
        <div class="col-md-9 mx-auto">
          <h1 class="display-4">编辑商品详情</h1>
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
          <div class="col-md-12 text-center">
            <div class="card text-center">
            <form method="post" class="addFormSingle" action="admin_productImage_add" enctype="multipart/form-data">
              <div class="card-header" style=""> 添加商品图片</div>
              <div class="card-body text-center">
                <h5 class="card-title text-center">选择图片</h5>
               
                  <div class="input-group text-center">
                  <input id="filepathSingle" type="file" name="filepath" />
                  </div>
               <input type="hidden" name="type" value="type_single" />
				<input type="hidden" name="pid" value="${p.id}" />
                <div class="form-group">
                </div>
                <button type="submit" class="btn btn-lg btn-block btn-primary">提交</button>
              </div>
              </form>
            </div>
          </div>
        </div>
        <div class="col-md-9 text-center" style="">
          <ul class="breadcrumb">
            <li class="breadcrumb-item"> <a href="admin">分类</a> </li>
            <li class="breadcrumb-item active" ><a >产品管理</a></li>
            <li class="breadcrumb-item active">编辑商品详情</li>
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
                      <th scope="col">操作</th>
                    </tr>
                  </thead>
                  <tbody>
                  <c:forEach items="${pisSingle}" var="pi">
                    <tr>
                      <th scope="row">${pi.id}</th>
                      <td><br><img height="50px" src="img/productSingle/${pi.id}.jpg"></td>
                      <td>
                        <ul class="list-group my-3">
                        <a deleteLink="true" href="admin_productImage_delete?id=${pi.id}">
                          <li class="list-group-item d-flex justify-content-between align-items-center my-3"> 删除<i class="fa fa-list text-muted fa-lg"></i></li>
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
          <div class="card text-center" >
            <div class="card-header">产品说明编辑器</div>
            <div class="card-body">
     <!-- 加载编辑器的容器 -->
    <script id="container" name="content" type="text/plain">
        这里写你的初始化内容
    </script>
    <!-- 配置文件 -->
    <script type="text/javascript" src="admin/ueditor/ueditor.config.js"></script>
    <!-- 编辑器源码文件 -->
    <script type="text/javascript" src="admin/ueditor/ueditor.all.js"></script>
    <!-- 实例化编辑器 -->
    <script type="text/javascript">
 		
    	var ue = UE.getEditor('container');
    	ue.ready(function() {
    	    //设置编辑器的内容
    	    ue.setContent('${p.edit}');
    	    //获取html内容，返回: <p>hello</p>
    	    var html = ue.getContent();
    	    
    	    //获取纯文本内容，返回: hello
    	    var txt = ue.getContentTxt();
    	    
    	});
        
    </script>

              <button href="#" class="postEditor btn btn-primary">提交</button>
            </div>
            <div class="card-footer text-muted"> 2 days ago </div>
          </div>
        </div>
      </div>
    </div>
  </div>
      

 <%@include file="../include/admin/footer.jsp"%>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  
<script type="text/javascript">

      
    </script>
</body>

</html>