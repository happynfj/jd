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
					<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
					<ul class="layui-nav layui-nav-tree" lay-filter="leftNav">
						<li class="layui-nav-item layui-nav-itemed">
							<a class="" href="javascript:;">商品管理</a>
							<dl class="layui-nav-child">
								<dd>
									<a id="goodsAdd" href="javascript:;" data-url="http://localhost:8011/item/pageList" data-id='1' data-text="新增商品">新增商品</a>
								</dd>
								<dd>
									<a id="goodsList" href="javascript:;" data-url="http://localhost:8011/item/pageList" data-id='2' data-text="商品列表">商品列表</a>
								</dd>
								<dd>
									<a href="javascript:;">规格参数</a>
								</dd>
							</dl>
						</li>

                        <li class="layui-nav-item">
                            <a class="" href="javascript:;">系统管理</a>
                            <dl class="layui-nav-child">
                                <dd>
                                    <a id="goodsAdd" href="javascript:;">用户管理</a>
                                </dd>
                                <dd>
                                    <a id="goodsList" href="javascript:;">角色管理</a>
                                </dd>
                            </dl>
                        </li>

						<li class="layui-nav-item">
							<a href="javascript:;">解决方案</a>
							<dl class="layui-nav-child">
								<dd>
									<a href="javascript:;">列表一</a>
								</dd>
								<dd>
									<a href="javascript:;">列表二</a>
								</dd>
								<dd>
									<a href="">超链接</a>
								</dd>
							</dl>
						</li>
						<li class="layui-nav-item">
							<a href="">云市场</a>
						</li>
						<li class="layui-nav-item">
							<a href="">发布商品</a>
						</li>
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
		<#--<script>
			layui.use('element', function() {
				var element = layui.element;
				$('#goodsAdd').click(function(){
					if ( $("li[lay-id='12']").length > 0 ) {
						//选中选项卡
					element.tabChange('docDemoTabBrief', '12');
					} else{
						//增加选项卡
					element.tabAdd('docDemoTabBrief', {
					title: '增加商品',
					id: '12',
					content: '<iframe src="http://localhost:8011/item/pageList" id="myiframe1" width="100%"  frameborder="0"></iframe>'
					});
					element.tabChange('docDemoTabBrief', '12');
					}
					var ifm= document.getElementById("myiframe1");
					ifm.height=document.documentElement.clientHeight;
				});
				
				$('#goodsList').click(function(){
					//判断选项卡是否存在
					if ( $("li[lay-id='13']").length > 0 ) {
					} else{
						//增加选项卡
					element.tabAdd('docDemoTabBrief', {
					title: '商品列表',
					id: '13',
					content: '<iframe id = "myiframe2" frameborder="0" width="100%" src="http://localhost:8011/item/pageList"></iframe>'
					});
					}
					element.tabChange('docDemoTabBrief', '13');
					var ifm= document.getElementById("myiframe2");
					ifm.height=document.documentElement.clientHeight;
				});
			});
		</script>-->

	</body>

<#--<script>
	$(function () {
        var ifm= document.getElementById("myiframe");
        ifm.height=document.documentElement.clientHeight;
    });
</script>-->
    <script src="../layui.js"></script>
    <script src="../js/main.js"></script>
</html>
