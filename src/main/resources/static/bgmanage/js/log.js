var table=null;
layui.use(['element','table','tools','layer','laydate'],function () {
    var startTime = layui.laydate.render({elem: '#startTime'});
    var endTime = layui.laydate.render({elem: '#endTime'});

     table = layui.table.render({
        elem: '#list',
        url: hostURL + '/bgmanage/logList/',
        page: true,
        cols: [[
            {title: '序号', width:60,templet:function(d,a){
                return d.LAY_INDEX;
            }},
            {field: 'editUser', title: '操作用户',align:'center'},
            {field: 'editTime', title: '操作时间',align:'center'},
            {field: 'describe', title: '操作描述',align:'center'},
            {field: 'clientType', title: '客户端类型',align:'center', width:120},
            {field: 'ipAddress', title: 'IP地址',align:'center'},
            {field: 'city', title: '所属城市',align:'center'},
            {title: '操作',align:'center', width:80,templet:function(row){
                var logId = row.logId;
                return '<button onclick="del('+logId+')" class="layui-btn layui-btn-danger layui-btn-xs">删除</button>';
            }},
        ]]
    });
    $('#select-btn').click(function () {
        table.reload({
            where: {
                editUser: $('#userName').val(),
                startTime: $('#startTime').val(),
                endTime: $('#endTime').val(),
            }
            ,page: {
                curr: 1
            }
        });
    });
});

/*删除*/
function del(logId){
    layui.layer.confirm('确定删除当前数据？', {
        title: '温馨提示',
        btn: ['确定','取消']
    }, function(){
        layui.tools.post({
            url:hostURL+'/bgmanage/deleteLog',
            type:'post',
            dataType:'json',
            data:{logId:logId},
            complete:function(res){
                layui.tools.closeAll();
                if(res.code==0){
                    layui.tools.succTips(res.msg,function(){
                        table.reload({
                            where: {
                                editUser: $('#userName').val(),
                                startTime: $('#startTime').val(),
                                endTime: $('#endTime').val(),
                            }
                        });
                    });
                }
            }
        });
        return false;
    });
}
