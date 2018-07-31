<link rel="stylesheet" href="${springMacroRequestContext.contextPath}/commons/layui/css/layui.css"  media="all">
<link rel="stylesheet" href="${springMacroRequestContext.contextPath}/pc/css/commons.css"  media="all">
<script src="${springMacroRequestContext.contextPath}/commons/layui/layui.all.js"></script>
<script src="${springMacroRequestContext.contextPath}/commons/layui/layui.js"></script>
<script src="${springMacroRequestContext.contextPath}/commons/jquery-1.8.3.min.js"></script>
<script src="${springMacroRequestContext.contextPath}/commons/jquery.cookie.js"></script>
<script>
    var hostURL = '${springMacroRequestContext.contextPath}';
    layui.config({
        base:"${springMacroRequestContext.contextPath}/commons/"
    }).extend({
        "tools":"tools"
    });
</script>
<script src="${springMacroRequestContext.contextPath}/pc/js/commons.js"></script>