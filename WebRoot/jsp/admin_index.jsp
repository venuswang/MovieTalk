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
                <a class="navbar-brand" href="index.html">
                    <i class="fa fa-leaf f20 mr5"></i>
                    后台管理系统
                </a>
            </div>
            <!-- Top Menu Items -->
            <ul class="nav navbar-right top-nav">
                <li class="dropdown">
                    <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-envelope"></i> <b class="caret"></b></a>
                    <ul class="dropdown-menu message-dropdown">
                        <li class="message-preview">
                            <a href="javascript:;">
                                <div class="media">
                                    <span class="pull-left">
                                        <img class="media-object" src="img/50x50.png" alt="">
                                    </span>
                                    <div class="media-body">
                                        <h5 class="media-heading"><strong>qcloud</strong>
                                        </h5>
                                        <p class="small text-muted">Yesterday at 4:32 PM</p>
                                        <p>当前有一条未读的短消息...</p>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="message-preview">
                            <a href="javascript:;">
                                <div class="media">
                                    <span class="pull-left">
                                        <img class="media-object" src="img/50x50.png" alt="">
                                    </span>
                                    <div class="media-body">
                                        <h5 class="media-heading"><strong>qcloud</strong>
                                        </h5>
                                        <p class="small text-muted">Yesterday at 4:32 PM</p>
                                        <p>当前有一条未读的短消息...</p>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="message-preview">
                            <a href="javascript:;">
                                <div class="media">
                                    <span class="pull-left">
                                        <img class="media-object" src="img/50x50.png" alt="">
                                    </span>
                                    <div class="media-body">
                                        <h5 class="media-heading"><strong>qcloud</strong>
                                        </h5>
                                        <p class="small text-muted">Yesterday at 4:32 PM</p>
                                        <p>当前有一条未读的短消息...</p>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="message-footer">
                            <a href="javascript:;">查看所有消息</a>
                        </li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-bell"></i> <b class="caret"></b></a>
                    <ul class="dropdown-menu alert-dropdown">
                        <li>
                            <a href="javascript:;"><span class="label label-default">&nbsp;&nbsp;提醒内容&nbsp;&nbsp;</span></a>
                        </li>
                        <li>
                            <a href="javascript:;"><span class="label label-primary">&nbsp;&nbsp;提醒内容&nbsp;&nbsp;</span></a>
                        </li>
                        <li>
                            <a href="javascript:;"><span class="label label-success">&nbsp;&nbsp;提醒内容&nbsp;&nbsp;</span></a>
                        </li>
                        <li>
                            <a href="javascript:;"><span class="label label-info">&nbsp;&nbsp;提醒内容&nbsp;&nbsp;</span></a>
                        </li>
                        <li>
                            <a href="javascript:;"><span class="label label-warning">&nbsp;&nbsp;提醒内容&nbsp;&nbsp;</span></a>
                        </li>
                        <li>
                            <a href="javascript:;"><span class="label label-danger">&nbsp;&nbsp;提醒内容&nbsp;&nbsp;</span></a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="javascript:;" class='text-center'>查看所有提醒</a>
                        </li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> admin <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="javascript:;"><i class="fa fa-fw fa-user"></i> 用户</a>
                        </li>
                        <li>
                            <a href="javascript:;"><i class="fa fa-fw fa-envelope"></i> 消息盒</a>
                        </li>
                        <li>
                            <a href="javascript:;"><i class="fa fa-fw fa-gear"></i> 设置</a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="javascript:;"><i class="fa fa-fw fa-power-off"></i> 退出</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <li class="active">
                        <a href="index.html"><i class="fa fa-fw fa-dashboard"></i> 首页</a>
                    </li>
                    <li>
                        <a href="tables.html"><i class="fa fa-fw fa-table"></i> 表格</a>
                    </li>
                    <li>
                        <a href="forms.html"><i class="fa fa-fw fa-edit"></i> 表单</a>
                    </li>
                    <li>
                        <a href="bootstrap-elements.html"><i class="fa fa-fw fa-desktop"></i> 排版</a>
                    </li>
                    <li>
                        <a href="bootstrap-grid.html"><i class="fa fa-fw fa-wrench"></i> Bootstrap 布局</a>
                    </li>
                    <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#demo"><i class="fa fa-fw fa-arrows-v"></i> 下拉菜单 <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="demo" class="collapse">
                            <li>
                                <a href="javascript:;">子菜单1 </a>
                            </li>
                            <li>
                                <a href="javascript:;">子菜单2</a>
                            </li>
                        </ul>
                    </li>
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
                            概述
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
                                        <span class="king-counter-number white">260</span>
                                        <span class="king-counter-icon ml10 white">
                                            <i class="fa fa-image"></i>
                                        </span>
                                    </div>
                                    <div class="king-counter-label text-uppercase f16">followers</div>
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
                                        <span class="king-counter-number white">300</span>
                                        <span class="king-counter-icon ml10 white">
                                            <i class="fa fa-music"></i>
                                        </span>
                                    </div>
                                    <div class="king-counter-label text-uppercase f16">followers</div>
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
                                        <span class="king-counter-number white">110</span>
                                        <span class="king-counter-icon ml10 white">
                                        <i class="fa fa-envelope"></i>
                                    </span>
                                    </div>
                                    <div class="king-counter-label text-uppercase f16">followers</div>
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
                                        <span class="king-counter-number white">50</span>
                                        <span class="king-counter-number-related white">+</span>
                                    </div>
                                    <div class="king-counter-label text-uppercase f16">followers</div>
                                </div>
                            </div>
                        </div>
                    </div>  
                </div>
                <!-- /.row -->

                <div class="row charts">
                    <div class="col-md-6">
                        <div class="king-block king-block-bordered mb30">
                            <div class="king-block-header">
                                <h3 class="king-block-title">数据</h3>
                            </div>
                            <div class="king-block-content">
                                <div class="chart" id="chartA"></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="king-block king-block-bordered mb30">
                            <div class="king-block-header">
                                <h3 class="king-block-title">数据</h3>
                            </div>
                            <div class="king-block-content">
                                <div class="chart" id="chartC"></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="king-block king-block-bordered mb30">
                            <div class="king-block-header">
                                <h3 class="king-block-title">数据</h3>
                            </div>
                            <div class="king-block-content">
                                <div class="chart" id="chartB"></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="king-block king-block-bordered mb30">
                            <div class="king-block-header">
                                <h3 class="king-block-title">数据</h3>
                            </div>
                            <div class="king-block-content">
                                <div class="chart" id="chartD"></div>
                            </div>
                        </div>
                    </div>
                    
                </div>
                <!-- /.row -->

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

	<!-- 如果要使用Bootstrap的js插件，必须先调入jQuery -->
	<script src="./js/jquery-1.10.2.min.js"></script>
	<!-- 包括所有bootstrap的js插件或者可以根据需要使用的js插件调用　-->
	<script src="./js/bootstrap.min.js"></script>

    <!-- 包括所有kendoui的js插件或者可以根据需要使用的js插件调用　-->
    <script src="./js/kendo.all.min.js"></script>
    <script type="text/javascript">
    $(document).ready(function() {
       $('#chartA').kendoChart({
           seriesDefaults: {
                type: 'line'
            },
            legend:{            
                position : "bottom"
            },
            theme : 'bootstrap',
            tooltip:{
                visible:true,
                template:"#= series.name # #= value #"
            },
            categoryAxis: {
                categories: ['07-20','07-21','07-22','07-23','07-24','07-25','07-26'],
                majorGridLines: {
                    visible: false
                }
            },
            series: [{
                name: "测试数据1",
                data: [0, 2, 4, 5, 0, 1, 0]
            }, {
                name: "测试数据2",
                data: [0, 1, 0, 0, 2, 0, 0]
            }, {
                name: "测试数据3",
                data: [4, 0, 2, 1, 5, 0, 1]
            }]
        });

        $('#chartB').kendoChart({
            legend:{            
                position : "bottom"
            },
            theme : 'bootstrap',
            seriesDefaults:{
                type:'area',
                area: {
                    line: {
                        style: "smooth"
                    }
                }
            },
            categoryAxis:{
                categories : ['周一','周二','周三','周四','周五','周六','周日'],
                majorGridLines: {
                    visible: false
                }
            },
            series: [{
                name:'项目一',
                data:[10, 12, 21, 54, 260, 830, 710]
            },
            {
                name:'项目二',
                data:[30, 182, 434, 791, 390, 30, 10]
            },
            {
                name:'项目三',
                data:[1320, 1132, 601, 234, 120, 90, 20]
            }]
        });

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
                data: [{
                    category:'直接访问',
                    value:335
                }, 
                {
                    value: 310,
                    category: '测试数据1'
                },
                {
                    value: 234,
                    category: '测试数据2'
                },
                {
                    value: 135,
                    category: '测试数据3'
                },
                {
                    value: 1548,
                    category: '测试数据4'
                }]
            }]
        });

        $('#chartD').kendoChart({
            seriesDefaults: { 
                type: 'column' 
            },
            legend:{            
                position : "bottom"
            },
            theme : 'bootstrap',
            tooltip: { 
                visible: true,
            },
            categoryAxis: { 
                categories: [ 'Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec' ],
                majorGridLines: {
                    visible: false
                }
            }, 
            series: [{ 
                name: '测试数据1', 
                data: [49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4]
            }, { 
                name: '测试数据2', 
                data: [83.6, 78.8, 98.5, 93.4, 106.0, 84.5, 105.0, 104.3, 91.2, 83.5, 106.6, 92.3]
            }, { 
                name: '测试数据4',
                data: [48.9, 38.8, 39.3, 41.4, 47.0, 48.3, 59.0, 59.6, 52.4, 65.2, 59.3, 51.2]
            }, {
                name: '测试数据5',
                data: [42.4, 33.2, 34.5, 39.7, 52.6, 75.5, 57.4, 60.4, 47.6, 39.1, 46.8, 51.1]
            }] 
        });
    });
    
    //重新绘制
    $(window).on('resize',function(){
        var chartA = $("#chartA").data("kendoChart");
        var chartB = $("#chartB").data("kendoChart");
        var chartC = $("#chartC").data("kendoChart");
        var chartD = $("#chartD").data("kendoChart");
        
        chartA.redraw();
        chartB.redraw();
        chartC.redraw();
        chartD.redraw();
    });
                                
    </script>         
  </body>
</html>
