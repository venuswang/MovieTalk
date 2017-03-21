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
    
    <title>所有影评</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
		html,body{
    		min-height:600px;
  	 }
	</style>
  </head>
  
  <body>
  	<%@include file="head.jsp" %>
	<form class="form-horizontal" style="padding-top: 40px;padding-bottom: 20px; height: 100%">
		<div class="form-group">
			<label class="col-sm-2 control-label"></label>
			<div class="col-sm-8">
				<table class="table table-hover">
					<thead>
						<tr class="text-center">
							<th><center>影评名称</center></th>
							<th><center>被评价电影</center></th>
							<th><center>评价人</center></th>
							<th><center>影评有用数</center></th>
							<th><center>影评无用数</center></th>
							<th><center>影评发表时间</center></th>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${longReview.count == 0}">
								<tr>
									<td rowspan="3" colspan="6">
										<center>暂时没有数据,请参加电影评论吧</center>
									</td>
								</tr>
							</c:when>
							<c:otherwise>
								<c:forEach items="${longReview.longReview}" var="review">
									<tr class="text-center">
										<td><a href="common/query_long_review_by_id/${review.id}" target="_blank">${review.title}</a></td>
										<td><a href="common/query_film_by_id/${review.mid}" target="_blank">${review.filname}</a></td>
										<td>${review.uname}</td>
										<td>${review.usenum}</td>
										<td>${review.unuse}</td>
										<td>${review.rtime}</td>
									</tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</tbody>
					<tfoot>
						<tr>
							<td colspan="3" class="text-left">
								共有${longReview.count}条，每页显示：10条
							</td>
							<td colspan="3" class="text-right">
								<c:choose>
									<c:when test="${longReview.page <= 1}">
										<a class="btn btn-info disabled" role="button">«</a>
									</c:when>
									<c:otherwise>
										<a href="common/all_long_reviews/${longReview.page - 1}/10" class="btn btn-info disabled" role="button">«</a>
									</c:otherwise>
								</c:choose>
								<a class="btn btn-info disabled" role="button">${longReview.page}</a>
								<c:choose>
									<c:when test="${longReview.page >= longReview.pageCount}">
										<a class="btn btn-info disabled" role="button">»</a>
									</c:when>
									<c:otherwise>
										<a href="common/all_long_reviews/${longReview.page + 1}/10" class="btn btn-info disabled" role="button">»</a>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
	</form>
  </body>
</html>
