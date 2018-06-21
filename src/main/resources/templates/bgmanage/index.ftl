<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>学习空间后台管理系统</title>
        <#include "/commons/base.ftl"/>
        <link rel="stylesheet" href="${springMacroRequestContext.contextPath}/bgmanage/css/index.css">
        <script src="${springMacroRequestContext.contextPath}/commons/echarts.common.min.js"></script>
    </head>

    <body class="layui-layout-body">
        <div class="layui-layout layui-layout-admin">
            <!--引入头部和左侧菜单-->
            <#include "/commons/headandmenu.ftl"/>

            <div class="layui-body">
                <div class="row">
                    <div class="col">
                        <h2>近期用户增长情况</h2>
                        <div class="echarts" id="echart1"></div>
                    </div>
                    <div class="col">
                        <h2>近期访问量情况</h2>
                        <div class="echarts" id="echart2"></div>
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <h2>近期各方向访问量排行Top10</h2>
                        <div class="echarts" id="echart3"></div>
                    </div>
                    <div class="col">
                        <h2>笔记数量统计</h2>
                        <div class="echarts" style="display: flex;">
                            <div class="note-total">
                                <div>当前笔记总量</div>
                                <span>600</span>条
                            </div>
                            <div id="echart4"></div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col" style="height: auto;">
                        <h2>有用笔记排行Top10</h2>
                        <table id="use-note"></table>
                    </div>
                </div>
                <div class="row">
                    <div class="col" style="height: auto;">
                        <h2>无用笔记排行Top10</h2>
                        <table id="unuse-note"></table>
                    </div>
                </div>
            </div>

            <!--引入底部-->
            <#include "/commons/footer.ftl"/>
        </div>
    </body>
    <script src="${springMacroRequestContext.contextPath}/bgmanage/js/index.js"></script>
</html>