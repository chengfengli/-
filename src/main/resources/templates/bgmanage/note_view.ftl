<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>${(note.noteTitle)!}</title>
        <#include "/pc/base.ftl"/>
        <link rel="stylesheet" href="${springMacroRequestContext.contextPath}/pc/css/details.css">
        <link rel="stylesheet" href="${springMacroRequestContext.contextPath}/commons/highlight/styles/default.css">
        <script src="${springMacroRequestContext.contextPath}/commons/highlight/highlight.pack.js"></script>
    </head>

    <body>
        <div class="body">
            <h2 class="details-note-title">${(note.noteTitle)!}</h2>
            <div class="sign">
                <span class="tag"><i class="layui-icon layui-icon-note"></i><span class="count">${(note.tag)!}</span></span>
                <span class="praise"><i class="layui-icon layui-icon-praise"></i><span class="count">0</span></span>
                <span class="tread"><i class="layui-icon layui-icon-tread"></i><span class="count">0</span></span>
                <span class="create-time">xxxx-xx-xx xx:xx</span>
            </div>
            <div class="details-content">${(note.noteTxt)!}</div>
            <div>
                <h3 style="margin: 10px 0;font-weight: bold">附件：</h3>
                <div class="file-list">
                    <div class="file-name">附件名称附件名称附件名称</div>
                    <div class="down"><a href="#">下载</a></div>
                </div>
                <div class="file-list">
                    <div class="file-name">附件名称附件名称附件名称</div>
                    <div class="down"><a href="#">下载</a></div>
                </div>
            </div>
        </div>
    </body>
    <script>
        hljs.initHighlightingOnLoad();
    </script>
</html>