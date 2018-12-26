package cn.servlet;

import java.io.IOException;

import cn.daoimpl.*;
import cn.entity.*;
import cn.tools.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public register() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
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
		String _password = request.getParameter("password");
		String _trueName = request.getParameter("trueName");
		String _userName = request.getParameter("userName");
		UserDaoImpl userdao = new UserDaoImpl();
		User user = new User();
		user.setTname(_trueName);
		user.setUpass(_password);
		user.setUid(_id);
		user.setUname(_userName);
		boolean flag = false;
		flag = userdao.add(user);
		
		if(flag) {
			request.getSession().setAttribute(Constants.USER_SESSION,user);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("register.html").forward(request, response);
		}
	}

}
