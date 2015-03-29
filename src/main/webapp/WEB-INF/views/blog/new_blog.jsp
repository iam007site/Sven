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

<style type="text/css">
.oldtag{
margin:5px 5px 5px 5px
}
.btnlist{
margin-left:40px;
margin-right:40px
}

</style>
<link rel="stylesheet" type="text/css"
	href="/resources/css/tagsinput/bootstrap-tagsinput.css">
</head>

<body>
	<div class="container">

		<jsp:include page="../common/nav.jsp"></jsp:include>

		<div class="panel panel-primary">
			<!-- Default panel contents -->
			<div class="panel-heading">发布新文章</div>
			<div class="panel-body"></div>
			<form class="form-horizontal" action="/user/blog/new" method="post" id="form">
				<fieldset>

					<!-- Form Name -->
					<!-- <legend>Form Name</legend> -->

					<div class="row form-group">
						<div class="col-md-offset-1 col-md-2  text-center">
							<select id="blogType" name="blogType" class="form-control  text-center">
								<option value="">---请选择--</option>
								<option value="原创">原创</option>
								<option value="翻译">翻译</option>
								<option value="转载">转载</option>
							</select>
						</div>
						<div class="col-md-8">
							<input id="title" name="title" type="text" placeholder="请输入文章标题最多100字"
								class="form-control input-md" required="">

						</div>
					</div>

					<div class="row form-group">
						<div class="col-md-offset-1 col-md-2 text-center">
							<label class=""><strong>文 章 摘 要 :</strong></label>
						</div>
						<div class="col-md-8">
							<textarea class="form-control" rows="6" id="summary"
								name="summary">请输入文章摘要，最多300字</textarea>
						</div>
					</div>

					<div class="row form-group">
						<div class="col-md-offset-1 col-md-2 text-center">
							<label class=""><strong>文 章 详 情 :</strong></label>
						</div>
						<div class="col-md-8">
							<textarea rows="20" class="form-control" id="content"
								name="content">请输入文章内容，最多8000字</textarea>
						</div>
					</div>

					<div class="row form-group">
						<label class="col-md-offset-1 col-md-2 control-label" for="categorytextinput">
							选择文章分类:
						</label>
						<div class="col-md-8" id="categorytextinput">
							<div class="row ">
								<div class="col-md-3">
									<select id="categorySelect" name="categorySelect"
										class="form-control">
										<option value="">-选择已有分类-</option>
										<option value="java">java</option>
										<option value="akka">akka</option>
										<option value="Mysql">Mysql</option>
										<option value="jquery">jquery</option>
									</select>
								</div>
								<div class="col-md-9">
									<div class="row ">
										<div class="col-md-9">
											<input id="category" name="category" type="text" value=""
												style="width: 100px" class="form-control input-md "
												placeholder="       " />
										</div>
										<div class="pull-right">
										<label class="control-label">
							                 (最多一个分类)
						                </label>
										</div>
									</div>

								</div>

							</div>


						</div>
					</div>

					<div class="row form-group">
						<div class="col-md-offset-1 col-md-2 control-label" for="tagstextinput">
							<label>请添加文章标签:</label>
						</div>
						<div class="col-md-8" id="tagstextinput">
							<input id="tags" name="tags" type="text" style="width: 100px" value=""
							class="form-control input-md" placeholder="添加文章标签,最多五个"  /> 
							<span class="help-block">最多5个标签</span>

						</div>
					</div>
					<div class="row form-group">
						<div class="col-md-offset-1 col-md-2">
							<span class="text-center glyphicon glyphicon-plus btn-default btn" data-toggle="collapse" data-target="#collapseExample"
								aria-expanded="false" aria-controls="collapseExample">  我的常用标签:</span>
						</div>
						<div class="col-md-8">
							<div class="collapse" id="collapseExample">
								<div class="panel panel-default">
									<div id="collapseOne" class="panel-collapse collapse in"
										role="tabpanel" aria-labelledby="headingOne">
										<div class="panel-body">
										<span class="btn btn-success oldtag" value="标签">标签1</span>
										<span class="btn btn-success oldtag" value="标签">标签2</span>
										<span class="btn btn-success oldtag" value="标签">标签3</span>
										<span class="btn btn-success oldtag" value="标签">标签4</span>
										<span class="btn btn-success oldtag" value="标签">标签5</span>
										<span class="btn btn-success oldtag" value="标签">标签6</span>
										<span class="btn btn-success oldtag" value="标签">标签7</span>
										<span class="btn btn-success oldtag" value="标签">标签8</span>
										<span class="btn btn-success oldtag" value="标签">标签9</span>
										<span class="btn btn-success oldtag" value="标签">标签10</span>
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
							<button id="submit-btn" name="submit-btn" class="btn btn-success btnlist">发  布</button>
							<button id="preview-btn" name="preview-btn" class="btn btn-error btnlist">预  览</button>
							<button id="cancel-btn" name="cancel-btn" class="btn btn-danger btnlist">取  消</button>
						</div>
					</div>

				</fieldset>
			</form>
		</div>
		<jsp:include page="../common/foot.jsp"></jsp:include>
	</div>

</body>

<script type="text/javascript"
	src="/resources/js/jquery1.11.1/jquery.validate.js"></script>
<script type="text/javascript"
	src="/resources/js/jquery1.11.1/additional-methods.min.js"></script>

<script type="text/javascript"
	src="/resources/js/tagsinput/angular.min.js"></script>

<script type="text/javascript"
	src="/resources/js/tagsinput/bootstrap-tagsinput.min.js"></script>

<script type="text/javascript"
	src="/resources/js/tagsinput/bootstrap-tagsinput-angular.min.js"></script>
<script type="text/javascript" src="/resources/js/newBlog.js"></script>
</html>
