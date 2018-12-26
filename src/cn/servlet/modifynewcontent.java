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
 * Servlet implementation class modifynewcontent
 */
@WebServlet("/modifynewcontent")
public class modifynewcontent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifynewcontent() {
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
		
		User user = new User();
		News news = new News();
		user=(User)request.getSession().getAttribute(Constants.USER_SESSION);
		news.setUid(Integer.parseInt(request.getParameter("uid")));
		news.setNid(Integer.parseInt(request.getParameter("nid")));
		news.setNcontent(request.getParameter("ncontent"));
		news.setNtitle(request.getParameter("ntitle"));
		System.out.println(news.getUid()+"/"+news.getNcontent()+"/"+news.getNtitle());
		PermissionProxy pp=new PermissionProxy();
		pp.modifyNews(user, "modifycontent",news);
		System.out.println("modify newsc");
		request.getRequestDispatcher("/newslist").forward(request, response);
	}

}
