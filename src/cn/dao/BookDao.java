/**  

* @Title: BookDao.java  

* @Description:   

* @author HW

* @date 2018年11月15日  

* @version 1.0  

*/  

package cn.dao;

import java.sql.SQLException;
import java.util.List;

import cn.entity.Book;

/**  

* @Title: BookDao  

* @Description:  对书籍的插入，查询，更新，删除 

* @author Hw 

* @date 2018年11月15日  

*/

public interface BookDao {
	/**
	 * 
	 * @Title: getAll 
	 * @Description:获取book数据库表中的所有数据 
	 * @return list
	 */
	public List<Book> getAll();
	/**
	 * 
	 * @Title: updateBook 
	 * @Description: 要输入用户id 作者 书名  更新书籍类型
	 * @param ID 用户ID
	 * @param author 作者
	 * @param name 书名
	 * @param object  书籍类型
	 * @return 受影响的行数
	 */
	public int updateBookType(Integer ID , String author, String name,Integer type);
	/**
	 * 
	 * @Title: updateBookPrice 
	 * @Description:要输入用户id 作者 书名 更新价格   
	 * @param ID 用户ID
	 * @param author 作者
	 * @param name 书名
	 * @param object 更新价格
	 * @return 受影响的行数
	 */
	public int updateBookPrice(Integer ID , String author, String name,float price);
	/**
	 * 
	 * @Title: deleteBook 
	 * @Description: 删除某一行根据用户id 作者 书名  
	 * @param ID
	 * @param author
	 * @param name
	 * @return 受影响行数
	 */
	public int deleteBook(Integer ID , String author, String name);
	/**
	 * 
	 * @Title: insertBook 
	 * @Description: book的值只需要用户id 作者 书籍名称 书籍类型 价格 内容  
	 * @param book
	 * @return 受影响行数
	 */
	public int insertBook(Book book);
	public Integer getbookid(Book book)throws Exception;
	public List<Book> getListByTitle(String name) throws Exception;//通过书籍名查询书籍列表
	public List<Book> getListByType(Integer type)throws Exception;//通过类型查询书籍列表
	public Book getbookbybid(Book book) throws Exception;
}
