<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>日志管理</title>
        <#include "/commons/base.ftl"/>
        <link rel="stylesheet" href="${springMacroRequestContext.contextPath}/bgmanage/css/log.css">
    </head>

    <body class="layui-layout-body">
        <div class="layui-layout layui-layout-admin">
            <!--引入头部和左侧菜单-->
            <#include "/commons/headandmenu.ftl"/>

            <div class="layui-body">
                <div class="layui-form">
                    <div class="layui-form-item">
                        <label class="layui-form-label">操作用户</label>
                        <div class="layui-input-inline">
                            <input type="text" id="userName" autocomplete="off" class="layui-input">
                        </div>
                        <label class="layui-form-label">操作时间</label>
                        <div class="layui-input-inline">
                            <input type="text" readonly class="layui-input" id="startTime">
                            <i class="layui-icon layui-icon-date"></i>
                        </div>
                        <label class="layui-form-label" style="width: 14px;margin-right: 10px;">至</label>
                        <div class="layui-input-inline">
                            <input type="text" readonly class="layui-input" id="endTime">
                            <i class="layui-icon layui-icon-date"></i>
                        </div>

                        <button id="select-btn" class="layui-btn layui-btn-normal">查询</button>
                    </div>
                </div>
                <table id="list"></table>
            </div>

            <!--引入底部-->
            <#include "/commons/footer.ftl"/>
        </div>
    </body>
    <script src="${springMacroRequestContext.contextPath}/bgmanage/js/log.js"></script>
</html>