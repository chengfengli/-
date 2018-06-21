layui.use(['element','table','tools','layer'],function () {
    var data = [
        {title:'Linux系统解压文件命令',sex:'李四',city:'2017-01-01 15:30',time:'2017-01-01 15:30'},
        {title:'Linux系统解压文件命令',sex:'李四',city:'2017-01-01 15:30',time:'2017-01-01 15:30'},
        {title:'Linux系统解压文件命令',sex:'李四',city:'2017-01-01 15:30',time:'2017-01-01 15:30'},
        {title:'Linux系统解压文件命令',sex:'李四',city:'2017-01-01 15:30',time:'2017-01-01 15:30'},
        {title:'Linux系统解压文件命令',sex:'李四',city:'2017-01-01 15:30',time:'2017-01-01 15:30'},
        {title:'Linux系统解压文件命令',sex:'李四',city:'2017-01-01 15:30',time:'2017-01-01 15:30'},
        {title:'Linux系统解压文件命令',sex:'李四',city:'2017-01-01 15:30',time:'2017-01-01 15:30'},
        {title:'Linux系统解压文件命令',sex:'李四',city:'2017-01-01 15:30',time:'2017-01-01 15:30'},
        {title:'Linux系统解压文件命令',sex:'李四',city:'2017-01-01 15:30',time:'2017-01-01 15:30'},
        {title:'Linux系统解压文件命令',sex:'李四',city:'2017-01-01 15:30',time:'2017-01-01 15:30'},
    ];

    layui.table.render({
        elem: '#direction-list',
        //url: '/demo/table/user/',
        data:data,
        page: false,
        cols: [[
            {title: '序号', width:80,templet:function(d,a){
                return d.LAY_INDEX;
            }},
            {field: 'title', title: '放向名称',align:'center'},
            {field: 'sex', title: '创建人',align:'center'},
            {field: 'city', title: '创建时间',align:'center'},
            {field: 'time', title: '最后修改时间',align:'center'},
            {field: 'sex', title: '修改人',align:'center'},
            {title: '操作',align:'center',templet:function(row){
                return '<button onclick="edit()" class="layui-btn layui-btn-xs">编辑</button>'+
                    '<button onclick="del()" class="layui-btn layui-btn-danger layui-btn-xs">删除</button>';
            }},
        ]]
    });
});
/*编辑*/
function edit(){

}

/*删除*/
function del(){
    layui.layer.confirm('确定删除当前数据？', {
        title: '温馨提示',
        btn: ['确定','取消']
    }, function(){
        layui.tools.closeAll();
        return false;
    });
}