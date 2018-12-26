<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!doctype html>
<head>    
    <meta charset="UTF-8">
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
            <form class="contact" action="#" method="post" id="form">           
            <div class="row clearfix">
                <div class="lbl">
                    <label for="username">
                        用户名</label>
                </div>
                ${userSession.uid }
            </div>
  
            <div class="row clearfix">
                <div class="lbl">
                    <label for="stitle">
                        标题</label>
                </div>
                <div class="ctrl">
                   	<input name="stitle" type="text"  class="form-control" value=<%String topic=request.getParameter("topic");
					       out.println(topic); %> required>
                </div>
            </div>     
            
            <div class="row clearfix">
                <div class="lbl">
                    <label for="scontent">
                        内容</label>
                </div>
                <div class="ctrl">
                    <textarea id="scontent" name="scontent" 
                    rows="6" cols="10">
                    <% 
					String content=request.getParameter("articlecontent");
					out.println(content);
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
