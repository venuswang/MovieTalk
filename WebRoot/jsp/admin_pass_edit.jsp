<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
                    <li class="active">
                        <a href="javascript:;" data-toggle="collapse" data-target="#demo"><i class="fa fa-fw fa-edit"></i> 信息设置 <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="demo" class="collapse in"> <!--  -->
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
                    <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#tag_demo"><i class="fa fa-fw fa-edit"></i> 影片标签设置 <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="tag_demo" class="collapse out">
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
				<!-- Page Heading -->
				<div class="row page-header-box">
					<div class="col-lg-12">
						<h1 class="page-header">用户密码修改</h1>
					</div>
				</div>
				<div class="main-wrap">
					<div class="panel panel-default">
						<div class="panel-heading">修改密码</div>
						<div class="panel-body">
							<div class="col-sm-8">
								<div class="form-horizontal mt15">
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">原始密码：</label>
                                        <div class="col-sm-10">
                                            <input type="password" class="form-control" placeholder="请填写原始密码" id="original_pass">
                                            <span class="king-required-tip text-danger ml5">*</span>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">修改密码：</label>
                                        <div class="col-sm-10">
                                            <input type="password" class="form-control" placeholder="请填写将要修改的密码" id="current_pass">
                                            <span class="king-required-tip text-danger ml5">*</span>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">确认密码：</label>
                                        <div class="col-sm-10">
                                            <input type="password" class="form-control" placeholder="请再次填写要修改的密码" id="confirm_pass">
                                            <span class="king-required-tip text-danger ml5">*</span>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label"></label>
                                        <label class="col-sm-2 control-label"></label>
                                        
                                        <div class="col-sm-2">
                                           <button class="king-btn king-info mr10" title="修改" onclick="admin_pass_update()">
                                                <i class="fa fa-save btn-icon"></i>修改
                                            </button>
                                        </div>
                                        <label class="col-sm-2">
                                        	<button type="reset" class="king-btn king-default" title="重置" onclick="admin_pass_clear()">
                                                <i class="fa fa-mail-reply-all btn-icon"></i>重置
                                            </button>
                                        </label>
                                        <label class="col-sm-3 control-label"></label>
                                        <label class="col-sm-2 control-label"></label>
                                    </div>
                                 </div >
                            </div>
                        </div>
                        </div>
                    </div>
                 </div>
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
