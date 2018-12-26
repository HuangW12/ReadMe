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
import cn.entity.User;
import cn.proxy.PermissionProxy;

/**
 * Servlet implementation class SearchBuybyBtitle
 */
@WebServlet("/SearchBuybyBtitle")
public class SearchBuybyBtitle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchBuybyBtitle() {
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
		List<Buy> b =new ArrayList<Buy>();
		String btitle = request.getParameter("btitle");
		try {
			b=pp.SearchByBtIitle(user, btitle);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("buyList",b);
		for(Buy be:b) {
			 System.out.println(be);
	     }
		request.getRequestDispatcher("buy.jsp").forward(request, response);
		
	}

}
