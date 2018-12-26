package cn.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.entity.Sell;
import cn.entity.User;
import cn.proxy.RealPermission;
import cn.tools.Constants;

/**
 * Servlet implementation class index
 */
@WebServlet("/index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
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
	
		RealPermission re = new RealPermission();
		User user=new User();
		user=(User)request.getSession().getAttribute(Constants.USER_SESSION);
		List<Sell> s= new ArrayList();
		s=(List<Sell>)re.viewNote(user, "sellmessage");
		
		request.setAttribute("sellList", s);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}
