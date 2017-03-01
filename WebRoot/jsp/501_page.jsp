<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>服务器出错</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="./css/bk.css?v=1.0.1" rel="stylesheet">
	<link href="./css/font-awesome.css" rel="stylesheet">


  </head>
  
  <body>
	<div class="king-exception-box king-500-page king-500-page1" style="padding-top:111px;">
		<div class="error-number">
			<i class="fa fa-warning show"></i> <span>500</span>
		</div>
		<div class="error-title">服务器错误</div>
		<p class="error-tip">
			我们遇到一个内部服务器的问题。 <br>请稍后再试或联系
		<a href="mailto:mail@contact.tld" class="">venuswang@tencent.com</a>
		</p>
	</div>
</body>
</html>
