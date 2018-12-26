<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <title>更改信息</title>
    <link href="css/demo.css" rel="stylesheet" type="text/css">

</head>
<body>    
    <section id="getintouch" >
        <div class="container" style="border-bottom: 0;">
            <h1>
                <span>更改信息</span>
            </h1>
        </div>
        <div class="container">
            <form class="contact" action="modifymyinfo" method="post" id="form">
            <div class="row clearfix">
                <div class="lbl">
                    <label for="name">
                        姓名</label>
                </div>
                <div class="ctrl">
                    <input type="text" id="name" name="truename" data-required="true" data-validation="text"
                        data-msg="Invalid Name" placeholder="${userSession.tname}">
               </div>
            </div>
            
            <div class="row clearfix">
                <div class="lbl">
                    <label for="username">
                        用户名</label>
                </div>
                <div class="ctrl">
                    <input type="text" id="username" name="username" data-required="true" data-validation="*"
                         placeholder="${userSession.uname}">
                </div>
            </div>
            
             <div class="row clearfix">
                <div class="lbl">
                    <label for="username">
                        原密码</label>
                </div>
                <div class="ctrl">
                    <input type="text" id="password" name="opassword" data-required="true" data-validation="*"
                         placeholder="${userSession.upass}">
                </div>
            </div>
            <div class="row clearfix">
                <div class="lbl">
                    <label for="password">
                        新密码</label>
                </div>
                <div class="ctrl">
                    <input name="npassword" type="text"  placeholder="新密码" required>
                </div>
            </div>
            
            
           
            <div class="row  clearfix">
                <div class="span10 offset2">
                    <input type="submit" name="submit" id="submit" class="submit" value="提交">
                </div>
              <input type="hidden" name="uid" data-required="true" value="${userSession.uid}">
              <input type="hidden" name="utype" data-required="true" value="${userSession.utype}">  
            </div>
            </form>
            </div>
        </div>
    </section>
</body>
</html>