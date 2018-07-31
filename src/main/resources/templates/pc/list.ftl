<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>学习空间</title>
        <#include "/pc/base.ftl"/>
        <link rel="stylesheet" href="${springMacroRequestContext.contextPath}/pc/css/list.css">
        <script>
            var total = parseInt('${(total)!}');
        </script>
    </head>

    <body>
        <!--引入头部和左侧菜单-->
        <#include "/pc/header.ftl"/>
        <div class="body">
            <div id="list-left">
                <div class="group"></div>
                <#if total!=0>
                <div id="page" style="text-align: center;"></div>
                </#if>
            </div>
            <div id="list-right">
                <div class="view">
                    <h3 class="view-name">最新教程</h3>
                    <list class="list">
                        <#list newCourse as note>
                        <li><a href="${springMacroRequestContext.contextPath}/pc/note_details?noteId=${(note.noteId)!}">${(note.noteTitle)!}</a></li>
                        </#list>
                    </ul>
                </div>
            </div>
        </div>
        <!--引入底部-->
        <#include "/pc/footer.ftl"/>
    </body>
    <script src="${springMacroRequestContext.contextPath}/pc/js/list.js"></script>
</html>