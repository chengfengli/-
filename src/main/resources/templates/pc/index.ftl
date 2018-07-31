<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>学习空间</title>
        <#include "/pc/base.ftl"/>
        <link rel="stylesheet" href="${springMacroRequestContext.contextPath}/pc/css/index.css">
    </head>

    <body>
        <!--引入头部和左侧菜单-->
        <#include "/pc/header.ftl"/>
        <div class="body">
            <div id="index-left">
                <div class="group">
                    <h2 class="type">最新教程 <a class="index-more" href="">更多<i class="layui-icon layui-icon-next"></i></a></h2>
                    <#list list1 as note>
                        <div class="group-item">
                            <a href="${springMacroRequestContext.contextPath}/pc/note_details?noteId=${(note.noteId)!}" target="_blank" class="note-title">${(note.noteTitle?html)!}</a>
                            <div class="abstract">${(note.subtitle?html)!}</div>
                            <div class="sign">
                                <span class="tag"><i class="layui-icon layui-icon-note"></i><span class="count">${(note.tag)!}</span></span>
                                <span class="praise"><i class="layui-icon layui-icon-praise"></i><span class="count">${(note.useCount)!}</span></span>
                                <span class="tread"><i class="layui-icon layui-icon-tread"></i><span class="count">${(note.unusedCount)!}</span></span>
                                <span class="create-time">${(note.createTime)!}</span>
                            </div>
                        </div>
                    </#list>
                </div>

                <div class="group">
                    <h2 class="type">最新问题 <a class="index-more" href="">更多<i class="layui-icon layui-icon-next"></i></a></h2>
                    <#list list2 as note>
                        <div class="group-item">
                            <a href="${springMacroRequestContext.contextPath}/pc/note_details?noteId=${(note.noteId)!}" target="_blank" class="note-title">${(note.noteTitle?html)!}</a>
                            <div class="abstract">${(note.subtitle?html)!}</div>
                            <div class="sign">
                                <span class="tag"><i class="layui-icon layui-icon-note"></i><span class="count">${(note.tag)!}</span></span>
                                <span class="praise"><i class="layui-icon layui-icon-praise"></i><span class="count">${(note.useCount)!}</span></span>
                                <span class="tread"><i class="layui-icon layui-icon-tread"></i><span class="count">${(note.unusedCount)!}</span></span>
                                <span class="create-time">${(note.createTime)!}</span>
                            </div>
                        </div>
                    </#list>
                </div>
            </div>
            <div id="index-right">
                <div class="view">
                    <h3 class="view-name">数据总览</h3>
                    <ul class="list">
                        <#list list3 as item>
                            <li>${(item.name)!}<span class="count">(${(item.value)!})</span></li>
                        </#list>
                    </ul>
                </div>
                <div class="view">
                    <h3 class="view-name">热门教程</h3>
                    <ul class="list">
                        <#list hotCourse as note>
                        <li><a href="${springMacroRequestContext.contextPath}/pc/note_details?noteId=${(note.noteId)!}" target="_blank">${(note.noteTitle?html)!}</a></li>
                        </#list>
                    </ul>
                </div>
                <div class="view">
                    <h3 class="view-name">热门问题</h3>
                    <ul class="list">
                        <#list hotQuestion as note>
                        <li><a href="${springMacroRequestContext.contextPath}/pc/note_details?noteId=${(note.noteId)!}" target="_blank">${(note.noteTitle?html)!}</a></li>
                    </#list>
                    </ul>
                </div>
            </div>
        </div>
        <!--引入底部-->
        <#include "/pc/footer.ftl"/>
    </body>
    <script src="${springMacroRequestContext.contextPath}/pc/js/index.js"></script>
</html>