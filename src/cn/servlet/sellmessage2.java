package cn.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.daoimpl.BtypeImpl;
import cn.entity.Book;
import cn.entity.Btype;
import cn.entity.News;
import cn.entity.Sell;
import cn.entity.User;
import cn.proxy.PermissionProxy;
import cn.tools.Constants;
import cn.tools.PageSupport;

/**
 * Servlet implementation class sellmessage
 */
@WebServlet("/sellmessage2")
public class sellmessage2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sellmessage2() {
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
		BtypeImpl btypeImpl = new BtypeImpl();
		user=(User)request.getSession().getAttribute(Constants.USER_SESSION);
		Book book= new Book();
		book.setBid(Integer.parseInt(request.getParameter("bid")));
		PermissionProxy pp= new PermissionProxy();
		System.out.println(book.getBid());
		try {
			book = pp.getBookBybid(user, book);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String type=null;
		try {
			type = btypeImpl.getTypeBytid(book.getBtype());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Sell sell = new Sell();
		sell.setBid(Integer.parseInt(request.getParameter("bid")));
		sell.setScontent(request.getParameter("scontent"));
		sell.setSdate(Timestamp.valueOf(request.getParameter("sdate")));
		sell.setSid(Integer.parseInt(request.getParameter("sid")));
		sell.setStitle(request.getParameter("stitle"));
		sell.setUid(Integer.parseInt(request.getParameter("uid")));
		
		request.getSession().setAttribute(Constants.SELL_SESSION_2,sell);
		request.getSession().setAttribute(Constants.BOOK_SESSION_2,book);
		request.getSession().setAttribute(Constants.BTYPE_SESSION_2,type);
		
		request.getRequestDispatcher("modifysell.jsp").forward(request, response);
		System.out.println(book);
	}

}

