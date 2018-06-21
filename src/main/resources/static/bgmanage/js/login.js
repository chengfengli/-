layui.use(['element','form','tools'], function(){
    var element = layui.element;
    var tools = layui.tools;
    $("#canvas").canvas1();
    $('.login-btn').click(function () {
        var account = $('#account').val();
        var password = $('#password').val();
        if(tools.isEmpty(account)){
            tools.errTips("账号不能为空");
        }else if(tools.isEmpty(password)){
            tools.errTips("密码不能为空");
        }else{
            var params = {account:account,password:password};
            $.ajax({
                url:hostURL+'/bgmanage/login',
                type:'post',
                dataType:'json',
                data:params,
                success:function(res){
                    if(res.code==0){
                        sessionStorage.setItem("menu","home");
                        tools.popTo(hostURL+'/bgmanage/home',false);
                    }else{
                        tools.errTips(res.msg);
                    }
                }
            });
        }
    });
});