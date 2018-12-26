<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!doctype html>
<head>    
    <meta charset="UTF-8">
    <title>修改新闻内容</title>
    <link href="css/demo.css" rel="stylesheet" type="text/css">

</head>
<body>    
    <section id="getintouch" >
        <section id="getintouch" >
        <div class="container" style="border-bottom: 0;">
            <h1>
                <span>修改新闻内容</span>
            </h1>
        </div>
        <form class="contact" action="modifynewcontent" method="post" id="form">  
              
        <div class="container"> 
         <div class="row clearfix">
                <div class="lbl">
                    <label for="username">
                     用户ID</label>
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
                   	<%String nntitle=request.getParameter("ntitle");
					       out.println(nntitle); %> 
				<input name="ntitle" type="hidden"  class="form-control" value=<%String ntitle=request.getParameter("ntitle");
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
					String ncontent=request.getParameter("ncontent");
					out.println(ncontent);
					%></textarea>
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
   
    </section>
   
</body>
</html>
