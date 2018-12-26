package cn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import cn.daoimpl.UserDaoImpl;
import cn.entity.Buy;
import cn.entity.User;
import cn.proxy.PermissionProxy;
import cn.tools.Constants;

/**
 * Servlet implementation class delbuyinfo
 */
@WebServlet("/delbuyinfo")
public class delbuyinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delbuyinfo() {
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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charest=UTF-8");
		PermissionProxy pp= new PermissionProxy();
		User user=new User();
		UserDaoImpl u= new UserDaoImpl();
		user=(User)request.getSession().getAttribute(Constants.USER_SESSION);
		Buy b= new Buy();
		b.setUid(Integer.parseInt(request.getParameter("userid")));
		b.setBtitle(request.getParameter("btitle"));
		System.out.println(b.getUid());		
		System.out.println(b.getBtitle());
		pp.modifyNote(user, "buy", "delete", b);
		if(user.getUtype()==1)
		    request.getRequestDispatcher("/viewBuyMessage").forward(request, response);
		else if (user.getUtype()==0)
			request.getRequestDispatcher("/mybuymessage").forward(request, response);
		System.out.println("成功");
	}

}
