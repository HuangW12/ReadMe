package cn.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.daoimpl.BookImpl;
import cn.daoimpl.UserDaoImpl;
import cn.entity.Book;
import cn.entity.Sell;
import cn.entity.User;
import cn.proxy.PermissionProxy;
import cn.tools.Constants;
import cn.tools.PageSupport;

/**
 * Servlet implementation class delsellmessage
 */
@WebServlet("/delsellmessage")
public class delsellmessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delsellmessage() {
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
		User user=new User();
		user=(User)request.getSession().getAttribute(Constants.USER_SESSION);
		Book book = new Book();
		book.setUid(Integer.parseInt(request.getParameter("userid")));
		book.setBid(Integer.parseInt(request.getParameter("bid")));
		System.out.println(book.getBid());
		System.out.println(book.getUid());
		BookImpl bookImpl = new BookImpl();
		try {
			book=bookImpl.getbookbybid(book);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(book);
		PermissionProxy pp= new PermissionProxy();
		pp.modifybook(user, "delete", book);
		if(user.getUtype()==1)
		    request.getRequestDispatcher("/viewSellMessage").forward(request, response);
		else if(user.getUtype()==0)
			request.getRequestDispatcher("/mysellmessage").forward(request, response);
		      System.out.println("delete sell");
	}

}
