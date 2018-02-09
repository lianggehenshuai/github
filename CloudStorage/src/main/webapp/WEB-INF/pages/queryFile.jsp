<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="l"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询所有文件</title>
</head>
<body>
<table border="1px">
	<thead>
			<th>文件类型</th>
			<th>id</th>
			<th>文件</th>
			<th>大小</th>
			<th>创建日期</th>
			<th>下载</th>
	</thead>
	<tbody>
		<l:forEach items="${lists}" var="file">
		<tr>
			<td><img src="http://localhost:8080/CloudStorage/image/file.png" style="width:50px;height:50px"/></td>
			<td>${file.id}</td>
			<td>${file.filename}</td>
			<td>${file.filesize}字节</td>
			<td>${file.createdate}</td>
			<td><a href="http://localhost:8080/CloudStorage/hello/down.do?id=${file.id}">下载该文件</a></td>
		</tr>
		</l:forEach>
	</tbody>
</table>
</body>
</html>