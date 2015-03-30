<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap 101 Template</title>

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
    <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>js/bootstrap-3.2.0/dist/css/bootstrap.css" />

<link rel="stylesheet"
	href="<%=basePath%>js/bootstrap-3.2.0/dist/css/bootstrap-theme.min.css">

<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>

<script src="<%=basePath%>js/bootstrap-3.2.0/dist/js/bootstrap.min.js"></script>
<script src="<%=basePath%>js/bootstrap-3.2.0/js/collapse.js"></script>
<script src="<%=basePath%>js/bootstrap-3.2.0/js/affix.js"></script>
<style type="text/css">
.myBg {
	background-color: green;
}
</style>
</head>
<body>

	<!-- Fixed navbar -->
	<div class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="container" style="height: 50px;">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Project name</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#about">About</a></li>
					<li><a href="#contact">Contact</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Dropdown <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li class="divider"></li>
							<li class="dropdown-header">Nav header</li>
							<li><a href="#">Separated link</a></li>
							<li><a href="#">One more separated link</a></li>
						</ul></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="../navbar/">Default</a></li>
					<li><a href="../navbar-static-top/">Static top</a></li>
					<li class="active"><a href="./">Fixed top</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>

	<div class="container"
		style="margin-top: 50px; background: blue; height: 100px;">
		<h1>JavaScript 插件</h1>
		<p>jQuery 插件为 Bootstrap 的组件赋予了“生命”。可以简单地一次性引入所有插件，或者逐个引入到你的页面中。</p>
	</div>
	<div class="container" style="margin-top: 10px;">
		<div class="row">
			<div class="col-md-8">
				<div class="row">
					<div class="panel panel-default col-md-6" style="height: 200px;">
						<div class="panel-heading">Basic panel example</div>
						<div class="panel-body">
							<ul>
								<li>1111111111111111111111</li>
								<li>1111111111111111111111</li>
								<li>1111111111111111111111</li>
								<li>1111111111111111111111</li>
								<li>1111111111111111111111</li>
							</ul>
						</div>
					</div>
					<div class="panel panel-default col-md-6" style="height: 200px;">
						<div class="panel-heading">Basic panel example</div>
						<div class="panel-body">
							<ul>
								<li>1111111111111111111111</li>
								<li>1111111111111111111111</li>
								<li>1111111111111111111111</li>
								<li>1111111111111111111111</li>
								<li>1111111111111111111111</li>
							</ul>
						</div>
					</div>
					<div class="panel panel-default col-md-6" style="height: 200px;">
						<div class="panel-heading">Basic panel example</div>
						<div class="panel-body">
							<ul>
								<li>1111111111111111111111</li>
								<li>1111111111111111111111</li>
								<li>1111111111111111111111</li>
								<li>1111111111111111111111</li>
								<li>1111111111111111111111</li>
							</ul>
						</div>
					</div>
					<div class="panel panel-default col-md-6" style="height: 200px;">
						<div class="panel-heading">Basic panel example</div>
						<div class="panel-body">
							<ul>
								<li>1111111111111111111111</li>
								<li>1111111111111111111111</li>
								<li>1111111111111111111111</li>
								<li>1111111111111111111111</li>
								<li>1111111111111111111111</li>
							</ul>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="panel panel-default col-md-12" style="height: 200px;">
						<div class="panel-heading">Basic panel example</div>
						<div class="panel-body">
							<ul>
								<li>1111111111111111111111</li>
								<li>1111111111111111111111</li>
								<li>1111111111111111111111</li>
								<li>1111111111111111111111</li>
								<li>1111111111111111111111</li>
							</ul>
						</div>
					</div>
				</div>
			</div>

			<div class="col-md-4">
				<ul class="nav nav-pills nav-stacked" role="tablist">
					<li role="presentation" class="active"><a href="#">Home</a></li>
					<li role="presentation"><a href="#">Profile</a></li>
					<li role="presentation"><a href="#">Messages</a></li>
					<li role="presentation"><a href="#">Messages</a></li>
					<li role="presentation"><a href="#">Messages</a></li>
					<li role="presentation"><a href="#">Messages</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="container" style="height:100px;background:red;">
	aboutboful
	</div>
</body>
</html>