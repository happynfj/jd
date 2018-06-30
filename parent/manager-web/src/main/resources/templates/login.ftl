<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>后台登录</title>
		<link rel="stylesheet" type="text/css" href="../css/layui.css" />
		<link rel="stylesheet" type="text/css" href="../css/login.css" />
        <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
		<script src="../layui.js"></script>
	</head>

	<body>
		<div class="m-login-bg">
			<div class="m-login">
				<h3>后台系统登录</h3>
				<div class="m-login-warp">
					<form class="layui-form">
						<div class="layui-form-item">
							<input type="text" name="username" required lay-verify="required" placeholder="用户名" autocomplete="off" class="layui-input">
						</div>
						<div class="layui-form-item">
							<input type="text" name="password" required lay-verify="required" placeholder="密码" autocomplete="off" class="layui-input">
						</div>
						<div class="layui-form-item">
							<div class="layui-inline">
								<input type="text" name="verity" required lay-verify="required" placeholder="验证码" autocomplete="off" class="layui-input">
							</div>
							<div class="layui-inline">
								<img class="verifyImg" onclick="this.src=this.src+'?c='+Math.random();" src="../image/yzm.jpg" />
							</div>
						</div>
						<div class="layui-form-item m-login-btn">
							<div class="layui-inline">
								<button class="layui-btn layui-btn-normal" lay-submit lay-filter="login">登录</button>
							</div>
							<div class="layui-inline">
								<button type="reset" class="layui-btn layui-btn-primary">取消</button>
							</div>
						</div>
					</form>
				</div>
				<p class="copyright">Copyright 2015-2016 by XIAODU</p>
			</div>
		</div>

		<script>
			layui.use(['form', 'layedit', 'laydate'], function() {
				var form = layui.form;
				layer = layui.layer;

				//自定义验证规则
				form.verify({
					username: function(value) {
						if(value.length < 5) {
							return '用户名至少五位';
						}
					},
					password: [/(.+){6,12}$/, '密码必须6到12位'],
					verity: [/(.+){6}$/, '验证码必须是6位'],
					
				});

				//监听提交
				form.on('submit(login)', function(data) {
				   $.post("/sys/login",data.field,function (result) {
					   if(result.code){
					   }
                   });
				});

			});
		</script>
	</body>

</html>