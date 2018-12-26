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
    <div class="newstitle"><span>+</span><b>出售列表</b></div>
    <form action="delsellmessage" method="post">
     <c:forEach items="${sellList}" var="s">
      <h2><a href="#" >${s.stitle }</a></h2>
      <h2><a href="#" >${s.uid }</a></h2>
    <a href="delsellmessage?userid=${s.uid}&bid=${s.bid}">删除</a></span>
    </c:forEach>
    </form>
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