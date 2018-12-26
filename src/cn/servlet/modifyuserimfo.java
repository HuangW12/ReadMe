package cn.servlet;

import java.io.IOException;
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
 * Servlet implementation class modifyuserimfo
 */
@WebServlet("/modifyuserimfo")
public class modifyuserimfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifyuserimfo() {
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
		Integer _userid=Integer.parseInt(request.getParameter("userid"));
		String password = request.getParameter("upass");
        Integer utype = Integer.parseInt(request.getParameter("utype"));
		Integer uclass = Integer.parseInt(request.getParameter("uclass"));
		Integer ustate = Integer.parseInt(request.getParameter("ustate"));
		System.out.println(request.getParameter("uid"));
		User user = new User();
		User user2 = new User();
		System.out.println(_userid+"  pass"+password+"  type"+utype+" class"+uclass+" state"+ustate);
		user2.setUclass(uclass);
		user2.setUid(_userid);
		user2.setUpass(password);
		user2.setUtype(utype);
		user2.setUstate(ustate);
		user=(User)request.getSession().getAttribute(Constants.USER_SESSION);
		PermissionProxy pp=new PermissionProxy();
		
		try {
			pp.modifyUser(user, "type", user2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pp.modifyUser(user, "password", user2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pp.modifyUser(user, "state", user2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pp.modifyUser(user, "class", user2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("modify user");
		request.getRequestDispatcher("/userlist").forward(request, response);
		
	}

}
