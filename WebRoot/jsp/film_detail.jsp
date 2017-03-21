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
    
    <title>电影${list.filname}详情</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
  	<%@include file="head.jsp" %>
  	<input type="hidden" id="mid" value="${list.id}">
  	<input type="hidden" id="uid" value="${sessionScope.uid}">
  	<input type="hidden" id="film" value="${list.filname}">
  	<form class="form-horizontal" style="padding-top: 40px;padding-bottom: 20px;">
  		<div class="form-group">
  			<label class="col-sm-1 control-label"></label>
  			<label class="col-sm-2 control-label"><h3><center>${list.filname}</center></h3></label>
  		</div>
		<div class="form-group">
			<label class="col-sm-1 control-label"></label>
			<label class="col-sm-2 control-label">
				<img src="/pic/${list.picname}" alt="${list.filname}" class="img-thumbnail">
			</label>
			<div class="col-sm-6">
				影名:${list.filname}<br/>
				导演:${list.director}<br/>
				编剧:${list.editor}<br/>
				制片国家:${list.nation}<br />
				语言:${list.voice}<br />
				时长:${list.duration}<br />
				简介:${list.content}
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-1 control-label"></label>
			<div class="col-sm-6">
				<label class="radio-inline">
					<img src="./images/short-comment.gif" />
					<c:choose>
						<c:when test="${sessionScope.uid == null}">
							<button type="button" onclick="login_click()" class="btn btn-link">写短评</button>
						</c:when>
						<c:otherwise>
							<button type="button" onclick="short_common()" class="btn btn-link">写短评</button>
						</c:otherwise>
					</c:choose>
				</label>
				<label class="radio-inline">
					<img src="./images/add-review.gif" />
					<c:choose>
						<c:when test="${sessionScope.uid == null}">
							<button type="button" onclick="login_click()" class="btn btn-link">写影评</button>
						</c:when>
						<c:otherwise>
							<button type="button" onclick="long_common()" class="btn btn-link">写影评</button>
						</c:otherwise>
					</c:choose>
				</label>
				<label class="radio-inline">
					<c:choose>
						<c:when test="${list.iscollect}">
							<button type="button" onclick="cancel_collect()" class="btn btn-warning">取消收藏</button>
						</c:when>
						<c:when test="${sessionScope.uid == null}">
							<button type="button" onclick="login_click()" class="btn btn-warning">收藏</button>
						</c:when>
						<c:otherwise>
							<button type="button" onclick="add_collect()" class="btn btn-warning">收藏</button>
						</c:otherwise>
					</c:choose>
				</label>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-1 control-label"></label>
			<div class="col-sm-8">
				<table class="table table-hover" id="short_content_table">
					
				</table>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-1 control-label"></label>
			<div class="col-sm-8">
				<table class="table table-hover" id="long_content_table">
					
				</table>
			</div>
		</div>
	</form>
	<!-- short_content_dialog start-->
	<div class="modal fade" id="shortReviewModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel2">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="exampleModalLabel2">电影短评</h4>
				</div>
				<div class="modal-body">
					<form>
						<div class="form-group">
							<label for="recipient-name" class="control-label">电影短评:</label> 
							<textarea class="form-control" rows="3" id="short_common"></textarea>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" onclick="short_common_save()"
						class="btn btn-primary">发表短评</button>
				</div>
			</div>
		</div>
	</div>
	<!-- short_content_dialog  end-->
	<!-- long_content_dialog start-->
	<div class="modal fade" id="longReviewModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel3">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="exampleModalLabel3">电影影评</h4>
				</div>
				<div class="modal-body">
					<form>
						<div class="form-group">
							<label for="recipient-name" class="control-label">影评标题:</label> 
							<input class="form-control" id="long_title"></input>
						</div>
						<div class="form-group">
							<label for="recipient-name" class="control-label">电影影评:</label> 
							<textarea class="form-control" rows="5" id="long_common"></textarea>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" onclick="long_common_save()"
						class="btn btn-primary">发表影评</button>
				</div>
			</div>
		</div>
	</div>
	<!-- short_content_dialog  end-->
	
  </body>
  <script src="./js/film_detail.js" type="text/javascript"></script>
</html>
