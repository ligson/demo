<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="tangs" uri="/tangs"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

.style1 td {
	background: #AAAAAA;
}

.tbl tr:hover {
	background-color: #00F000;
}

.pager a {
	display: block;
	width: 30px;
	height: 30px;
	text-align: center;
	line-height: 30px;
	float: left;
	margin-left: 5px;
	background-color: #DDDDDD;
}

.pager h1 a {
	width: 100px;
	height: 30px;
	line-height: 30px;
	text-align: center;
	font-size: 12px;
}

.pager span {
	display: block;
	width: 30px;
	height: 30px;
	text-align: center;
	line-height: 30px;
	float: left;
	margin-left: 5px;
}
.font12{
	font-size:12px
}
.font14{
	font-size:14px;
}
.font18{
    font-size:18px;
}
.fontbold{
	font-weight:bold;
}
 .col333{
 	color:#333;
 }
 .col666{
    color:#666
 }
 .col000{
    color:#0000cc;
 }
 .col27a{
  color:#27ae60;
 }
 .search_number{
  display:block;
  ovflow:hidden;
 }
 .search_items_title{
  height:30px;
  line-height:30px;
  
 }
 .search_items{
  margin-bottom:7px;
  margin-top:7px;
 }
 .search_bot{
  height:20px;
  line-height:20px;
 }
 .search_number{
  height:20px;
  line-height:20px;
  margin: 10px 0;
  
  
 }
 .search_number_line{
 padding-bottom:5px;
 border-bottom: 1px solid #999;
 }
 .pad-top{
 padding-top:30px;
 }
</style>
</head>
<body>

	<div class="container pad-top">
		<div class="row">
		<div class="col-md-12">
			<form action="<%=basePath%>search/search">
				<div class="col-md-4">
					<input type="text" name="key"  class="form-control" value="${key}" />
				</div>
				<div class="col-md-4">
					<input type="submit"  class="btn btn-success" value="search" />
				</div>
			</form>
		   </div>
		</div>
		<div class="row">
			<div class="col-md-12  col666 search_number">
			<div class="col-md-12 search_number_line">总共：${result.total}条记录，花费时间${result.useTime}秒</div>
		</div>
		<s:iterator value="result.result" id="model">
			<div class="col-md-12  search_items">
				<div class="col-md-12 search_items_title">
				   
				   
					<a class="font18" href="${model.url}" target="_blank">${model.title}</a>
				</div>
				<div class="col-md-12 font12 col333">${model.content}</div>
				<div class="col-md-12 search_bot">
				   <a href="#" class="font12 col27a" target="_blank">${model.url}</a>&nbsp;&nbsp;&nbsp;<span class="font12 col666"><s:date name="#model.tstamp" format="yyyy-MM-dd"/></span>
				</div>
			</div>
		</s:iterator>
		<div class="row">
			<div class="col-md-12">
				<div class="pager">
					<tangs:pages url="${basePath}search/search" total="${result.total}"
						offset="${offset}" params="key=${key}" max="20" />
					<br/> 总共有条${result.total}记录,当前在第<s:property value="@demo.tag.Pages@getCurrentPages(offset,20)" />页，共<s:property value="@demo.tag.Pages@getTotalPages(total,20)" />页
				</div>
			</div>
		</div>
	</div>

	<s:debug></s:debug>
</body>
</html>