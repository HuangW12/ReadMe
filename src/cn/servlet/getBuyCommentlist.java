package cn.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.daoimpl.BuyCommentDaoImpl;
import cn.entity.Buy;
import cn.entity.BuyComment;
import cn.tools.Constants;

/**
 * Servlet implementation class getBuyCommentlist
 */
@WebServlet("/getBuyCommentlist")
public class getBuyCommentlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getBuyCommentlist() {
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
		
		BuyCommentDaoImpl buyCommentDaoImpl = new BuyCommentDaoImpl();
		List<BuyComment> buyComments=new ArrayList<BuyComment>();
		Buy buy= new Buy();
		buy.setBcontent(request.getParameter("bcontent"));
		buy.setBdate(Timestamp.valueOf(request.getParameter("bdate")));
		buy.setBtitle(request.getParameter("btitle"));
		buy.setBuyid(Integer.parseInt(request.getParameter("buyid")));
		buy.setUid(Integer.parseInt(request.getParameter("uid")));
		System.out.println(buy.getUid());
		try {
			buyComments=buyCommentDaoImpl.getCommentList(buy.getBuyid());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getSession().setAttribute(Constants.BUY_SESSION,buy);
		request.setAttribute("bcommentList", buyComments);
		System.out.println("1111");
		request.getRequestDispatcher("buyshow.jsp").forward(request, response);
	}

}
