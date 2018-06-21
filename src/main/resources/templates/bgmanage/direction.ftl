<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>学习空间后台管理系统-方向管理</title>
        <#include "/commons/base.ftl"/>
    </head>

    <body class="layui-layout-body">
        <div class="layui-layout layui-layout-admin">
            <!--引入头部和左侧菜单-->
            <#include "/commons/headandmenu.ftl"/>

            <div class="layui-body">
                <button id="add-btn" class="layui-btn">新增</button>
                <table id="direction-list"></table>
            </div>

            <!--引入底部-->
            <#include "/commons/footer.ftl"/>
        </div>
    </body>
    <script src="${springMacroRequestContext.contextPath}/bgmanage/js/direction.js"></script>
</html>