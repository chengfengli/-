var E = window.wangEditor;
var editor = new E('#content');
editor.customConfig.uploadImgShowBase64 = true;
editor.create();

var config = {
    browseFileId : "i_select_files",
    filesQueueId : "i_stream_files_queue",
    filesQueueHeight : 'auto',
    messagerId : "i_stream_message_container",
    multipleFiles: true,
    onRepeatedFile: function(f) {
        alert("文件："+f.name +" 大小："+f.size + " 已存在于上传队列中。");
        return false;
    }
};
var _t = new Stream(config);
layui.use(['element','form','tools','code'], function(){

    $('#getval').click(function () {
        $('#con').html(editor.txt.html());
        layui.code({title: '代码块',about: false});
    });
});