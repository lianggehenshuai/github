<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="l"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传</title>
</head>
<body>
<form action="update.do" method="POST" enctype="multipart/form-data">
<p>请选择上传的文件:</p>
<input type="file" name="f"/><br/>
<input type="submit" value="上传"> 
<a style="color: red"><l:out value="${message}" /></a><br/>
<a href="http://localhost:8080/CloudStorage/hello/query.do">查看所有文件</a>
</form>
</body>
</html>