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
    <link rel="stylesheet" type="text/css" href="../css/ztree/zTreeStyle.css" />
    <script src="https://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>
    <script src="../jquery.ztree.all.js"></script>
    <link rel="stylesheet" href="../css/layui.css">

    <style>
        body {
            padding: 10px;
        }
    </style>
</head>

<ul id="ztree1" class="ztree"></ul>

<body>
<div class="layui-form-item layui-btn-sm" style="margin-left: 15px">
    <button class="layui-btn" id="catBtn" data-url="/itemcat/tree">一个标准的按钮</button>
    <input type="hidden"/>
</div>

<form class="layui-form layui-form-pane1" action="" lay-filter="first">

    <div class="layui-form-item">
        <label class="layui-form-label">商品类目</label>
        <div class="layui-input-block">
            <input type="text" name="title"  id="goodsCat" required placeholder="请选择类目" autocomplete="off"
                   class="layui-input">
        </div>
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
<script src="../js/common.js"></script>
</body>
</html>
