<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员空间</title>
<link href="css/index1.css" rel="stylesheet">
</head>
<body>
<header>
  <div class="logo"><a href="administratorspace.jsp">管理员空间</a></div>
  <nav>
    <ul id="starlist">
       <li><a href="viewSellMessage">出售列表</a></li>
      <li><a href="viewBuyMessage">求购列表</a></li>
      <li><a href="userlist">用户列表</a></li>
      <li><a href="reportlist">举报列表</a></li>
      <li><a href="newslist">新闻列表</a></li>   
      <li><a href="information.jsp?uid=${userSession.uid}&password=${userSession.upass}&truename=${userSession.tname}&username=${userSession.uname}">更改个人信息</a></li>
    </ul>
  </nav>
</header>
<div class="box">
  <div class="blank"></div>
   <div class="blogs">
    <div class="bloglist">
    <div class="newstitle"><span><a href="publishnews.html">添加</a></span><b>新闻列表</b></div>
     <c:forEach items="${newsList}" var="news">
      <h2><a href="newslist?ntitle=${news.ntitle }" >${news.ntitle }</a></h2>
      <span ><a href="updatetitle.jsp?uid=${news.uid} &nid=${news.nid} &ntitle=${news.ntitle}&ncontent=${news.ncontent}">修改标题</a>
      <a href="updatecontent.jsp?uid=${news.uid} &nid=${news.nid} &ntitle=${news.ntitle}&ncontent=${news.ncontent}">修改内容</a>
    <a href="delnews?uid=${news.uid}&nid=${news.nid}&ntitle=${news.ntitle}&ncontent=${news.ncontent}">删除</a></span>
    </c:forEach>
    </div>
    </div>
    <aside>
    <div class="paihang">
      <h2>管理员信息</h2>
      <ul>
        <li>用户名 ${userSession.uname }</a></li>
        <li>id ${userSession.uid }</a></li>
      </ul>
    </div>
    </aside>

</div>
</body>
</html>