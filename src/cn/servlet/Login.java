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
import cn.entity.News;
import cn.entity.Sell;
import cn.entity.User;
import cn.proxy.PermissionProxy;
import cn.proxy.RealPermission;
import cn.tools.Constants;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Login() {
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
				UserDaoImpl userdao = new UserDaoImpl();
				User user = new User();
				PermissionProxy pp= new PermissionProxy();
				boolean flag = false;
				try {
					user= userdao.getUser(_id);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(user.getUpass().equals(_password))
					flag=true;
				Integer type;
				type=user.getUtype();
				request.getSession().setAttribute("uuid", user.getUid());
				if(flag) {
					if(type==1) {
						List<News> newsList =new ArrayList<>();
						newsList=pp.viewNews(user);
						request.setAttribute("newsList", newsList);
						request.getSession().setAttribute(Constants.USER_SESSION,user);
						
						request.getRequestDispatcher("administratorspace.jsp").forward(request, response);
						 for(News se:newsList) {
						      System.out.println(se);
					     }
					}
					else {
						RealPermission re = new RealPermission();
					    List<Sell> s= new ArrayList();
					    s=(List<Sell>)re.viewNote(user, "sellmessage");
				
					    request.setAttribute("sellList", s);
					    request.getSession().setAttribute(Constants.USER_SESSION,user);
					    request.getRequestDispatcher("/index").forward(request, response);
					    for(Sell se:s) {
						      System.out.println(se);
					     }
				    }
				}
				else {
					request.getRequestDispatcher("login.html").forward(request, response);
				}
			}

	
}
