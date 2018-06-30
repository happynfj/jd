layui.use('element',function () {
    var element = layui.element;
    element.on('nav(leftNav)',function (elem) {
        var id = elem.attr('data-id');
        var url = elem.attr('data-url');
        var text = elem.attr('data-text');
        if(!url){
            return;
        }
        var isActive = $('.layui-tab .layui-tab-title').find("li[lay-id=" + id + "]");
        if(isActive.length>0){
            element.tabChange('tabF',id);
        }else{
            element.tabAdd('tabF',{
               title:text,
               content: '<iframe id = "iframe' + id + '" src="' + url + '" name="iframe' + id + '" class="iframe" frameborder="no" data-id="' + id + '" scrolling="auto" width="100%"></iframe>',
                id:id
            });
            adaptIframe(id);
            element.tabChange('tabF', id);
        }
    });
});

function adaptIframe(id) {
    var ifm= document.getElementById("iframe"+id);
    ifm.height=document.documentElement.clientHeight;
}