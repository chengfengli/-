var $,layer,utils;
layui.define(['jquery','layer'],function (exports) {
    $ = layui.jquery;
    layer = layui.layer;
    utils={
        /*验证是否为空，为空则返回true*/
        isEmpty:function (val) {
            var bool = false;
            if(val != null && val != undefined){
                val = val.toString();
            }
            if(val == null || val == undefined || val == '' || val.trim() == ''){
                bool = true;
            }
            return bool;
        },
        /*加载框*/
        loading:function(type){
            var load = null;
            if(utils.isEmpty(type)){
                load = layer.load();
            }else{
                load = layer.load(type);
            }
            return load;
        },
        /*关闭对应的提示框*/
        close:function(index){
            layer.close(index);
        },
        /*关闭所有的提示框*/
        closeAll:function(){
            layer.closeAll();
        },
        /*错误提示框*/
        errTips:function (msg) {
            layer.msg(msg,{icon:2});
            if(typeof(callback) == 'function'){
                setTimeout(function () {
                    callback();
                },2000);
            }
        },
        /*成功提示框*/
        succTips:function (msg,callback) {
            layer.msg(msg,{icon:1});
            if(typeof(callback) == 'function'){
                setTimeout(function () {
                    callback();
                },2000);
            }
        },
        /*合并两个json对象*/
        jsonMdrge:function(json1,json2){
            for(var key in json2){
                json1[key] = json2[key];
            }
            return json1;
        },
        /*post请求*/
        post:function(option){
            var nowDate = new Date();
            var old_option = {url:'',dataType:'json',data:null,loading:true,complete:null};
            var new_option = utils.jsonMdrge(old_option,option);
            //判断请求路径中是否携带参数
            if(new_option.url.indexOf('?')==-1){
                new_option.url+='?'+nowDate.getTime();
            }else{
                new_option.url+='&'+nowDate.getTime();
            }
            var load = null;
            if(new_option.loading){
                load = utils.loading();
            }
            $.ajax({
                url: new_option.url,
                type: 'post',
                dataType: 'json',
                data: new_option.data,
                complete:function (res) {
                    if(new_option.loading){
                        utils.close(load);
                    }
                    if(res.status==404){
                        utils.errTips('地址不存在');
                    }else if(res.status==500){
                        utils.errTips('系统内部异常');
                    }else if(res.status==400){
                        utils.errTips('请求参数错误');
                    }else{
                        res = JSON.parse(res.responseText);
                        if(old_option.complete!=null){
                            old_option.complete(res);
                        }
                    }
                }
            });
        },
        /*跳转页面，new_tab：是否新开页面*/
        popTo:function(url,new_tab){
            var nowDate = new Date();
            //判断请求路径中是否携带参数
            if(url.indexOf('?')==-1){
                url+='?'+nowDate.getTime();
            }else{
                url+='&'+nowDate.getTime();
            }
            if(new_tab==true){
                window.open(url);
            }else{
                location.href = url;
            }
        },
        /*颜色*/
        colors:['#29a5e0','#ffgb78','#ffd94d','#99e7b3','#5be3e6','#1ccaf1','#978ef9','#e98ad4','#e459b0','#7c71fb'],
    }
    exports('tools',utils);
});