<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<div class="king-topbar">
	<div class="form-group">
		<label class="col-sm-3 control-label text-center head-font-size">
			电影系统 </label>
		<div class="col-sm-6">
			<input type="text" class="form-control head-input-size"
				placeholder="电影、别名" id="film_name" name="user_account">
		</div>
		<div class="col-sm-1">
			<img alt="search" onclick="query_all_films(1)"
				class="head-search-size" src="./images/search.png">
		</div>
	</div>
</div>
</html>
