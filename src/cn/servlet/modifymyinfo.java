package cn.servlet;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.daoimpl.UserDaoImpl;
import cn.entity.User;
import cn.proxy.PermissionProxy;
import cn.tools.Constants;

/**
 * Servlet implementation class modifymyinfo
 */
@WebServlet("/modifymyinfo")
public class modifymyinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifymyinfo() {
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
		//转换字符串
		Integer _id=Integer.parseInt(request.getParameter("uid"));
		Integer _type=Integer.parseInt(request.getParameter("utype"));
		String _password = request.getParameter("npassword");
		String _truename = request.getParameter("truename");
		String _username = request.getParameter("username");
	
		User user = new User();
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		user.setTname(_truename);
		user.setUid(_id);
		user.setUname(_username);
		user.setUpass(_password);
		user.setUtype(_type);
		System.out.println(user.getUpass());
		
		PermissionProxy pp=new PermissionProxy();
		Boolean flag=false;
		try {
			flag=pp.modifyUserInfo(user);
			System.out.println("修改信息成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(flag);
		
		user=userDaoImpl.getById(_id);
		request.getSession().setAttribute(Constants.USER_SESSION,user);
		if(_type==1)
			request.getRequestDispatcher("administratorspace.jsp").forward(request, response);
		else if(_type==0)
			request.getRequestDispatcher("space.jsp").forward(request, response);
		
	}

}
