layui.use('layer', function () {
    //按钮弹框操作
    $('#catBtn').click(function () {
        var url = $(this).attr("data-url");
        openLayer(url);
    });
});

//打开layer
function openLayer(url) {
    var index = layer.open({
        type: 2,
        btn: ['确认', '取消'],
        area: ['500px', '600px'],
        content: url,
        yes: function (index, layero) {
            var body = layer.getChildFrame('body', index);//建立父子联系
            var inputList = body.find('input');
            var iptVal = $(inputList[0]).val();
            $('#goodsCat').val(iptVal);
            layer.close(index);
        }
    });
}

//监听跳转按钮事件
$('#gobtn').click(function () {
    var url=$(this).attr('data-url');
    var id = $(this).attr('data-id');
    window.location.href=url+"?id="+id;
    return false;
});