/**
 * 这是admin中的jsp页面的js文件
 */
function admin_message_edit() {
	var admin_id = $('#admin_id').val();
	var uname = $('#uname').val();
	var fullname = $('#fullname').val();
	var phone = $('#phone').val();
	var email = $('#email').val();
	if (admin_id == "" || uname == "" || uname.length > 32) {
		toastr.error("非法操作", "温馨提示", {
			preventDuplicates : true,
		});
		return false;
	}
	if(fullname.length > 50) {
		toastr.error("用户名长度不能超过50个字符", "温馨提示", {
			preventDuplicates : true,
		});
		return false;
	}
	if(phone != "") {
		var regu = /^[1][0-9]{10}$/;
		var re = new RegExp(regu);
		if(!re.test(phone)) {
			toastr.error("手机号码格式不正确", "温馨提示", {
				preventDuplicates : true,
			});
			return false;
		}
	}
	if(email == "") {
		toastr.error("email不能为空", "温馨提示", {
			preventDuplicates : true,
		});
		return false;
	} else {
		var emailReg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
		if(!emailReg.test(email)) {
			toastr.error("email格式不正确", "温馨提示", {
				preventDuplicates : true,
			});
			return false;
		}
	}
	var url = "admin/edit_message_save";
	$.ajax({
		url : url,
		type : 'POST',
		data : {
			"id": admin_id,
			"uname": uname,
			"fullname": fullname,
			"email": email,
			"phone": phone
		}
	}).done(function(res) {
		if (res.result) {
			window.location.href = "admin/admin_message";
		} else {
			toastr.error(res.message, "温馨提示", {
				preventDuplicates : true,
			});
		}
	});
}


function admin_pass_update() {
	var original_pass = $.trim($('#original_pass').val());
	var current_pass_original = $('#current_pass').val();
	var current_pass = $.trim(current_pass_original);
	var confirm_pass_original = $('#confirm_pass').val();
	var confirm_pass = $.trim(confirm_pass_original);
	if(original_pass == "" || current_pass == "" || confirm_pass == "") {
		toastr.error("密码(去掉首尾空格)不能为空", "温馨提示", {
			preventDuplicates : true,
		});
		return false;
	}
	if(original_pass.length > 50 || current_pass.length > 50 || confirm_pass.length > 50) {
		toastr.error("密码长度超过50个字符", "温馨提示", {
			preventDuplicates : true,
		});
		return false;
	}
	if(current_pass != confirm_pass || current_pass_original.length != confirm_pass_original.length) {
		toastr.error("更新的密码和确认密码不一致", "温馨提示", {
			preventDuplicates : true,
		});
		return false;
	}
	var url = "admin/edit_pass_save";
	$.ajax({
		url : url,
		type : 'POST',
		data : {
			"originalPassword":original_pass,
			"currentPassword":current_pass,
			"confirmPassword":confirm_pass
		}
	}).done(function(res) {
		if (res.result) {
			document.getElementById('original_pass').value = "";
			document.getElementById('current_pass').value = "";
			document.getElementById('confirm_pass').value = "";
			toastr.success(res.message, "温馨提示", {
				preventDuplicates : true,
			});
		} else {
			toastr.error(res.message, "温馨提示", {
				preventDuplicates : true,
			});
		}
	});
}

function admin_pass_clear() {
	document.getElementById('original_pass').value = "";
	document.getElementById('current_pass').value = "";
	document.getElementById('confirm_pass').value = "";
}

function admin_mess_clear() {
	document.getElementById('fullname').value = "";
	document.getElementById('phone').value = "";
	document.getElementById('email').value = "";
}

function admin_tag_clear() {
	document.getElementById('tag_name').value = "";
}

function admin_type_clear() {
	document.getElementById('type_name').value = "";
}

function admin_actor_clear() {
	document.getElementById('actor_name').value = "";
}

function admin_list_clear() {
	document.getElementById('list_name').value = "";
}

function admin_tag_add() {
	$("#tagModal").modal("show");
}

function admin_type_add() {
	$("#typeModal").modal("show");
}

function admin_actor_add() {
	$("#actorModal").modal("show");
}

function admin_list_add() {
	$("#listModal").modal("show");
}

function admin_tag_add_save() {
	var tag_name = $("#tag_add_name").val();
	var url = "admin/add_tag_save";
	$.ajax({
		url : url,
		type : 'POST',
		data : {
			"tag_name": tag_name,
		}
	}).done(function(res) {
		if (res.result) {
			$("#tagModal").modal("hide");
			var filterParam = $("#tag_name").val();
			window.location.href = "admin/admin_tag/1/10?tag_name=" + filterParam;
		} else {
			alert(res.message);
		}
	});
}

function admin_type_add_save() {
	var type_name = $("#type_add_name").val();
	var url = "admin/add_type_save";
	$.ajax({
		url : url,
		type : 'POST',
		data : {
			"type_name": type_name,
		}
	}).done(function(res) {
		if (res.result) {
			$("#typeModal").modal("hide");
			var filterParam = $("#type_name").val();
			window.location.href = "admin/admin_type/1/10?type_name=" + filterParam;
		} else {
			alert(res.message);
		}
	});
}

function tag_edit(elemid) {
	var id = elemid.parentNode.parentNode.children[1].innerText;
	var tagName = elemid.parentNode.parentNode.children[2].innerText;
	$("#tagEditModal").modal("show");
	document.getElementById("tag_edit_name").value = tagName;
	document.getElementById("tag_edit_id").value = id;
}

function type_edit(elemid) {
	var id = elemid.parentNode.parentNode.children[1].innerText;
	var typeName = elemid.parentNode.parentNode.children[2].innerText;
	$("#typeEditModal").modal("show");
	document.getElementById("type_edit_name").value = typeName;
	document.getElementById("type_edit_id").value = id;
}

function actor_edit(elemid) {
	var id = elemid.parentNode.parentNode.children[0].innerText;
	var cname = elemid.parentNode.parentNode.children[2].innerText;
	var ename = elemid.parentNode.parentNode.children[3].innerText;
	var sex = elemid.parentNode.parentNode.children[4].innerText;
	var constellation = elemid.parentNode.parentNode.children[5].innerText;
	var birthday = elemid.parentNode.parentNode.children[6].innerText;
	var bornaddress = elemid.parentNode.parentNode.children[7].innerText;
	var profession = elemid.parentNode.parentNode.children[8].innerText;
	var picName = elemid.parentNode.parentNode.children[9].innerText.replace(/(^\s*)|(\s*$)/g, "");
	document.getElementById("edit_id").value = id;
	document.getElementById("edit_cname").value = cname;
	document.getElementById("edit_picname").value = picName;
	document.getElementById("edit_ename").value = ename;
	if(sex == '不详') {
		$('#edit_sex').val(2);
	} else if(sex == '女') {
		$('#edit_sex').val(1);
	} else {
		$('#edit_sex').val(0);
	}
	$('#edit_constellation').val(constellation);
	document.getElementById("edit_birthday").value = birthday;
	document.getElementById("edit_bornaddress").value = bornaddress;
	document.getElementById("edit_profession").value = profession;
	$("#edit_picimg").attr("src", "/pic/" + picName);
	$("#actorEditModal").modal("show");
}

function admin_tag_edit_save() {
	var id = $('#tag_edit_id').val();
	var name = $('#tag_edit_name').val();
	var url = "admin/edit_tag_save";
	$.ajax({
		url : url,
		type : 'POST',
		data : {
			"id": id,
			"tagname": name,
		}
	}).done(function(res) {
		if (res.result) {
			$("#tagEditModal").modal("hide");
			var filterParam = $("#tag_name").val();
			debugger;
			window.location.href = "admin/admin_tag/1/10?tag_name=" + filterParam;
		} else {
			alert(res.message);
		}
	});
}

function admin_type_edit_save() {
	var id = $('#type_edit_id').val();
	var name = $('#type_edit_name').val();
	var url = "admin/edit_type_save";
	$.ajax({
		url : url,
		type : 'POST',
		data : {
			"id": id,
			"typename": name,
		}
	}).done(function(res) {
		if (res.result) {
			$("#typeEditModal").modal("hide");
			var filterParam = $("#type_name").val();
			debugger;
			window.location.href = "admin/admin_type/1/10?type_name=" + filterParam;
		} else {
			alert(res.message);
		}
	});
}

function tag_delete(elemid) {
	var id = elemid.parentNode.parentNode.children[1].innerText;
	var tagName = elemid.parentNode.parentNode.children[2].innerText;
	$("#tagDelModal").modal("show");
	document.getElementById("tag_del_name").value = tagName;
	document.getElementById("tag_del_id").value = id;
}

function type_delete(elemid) {
	var id = elemid.parentNode.parentNode.children[1].innerText;
	var typeName = elemid.parentNode.parentNode.children[2].innerText;
	$("#typeDelModal").modal("show");
	document.getElementById("type_del_name").value = typeName;
	document.getElementById("type_del_id").value = id;
}

function actor_delete(elemid) {
	var id = elemid.parentNode.parentNode.children[0].innerText;
	var aid = elemid.parentNode.parentNode.children[1].innerText;
	var d = dialog({
        width: 260,
        title: '提示',
        content: '你确定要删除该条记录吗？',
        okValue: '确定',
        ok: function() {
        	var url = "admin/del_actor_save";
    		$.ajax({
    			url : url,
    			type : 'POST',
    			data : {
    				"id": id,
    				"aid": aid,
    			}
    		}).done(function(res) {
    			if (res.result) {
    				var filterParam = $("#actor_name").val();
    				window.location.href = "admin/admin_actor/1/10?actor_name=" + filterParam;
    			} else {
    				alert(res.message);
    			}
    		});
        },
        cancelValue: '取消',
        cancel: function() {
        	
        },
        onshow: function() {
           
        },
    });
    d.show();
	/*if(window.confirm('你确定要删除该条记录吗？')){
        //alert("确定");
		var url = "admin/del_actor_save";
		$.ajax({
			url : url,
			type : 'POST',
			data : {
				"id": id,
				"aid": aid,
			}
		}).done(function(res) {
			if (res.result) {
				var filterParam = $("#actor_name").val();
				window.location.href = "admin/admin_actor/1/10?actor_name=" + filterParam;
			} else {
				alert(res.message);
			}
		});
     }else{
        //alert("取消");
       return false;
    }*/
}

function admin_tag_del_save() {
	var id = $('#tag_del_id').val();
	var name = $('#tag_del_name').val();
	var url = "admin/del_tag_save";
	$.ajax({
		url : url,
		type : 'POST',
		data : {
			"id": id,
			"tagname": name,
		}
	}).done(function(res) {
		if (res.result) {
			$("#tagDelModal").modal("hide");
			var filterParam = $("#tag_name").val();
			window.location.href = "admin/admin_tag/1/10?tag_name=" + filterParam;
		} else {
			alert(res.message);
		}
	});
}

function admin_type_del_save() {
	var id = $('#type_del_id').val();
	var name = $('#type_del_name').val();
	var url = "admin/del_type_save";
	$.ajax({
		url : url,
		type : 'POST',
		data : {
			"id": id,
			"typename": name,
		}
	}).done(function(res) {
		if (res.result) {
			$("#typeDelModal").modal("hide");
			var filterParam = $("#type_name").val();
			window.location.href = "admin/admin_type/1/10?type_name=" + filterParam;
		} else {
			alert(res.message);
		}
	});
}

$("#picfile").change(function(){
	var objUrl = getObjectURL(this.files[0]) ;
	if (objUrl) {
		$("#picimg").attr("src", objUrl) ;
	}
}) ;

$("#edit_picfile").change(function(){
	var objUrl = getObjectURL(this.files[0]) ;
	if (objUrl) {
		$("#edit_picimg").attr("src", objUrl) ;
	}
}) ;

//建立一個可存取到該file的url
function getObjectURL(file) {
	var url = null ; 
	if (window.createObjectURL!=undefined) { // basic
		url = window.createObjectURL(file) ;
	} else if (window.URL!=undefined) { // mozilla(firefox)
		url = window.URL.createObjectURL(file) ;
	} else if (window.webkitURL!=undefined) { // webkit or chrome
		url = window.webkitURL.createObjectURL(file) ;
	}
	return url ;
}

$(".form_datetime").datetimepicker({
	language:  'zh-TW',
    format: "yyyymmdd",
    weekStart: 1,//一周从哪一天开始。0（星期日）到6（星期六）
    todayBtn: true,
    autoclose: true,//当选择一个日期之后是否立即关闭此日期时间选择器。
    startView: 2,
    minView: 2,
    forceParse: false,
    todayHighlight: true,//高亮当前日期
});