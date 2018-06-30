<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>表单模块 - layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" type="text/css" href="../css/ztree/zTreeStyle.css"/>
    <script src="https://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>
    <script src="../jquery.ztree.all.js"></script>
    <link rel="stylesheet" href="../css/layui.css">
    <script src="../layui.js"></script>

    <style>
        body {
            padding: 10px;
        }
    </style>
</head>

<body>
<form class="layui-form" action="">
    <input type="hidden"  id="ipt" value="123">
    <div class="layui-form-item">
        <ul id="ztree1" class="ztree"></ul>
    </div>

   <#-- <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="*" id="submitBtn">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>-->
</form>


</body>
</html>

<script>
    $(function () {
        //构造Ztree
        var setting = {
            data: {
                simpleData: {
                    enable: true,
                    pIdKey: "pid"
                }
            },
            callback:{
                onClick:handlerClick
            }
        };
        $.post('/itemCat/all', function (result) {
            if (result.code) {
                $.fn.zTree.init($("#ztree1"), setting, result.data);
            }
        });

        //获取子窗口索引
        var index = parent.layer.getFrameIndex(window.name);

        //引入form模块
        layui.use('form', function () {
            var form = layui.form;
            form.on('submit(*)', function (data) {
                parent.layer.close(index);
            });
        });

        //ztree点击时间
        function handlerClick(e,treeId,treeNode){
            $('#ipt').val(treeNode.name);
        }
    });
</script>
