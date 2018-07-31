layui.use(['element','form'],function () {
});
function getParams() {
    var params = {
        directionId:$("#id").val(),
        directionName:$('#directionName').val()
    };
    return params;
}