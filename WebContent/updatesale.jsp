<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<head>    
    <meta charset="UTF-8">
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
                   	<input name="stitle" type="text" value=<%String stitle=request.getParameter("stitle");
					       out.println(stitle); %> required>
                </div>
            </div>
            <div class="row clearfix">
                <div class="lbl">
                    <label for="bname">
                        书名</label>
                </div>
                <div class="ctrl">
                   	<input name="bname" type="text"  value=<%String bname=request.getParameter("bname");
					       out.println(bname); %> required>
                </div>
            </div>     
            <div class="row clearfix">
                <div class="lbl">
                    <label for="btype">
                        书籍类型</label>
                </div>
                <div class="ctrl">
                   	<input name="btype" type="text"  value=<%String topic=request.getParameter("topic");
					       out.println(topic); %>required>
                </div>
            </div>                 
             <div class="row clearfix">
                <div class="lbl">
                    <label for="price">
                       价格</label>
                </div>
                <div class="ctrl">
                   	<input name="price" type="text"  value=<%String price=request.getParameter("price");
					       out.println(price); %> required>
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
                      value=<%String scontent=request.getParameter("scontent");
					       out.println(scontent); %></textarea>
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
