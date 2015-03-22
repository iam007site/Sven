<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
<head>
<title>app反馈</title>
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
			<div class="panel-heading">app反馈</div>
			<div class="panel-body"></div>
			<table class="table table-bordered table-hover table-responsive">
				<thead>
					<tr>
						<th class="col-md-1">id</th>
						<th class="col-md-2">手机信息</th>
						<th class="col-md-7">反馈内容</th>
						<th class="col-md-2">反馈时间</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${not empty list}">
							<c:forEach var="item" items="${list}">
								<tr>
									<td><c:out value="${item.nid}"></c:out></td>
									<td><c:out value="${item.device}"></c:out></td>
									<td><c:out value="${item.content}"></c:out></td>
									<td><fmt:formatDate value="${item.publishTime}"
											type="both" pattern="yyyy-MM-dd HH:mm:ss" /></td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<br>
							<br>
							<h1 style="text-align: center;">还没有app反馈信息</h1>
						</c:otherwise>
					</c:choose>

				</tbody>
			</table>
		</div>

		<br> <br>
		<nav>
		<ul class="pager">
			<c:choose>
				<c:when test="${pageNum-1 ge 1}">
					<li><a href="/admin/feedback/${pageNum-1}">上一页</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="/admin/feedback/1">上一页</a></li>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${pageNum+1 ge totalPage}">
					<li><a href="/admin/feedback/${totalPage}">下一页</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="/admin/feedback/${pageNum+1}">下一页</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
		</nav>
		<!-- </div> -->

	</div>
</body>

<jsp:include page="../common/foot.jsp"></jsp:include>
<script type="text/javascript">
	$(function() {
		$("#feedback").addClass("active");
	});
</script>
</html>