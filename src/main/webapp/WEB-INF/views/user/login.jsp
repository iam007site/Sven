<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!doctype html>
<html lang="en">
<head>
<link rel="shortcut icon" type="image/x-icon"
	href="/resources/img/icon.png" media="screen" />
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	
	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />


    <title>Sven 登录 </title>
    
    <link href="/resources/css/bootstrap3.3.2/bootstrap-3.3.2.min.css" rel="stylesheet" />
	<link href="/resources/css/login/coming-sssoon.css" rel="stylesheet" />    
    
    <!--     Fonts     -->
    <link href="/resources/css/login/font-awesome.css" rel="stylesheet">
    <link href='/resources/css/login/css.css' rel='stylesheet' type='text/css'>
  
</head>

<body>
<!--nav class="navbar navbar-transparent navbar-fixed-top" role="navigation">  
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
    </div>

   
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
         <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown"> 
                <img src="http://demos.creative-tim.com/coming-sssoon-pages/images/flags/US.png"/>
                English(US) 
                <b class="caret"></b>
              </a>
              <ul class="dropdown-menu">
                <li><a href="#"><img src="http://demos.creative-tim.com/coming-sssoon-pages/images/flags/DE.png"/> Deutsch</a></li>
                <li><a href="#"><img src="http://demos.creative-tim.com/coming-sssoon-pages/images/flags/GB.png"/> English(UK)</a></li>
                <li><a href="#"><img src="http://demos.creative-tim.com/coming-sssoon-pages/images/flags/FR.png"/> Français</a></li>
                <li><a href="#"><img src="http://demos.creative-tim.com/coming-sssoon-pages/images/flags/RO.png"/> Română</a></li>
                <li><a href="#"><img src="http://demos.creative-tim.com/coming-sssoon-pages/images/flags/IT.png"/> Italiano</a></li>
                
                <li class="divider"></li>
                <li><a href="#"><img src="http://demos.creative-tim.com/coming-sssoon-pages/images/flags/ES.png"/> Español <span class="label label-default">soon</span></a></li>
                <li><a href="#"><img src="http://demos.creative-tim.com/coming-sssoon-pages/images/flags/BR.png"/> Português <span class="label label-default">soon</span></a></li>
                <li><a href="#"><img src="http://demos.creative-tim.com/coming-sssoon-pages/images/flags/JP.png"/> 日本語 <span class="label label-default">soon</span></a></li>
                <li><a href="#"><img src="http://demos.creative-tim.com/coming-sssoon-pages/images/flags/TR.png"/> Türkçe <span class="label label-default">soon</span></a></li>
             
              </ul>
        </li>

      </ul>
      <ul class="nav navbar-nav navbar-right">
            <li>
                <a href="#"> 
                    <i class="fa fa-facebook-square"></i>
                    Share
                </a>
            </li>
             <li>
                <a href="#"> 
                    <i class="fa fa-twitter"></i>
                    Tweet
                </a>
            </li>
             <li>
                <a href="#"> 
                    <i class="fa fa-envelope-o"></i>
                    Email
                </a>
            </li>
       </ul>
      
    </div>
  </div>
</nav-->
<div class="main" style="background-image: url('/resources/img/login-background.jpg')">

<!--    Change the image source '/images/default.jpg' with your favourite image.     -->
    
    <div class="cover black" data-color="black"></div>
     
<!--   You can change the black color for the filter with those colors: blue, green, red, orange       -->

    <div class="container">
        <h1 class="logo cursive">
            Sven 登录
        </h1>
<!--  H1 can have 2 designs: "logo" and "logo cursive"           -->
        
        <div class="content">
            <h4 class="motto">自由博客我做主</h4>
            <div class="subscribe">
                <h5 class="info-text">
                    <!-- Join the waiting list for the beta. We keep you posted. -->
						

					</h5>
                <div class="row">
                    <div class="col-md-5 col-md-offset-4 col-sm6-6 col-sm-offset-3 ">
						<c:if test="${not empty message}">
						    <div style="color:red">
						       <c:out value="${message }"></c:out>
						    </div>
							
						</c:if>
						<form class="" role="form" action="/user/login" method="post">
                          <div class="form-group ">
                            <label class="sr-only" for="email">Email </label>
                            <input type="email" name="email" id="email"  class="form-control transparent" placeholder="Your email here...">
                          </div>
                          <br>
                          <div class="form-group">
                            <label class="sr-only" for="password">Password </label>
                            <input type="password" name="password" id ="password" class="form-control transparent" placeholder="Your password here...">
                          </div>
                            <input type="hidden" value="1" name="rememberMe">
                          
                          <button type="submit" class="btn btn-danger btn-fill">登录</button>
                                                                      没有账号？点击
                          <a href="/user/register">>>>>注册</a>
                          <!--button type="submit" class="btn btn-danger btn-fill">注册</button-->
                        </form>

                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="footer">
      <div class="container">
             Made By <i class="fa fa-heart heart"></i> by <a href="http://evilcoder.cn">Sven </a>. Get more <a href="http://www.evilcoder.cn">here.</a>
      </div>
    </div>
 </div>
 
 <!--div class="fixed-plugin">
    <div class="dropdown open">
      <a href="#" data-toggle="dropdown"> 
        <i class="fa fa-cog fa-2x"> </i>
      </a>
      <ul class="dropdown-menu">
          <li>
            <a id="filterControl">
                <span class="badge badge-black active" data-color="black"></span>
                <span class="badge badge-blue" data-color="blue"></span>
                <span class="badge badge-green" data-color="green"></span>
                <span class="badge badge-orange" data-color="orange"></span>
                <span class="badge badge-red" data-color="red"></span>
                Filter Color
            </a>
        </li>
       <li class="active">
            <a href="http://demos.creative-tim.com/coming-sssoon-demo-image-background">
                <img src="http://demos.creative-tim.com/coming-sssoon-pages/images/thumb_image.png">
                 Image Background
            </a>
        </li>
        <li>
            <a href="/coming-sssoon-demo-video-background">
                <img src="http://demos.creative-tim.com/coming-sssoon-pages/images/thumb_video.png">
                 Video Background
            </a>
        </li>
        <li>
            <a href="/coming-sssoon-demo-cream-app">
               <img src="http://demos.creative-tim.com/coming-sssoon-pages/images/thumb_application.png">
               Application Page
            </a>
        </li>
         <li>
            <a href="/coming-sssoon-demo-restaurant">
               <img src="http://demos.creative-tim.com/coming-sssoon-pages/images/thumb_restaurant.png">
              Restaurant Page
            </a>
        </li>
       <li>
            <a href="http://ct-freebies.herokuapp.com/coming-sssoon-page-components" target="_blank" class="btn btn-default btn-fill">Tutorial</a>
        </li>
        <li>
            <a href="http://www.creative-tim.com/product/coming-sssoon-page" target="_blank" class="btn btn-info btn-fill">Download, it's free!</a>
        </li>
        <li><a></a></li>
      </ul>
    </div>
 </div-->
</body>
   <script src="/resources/js/jquery1.11.1/jquery-1.11.1.min.js" type="text/javascript"></script>
	<script src="/resources/js/bootstrap/bootstrap.min.js" type="text/javascript"></script>
	
<script>
$('#filterControl .badge').click(function(){
    oldColor = $('.cover').attr('data-color');
    newColor = $(this).attr('data-color');
    $('.cover').removeClass(oldColor).addClass(newColor).attr('data-color',newColor);
    $('#filterControl .badge').each(function(){
        $(this).removeClass('active');
    });
    $(this).addClass('active');
});


</script>


</html>