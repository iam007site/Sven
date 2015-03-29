<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
<head>
<title>403-文章不存在</title>
<jsp:include page="../common/head.jsp"></jsp:include>

<style type="text/css">
body {
	background-color: rgb(239, 239, 234);
}

.left-body {
	margin: 0;
	padding: 0;
	width: 250px;
	min-height: 200px;
}

.left-item {
	border-radius: 7px 7px 7px 7px;
	box-shadow: 1px 1px 2px #a7a8ad;
	background: #fff;
	margin: 0 5px 20px;
	padding: 5px;
}

.left-item-li {
	padding: 5px;
}

.left-item-title {
	color: #fff;
	border-bottom: 1px solid #dadfe1;
	height: 1.5em;
	line-height: 1.5em;
	background: #2eb1e8;
	border-top-left-radius: 7px;
	border-top-right-radius: 7px;
	text-indent: 1em;
	text-shadow: 1px 1px 0 rgba(0, 0, 0, .3);
}

.right-body {
	height: 100%;
	background-color: #fff;
	border-radius: 7px 7px 7px 7px;
	box-shadow: 1px 1px 2px #a7a8ad;
}

.right-body-list {
	padding: 5px;
}

}
.right-body-list-item {
	min-height: 20px;
	margin-bottom: 30px;
	padding-bottom: 5px;
	width: 100%;
}
</style>
</head>

</head>
<body>

	<div class="container">

		<jsp:include page="../common/nav.jsp"></jsp:include>

		<c:if test="${not empty message}">
			<p class="bg-danger">
				<c:out value="${message }"></c:out>
			</p>
		</c:if>

		<div class="container-fluid">
			<div class="row text-center">
				<h1>该文章不存在或已被删除</h1>
				<h3><a href="/home">返回首页</a></h3>
			</div>


		</div>



	</div>
</body>

<jsp:include page="../common/foot.jsp"></jsp:include>
</html>