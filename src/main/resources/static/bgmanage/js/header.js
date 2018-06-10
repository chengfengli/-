$(function () {
    window.onload=function (ev) {
        var menu = sessionStorage.getItem('menu');
        if(menu){
            $('#'+menu).parents('.layui-nav-item').addClass('layui-nav-itemed');
            $('#'+menu).parent().addClass('layui-this');
        }else{
            $('#home').parents('.layui-nav-item').addClass('layui-nav-itemed');
            $('#home').parent().addClass('layui-this');
        }
    }

    $('.menu').click(function () {
        var id = $(this).attr('id');
        sessionStorage.setItem('menu',id);
        var href = $(this).data('href');
        location.href = href;
    });
});