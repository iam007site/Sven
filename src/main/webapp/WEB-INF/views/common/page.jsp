<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<br>
<br>
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