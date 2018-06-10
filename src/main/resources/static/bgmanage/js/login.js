layui.use(['element','form','layer'], function(){
    var element = layui.element;
    $("#canvas").canvas1();
    layui.form.on('submit(formDemo)', function(data){
        sessionStorage.setItem("menu","home");
        location.href = hostURL+'/bgmanage/user/home';
        return false;
    });
});