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
    
    <title>后台管理员首页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="管理员后台首页">
	 <link href="./css/bootstrap.min.css" rel="stylesheet">
	<link href="./css/font-awesome.css" rel="stylesheet">
    <!-- 当前项目样式文件 -->
    <link href="./css/sb-admin.css" rel="stylesheet">
    <link href="./css/sb-bk-theme.css" rel="stylesheet">
    <!--蓝鲸平台APP 公用的样式文件 -->
    <link href="./css/toastr.min.css" media="all" rel="stylesheet" type="text/css" />
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
                        <!--  <li>
                            <a href="admin/admin_message"><i class="fa fa-fw fa-gear"></i>信息设置</a>
                        </li>
                        <li class="divider"></li>-->
                        <li>
                            <a href="admin/admin_login_out"><i class="fa fa-fw fa-power-off"></i> 退出</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <li  class="active">
                        <a href="admin/admin_index"><i class="fa fa-fw fa-dashboard"></i> 首页</a>
                    </li>
                     <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#demo"><i class="fa fa-fw fa-edit"></i> 信息设置 <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="demo" class="collapse">
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
                        <ul id="tag_demo" class="collapse">
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
                    <!--  
                    <li>
                        <a href="admin/admin_message"><i class="fa fa-fw fa-arrows-v"></i> 信息设置</a>
                    </li>
                    
                    <li>
                        <a href="bootstrap-elements.html"><i class="fa fa-fw fa-desktop"></i> 排版</a>
                    </li>
                    <li>
                        <a href="bootstrap-grid.html"><i class="fa fa-fw fa-wrench"></i> Bootstrap 布局</a>
                    </li>
                    -->
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </nav>
        
        <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row page-header-box">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                           	系统概述
                        </h1>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row data-panel">
                    <div class="col-lg-3 col-md-6">
                        <div class="king-widget2">
                            <div class="king-widget-content p20 bg-info">
                                <div class="king-counter king-counter-lg">
                                    <div class="king-counter-label text-uppercase f16">we have</div>
                                    <div class="king-counter-number-group">
                                        <span class="king-counter-number white">${listCount}</span>
                                        <span class="king-counter-icon ml10 white">
                                            <i class="fa fa-film"></i>
                                        </span>
                                    </div>
                                    <div class="king-counter-label text-uppercase f16">films</div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="king-widget2">
                            <div class="king-widget-content p20 bg-info">
                                <div class="king-counter king-counter-lg">
                                    <div class="king-counter-label text-uppercase f16">we have</div>
                                    <div class="king-counter-number-group">
                                        <span class="king-counter-number white">${adminCount}</span>
                                        <span class="king-counter-icon ml10 white">
                                            <i class="fa fa-user"></i>
                                        </span>
                                    </div>
                                    <div class="king-counter-label text-uppercase f16">managers</div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="king-widget2">
                            <div class="king-widget-content p20 bg-info">
                                <div class="king-counter king-counter-lg">
                                    <div class="king-counter-label text-uppercase f16">we have</div>
                                    <div class="king-counter-number-group">
                                        <span class="king-counter-number white">${userCount}</span>
                                        <span class="king-counter-icon ml10 white">
                                        <i class="fa fa-users"></i>
                                    </span>
                                    </div>
                                    <div class="king-counter-label text-uppercase f16">users</div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="king-widget2">
                            <div class="king-widget-content p20 bg-info">
                                <div class="king-counter king-counter-lg">
                                    <div class="king-counter-label text-uppercase f16">we have</div>
                                    <div class="king-counter-number-group">
                                        <span class="king-counter-number white">${linkCount}</span>
                                        <span class="king-counter-number-related white">+</span>
                                    </div>
                                    <div class="king-counter-label text-uppercase f16">links</div>
                                </div>
                            </div>
                        </div>
                    </div> 
                    <div class="col-md-6">
                        <div class="king-block king-block-bordered mb30">
                            <div class="king-block-header">
                                <h3 class="king-block-title">用户男女比例数据</h3>
                            </div>
                            <div class="king-block-content" style="max-height: 320px">
                                <div class="chart" id="chartC"></div>
                            </div>
                        </div>
                    </div> 
                    <div class="col-md-6">
                        <div class="king-block king-block-bordered mb30">
                            <div class="king-block-header">
                                <h3 class="king-block-title">运营商比例数据</h3>
                            </div>
                            <div class="king-block-content" style="max-height: 320px">
                                <div class="chart" id="chartD"></div>
                            </div>
                        </div>
                    </div> 
                </div>
             </div>   
         </div>    
                
	<!-- 如果要使用Bootstrap的js插件，必须先调入jQuery -->
	<script src="./js/jquery-1.10.2.min.js"></script>
	<!-- 包括所有bootstrap的js插件或者可以根据需要使用的js插件调用　-->
	<script src="./js/bootstrap.min.js"></script>

    <!-- 包括所有kendoui的js插件或者可以根据需要使用的js插件调用　-->
    <script src="./js/kendo.all.min.js"></script>
    <script src="./js/toastr.min.js" type="text/javascript"></script>
    <script type="text/javascript">
    var sex_list = [];
	var isp_list = [];
	var url = "admin/get_sex_isp";
	(function(){
		$.ajax({
			url : url,
			type : 'POST',
			data : {
			
			}
		}).done(function(res) {
			debugger;
			sex_list = res.sex;
			isp_list = res.isp;
			init_graph();
		});
	}());
	
	function init_graph() {
    //$(document).ready(function() {
        $('#chartC').kendoChart({
            legend:{            
                position : "bottom"
            },
            theme : 'bootstrap',
            seriesDefaults: {
                labels: {
                    template: "#= category # - #= kendo.format('{0:P}', percentage)#",
                    position: "outsideEnd",
                    visible: true,
                    background: "transparent"
                }
            },
            series: [{
                name: '访问来源', 
                type: 'pie',
                data: sex_list
            }]
        });
        $('#chartD').kendoChart({
            legend:{            
                position : "bottom"
            },
            theme : 'bootstrap',
            seriesDefaults: {
                labels: {
                    template: "#= category # - #= kendo.format('{0:P}', percentage)#",
                    position: "outsideEnd",
                    visible: true,
                    background: "transparent"
                }
            },
            series: [{
                name: '访问来源', 
                type: 'pie',
                data: isp_list
            }]
        });
    };
    
    //重新绘制
    $(window).on('resize',function(){
        var chartC = $("#chartC").data("kendoChart");
        var chartD = $("#chartD").data("kendoChart");
        chartC.redraw();
        chartD.redraw();
    });                              
    </script>         
  </body>
</html>
