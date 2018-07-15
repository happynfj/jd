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

<div class="layui-row">
    <div class="layui-col-md3">
        <ul id="ztree1" class="ztree"></ul>
    </div>
    <div class="layui-col-md9">
        <form class="layui-form" lay-filter="first">

            <div class="layui-form-item">
                <label class="layui-form-label">操作按钮</label>
                <div class="layui-btn-container">
                    <button class="layui-btn">新增</button>
                    <button class="layui-btn">上移</button>
                    <button class="layui-btn">下移</button>
                    <button class="layui-btn">删除</button>
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">上级菜单</label>
                <div class="layui-input-block">
                    <input type="text" name="pname" placeholder="请输入" autocomplete="off" class="layui-input" disabled>
                </div>
                <input type="hidden" name="pId" id="pId">
                <input type="hidden" name="menuId" id="menuId">
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">菜单类型</label>
                <div class="layui-input-block">
                    <input type="radio" name="menuType" value="M" title="目录">
                    <input type="radio" name="menuType" value="C" title="菜单" checked>
                    <input type="radio" name="menuType" value="F" title="按钮" checked>
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">菜单名称</label>
                <div class="layui-input-block">
                    <input type="text" name="menuName" placeholder="请输入" autocomplete="off" class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">请求地址</label>
                <div class="layui-input-block">
                    <input type="text" name="url" placeholder="请输入" autocomplete="off" class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">权限标识</label>
                <div class="layui-input-block">
                    <input type="text" name="perms" placeholder="请输入" autocomplete="off" class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">显示排序</label>
                <div class="layui-input-block">
                    <input type="text" name="orderNum" placeholder="请输入" autocomplete="off" class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">图标</label>
                <div class="layui-input-block">
                    <input type="text" name="icon" placeholder="请输入" autocomplete="off" class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">菜单状态</label>
                <div class="layui-input-block">
                    <input type="radio" name="visible" value="0" title="显示">
                    <input type="radio" name="visible" value="1" title="隐藏" checked>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit lay-filter="*">立即提交</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
            <!-- 更多表单结构排版请移步文档左侧【页面元素-表单】一项阅览 -->
        </form>
    </div>
</div>

</body>
</html>

<script>
        layui.use('form', function () {
            var form = layui.form;

            //构造Ztree
            var setting = {
                data: {
                    simpleData: {
                        enable: true,
                        pIdKey: "pid"
                    }
                },
                callback: {
                    onClick: handlerClick //点击事件
                }
            };
            $.post('/menu/list', function (result) {
                if (result.code) {
                    $.fn.zTree.init($("#ztree1"), setting, result.data);
                    var zTree = $.fn.zTree.getZTreeObj("ztree1");//获取ztree对象
                    var node = zTree.getNodeByParam('id', 1);//获取id为1的点
                    zTree.selectNode(node); //选择点
                    zTree.expandNode(node); //展开点
                    zTree.setting.callback.onClick(null, zTree.setting.treeId, node);//调用事件
                }
            });

            //ztree点击时间
            function handlerClick(e, treeId, treeNode) {
                $.post('/menu/one',{"id":treeNode.id} ,function (result) {
                    if (result.code == 1) {
                        if(!result.data.pname){
                            result.data.pname = "主目录";
                        }
                        form.val("first", result.data);
                    }
                })
            }
            //监听提交
            form.on('submit(*)', function(data){
                console.log(data.field);
                $.post('/menu/save',data.field,function(result){
                    if(result.code){
                        layer.msg('添加成功');
                    }
                });
                return false;
            });
        })
</script>

