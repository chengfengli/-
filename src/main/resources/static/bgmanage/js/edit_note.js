/*富文本*/
var E = window.wangEditor;
var editor = new E('#content');
editor.customConfig.uploadImgShowBase64 = true;
editor.customConfig.zIndex = 100;
editor.create();

// 文件对象数组
var fileList = [];
// 删除已经存在的文件
var haveFiles = [];
// 删除刚删除的文件
var newFiles = new Array();
layui.use(['element','form','tools'], function(){
    /*上传插件*/
    var uploader = WebUploader.create({
        // swf文件路径
        swf: hostURL + '/commons/webuploader/Uploader.swf',
        // 文件接收服务端。
        server: hostURL+'/file/upload',
        // 选择文件的按钮。可选。
        // 内部根据当前运行是创建，可能是input元素，也可能是flash.
        pick: '#picker',
        auto:true,
        // 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
        resize: false,
        fileSingleSizeLimit:1024*1024*100,
        fileSizeLimit:1024*1024*1024
    });
    // 当有文件被添加进队列的时候
    uploader.on( 'fileQueued', function( file ) {
        $('#file-list').append( '<tr id="'+file.id+'">' +
            '   <td><div class="file-name">'+file.name+'</div></td>' +
            '   <td class="progress">' +
            '       <div class="layui-progress" lay-filter="'+file.id+'" lay-showPercent="true">' +
            '           <div id="'+file.id+'txt" class="layui-progress-bar" lay-percent="10%">0</div>' +
            '       </div>' +
            '   </td>' +
            '   <td class="btns"><button type="button" data-name="" class="del-file layui-btn layui-btn-danger layui-btn-xs">删除</button></td>' +
            '</tr>');
        $('.del-file').click(function () {
            var fileAlias = $(this).data('name');
            $(this).parents('tr').remove();
            newFiles.push(fileAlias);
            for(var i in fileList){
                if(fileList[i].fileAlias == fileAlias){
                    fileList.splice(i,1);
                }
            }
        });
    });
    // 上传过程中触发，携带上传进度
    uploader.on('uploadProgress',function(file,response ){
        var progress = Math.round(response*100)+'%';
        layui.element.progress(file.id, progress);
        $('#'+file.id+'txt').text(progress);
    });
    // 当某个文件上传到服务端响应后
    uploader.on('uploadAccept',function(obj,response ){
        $("#"+obj.file.id).find('button').attr('data-name',response.data.fileAlias);
        fileList.push(response.data);
    });
    uploader.on('error', function (handler) {
        if(handler == 'F_EXCEED_SIZE'){
            layui.tools.errTips("所选文件大小超出限制，单个文件最大100MB");
        }else if(handler == 'Q_EXCEED_SIZE_LIMIT'){
            layui.tools.errTips("文件总大小超出限制，最大1024MB");
        }
    })

    /*立即发布*/
    $("#release-btn").click(function () {
        var params = getParams();
        if(formCheck(params)){
            layui.tools.post({
                url:hostURL+"/bgmanage/releaseNote",
                data:params,
                complete:function(res){
                    if(res.code==0){
                        layui.tools.succTips(res.msg,function () {
                            layui.tools.popTo(hostURL+"/bgmanage/noteList");
                        });
                    }else{
                        layui.tools.errTips(res.msg);
                    }
                }
            });
        }
    });

    /*暂存*/
    $("#save-btn").click(function () {
        var params = getParams();
        if(formCheck(params)){
            layui.tools.post({
                url:hostURL+"/bgmanage/editNote",
                data:params,
                complete:function(res){
                    if(res.code==0){
                        layui.tools.succTips(res.msg,function () {
                            layui.tools.popTo(hostURL+"/bgmanage/noteList");
                        });
                    }else{
                        layui.tools.errTips(res.msg);
                    }
                }
            });
        }
    });

    /*重置*/
    $("#reset").click(function () {
        layui.tools.popTo(hostURL+"/bgmanage/note");
    });

    /*预览*/
    $("#view").click(function () {
        var params = getParams();
        if(formCheck(params)){
            layui.tools.post({
                url:hostURL+"/bgmanage/noteStorage",
                data:params,
                complete:function(res){
                    if(res.code==0){
                        layui.tools.popTo(hostURL+"/bgmanage/noteView?id="+res.data,true);
                    }else{
                        layui.tools.errTips(res.msg);
                    }
                }
            });
        }
    });

    /*编辑时初始化数据*/
    if(!layui.tools.isEmpty($('#noteId').val())){
        layui.tools.post({
            url:hostURL+"/bgmanage/selectNoteById",
            data:{noteId:$('#noteId').val()},
            complete:function(res){
                if(res.code==0){
                    $('#noteTitle').val(res.data.noteTitle);
                    $('#tag').val(res.data.tag);
                    $('#directionId').val(res.data.directionId);
                    $('#noteType').val(res.data.noteType);
                    editor.txt.html(res.data.noteTxt);
                    layui.form.render();
                }
            }
        });
    }
    /**
     * 获取要删除文件的id、name
     */
    $('.del-have-file').click(function () {
        var fileId = $(this).data('id');
        var name = $(this).data('alias');
        haveFiles.push({fileId:fileId,fileAlias:name});
        $(this).parents('tr').remove();
    });
});
// 获取表单参数
function getParams(){
    var params = {
        noteId:$('#noteId').val(),
        noteTitle:$("#noteTitle").val(),
        subtitle:$("#subtitle").val(),
        directionId:$("#directionId").val(),
        noteType:$("#noteType").val(),
        tag:$("#tag").val(),
        noteTxt:editor.txt.html(),
        fileList:JSON.stringify(fileList),
        haveFiles:JSON.stringify(haveFiles),
        newFiles:newFiles
    };
    return params;
}
// 表单验证
function formCheck(params) {
    if(layui.tools.isEmpty(params.noteTitle)){
        layui.tools.errTips("请填写笔记标题");
        $('#noteTitle').addClass("layui-form-danger").focus();
        return false;
    }else if(layui.tools.isEmpty(params.subtitle)){
        layui.tools.errTips("请填写笔记简介");
        $('#subtitle').addClass("layui-form-danger").focus();
        return false;
    }else if(layui.tools.isEmpty(params.directionId)){
        layui.tools.errTips("请选择所属方向");
        $('#directionName').addClass("layui-form-danger").focus();
        return false;
    }else if(layui.tools.isEmpty(params.noteType)){
        layui.tools.errTips("请选择笔记类型");
        $('#noteType').addClass("layui-form-danger").focus();
        return false;
    }else if(layui.tools.isEmpty(params.tag)){
        layui.tools.errTips("请填写标签");
        $('#tag').addClass("layui-form-danger").focus();
        return false;
    }else if(layui.tools.isEmpty(editor.txt.text())){
        layui.tools.errTips("请填写内容");
        $('.w-e-text').focus();
        return false;
    }
    return true;
}
$(function () {

})