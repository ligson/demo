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
<link rel="shortcut icon" href="<%=basePath %>skin/default/images/favicon.ico" type="image/x-icon" />
<link href="<%=basePath %>skin/default/css/layout_login.css" rel="stylesheet" type="text/css">
</head>
<body class="logincss" screen_capture_injected="true">
	<s:debug></s:debug>
	<form action="<%=basePath%>login" method="post">
		<div></div>
		<div class="logbox">
			<div class="loginbox">
				<table width="282" border="0" align="right" cellpadding="0"
					cellspacing="0">
					<tbody>
						<tr height="30">
							<td style="color:red;"><s:actionmessage /></td>
						</tr>
						<tr>
							<td>
								<table width="282" border="0" cellspacing="0" cellpadding="0">
									<tbody>
										<tr>
											<td height="33" class="txtIpt">
												用户名 <input name="name" type="text" maxlength="25" id="name"
												style="ime-mode: disabled; border: 0" value="libiao"  />
											</td>
										</tr>
									</tbody>
								</table>
							</td>
						</tr>
						<tr>
							<td style="padding-top: 12px">
								<table width="282" border="0" cellspacing="0" cellpadding="0">
									<tbody>
										<tr>
											<td height="33" class="txtIpt">
												密&nbsp;&nbsp;&nbsp;&nbsp;码 <input name="password"
												type="password" maxlength="50" id="password"
												style="ime-mode: disabled; border: 0" value="libiao"/>
											</td>
										</tr>
									</tbody>
								</table>
							</td>
						</tr>
						<tr height="30">
							<td>
								<input type="checkbox"  >
								两周内不用登陆
							</td>
						</tr>
						<tr>
							<td height="50" valign="bottom">
								<table border="0" width="100%" height="100%" cellpadding="0" cellspacing="0">
									<tbody>
										<tr>
											<td align="center"><input type="image"  id="IBtnLogin"
												border="0" src="<%=basePath %>skin/default/images/btn_login.gif"
												style="border-width: 0px;"></td>
											<td  align="center"><a href="">忘记密码？</a></td>
										</tr>
									</tbody>
								</table>
							</td>
						</tr>
						<tr>
							<td align="right">没有账号？<a>注册一个</a></td>
						</tr>
						
					</tbody>
				</table>
			</div>
		</div>
		<p>
			Copyright <span class="copyright">©</span> 2012-2013 沙舟狼客工作室<img
				border="0" hspace="0" vspace="0" src="<%=basePath %>skin/default/images/pic.gif">
		</p>

		<div></div>
	</form>
</body>
</html>
