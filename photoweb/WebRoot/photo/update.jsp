<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<base href="http://localhost:8080/photoweb/">
</head>
<body>
	<!-- 判断如果有photo就是修改并回显，没有id就直接返回到页面 -->
	<form action="photoServlet" method="post">
			<c:if test="${empty photo }">
					<input type="hidden" name="action" value="addPhoto">
					<h1>添加图片</h1>
					图名：<input type="text" name="photoName" ><br/>
					图片链接：<input type="text" name="url" ><br/>
					图片详情：<input type="text" name="erea" ><br/>
			</c:if>
			<c:if test="${not empty photo }">
				<input type="hidden" name="action" value="updatePhoto">
				<input type="hidden" name="id" value="${photo.id }">
					<h1>修改图片</h1><br/>
						图名：	 <input type="text" name="photoName" value="${photo.photoName}"><br/>
						图片链接：<input type="text" name="url" value="${photo.url}"><br/>
						图片详情：<input type="text" name="erea" value="${photo.erea}"><br/>
			</c:if>
			<input type="submit" value="提交">
	</form>
	
</body>
</html>