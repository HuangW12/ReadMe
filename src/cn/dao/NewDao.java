/**  

* @Title: NewDao.java  

* @Description:   

* @author HW

* @date 2018年11月15日  

* @version 1.0  

*/  

package cn.dao;

import java.util.List;

import org.apache.tomcat.util.descriptor.web.NamingResources;

import cn.entity.News;

/**  

* @Title: NewDao  

* @Description:  对new表的增删改查  

* @author Hw 

* @date 2018年11月15日  

*/

public interface NewDao {
	
	/**
	 * 
	 * @Title: getAll 
	 * @Description: 获取new表中所有的数据  
	 * @return list
	 */
	public List<News> getAll();
	/**
	 * 
	 * @Title: insertNew 
	 * @Description:  对new表的插入需要用户ID 新闻标题 新闻内容 
	 * @param uid 用户ID
	 * @param ntitle 新闻标题
	 * @param ncontent  新闻内容
	 * @return 受影响的行数
	 */
	public int insertNew(News news);
	/**
	 * 
	 * @Title: deleteNew 
	 * @Description:  删除时用户ID和新闻内容即可 
	 * @param uid 用户ID
	 * @param ncontent 新闻内容
	 * @return 受影响的行数
	 */
	public int deleteNew(News news);
	/**
	 * 
	 * @Title: updateNewTitle 
	 * @Description: 更新新闻标题  
	 * @param uid 用户ID
	 * @param ncontent 新闻内容
	 * @return 受影响的行数
	 */
	public int updateNewTitle(News news);
	/**
	 * 
	 * @Title: updateNewContent 
	 * @Description:更新  新闻内容 
	 * @param uid 用户ID
	 * @param ntitle 新闻标题 
	 * @return 受影响的行数
	 */
	public int updateNewContent(News news);


}
