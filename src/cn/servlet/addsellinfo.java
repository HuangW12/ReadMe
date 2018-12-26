package cn.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.daoimpl.BookImpl;
import cn.daoimpl.BtypeImpl;
import cn.daoimpl.BuyCommentDaoImpl;
import cn.daoimpl.UserDaoImpl;
import cn.entity.Book;
import cn.entity.Buy;
import cn.entity.Sell;
import cn.entity.User;
import cn.proxy.PermissionProxy;
import cn.tools.Constants;

/**
 * Servlet implementation class addsellinfo
 */
@WebServlet("/addsellinfo")
public class addsellinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addsellinfo() {
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
				
				Sell s= new Sell();
				Book book = new Book();
				BookImpl bookImpl=new BookImpl();
				BtypeImpl btd = new BtypeImpl();
				Integer integer=0;
				try {
					integer = btd.getTypeID(request.getParameter("type"));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				book.setAuthor(request.getParameter("author"));
				book.setBname(request.getParameter("bname"));
				book.setBtype(integer);
				book.setPrice(Integer.parseInt(request.getParameter("price")));
				book.setUid(user.getUid());
				bookImpl.insertBook(book);
				try {
					book.setBid(bookImpl.getbookid(book));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("bid"+book.getBid());
				Timestamp d = new Timestamp(System.currentTimeMillis());
				s.setBid(book.getBid());
				s.setScontent(request.getParameter("scontent"));
				s.setSdate(d);
				s.setStitle(request.getParameter("stitle"));
				s.setUid(user.getUid());
				System.out.println(s);
				pp.modifyNote(user, "sell", "add", s);				
				
				request.getRequestDispatcher("/mysellmessage").forward(request, response);
	}

}
