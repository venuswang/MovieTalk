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
    
    <title>后台管理员登录</title>
    <meta charset="utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="后台登陆,影评网站">
	<meta http-equiv="description" content="影评网站后台">
	<link href="./css/toastr.min.css" media="all" rel="stylesheet" type="text/css" />
	<link href="./css/application.css" media="all" rel="stylesheet" type="text/css" />
  	<script src="./js/jquery-1.10.2.min.js" type="text/javascript"></script>
  	<script src="./js/toastr.min.js" type="text/javascript"></script>
  	<script src="./js/application.js" type="text/javascript"></script>
  	<script src="./js/common.js" type="text/javascript"></script>
	<style>
      section#main {  margin-left: 0px; }
      ul.top-notifications { display: none; }
  </style>
  </head>
  
  <body>
	<section id="main">
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<div class="login-container center">
					<div class="title text-transparent">Sign in</div>
					<hr class="main">

					<form class="login-form">
						<ul class="fields-list">
							<li>
								<i class="icon-user" style="float: left;"></i> 
								<input autocomplete="off" id="username" name="uname" placeholder="username" type="text">
							</li>
							<li>
								<i class="icon-key"></i> 
								<input autocomplete="off" id="password" name="pword" placeholder="password" type="password">
							</li>
						</ul>
						<div class="actions">
							<a onclick="loginCheck()" class="btn btn-large medium-blue login-btn"> Sign in </a>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	</section>
</body>
</html>
