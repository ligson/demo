<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色</title>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>js/ztree/css/zTreeStyle/zTreeStyle.css">
<link href="<%=basePath%>js/jquery-ui.css" type="text/css"
	rel="stylesheet" />
<script type="text/javascript" src="<%=basePath%>js/jquery-ui-1.9.2.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/ztree/js/jquery.ztree.all-3.5.js"></script>
<script type="text/javascript">
	var ztree;
	var baseUrl = "<%=basePath%>";
	function zTreeOnAsyncSuccess(event, treeId, treeNode, msg) {
		var nodes = ztree.getNodes();
		
	}
	$(function() {
		var zNodes = [];
		var setting = {
			async : {
				enable : true,
				url : baseUrl+"role/listRoleAction",
				autoParam:["id=pid"]
			},
			callback:{
				onAsyncSuccess: zTreeOnAsyncSuccess
			}
		};
		ztree = $.fn.zTree.init($("#ztree"), setting);
		//ztree.refresh();
		$("#createRoleDialog").dialog({
			autoOpen : false
		});
		$("#createRoleDialogBtn").click(function() {
			$("#createRoleDialog").dialog("open");
		});
		$("#ff").submit(function(){
			var nodes = ztree.getSelectedNodes();
			if(nodes.length==1){
				$("input[name='pid']").val(nodes[0].id);
			}
		});
		$("#testBtn").click(function(){
			var nodes = ztree.getSelectedNodes();
			alert(nodes[0]);
		});
		
		var isRemove = false;
		$("#removeRoleBtn").click(function(){
			var nodes = ztree.getSelectedNodes();
			if(nodes[0]){
				$.post(baseUrl+"role/countChildRoleAction",{pid:nodes[0].id},function(data){
					if(data.count>0){
						confirm("该角色下还有其他角色不能删除");
						isRemove = false;
					}else{
						if(confirm("你确定要删除吗？")){
							$("#rf>input[name='pid']").val(nodes[0].id);
							$("#rf").submit();
						}
						isRemove = true;
					}
				});
			}
		});
		
		$("#updateRoleNameBtn").click(function(){
					
		});
	});
</script>
<style type="text/css">
#cleft {
	width: 300px;
	min-height: 500px;
	border: 1px solid green;
	float: left;
	background: #fff;
}

#cright {width：200px;
	background: #FFF;
	float: left;
}
</style>
</head>
<body>
	<div id="cleft">
		<ul id="ztree" class="ztree"></ul>
	</div>
	<div id="cright">
		<input type="button" id="createRoleDialogBtn" value="创建一个角色" />
		<input type="button" id="testBtn" value="0000" />
		<form action="<%=basePath%>role/removeRoleAction" method="post" id="rf">
			<input type="hidden" name="pid" value="">
		</form>
		<input type="button" id="removeRoleBtn" value="删除选定角色" />
		<input type="button" id="updateRoleNameBtn" value="修改角色名" />
	</div>
	<div id="createRoleDialog" style="display: none;" title="创建一个角色">
		<form action="<%=basePath%>role/createRoleAction" method="post" id="ff">
		<input type="hidden" name="pid" value="" />
			name:<input type="text" name="role.name" value="" /><br /> <input
				type="submit" value="tijiao" />
				
		</form>
	</div>
	<div id="updateRoleNameDialog" style="display:none;" title="修改角色名">
		<span id="roleName"></span>
		
	</div>
</body>
</html>