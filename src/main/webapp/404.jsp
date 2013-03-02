<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>页面未找到</title>
<script type="text/javascript">
	var i = 5;
	function goHome(){
		document.getElementById("number").innerHTML=i--;
		if(i==0){
			window.location.href="./";
		}
		if(i<0){
			i=0;
		}
	}
	setInterval(goHome,1000);
</script>
</head>
<body>
页面未找到！将在<span id="number">5</span>秒内跳转到首页！如果没有跳转请点击<a href="<%=basePath%>index">这里</a>
</body>
</html>