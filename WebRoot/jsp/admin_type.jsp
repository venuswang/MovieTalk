<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix=

"c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>后台管理员详情</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="管理员后台详情">
	<link href="./css/bootstrap.min.css" rel="stylesheet">
	<link href="./css/toastr.min.css" media="all" rel="stylesheet" type="text/css" />
	<link href="./css/font-awesome.css" rel="stylesheet">
    <!-- 当前项目样式文件 -->
    <link href="./css/sb-admin.css" rel="stylesheet">
    <link href="./css/sb-bk-theme.css" rel="stylesheet">
    <!--蓝鲸平台APP 公用的样式文件 -->
    
 	<link href="./css/bk.css?v=1.0.1" rel="stylesheet">

  </head>
  
  <body>
     <div id="wrapper">
        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="admin/admin_index">
                    <i class="fa fa-leaf f20 mr5"></i>
                    	后台管理系统
                </a>
            </div>
            <!-- Top Menu Items -->
            <ul class="nav navbar-right top-nav">
                <li class="dropdown">
                    <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" style="width:160px;">
                    	<i class="fa fa-user" style="padding-left:9px"></i> ${sessionScope.username} <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="admin/admin_login_out"><i class="fa fa-fw fa-power-off"></i> 退出</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <li>
                        <a href="admin/admin_index"><i class="fa fa-fw fa-dashboard"></i> 首页</a>
                    </li>
                    <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#demo"><i class="fa fa-fw fa-edit"></i> 信息设置 <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="demo" class="collapse out"> <!--  -->
                        	<li>
                                <a href="admin/admin_message">基本信息详情 </a>
                            </li>
                            <li>
                                <a href="admin/admin_message_edit">基本信息修改 </a>
                            </li>
                            <li>
                                <a href="admin/admin_pass_edit">密码修改</a>
                            </li>
                        </ul>
                    </li>
                    <li class="active">
                        <a href="javascript:;" data-toggle="collapse" data-target="#tag_demo"><i class="fa fa-fw fa-edit"></i> 影片标签设置 <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="tag_demo" class="collapse in">
                        	<li>
                                <a href="admin/admin_tag/1/10?tag_name=">影片标签详情 </a>
                            </li>
                            <li>
                                <a href="admin/admin_type/1/10?type_name=">影片类型详情 </a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="admin/admin_actor/1/10?actor_name="><i class="fa fa-fw fa-table"></i> 影片演员详情</a>
                    </li>
                    <li>
                        <a href="admin/admin_list/1/10?list_name="><i class="fa fa-fw fa-desktop"></i> 影片详情</a>
                    </li>
                    <!--  <li class="active">
                        <a href="admin/admin_message"><i class="fa fa-fw fa-edit"></i> 信息设置</a>
                    </li> 
                    <li>
                        <a href="tables.html"><i class="fa fa-fw fa-table"></i> 表格</a>
                    </li>
                    <li>
                        <a href="bootstrap-elements.html"><i class="fa fa-fw fa-desktop"></i> 排版</a>
                    </li>
                    <li>
                        <a href="bootstrap-grid.html"><i class="fa fa-fw fa-wrench"></i> Bootstrap 布局</a>
                    </li>-->
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </nav>
        <!-- start -->
		 <div id="page-wrapper">

            <div class="container-fluid">
                <div class="row page-header-box">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            	影片类型详情
                        </h1>
                    </div>
                </div>
                <!-- Page Heading -->
                <div class="panel panel-default">
                	<div class="panel-heading">
                		查询条件
                	</div>
                	<div class='panel-body'>  
                		<div class="row">
                		<form role="form" action="admin/admin_type/1/10">
                			<div class="col-sm-6 col-md-6 col-lg-4">
							            <div class="form-group">
							            	<div class="col-lg-1"></div>
							                <div class="input-group">
							                    <div class="input-group-addon">影片类型</div>
							                    <input class="form-control" type="text" id="type_name" name="type_name" value="${typeVO.filterParam}">
							                </div>
							            </div>
							</div>
                			<div class="col-lg-12">
                				<hr class="mt5 mb15">
                				<div class="col-lg-1"></div>
                				
	                				<button type="submit"  class="king-btn king-info">查询</button>	
	                				<button type="button" onclick="admin_type_clear()" class="king-btn king-success">重置</button>	
	                			
                			</div>
                			</form>
                		</div>
                	</div>
                </div>
                <!---->
                <div class="panel panel-default">
                	<div class="panel-heading" absolute="float">
                			影片类型详情&nbsp;&nbsp;&nbsp;
	                		<button type="button" onclick="admin_type_add()" class="king-btn king-info">添加类型</button>
                	</div>
                	<div class='panel-body'>
                        <div class="table-responsive">
                            <table class="table table-bordered table-hover table-striped">
                                <thead>
                                    <tr>
                                        <th>编号</th>
                                        <th>id</th>
                                        <th>类型</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tfoot>
                                    		<c:forEach items="${typeVO.mType}" var="type" varStatus="num">
	                                    	<tr>
                                    			<td>
                                    				${num.count + (typeVO.page - 1) * 10}
                                    			</td>
                                    			<td>
                                    				${type.id}
                                    			</td>
                                    			<td>
                                    				${type.typename}
                                    			</td>
                                    			<td>
                                    				<button type="button" onclick="type_edit(this)"  class="king-btn king-info">编辑</button>
                                    				<button type="button" onclick="type_delete(this)" class="king-btn king-fail">删除</button>
                                    			</td>
	                                    	</tr>
                                    		</c:forEach>
	                                    <tr>
		                                    <td colspan="4">
						                        <div class="pagination-info pull-left">共有${typeVO.count}条，每页显示：10条</div>
			                                	<div class="pull-right king-page-box">
						                            <ul class="pagination pagination-small pull-right">
						                              <c:choose>
						                              	<c:when test="${typeVO.page <= 1}">
						                              		<li class="disabled"><a>«</a></li>
						                              	</c:when>
						                              	<c:otherwise>
						                              		<li><a href="admin/admin_type/${typeVO.page - 1}/10?type_name=${typeVO.filterParam}">«</a></li>
						                              	</c:otherwise>
						                              </c:choose>
						                              <li><a href="admin/admin_type/1/10?type_name=${typeVO.filterParam}">第一页</a></li>
						                              <li class="active"><a>${typeVO.page}</a></li>
						                              <li><a href="admin/admin_type/${typeVO.pageCount}/10?type_name=${typeVO.filterParam}">最后一页</a></li>
						                              <c:choose>
						                              	<c:when test="${typeVO.page >= typeVO.pageCount}">
						                              		<li class="disabled"><a>»</a></li>
						                              	</c:when>
						                              	<c:otherwise>
						                              		<li><a href="admin/admin_type/${typeVO.page + 1}/10?type_name=${typeVO.filterParam}">»</a></li>
						                              	</c:otherwise>
						                              </c:choose>
						                            </ul>
						                        </div>
					                        </td>
	                                    </tr>
                                    </tfoot>
                                </tbody>
                            </table>
                        </div>
                	</div>
                </div>

            </div>
            <!-- /.container-fluid -->

        </div>
        <div class="modal fade" id="typeModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="exampleModalLabel">添加影片类型</h4>
      </div>
      <div class="modal-body">
        <form>
          <div class="form-group">
            <label for="recipient-name" class="control-label">影片类型:</label>
            <input type="text" class="form-control" id="type_add_name">
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" onclick="admin_type_add_save()" class="btn btn-primary">添加</button>
      </div>
    </div>
  </div>
</div>
<div class="modal fade" id="typeEditModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel1">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="exampleModalLabel1">编辑影片类型</h4>
      </div>
      <div class="modal-body">
        <form>
          <div class="form-group">
            <label for="recipient-name" class="control-label">影片类型:</label>
            <input type="text" class="form-control" id="type_edit_name">
            <input type="hidden" id="type_edit_id">
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" onclick="admin_type_edit_save()" class="btn btn-primary">保存</button>
      </div>
    </div>
  </div>
</div>
<div class="modal fade" id="typeDelModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel2">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="exampleModalLabel2">删除影片类型</h4>
      </div>
      <div class="modal-body">
        <form>
          <div class="form-group">
            <label for="recipient-name" class="control-label">影片类型:</label>
            <input type="text" class="form-control" id="type_del_name" disabled="disabled">
            <input type="hidden" id="type_del_id">
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" onclick="admin_type_del_save()" class="btn btn-primary">删除</button>
      </div>
    </div>
  </div>
</div>
        <!-- /#page-wrapper -->
		<!-- end -->
	<!-- 如果要使用Bootstrap的js插件，必须先调入jQuery -->
	<script src="./js/jquery-1.10.2.min.js"></script>
	<script src="./js/toastr.min.js" type="text/javascript"></script>
	<!-- 包括所有bootstrap的js插件或者可以根据需要使用的js插件调用　-->
	<script src="./js/bootstrap.min.js"></script>

    <!-- 包括所有kendoui的js插件或者可以根据需要使用的js插件调用　-->
    <script src="./js/kendo.all.min.js"></script>
    <script src="./js/admin.js"></script>                         
    </script>         
  </body>
</html>
