<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户登出</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="./css/bk.css?v=1.0.1" rel="stylesheet">

  </head>
  
  <body>
  	<div class="king-exception-box king-401-page" style="padding-top: 101px;">
	    <img src="./img/expre_401.png">
	    <h1>您已经安全退出</h1>
	    <a href="common/user" class="king-btn king-info king-noborder">重新登录</a>
	    <a href="common/index" class="king-btn king-info king-noborder">返回首页</a>
	</div>
  		
  </body>
</html>
