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
<title>update</title>
<link href="<%=basePath %>js/jquery-ui.css" type="text/css"
	rel="stylesheet" />
<script type="text/javascript" src="<%=basePath %>js/date.js"></script>
<script type="text/javascript" src="<%=basePath %>js/jquery-ui-1.9.2.js"></script>
<script type="text/javascript"
	src="<%=basePath %>js/jquery.ui.datepicker-zh-CN.js"></script>
<script type="text/javascript">
	$(function() {
		$("#datepicker").datepicker({
			showOn : "button",
			buttonImage : "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif",
			buttonImageOnly : true
		});
		$("#datepicker").datepicker("setDate",Date.parseFromText("<s:property value='user.birth' />","yyyyMMddHHmmss"));
		$("#ff").submit(function(){
			var date = $("#datepicker").datepicker("getDate");
			$("input[name='user.birth']").val(date.format("yyyyMMddHHmmss"));
			//return false;	
		});
	});
</script>
</head>
<body>
	<form action="<%=basePath%>user/modifyUserInfoAction" method="post" id="ff">
		<input type="hidden" name="user.id" value="${user.id}"> <input
			type="hidden" name="user.birth" value="" />
		<table>
			<tr>
				<td>name</td>
				<td>${user.name}</td>
				<td></td>
			</tr>
			<tr>
				<td>sex</td>
				<td><s:if test="user.sex">
						<label> <input type="radio" name="user.sex" value="true"
							checked="checked" /> 男
						</label>
						<label> <input type="radio" name="user.sex" value="false" />
							女
						</label>

					</s:if> <s:else>
						<label> <input type="radio" name="user.sex" value="true" />
							男
						</label>
						<label> <input type="radio" name="user.sex" value="false"
							checked="checked" /> 女
						</label>
					</s:else></td>
				<td></td>
			</tr>
			<tr>
				<td>birth</td>
				<td><input type="text" id="datepicker" value="" /></td>
				<td></td>
			</tr>
			<tr>
				<td>email</td>
				<td><input type="text" name="user.email" value="${user.email}" /></td>
				<td></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="submit" /></td>
			</tr>
		</table>
	</form>
</body>
</html>