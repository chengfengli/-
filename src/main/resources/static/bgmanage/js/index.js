layui.use(['element','tools','table'], function(){
    var tools = layui.tools;
    // 笔记数量统计
    tools.post({
        url:hostURL+'/bgmanage/noteCountStatistics',
        complete:function (res) {
            $('#note-all-count').html(res.data.allCount);
            echartFun4(tools.colors,res.data.list);
        }
    });

    // 各方向访问量排行
    tools.post({
        url:hostURL+"/bgmanage/browseTopGroupByDirection",
        complete:function (res) {
            echartFun3(tools.colors,res.data);
        }
    })
    echartFun1(tools.colors);
    echartFun2(tools.colors);

    var data = [
        {title:'Linux系统解压文件命令',sex:'linux',city:200,},
        {title:'Linux系统解压文件命令',sex:'linux',city:200,},
        {title:'Linux系统解压文件命令',sex:'linux',city:200,},
        {title:'Linux系统解压文件命令',sex:'linux',city:200,},
        {title:'Linux系统解压文件命令',sex:'linux',city:200,},
        {title:'Linux系统解压文件命令',sex:'linux',city:200,},
        {title:'Linux系统解压文件命令',sex:'linux',city:200,},
        {title:'Linux系统解压文件命令',sex:'linux',city:200,},
        {title:'Linux系统解压文件命令',sex:'linux',city:200,},
        {title:'Linux系统解压文件命令',sex:'linux',city:200,},
    ];
    /*有用笔记*/
    layui.table.render({
        elem: '#use-note',
        url:hostURL + '/bgmanage/selectByUse/',
        page: false,
        cols: [[
            {title: '序号', width:80,templet:function(row){
                return row.LAY_INDEX;
            }},
            {field: 'noteTitle', title: '标题',align:'center'},
            {title: '所属方向',align:'center',templet:function (row) {
                return row.direction.directionName;
            }},
            {field: 'useCount', title: '采用量',align:'center'},
            {title: '详情',align:'center',templet:function(row){
                var noteId = row.noteId;
                return '<button onclick="details(this)" data-id="'+noteId+'" class="layui-btn layui-btn-normal layui-btn-xs">详情</button>';
            }},
        ]]
    });
    /*无用用笔记*/
    layui.table.render({
        elem: '#unuse-note',
        url:hostURL + '/bgmanage/selectByUnUse/',
        page: false,
        cols: [[
            {title: '序号', width:80,templet:function(d,a){
                return d.LAY_INDEX;
            }},
            {field: 'noteTitle', title: '标题',align:'center'},
            {title: '所属方向',align:'center',templet:function (row) {
                return row.direction.directionName;
            }},
            {field: 'unusedCount', title: '反馈量',align:'center'},
            {title: '详情',align:'center',templet:function(row){
                var noteId = row.noteId;
                return '<button onclick="details(this)" data-id="'+noteId+'" class="layui-btn layui-btn-normal layui-btn-xs">详情</button>';
            }},
        ]]
    });
});
/*近期用户增长情况*/
function echartFun1(colors){
    var echart = echarts.init(document.getElementById('echart1'));
    var option = {
        tooltip: {
            trigger: 'axis'
        },
        grid: {
            top: 20,
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data: ['周一','周二','周三','周四','周五','周六','周日']
        },
        yAxis: {
            type: 'value',
            axisTick:{
                show:false,
            },
        },
        series: [
            {
                name:'邮件营销',
                type:'line',
                stack: '总量',
                data:[120, 132, 101, 134, 90, 230, 210]
            }
        ],
        color:colors
    };
    echart.setOption(option);
}

/*近期访问量情况*/
function echartFun2(colors){
    var echart = echarts.init(document.getElementById('echart2'));
    var option = {
        tooltip: {
            trigger: 'axis'
        },
        grid: {
            top: 20,
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data: ['周一','周二','周三','周四','周五','周六','周日']
        },
        yAxis: {
            type: 'value',
            axisTick:{
                show:false,
            },
        },
        series: [
            {
                name:'邮件营销',
                type:'line',
                stack: '总量',
                data:[120, 132, 101, 134, 90, 230, 210]
            }
        ],
        color:colors
    };
    echart.setOption(option);
}

/*各方向访问量排行*/
function echartFun3(colors,data){
    var x_data = [];
    var y_data = [];
    for (var key in data){
        x_data.push(key);
        y_data.push(data[key])
    }
    var echart = echarts.init(document.getElementById('echart3'));
    var option = {
        tooltip: {
            trigger: 'axis'
        },
        grid: {
            top: 20,
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: [
            {
                type : 'category',
                data : x_data,
                axisTick: {
                    alignWithLabel: true
                }
            }
        ],
        yAxis: {
            type: 'value',
            axisTick:{
                show:false,
            },
        },
        series: [
            {
                name:'访问量',
                type:'bar',
                barWidth: '60%',
                data:y_data
            }
        ],
        color:colors
    };
    echart.setOption(option);
}

/*系统当前笔记数量统计*/
function echartFun4(colors,data){
    var echart = echarts.init(document.getElementById('echart4'));
    var option = {
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        series : [
            {
                name: '各方向笔记数量占比',
                type: 'pie',
                radius : '55%',
                center: ['45%', '50%'],
                data:data,
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ],
        color:colors
    };
    echart.setOption(option);
}

/*详情*/
function details($this){
    layui.tools.popTo(hostURL+"/bgmanage/noteView?id="+$this.dataset.id,true);
}


