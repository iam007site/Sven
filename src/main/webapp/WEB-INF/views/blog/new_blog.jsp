<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
<head>
<title>发布新文章</title>
<jsp:include page="../common/head.jsp"></jsp:include>
<link rel="stylesheet" type="text/css"
	href="http://timschlechter.github.io/bootstrap-tagsinput/examples/lib/bootstrap-tagsinput/bootstrap-tagsinput.css">
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
			<div class="panel-heading">发布新文章</div>
			<div class="panel-body"></div>
			<form class="form-horizontal" action="#" method="post"
				enctype="multipart/form-data" id="form">
				<fieldset>

					<!-- Form Name -->
					<!-- <legend>Form Name</legend> -->

					<div class="row form-group">
						<div class="col-md-offset-1 col-md-2">
							<select id="type" name="type" class="form-control">
								<option value="原创">请选择</option>
								<option value="翻译">原创</option>
								<option value="转载">翻译</option>
								<option value="">转载</option>
							</select>
						</div>
						<div class="col-md-8">
							<input id="title" name="title" type="text" placeholder="请输入文章标题"
								class="form-control input-md" required="">

						</div>
					</div>

					<div class="row form-group">
						<div class="col-md-offset-1 col-md-2 text-center">
							<label class=""><strong>文 章 摘 要 :</strong></label>
						</div>
						<div class="col-md-8">
							<textarea class="form-control" rows="6" id="summary"
								name="summary">请输入文章摘要</textarea>
						</div>
					</div>

					<div class="row form-group">
						<div class="col-md-offset-1 col-md-2 text-center">
							<label class=""><strong>文 章 详 情 :</strong></label>
						</div>
						<div class="col-md-8">
							<textarea rows="20" class="form-control" id="content"
								name="content">请输入文章内容</textarea>
						</div>
					</div>

					<div class="row form-group">
						<div class="col-md-offset-1 col-md-2 text-center">
							<strong>选择文章分类:</strong>

						</div>
						<div class="col-md-8">
							<div class="row">
								<div class="col-md-2">
									<select id="categorySelect" name="categorySelect"
										class="form-control">
										<option value="java">java</option>
										<option value="akka">akka</option>
										<option value="Mysql">Mysql</option>
										<option value="jquery">jquery</option>
									</select>
								</div>
								<div class="col-md-10">
									<div class="row ">
										<div class="col-md-3">
											<span>或新建分类：</span>
										</div>
										<div class="col-md-5">
											<input id="catrgory" name="catrgory" type="text"
												style="width: 100px" class="form-control input-md "
												placeholder="       " />
										</div>
										<div class="col-md-3 pull-right">
											<span>(最多一个分类)</span>
										</div>
									</div>

								</div>

							</div>


						</div>
					</div>

					<!-- Button (Double) -->
					<div class="form-group">
						<label class="col-md-4 control-label" for="submit"></label>
						<div class="col-md-8">
							<button id="submit" name="submit" class="btn btn-success">发
								布</button>
							<button id="preview" name="preview" class="btn btn-danger">预
								览</button>
							<button id="cancel" name="cancel" class="btn btn-error">取消</button>
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

<script type="text/javascript"
	src="http://timschlechter.github.io/bootstrap-tagsinput/examples/lib/angular/angular.min.js"></script>

<script type="text/javascript"
	src="http://timschlechter.github.io/bootstrap-tagsinput/examples/lib/bootstrap-tagsinput/bootstrap-tagsinput.js"></script>

<script type="text/javascript"
	src="http://timschlechter.github.io/bootstrap-tagsinput/examples/lib/bootstrap-tagsinput/bootstrap-tagsinput-angular.js"></script>
<script type="text/javascript" src="/resources/js/newBlog.js"></script>
</html>
