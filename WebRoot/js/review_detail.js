/**
 * 长评界面js
 */
function review_reply() {
	$("#answerReviewModal").modal("show");
}

function review_reply_save() {
	var lid = $("#lid").val();
	var content = $("#answer_common").val();
	var url = "custom/review_reply_save";
	$.ajax({
		url : url,
		type : 'POST',
		data : {
			"lid": lid,
			"content": content
		}
	}).done(function(res) {
		if (res.result) {
			$("#answerReviewModal").modal("hide");
			query_reply(1);
		} else {
			toastr.error(res.message, "温馨提示", {
				preventDuplicates : true,
			});
		}
	});
}

function review_reply_delete(id) {
	var url = "custom/review_reply_delete";
	$.ajax({
		url : url,
		type : 'POST',
		data : {
			"id": id
		}
	}).done(function(res) {
		if (res.result) {
			query_reply(1);
		} else {
			toastr.error(res.message, "温馨提示", {
				preventDuplicates : true,
			});
		}
	});
}

function l_approve_add() {
	var id = $("#lid").val();
	var url = "custom/l_approve_add";
	$.ajax({
		url : url,
		type : 'POST',
		data : {
			"id": id
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

function l_approve_cancel() {
	var id = $("#lid").val();
	var url = "custom/l_approve_cancel";
	$.ajax({
		url : url,
		type : 'POST',
		data : {
			"id": id
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

function l_anti_add() {
	var id = $("#lid").val();
	var url = "custom/l_anti_add";
	$.ajax({
		url : url,
		type : 'POST',
		data : {
			"id": id
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


function l_anti_cancel() {
	var id = $("#lid").val();
	var url = "custom/l_anti_cancel";
	$.ajax({
		url : url,
		type : 'POST',
		data : {
			"id": id
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

function query_reply(current_page) {
	var uid = $("#uid").val();
	var lid = $("#lid").val();
	var film = $("#film").val();
	$.ajax({
		url : "common/query_review_reply/" + current_page + "/10",
		type : 'POST',
		data: {
			"lid": lid
		}
	}).done(function(data) {
//		console.log(data);
		var answer_content = document.getElementById("answer_content_table");
		answer_content.innerHTML = "";
		var answer_content_html = "";
		if(uid == "") {
			answer_content_html = "<thead><td>" + film + "的影评回复------(共有" + data.count + "条)</td><td class=\"text-right\"><button type=\"button\" onclick=\"login_click()\" class=\"btn btn-btn-link\">回复</button></td></thead>";
			if(data.count == 0) {
				answer_content_html += "<tbody><tr><td rowspan=\"2\" colspan=\"2\" class=\"text-center\">暂时还无人评论,快成为第一个评论者吧...</td></tr></tbody>";
				answer_content_html += "<tfoot><td colspan=\"2\" class=\"text-right\"><button type=\"button\" class=\"btn btn-info disabled\">«</button><button type=\"button\" class=\"btn btn-default disabled\">" + data.page + "</button><button type=\"button\" class=\"btn btn-info disabled\">»</button></td></tfoot>";
			} else {
				answer_content_html += "<tbody>";
				for(var index = 0; index < data.reply.length; index++) {
					var reply_object = data.reply[index];
					answer_content_html += "<tr><td>" + reply_object.uname + "&nbsp;" + reply_object.rtime + "&nbsp;发表<br/>" + reply_object.content + "</td><td class=\"text-right\">&nbsp;</td></tr>";
				}
				answer_content_html += "</tbody><tfoot><td colspan=\"2\" class=\"text-right\">";
				// start
				if(data.page <= 1) {
					answer_content_html += "<button type=\"button\" class=\"btn btn-info disabled\">«</button>";
				} else {
					var pre_page = data.page - 1;
					answer_content_html += "<button type=\"button\" onclick=\"query_reply(" + pre_page + ")\" class=\"btn btn-info\">«</button>";
				}
				answer_content_html += "<button type=\"button\" class=\"btn btn-default disabled\">" + data.page + "</button>";
				if(data.page >= data.pageCount) {
					answer_content_html += "<button type=\"button\" class=\"btn btn-info disabled\">»</button>";
				} else {
					var next_page = data.page + 1;
					answer_content_html += "<button type=\"button\" onclick=\"query_reply(" + next_page + ")\" class=\"btn btn-info\">»</button>";
				}
				answer_content_html += "</td></tfoot>";
				// end
			}
		} else {
			answer_content_html = "<thead><td>" + film + "的影评回复------(共有" + data.count + "条)</td><td class=\"text-right\"><button type=\"button\" onclick=\"review_reply()\" class=\"btn btn-btn-link\">回复</button></td></thead>";
			if(data.count == 0) {
				answer_content_html += "<tbody><tr><td rowspan=\"2\" colspan=\"2\" class=\"text-center\">暂时还无人评论,快成为第一个评论者吧...</td></tr></tbody>";
				answer_content_html += "<tfoot><td colspan=\"2\" class=\"text-right\"><button type=\"button\" class=\"btn btn-info disabled\">«</button><button type=\"button\" class=\"btn btn-default disabled\">" + data.page + "</button><button type=\"button\" class=\"btn btn-info disabled\">»</button></td></tfoot>";
			} else {
				answer_content_html += "<tbody>";
				for(var index = 0; index < data.reply.length; index++) {
					var reply_object = data.reply[index];
					if(reply_object.uid == uid) {
						answer_content_html += "<tr><td>" + reply_object.uname + "&nbsp;" + reply_object.rtime + "&nbsp;发表<br/>" + reply_object.content + "</td><td class=\"text-right\"><button type=\"button\" onclick=\"review_reply_delete(" + reply_object.id + ")\" class=\"btn btn-btn-link\">删除</button></td></tr>";
					} else {
						answer_content_html += "<tr><td>" + reply_object.uname + "&nbsp;" + reply_object.rtime + "&nbsp;发表<br/>" + reply_object.content + "</td><td class=\"text-right\">&nbsp;</td></tr>";
					}
				}
				answer_content_html += "</tbody><tfoot><td colspan=\"2\" class=\"text-right\">";
				// start
				if(data.page <= 1) {
					answer_content_html += "<button type=\"button\" class=\"btn btn-info disabled\">«</button>";
				} else {
					var pre_page = data.page - 1;
					answer_content_html += "<button type=\"button\" onclick=\"query_reply(" + pre_page + ")\" class=\"btn btn-info\">«</button>";
				}
				answer_content_html += "<button type=\"button\" class=\"btn btn-default disabled\">" + data.page + "</button>";
				if(data.page >= data.pageCount) {
					answer_content_html += "<button type=\"button\" class=\"btn btn-info disabled\">»</button>";
				} else {
					var next_page = data.page + 1;
					answer_content_html += "<button type=\"button\" onclick=\"query_reply(" + next_page + ")\" class=\"btn btn-info\">»</button>";
				}
				answer_content_html += "</td></tfoot>";
				// end
			}
		}
		answer_content.innerHTML += answer_content_html;
	});
}

query_reply(1);