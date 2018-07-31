<link rel="stylesheet" href="/commons/layui/css/layui.css"  media="all">
<link rel="stylesheet" href="/wap/css/commons.css"  media="all">
<script src="/commons/layui/layui.all.js"></script>
<script src="/commons/layui/layui.js"></script>
<script src="/commons/jquery-1.8.3.min.js"></script>
<script>
    var hostURL = '${springMacroRequestContext.contextPath}';
    layui.config({
        base:"${springMacroRequestContext.contextPath}/commons/"
    }).extend({
        "tools":"tools"
    });
</script>
<script src="${springMacroRequestContext.contextPath}/wap/js/commons.js"></script>