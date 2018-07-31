<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>添加/编辑笔记</title>
        <#include "/commons/base.ftl"/>
        <link rel="stylesheet" href="${springMacroRequestContext.contextPath}/commons/wangEditor/wangEditor.css">
        <link rel="stylesheet" href="${springMacroRequestContext.contextPath}/commons/webuploader/webuploader.css">
        <link rel="stylesheet" href="${springMacroRequestContext.contextPath}/bgmanage/css/edit_note.css">
    </head>

    <body class="layui-layout-body" style="width: 100%;">
        <div class="layui-layout layui-layout-admin">
            <!--引入头部和左侧菜单-->
            <#include "/commons/headandmenu.ftl"/>

            <div class="layui-body">
                <form class="layui-form" lay-filter="form-note" action="return false;">
                    <div class="layui-form-item">
                        <label class="layui-form-label">标题</label>
                        <div class="layui-input-block">
                            <input type="hidden" id="noteId"  value="${(note.noteId)!}" >
                            <input type="text" id="noteTitle" name="noteTitle" maxlength="50" required  lay-verify="required" placeholder="请输入标题,50个字以内" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">简介</label>
                        <div class="layui-input-block">
                            <textarea id="subtitle" maxlength="150" placeholder="简单描述,150个字以内" class="layui-textarea">${(note.subtitle)!}</textarea>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">所属方向</label>
                        <div class="layui-input-block">
                            <select name="city" id="directionId" name="directionId" required  lay-verify="required">
                                <option value=""></option>
                                <#list directions as direction>
                                <option value="${(direction.directionId)!}">${(direction.directionName)!}</option>
                                </#list>
                            </select>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">笔记类型</label>
                        <div class="layui-input-block">
                            <select name="city" id="noteType" name="noteType" required  lay-verify="required">
                                <option value=""></option>
                                <option value="1">问答</option>
                                <option value="2">教程</option>
                            </select>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">标签</label>
                        <div class="layui-input-block">
                            <input type="text" id="tag" name="tag" maxlength="50" required  lay-verify="required" placeholder="如：springmvc springboot,50个字以内" autocomplete="off" class="layui-input">
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
                            <div id="uploader" class="wu-example">
                                <div class="btns">
                                    <div id="picker">选择文件</div>
                                </div>
                                <!--已有附件-->
                                <table id="have-file-list" class="uploader-list">
                                    <#if files??>
                                        <#list files as file>
                                            <tr>
                                                <td><div class="file-name">${(file.fileName)!}</div></td>
                                                <td class="btns"><button type="button" data-id="${(file.fileId)!}" data-alias="${(file.fileAlias)!}" class="del-have-file layui-btn layui-btn-danger layui-btn-xs">删除</button></td>
                                            </tr>
                                        </#list>
                                    </#if>
                                </table>
                                <!--新添加的附件-->
                                <table id="file-list" class="uploader-list"></table>
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-input-block">
                            <button type="button" id="release-btn" class="layui-btn">立即发布</button>
                            <button type="button" id="save-btn" class="layui-btn layui-btn-warm">暂存</button>
                            <button type="button" id="view" class="layui-btn layui-btn-normal">预览</button>
                            <button type="button" id="reset" class="layui-btn layui-btn-primary">重置</button>
                        </div>
                    </div>
                </form>
            </div>

            <!--引入底部-->
            <#include "/commons/footer.ftl"/>
        </div>
    </body>
    <script src="${springMacroRequestContext.contextPath}/commons/wangEditor/wangEditor.js"></script>
    <script src="${springMacroRequestContext.contextPath}/commons/webuploader/webuploader.js"></script>
    <script src="${springMacroRequestContext.contextPath}/bgmanage/js/edit_note.js"></script>
</html>