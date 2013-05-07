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
	pageContext.setAttribute("basePath", basePath);
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="<%=basePath %>skin/default/images/favicon.ico" type="image/x-icon" />
<title>演示学习-<decorator:title default="装饰器页面..." /></title>
<link type="text/css" href="<%=basePath %>skin/default/css/base.css" rel="stylesheet"/>
<link type="text/css" href="<%=basePath%>js/jquery-ui.css" rel="stylesheet"/>
<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery-ui-1.9.2.js"></script>
<script type="text/javascript">
	$(function() {
		resizeUI();
		$(window).resize(function() {
			resizeUI();

		});
		$("#mylink").mouseenter(function(){
			alert(a);
		});
	});
	function resizeUI() {
		var ww = $(window).width();
		var wh = $(window).height();
		if (wh - 200 > 500) {
			$("#main").css("height", wh - 200);
			$("#right").css("height", wh - 220);
		}
		if (ww - 200 > 500) {
			$("#right").css("width", ww - 220);
		}
	}
</script>
<decorator:head />
</head>
<body>

	<div id="header">
		<p><span style="vertical-align:middle;"><img alt="logo" src="<%=basePath%>skin/default/images/icon_youtube_home.png" border="0"></span>&nbsp;演示学习</p>
		<div>
			欢迎你：<a href="${basePath}user/userAction_view?uid=${currentUser.id}" class="my" id="mylink">${currentUser.name}</a>
			
				<div id="mymenu" style="display:none;" >
					<span>sssss</span>
					<span>sssss</span>
					<span>sssss</span>
				</div>
			光临本系统,<a href="<%=basePath%>logout">注销!</a>
		</div>
	</div>
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
			<div id="contentContainer">
				<decorator:body />
			</div>
		</div>
	</div>
	<div id="footer">
		<p>©  2013 ligson. All Rights Reserved. Terms of Use, Privacy and Trademark Standards</p>
	</div>
</body>
<script defer src="http://julying.com/lab/weather/v3/jquery.weather.build.min.js?parentbox=body&moveArea=all&zIndex=1&move=1&drag=1&autoDrop=0&styleSize=big&style=default&area=client"></script>
</html>