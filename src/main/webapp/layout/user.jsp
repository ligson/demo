<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="tangs" uri="/tangs"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
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
<title>演示学习-<decorator:title default="装饰器页面..." /></title>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

#header {
	width: 100%;
	height: 100px;
	background: blue;
	float: left;
}

#main {
	width: 100%;
	background: green;
	float: left;
}

#footer {
	width: 100%;
	height: 100px;
	background: blue;
	float: left;
}

#left {
	width: 200px;
	height: 100%;
	background: red;
	float: left;
}

#right {
	height: 100%;
	background: yellow;
	overflow: auto;
	float: left;
	background: yellow;
}

.nav h1 {
	font-size: 12px;
	width: 150px;
	height: 40px;
	background: #FF00FF;
	line-height: 40px;
	padding-left: 50px;
	float: left;
}

.nav span,.nav span a {
	font-size: 12px;
	display: block;
	width: 200px;
	height: 30px;
	line-height: 30px;
	float: left;
	background: #01FFEE;
	text-decoration: none;
	background: #01FFEE;
}

.nav span a {
	width: 150px;
	padding-left: 50px;
}

.nav span a:hover {
	color: #FFFFFF;
	font-weight: bold;
	background: #01FF00;
}
</style>
<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	$(function() {
		resizeUI();
		$(window).resize(function() {
			resizeUI();

		});
	});
	function resizeUI() {
		var ww = $(window).width();
		var wh = $(window).height();
		if (wh - 200 > 500) {
			$("#main").css("height", wh - 200);
			$("#right").css("height", wh - 200);
		}
		if (ww - 200 > 500) {
			$("#right").css("width", ww - 200);
		}
	}
</script>
<decorator:head />
</head>
<body>

	<div id="header"></div>
	<div id="main">
		<div id="left">
			<div class="nav">
				<h1>用户管理</h1>
				<span><a href="<%=basePath%>user/userAction_list">用户列表</a></span>
				<span><a href="<%=basePath%>user/userAction_list">用户列表</a></span>
				<span><a href="<%=basePath%>user/userAction_list">用户列表</a></span>
				<span><a href="<%=basePath%>user/userAction_list">用户列表</a></span>
				<span><a href="<%=basePath%>user/userAction_list">用户列表</a></span>
			</div>
			<div class="nav">
				<h1>角色管理</h1>
				<span><a href="<%=basePath%>role/roleTreeAction">角色列表</a></span>
				<span><a href="<%=basePath%>user/userAction_list">用户列表</a></span>
				<span><a href="<%=basePath%>user/userAction_list">用户列表</a></span>
				<span><a href="<%=basePath%>user/userAction_list">用户列表</a></span>
				<span><a href="<%=basePath%>user/userAction_list">用户列表</a></span>
			</div>
			<div class="nav">
				<h1>用户管理</h1>
				<span><a href="<%=basePath%>user/userAction_list">用户列表</a></span>
				<span><a href="<%=basePath%>user/userAction_list">用户列表</a></span>
				<span><a href="<%=basePath%>user/userAction_list">用户列表</a></span>
				<span><a href="<%=basePath%>user/userAction_list">用户列表</a></span>
				<span><a href="<%=basePath%>user/userAction_list">用户列表</a></span>
			</div>
		</div>
		<div id="right">
			<decorator:body />
		</div>
	</div>
	<div id="footer"></div>
</body>
</html>