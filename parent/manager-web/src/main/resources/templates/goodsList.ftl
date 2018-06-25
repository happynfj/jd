<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>table模块快速使用</title>
  <link rel="stylesheet" href="../css/layui.css" media="all">
</head>
<body>
	<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script type="text/html" id="toolbarDemo">
  <i class="layui-icon" data-type="add">&#xe654;</i>
  <i class="layui-icon" data-type="delete">&#xe640;</i>
</script>

<table id="test" lay-filter="test"></table>

<!-- <link rel="stylesheet" href="../src/css/layui.css">-->
<script src="https://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>
<script src="../layui.js"></script>
<script>
layui.use('table', function(){
  var table = layui.table;
  
  //第一个实例
  table.render({
    elem: '#test'
    ,height: 450
    ,url: './json/table/demo1.json'
    //,size: 'sm'
    //开启分页
    ,page:true 
    ,limit: 30
    ,toolbar: '#toolbarDemo'
    ,cols: [[
      {type: 'checkbox', fixed: 'left'}
      ,{field:'id', title:'ID', width:80, fixed: 'left', unresize: true, sort: true}
      ,{field:'username', title:'用户名', width:120, edit: 'text', templet: '#usernameTpl'}
      ,{field:'email', title:'邮箱', width:150}
      ,{field:'sex', title:'性别', width:80, edit: 'text', sort: true}
      ,{field:'city', title:'城市', width:100}
      ,{field:'sign', title:'签名'}
      ,{field:'experience', title:'积分', width:80, sort: true}
     /* ,{field:'ip', title:'IP', width:120}
      ,{field:'logins', title:'登入次数', width:100, sort: true}*/
      ,{field:'joinTime', title:'加入时间', width:120}
      ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
    ]]
  });
});
</script>
</body>
</html>
