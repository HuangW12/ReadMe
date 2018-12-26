package cn.proxy;

import cn.entity.*;

import java.util.List;
import cn.dao.*;
import cn.service.*;
import cn.daoimpl.*;

public class RealPermission implements AbstractPermission {

	private UserDao userDao;
	private NewDao nsi;
	private ReportDao rsi;
	private CommentDao bcsi;
	private CommentDao scsi;
	private BtypeDao bt;
	private BookDao b;
	
	public RealPermission(){
		userDao = new UserDaoImpl();
	    nsi = new NewDaoImpl();
	    rsi = new ReportDaoImpl();
	    bcsi = new BuyCommentDaoImpl();
	    scsi = new SellCommentDaoImpl();
	    bt = new BtypeImpl();
	    b = new BookImpl();
	}
	
	@Override
	public boolean modifyUserInfo(User user) {
		// TODO Auto-generated method stub
		boolean flag = false;
		flag = userDao.updateUser(user);
		return flag;
	}

	@Override
	public List<?> viewNote(User user,String method) {
		// TODO Auto-generated method stub
	    if(method == "buymessage") {
			return (List<Buy>) GetMessageClass.getBuyMessageFactory().getMessage().getAll();
		}
		else if(method == "sellmessage") {
			return (List<Sell>) GetMessageClass.getSellMessageFactory().getMessage().getAll();
		}
		else
			return null;
		//浏览信息
	}

	@Override
	public void modifyNote(User user,String f,String method,Object object1) {
		// TODO Auto-generated method stub
		Integer uid = user.getUid();
		ForumAccount acc = new ForumAccount(user);
		if(f =="buy")
		{
			if(method == "add") {
				GetMessageClass.getBuyMessageFactory().getMessage().insertMessage(object1);
				acc.writeBuyNote(20);
			}
			else if(method == "delete") {
				if(user.getUtype()==0)
					GetMessageClass.getBuyMessageFactory().getMessage().deleteMessage(uid, ((Buy)object1).getBtitle());
				else if(user.getUtype()==1)
					GetMessageClass.getBuyMessageFactory().getMessage().deleteMessage(((Buy)object1).getUid(),((Buy)object1).getBtitle());	
			}
			else if(method == "modify")
				GetMessageClass.getBuyMessageFactory().getMessage().updateMessage(uid, ((Buy)object1).getBtitle(), ((Buy)object1).getBcontent());
			else
				System.out.println("操作无效");
		}
		
		else if(f =="sell")
		{
			if(method == "add") {
				GetMessageClass.getSellMessageFactory().getMessage().insertMessage(object1);
				acc.writeSellNote(30);
			}
			else if(method == "delete") {
				if(user.getUtype()==0)
				    GetMessageClass.getSellMessageFactory().getMessage().deleteMessage(uid, ((Sell)object1).getStitle());
				else if(user.getUtype()==1)
					GetMessageClass.getSellMessageFactory().getMessage().deleteMessage(((Sell)object1).getUid(), ((Sell)object1).getStitle());
			}
			else if(method =="modify")
				GetMessageClass.getSellMessageFactory().getMessage().updateMessage(uid, ((Sell)object1).getStitle(), ((Sell)object1).getScontent());
			else
				System.out.println("操作无效");
		}
		//更改信息
	}


	@Override
	public boolean modifyUser(User user,String method,User u) throws Exception
	{
		// TODO Auto-generated method stub
		boolean flag = false;
		if(method=="type")
			flag = userDao.modifyType(u);
		else if(method=="password")
			flag = userDao.modifyUserPassword(u);
		else if(method=="state")
			flag = userDao.modifyUserState(u);
		else if(method=="class")
			flag = userDao.modifyUserClass(u);
		else
			System.out.println("该操作无效");
		return flag;
	}

	@Override
	public boolean modifyNews(User user,String method,News news) {
		// TODO Auto-generated method stub
		boolean flag = false;
		if(method=="add") {
			if(nsi.insertNew(news)>0)
				flag = true;
		}
		else if(method=="delete") {
			if(nsi.deleteNew(news)>0)
				flag = true;
		}
		else if(method=="modifycontent") {
			if(nsi.updateNewContent(news)>0)
				flag = true;
		}
		else if(method == "modifytitle") {
			if(nsi.updateNewTitle(news)>0)
				flag = true;
		}		
		else 
			System.out.println("该操作无效");
		return flag;
		
	}

	@Override
	public boolean modifyReport(User user,String method,Report report) {
		// TODO Auto-generated method stub
		boolean flag = false;
		Integer aid = report.getAid();
		Integer bid = report.getBid();
		String rcomment = report.getRcomment();
		if(method=="add") {
			if(rsi.insertReport(aid, bid, rcomment)>0)
				flag = true;
		}
		else if(method=="delete") {
		    if(rsi.deleteReport(aid, bid, rcomment)>0)
		    	flag = true;
		}
		else 
			System.out.println("该操作无效");
		return flag;
	}

	@Override
	public boolean disposeReport(User user,Report report) {
		// TODO Auto-generated method stub
		boolean flag = false;
		if(rsi.updateReport(report)>0)
			flag = true;
		return flag;
	}

	@Override
	public void modifyComment(User user,String f,String method,Object object2) {
		// TODO Auto-generated method stub
		Integer uid = user.getUid();
		System.out.println(object2);
		ForumAccount acc = new ForumAccount(user);
		if(f == "buycomment")
		{
			if(method == "add") {
				bcsi.insertComment(object2);
				acc.comment(10);
			}
			else if(method == "delete") {
				if(user.getUtype()==0)
					bcsi.deleteComment(uid,((BuyComment)object2).getBc_comment());
				else if(user.getUtype()==1)
					bcsi.deleteComment(((BuyComment)object2).getUid(), ((BuyComment)object2).getBc_comment());
			}
			else if(method == "modify")
				bcsi.updateComment(uid, ((BuyComment)object2).getBuyid(), ((BuyComment)object2).getBc_comment());
			
		}
		else if(f =="sellcomment")
		{
			if(method =="add") {
				scsi.insertComment(object2);
				acc.comment(10);
			}
			else if(method == "delete") {
				if(user.getUtype()==0)
				    scsi.deleteComment(uid, ((SellComment)object2).getSc_content());
				else if(user.getUtype()==1)
					scsi.deleteComment(((SellComment)object2).getUid(), ((SellComment)object2).getSc_content());
			}
			else if(method == "modify")
				scsi.updateComment(uid, ((SellComment)object2).getSid(), ((SellComment)object2).getSc_content());
		}
	}

	@Override
	public List<Sell> SearchByBType(User user, String type) throws Exception {
		// TODO Auto-generated method stub
		Integer i = null;
		i = bt.getTypeID(type);
		List<Book> books = b.getListByType(i);
		List<Sell> sells = GetMessageClass.getSellMessageFactory().getMessage().getListByBook(books);
		return sells;
	}

	@Override
	public List<Sell> SearchByBTitle(User user, String title) throws Exception{
		// TODO Auto-generated method stub
		List<Book> books = b.getListByTitle(title);
		List<Sell> sells = GetMessageClass.getSellMessageFactory().getMessage().getListByBook(books);
		return sells;
	}

	@Override
	public List<Buy> SearchByBtIitle(User user, String title) throws Exception{
		// TODO Auto-generated method stub
		List<Buy> buy = GetMessageClass.getBuyMessageFactory().getMessage().getListByTitle(title);
		return buy;
	}

	@Override
	public void modifybook(User user, String method, Book book) {
		// TODO Auto-generated method stub
		Integer uid=user.getUid();
		Integer type = user.getUtype();
		if(method == "add") {
			b.insertBook(book);		
		}
		else if(method == "delete") {
			if(type==0) {
			   b.deleteBook(uid, book.getAuthor(), book.getBname());}
			else if (type==1){
				b.deleteBook(book.getUid(), book.getAuthor(), book.getBname());
			}
		}
		else if(method =="modifyprice") {
			b.updateBookPrice(uid, book.getAuthor(), book.getBname(), book.getPrice());
			System.out.println(book.getAuthor()+book.getBname()+book.getPrice());
		}
		else if(method =="modifytype")
			b.updateBookType(uid, book.getAuthor(), book.getBname(), book.getBtype());
		else
			System.out.println("操作无效");
	}

	@Override
	public List<News> viewNews(User user) {
		// TODO Auto-generated method stub
		return nsi.getAll();
	}

	@Override
	public List<User> viewUser(User user) {
		// TODO Auto-generated method stub
		return userDao.getAll();
	}

	@Override
	public List<Report> viewreport(User user,String method) {
		// TODO Auto-generated method stub
		if(method=="n")
			try {
				return rsi.getNList();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else if(method=="f")
			try {
				return rsi.getFList();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return null;
	}

	@Override
	public List<?> viewMyNote(User user, String method) throws Exception{
		// TODO Auto-generated method stub
		if(method=="buymessage") {
			try {
				return (List<Buy>) GetMessageClass.getBuyMessageFactory().getMessage().getListByID(user.getUid());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(method == "sellmessage") {
			try {
				return (List<Sell>) GetMessageClass.getSellMessageFactory().getMessage().getListByID(user.getUid());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Book getBookBybid(User user, Book book) throws Exception {
		// TODO Auto-generated method stub
		book=b.getbookbybid(book);
		return book;
	}

}
