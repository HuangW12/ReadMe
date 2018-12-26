<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改用户信息与权限</title>
 <link href="css/demo.css" rel="stylesheet" type="text/css">
</head>
<body>
<section id="getintouch" >
        <div class="container" style="border-bottom: 0;">
            <h1>
                <span>更改用户信息</span>
            </h1>
        </div>
        <div class="container">
            <form class="contact" action="modifyuserimfo" method="post" id="form">           
            <div class="row clearfix">
                <div class="lbl">
                    <label for="uid">
                        用户id</label>
                </div>     
		    	<input name="userid" type="text"  class="form-control" value=<%String userid=request.getParameter("uid");
					       out.println(userid); %> required>
            </div>
  
            <div class="row clearfix">
                <div class="lbl">
                    <label for="password">
                     用户密码</label>
                </div>
                <div class="ctrl">
                   	 <input name="upass" type="text"  class="form-control" value=<%String upass=request.getParameter("upass");
					       out.println(upass); %> required>
                </div>
            </div>     
            
            <div class="row clearfix">
                <div class="lbl">
                    <label for="scontent">
                      用户权限</label>
                </div>
                <div class="ctrl">
                   <input name="utype" type="text"  class="form-control" value=<%String utype=request.getParameter("utype");
					       out.println(utype); %> required>
                </div>
            </div>
            
            <div class="row clearfix">
                <div class="lbl">
                    <label for="scontent">
                      用户等级</label>
                </div>
                <div class="ctrl">
                   <input name="uclass" type="text"  class="form-control" value=<%String uclass=request.getParameter("uclass");
					       out.println(uclass); %> required>
                </div>
            </div>
            
             <div class="row clearfix">
                <div class="lbl">
                    <label for="scontent">
                      用户冻结</label>
                </div>
                <div class="ctrl">
                <input name="ustate" type="text"  class="form-control" value=<%String ustate=request.getParameter("ustate");
					       out.println(ustate); %> required>
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