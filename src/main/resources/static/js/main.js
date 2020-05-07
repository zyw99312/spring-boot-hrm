layui.use(['laydate', 'laypage', 'layer', 'table', 'carousel', 'upload', 'element', 'slider'], function(){
        var laydate = layui.laydate //日期
            ,laypage = layui.laypage //分页
            ,layer = layui.layer //弹层
            ,table = layui.table //表格
            ,carousel = layui.carousel //轮播
            ,upload = layui.upload //上传
            ,element = layui.element //元素操作
            ,slider = layui.slider //滑块

//绝对路径
const basePath = $('#basePath').val();

$(function () {

    //点击logo跳转
    /*$('.layui-logo').click(function () {
        location.href = "/hrm/development_info.html";
    });*/
    //welcome
    layer.open({
        type: 1
        ,title: false
        ,area: '600px'
        ,shade: 0.8
        ,id: 'LAY_welcome' //设定一个id，防止重复弹出
        ,moveType: 1 //拖拽模式，0或者1
        ,content:
            "<div style='padding:15px;line-height: 20px;background-color: #393D49; color: #aac5e7;'"
            +"<p><b style='font-size:20pt'>欢迎使用：</b></p>"
            +"\-------------------------------------------------------------------------------"
            +"\n<p></p>"
            +"<p style='font-size:14pt'>Development tools and technical support.</p>"
            +"<ul>\n" +
            "\t                <li>This system USES LayUI to develop the front end.</li>\n" +
            "\t                <li>Development tools using IDEA 2019.3 x64.</li>\n" +
            "\t                <li>The database is visually developed using Navicat Premium 15.</li>\n" +
            "\t                <li>Background development USES the popular SpringBoot framework for development.</li>\n" +
            "\t                <li>For graduation design.</li>\n" +
            "\t                <li>Author: Alvi Zhong | date: In March 2020.</li>\n<br>" +
            "\t            </ul>"
            +"</div>"

            +"<div style='padding:15px;line-height: 20px;background-color: #393D49; color: #aac5e7;'"+
            +"<p style=\"font-size:12pt\">开发工具及技术支持.</p>"
            +"<ul>\n" +
            "\t                <li>本系统使用 LayUI 来进行前端开发.</li>\n" +
            "\t                <li>开发工具使用 IDEA 2019.3 x64.</li>\n" +
            "\t                <li>数据库使用 Navicat Premium 15 进行可视化开发.</li>\n" +
            "\t                <li>后台开发使用流行的 SpringBoot 框架进行开发 .</li>\n" +
            "\t                <li>作者: 钟友维　|　日期: 2020年3月.</li>\n" +
            "\t            </ul>"
            +'</div>'
    });
    //个人信息
    $('#myInfo').click(function () {
        layer.open({            type: 1
            ,title: false
            ,area: '400px'
            ,shade: 0.8
            ,id: 'LAY_myInfo' //设定一个id，防止重复弹出
            ,moveType: 1 //拖拽模式，0或者1
            ,content:
                "<div style='padding:15px;line-height: 20px;background-color: #393D49; color: #aac5e7;'"
                +"<p><b style='font-size:20pt'>个人信息：</b></p>"
                +"\-------------------------------------------------------------------------------"
                +"\n<p></p>"
                +'<ul>\n'
                +"<li>姓　名：  　　　　　　　　　　　钟友维</li>\n"
                +"<li>性　别：  　　　　　　　　　　　男</li>\n"
                +"<li>手机号：　　　　　　　　　　 　15073811481</li>\n"
                +"<li>邮　箱：　　　　　　　　 　　　2503737810@qq.com</li>\n"
                +"</ul>"
                +"</div>"
        });
        return false;
    });

    //安全设置
    $('#mySecurity').click(function () {
        layer.open({            type: 1
            ,title: false
            ,area: '400px'
            ,shade: 0.8
            ,id: 'LAY_mySecurity' //设定一个id，防止重复弹出
            ,moveType: 1 //拖拽模式，0或者1
            ,content:
                "<div style='padding:15px;line-height: 20px;background-color: #393D49; color: #aac5e7;'"
                +"<p><b style='font-size:20pt'>安全设置：</b></p>"
                +"\-------------------------------------------------------------------------------"
                +"\n<p></p>"
                +'<ul>\n'
                +"<li>√　安全级别：  高</li>\n<br>"
                +"<li>√　为了您公司的信息安全请勿将账号给与非管理人员.</li>\n<br>"
                +"<li>√　如果忘记账号密码请在数据库中手动添加超级管理员.</li>\n<br>"
                +"<li>√　作者绝对不会留下任何后门.</li>\n"
                +"</ul>"
                +"</div>"
        });
        return false;
    });

    //注销登录
    $('.logout').click(function () {
        layer.confirm('是否退出登录？', {
            btn: ['确定', '取消'] //可以无限个按钮
        }, function(){
            layer.msg('　已退出登录！',{icon: 6});
            window.location.href = basePath+'/logout';
        }, function(){

            layer.msg('　　已取消！',{icon: 6});
        });

        return false;
    });

    //签到
    $('#qiandao').click(function () {
        layer.msg('　　签到成功！',{icon: 1});
        return false;
    });
    //请假
    $('#qingjia').click(function () {
        layer.msg('　　请与领导面谈！',{icon: 2});
        return false;
    });

    //帮助
    $('#help').click(function () {
        layer.open({
            type: 1
            ,title: false
            ,area: '400px'
            ,shade: 0.8
            ,id: 'LAY_help' //设定一个id，防止重复弹出
            ,moveType: 1 //拖拽模式，0或者1
            ,content:
                "<div style='padding:15px;line-height: 20px;background-color: #393D49; color: #aac5e7;'"
                +"<p><b style='font-size:20pt'>帮　助：</b></p>"
                +"\-------------------------------------------------------------------------------"
                +"\n<p></p>"
                +'<ul>\n'
                +"<li>新增管理员：  　　　　　　　　　账号管理-->新增账号</li>\n"
                +"<li>修改账号信息： 　　　　　　　　账号管理-->账号管理</li>\n"

                +"<li>新增部门：　　　　　　　　　　 部门管理-->新增部门</li>\n"
                +"<li>修改部门信息：　　　　　　　　 部门管理-->部门管理</span>\n"

                +"<li>新增职位：　　　　　　　　　 　职位管理-->新增职位</li>\n"
                +"<li>修改职位信息： 　　　　　　　　职位管理-->职位管理</li>\n"

                +"<li>新增员工：　　　　　　　　　 　员工管理-->新增员工</li>\n"
                +"<li>修改员工信息：　 　　　　　　　员工管理-->账号管理</li>\n<br>"

                +"<li>查看公告：　　　　　 　　　　　　-->公告</li><br>"
                +"<li>下载应用： 　　　　　　　　　　　-->下载</li><br>"
                +"</ul>"
                +"</div>"
        });
        return false;
    });

    //技术支持
    $('#support').click(function () {

        layer.open({
            type: 1
            ,title: false
            ,area: '410px'
            ,shade: 0.8
            ,id: 'LAY_support' //设定一个id，防止重复弹出
            ,moveType: 1 //拖拽模式，0或者1
            ,content:
                "<div style='padding:15px;line-height: 20px;background-color: #393D49; color: #aac5e7;'"
                +"<p><b style='font-size:20pt'>技术支持：</b></p>"
                +"\-------------------------------------------------------------------------------"
                +"\n<p></p>"
                +"<p style=\"font-size:12pt\">Development tools and technical support.</p>"
                +"<ul>\n" +
                "\t                <li>This system USES LayUI to develop the front end.</li>\n" +
                "\t                <li>Development tools using IDEA 2019.3 x64.</li>\n" +
                "\t                <li>The database is visually developed using Navicat Premium 15.</li>\n" +
                "\t                <li>Background development USES the popular SpringBoot framework for development.</li>\n" +
                "\t                <li>For graduation design.</li>\n" +
                "\t                <li>Author: Alvi Zhong | date: In March 2020.</li>\n<br>" +
                "\t            </ul>"
                +"</div>"

                +"<div style='padding:15px;line-height: 20px;background-color: #393D49; color: #aac5e7;'"+
                +"<p style=\"font-size:12pt\">开发工具及技术支持.</p>"
                +"<ul>\n" +
                "\t                <li>本系统使用 LayUI 来进行前端开发.</li>\n" +
                "\t                <li>开发工具使用 IDEA 2019.3 x64.</li>\n" +
                "\t                <li>数据库使用 Navicat Premium 15 进行可视化开发.</li>\n" +
                "\t                <li>后台开发使用流行的 SpringBoot 框架进行开发 .</li>\n" +
                "\t                <li>作者: 钟友维　|　日期: 2020年3月.</li>\n" +
                "\t            </ul>"
                +'</div>'
        });
        return false;
    });

    //关于
    $('#about').click(function () {
        //示范一个公告层
        layer.open({
            type: 1
            ,title: false
            ,area: '400px;'
            ,shade: 0.8
            ,id: 'LAY_about' //设定一个id，防止重复弹出
            ,moveType: 0 //拖拽模式，0或者1
            ,content:
                "<div style='padding:15px;line-height: 20px;background-color: #393D49; color: #aac5e7;'"
                +"<p><b style='font-size:20pt'>欢迎使用：</b></p>"
                +"\-------------------------------------------------------------------------------"
                +"\n<p></p>"
                +"<p style=\"font-size:12pt\">Technology related.</p>"
                +"<ul>\n" +
                "\t                <li>Background development USES the popular SpringBoot framework for development.</li>\n" +
                "\t                <li>For graduation design.</li>\n" +
                "\t                <li>Author: Alvi Zhong | date: In March 2020.</li>\n<br>" +
                "\t            </ul>"
                +"</div>"
                +"<div style='padding:15px;line-height: 20px;background-color: #393D49; color: #aac5e7;'"+
                +"<p style=\"font-size:12pt\">技术相关.</p>"
                +"<ul>\n" +
                "\t                <li>后台开发使用流行的 SpringBoot 框架进行开发 .</li>\n" +
                "\t                <li>用于毕业设计.</li>\n" +
                "\t                <li>作者: 钟友维　|　日期: 2020年3月.</li>\n" +
                "\t            </ul>"
                +'</div>'
        });
    });


});

});