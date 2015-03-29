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
<link href="/resources/css/blog/blogdetail.css" rel="stylesheet">
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

			<div class="row col-md-12">
				<div class="col-md-3 left-body">

					<!-- Subscribe to my feed widget -->
					<div class="well text-center left-item">
						<p class="lead">不想错过他的文章更新吗？赶紧订阅他的动态</p>
						<button class="btn btn-primary btn-md">Rss订阅我的动态</button>
					</div>

                    <div class="panel panel-default left-item">
						<div class="panel-heading">
							<h4>最新发表</h4>
						</div>
						<ul class="list-group">
							<li class="list-group-item "><a href="#"> 我的随笔 (0) </a></li>
							<li class="list-group-item "><a href="#"> 我的评论 (0) </a></li>
							<li class="list-group-item "><a href="#"> 我的参与 (0) </a></li>
							<li class="list-group-item "><a href="#"> 最新评论 (0) </a></li>
							<li class="list-group-item "><a href="#"> 我的标签  (0) </a></li>
						</ul>
					</div>

					<div class="panel panel-default left-item">
						<div class="panel-heading">
							<h4>博文分类</h4>
						</div>
						<ul class="list-group">
							<c:if test="${not empty categoryList}">
								<c:forEach items="${ categoryList}" var="category">
									<li class="list-group-item ">
										<a href="/${category.author}/blog/category/${category.categoryId}">
											<c:out value="${category.categoryName}"></c:out> 
											(<c:out value="${category.num}"></c:out>)
										</a>
									</li>
								</c:forEach>
							</c:if>
						</ul>
					</div>

					<div class="panel panel-default left-item">
						<div class="panel-heading">
							<h4>我的标签</h4>
						</div>
						<div class="panel-body">
							<ul class="list-inline">
								<<c:if test="${not empty tags}">
							        <c:forEach items="${tags }" var="tag">
							            <li>
							               <a href="/${author}/blog/tag/${tag}"><c:out value="${tag}"></c:out></a>
							             </li>
							        </c:forEach>
							    </c:if>
							</ul>
						</div>
					</div>

					<div class="panel panel-default left-item">
						<div class="panel-heading">
							<h4>最新评论</h4>
						</div>
						<ul class="list-group">
							<li class="list-group-item"><a href="#">I don't believe
									in astrology but still your writing style is really great! - <em>john</em>
							</a></li>
							<li class="list-group-item"><a href="#">Wow.. what you
									said is really true! I'm an aries though - <em>Anto</em>
							</a></li>
							<li class="list-group-item"><a href="#">Does capricorn
									and aries is compatibile? - <em>Sarah</em>
							</a></li>
							<li class="list-group-item"><a href="#">I'm a cancer
									woman been in love with Leo. Will this work? - <em>Mary</em>
							</a></li>
						</ul>
					</div>

				</div>

				<div class="col-md-9 right-body pull-right">
					<div class="right-body-list">
						<div class="main-content">
						    <c:if test="${not empty blog }">
						        
						    </c:if>
						    <c:choose>
						        <c:when test="${not empty blog }">
						            <article>
								<h3>
									<a href="/${blog.author}/blog/detail/${blog.id}"> [<c:out
											value="${blog.blogType}"></c:out>] &nbsp;&nbsp; <c:out
											value="${blog.title }"></c:out>
									</a>
								</h3>

								<div class="row">
									<div class="group1 col-sm-6 col-md-6">
										<span class="glyphicon glyphicon-folder-open"></span> 
										分类：
										<a href="/${blog.author}/blog/category/${blog.categoryId}"> 
										    <c:out value="${blog.categoryName }"> </c:out>
										</a> 
										<span class="glyphicon glyphicon-bookmark"></span> 
										标签：
										<a href="#">Aries</a>, <a href="#">Fire</a>, <a href="#">Mars</a>
									</div>
									<div class="group2 col-sm-6 col-md-6">
										<span class="glyphicon glyphicon-pencil"></span> <a
											href="singlepost.html#comments">20 Comments</a> <span
											class="glyphicon glyphicon-time"></span>
										<fmt:formatDate value="${blog.createTime}" type="both"
											pattern="yyyy-MM-dd HH:mm:ss" />
									</div>
								</div>
								<hr>
								<!-- <hr> --> <!-- <img src="http://placehold.it/900x300" class="img-responsive"> -->
								
								<h3>摘要：</h3>
								<p class="lead" style="font-size: 18px">
									<c:out value="${blog.summary }" escapeXml="false"></c:out>
								</p>
								<hr>
								<p class=""><c:out value="${blog.content}" escapeXml="false"></c:out>
								</p>
								</article>
						        </c:when>
								<c:otherwise>
									<h1>该文章不存在或已被删除</h1>
									<h3>
										<a href="/home">返回首页</a>
									</h3>
								</c:otherwise>
							</c:choose>
						</div>
					</div>

					<div></div>
				</div>
			</div>
		</div>


		<!-- </div> -->

	</div>
</body>

<jsp:include page="../common/foot.jsp"></jsp:include>
</html>