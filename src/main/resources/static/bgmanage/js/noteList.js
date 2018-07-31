var table
layui.use(['element','table','tools','layer'],function () {
    $("#add-btn").click(function () {
        sessionStorage.setItem('menu','note-list');
        layui.tools.popTo(hostURL+"/bgmanage/note");
    });

    table = layui.table.render({
        elem: '#list',
        url: hostURL+'/bgmanage/selectNote',
        page: true,
        cols: [[
            {title: '序号', width:60,templet:function(d,a){
                return d.LAY_INDEX;
            }},
            {field: 'noteTitle', title: '标题',align:'center'},
            {field: 'status', title: '状态', width:80,align:'center',templet:function (row) {
                if(row.status==0){
                    return '未发布';
                }else if(row.status==1){
                    return '已发布';
                }
            }},
            {title: '所属方向',align:'center', width:100,templet:function (row) {
                return row.direction.directionName;
            }},
            {field: 'noteType', title: '类型', width:60,align:'center',templet:function (row) {
                if(row.noteType==1){
                    return '问答';
                }else if(row.noteType==2){
                    return '教程';
                }
            }},
            {field: 'createUser', title: '创建人', width:80,align:'center'},
            {field: 'createTime', title: '创建时间', width:150,align:'center'},
            {field: 'updateTime', title: '最后修改时间', width:150,align:'center'},
            {field: 'updateUser', title: '修改人', width:80,align:'center'},
            {title: '操作',width:150,align:'center', width:110,templet:function(row){
                var id = row.noteId;
                return "<button onclick='edit(this)' data-id='"+id+"' class='edit-btn layui-btn layui-btn-xs'>编辑</button>"+
                    "<button onclick='del(this)' data-id='"+id+"' class='edit-btn layui-btn layui-btn-xs layui-btn-danger'>删除</button>";
            }},
        ]]
    });

    /*查询*/
    $('#select-btn').click(function () {
        var noteTitle = $('#noteTitle').val();
        if(noteTitle.length!=0){
            noteTitle = noteTitle.trim();
        }
        table.reload({
            where: {
                noteTitle:noteTitle,
                directionId:$('#directionId').val(),
                status:$('#status').val(),
            }
            ,page: {
                curr: 1
            }
        });
    });
});
/*编辑*/
function edit($this){
    sessionStorage.setItem('menu','note-list');
    layui.tools.popTo(hostURL+"/bgmanage/note?id="+$this.dataset.id);
}

/*删除*/
function del($this){
    layui.layer.confirm('确定删除当前数据？', {
        title: '温馨提示',
        btn: ['确定','取消']
    }, function(){
        layui.tools.closeAll();
        layui.tools.post({
            url:hostURL+"/bgmanage/deleteNote",
            data:{id:$this.dataset.id},
            complete:function (res) {
                if(res.code==0){
                    layui.tools.succTips(res.msg,function () {
                        $('#select-btn').click();
                    });
                }else{
                    layui.tools.errTips(res.msg);
                }
            }
        });
        return false;
    });
}
