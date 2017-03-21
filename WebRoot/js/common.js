/**
 * 这是common中的jsp页面的js文件
 */
// 管理员登录
function loginCheck() {
	var username = $('#username').val();
	var password = $('#password').val();
	if (username == "" || username.length > 32 || password == "" || password.length > 50) {
		toastr.error("用户名和账号不合法", "温馨提示", {
			preventDuplicates : true,
		});
		return false;
	}
	var url = "common/mlogin";
	$.ajax({
		url : url,
		type : 'POST',
		data : {
			"uname": username,
			"pword": password
		}
	}).done(function(res) {
		if (res.result) {
			window.location.href = "admin/admin_index";
		} else {
			toastr.error(res.message, "温馨提示", {
				preventDuplicates : true,
			});
		}
	});

}


// 用户登录
function userCheck() {
	var username = $('#username').val();
	var password = $('#password').val();
	if (username == "" || username.length > 32 || password == "" || password.length > 50) {
		toastr.error("用户名和账号不合法", "温馨提示", {
			preventDuplicates : true,
		});
		return false;
	}
	var url = "common/ulogin";
	$.ajax({
		url : url,
		type : 'POST',
		data : {
			"uname": username,
			"pword": password
		}
	}).done(function(res) {
		if (res.result) {
			var url = window.location.href;
			if(url.indexOf("common/user") >= 0){
				window.location.href = "common/index";
			} else {
				window.location.href = url;
			}
				
		} else {
			toastr.error(res.message, "温馨提示", {
				preventDuplicates : true,
			});
		}
	});
}

function login_click() {
	$("#loginModal").modal("show");
}

function login_save() {
	var username = $('#login_name').val();
	var password = $('#login_pass').val();
	if (username == "" || username.length > 32 || password == "" || password.length > 50) {
		toastr.error("用户名和账号不合法", "温馨提示", {
			preventDuplicates : true,
		});
		return false;
	}
	var url = "common/ulogin";
	$.ajax({
		url : url,
		type : 'POST',
		data : {
			"uname": username,
			"pword": password
		}
	}).done(function(res) {
		if (res.result) {
			var url = window.location.href;
			window.location.href = url;
		} else {
			toastr.error(res.message, "温馨提示", {
				preventDuplicates : true,
			});
		}
	});
}

function regist_click() {
	$("#registModal").modal("show");
}

function regist_save() {
	var username = $('#regist_name').val();
	var password = $('#regist_pass').val();
	var confirm_password = $('#regist_pass_confirm').val();
	var regist_mail = $('#regist_mail').val();
	var regist_sex = $('input:radio:checked').val();
	if (username == "" || username.length > 32 || password == "" || password.length > 50) {
		toastr.error("用户名和账号不合法", "温馨提示", {
			preventDuplicates : true,
		});
		return false;
	}
	if (password != confirm_password) {
		toastr.error("密码和确认密码不一致", "温馨提示", {
			preventDuplicates : true,
		});
		return false;
	}
	if(regist_mail == "") {
		toastr.error("email不能为空", "温馨提示", {
			preventDuplicates : true,
		});
		return false;
	} else {
		var emailReg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
		if(!emailReg.test(regist_mail)) {
			toastr.error("email格式不正确", "温馨提示", {
				preventDuplicates : true,
			});
			return false;
		}
	}
	var url = "common/uregist";
	$.ajax({
		url : url,
		type : 'POST',
		data : {
			"uname": username,
			"pword": password,
			"sex": regist_sex,
			"email": regist_mail
		}
	}).done(function(res) {
		if (res.result) {
			var url = window.location.href;
			window.location.href = url;
		} else {
			toastr.error(res.message, "温馨提示", {
				preventDuplicates : true,
			});
		}
	});
}