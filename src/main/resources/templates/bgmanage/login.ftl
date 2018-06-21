<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
        <title>学习空间后台管理系统-用户登陆</title>
        <#include "/commons/base.ftl"/>
        <link rel="stylesheet" href="${springMacroRequestContext.contextPath}/bgmanage/css/login.css"  media="all">
    </head>

    <body>
        <canvas id="canvas"></canvas>
        <div  class="login-box layui-form layui-form-pane">
            <h2 class="login-title"><span>学习空间</span>管理系统</h2>
            <div class="login-project">管理员登录</div>
            <div class="layui-form">
                <div class="layui-form-item">
                    <label class="layui-form-label">
                        <i class="layui-icon layui-icon-username" style="font-size: 20px;"></i>
                    </label>
                    <div class="layui-input-block">
                        <input type="text" id="account" required lay-verify="required" placeholder="请输入登录账号" autocomplete="off" class="layui-input layui-form-danger">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">
                        <i class="layui-icon layui-icon-password" style="font-size: 20px;"></i>
                    </label>
                    <div class="layui-input-block">
                        <input type="password" id="password" required  lay-verify="required" placeholder="请输入登录密码" autocomplete="off" class="layui-input layui-form-danger">
                    </div>
                </div>
                <div class="layui-form-item">
                    <button class="login-btn layui-btn layui-btn-normal layui-btn-fluid">登&nbsp;&nbsp;录</button>
                </div>
                <div class="motto">积水成渊，积土成山，每天记录一点点！</div>
            </div>
        </div >
    </body>
    <script src="${springMacroRequestContext.contextPath}/bgmanage/js/canvas.js"></script>
    <script src="${springMacroRequestContext.contextPath}/bgmanage/js/login.js"></script>
</html>