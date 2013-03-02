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
<title>login</title>
</head>
<body>
<s:actionmessage/>
<s:debug></s:debug>
	<form action="<%=basePath%>login" method="post">
		<table>
			<tr>
				<td>name</td>
				<td><input type="text" name="name" value="admin" /></td>
			</tr>
			<tr>
				<td>password</td>
				<td><input type="password" name="password" value="password" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="login"></td>
			</tr>
		</table>
	</form>
</body>
</html>
