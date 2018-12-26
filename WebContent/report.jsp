<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>处理举报信息</title>
 <link href="css/demo.css" rel="stylesheet" type="text/css">
</head>
<body>
<section id="getintouch" >
        <div class="container" style="border-bottom: 0;">
            <h1>
                <span>处理举报信息</span>
            </h1>
        </div>
        <div class="container">
            <form class="contact" action="modifyreport" method="post" id="form">           
            <div class="row clearfix">
                <div class="lbl">
                    <label for="uid">
                        举报用户id</label>
                </div>
                <%String aaid=request.getParameter("aid");
					       out.println(aaid); %> 
		        <input name="aid" type="hidden"  class="form-control" value=<%String aid=request.getParameter("aid");
					       out.println(aid); %> required>
            </div>
  
           <div class="row clearfix">
                <div class="lbl">
                    <label for="uid">
                        被举报用户id</label>
                </div>
                <%String bbid=request.getParameter("bid");
					       out.println(bbid); %> 
				<input name="bid" type="hidden"  class="form-control" value=<%String bid=request.getParameter("bid");
					       out.println(bid); %> required>
            </div>
            
            <div class="row clearfix">
                <div class="lbl">
                    <label for="rcontent">
                      举报内容</label>
                </div>
                <div class="ctrl">
                  <%String rrcomment=request.getParameter("rcomment");
					       out.println(rrcomment); %> 
			    <input name="rcomment" type="hidden"  class="form-control" value=<%String rcomment=request.getParameter("rcomment");
					       out.println(rcomment); %> required>
				<input name="rcomment" type="hidden"  class="form-control" value="${rcomment}" required>
                </div>
            </div>
            
            <div class="row clearfix">
                <div class="lbl">
                    <label for="scontent">
                      处理状态</label>
                </div>
                <div class="ctrl">
                   <input name="rstate" type="text"  value="<%String rstate=request.getParameter("rstate");
					       out.println(rstate); %> " required>
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