<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <title>修改求购信息</title>
    <link href="css/demo.css" rel="stylesheet" type="text/css">

</head>
<body>    
    <section id="getintouch" >
        <div class="container" style="border-bottom: 0;">
            <h1>
                <span>修改求购信息</span>
            </h1>
        </div>
        <div class="container">
            <form class="contact" action="modifybuyinfo" method="post" id="form">           
            <div class="row clearfix">
                <div class="lbl">
                    <label for="uname">
                        用户名</label>
                </div>
                ${userSession.uname }
            </div>
  
            <div class="row clearfix">
                <div class="lbl">
                    <label for="btitle">
                        标题</label>
                </div>
                <div class="ctrl">
                <% 
					String bbtitle=request.getParameter("btitle");
					out.println(bbtitle);
					%>
                   	<input name="btitle" type="hidden"  value=<% 
					String btitle=request.getParameter("btitle");
					out.println(btitle);
					%>required>
                </div>
            </div>     
            
            <div class="row clearfix">
                <div class="lbl">
                    <label for="bcontent">
                        内容</label>
                </div>
                <div class="ctrl">
                    <textarea id="bcontent" name="bbcontent" 
                    rows="6" cols="10">
                    <% 
					String bcontent=request.getParameter("bcontent");
					out.println(bcontent);
					%></textarea>
                </div>
            </div>
                      
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