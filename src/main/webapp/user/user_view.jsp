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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>user info</title>
<script type="text/javascript" src="<%=basePath %>js/date.js"></script>
</head>
<body>
pic:


<img src="<%=basePath %>${user.pic}" onerror="this.src='<%=basePath %>style/default/images/guest.jpg'" width=100 height=100 alt=""/>


<a href="<%=basePath%>user/modifyUserPicAction?uid=${user.id}">更改头像</a><br/>
name:${user.name}<br/>
birth:<s:property value="@demo.util.DateUtils@dateTextToFormat(user.birth,'yyyyMMddHHmmss','yyyy-MM-dd')"/> <br/>
email:${user.email}<br/>
sex:${user.sex?"男":"女"}<br/>
${pageScope.basePath}
<%=request.getAttribute("user")%>
</body>
</html>