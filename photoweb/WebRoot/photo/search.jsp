<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" align="center">
		<tr>
			<th colspan="5">图片展示</th>
		</tr>
		<tr>
			<th>id</th>
			<th>图名</th>
			<th>图片</th>
			<th>介绍</th>
			<th>操作</th>
		</tr>
		<c:if test="${not empty search }">
		<c:forEach items="${requestScope.search}" var="item">
			<tr>
				<td>${item.id }</td>
				<td>${item.photoName }</td>
				<td><img alt="图片${item.url }" src="photo/${item.url }"  width="100px" height="100px"> </td>
				<td>${item.erea }</td>
				<td><a href="photoServlet?action=showOne&id=${item.id }">修改</a>/<a href="photoServlet?action=deletePhoto&id=${item.id }">删除 </a></td>
			</tr>
		</c:forEach>
		</c:if>
		<c:if test="${empty search }">
			<tr>
				<td>你搜索的图片名不存在</td>
			</tr>
		</c:if>
		</table>
</body>
</html>