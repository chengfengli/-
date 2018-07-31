<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>编辑方向</title>
        <#include "/commons/base.ftl"/>
    </head>

    <body style="margin-top: 20px">
        <div class="layui-form">
            <div class="layui-form-item">
                <label class="layui-form-label">方向名称</label>
                <div class="layui-input-inline">
                    <input type="hidden" id="id" value="${(direction.directionId)!}">
                    <input type="text" id="directionName" maxlength="10"  value="${(direction.directionName)!}" style="width: 200px;" required  lay-verify="required" placeholder="长度10个字符以内" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
    </body>
    <script src="${springMacroRequestContext.contextPath}/bgmanage/js/edit_direction.js"></script>
</html>