<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
        <title>学习空间</title>
        <#include "/wap/base.ftl"/>
        <link rel="stylesheet" href="${springMacroRequestContext.contextPath}/wap/css/list.css">
        <script>
            var total = parseInt('${(total)!}');
        </script>
    </head>

    <body>
        <!--引入头部和左侧菜单-->
        <#include "/wap/header.ftl"/>
        <div class="body">
            <div id="data">
                <#list list as note>
                <a href="${springMacroRequestContext.contextPath}/wap/details?noteId=${(note.noteId)!}" class="item">
                    <div class="note-name">${(note.noteTitle?html)!}</div>
                    <div class="note-subtitle">${(note.subtitle?html)!}</div>
                    <div class="sign">
                        <span class="tag"><i class="layui-icon layui-icon-note"></i><span class="count">${(note.tag)!}</span></span>
                        <span class="praise"><i class="layui-icon layui-icon-praise"></i><span class="count">${(note.useCount)!}</span></span>
                        <span class="tread"><i class="layui-icon layui-icon-tread"></i><span class="count">${(note.unusedCount)!}</span></span>
                        <span class="create-time">${(note.createTime)!}</span>
                    </div>
                </a>
                </#list>
            </div>
            <button id="load-more" class="layui-btn layui-btn-primary layui-btn-sm">加载更多</button>
        </div>
        <!--引入底部-->
    </body>
    <script src="${springMacroRequestContext.contextPath}/wap/js/list.js"></script>
</html>