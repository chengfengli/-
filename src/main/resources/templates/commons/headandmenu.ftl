<div class="layui-header">
    <div class="layui-logo">学习空间后台管理系统</div>
    <ul class="layui-nav layui-layout-right">
        <li class="layui-nav-item">
            <a href="javascript:void(0);">管理员</a>
            <dl class="layui-nav-child">
                <dd><a href="${springMacroRequestContext.contextPath}/bgmanage/user/login_out">退出</a></dd>
            </dl>
        </li>
    </ul>
</div>

<div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
        <ul class="layui-nav layui-nav-tree"  lay-filter="test">
            <li class="layui-nav-item"><a class="menu" id="home" href="javascript:void(0);" data-href="${springMacroRequestContext.contextPath}/bgmanage/user/home">首页</a></li>
            <li class="layui-nav-item">
                <a href="javascript:void(0);">笔记管理</a>
                <dl class="layui-nav-child">
                    <dd><a class="menu" id="edit-note" href="javascript:void(0);" data-href="${springMacroRequestContext.contextPath}/bgmanage/note/edit">添加/编辑</a></dd>
                    <dd><a class="menu" id="note-list" href="javascript:void(0);" data-href="${springMacroRequestContext.contextPath}/bgmanage/note/list">笔记列表</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a class="menu" href="javascript:void(0);" id="direction" data-href="${springMacroRequestContext.contextPath}/bgmanage/direction/list">方向管理</a></li>
            <li class="layui-nav-item"><a class="menu" href="javascript:void(0);" id="log" data-href="${springMacroRequestContext.contextPath}/bgmanage/log/list">日志管理</a></li>
        </ul>
    </div>
</div>