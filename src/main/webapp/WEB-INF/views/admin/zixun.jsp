<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
<head>
<title>资讯文章管理</title>
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
			<div class="panel-heading">资讯文章管理</div>
			<div class="panel-body"></div>
			<table class="table table-bordered table-hover table-responsive">
				<thead>
					<tr>
						<th class="col-md-1">id</th>
						<th class="col-md-1">作者</th>
						<th class="col-md-2">文章标题</th>
						<th class="col-md-5">摘要</th>
						<th class="col-md-2">发表时间</th>
						<th class="col-md-1">文章管理</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${not empty list}">
							<c:forEach var="item" items="${list}">
								<tr>
									<td><c:out value="${item.nid}"></c:out></td>
									<td><c:out value="${item.author}"></c:out></td>
									<td><c:out value="${item.title}"></c:out></td>
									<td><c:out value="${item.summary}"></c:out></td>
									<td><fmt:formatDate value="${item.publishTime}"
											type="both" pattern="yyyy-MM-dd HH:mm:ss" /></td>
									<td><a href="/admin/zx/edit?nid=${item.nid}">修改</a>&nbsp;<a
										href="/admin/zx/delete?nid=${item.nid}">删除</a></td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<h1 style="text-align: center;">你还没发布站点资讯</h1>
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
					<li><a href="/admin/zx/${pageNum-1}">上一页</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="/admin/zx/1">上一页</a></li>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${pageNum+1 ge totalPage}">
					<li><a href="/admin/zx/${totalPage}">下一页</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="/admin/zx/${pageNum+1}">下一页</a></li>
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
		$("#webManage").addClass("active");
	});
</script>
</html>