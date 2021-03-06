<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>分类列表</title>
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
<body class="user-select">
<header class="header">
<nav class="navbar navbar-default" id="navbar">
<div class="container">
  <div class="header-topbar hidden-xs link-border">
	<ul class="site-nav topmenu">
<% if(session.getAttribute("uuid")==null){%> 	
       <li><a href="login.html" >登录</a></li>
		<li><a href="registered.html" rel="nofollow" >注册</a></li>
    <% } else {%><% String uid=session.getAttribute("uuid").toString();%> 欢迎登录！
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
	  <li><a data-cont="转让信息" title="出售列表" href="viewSellMessage">出售列表</a></li>
	  <li><a data-cont="求购信息" title="求购列表" href="viewBuyMessage">求购列表</a></li>
	  <li><a data-cont="空间" title="空间" href="myspace" >空间</a></li>
	</ul>
  </div>
</div>
</nav>
</header>
<section class="container">
<div class="content-wrap">
<div class="content">
  <div class="title">
	<h3 style="line-height: 1.3">我的求购信息</h3>
  </div>
<c:forEach var="mybuy" items="${buyList }" varStatus="status" >
  <article class="excerpt excerpt-1" style="">             
		<header>
 <h2><a href="getBuyCommentlist?buyid=${mybuy.buyid}&uid=${mybuy.uid}&btitle=${mybuy.btitle}&bdate=${mybuy.bdate}&bcontent=${mybuy.bcontent}" target="_blank" >${mybuy.btitle }</a></h2>
      <a href="delbuyinfo?userid=${mybuy.uid}&buyid=${mybuy.buyid}&btitle=${mybuy.btitle}">删除</a></span>
    	<a href="modifybuy.jsp?userid=${mybuy.uid}&buyid=${mybuy.buyid}&btitle=${mybuy.btitle}&bcontent=${mybuy.bcontent}">修改</a></span>
		</header>
		<p class="meta">
			<time class="time"><i class="glyphicon glyphicon-time"></i> ${mybuy.bdate }</time>
		</p>
		<p class="note">${mybuy.bcontent}</p>
	</article>
	</c:forEach>
  <nav class="pagination" style="display: none;">
	<ul>
	  <li class="prev-page"></li>
	  <li class="active"><span>1</span></li>
	  <li><a href="?page=2">2</a></li>
	  <li class="next-page"><a href="?page=2">下一页</a></li>
	  <li><span>共 2 页</span></li>
	</ul>
  </nav>
</div>
</div>
<aside class="sidebar">
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