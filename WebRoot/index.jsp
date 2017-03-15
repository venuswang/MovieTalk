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
    
    <title>首页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/opentip.css">
  </head>
  
  <body>
  	<%@include file="jsp/head.jsp" %>
  	 <div class="row">
      <div class="col-lg-12">
          <div class="panel panel-default">
              <div class="bootstrap-admin-panel-content" id="div-content">
                 	
              </div>
              <div class="panel-footer" id="div-footer">
                         
              </div>   
          </div>
      </div>
  </div>

  </body>
  <script src="js/opentip-jquery.min.js" type="text/javascript"></script>
  <script src="js/user-index.js" type="text/javascript"></script>
</html>
