<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<base href="http://localhost:8080/photoweb/">
</head>
<body>
	<form action="photoServlet?action=searchPhoto" method="post">
	<div align="center">
		<input type="text" name="photoName" value="">
		<input type="submit" value="搜索"> 
	</div>
	</form>
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
		<c:forEach items="${requestScope.page.items}" var="item">
		<tr>
			<td>${item.id }</td>
			<td>${item.photoName }</td>
			<td><img alt="图片${item.url }" src="photo/${item.url }"  width="100px" height="100px"> </td>
			<td>${item.erea }</td>
			<td><a href="photoServlet?action=showOne&id=${item.id }">修改</a>/<a href="photoServlet?action=deletePhoto&id=${item.id }">删除 </a></td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="4"></td>
			<td>
				<a href="photo/update.jsp">添加</a>
			</td>
		</tr>
	</table>
			<div align="center">
				<a href="photoServlet?action=pagePhoto&pageNo=1">首页</a>&nbsp;
				<c:if test="${page.pageNo>1 }">
					<a href="photoServlet?action=pagePhoto&pageNo=${page.pageNo-1 }">上一页</a>&nbsp;&nbsp;
				</c:if>
				【${page.pageNo }】&nbsp;
				<c:if test="${page.pageNo<page.pageTotal }">
					<a href="photoServlet?action=pagePhoto&pageNo=${page.pageNo+1 }">下一页</a>&nbsp;&nbsp;
				</c:if>
				<a href="photoServlet?action=pagePhoto&pageNo=${page.pageTotal }">末页</a>&nbsp;
				共${page.pageTotal }页&nbsp;
				共${page.totalCount }条记录&nbsp;
				到<input type="text" id="input_no" value="${page.pageNo }">页&nbsp;
				<input type="button" id="search" value="确定">
			</div>
	<script type="text/javascript">
	$(function(){
		// 1.先获取标签对象
		// 2.绑定单击事件
		alert("asasa");
		$("#search").click(function () {
				var pageNo = $("input_no").val();
				location.href = "photoServlet?action=pagePhoto&pageNo="+pageNo;
			});
	});
</script>
</body>
</html>