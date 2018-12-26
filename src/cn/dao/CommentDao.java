/**  

* @Title: Comment.java  

* @Description:   

* @author HW

* @date 2018年11月15日  

* @version 1.0  

*/  

package cn.dao;

import java.util.List;

/**  

* @Title: CommentDao  

* @Description: 对求购/出售信息评论的增删改查  

* @author Hw 

* @date 2018年11月15日  

*/

public interface CommentDao {
	
	/**
	 * 
	 * @Title: getAll 
	 * @Description: 获取求购/出售信息评论的表中所有信息  
	 * @return list
	 */
	public List<?> getAll();
	/**
	 * 
	 * @Title: insertComment 
	 * @Description:   对求购/出售信息评论表的插入
	 * @param object 求购/出售信息评论对象
	 * @return 受影响的行数
	 */
	public int insertComment(Object object);
	/**
	 * 
	 * @Title: deleteComment 
	 * @Description: 对求购/出售信息评论表的删除  
	 * @param uid 用户id
	 * @param bc_comment 评论的内容
	 * @return 受影响的行数
	 */
	public int deleteComment(Integer uid,String comment);
	/**
	 * 
	 * @Title: updateComment 
	 * @Description:  对求购/出售信息评论表的更新 
	 * @param uid 用户id
	 * @param id 求购/出售信息的id
	 * @return 受影响的行数
	 */
	public int updateComment(Integer uid,Integer id,String comment);
	public List<?> getCommentListByID(Integer uid)throws Exception;
	public List<?> getCommentList(Integer id)throws Exception;

}
