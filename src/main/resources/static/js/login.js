$(function () {

        const basePath = $('#basePath').val();
        layui.use(['layer', 'element'], function () {
            const layer = layui.layer,
            element = layui.element;

            $('#submit').click(function () {
                    layer.load(0,{time: 2*1000});
            /*$.ajax({
                url: basePath+'/checkLogin',
                type: 'post',
                data: {
                    'username' : $('#username').val(),
                    "password" : $('#password').val(),
                },
                beforeSend : function () {
                    layer.load(0,{time: 2*1000});
                },
                success : function (data, response, status) {
                    var obj = eval(data);
                    if (obj.success) {
                        location.href = basePath+'/toMain';
                    } else {
                        layer.msg('登陆失败',{icon:2});
                    }
                }
            });
            return false;*/
        });
    });

});