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
    <link rel="stylesheet" href="../lib/kindeditor/themes/default/default.css">

    <style>
        body {
            padding: 10px;
        }
    </style>
</head>

<ul id="ztree1" class="ztree"></ul>

<body>

<#--<div class="layui-form-item layui-btn-sm" style="margin-left: 15px">
    <button class="layui-btn" id="catBtn" data-url="/itemcat/tree">商品类目</button>
    <input type="hidden"/>
</div>-->

<form class="layui-form layui-form-pane1" action="" lay-filter="first" id="addForm">
    <div class="layui-tab">
        <div class="layui-tab-title">
            <li><a href="/item/pageList">商品列表</a></li>
            <li class="layui-this">
                <#if isEdit=='1'>
                    编辑商品
                    <#else>
                    增加商品
                </#if>
            </li>
        </div>
        <div class="layui-tab-content">
            <div class="layui-tab-item"></div>
            <div class="layui-tab-item layui-show">

                <div class="layui-form-item">
                    <label class="layui-form-label">商品类目</label>
                    <div class="layui-input-inline">
                        <input type="text" id="goodsCat"  required placeholder="请选择类目" autocomplete="off"
                               class="layui-input">
                    </div>
                    <div class="layui-input-inline">
                        <button class="layui-btn" id="catBtn" data-url="/itemcat/tree" name="cid">商品类目</button>
                    </div>
                    <input type="hidden" id="goodsCatId" name="cid"/>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">商品标题</label>
                    <div class="layui-input-block">
                        <input type="text" name="title" lay-verify="required|title" placeholder="请输入标题"
                               autocomplete="off"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">商品卖点</label>
                    <div class="layui-input-block">
                        <input type="tel" name="sellPoint" lay-verify="required|title"  placeholder="请输入卖点"
                               autocomplete="off"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">商品价格</label>
                    <div class="layui-input-block">
                        <input type="text" name="price" lay-verify="required|number"  placeholder="请输入价格"
                               autocomplete="off"
                               class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">商品数量</label>
                    <div class="layui-input-block">
                        <input type="text" name="num" lay-verify="required|number"  placeholder="请输入数量"
                               autocomplete="off"
                               class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">商品条码</label>
                    <div class="layui-input-block">
                        <input type="text" name="barcode" lay-verify="required|number" required placeholder="请输入条形码"
                               autocomplete="off"
                               class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">图片上传</label>
                    <div class="layui-input-block">
                        <button type="button" class="layui-btn" id="test1">
                            <i class="layui-icon">&#xe67c;</i>上传图片
                        </button>
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">商品描述</label>
                    <div class="layui-input-block">
                        <textarea style="width:800px;height:300px;visibility:hidden;" name="itemDesc" id="editor_id"></textarea>
                    </div>
                </div>

                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="*">立即提交</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>

            </div>
        </div>
    </div>
</form>

<script src="../layui.js"></script>
<script src="../js/common.js"></script>
<script src="../lib/kindeditor/kindeditor-all.js"></script>
<script src="../lib/ueditor/ueditor.all.js"></script>
</body>

<script>
    layui.use(['element','upload','form','layer'], function () {
        var element = layui.element;
        var upload = layui.upload;
        var form = layui.form;
        var layer = layui.layer;
        var editor;
        //渲染富文本编辑器
        KindEditor.ready(function(K) {
            editor = K.create('#editor_id', {
                uploadJson : '/kindeditor/jsp/upload_json.jsp',
                fileManagerJson : '/kindeditor/jsp/file_manager_json.jsp',
                allowFileManager : true
            });
        });


        //图片上传
        /*var uploadInst = upload.render({
            elem: '#test1' //绑定元素
            ,url: '/item/uploadImg' //上传接口
            ,multiple: true
            ,done: function(res){
                //上传完毕回调
            }
            ,error: function(){
               alert(123);
            }
        });*/

        var uploadPram={
            //指定上传文件参数名称
            filePostName  : "uploadFile",
            //指定上传文件请求的url。
            uploadJson : '/item/uploadImg',
            //上传类型，分别为image、flash、media、file
            dir : "image"
        };

        //editor图片上传组件
        $('#test1').click(function () {
            alert(123);
            var form  = $('#addForm');
            KindEditor.editor(uploadPram).loadPlugin('multiimage',function () {
                var editor = this;
                editor.plugin.multiImageDialog({
                    clickFn : function (urlList) {
                        var imgArr = [];
                        KindEditor.each(urlList,function (i, data) {
                            imgArr = data.url;
                            alert(data.url);
                        })
                    }
                });
            })
        });

        //自定义验证规则
        form.verify({
            title: function(value){
                if(value.length < 5){
                    return '标题也太短了吧';
                }
            }
            ,pass: [/(.+){6,12}$/, '密码必须6到12位']
            ,money: [
                /^\d+\.\b\d{2}\b$/
                ,'金额必须为小数保留两位'
            ]
        });

        //监听提交
        form.on('submit(*)', function(data){
            console.log(data.field);
            editor.sync();
            var desc = $('#editor_id').val();
            alert(desc);
            data.field.itemDesc = desc;
            $.post('/item/save',data.field,function(result){
                if(result.code){
                    layer.msg('添加成功');
                }
            });
            return false;
        });

    });
</script>


</html>
