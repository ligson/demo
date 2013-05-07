<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="tangs" uri="/tangs"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	pageContext.setAttribute("basePath", basePath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>I用户列表</title>
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
</style>
<script type="text/javascript">
	function sendMail(uid){
		$.post("${basePath}user/sendMailAction",{uid:uid},function(data){
			if(data.result=="success"){
				alert("邮件发送成功！");
			}else{
				alert("邮件发送失败，错误信息:"+data.errorMsg);
			}
		});
	}
</script>
</head>
<body>
	<table border="1" class="tbl">
		<tr>
			<td>-</td>
			<td>name</td>
			<td>picture</td>
			<td>sex</td>
			<td>birth</td>
			<td>email</td>
			<td>options</td>
		</tr>
		<s:iterator value="users" id="u" status="st">
			<s:if test="#st.even">
				<tr class="style1">
			</s:if>
			<s:else>
				<tr>
			</s:else>
			<td><s:property value="#st.index+1" /></td>
			<td><s:property value='#u.name' /></td>
			<td><img src="<%=basePath %>${u.pic}"
				onerror="this.src='<%=basePath %>skin/default/images/guest.jpg'"
				width=50 height=50 alt="" /></td>
			<td><s:if test="#u.sex">
					男
				</s:if> <s:else>
					女
				</s:else></td>
			<td><tangs:dateFormat dateStringFormat="yyyyMMddHHmmss"
					dateString="${u.birth}" dateParseFormat="yyyy-MM-HH" /></td>
			<td><s:property value='#u.email' /></td>
			<td><a href="${basePath}user/userAction_view?uid=${u.id}">查看详细信息</a>
				<a href="${basePath}user/userAction_remove?uid=${u.id}">删除</a> <a
				href="${basePath}user/userAction_modify?uid=${u.id}">修改信息</a>
				<a href="javascript:void(0);" onclick="sendMail('${u.id}')">发送邮件</a>
				</td>
			</tr>
		</s:iterator>
	</table>
	<div class="pager">
		<tangs:pages url="${basePath}user/userAction_list" total="${total}"
			offset="${offset}" />
		<br /> 总共有条${total}记录,当前在第
		<s:property value="@demo.tag.Pages@getCurrentPages(offset,10)" />
		页，共
		<s:property value="@demo.tag.Pages@getTotalPages(total,10)" />
		页
	</div>
	<a href="${basePath}user/downloadUserList">download</a>
</body>
</html>