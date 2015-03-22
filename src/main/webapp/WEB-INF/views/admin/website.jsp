<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
<head>
<title>展示站点管理</title>
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
			<div class="panel-heading">展示站点管理</div>
			<div class="panel-body"></div>
			<table class="table table-bordered table-hover table-responsive">
				<thead>
					<tr>
						<th class="col-md-1 ">id</th>
						<th class="col-md-2 ">网站名称</th>
						<th class="col-md-4 ">网站地址</th>
						<th class="col-md-3 ">网站logo</th>
						<th class="col-md-2 ">网站管理</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${not empty list}">
							<c:forEach var="item" items="${list}">
								<tr>
									<td class="col-md-1 col-xs-1"><c:out value="${item.nid}"></c:out></td>
									<td class="col-md-2 col-xs-1"><c:out value="${item.name}"></c:out></td>
									<td class="col-md-4 col-xs-4"><a href="${item.url}"><c:out
												value="${item.url}"></c:out></a></td>
									<td class="col-md-3 col-xs-3"><a href="#"
										class="thumbnail"> <img alt="logo" src="${item.logo}"></a></td>
									<td class="col-md-2 col-xs-2"><a
										href="/admin/website/delete?nid=${item.nid}">删除</a></td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<h1 style="text-align: center;">你还没发布站点</h1>
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
					<li><a href="/admin/website/${pageNum-1}">上一页</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="/admin/website/1">上一页</a></li>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${pageNum+1 ge totalPage}">
					<li><a href="/admin/website/${totalPage}">下一页</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="/admin/website/${pageNum+1}">下一页</a></li>
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