<div class="layui-header">
    <div class="layui-logo">学习空间后台管理系统</div>
    <ul class="layui-nav layui-layout-right">
        <li class="layui-nav-item">
            ${(user.userName)!}
            <dl class="layui-nav-child">
                <dd><a href="${springMacroRequestContext.contextPath}/bgmanage/logout">退出</a></dd>
            </dl>
        </li>
    </ul>
</div>

<div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
        <ul class="layui-nav layui-nav-tree"  lay-filter="test">
            <li class="layui-nav-item"><a class="menu" id="home" href="javascript:void(0);" data-href="${springMacroRequestContext.contextPath}/bgmanage/home">首页</a></li>
            <li class="layui-nav-item"><a class="menu" id="note-list" href="javascript:void(0);" data-href="${springMacroRequestContext.contextPath}/bgmanage/noteList">笔记列表</a></li>
            <li class="layui-nav-item"><a class="menu" href="javascript:void(0);" id="direction" data-href="${springMacroRequestContext.contextPath}/bgmanage/direction">方向管理</a></li>
            <li class="layui-nav-item"><a class="menu" href="javascript:void(0);" id="log" data-href="${springMacroRequestContext.contextPath}/bgmanage/log">日志管理</a></li>
        </ul>
    </div>
</div>