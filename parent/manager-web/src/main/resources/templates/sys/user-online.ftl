<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>table模块快速使用</title>
    <link rel="stylesheet" href="../css/layui.css" media="all">
</head>
<body>

<#--表行工具栏模板-->
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">强退</a>
</script>


    <form class="layui-form" action="">
            <button class="layui-btn" id="gobtn" data-url="/item/pageAdd" data-id="1">增加</button>
            <div class="layui-inline" style="margin-left: 1000px">
                <select name="status" lay-filter="status">
                    <option value="">请选择一个状态</option>
                    <option value="1">正常</option>
                    <option value="2">下架</option>
                    <option value="3">删除</option>
                </select>
            </div>
            <div class="layui-inline">
                <input type="text" name="title"  placeholder="请输入标题" autocomplete="off"
                       class="layui-input">
            </div>
            <a class="layui-btn layui-btn-normal" style="margin-left: 10px" lay-submit lay-filter="*">搜索</a>

        <table id="test" lay-filter="test"></table>
    </form>


<script src="https://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>
<script src="../layui.js"></script>
<script src="../js/common.js"></script>

<script>
    var itemTbOP = {
        elem: '#test'
        , height: 700
        //, url: '/item/list'
        //开启分页
        , page: true
        , limit: 20
        , cols: [[
            {type: 'checkbox', fixed: 'left'}
            , {field: 'sessionid', title: '回话编号', width: '15%', fixed: 'left', unresize: true}
            , {field: 'loginName', title: '登录名', width: '8%', edit: 'text', templet: '#usernameTpl'}
            , {field: 'deptName', title: '部门名称', width: '8%'}
            , {field: 'ipaddr', title: '主机地址', width: '10%', edit: 'text'}
            , {field: 'loginLocation', title: '登录地点', width: '5%', sort: true}
            , {field: 'browser', title: '浏览器', width: '6%'}
            , {field: 'os', title: '操作系统', width: '8%'}
            , {field: 'status', title: '状态', width: '5%'}
            , {field: 'createTime', title: '登录时间', width: '12%', sort: true}
            , {field: 'endTime', title: '最后访问时间', width: '12%', sort: true}
            , {fixed: 'right', title: '操作', toolbar: '#barDemo', width: '8%'}
        ]]
        ,done:function (res, curr, count) {
            $('[data-field=status]').children().each(function (i) {
                if($(this).html()=='on_line'){
                    $(this).html('<a class="layui-btn layui-btn-xs" lay-event="del">正常</a>');
                }else if($(this).html()=='2'){
                    $(this).html('下架');
                }else if($(this).html()=='3'){
                    $(this).html('删除');
                }
            })
        }
    }
</script>


<script>
    layui.use(['table', 'form'], function () {
        var table = layui.table;
        var form = layui.form;
        //构造table
        itemTbOP.url = '/online/list';
        table.render(itemTbOP);
        //监听工具条
        table.on('tool(test)', function (obj) {
            console.log(JSON.stringify(obj));
            var data = obj.data;
            if (obj.event === 'del') {
                layer.confirm('真的删除行么', function (index) {
                    obj.del();
                    layer.close(index);
                    $.ajax({
                        url: '/item/del',
                        success: function (result) {
                            if (result.code) {
                                // alert("删除成功");
                            }
                        }
                    })
                });
            } else if (obj.event === 'edit') {
                var id = obj.data.id;
                var url = "/item/pageAdd";
                var isEdit = 1;
                window.location.href=url+"?id="+id+"&isEdit="+isEdit;
                return false;
            }
        });

        //监听提交
        form.on('submit(*)',function (data) {
            console.log(data.field);
            itemTbOP.where = data.field;
            table.render(itemTbOP);
        });
    });
</script>
</body>

</html>
