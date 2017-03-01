/**
 * 加载admin_list中的数据模块
 */
$.fn.modal.Constructor.prototype.enforceFocus = function () {
	
}
$.ajax({
		url : "admin/query_all_tag",
		type : 'POST',
		}).done(function(data) {
			$("#tag_select .select2_box").select2({
			    width: 511,
				placeholder: "请选择影片标签",
				data: data
			});
		});

$.ajax({
	url : "admin/query_all_actor",
	type : 'POST',
}).done(function(data) {
	$('#actorid').select2({
		width: 511,
		multiple: true,
		placeholder: "请选择影片演员",
		data: data
	});
});

$.ajax({
	url : "admin/query_all_type",
	type : 'POST',
}).done(function(data) {
	$('#typeid').select2({
		width: 511,
		multiple: true,
		placeholder: "请选择影片类型",
		data: data
	});
});
