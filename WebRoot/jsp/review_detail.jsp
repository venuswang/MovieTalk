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
  	<input type="hidden" id="lid" value="${longReview.id}">
  	<input type="hidden" id="film" value="${longReview.filname}">
  	<input type="hidden" id="uid" value="${sessionScope.uid}">
  	<form class="form-horizontal" style="padding-top: 40px;padding-bottom: 20px;">
  		<div class="form-group">
  			<label class="col-sm-2 control-label"></label>
  			<label class="col-sm-2 control-label"><h3>${longReview.title}</h3></label>
  		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label"></label>
			<label class="col-sm-6">
				${longReview.uname}&nbsp;&nbsp;评论&nbsp;&nbsp;${longReview.filname}&nbsp;&nbsp;${longReview.rtime}
			</label>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label"></label>
			<div class="col-sm-6">
				${longReview.content}
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label"></label>
			<div class="col-sm-6">
				<label class="radio-inline">
					<c:choose>
						<c:when test="${sessionScope.uid == null}">
							<button type="button" onclick="login_click()" class="btn btn-warning">${longReview.usenum}&nbsp;有用</button>
						</c:when>
						<c:when test="${longReview.approve == false}">
							<button type="button" onclick="l_approve_add()" class="btn btn-warning">${longReview.usenum}&nbsp;有用</button>
						</c:when>
						<c:otherwise>
							<button type="button" onclick="l_approve_cancel()" class="btn btn-warning">${longReview.usenum}&nbsp;取消有用</button>
						</c:otherwise>
					</c:choose>
				</label>
				<label class="radio-inline">
					<c:choose>
						<c:when test="${sessionScope.uid == null}">
							<button type="button" onclick="login_click()" class="btn btn-warning">${longReview.unuse}&nbsp;无用</button>
						</c:when>
						<c:when test="${longReview.anti == false}">
							<button type="button" onclick="l_anti_add()" class="btn btn-warning">${longReview.unuse}&nbsp;无用</button>
						</c:when>
						<c:otherwise>
							<button type="button" onclick="l_anti_cancel()" class="btn btn-warning">${longReview.unuse}&nbsp;取消无用</button>
						</c:otherwise>
					</c:choose>
				</label>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-1 control-label"></label>
			<div class="col-sm-8">
				<table class="table table-hover" id="answer_content_table">
					
				</table>
			</div>
		</div>
	</form>
	<!-- short_content_dialog start-->
	<div class="modal fade" id="answerReviewModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel2">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="exampleModalLabel2">电影影评回复</h4>
				</div>
				<div class="modal-body">
					<form>
						<div class="form-group">
							<label for="recipient-name" class="control-label">电影影评回复:</label> 
							<textarea class="form-control" rows="3" id="answer_common"></textarea>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" onclick="review_reply_save()"
						class="btn btn-primary">发表影评回复</button>
				</div>
			</div>
		</div>
	</div>
	<!-- short_content_dialog  end-->
  </body>
  <script src="./js/review_detail.js" type="text/javascript"></script>
</html>
