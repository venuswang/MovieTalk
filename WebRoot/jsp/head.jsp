<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
		 <link href="./css/bootstrap.min.css" rel="stylesheet">
	  	<link href="./css/bootstrap_noresponsive.css" rel="stylesheet">
        <link href="./css/bk.css?v=1.0.1" rel="stylesheet">
        <link href="./css/style.css" rel="stylesheet">
        <link href="./css/head.css" rel="stylesheet">
       	<script src="./js/jquery-1.10.2.min.js" type="text/javascript"></script>
       	<script src="./js/bootstrap.min.js" type="text/javascript"></script>
       	<script src="./js/common.js" type="text/javascript"></script>
		<div class="king-layout1-main" style="width:100%;">
    <!-- header start -->
    <div class="king-layout1-header" style=" background:#eee;">
        <div class="king-header2 navbar navbar-blue">
            <div class="container">
                <div class="navbar-header">
                  <a class="navbar-brand" href="common/index" title="影评系统"><span class="shape shape1"></span><span class="shape shape2"></span><span class="shape shape3"></span><span class="shape shape4"></span><span class="txt">影评系统</span></a> </div>
                <div class="">
                  <ul class="nav navbar-nav navbar-left">
                    <li><a href="common/index"><span>首页</span></a></li>
                    <li><a href="alarm.html"><span>标签</span></a></li>
                    <li><a href="key.html"><span>影片长评</span></a></li>
                    <c:if test="${sessionScope.username != null}">
                    	<li class="active"><a href="table3.html"><span>个人中心</span></a></li>
                    </c:if>
                  </ul>
                  <ul class="nav navbar-nav navbar-right">
                   	<c:choose>
						<c:when test="${sessionScope.username == null}">
							<li class="disuser"><a id="login" onclick="login_click()" class="thickbox"  title="登录">登录</a></li>
							<li><a onclick="regist_click()">注册</a></li>
						</c:when>
						<c:otherwise>
							<li class="disuser"><a href="__APP__/User/index/uid/{$smarty.session.loginuser.id}"  style="color:#fff;"></a></li>
							<li><a href="__APP__/Login/loginout">退出</a></li>
						</c:otherwise>
					</c:choose>
                  </ul>
                </div>
            </div>
        </div>

        <div class="king-topbar">
                 <div class="form-group">
                      <label class="col-sm-3 control-label text-center head-font-size">
                      	电影系统
                      </label>
                      <div class="col-sm-6">
                          <input type="text" class="form-control head-input-size"  placeholder="电影、影人" id="user_account" name="user_account">
                      </div>
                       <div class="col-sm-1">
                       	   <img alt="search" class="head-search-size" src="./images/search.png">
                       </div>
                  </div>
        </div>
    </div>
    <!-- header end -->
	<div class="modal fade" id="loginModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="exampleModalLabel">会员登录</h4>
				</div>
				<div class="modal-body">
					<form>
						<div class="form-group">
							<label for="recipient-name" class="control-label">用户名:</label> <input
								type="text" class="form-control" id="login_name">
						</div>
						<div class="form-group">
							<label for="recipient-name" class="control-label">密码:</label> <input
								type="password" class="form-control" id="login_pass">
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" onclick="login_save()"
						class="btn btn-primary">登录</button>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="registModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel1">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="exampleModalLabel1">会员注册</h4>
				</div>
				<div class="modal-body">
					<form>
						<div class="form-group">
							<label for="recipient-name" class="control-label">用户名:</label> <input
								type="text" class="form-control" id="regist_name">
						</div>
						<div class="form-group">
							<label for="recipient-name" class="control-label">密码:</label> <input
								type="password" class="form-control" id="regist_pass">
						</div>
						<div class="form-group">
							<label for="recipient-name" class="control-label">确认密码:</label> <input
								type="password" class="form-control" id="regist_pass_confirm">
						</div>
						<div class="form-group">
							<label for="recipient-name" class="control-label">邮箱:</label> <input
								type="email" class="form-control" id="regist_mail">
						</div>
						<div class="form-group">
							<label for="recipient-name" class="control-label">性别:</label> 
							<div style="padding-left: 24px;">
								<input type="radio"  name="regist_sex" value=1>男
								<input type="radio"  name="regist_sex" checked="checked" value=0>女
								<input type="radio"  name="regist_sex" value=2>保密
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" onclick="regist_save()"
						class="btn btn-primary">注册</button>
				</div>
			</div>
		</div>
	</div>
</html>
