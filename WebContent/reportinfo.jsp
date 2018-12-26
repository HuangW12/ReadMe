<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>举报</title>
<link href="css/demo.css" rel="stylesheet" type="text/css">

</head>
<body>    
    <section id="getintouch" >
        <div class="container" style="border-bottom: 0;">
            <h1>
                <span>举报</span>
            </h1>
        </div>
        <div class="container">
            <form class="contact" action="addreport" method="post" id="form">           
            <div class="row clearfix">
                <div class="lbl">
                    <label for="uname">
                        被举报人</label>
                </div>
                <input name="bid" type="text"  placeholder="用户名" value=<%String bid=request.getParameter("bid");
					       out.println(bid);%>required>
            </div>
  
            
            <div class="row clearfix">
                <div class="lbl">
                    <label for="scontent">
                        举报内容</label>
                </div>
                <div class="ctrl">
                    <textarea id="rcomment" name="rcomment" rows="6" cols="10"></textarea>
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