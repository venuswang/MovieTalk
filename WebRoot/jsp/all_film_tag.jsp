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
    
    <title>标签页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
		html,body{
    		min-height:500px;
  	 }
	</style>
  </head>
  
  <body>
  	<%@include file="head.jsp" %>
	<div class="row" style="height: 100%">
      <div class="col-lg-12">
          <div>
              <div class="bootstrap-admin-panel-content" id="div-content">
              		<div class="row bootstrap-admin-light-padding-bottom">
	                 	<div class="col-md-2 head-img-size"></div>
	                 	<div class="col-md-2 head-img-size">年代 · · · · · ·</div>
	                 </div>
	                 <c:forEach items="${tags}" var="tag" varStatus="status">
	                 	<c:if test="${status.count % 4 == 1}">
	                 		<div class="row bootstrap-admin-light-padding-bottom">
				                 	<div class="col-md-2 head-img-size"></div>
	                 	</c:if>
		                 	<div class="col-md-2 head-img-size">
		                 		<a href="common/all_film_by_tagid/1/10/${tag.id}">${tag.tagname}(${tag.total})</a>
		                 	</div>
				        <c:if test="${status.count % 4 == 0 || status.last}">         	
			               		 </div>
			            </c:if>
	                 </c:forEach>
                 	
	                <div class="row bootstrap-admin-light-padding-bottom">
	                 	<div class="col-md-2 head-img-size"></div>
	                 	<div class="col-md-2 head-img-size">类型 · · · · · ·</div>
	                 </div>
                 	<c:forEach items="${types}" var="type" varStatus="status">
	                 	<c:if test="${status.count % 4 == 1}">
	                 		<div class="row bootstrap-admin-light-padding-bottom">
				                 	<div class="col-md-2 head-img-size"></div>
	                 	</c:if>
		                 	<div class="col-md-2 head-img-size">
		                 		<a href="common/all_film_by_typeid/1/10/${type.id}">${type.typename}(${type.total})</a>
		                 	</div>
				        <c:if test="${status.count % 4 == 0 || status.last}">         	
			               		 </div>
			            </c:if>
	                 </c:forEach>
              </div>
          </div>
      </div>
  </div>
  </body>
</html>
