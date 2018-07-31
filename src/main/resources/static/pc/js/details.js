layui.use(['element','form','tools','code'], function(){
    //搜索
    $('#search-btn').click(function () {
        var keyword = $('#keyword').val();
        if(layui.tools.isEmpty(keyword)){
            layui.tools.errTips("请输入关键字")
        }else{
            layui.tools.popTo(hostURL+"/pc/list?keyword="+keyword);
        }
    });
    //点赞
    $("#praise").click(function () {
        var noteId = $("#id").val();
        layui.tools.post({
            url:hostURL+"/pc/updateUseCount",
            data:{"noteId":noteId},
            complete:function (res) {
                if(res.code==0){
                    layui.tools.succTips(res.msg);
                }else{
                    layui.tools.errTips(res.msg);
                }
            }
        });
    });
    //踩
    $("#tread").click(function () {
        var noteId = $("#id").val();
        layui.tools.post({
            url:hostURL+"/pc/updateUnusedCount",
            data:{noteId:noteId},
            complete:function (res) {
                if(res.code==0){
                    layui.tools.succTips(res.msg);
                }else{
                    layui.tools.errTips(res.msg);
                }
            }
        });
    });
})