<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>学习空间后台管理系统</title>
        <#include "/commons/base.ftl"/>
    </head>

    <body class="layui-layout-body">
        <div class="layui-layout layui-layout-admin">
            <!--引入头部和左侧菜单-->
            <#include "/commons/headandmenu.ftl"/>

            <div class="layui-body">
                <div style="padding: 15px;">方向</div>
            </div>

            <!--引入底部-->
            <#include "/commons/footer.ftl"/>
        </div>
    </body>
    <script>
        //JavaScript代码区域
        layui.use('element', function(){
            var element = layui.element;

        });
    </script>
</html>