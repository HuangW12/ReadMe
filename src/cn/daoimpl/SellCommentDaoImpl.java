/**  

* @Title: SellCommentDaoImpl.java  

* @Description:   

* @author HW

* @date 2018年11月15日  

* @version 1.0  

*/  

package cn.daoimpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.dao.CommentDao;
import cn.entity.SellComment;
import cn.util.JdbcUtils;

/**  

* @Title: SellCommentDaoImpl  

* @Description:   

* @author Hw 

* @date 2018年11月15日  

*/

public class SellCommentDaoImpl implements CommentDao {

	/** (non-Javadoc)  
	 * Title: getAll
	 * Description:   
	 * @return  
	 * @see cn.dao.CommentDao#getAll()  
	 */

	@SuppressWarnings("unchecked")
	@Override
	public List<SellComment> getAll() {
		String sql = "select * from scomment";
		return JdbcUtils.getList(SellComment.class, sql);
	}

	/** (non-Javadoc)  
	 * Title: insertComment
	 * Description:   
	 * @param object
	 * @return  
	 * @see cn.dao.CommentDao#insertComment(java.lang.Object)  
	 */

	@Override
	public int insertComment(Object object) {
		String sql = "insert into scomment(uid,sid,sctime,sc_content) values(?,?,?,?)";
		System.out.println((SellComment)object);
		return JdbcUtils.executeSQL(sql, ((SellComment) object).getUid(),((SellComment) object).getSid(),((SellComment) object).getSctime(),((SellComment) object).getSc_content());
	}

	/** (non-Javadoc)  
	 * Title: deleteComment
	 * Description:   
	 * @param uid
	 * @param bc_comment
	 * @return  
	 * @see cn.dao.CommentDao#deleteComment(java.lang.Integer, java.lang.String)  
	 */

	@Override
	public int deleteComment(Integer uid, String comment) {
		String sql = "delete from scomment where uid = ? and sc_content = ?";
		return JdbcUtils.executeSQL(sql, uid,comment);
	}

	/** (non-Javadoc)  
	 * Title: updateComment
	 * Description:   
	 * @param uid
	 * @param id
	 * @return  
	 * @see cn.dao.CommentDao#updateComment(java.lang.Integer, java.lang.Integer)  
	 */

	@Override
	public int updateComment(Integer uid, Integer id,String comment) {
		String sql = "update scomment set sc_content = ? where uid = ? and sid = ?";
		return JdbcUtils.executeSQL(sql, comment,uid,id);
	}

	public List<SellComment> getCommentListByID(Integer uid) throws Exception {
		// TODO Auto-generated method stub
		ResultSet resultSet = null;
	    List<SellComment> SCList =new ArrayList<SellComment>();
	    Object[] params = {uid};
		String sql = "select * from scomment  where uid = ?";
		resultSet = JdbcUtils.execute(sql, params);
		while(resultSet.next()){
	        SellComment sc = new SellComment();
	        sc.setSc_content(resultSet.getString("sc_content"));
	        sc.setScid(resultSet.getInt("scid"));
	        sc.setSctime(resultSet.getTimestamp("sctime"));
	        sc.setSid(resultSet.getInt("sid"));
	        sc.setUid(resultSet.getInt("uid"));
			
			SCList.add(sc);
		}
		return SCList;
	}

	/*通过出售信息编号获得它的评论*/
	@Override
	public List<SellComment> getCommentList(Integer id) throws Exception {
		// TODO Auto-generated method stub
		ResultSet resultSet = null;
	    List<SellComment> SCList =new ArrayList<SellComment>();
	    Object[] params = {id};
		String sql = "select * from scomment  where sid = ?";
		resultSet = JdbcUtils.execute(sql, params);
		while(resultSet.next()){
	        SellComment sc = new SellComment();
	        sc.setSc_content(resultSet.getString("sc_content"));
	        sc.setScid(resultSet.getInt("scid"));
	        sc.setSctime(resultSet.getTimestamp("sctime"));
	        sc.setSid(resultSet.getInt("sid"));
	        sc.setUid(resultSet.getInt("uid"));
			
			SCList.add(sc);
		}
		return SCList;
	}
	
}
