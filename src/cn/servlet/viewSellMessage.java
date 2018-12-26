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
import cn.entity.Sell;
import cn.entity.User;
import cn.proxy.PermissionProxy;
import cn.tools.Constants;

/**
 * Servlet implementation class viewSellMessage
 */
@WebServlet("/viewSellMessage")
public class viewSellMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewSellMessage() {
        super();
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
				
				PermissionProxy pp= new PermissionProxy();
				User user=new User();
				UserDaoImpl u= new UserDaoImpl();
				user=(User)request.getSession().getAttribute(Constants.USER_SESSION);
				List<Sell> s= new ArrayList();
				try {
					s=(List<Sell>)pp.viewNote(user, "sellmessage");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.setAttribute("sellList",s);
				if(user==null)
					request.getRequestDispatcher("sell.jsp").forward(request, response);
				else {
					Integer type=user.getUtype();
					if(type==0)
						request.getRequestDispatcher("sell.jsp").forward(request, response);
					else if(type==1)
						request.getRequestDispatcher("selllist.jsp").forward(request, response);
				}
				
				for(Sell se:s) {
				      System.out.println(se);
			     }
	}

}
