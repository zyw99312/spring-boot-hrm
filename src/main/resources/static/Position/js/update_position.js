$(function () {
	layui.use(['layer', 'element'], function () {
		var layer = layui.layer,
			element = layui.element;
		$('#submit').click(function () {
			layer.load(0,{time: 3*1000});
		});
	});

});