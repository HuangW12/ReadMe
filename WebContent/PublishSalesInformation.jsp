<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <title>发布出售信息</title>
    <link href="css/demo.css" rel="stylesheet" type="text/css">

</head>
<body>    
    <section id="getintouch" >
        <div class="container" style="border-bottom: 0;">
            <h1>
                <span>发布出售信息</span>
            </h1>
        </div>
        <div class="container">
            <form class="contact" action="addsellinfo" method="post" id="form">           
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
                   	<input name="stitle" type="text"  placeholder="标题" required>
                </div>
            </div>     
            <div class="row clearfix">
                <div class="lbl">
                    <label for="stitle">
                        书名</label>
                </div>
                <div class="ctrl">
                   	<input name="bname" type="text"  placeholder="书名" required>
                </div>
            </div> 
            <div class="row clearfix">
                <div class="lbl">
                    <label for="stitle">
                        价格</label>
                </div>
                <div class="ctrl">
                   	<input name="price" type="text"  placeholder="价格" required>
                </div>
            </div>
            
            <div class="row clearfix">
                <div class="lbl">
                    <label for="stitle">
                        作者</label>
                </div>
                <div class="ctrl">
                   	<input name="author" type="text"  placeholder="作者" required>
                </div>
            </div> 
            <div class="lbl">
                    <label for="stitle">
                        书籍类型</label>
                </div>
                    <select class="form-control input-lg" id="cat_id" name="type" style="margin-left:4px;margin-top: 5px;">
                        <option value="">请选择</option>
                        <option value=计算机类>计算机类</option>
                        <option value=文学类>文学类</option>
                        <option value=数学类>数学类</option>
                        <option value=生物学>生物学</option>
                        <option value=物理学>物理学</option>
                        <option value=化学类>化学类</option>
                        <option value=艺术类>艺术类</option>
                        <option value=体育类>体育类</option>
                    </select>         
            <div class="row clearfix">
                <div class="lbl">
                    <label for="scontent">
                        内容</label>
                </div>
                <div class="ctrl">
                    <textarea id="scontent" name="scontent" rows="6" cols="10"></textarea>
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