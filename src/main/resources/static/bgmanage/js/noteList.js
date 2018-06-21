layui.use(['element','table','tools','layer'],function () {
    $("#add-btn").click(function () {
        sessionStorage.setItem('menu','edit-note');
        layui.tools.popTo(hostURL+"/bgmanage/note/edit");
    });
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
        elem: '#list',
        //url: '/demo/table/user/',
        data:data,
        page: true,
        cols: [[
            {title: '序号', width:80,templet:function(d,a){
                return d.LAY_INDEX;
            }},
            {field: 'title', title: '标题',align:'center'},
            {field: 'title', title: '状态',align:'center'},
            {field: 'sex', title: '创建人',align:'center'},
            {field: 'city', title: '创建时间',align:'center'},
            {field: 'time', title: '最后修改时间',align:'center'},
            {field: 'sex', title: '修改人',align:'center'},
            {title: '操作',align:'center',templet:function(row){
                return '<button onclick="edit()" class="layui-btn layui-btn-xs">编辑</button>'+
                    '<button onclick="del()" class="layui-btn layui-btn-danger layui-btn-xs">删除</button>'+
                    '<button onclick="view()" class="layui-btn layui-btn-normal layui-btn-xs">预览</button>';
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

/*预览*/
function view(){

}