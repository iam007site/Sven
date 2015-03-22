<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
<head>
<title>添加展示网站</title>
<jsp:include page="../common/head.jsp"></jsp:include>
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
			<div class="panel-heading">添加展示网站</div>
			<div class="panel-body"></div>

			<form class="form-horizontal" id="webForm" method="post" 
			action="/admin/website/new"  enctype="multipart/form-data">
				<fieldset>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 col-xs-4 control-label" for="name">网站名称</label>
						<div class="col-md-4 col-xs-8">
							<input id="name" name="name" type="text" placeholder="例如：彩票乐"
								class="form-control input-md" required=""> 
								<!-- <span class="help-block">help</span> -->
						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 col-xs-4 control-label" for="url">网站地址</label>
						<div class="col-md-4 col-xs-8">
							<input id="url" name="url" type="text"
								placeholder="例如http://www.baidu.com"
								class="form-control input-md" required="">
						</div>
					</div>



					<!-- Select Basic -->
					<div class="form-group">
						<label class="col-md-4 col-xs-4 control-label" for="score">网站评分</label>
						<div class="col-md-4 col-xs-4">
							<select id="score" name="score" class="form-control">
							    <option value="">请选择</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
							</select>
						</div>
					</div>

					<!-- File Button -->
					<div class="form-group">
						<label class="col-md-4 col-xs-4 control-label" for="logoFile">网站logo</label>
						<div class="col-md-4 col-xs-8">
							<input id="logoFile" name="logoFile" class="input-file" type="file">
						</div>
					</div>

					<!-- File Button -->
					<div class="form-group">
						<label class="col-md-4 col-xs-4 control-label" for="picture1">图片一</label>
						<div class="col-md-4 col-xs-8">
							<input id="picture1" name="picture1" class="input-file"
								type="file">
						</div>
					</div>

					<!-- File Button -->
					<div class="form-group">
						<label class="col-md-4 col-xs-4 control-label" for="picture2">图片二</label>
						<div class="col-md-4 col-xs-8">
							<input id="picture2" name="picture2" class="input-file"
								type="file">
						</div>
					</div>

					<!-- File Button -->
					<div class="form-group">
						<label class="col-md-4 col-xs-4 control-label" for="picture3">图片三</label>
						<div class="col-md-4 col-xs-8">
							<input id="picture3" name="picture3" class="input-file"
								type="file">
						</div>
					</div>

					<!-- Textarea -->
					<div class="form-group">
						<label class="col-md-4 col-xs-4 control-label" for="summary">网站简介</label>
						<div class="col-md-7 col-xs-7">
						    <span class="help-block">最多300字</span>
							<textarea rows="10" class="form-control" id="summary"
								name="summary">填写网站简介</textarea>
						</div>
					</div>

					<!-- Textarea -->
					<div class="form-group">
						<label class="col-md-4 col-xs-4 control-label" for="content">网站详细介绍</label>
						<div class="col-md-7 col-xs-7">
							<textarea rows="20" cols="100" class="form-control" id="content"
								name="content">填写网站详细介绍</textarea>
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
		$("#webNew").addClass("active");
	});
</script>
<script type="text/javascript"
	src="http://cdn.jsdelivr.net/jquery.validation/1.13.1/jquery.validate.js"></script>
<script type="text/javascript"
	src="http://cdn.jsdelivr.net/jquery.validation/1.13.1/additional-methods.min.js"></script>
	
<script type="text/javascript"
	src="/resources/js/websiteNew.js"></script>
</html>