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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	<script src="js/application.js" type="text/javascript"></script>
	-->
  </head>
  
  <body>
  	<%@include file="jsp/head.jsp" %>
  	 <div class="row">
      <div class="col-lg-12">
          <div class="panel panel-default">
              <div class="bootstrap-admin-panel-content">
                  <div class="row bootstrap-admin-light-padding-bottom">
                  	  <div class="col-md-3 head-img-size">
                  	  
                  	  </div>
                      <div class="col-md-2 head-img-size">
                          <a href="javascript:;" class="thumbnail">
                              <img src="images/260-180.png">
                          </a>
                      </div>
                      <div class="col-md-2 head-img-size">
                          <a href="javascript:;" class="thumbnail">
                              <img src="images/260-180.png">
                          </a>
                      </div>
                      <div class="col-md-2 head-img-size">
                          <a href="javascript:;" class="thumbnail">
                              <img src="images/260-180.png">
                          </a>
                      </div>
                  </div> 
                  <div class="row bootstrap-admin-light-padding-bottom">
                  	  <div class="col-md-3 head-img-size">
                  	  
                  	  </div>
                      <div class="col-md-2 head-img-size">
                          <a href="javascript:;" class="thumbnail">
                              <img src="images/260-180.png">
                          </a>
                      </div>
                      <div class="col-md-2 head-img-size">
                          <a href="javascript:;" class="thumbnail">
                              <img src="images/260-180.png">
                          </a>
                      </div>
                      <div class="col-md-2 head-img-size">
                          <a href="javascript:;" class="thumbnail">
                              <img src="images/260-180.png">
                          </a>
                      </div>
                  </div> 
                  <div class="row bootstrap-admin-light-padding-bottom">
                  	  <div class="col-md-3 head-img-size">
                  	  
                  	  </div>
                      <div class="col-md-2 head-img-size">
                          <a href="javascript:;" class="thumbnail">
                              <img src="images/260-180.png">
                          </a>
                      </div>
                      <div class="col-md-2 head-img-size">
                          <a href="javascript:;" class="thumbnail">
                              <img src="images/260-180.png">
                          </a>
                      </div>
                      <div class="col-md-2 head-img-size">
                          <a href="javascript:;" class="thumbnail">
                              <img src="images/260-180.png">
                          </a>
                      </div>
                  </div> 
              </div>
              <div class="panel-footer">
                     <!-- start -->
 						共有100条，每页显示：10条
 				<div class="pull-right">
				  <ul class="list-inline">
		    			<li class="disabled"><a>«</a></li>
		    			<li ><a>1</a></li>
		    			<li class="disabled"><a>»</a></li>
		    	 </ul>	
 					</div>
 				<!-- end -->          
              </div>   
          </div>
      </div>
  </div>

  </body>
</html>
