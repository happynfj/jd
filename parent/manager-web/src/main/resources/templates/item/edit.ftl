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

    <link rel="stylesheet" href="../css/layui.css">

    <style>
        body {
            padding: 10px;
        }
    </style>
</head>
<body>

<form class="layui-form layui-form-pane1" action="" lay-filter="first">

    <div class="layui-form-item layui-btn-sm" style="margin-left: 15px">
        <button class="layui-btn">一个标准的按钮</button>
    </div>



    <div class="layui-form-item">
        <label class="layui-form-label">输入框</label>
        <div class="layui-input-block">
            <input type="text" name="title" lay-verify="required|title" required placeholder="请输入标题" autocomplete="off"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">手机</label>
        <div class="layui-input-block">
            <input type="tel" name="phone" lay-verify="required|number" lay-verType="tips" autocomplete="off"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">邮箱</label>
        <div class="layui-input-block">
            <input type="email" name="email" lay-verify="email" lay-verType="alert" autocomplete="off"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-inline">
            <input type="password" name="password" lay-verify="required|pass" placeholder="请输入密码" autocomplete="off"
                   class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux">请务必填写用户名</div>
    </div>

    <div class="layui-form-item" pane>
        <label class="layui-form-label">开关开</label>
        <div class="layui-input-block">
            <input type="checkbox" checked name="open" lay-skin="switch" lay-filter="switchTest" lay-text="ON|OFF">
            <input type="checkbox" name="open2" lay-skin="switch" lay-filter="switchTest" lay-text="已绑定|绑定">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="*">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>

<br><br><br>


<script src="../layui.js"></script>
<!-- <script src="../build/lay/dest/layui.all.js"></script> -->

<script>

    layui.use('form', function () {
        var form = layui.form;

        //自定义验证规则
        form.verify({
            title: function (value) {
                if (value.length < 5) {
                    return '标题也太短了吧';
                }
            }
            , pass: [/(.+){6,12}$/, '密码必须6到12位']
            , money: [
                /^\d+\.\b\d{2}\b$/
                , '金额必须为小数保留两位'
            ]
        });

        //初始赋值
        form.val('first', {
            'title': '测试'
            , 'phone': 11111111111
            , 'email': 'xu@sentsin.com'
            , 'password': 123123
            , 'quiz': 2
            , 'interest': 3
            , 'like[write]': true
            //,'open': false
            , 'sex': '男'
            , 'desc': 'form 是我们非常看重的一块'
        });


        //事件监听
        form.on('select', function (data) {
            console.log('select: ', this, data);
        });

        form.on('select(quiz)', function (data) {
            console.log('select.quiz：', this, data);
        });

        form.on('select(interest)', function (data) {
            console.log('select.interest: ', this, data);
        });


        form.on('checkbox', function (data) {
            console.log(this.checked, data.elem.checked);
        });

        form.on('switch', function (data) {
            console.log(data);
        });

        form.on('radio', function (data) {
            console.log(data);
        });

        //监听提交
        form.on('submit(*)', function (data) {
            console.log(data)
            alert(JSON.stringify(data.field));
            return false;
        });

    });

</script>

<script>
    layui.use('jquery', function () {
        var $ = layui.jquery;
        var submit = function () {
            return false;
        };
        $('#test').on('submit', function () {
            return false
        });
        $('#test').on('submit', function () {
            return true
        });
    });
</script>
</body>
</html>
