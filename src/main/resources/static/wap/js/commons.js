layui.use(['element','form','tools'],function () {
    $('#search-btn').click(function () {
        var keyword = $('#keyword').val();
        if(layui.tools.isEmpty(keyword)){
            layui.tools.errTips("请输入关键字")
        }else{
            layui.tools.popTo(hostURL+"/wap/list?keyword="+keyword);
        }
    });
});