<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <title>修改出售信息</title>
    <link href="css/demo.css" rel="stylesheet" type="text/css">

</head>
<body>    
    <section id="getintouch" >
        <div class="container" style="border-bottom: 0;">
            <h1>
                <span>修改出售信息</span>
            </h1>
        </div>
        <div class="container">
            <form class="contact" action="modifysell" method="post" id="form">           
            <div class="row clearfix">
                <div class="lbl">
                    <label for="uname">
                        用户名</label>
                </div>
                ${userSession.uname }
            </div>
  
            <div class="row clearfix">
                <div class="lbl">
                    <label for="stitle">
                        标题</label>
                </div>
                <div class="ctrl">
                ${sellSession2.stitle }
                   	<input name="stitle" type="hidden"  value="${sellSession2.stitle }" required>
                </div>
            </div>     
            <div class="row clearfix">
                <div class="lbl">
                    <label for="stitle">
                        书名</label>
                </div>
                <div class="ctrl">
               		 ${bookSession2.bname}
                   	<input name="bname" type="hidden"  value="${bookSession2.bname}" required>
                </div>
            </div> 
            <div class="row clearfix">
                <div class="lbl">
                    <label for="stitle">
                        价格</label>
                </div>
                <div class="ctrl">
                   	<input name="price" type="text"  placeholder="${bookSession2.price}" required>
                </div>
            </div>
            
            <div class="row clearfix">
                <div class="lbl">
                    <label for="stitle">
                        作者</label>
                </div>
                <div class="ctrl">
                ${bookSession2.author}
                   	<input name="author" type="hidden"  value="${bookSession2.author}" required>
                </div>
            </div> 
            <div class="lbl">
                    <label for="stitle">
                        书籍类型</label>
                </div>
                    <select class="form-control input-lg" id="cat_id" name="btype" style="margin-left:4px;margin-top: 5px;">
                        <option value="">请选择</option>
                        <option value=1>计算机类</option>
                        <option value=2>文学类</option>
                        <option value=3>数学类</option>
                        <option value=4>生物学</option>
                        <option value=5>物理学</option>
                        <option value=6>化学类</option>
                        <option value=7>艺术类</option>
                        <option value=8>体育类</option>
                    </select>         
            <div class="row clearfix">
                <div class="lbl">
                    <label for="scontent">
                        内容</label>
                </div>
                <div class="ctrl">
                    <textarea id="scontent" name="scontent" rows="6" cols="10" >
                                        <% 
					String sscontent=request.getParameter("scontent");
					out.println(sscontent);
					%></textarea>
					<input name="scontent" type="hidden"  class="form-control" value=<%String scontent=request.getParameter("scontent");
					       out.println(scontent); %> required>
				<!-- 	<input name="scontent" type="hidden"  class="form-control" value= "${sellSession.scontent }"%> required></textarea>
                 --></div>
            </div>    
            <input name="sid" type="hidden"  class="form-control" value="${sellSession2.sid}" %>       
           <input name="bid" type="hidden"  class="form-control" value="${bookSession2.bid}" %>
            <div class="row  clearfix">
                <div class="span10 offset2">
                    <input type="submit" name="submit" id="submit" class="submit" value="提交">
                </div>
            </div>
            </form>
        </div>
    </section>
</body>
</html>