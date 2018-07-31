<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
        <title>${(note.noteTitle)!}</title>
        <#include "/wap/base.ftl"/>
        <link rel="stylesheet" href="${springMacroRequestContext.contextPath}/wap/css/details.css">
        <link rel="stylesheet" href="${springMacroRequestContext.contextPath}/commons/highlight/styles/default.css">
        <script src="${springMacroRequestContext.contextPath}/commons/highlight/highlight.pack.js"></script>
    </head>

    <body>
        <!--引入头部和左侧菜单-->
        <#include "/wap/header.ftl"/>
        <div class="body">
            <input type="hidden" id="id" value="${(note.noteId)!}">
            <h2 class="details-note-title">${(note.noteTitle?html)!}</h2>
            <div class="sign">
                <span class="tag"><i class="layui-icon layui-icon-note"></i><span class="count">${(note.tag)!}</span></span>
                <span class="praise"><i class="layui-icon layui-icon-praise"></i><span class="count">${(note.useCount)!}</span></span>
                <span class="tread"><i class="layui-icon layui-icon-tread"></i><span class="count">${(note.unusedCount)!}</span></span>
                <span class="create-time">${(note.createTime)!}</span>
            </div>
            <div class="details-content">${(note.noteTxt)!}</div>
            <div>
                <#if files?? && (files?size > 0)>
                    <h3 style="margin: 10px 0;font-weight: bold">附件：</h3>
                    <#list files as file>
                        <div class="file-list">
                            <div class="file-name"><a href="${springMacroRequestContext.contextPath}/file/download?fileId=${(file.fileId)!}">${(file.fileName)!}</a></div>
                        </div>
                    </#list>
                </#if>
            </div>
            <div class="comment">
                <button type="button" id="praise" class="layui-btn layui-btn-normal" title="点个赞呗"><i class="layui-icon layui-icon-praise"></i></button>
                <button type="button" id="tread" class="layui-btn layui-btn-primary" title="手下留情"><i class="layui-icon layui-icon-tread"></i></button>
            </div>
            <div>
                <h3 style="margin: 10px 0;">发表评论：</h3>
                <div class="layui-form">
                    <textarea maxlength="200" placeholder="请输入评价内容,200个字以内" class="layui-textarea"></textarea>
                    <button type="button" id="submit" class="layui-btn layui-btn-normal">提交</button>
                </div>
            </div>
        </div>
        <!--引入底部-->

    </body>
    <script src="${springMacroRequestContext.contextPath}/wap/js/details.js"></script>
    <script>
        hljs.initHighlightingOnLoad();
    </script>
</html>