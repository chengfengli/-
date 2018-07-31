<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
        <title>学习空间</title>
        <#include "/wap/base.ftl"/>
        <link rel="stylesheet" href="${springMacroRequestContext.contextPath}/wap/css/index.css">
    </head>

    <body>
        <!--引入头部和左侧菜单-->
        <#include "/wap/header.ftl"/>
        <div class="body">
            <h2 class="type">最新教程</h2>
            <#list list1 as note>
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

            <h2 class="type">最新问答</h2>
            <#list list2 as note>
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
        <!--引入底部-->
    </body>
    <script src="${springMacroRequestContext.contextPath}/wap/js/index.js"></script>
</html>