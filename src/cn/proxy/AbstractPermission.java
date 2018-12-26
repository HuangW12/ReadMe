package cn.proxy;


import java.util.List;
import cn.entity.*;

public interface AbstractPermission {
	public boolean modifyUserInfo(User user)throws Exception;//修改用户信息（用户操作）
	public List<?> viewNote(User user,String method);//浏览
	public void modifyNote(User user,String f,String method,Object object1);//修改帖子（管理员/用户操作）
	public boolean modifyUser(User user,String method,User u)throws Exception;//修改用户(管理员操作)
	public boolean modifyNews(User user,String method,News news);//修改新闻（管理员操作）
	public boolean modifyReport(User user,String method,Report report);//发布和删除举报（用户操作）
	public boolean disposeReport(User user,Report report);//处理举报（管理员操作）
	public void modifyComment(User user,String f,String method,Object object2);//修改评论（管理员/用户操作）
	public List<Sell> SearchByBType(User user,String type)throws Exception;//根据分类搜索到出售信息
	public List<Sell> SearchByBTitle(User user,String title)throws Exception;//根据书名搜索到出售信息
	public List<Buy> SearchByBtIitle(User user,String title)throws Exception;//根据书名搜索到求购信息
	public void modifybook(User user,String method,Book book);//管理书籍信息
	public List<News> viewNews(User user);
	public List<User> viewUser(User user);
	public List<Report> viewreport(User user,String method);
	public List<?> viewMyNote(User user,String method)throws Exception;
	public Book getBookBybid(User user,Book book)throws Exception;
	
}
