/**  

* @Title: Main.java  

* @Description:   

* @author HW

* @date 2018年11月13日  

* @version 1.0  

*/  

package cn.service;
import java.util.ArrayList;

import java.util.List;
import cn.proxy.*;
import cn.dao.*;
import cn.daoimpl.*;
import cn.entity.*;

/**  

* @Title: Main  

* @Description:   

* @author Hw 

* @date 2018年11月13日  

*/

public class Main {

	/**  
	 * @Title: main 
	 * @Description:   
	 * @param args  
	 * @throws Exception 
	 */

/*	public static void main(String[] args) {
	     System.out.println(GetMessageClass.getBuyMessageFactory().getMessage());
	     System.out.println(GetMessageClass.getBuyMessageFactory().getMessage());
	     System.out.println(GetMessageClass.getSellMessageFactory().getMessage());
	}*/
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception
	{
		AbstractPermission p = new PermissionProxy();
		User user1 = new User();
		UserDao userdao = new UserDaoImpl();
		Integer uid = 2016210001;
//		user1 = userdao.getUser(uid);
		
		User user2 = new User();
		uid = 2016210002;
		user2 = userdao.getUser(uid);
		
		user2.setUname("张二");
		p.modifyUserInfo(user2);
		String title="设计模式";
		BuyMessageImpl buyMessageImpl=new BuyMessageImpl();
		List<Buy> buys=buyMessageImpl.getListByTitle(title);
		for(Buy be:buys) {
			 System.out.println(be);
	     }
		System.out.println("aaa");
		Integer type = 1;
		BookImpl bookImpl= new BookImpl();
		List<Book> books = bookImpl.getListByType(type);
		for(Book b:books)
			System.out.println(b);
		books = bookImpl.getListByTitle(title);
		for(Book b:books)
			System.out.println(b);
		Integer bid=2;
		Book book=new Book();
		book.setBid(bid);
		book=bookImpl.getbookbybid(book);
		System.out.println(book);
				
	}

}
