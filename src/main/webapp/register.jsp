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
<title>注册</title>
<link href="<%=basePath%>skin/default/css/register.css" type="text/css"
	rel="stylesheet" />
<link href="<%=basePath%>js/jquery-ui.css" type="text/css"
	rel="stylesheet" />
<script type="text/javascript" src="<%=basePath %>js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="<%=basePath %>js/date.js"></script>
<script type="text/javascript" src="<%=basePath %>js/jquery-ui-1.9.2.js"></script>
<script type="text/javascript"
	src="<%=basePath %>js/jquery.ui.datepicker-zh-CN.js"></script>
<script type="text/javascript">
	$(function(){
		$("#userName").blur(function(){
			var userName = $("#userName").val();
			if(userName!=null&&userName!=""){
				var url = "<%=basePath%>checkNameUnique";
				$.post(url, {
					userName : userName
				}, function(data) {
					if (data.nameIsUnique) {
						$("#userNameErrorMsg").empty();
						$("#userNameErrorMsg").append("用户名唯一");
					} else {
						$("#userNameErrorMsg").empty();
						$("#userNameErrorMsg").append("用户名不唯一");
					}
				});
			}
		});

		$("#datepicker")
				.datepicker(
						{
							showOn : "button",
							buttonImage : "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif",
							buttonImageOnly : true
						});
		var userBirth = "<s:property value='user.birth' />";
		if (userBirth == "") {
			userBirth = new Date();
		} else {
			userBirth = Date.parseFromText(userBirth, "yyyyMMddHHmmss");
		}
		$("#datepicker").datepicker("setDate", userBirth);
		$("#ff").submit(function() {
			var date = $("#datepicker").datepicker("getDate");
			$("input[name='user.birth']").val(date.format("yyyyMMddHHmmss"));
			//return false;	
		});
	});
</script>
</head>
<body>
	<form action="<%=basePath%>register" method="post" id="ff">
		<table>
			<tr>
				<td>name</td>
				<td><input type="text" name="user.name" value="" id="userName" />
				</td>
				<td><span id="userNameErrorMsg"><s:fielderror
							fieldName="user.name" /> </span></td>
			</tr>
			<tr>
				<td>password</td>
				<td><input type="text" name="user.password" value="" /></td>
				<td><s:fielderror fieldName="user.password" /></td>
			</tr>
			<tr>
				<td>sex</td>
				<td><input type="radio" name="user.sex" value="" />男，<input
					type="radio" name="user.sex" value="" />女</td>
				<td><s:fielderror fieldName="user.sex" /></td>
			</tr>
			<tr>
				<td>birth</td>
				<td><input type="text" name="user.birth" value=""
					id="datepicker" /></td>
				<td><s:fielderror fieldName="user.birth" /></td>
			</tr>
			<tr>
				<td>email</td>
				<td><input type="text" name="user.email" value="" /></td>
				<td><s:fielderror fieldName="user.email" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="submit"></td>
				<td></td>
				<td><input type="reset" value="reset"></td>
			</tr>
		</table>
	</form>

</body>
</html>