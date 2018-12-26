<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!doctype html>
<head>    
    <meta charset="UTF-8">
    <title>修改新闻标题</title>
    <link href="css/demo.css" rel="stylesheet" type="text/css">

</head>
<body>    
    <section id="getintouch" >
        <div class="container" style="border-bottom: 0;">
            <h1>
                <span>修改新闻标题</span>
            </h1>
        </div>
        <form class="contact" action="modifynewtitle" method="post" id="form">  
              
        <div class="container"> 
         <div class="row clearfix">
                <div class="lbl">
                    <label for="username">
                        用户名</label>
                </div>
                <%String uuid=request.getParameter("uid");
					       out.println(uuid); %> 
				 <input name="uid" type="hidden"  class="form-control" value=<%String uid=request.getParameter("uid");
					       out.println(uid); %> required>
            </div>
    
            <div class="row clearfix">
                <div class="lbl">
                    <label for="stitle">
                        标题</label>
                </div>
                <div class="ctrl">
                   	<input name="ntitle" type="text"  class="form-control" value=<%String ntitle=request.getParameter("ntitle");
					       out.println(ntitle); %> required>
                </div>
            </div>                           
 
                <div class="row clearfix">
                <div class="lbl">
                    <label for="scontent">
                        内容</label>
                </div>
                <div class="ctrl">
                    <textarea id="ncontent" name="ncontent" 
                    rows="6" cols="10">
                    <% 
					String nncontent=request.getParameter("ncontent");
					out.println(nncontent);
					%></textarea>
					<input name="ncontent" type="hidden"  class="form-control" value=<%String ncontent=request.getParameter("ncontent");
					       out.println(ncontent); %> required>
                </div>
            </div>
              
            <div class="row  clearfix">
                <div class="span10 offset2">
                    <input type="submit" name="submit" id="submit" class="submit" value="提交">
                </div>
                <input name="nid" type="hidden"  class="form-control" value=<%String nid=request.getParameter("nid");
					       out.println(nid); %> required>
            </div>
            </div>
            </form>
        </div>
    </section>
   
</body>
</html>
