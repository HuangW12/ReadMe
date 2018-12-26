package cn.proxy;

import cn.entity.Book;
import cn.entity.Buy;
import cn.entity.News;

import java.lang.reflect.Method;
import java.util.List;
import cn.entity.Report;
import cn.entity.Sell;
import cn.entity.SellComment;
import cn.entity.User;
import cn.servlet.userlist;

public class PermissionProxy implements AbstractPermission {

	private RealPermission permission = new RealPermission();
	private int type;
	@Override
	public boolean modifyUserInfo(User user) throws Exception{
		// TODO Auto-generated method stub
		boolean flag = false;
		type = user.getUtype();
		if(type==1||type==0)
			flag = permission.modifyUserInfo(user);
		else
			System.out.println("对不起，你没有该权限");
		return flag;
	}

	@Override
	public List<?> viewNote(User user,String method){
		// TODO Auto-generated method stub
		List<?> list = null;
		list = permission.viewNote(user, method);
		return list;
	}

	@Override
	public void modifyNote(User user,String f,String method,Object object1) {
		// TODO Auto-generated method stub
		type = user.getUtype();
		if(type == 0||type == 1)
			permission.modifyNote(user, f, method, object1);
		else
			System.out.println("对不起，你没有该权限");
	}

	@Override
	public boolean modifyUser(User user,String method,User u) throws Exception{
		// TODO Auto-generated method stub
		boolean flag = false;
		type = user.getUtype();
		if(type == 1)
			flag = permission.modifyUser(user, method, u);
		else
			System.out.println("对不起，你没有该权限");
		return flag;
	}

	@Override
	public boolean modifyNews(User user,String method,News news) {
		// TODO Auto-generated method stub
		boolean flag = false;
		type = user.getUtype();
		if(type == 1)
			flag = permission.modifyNews(user, method, news);
		else
			System.out.println("对不起，你没有该权限");
		return flag;
	}

	@Override
	public boolean modifyReport(User user,String method,Report report) {
		// TODO Auto-generated method stub
		boolean flag = false;
		type = user.getUtype();
		if(type == 0)
			flag = permission.modifyReport(user, method,report);
		else 
			System.out.println("对不起，你没有该权限");
		return flag;
	}

	@Override
	public boolean disposeReport(User user,Report report) {
		// TODO Auto-generated method stub
		boolean flag = false;
		type = user.getUtype();
		if(type == 1)
			flag = permission.disposeReport(user, report);
		else 
			System.out.println("对不起，你没有该权限");
		return flag;
	}

	@Override
	public void modifyComment(User user,String f,String method,Object object2) {
		// TODO Auto-generated method stub
		type = user.getUtype();
		if(type == 0||type == 1)
			permission.modifyComment(user, f, method, object2);
		else
			System.out.println("对不起，你没有该权限");		
	}

	@Override
	public List<Sell> SearchByBType(User user, String type) throws Exception {
		// TODO Auto-generated method stub
		List<Sell> sells = permission.SearchByBType(user, type);
		return sells;
	}

	@Override
	public List<Sell> SearchByBTitle(User user, String title) throws Exception {
		// TODO Auto-generated method stub
		List<Sell> sells = permission.SearchByBTitle(user, title);
		return sells;
	}

	@Override
	public List<Buy> SearchByBtIitle(User user, String title) throws Exception {
		// TODO Auto-generated method stub
		List<Buy> buy = permission.SearchByBtIitle(user, title);
		return buy;
	}

	@Override
	public void modifybook(User user, String method, Book book) {
		// TODO Auto-generated method stub
		type = user.getUtype();
		if(type==0||type==1)
			permission.modifybook(user,method, book);
		else
			System.out.println("对不起，你没有该权限");
	}

	@Override
	public List<News> viewNews(User user) {
		// TODO Auto-generated method stub
		List<News> news = permission.viewNews(user);
		return news;
	}

	@Override
	public List<User> viewUser(User user) {
		// TODO Auto-generated method stub
		type = user.getUtype();
		if(type==1)
			 return permission.viewUser(user);
		else
			return null;
	}

	@Override
	public List<Report> viewreport(User user,String method) {
		// TODO Auto-generated method stub
		type = user.getUtype();
		if(type==1)
			 return permission.viewreport(user,method);
		else
			return null;
	}

	@Override
	public List<?> viewMyNote(User user, String method) throws Exception{
		// TODO Auto-generated method stub
		type = user.getUtype();
		if(type==0)
			 return permission.viewMyNote(user, method);
		else
			return null;
	}

	@Override
	public Book getBookBybid(User user, Book book) throws Exception {
		// TODO Auto-generated method stub
		book=permission.getBookBybid(user, book);
		return book;
	}

}
