package cn.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.daoimpl.UserDaoImpl;
import cn.entity.Report;
import cn.entity.User;
import cn.proxy.PermissionProxy;
import cn.tools.Constants;

/**
 * Servlet implementation class modifyreport
 */
@WebServlet("/modifyreport")
public class modifyreport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifyreport() {
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
		Report report = new Report();
		user=(User)request.getSession().getAttribute(Constants.USER_SESSION);
		report.setBid(Integer.parseInt(request.getParameter("bid")));
		report.setRcomment(request.getParameter("rcomment"));
		report.setAid(Integer.parseInt(request.getParameter("aid")));
		report.setRstate(Integer.parseInt(request.getParameter("rstate")));
		PermissionProxy pp=new PermissionProxy();
		pp.disposeReport(user, report);
		System.out.println(request.getParameter("bid"));
		System.out.println("dispose report");
		request.getRequestDispatcher("/reportlist").forward(request, response);
	}

}
