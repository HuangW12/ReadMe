package cn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.entity.News;
import cn.entity.Report;
import cn.entity.User;
import cn.proxy.PermissionProxy;
import cn.tools.Constants;

/**
 * Servlet implementation class reportlist
 */
@WebServlet("/reportlist")
public class reportlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reportlist() {
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
		
		User user = new User();
		user=(User)request.getSession().getAttribute(Constants.USER_SESSION);
		
		PermissionProxy pp=new PermissionProxy();
		List<Report> reports1 = pp.viewreport(user,"n");
		List<Report> reports2 = pp.viewreport(user, "f");
		for(Report r:reports1)
		{
			System.out.println(r);
		}
		request.setAttribute("reportList1",reports1);
		request.setAttribute("reportList2",reports2);
		request.getRequestDispatcher("reportlist.jsp").forward(request, response);
	}

}
