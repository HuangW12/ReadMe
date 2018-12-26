<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>个人空间</title>
<link href="css/index1.css" rel="stylesheet">
</head>
<body>
<header>
  <div class="logo"><a href="#">个人空间</a></div>
  <nav>
    <ul id="starlist">
      <li><a href="index">首页</a></li>
      <li><a href="viewSellMessage">出售列表</a></li>
      <li><a href="viewBuyMessage">求购列表</a></li>
      <li><a href="PublishSalesInformation.jsp?uname=${userSession.uname }">发布出售信息</a></li>
      <li><a href="PublishBuyInformation.jsp?uname=${userSession.uname }">发布求购信息</a></li>
      <li><a href="information.jsp?uid=${userSession.uid}&password=${userSession.upass}&truename=${userSession.tname}&username=${userSession.uname}">更改个人信息</a></li>
    </ul>
  </nav>
</header>
<div class="box">
  <div class="newsbox f_l ">
    <div class="newstitle"><span><a href="mysellmessage?">+</a></span><b>我的出售信息</b></div>
    <ul class="newsli">
     <c:forEach items="${sellList}" var="sell">
      <h2><a href="sellmessage?bid=${sell.bid}&sid=${sell.sid}&uid=${sell.uid}&stitle=${sell.stitle}&sdate=${sell.sdate}&scontent=${sell.scontent}" title="${sell.stitle }" >${sell.stitle }</a></h2>
    <a href="delsellmessage?userid=${sell.uid}&bid=${sell.bid}">删除</a>        <a href="sellmessage2?bid=${sell.bid}&stitle=${sell.stitle}&scontent=${sell.scontent}&sid=${sell.sid}&uid=${sell.uid}&sdate=${sell.sdate}">修改</a></span>
    </c:forEach>         
    </ul>
  </div>
  <div class="newsbox f_r ">
    <div class="newstitle"><span><a href="mybuymessage?">+</a></span><b>我的求购信息</b></div>
    <ul class="newsli">
       <c:forEach var="mybuy" items="${buyList }" varStatus="status" >
      <h2><a href="getBuyCommentlist?buyid=${mybuy.buyid}&uid=${mybuy.uid}&btitle=${mybuy.btitle}&bdate=${mybuy.bdate}&bcontent=${mybuy.bcontent}" target="_blank" >${mybuy.btitle }</a></h2>
      <a href="delbuyinfo?userid=${mybuy.uid}&buyid=${mybuy.buyid}&btitle=${mybuy.btitle}">删除</a></span>
    	<a href="modifybuy.jsp?userid=${mybuy.uid}&buyid=${mybuy.buyid}&btitle=${mybuy.btitle}&bcontent=${mybuy.bcontent}">修改</a></span>
	</c:forEach>     
    </ul>
  </div>
  <div class="blank"></div>
  <aside>
    
    <div class="paihang">
      <h2>关于我</h2>
      <ul>
        <li>用户名  ${userSession.uname }</li>
        <li>id  ${userSession.uid }</li>
        <li>等级 ${userSession.uclass }</li>
      </ul>
    </div>

 
  </aside>
</div>

</body>
</html>