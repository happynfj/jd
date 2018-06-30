<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <title>后台登录</title>
    <link rel="stylesheet" type="text/css" href="../css/layui.css" />
    <link rel="stylesheet" type="text/css" href="../css/ztree/zTreeStyle.css" />
    <script src="https://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>
    <script src="../jquery.ztree.all.js"></script>
    <script src="../layui.js"></script>
</head>

<body>

<#--<ul id="ztree1" class="ztree"></ul>-->

<ul id="demo">1123</ul>


<script>

</script>


<script>
    layui.use('tree',function () {
        var nodelist = {};
        $.post('/dept/tree2',function (result) {
            if(result.code){
                nodes = result.data;
            }
        });
        layui.tree({
            elem: '#demo' //指定元素
            //,check: 'checkbox' //勾选风格
            ,skin: 'as' //设定皮肤
            //,target: '_blank' //是否新选项卡打开（比如节点返回href才有效）
            ,drag: true
            ,click: function(item){ //点击节点回调
                console.log(item)
            }
            ,nodes:nodelist
        });
    });
</script>
</body>