package cn.servlet;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.daoimpl.UserDaoImpl;
import cn.entity.BuyComment;
import cn.entity.SellComment;
import cn.entity.User;
import cn.proxy.PermissionProxy;
import cn.tools.Constants;

/**
 * Servlet implementation class delsellcomment
 */
@WebServlet("/delsellcomment")
public class delsellcomment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delsellcomment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置字符
		request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charest=UTF-8");
		PermissionProxy pp= new PermissionProxy();
		User user=new User();
		UserDaoImpl u= new UserDaoImpl();
		user=(User)request.getSession().getAttribute(Constants.USER_SESSION);
		
		Integer sid = Integer.parseInt(request.getParameter("sid"));
		Timestamp d = new Timestamp(System.currentTimeMillis());
		SellComment sellComment = new SellComment();
		sellComment.setSc_content(request.getParameter("comment"));
		sellComment.setSctime(d);
		sellComment.setSid(sid);
		sellComment.setUid(Integer.parseInt(request.getParameter("uid")));

		pp.modifyComment(user, "sellcomment", "delete", sellComment);
		System.out.println("delete sc");
		
	}

}
