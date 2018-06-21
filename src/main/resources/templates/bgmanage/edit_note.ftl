<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>添加/编辑笔记</title>
        <#include "/commons/base.ftl"/>
        <link rel="stylesheet" href="${springMacroRequestContext.contextPath}/commons/wangEditor/wangEditor.min.css">
        <link rel="stylesheet" href="${springMacroRequestContext.contextPath}/commons/stream/css/stream-v1.css">
        <link rel="stylesheet" href="${springMacroRequestContext.contextPath}/bgmanage/css/edit_note.css">
    </head>

    <body class="layui-layout-body" style="width: 100%;">
        <div class="layui-layout layui-layout-admin">
            <!--引入头部和左侧菜单-->
            <#include "/commons/headandmenu.ftl"/>

            <div class="layui-body">
                <form class="layui-form" action="return false">
                    <div class="layui-form-item">
                        <label class="layui-form-label">标题</label>
                        <div class="layui-input-block">
                            <input type="text" name="title" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">所属方向</label>
                        <div class="layui-input-block">
                            <select name="city" lay-verify="required">
                                <option value=""></option>
                                <option value="0">北京</option>
                                <option value="1">上海</option>
                                <option value="2">广州</option>
                                <option value="3">深圳</option>
                                <option value="4">杭州</option>
                            </select>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">内容</label>
                        <div class="layui-input-block">
                            <div id="content"></div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">附件</label>
                        <div class="layui-input-block">
                            <div id="i_select_files" class="layui-btn layui-btn-primary">请选择文件</div>
                            <div id="i_stream_files_queue"></div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-input-block">
                            <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                        </div>
                    </div>
                </form>
            </div>

            <!--引入底部-->
            <#include "/commons/footer.ftl"/>
        </div>
    </body>
    <script src="${springMacroRequestContext.contextPath}/commons/wangEditor/wangEditor.min.js"></script>
    <script src="${springMacroRequestContext.contextPath}/commons/stream/js/stream-v1.js"></script>
    <script src="${springMacroRequestContext.contextPath}/bgmanage/js/edit_note.js"></script>
</html>