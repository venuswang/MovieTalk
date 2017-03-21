/**
 * 影片详情js
 */
function cancel_collect() {
	var mid = $("#mid").val();
	var url = "custom/cancel_collect";
	$.ajax({
		url : url,
		type : 'POST',
		data : {
			"mid": mid
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

function add_collect() {
	var mid = $("#mid").val();
	var url = "custom/add_collect";
	$.ajax({
		url : url,
		type : 'POST',
		data : {
			"mid": mid
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

function add_approve(short_common_id) {
	$.ajax({
		url : "custom/add_approve",
		type : 'POST',
		data: {
			"id": short_common_id
		}
	}).done(function(res) {
		if (res.result) {
			query_short_common(1);
		} else {
			toastr.error(res.message, "温馨提示", {
				preventDuplicates : true,
			});
		}
	});
}

function cancel_approve(short_common_id) {
	$.ajax({
		url : "custom/cancel_approve",
		type : 'POST',
		data: {
			"id": short_common_id
		}
	}).done(function(res) {
		if (res.result) {
			query_short_common(1);
		} else {
			toastr.error(res.message, "温馨提示", {
				preventDuplicates : true,
			});
		}
	});
}

function short_common() {
	// 弹模态框
	$("#shortReviewModal").modal("show");
}

function short_common_save() {
	// 短评保存
	var mid = $("#mid").val();
	var content = $("#short_common").val();
	$.ajax({
		url : "custom/short_common_save",
		type : 'POST',
		data: {
			"mid": mid,
			"content": content
		}
	}).done(function(data) {
		$("#shortReviewModal").modal("hide");
		query_short_common(1);
	});
}

function long_common() {
	// 弹模态框
	$("#longReviewModal").modal("show");
}

function long_common_save() {
	// 影评保存
	var mid = $("#mid").val();
	var long_title = $("#long_title").val();
	var content = $("#long_common").val();
	$.ajax({
		url : "custom/long_common_save",
		type : 'POST',
		data: {
			"mid": mid,
			"content": content,
			"title": long_title
		}
	}).done(function(data) {
		$("#longReviewModal").modal("hide");
		query_long_common(1);
	});
}

function query_short_common(current_page) {
	var uid = $("#uid").val();
	var mid = $("#mid").val();
	var film = $("#film").val();
	$.ajax({
		url : "common/query_short_common/" + current_page + "/10",
		type : 'POST',
		data: {
			"mid": mid
		}
	}).done(function(data) {
		// console.log(data);
		var short_content = document.getElementById("short_content_table");
		short_content.innerHTML = "";
		var short_content_html = "";
		// 如果用户没有登录
		if(uid == "") {
			short_content_html = "<thead><td>" + film + "的短评------(共有" + data.count + "条)</td><td class=\"text-right\"><button type=\"button\" onclick=\"login_click()\" class=\"btn btn-btn-link\">我要写短评</button></td></thead>";
			if(data.count == 0) {
				short_content_html += "<tbody><tr><td rowspan=\"2\" colspan=\"2\" class=\"text-center\">暂时还无人评论,快成为第一个评论者吧...</td></tr></tbody>";
				short_content_html += "<tfoot><td colspan=\"2\" class=\"text-right\"><button type=\"button\" class=\"btn btn-info disabled\">«</button><button type=\"button\" class=\"btn btn-default disabled\">" + data.page + "</button><button type=\"button\" class=\"btn btn-info disabled\">»</button></td></tfoot>";
			} else {
				short_content_html += "<tbody>";
				for(var index = 0; index < data.shrotReview.length; index++) {
					var short_object = data.shrotReview[index];
					short_content_html += "<tr><td>" + short_object.uname  + "看过&nbsp;" + short_object.rtime + "<br/>" + short_object.content + "</td><td class=\"text-right\">" + short_object.usenum + "<button type=\"button\" onclick=\"login_click()\" class=\"btn btn-link\">有用</button></td></tr>";
				}
				short_content_html += "</tbody><tfoot><td colspan=\"2\" class=\"text-right\">"
				if(data.page <= 1) {
					short_content_html += "<button type=\"button\" class=\"btn btn-info disabled\">«</button>";
				} else {
					var pre_page = data.page - 1;
					short_content_html += "<button type=\"button\" onclick=\"query_short_common(" + pre_page + ")\" class=\"btn btn-info\">«</button>";
				}
				short_content_html += "<button type=\"button\" class=\"btn btn-default disabled\">" + data.page + "</button>";
				if(data.page >= data.pageCount) {
					short_content_html += "<button type=\"button\" class=\"btn btn-info disabled\">»</button>";
				} else {
					var next_page = data.page + 1;
					short_content_html += "<button type=\"button\" onclick=\"query_short_common(" + next_page + ")\" class=\"btn btn-info\">»</button>";
				}
				short_content_html += "</td></tfoot>";
			}
		} else {
			short_content_html = "<thead><td>" + film + "的短评------(共有" + data.count + "条)</td><td class=\"text-right\"><button type=\"button\" onclick=\"short_common()\" class=\"btn btn-btn-link\">我要写短评</button></td></thead>";
			if(data.count == 0) {
				short_content_html += "<tbody><tr><td rowspan=\"2\" colspan=\"2\" class=\"text-center\">暂时还无人评论,快成为第一个评论者吧...</td></tr></tbody>";
				short_content_html += "<tfoot><td colspan=\"2\" class=\"text-right\"><button type=\"button\" class=\"btn btn-info disabled\">«</button><button type=\"button\" class=\"btn btn-default disabled\">" + data.page + "</button><button type=\"button\" class=\"btn btn-info disabled\">»</button></td></tfoot>";
			} else {
				short_content_html += "<tbody>"
					for(var index = 0; index < data.shrotReview.length; index++) {
						var short_object = data.shrotReview[index];
						short_content_html += "<tr><td>" + short_object.uname  + "看过&nbsp;" + short_object.rtime + "<br/>" + short_object.content + "</td><td class=\"text-right\">" + short_object.usenum;
						if(short_object.suppose == false) {
							short_content_html += "<button type=\"button\" onclick=\"add_approve(" + short_object.id +")\" class=\"btn btn-link\">有用</button></td></tr>"
						} else {
							short_content_html += "<button type=\"button\" onclick=\"cancel_approve(" + short_object.id + ")\" class=\"btn btn-link\">取消</button></td></tr>"
						}
					}
					short_content_html += "</tbody><tfoot><td colspan=\"2\" class=\"text-right\">"
					if(data.page <= 1) {
						short_content_html += "<button type=\"button\" class=\"btn btn-info disabled\">«</button>";
					} else {
						var pre_page = data.page - 1;
						short_content_html += "<button type=\"button\" onclick=\"query_short_common(" + pre_page + ")\" class=\"btn btn-info\">«</button>";
					}
					short_content_html += "<button type=\"button\" class=\"btn btn-default disabled\">" + data.page + "</button>";
					if(data.page >= data.pageCount) {
						short_content_html += "<button type=\"button\" class=\"btn btn-info disabled\">»</button>";
					} else {
						var next_page = data.page + 1;
						short_content_html += "<button type=\"button\" onclick=\"query_short_common(" + next_page + ")\" class=\"btn btn-info\">»</button>";
					}
					short_content_html += "</td></tfoot>";
			}
		}
		short_content.innerHTML += short_content_html;
	});
}

function query_long_common(current_page) {
	var uid = $("#uid").val();
	var mid = $("#mid").val();
	var film = $("#film").val();
	$.ajax({
		url : "common/query_long_common/" + current_page + "/10",
		type : 'POST',
		data: {
			"mid": mid
		}
	}).done(function(data) {
//		console.log(data);
		var long_content = document.getElementById("long_content_table");
		long_content.innerHTML = "";
		var long_content_html = "<thead><td colspan=\"3\">" + film + "的影评------(共有" + data.count + "条)</td><td class=\"text-right\">";
		if(uid == "") {
			long_content_html += "<button type=\"button\" onclick=\"login_click()\" class=\"btn btn-btn-link\">我要写影评</button>";
		} else {
			long_content_html += "<button type=\"button\" onclick=\"long_common()\" class=\"btn btn-btn-link\">我要写影评</button>";
		}
		long_content_html += "</td></thead><tbody>";
		if(data.count == 0) {
			long_content_html += "<tr><td rowspan=\"2\" colspan=\"4\" class=\"text-center\">暂时还无人评论,快成为第一个评论者吧...</td></tr></tbody>";
			long_content_html += "<tfoot><td colspan=\"4\" class=\"text-right\"><button type=\"button\" class=\"btn btn-info disabled\">«</button><button type=\"button\" class=\"btn btn-default disabled\">" + data.page + "</button><button type=\"button\" class=\"btn btn-info disabled\">»</button></td></tfoot>";
		} else {
			for(var index = 0; index < data.longReview.length; index++) {
				var long_object = data.longReview[index];
				long_content_html += "<tr><td><a href=\"common/query_long_review_by_id/"+ long_object.id + "\" target=\"_blank\">" + long_object.title + "</a></td><td>&nbsp;</td><td class=\"text-right\">" + long_object.usenum + "&nbsp;有用</td><td class=\"text-center\">" + long_object.unuse + "&nbsp;无用</td></tr>";
			}
			long_content_html += "</tbody><tfoot><td colspan=\"4\" class=\"text-right\">";
			// start
			if(data.page <= 1) {
				long_content_html += "<button type=\"button\" class=\"btn btn-info disabled\">«</button>";
			} else {
				var pre_page = data.page - 1;
				long_content_html += "<button type=\"button\" onclick=\"query_long_common(" + pre_page + ")\" class=\"btn btn-info\">«</button>";
			}
			long_content_html += "<button type=\"button\" class=\"btn btn-default disabled\">" + data.page + "</button>";
			if(data.page >= data.pageCount) {
				long_content_html += "<button type=\"button\" class=\"btn btn-info disabled\">»</button>";
			} else {
				var next_page = data.page + 1;
				long_content_html += "<button type=\"button\" onclick=\"query_long_common(" + next_page + ")\" class=\"btn btn-info\">»</button>";
			}
			// end
			long_content_html += "</td></tfoot>";
		}
		long_content.innerHTML += long_content_html;
	});
}

/**
 * 数据初始化
 */
query_short_common(1);
query_long_common(1);