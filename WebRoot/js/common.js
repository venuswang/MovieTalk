/**
 * 这是common中的jsp页面的js文件
 */
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

$("#login").bind('click', function () {
    alert("hello");
});