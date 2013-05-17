var ztree;
function zTreeOnAsyncSuccess(event, treeId, treeNode, msg) {
		var nodes = ztree.getNodes();

	}
	$(function() {
		var zNodes = [];
		var setting = {
			async : {
				enable : true,
				url : baseUrl + "role/listRoleAction",
				autoParam : [ "id=pid" ]
			},
			callback : {
				onAsyncSuccess : zTreeOnAsyncSuccess
			}
		};
		ztree = $.fn.zTree.init($("#ztree"), setting);
		//ztree.refresh();
		$("#createRoleDialog").dialog({
			autoOpen : false,
			buttons:{
				"提交" : function() {
					var roleName = $("#ff input[name='role.name']").val();
					if(roleName.isEmpty()){
						$("#ff input[name='role.name']").focus();
					}else{
						$("#ff").submit();
					}
				},
				Cancel : function() {
					$(this).dialog("close");
				}
			}
		});
		$("#createRoleDialogBtn").click(function() {
			$("#createRoleDialog").dialog("open");
		});
		$("#updateRoleNameDialog").dialog({
			autoOpen : false,
			buttons : {
				"提交" : function() {
					var nodes = ztree.getSelectedNodes();
					if (nodes.length == 1) {
						var roleName = $("#updateRoleNameDialog input[name='roleName']").val();
						if(!roleName.isEmpty()){
							$.post(baseUrl+"role/modifyRoleName",{roleId:nodes[0].id,"roleName":roleName.trim()},function(data){
								if(data.result=="success"){
									nodes[0].name = roleName;
									ztree.updateNode(nodes[0]);
									$("#updateRoleNameDialog").dialog("close");
								}else{
									alert("修改失败");
								}
							});
						}else{
							alert("不允许为空！");
						}
					}else{
						alert("位选中");
					}
				},
				Cancel : function() {
					$(this).dialog("close");
				}
			}
		});
		$("#ff").submit(function() {
			var nodes = ztree.getSelectedNodes();
			if (nodes.length == 1) {
				$("input[name='pid']").val(nodes[0].id);
			}
		});
		$("#testBtn").click(function() {
			var nodes = ztree.getSelectedNodes();
			alert(nodes[0]);
		});

		var isRemove = false;
		$("#removeRoleBtn").click(function() {
			var nodes = ztree.getSelectedNodes();
			if (nodes[0]) {
				$.post(baseUrl + "role/countChildRoleAction", {
					pid : nodes[0].id
				}, function(data) {
					if (data.count > 0) {
						confirm("该角色下还有其他角色不能删除");
						isRemove = false;
					} else {
						if (confirm("你确定要删除吗？")) {
							$("#rf>input[name='pid']").val(nodes[0].id);
							$("#rf").submit();
						}
						isRemove = true;
					}
				});
			}
		});

		$("#updateRoleNameBtn").click(function() {
			var nodes = ztree.getSelectedNodes();
			var node = nodes[0];
			if (node) {
				$("#updateRoleNameDialog").dialog("open");
			}
		});
	});