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
    
    <title>电影收藏夹</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
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
							<th colspan="3"><center>已收藏的电影</center></th>
							<th colspan="3"><center>操作</center></th>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${mstore.count == 0}">
								<tr>
									<td rowspan="3" colspan="6">
										<center>暂时没有数据,请收藏些电影吧</center>
									</td>
								</tr>
							</c:when>
							<c:otherwise>
								<c:forEach items="${mstore.store}" var="store">
									<tr class="text-center">
										<td colspan="3"><a href="common/query_film_by_id/${store.mid}" target="_blank">${store.filname}</a></td>
										<td colspan="3"><button type="button" onclick="cancel_collect(${store.mid})" class="btn btn-btn-link">删除</button></td>
									</tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</tbody>
					<tfoot>
						<tr>
							<td colspan="3" class="text-left">
								共有${mstore.count}条，每页显示：10条
							</td>
							<td colspan="3" class="text-right">
								<c:choose>
									<c:when test="${mstore.page <= 1}">
										<a class="btn btn-info disabled" role="button">«</a>
									</c:when>
									<c:otherwise>
										<a href="custom/all_movie_collect/${mstore.page - 1}/10" class="btn btn-info disabled" role="button">«</a>
									</c:otherwise>
								</c:choose>
								<a class="btn btn-info disabled" role="button">${mstore.page}</a>
								<c:choose>
									<c:when test="${mstore.page >= mstore.pageCount}">
										<a class="btn btn-info disabled" role="button">»</a>
									</c:when>
									<c:otherwise>
										<a href="custom/all_movie_collect/${mstore.page + 1}/10" class="btn btn-info disabled" role="button">»</a>
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
  <script type="text/javascript" src="./js/movie_collect.js"></script>
</html>
