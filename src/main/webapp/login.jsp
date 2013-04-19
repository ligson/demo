<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>登陆</title>
<link rel="shortcut icon"
	href="<%=basePath%>skin/default/images/favicon.ico"
	type="image/x-icon" />
<link href="<%=basePath%>skin/default/css/layout_login.css"
	rel="stylesheet" type="text/css" />
</head>
<body class="logincss">
	<form action="<%=basePath%>login" method="post">
		<div></div>
		<div class="logbox">
			<div class="loginbox">
				<table width="282" border="0" align="right" cellpadding="0"
					cellspacing="0">
					<tbody>
						<tr style="width: 30px; height: 60px;">
							<td
								style="color: red; width: 30px; height: 60px; word-wrap: break-word; word-break: break-all; overflow: hidden;"><s:actionerror /></td>
						</tr>
						<tr>
							<td>
								<table width="282" border="0" cellspacing="0" cellpadding="0">
									<tbody>
										<tr>
											<td height="33" class="txtIpt">用户名 <input name="name"
												type="text" maxlength="25" id="name" style="border: 0"
												value="admin" />
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
												style="ime-mode: disabled; border: 0" value="password" />
											</td>
										</tr>
									</tbody>
								</table>
							</td>
						</tr>
						<tr height="30">
							<td><input type="checkbox" id="chk" /> 两周内不用登陆</td>
						</tr>
						<tr>
							<td height="50" valign="bottom">
								<table border="0" width="100%" heigth="100%" cellpadding="0"
									cellspacing="0">
									<tbody>
										<tr>
											<td align="center"><input type="submit" id="IBtnLogin"
												style="width:124px;height:30px;border-width:0;background:url('<%=basePath%>skin/default/images/btn_login.gif');"
												value="" /></td>
											<td align="center"><a href="">忘记密码？</a></td>
										</tr>
									</tbody>
								</table>
							</td>
						</tr>
						<tr>
							<td align="right">没有账号？<a href="register.jsp">注册一个</a></td>
						</tr>

					</tbody>
				</table>
			</div>
		</div>
		<p>
			Copyright <span class="copyright">©</span> 2012-2013 沙舟狼客工作室<img
				border="0" hspace="0" vspace="0"
				src="<%=basePath%>skin/default/images/pic.gif" />
		</p>

		<div></div>
	</form>
</body>
</html>
