<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>笔记列表</title>
    <#include "/commons/base.ftl"/>
</head>

    <body class="layui-layout-body">
        <div class="layui-layout layui-layout-admin">
            <!--引入头部和左侧菜单-->
            <#include "/commons/headandmenu.ftl"/>

            <div class="layui-body">
                <form class="layui-form">
                    <div class="layui-form-item">
                        <label class="layui-form-label">标题关键字</label>
                        <div class="layui-input-inline">
                            <input type="text" id="noteTitle" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
                        </div>
                        <label class="layui-form-label">所属方向</label>
                        <div class="layui-input-inline">
                            <select name="city" id="directionId" lay-verify="required">
                                <option value="">全部</option>
                                <#list directions as direction>
                                    <option value="${direction.directionId}">${direction.directionName}</option>
                                </#list>
                            </select>
                        </div>
                        <label class="layui-form-label">状态</label>
                        <div class="layui-input-inline">
                            <select name="city" id="status" lay-verify="required">
                                <option value="">全部</option>
                                <option value="1">已发布</option>
                                <option value="0">未发布</option>
                            </select>
                        </div>

                        <button type="button" id="select-btn" class="layui-btn layui-btn-normal">查询</button>
                    </div>
                </form>
                <button id="add-btn" class="layui-btn">新增</button>
                <table id="list"></table>
            </div>

            <!--引入底部-->
            <#include "/commons/footer.ftl"/>
        </div>
    </body>
    <script src="${springMacroRequestContext.contextPath}/bgmanage/js/noteList.js"></script>
</html>