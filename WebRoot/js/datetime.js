/**
 * 时间处理
 */
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