<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>用户列表</title>
</head>
<body>
	<c:forEach items="${users}" var="item">
		<h4>${item.name}</h4>
		<h4>${item.id}</h4>
		<h4>${item.age}</h4>
		<img alt="" src="getImage.do?id=${item.image}" />
		<a href="getUser.do?id=${item.id}">修改</a>
	</c:forEach>
</body>
</html>
