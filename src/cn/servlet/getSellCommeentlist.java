package cn.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.daoimpl.SellCommentDaoImpl;
import cn.entity.Sell;
import cn.entity.SellComment;
import cn.entity.User;
import cn.tools.Constants;

/**
 * Servlet implementation class getSellCommeentlist
 */
@WebServlet("/getSellCommeentlist")
public class getSellCommeentlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getSellCommeentlist() {
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
		
	    SellCommentDaoImpl sellCommentDaoImpl = new SellCommentDaoImpl();
	    Sell sell =(Sell)request.getSession().getAttribute(Constants.SELL_SESSION);
	    List<SellComment> sellComments = new ArrayList<SellComment>();
	    try {
			sellComments = sellCommentDaoImpl.getCommentList(sell.getSid());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    request.setAttribute("scommentList", sellComments);
	    request.getRequestDispatcher("sellshow.jsp").forward(request, response);
	    
	}

}
