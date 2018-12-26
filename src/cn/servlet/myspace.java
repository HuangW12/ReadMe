package cn.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.daoimpl.UserDaoImpl;
import cn.entity.Buy;
import cn.entity.Sell;
import cn.entity.User;
import cn.proxy.PermissionProxy;
import cn.tools.Constants;

/**
 * Servlet implementation class myspace
 */
@WebServlet("/myspace")
public class myspace extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public myspace() {
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
		
		System.out.println(user);
		List<Sell> sells = new ArrayList<Sell>();
		List<Buy> buys = new ArrayList<Buy>();
		try {
			sells = (List<Sell>) pp.viewMyNote(user, "sellmessage");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			buys = (List<Buy>) pp.viewMyNote(user, "buymessage");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Sell s:sells)
			System.out.println(s);
		for(Buy b:buys)
			System.out.println(b);
		request.setAttribute("sellList",sells);
		request.setAttribute("buyList", buys);
		request.getRequestDispatcher("space.jsp").forward(request, response);
		}

}
