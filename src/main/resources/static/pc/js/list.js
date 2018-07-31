layui.use(['element','form','tools','laypage'], function(){
    $('#search-btn').click(function () {
        var keyword = $('#keyword').val();
        if(layui.tools.isEmpty(keyword)){
            layui.tools.errTips("请输入关键字")
        }else{
            layui.tools.popTo(hostURL+"/pc/list?keyword="+keyword);
        }
    });
    layui.laypage.render({
        elem: 'page',
        count: total,
        jump:function (obj, first) {
            if(total==0){
                $('.group').html('<div class="not-data">没有找到相关数据</div>');
            }else{
                layui.tools.post({
                    url:hostURL+'/pc/select_note_keyword',
                    data:{noteTitle:$('#keyword').val(),page:obj.curr,limit:obj.limit},
                    complete:function (res) {
                        var list = res.data;
                        var html = '';
                        for(var i=0;i<list.length;i++){
                            html += '<div class="group-item">' +
                                '        <a href="'+hostURL+'/pc/note_details?noteId='+list[i].noteId+'" target="_blank" class="note-title">'+list[i].noteTitle+'</a>' +
                                '        <div class="abstract">'+list[i].subtitle+'</div>' +
                                '        <div class="sign">' +
                                '            <span class="tag"><i class="layui-icon layui-icon-note"></i><span class="count">'+list[i].tag+'</span></span>' +
                                '            <span class="praise"><i class="layui-icon layui-icon-praise"></i><span class="count">'+list[i].useCount+'</span></span>' +
                                '            <span class="tread"><i class="layui-icon layui-icon-tread"></i><span class="count">'+list[i].unusedCount+'</span></span>' +
                                '            <span class="create-time">'+list[i].createTime+'</span>' +
                                '        </div>' +
                                '   </div>';
                        }
                        $('.group').html(html);
                    }
                })
            }
        }
    });
})