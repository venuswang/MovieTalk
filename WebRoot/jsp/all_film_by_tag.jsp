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
    		min-height:100%;
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
					<tbody>
						<c:choose>
							<c:when test="${list.count == 0}">
								<tr>
									<td rowspan="3" colspan="6">
										<center>暂时没有该年份的电影</center>
									</td>
								</tr>
							</c:when>
							<c:otherwise>
								<c:forEach items="${list.mList}" var="film">
									<tr class="text-center">
										<td colspan="2" >
											<img src="/pic/${film.picname}" alt="${film.filname}" class="img-thumbnail" width=110px height=50px/>
										</td>
										<td colspan="4">
											<a href="common/query_film_by_id/${film.id}" target="_blank">
												影名:${film.filname}<br/>
												导演:${film.director}<br/>
												编剧:${film.editor}<br/>
												制片国家:${film.nation}<br />
												语言:${film.voice}<br />
												时长:${film.duration}
											</a>
										</td>
									</tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</tbody>
					<tfoot>
						<tr>
							<td colspan="3" class="text-left">
								共有${list.count}条，每页显示：10条
							</td>
							<td colspan="3" class="text-right">
								<c:choose>
									<c:when test="${list.page <= 1}">
										<a class="btn btn-info disabled" role="button">«</a>
									</c:when>
									<c:otherwise>
										<a href="common/all_film_by_tagid/${list.page - 1}/10/${list.tagid}" class="btn btn-info disabled" role="button">«</a>
									</c:otherwise>
								</c:choose>
								<a class="btn btn-info disabled" role="button">${list.page}</a>
								<c:choose>
									<c:when test="${list.page >= list.pageCount}">
										<a class="btn btn-info disabled" role="button">»</a>
									</c:when>
									<c:otherwise>
										<a href="common/all_film_by_tagid/${list.page + 1}/10/${list.tagid}" class="btn btn-info disabled" role="button">»</a>
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
