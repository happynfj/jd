<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>table模块快速使用</title>
  <link rel="stylesheet" href="../css/layui.css" media="all">
</head>
<body>
    <#--表行工具栏模板-->
	<script type="text/html" id="barDemo">
      <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
      <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    </script>

    <#--表头工具栏模板-->
    <script type="text/html" id="toolbarDemo">
      <i class="layui-icon" data-type="add">&#xe654;</i>
      <i class="layui-icon" data-type="delete">&#xe640;</i>
    </script>

<table id="test" lay-filter="test"></table>

<script src="https://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>
<script src="../layui.js"></script>
<script>
layui.use('table', function(){
  var table = layui.table;
  
  //第一个实例
  table.render({
    elem: '#test'
    ,height: 600
    ,url: '/item/list'
    //开启分页
    ,page:true 
    ,limit: 30
      //表头工具栏
    ,toolbar: '#toolbarDemo'
    ,cols: [[
      {type: 'checkbox', fixed: 'left'}
      ,{field:'id', title:'商品ID', width:'5%', fixed: 'left', unresize: true, sort: true}
      ,{field:'title', title:'商品标题',width:'10%', edit: 'text', templet: '#usernameTpl'}
      ,{field:'cid', title:'叶子类目', width:'10%'}
      ,{field:'sellPoint', title:'卖点', width:'10%', edit: 'text', sort: true}
      ,{field:'price', title:'价格', width:'5%', sort: true}
      ,{field:'num', title:'库存数量', width:'5%'}
      ,{field:'barcode', title:'条形码', width:'10%'}
      ,{field:'status', title:'状态', width:'5%'}
      ,{field:'createTime', title:'创建日期', width:'12%', sort: true}
      ,{field:'updateTime', title:'更新日期', width:'12%', sort: true}
      ,{fixed: 'right', title:'操作', toolbar: '#barDemo',width:'12%'}
    ]]
  });

    //监听工具条
    table.on('tool(test)', function(obj){
      var data = obj.data;
        if(obj.event === 'del'){
            layer.confirm('真的删除行么', function(index){
                obj.del();
                layer.close(index);
                $.ajax({
                    url:'/item/del',
                    success:function (result) {
                        if(result.code){
                           // alert("删除成功");
                        }
                    }
                })
            });
        } else if(obj.event === 'edit'){
           /* layer.prompt({
                formType: 2
                ,value: data.username
            }, function(value, index){
                obj.update({
                    username: value
                });
                layer.close(index);
            });*/

            layer.open({
                type: 2,
                area: ['500px', '600px'],
                content:'/item/pageForm'//数组第二项即吸附元素选择器或者DOM
            });
        }
    });

});

</script>
</body>
</html>
