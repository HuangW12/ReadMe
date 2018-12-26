/**  

* @Title: Message.java  

* @Description:   

* @author 黄文 

* @date 2018年11月13日  

* @version 1.0  

*/  

package cn.dao;

import java.util.List;

import cn.entity.Book;
import cn.entity.Buy;
import cn.entity.Sell;


/**  

* @Title: Message  

* @Description: 对出售/求购信息的查询，更新，删除 ，插入

* @author Hw

* @date 2018年11月13日  

*/

public interface MessageDao {
	
	/**
	 * 
	 * @Title: getAll 
	 * @Description:  该方法获取数据库的buy和sell表的所有信息 
	 * @return 把数据存入List链表中进行返回
	 */
	public List<?> getAll();
	
	/**
	 * 
	 * @Title: deleteMessage 
	 * @Description: 根据id 和 内容来进行删除  
	 * @param id
	 * @param str
	 * @return 受影响的行数
	 */
	public int deleteMessage(Integer id , String str);
	
	/**
	 * 
	 * @Title: updateMessage 
	 * @Description: 根据id 和内容来进行更新  
	 * @param id 学号
	 * @param title 标题
	 * @param scontent 跟新的内容
	 * @return 受影响的行数
	 */
	public int updateMessage(Integer id , String title , String scontent);
	
	public int insertMessage(Object object);
	public List<?> getListByID(Integer uid) throws Exception;//通过用户id查找信息
	public List<Sell> getListByBook(List<Book> bookList) throws Exception;
	public List<Buy> getListByTitle(String btitle) throws Exception;

}
