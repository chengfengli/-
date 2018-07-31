layui.use(['element','form','tools'], function(){
    var tools = layui.tools;
    $("#canvas").canvas1();
    /*登陆*/
    $('.login-btn').click(function () {
        var account = $('#account').val();
        var password = $('#password').val();
        if(tools.isEmpty(account)){
            tools.errTips("账号不能为空");
        }else if(tools.isEmpty(password)){
            tools.errTips("密码不能为空");
        }else{
            var params = {account:account,password:password};
            $('.login-btn').addClass('layui-btn-disabled').attr('disabled','disabled').html('登录中...');
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
                        $('.login-btn').removeClass('layui-btn-disabled').attr('disabled',false).html('登&nbsp;&nbsp;录');
                        tools.errTips(res.msg);
                    }
                }
            });
        }
    });
    // 回车键事件
    $(document).keyup(function(event){
        if(event.keyCode ==13){
            $('.login-btn').click();
        }
    });
});