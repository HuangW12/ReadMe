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
 * Servlet implementation class modifybuyinfo
 */
@WebServlet("/modifybuyinfo")
public class modifybuyinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifybuyinfo() {
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
				
				Buy b= new Buy();
				b.setBcontent(request.getParameter("bbcontent"));
				b.setUid(user.getUid());
				b.setBtitle(request.getParameter("btitle"));
				System.out.println(b);
				pp.modifyNote(user, "buy", "modify", b);
				request.getRequestDispatcher("/mybuymessage").forward(request, response);
	}

}
