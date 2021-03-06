<!DOCTYPE html>

<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>layout 后台大布局 - Layui</title>
    <link rel="stylesheet" href="../css/layui.css">
    <script src="https://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>
</head>

<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">layui 后台布局</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item">
                <a href="">控制台</a>
            </li>
            <li class="layui-nav-item">
                <a href="">商品管理</a>
            </li>
            <li class="layui-nav-item">
                <a href="">用户</a>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;">其它系统</a>
                <dl class="layui-nav-child">
                    <dd>
                        <a href="">邮件管理</a>
                    </dd>
                    <dd>
                        <a href="">消息管理</a>
                    </dd>
                    <dd>
                        <a href="">授权管理</a>
                    </dd>
                </dl>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img"> 贤心
                </a>
                <dl class="layui-nav-child">
                    <dd>
                        <a href="">基本资料</a>
                    </dd>
                    <dd>
                        <a href="">安全设置</a>
                    </dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="">退了</a>
            </li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">

            <ul class="layui-nav layui-nav-tree" lay-filter="leftNav">
                <#list menuList as menu>
                    <li class="layui-nav-item">
                        <a class="" href="javascript:;">${menu.menuName}</a>
                          <#if (menu.chiList)??>
                               <dl class="layui-nav-child">
                              <#list  menu.chiList as menu>
                                <dd>
                                    <a id="goodsAdd" href="javascript:;"
                                       data-url="${menu.url}"
                                       data-id='${menu.menuId}'
                                       data-text="${menu.menuName}">${menu.menuName}</a>
                                </dd>
                              </#list>
                              <dl>
                          </#if>
                    </li>
                </#list>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!--选项卡-->
        <div class="layui-tab layui-tab-brief" lay-filter="tabF" lay-allowClose="true">
            <ul class="layui-tab-title">
                <li class="layui-this">后台主页</li>
            </ul>
            <div class="layui-tab-content">
                <div class="layui-tab-item layui-show">
                <#--<iframe id = "myiframe" src="http://localhost:8011/welcome" width="100%" height="100%" name="iframe" scrolling="auto" class="iframe" framborder="no"></iframe>-->
                </div>
            </div>
        </div>

    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © layui.com - 底部固定区域
    </div>
</div>

</body>

<script src="../layui.js"></script>
<script src="../js/main.js"></script>
</html>
