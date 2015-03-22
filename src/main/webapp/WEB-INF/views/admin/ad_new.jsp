<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
<head>
<title>添加广告</title>
<jsp:include page="../common/head.jsp"></jsp:include>
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

		<div class="panel panel-primary">
			<!-- Default panel contents -->
			<div class="panel-heading">发布广告</div>
			<div class="panel-body"></div>
			<form class="form-horizontal" action="/admin/ad/new" method="post"
				enctype="multipart/form-data" id="adForm">
				<fieldset>

					<!-- Form Name -->
					<!-- <legend>发布广告</legend> -->

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 col-xs-4 control-label" for="adTitle">广告标语</label>
						<div class="col-md-4 col-xs-8">
							<input id="adTitle" name="title" type="text"
								placeholder="请填入广告标语" class="form-control input-md" required="">
							<!-- <span class="help-block">*</span> -->
						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 col-xs-4 control-label" for="adUrl">广告地址</label>
						<div class="col-md-4 col-xs-8">
							<input id="adUrl" name="url" type="text"
								placeholder="如http://www.baidu.com"
								class="form-control input-md" required=""> 
								<!-- <span class="help-block">*</span> -->
						</div>
					</div>

					<!-- File Button -->
					<div class="form-group">
						<label class="col-md-4 col-xs-4 control-label" for="adImage">广告封面</label>
						<div class="col-md-4 col-xs-8">
							<input id="adImage" name="image" class="input-file" type="file">
						</div>
					</div>

					<!-- Button -->
					<div class="form-group">
						<label class="col-md-4 col-xs-4 control-label" for="sb"></label>
						<div class="col-md-4 col-xs-6">
							<button id="sb" name="sb" class="btn btn-primary">提交</button>
						</div>
					</div>

				</fieldset>
			</form>
		</div>

	</div>
</body>

<jsp:include page="../common/foot.jsp"></jsp:include>
<script type="text/javascript">
	$(function() {
		$("#adNew").addClass("active");
	});
</script>
<script type="text/javascript"
	src="http://cdn.jsdelivr.net/jquery.validation/1.13.1/jquery.validate.js"></script>
<script type="text/javascript"
	src="http://cdn.jsdelivr.net/jquery.validation/1.13.1/additional-methods.min.js"></script>
	
<script type="text/javascript"
	src="/resources/js/adNew.js"></script>

</html>