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
<title>uplopad</title>
<link href="<%=basePath%>js/jquery-ui.css" type="text/css"
	rel="stylesheet" />
<script type="text/javascript" src="<%=basePath%>js/jquery-ui-1.9.2.js"></script>


<script type="text/javascript">
	var baseUrl = '<%=basePath%>';
	$(function(){

	});
</script>
</head>
<body>

	<img id="generated" src="<%=basePath%>style/default/images/guest.jpg" />
	<br>

	<input type="button" id="uploadTypeBtn" value="upload一张图片" />
	<input type="button" id="camTypeBtn" value="pai一张图片" />
	<form action="<%=basePath%>user/modifyUserPicAction" method="post"
		enctype="multipart/form-data">
		<s:fielderror fieldName="file" />
		<input type="hidden" name="uid" value="${uid}" /> <input type="file"
			name="file" value="" /> <input type="submit" value="提交" />
	</form>

</body>
</html>