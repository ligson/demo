<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
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
<title>Insert title here</title>
<link href="<%=basePath%>js/jquery-ui.css" type="text/css"
	rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>js/imgareaselect/css/imgareaselect-default.css" />
<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery-ui-1.9.2.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/swfobject.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/imgareaselect/scripts/jquery.imgareaselect.pack.js"></script>

<script type="text/javascript">
	var baseUrl = '<%=basePath%>';
	$(function() {
		$('#generated').imgAreaSelect({
			resizable : false,
			maxWidth : 100,
			maxHeight : 100,
			minWidth : 100,
			minHeight : 100
		});

		
	});
</script>
</head>
<body>
	<input type="button" id="uploadTypeBtn" value="上传一张图片" />
	<input type="button" id="camTypeBtn" value="pai一张图片" />


	
	<input type="file" name="pic" id="buttonUpload" />

	<img id="generated" src="<%=basePath%>style/default/images/guest.jpg" />
</body>
</html>