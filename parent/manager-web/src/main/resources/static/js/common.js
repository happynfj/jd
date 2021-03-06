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
            var catName = $(inputList[0]).val();
            var catId =  $(inputList[0]).attr("data-id");
            $('#goodsCat').val(catName);
            $('#goodsCatId').val(catId);
            layer.close(index);
        }
    });
}

//监听跳转按钮事件
$('#gobtn').click(function () {
    var url=$(this).attr('data-url');
    var id = $(this).attr('id');
    window.location.href=url+"?id=2&isEdit=0";
    return false;
});
