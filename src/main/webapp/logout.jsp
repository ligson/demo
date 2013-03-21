<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>再见</title>
</head>

<body>
<%

 response.setHeader("refresh","2;url=login.jsp");//定时跳转

 session.invalidate();//注销

%>

<h3>你好,你已经退出本系统,两秒后跳会首页</h3>

<h3>如没有跳转,请按<a href="login.jsp">这里</a>
</body>
</html>