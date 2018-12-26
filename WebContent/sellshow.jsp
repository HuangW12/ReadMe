<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>show</title>
<meta name="keywords" content="">
<meta name="description" content="">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/nprogress.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
<link rel="apple-touch-icon-precomposed" href="images/icon.png">
<link rel="shortcut icon" href="images/favicon.ico">
<script src="js/jquery-2.1.4.min.js"></script>
<script src="js/nprogress.js"></script>
<script src="js/jquery.lazyload.min.js"></script>
<!--[if gte IE 9]>
<script src="js/jquery-1.11.1.min.js" type="text/javascript"></script>
<script src="js/html5shiv.min.js" type="text/javascript"></script>
<script src="js/respond.min.js" type="text/javascript"></script>
<script src="js/selectivizr-min.js" type="text/javascript"></script>
<![endif]-->
<!--[if lt IE 9]>
<script>window.location.href='upgrade-browser.html';</script>
<![endif]-->
</head>
<body class="user-select single">
<header class="header">
<nav class="navbar navbar-default" id="navbar">
<div class="container">
  <div class="header-topbar hidden-xs link-border">
	<ul class="site-nav topmenu">
<% if(session.getAttribute("uuid")==null){%> 	
       <li><a href="login.html" >登录</a></li>
		<li><a href="registered.html" rel="nofollow" >注册</a></li>
    <% } else {%><%%> 欢迎登录！
    <li><a href="Logout" >注销</a></li>
     <%}%>  

	</ul>
			E-book Share your knowledge!</div>
  <div class="navbar-header">
	<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#header-navbar" aria-expanded="false"> <span class="sr-only"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
	<h1 class="logo hvr-bounce-in"><a href="#" title="E-book"></a></h1>
  </div>
  <div class="collapse navbar-collapse" id="header-navbar">
	<ul class="nav navbar-nav navbar-right">
	  <li><a data-cont="首页" title="首页" href="index">首页</a></li>
	  <li><a data-cont="转让信息" title="转让信息" href="viewSellMessage">出售列表</a></li>
	  <li><a data-cont="求购信息" title="求购信息" href="viewBuyMessage">求购列表</a></li>
	  <% if(session.getAttribute("uuid")==null){%> 	
       <li><a data-cont="空间" title="登录" href="login.html" >登录</a></li>
    <% } else {%><%%> 
	  <li><a data-cont="空间" title="空间" href="myspace" >空间</a></li>
     <%}%> 
	</ul>
  </div>
</div>
</nav>
</header>
<section class="container">
<div class="content-wrap">
<div class="content">
  <header class="article-header">
	<h1 class="article-title"><a href="#" title="" >${sellSession.stitle }</a></h1>
	<div class="article-meta"> <span class="item article-meta-time">
	  <time class="time" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="发表时间：2016-10-14"><i class="glyphicon glyphicon-time"></i> ${sellSession.sdate }</time>
	  </span> <span class="item article-meta-source" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="来源：木庄网络博客"><i class="glyphicon glyphicon-globe"></i>${sellSession.uid }</span> <span class="item article-meta-category" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="MZ-NetBlog主题"><i class="glyphicon glyphicon-list"></i> <a href="#" title="MZ-NetBlog主题" >${btypeSession }</a></span> </div>
  </header>
  <article class="article-content">
	<p>
	书籍名：${bookSession.bname}</p>
	<p>作者：${bookSession.author}</p>
	<p>价格:${bookSession.price }</p>
	<p>内容描述：${sellSession.scontent }
	</p>

  </article>
   	  <% if(session.getAttribute("uuid")==null){%> 	
       <li><a data-cont="空间" title="登录" href="login.html" >登录</a></li>
    <% } else {%><%%> 
  <div class="article-tags"><a href="reportinfo.jsp?bid=${sellSession.uid}" rel="tag" >举报
	</a></div>
  <div class="title" id="comment">
	<h3>评论</h3>
  </div>
  <div id="respond">
		<form id="comment-form" name="comment-form" action="addsellcomment" method="POST">
			<div class="comment">
				<div class="comment-box">
					<textarea placeholder="您的评论或留言（必填）" name="comment" id="sid" cols="100%" rows="3" tabindex="3"></textarea>
					 <input name="sid" type="hidden"  class="form-control" value="${sellSession.sid }" required>
					<div class="comment-ctrl">
						<div class="comment-prompt" style="display: none;"> <i class="fa fa-spin fa-circle-o-notch"></i> <span class="comment-prompt-text">评论正在提交中...请稍后</span> </div>
						<div class="comment-success" style="display: none;"> <i class="fa fa-check"></i> <span class="comment-prompt-text">评论提交成功...</span> </div>
						<button type="submit" name="comment-submit" id="comment-submit" tabindex="4">评论</button>
					</div>
				</div>
			</div>
		</form>
		
	</div>
	<%}%> 
  <div id="postcomments">
	<ol id="comment_list" class="commentlist">      
	<c:forEach var="sellcomment" items="${scommentList }" varStatus="status" >  
	<li class="comment-content"><div class="comment-main"><p>${sellcomment.uid}<span class="time">${sellcomment.sctime}</span><br>${sellcomment.sc_content}</p></div></li>
  </c:forEach>
  </ol>
  </div>
</div>
</div>
<aside class="sidebar">
<div class="fixed">
  <div class="widget widget_search">
	<form class="navbar-form" action="SearchSellbyBtitle" method="post">
	  <div class="input-group">
		<input type="text" name="btitle" class="form-control" size="35" placeholder="请输入关键字" maxlength="15" autocomplete="off">
		<span class="input-group-btn">
		<button class="btn btn-default btn-search" name="search" type="submit">搜索</button>
		</span> </div>
	</form>
  </div>
</div>
<div class="widget widget_hot">
	  <h3>书籍分类</h3>
	  <ul>            
		<li><a title="计算机" href="classification?type=计算机类" ><span class="text">计算机
			</span>
			<a title="数学" href="classification?type=数学类" ><span class="text">数学
			</span>
			<a title="英语" href="classification?type=生物学" ><span class="text">生物
			</span>
			<a title="文学" href="classification?type=文学类" ><span class="text">文学</span>
			<a title="文学" href="classification?type=化学类" ><span class="text">化学</span>
			<a title="文学" href="classification?type=生物类" ><span class="text">生物学</span>
			<a title="文学" href="classification?type=物理类" ><span class="text">物理学</span>
			<a title="文学" href="classification?type=艺术类" ><span class="text">艺术</span>
			<a title="文学" href="classification?type=体育类" ><span class="text">体育</span>
		</li>
	  </ul>
</div>
</aside>
</section>

<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.ias.js"></script>
<script src="js/scripts.js"></script>
</body>
</html>