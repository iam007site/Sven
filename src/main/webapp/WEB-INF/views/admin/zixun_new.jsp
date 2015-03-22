<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
<head>
<title>添加资讯文章</title>
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
			<div class="panel-heading">发布资讯文章</div>
			<div class="panel-body"></div>
			<form class="form-horizontal" action="/admin/zx/new" method="post"
				enctype="multipart/form-data" id="zixunForm">
				<fieldset>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 col-xs-4 control-label" for="title">资讯标题</label>
						<div class="col-md-4 col-xs-8">
							<input id="title" name="title" type="text"
								placeholder="请填写资讯标题，最多50字" class="form-control input-md"
								required="">

						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 col-xs-4 control-label" for="author">资讯作者</label>
						<div class="col-md-4 col-xs-8">
							<input id="author" name="author" type="text"
								placeholder="请填写资讯作者名字,最多50字" class="form-control input-md"
								required="">

						</div>
					</div>

					<!-- Select Basic -->
					<div class="form-group">
						<label class="col-md-4 col-xs-4 control-label" for="caipiaoType">资讯种类</label>
						<div class="col-md-4 col-xs-8">
							<select id="caipiaoType" name="caipiaoType" class="form-control">
								<option value="">--请选择--</option>
								<option value="ssq">双色球</option>
								<option value="dlt">大乐透</option>
								<option value="fc3d">福彩3D</option>
								<option value="pl3">排列三</option>
							</select>
						</div>
					</div>

					<!-- Textarea -->
					<div class="form-group">
						<label class="col-md-4 col-xs-4 control-label" for="summary">资讯摘要</label>
						<div class="col-md-7 col-xs-7">
							<textarea rows="10"  class="form-control" id="summary" name="summary">请填写资讯摘要</textarea>
						</div>
					</div>

					<!-- Textarea -->
					<div class="form-group">
						<label class="col-md-4 col-xs-4 control-label" for="content">资讯详情</label>
						<div class="col-md-7 col-xs-7">
							<textarea rows="20" cols="100" class="form-control" id="content" name="content">请填写资讯详情</textarea>
						</div>
					</div>

					<!-- Button -->
					<div class="form-group">
						<label class="col-md-4 col-xs-4 control-label" for="sb"></label>
						<div class="col-md-4 col-xs-4">
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
		$("#zixunNew").addClass("active");
	});
</script>
<script type="text/javascript"
	src="http://cdn.jsdelivr.net/jquery.validation/1.13.1/jquery.validate.js"></script>
<script type="text/javascript"
	src="http://cdn.jsdelivr.net/jquery.validation/1.13.1/additional-methods.min.js"></script>

<script type="text/javascript" src="/resources/js/zixunNew.js"></script>

</html>