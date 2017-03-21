/**
 * 用户电影收藏夹js
 */

function cancel_collect(mid) {
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