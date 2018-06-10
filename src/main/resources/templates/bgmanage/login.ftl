<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>学习空间后台管理系统-用户登陆</title>
        <#include "/commons/base.ftl"/>
        <link rel="stylesheet" href="${springMacroRequestContext.contextPath}/bgmanage/css/login.css"  media="all">
    </head>

    <body>
        <canvas id="canvas"></canvas>
        <form  class="login-box layui-form layui-form-pane" action="return false;">
            <h2 class="login-title"><span>学习空间</span>管理系统</h2>
            <div class="login-project">管理员登陆</div>
            <div class="layui-form">
                <div class="layui-form-item">
                    <label class="layui-form-label">
                        <i class="layui-icon layui-icon-username" style="font-size: 20px;"></i>
                    </label>
                    <div class="layui-input-block">
                        <input type="text" name="title" required="" lay-verify="required" placeholder="请输入登陆账号" autocomplete="off" class="layui-input layui-form-danger">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">
                        <i class="layui-icon layui-icon-password" style="font-size: 20px;"></i>
                    </label>
                    <div class="layui-input-block">
                        <input type="password" required  lay-verify="required" placeholder="请输入登陆密码" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <button lay-submit lay-filter="formDemo" class="layui-btn layui-btn-normal layui-btn-fluid">登陆</button>
                </div>
                <div class="motto">
                    积水成渊，积土成山，每天记录一点点！
                </div>
            </div>
        </form >
    </body>
    <script src="${springMacroRequestContext.contextPath}/bgmanage/js/canvas.js"></script>
    <script src="${springMacroRequestContext.contextPath}/bgmanage/js/login.js"></script>
</html>