layui.use(['element','form','tools'],function () {
    var limit = 10,page = 1,pageCount = Math.ceil(total/limit),isMore=true;
    $('#load-more').click(function () {
        if(isMore){
            page+=1;
        }
        layui.tools.post({
            url:hostURL+'/pc/select_note_keyword',
            data:{noteTitle:$('#keyword').val(),page:page,limit:limit},
            complete:function (res) {
                var list = res.data;
                var html = '';
                if(list.length==0){
                    layui.tools.msg('没有更多数据');
                    isMore = false;
                }else{
                    isMore = true;
                }
                for(var i=0;i<list.length;i++){
                    html += '<a href="'+hostURL+'/wap/details?noteId='+list[i].noteId+'" class="item">' +
                        '        <div class="note-name">'+list[i].noteTitle+'</div>' +
                        '        <div class="note-subtitle">'+list[i].subtitle+'</div>' +
                        '        <div class="sign">' +
                        '            <span class="tag"><i class="layui-icon layui-icon-note"></i><span class="count">'+list[i].tag+'</span></span>' +
                        '            <span class="praise"><i class="layui-icon layui-icon-praise"></i><span class="count">'+list[i].useCount+'</span></span>' +
                        '            <span class="tread"><i class="layui-icon layui-icon-tread"></i><span class="count">'+list[i].unusedCount+'</span></span>' +
                        '            <span class="create-time">'+list[i].createTime+'</span>' +
                        '        </div>' +
                        '   </a>';
                }
                $('#data').append(html);
            }
        })
    });
});