<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="l"%>
<!DOCTYPE html>
<!--
	作者：yhl
	时间：2018-02-09
	描述：文件页面
-->
<html>
	<head>
		<meta charset="utf-8" />
		<title>免费云盘,让生活每一天更好</title>
		<link rel="Shortcut Icon" href="${pageContext.request.contextPath}/images/pig.ico" type="image/x-icon">
	</head>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">  
	<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
	<style>
	/*设置所有内边距和外边距*/
	*{
		padding: 0;
		margin: 0;
	}
	/*logo所在的div容器*/
	#head
	{
		width: 100%;
		height: 115px;
		border-bottom: 1px solid black;
		display: flex;
	}
	/*图片左边div容器*/
	#logo
	{
		width: 300px;
		height: 100%;
		border-right: 1px solid black;
		float: left;
	}
	/*图片右边导航容器*/
	#item
	{
		flex: 1;
		height: 100%;
		/*border-left: 1px solid black;*/
		float: left;
		padding-top: 53px;
	}
	/*logo*/
	#logo img
	{
		width: 190px;
		height: 60px;
		margin-left: 70px;
		margin-top: 40px;
	}
	#con
	{
		width: 100%;
		height: 100%;
		position: fixed;
		background-color: #FFFFFF;
		display: flex;
		flex-flow: row nowrap;
	}
	/*-------------------容器左边----------------------*/
	#left{
		height: 100%;
		width: 300px;
		background-color: #EFF4F8;
		text-align: center;
	}
	#right
	{
		/* height: 100%; */
		flex:1;
		background-color: #FFFFFF; 
		border-radius: 25px;
	}
	#left first
	{
		width: 100%;
		height: 50px;
		border: 1px solid black;
	}
	/*--------------------------------------------------*/
	
	/*=====================容器右边========================*/
	#right1
	{
		width: 100%;
		height: 60px;
		/*border: 1px solid black;*/
		line-height: 60px;
		padding-left: 45px;
	}
	#right2
	{
		width: 100%;
		/* height: 100%; */
		border-left: 1px solid black;
		padding-left: 45px;
	}
	/*===================================================*/
	</style>
	
	<body>
		<div id="head">
			<div id="logo"><img src="${pageContext.request.contextPath}/images/neuedu.png"/></div>
			<div id="item">
				<nav class="navbar navbar-default" role="navigation">
					<div class="container-fluid">
				    <div class="navbar-header">
				        <a class="navbar-brand" href="#">查询文件</a>
				    </div>
				    <div>
				        <form class="navbar-form navbar-left" role="search">
				            <div class="form-group">
				                <input type="text" class="form-control" placeholder="请输入文件">
				            </div>
				            <button type="submit" class="btn btn-default">查询</button>
				        </form>
				        <button type="button" class="btn btn-default navbar-btn">
				            分享
				        </button>
				    </div>
					</div>
				</nav>
			</div>
		</div>
		<div id="con">
			<div id="left">
				<ul class="nav nav-pills nav-stacked">
					<li class="active"><a href="#">全部文件</a></li>
					<li class="active"><a href="File2.do">上传文件</a></li>
					<li class="active"><a href="#">回收站</a></li>
					<li class="active"><a href="index.jsp">今日新闻</a></li>
					<li class="active"><a href="#">种子</a></li>
				</ul>
			</div>
			<div id="right">
				<div id="right1">
					<button type="button" class="btn btn-success" onclick="location='http://localhost:8080/CloudStorage/hello/File2.do'">上传文件</button>
					<button type="button" class="btn btn-info" style="margin-left:4px">离线下载 </button>
					<button type="button" class="btn btn-warning">我的设备</button>
				</div>
				<div id="right2">
					<l:out value="${result}"/>
					<table class="table table-hover" style="border-left: 1px solid navy;">
					  <caption>全部文件</caption>
					  <thead>
					    <tr>
					      <th>文件类型</th>
					      <th>文件名称</th>
					      <th>文件大小</th>
					      <th>创建日期</th>
					      <th>下载</th>
					    </tr>
					  </thead>
					  <tbody>
					    <l:forEach items="${lists}" var="file">
							<tr>
								<td><img src="${pageContext.request.contextPath}/images/file.png" style="width:50px;height:50px"/></td>
								<td>${file.filename}</td>
								<td>${file.filesize}B</td>
								<td>${file.createdate}</td>
								<td><a href="http://localhost:8080/CloudStorage/hello/down.do?id=${file.id}">下载该文件</a></td>
							</tr>
						</l:forEach>
					  </tbody>
					</table>	
				</div>
			</div>		
		</div>
	</body>
</html>
