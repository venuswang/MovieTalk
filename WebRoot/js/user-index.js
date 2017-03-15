/**
 * 首页数据的加载
 */

function query_all_films(currentPage) {
	$.ajax({
		url : "common/query_all_film/" + currentPage + "/10",
		type : 'POST',
	}).done(function(data) {
		debugger;
		var div_content = document.getElementById("div-content");
		var div_footer = document.getElementById("div-footer");
		div_content.innerHTML = "";
		div_footer.innerHTML = "";
		if(data.count == 0) {
			var append_html = "<div class=\"row bootstrap-admin-light-padding-bottom\"><div class=\"col-md-3 head-img-size\"></div><div class=\"col-md-6 head-img-size font-position\">无影片信息<div></div>";
			div_content.innerHTML += append_html;
			var footer_html = "共有" + data.count + "条，每页显示：10条" + "<div class=\"pull-right\"><ul class=\"list-inline\"><li class=\"disabled\"><a>«</a></li><li ><a>" + data.page + "</a></li><li class=\"disabled\"><a>»</a></li></ul></div>"
			div_footer.innerHTML += footer_html;
		} else {
			// content start
			var content_html_start = "";
			var common_start = "<div class=\"row bootstrap-admin-light-padding-bottom\"><div class=\"col-md-3 head-img-size\"></div>";
			for(var index = 0; index < data.count; index++) {
				if(index % 3 == 0) {
					content_html_start += common_start;
				}
				var img_id = "img" + index;
				var temp_html = "<div class=\"col-md-2 head-img-size\"> <a href=\"common/query_film_by_id/" + data.mList[index].id + "\" class=\"thumbnail\" id=\"" + img_id + "\"><img src=\"/pic/" + data.mList[index].picname + "\" style=\"width:175px;height:222px\"></a></div>";
				content_html_start += temp_html;
				if(index % 3 == 2 && index != data.count - 1) {
					content_html_start += "</div>";
				}
			}
			content_html_start += "</div>";
			div_content.innerHTML += content_html_start;
			// footer start
			var footer_html_start = "共有" + data.count + "条，每页显示：10条" + "<div class=\"pull-right\"><ul class=\"list-inline\">";
			if(data.page <= 1) {
				footer_html_start += "<li class=\"disabled\"><a>«</a></li><li ><a>"+ data.page + "</a></li>";
			} else {
				var pre_page = data.page - 1;
				footer_html_start += "<li><a onclick=\"query_all_films(" + pre_page + ")\">«</a></li><li ><a>"+ data.page + "</a></li>";
			}
			if(data.page >= data.pageCount) {
				footer_html_start += "<li class=\"disabled\"><a>»</a></li></ul></div>";
			} else {
				var next_page = data.page + 1;
				footer_html_start += "<li><a onclick=\"query_all_films(" + next_page + ")\">»</a></li></ul></div>";
			}
			div_footer.innerHTML += footer_html_start;
			Opentip.styles.myNormalStyle = {
				        "extends": "standard",
				        stem: true,
				        showOn: "mouseover",
				        tipJoint: "left"
				    };
			for(var i = 0; i < data.count; i++) {
				var img_id = "#img" + i;
				var list = data.mList[i];
				var img_msg = "影名:" + list.filname + "<br/>导演:" + list.director + "<br/>编剧:" + list.editor + "<br/>制片国家:" + list.nation + "<br />语言:" + list.voice + "<br />时长:" + list.duration + "<br />简介:" + list.content;
				new Opentip($(img_id), img_msg, {
					target : img_id,
					style : "myNormalStyle"
				});
			}
		}
	});
}
query_all_films(1);