package cn.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.entity.News;
import cn.entity.User;
import cn.proxy.PermissionProxy;
import cn.tools.Constants;

/**
 * Servlet implementation class delnews
 */
@WebServlet("/delnews")
public class delnews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delnews() {
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
		User user = new User();
		News news =  new News(); 
		user=(User)request.getSession().getAttribute(Constants.USER_SESSION);
		String _nid=request.getParameter("nid");
		String _uid=request.getParameter("uid");
		System.out.println(_uid+_nid);
		news.setNid(Integer.parseInt(_nid));
		news.setUid(Integer.parseInt(_uid));
		news.setNcontent(request.getParameter("ncontent"));
		news.setNtitle(request.getParameter("ntitle"));
		PermissionProxy pp=new PermissionProxy();
		pp.modifyNews(user, "delete",news);
		System.out.println("delete news");
		request.getRequestDispatcher("/newslist").forward(request, response);
	}

}
