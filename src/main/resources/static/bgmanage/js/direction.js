var table;
layui.use(['element','table','tools','layer'],function () {
    table = layui.table.render({
        elem: '#direction-list',
        url: hostURL+'/bgmanage/selectDirection',
        page: false,
        cols: [[
            {title: '序号', width:80,templet:function(d,a){
                return d.LAY_INDEX;
            }},
            {field: 'directionName', title: '方向名称',align:'center'},
            {field: 'createUser', title: '创建人',align:'center'},
            {field: 'createTime', title: '创建时间',align:'center'},
            {field: 'updateTime', title: '最后修改时间',align:'center'},
            {field: 'updateUser', title: '修改人',align:'center'},
            {title: '操作',align:'center',templet:function(row){
                var id = row.directionId;
                return '<button onclick="edit('+id+')" class="layui-btn layui-btn-xs">编辑</button>'+
                    '<button onclick="del('+id+')" class="layui-btn layui-btn-danger layui-btn-xs">删除</button>';
            }},
        ]]
    });
    $('#add-btn').click(function () {
        edit('');
    });
});
/*编辑*/
function edit(id){
    layui.layer.open({
        id:'edit_direction',
        title:"编辑方向名称",
        closeBtn: 0,
        type: 2,
        area: ['327px', '200px'],
        content: [hostURL+'/bgmanage/edit_direction_page?directionId='+id, 'no'],
        btn: ['保存', '取消'],
        yes: function(index, layero){
            var frameId=document.getElementById('edit_direction').getElementsByTagName("iframe")[0].id;
            var data = $('#'+frameId)[0].contentWindow.getParams();
            if(layui.tools.isEmpty(data.directionName)){
                layui.tools.errTips("方向名称不能为空");
            }else{
                layui.tools.post({
                    url:hostURL+"/bgmanage/eidtDirection",
                    data:data,
                    complete:function (res) {
                        if(res.code==0){
                            layui.tools.closeAll();
                            layui.tools.succTips(res.msg,function(){
                                table.reload();
                            });
                        }else{
                            layui.tools.errTips(res.msg);
                        }
                    }
                });
            }
            return false;
        }
    });
}

/*删除*/
function del(id){
    layui.layer.confirm('确定删除当前数据？', {
        title: '温馨提示',
        btn: ['确定','取消']
    }, function(){
        layui.tools.post({
            url:hostURL+"/bgmanage/deleteDirection",
            data:{id:id},
            complete:function (res) {
                if(res.code==0){
                    layui.tools.closeAll();
                    layui.tools.succTips(res.msg,function(){
                        table.reload();
                    });
                }else{
                    layui.tools.errTips(res.msg);
                }
            }
        });
    });
}