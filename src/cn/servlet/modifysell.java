package cn.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.entity.Book;
import cn.entity.Sell;
import cn.entity.User;
import cn.proxy.PermissionProxy;
import cn.tools.Constants;

/**
 * Servlet implementation class modifysell
 */
@WebServlet("/modifysell")
public class modifysell extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifysell() {
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
		user=(User)request.getSession().getAttribute(Constants.USER_SESSION);
		Book book = new Book();
		book.setBid(Integer.parseInt(request.getParameter("bid")));
		book.setUid(user.getUid());
		book.setAuthor(request.getParameter("author"));
		book.setBname(request.getParameter("bname"));
		book.setPrice(Integer.parseInt(request.getParameter("price")));
		book.setBtype(Integer.parseInt(request.getParameter("btype")));
		String btype = request.getParameter("btype");
		Sell sell = new Sell();
		sell.setBid(Integer.parseInt(request.getParameter("bid")));
		sell.setScontent(request.getParameter("scontent"));
		sell.setStitle(request.getParameter("stitle"));
		sell.setUid(user.getUid());
		System.out.println(book);
		System.out.println(sell);
		pp.modifybook(user,"modifyprice", book);
		pp.modifybook(user,"modifytype", book);
		pp.modifyNote(user,"sell","modify", sell);
		request.getRequestDispatcher("/mysellmessage").forward(request, response);
		      System.out.println("modify sell");

	}

}
