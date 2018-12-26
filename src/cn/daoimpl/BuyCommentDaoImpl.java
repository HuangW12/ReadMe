/**  

* @Title: BuyCommentDaoImpl.java  

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
import cn.entity.BuyComment;
import cn.util.JdbcUtils;

/**  

* @Title: BuyCommentDaoImpl  

* @Description:   

* @author Hw 

* @date 2018年11月15日  

*/

public class BuyCommentDaoImpl implements CommentDao {

	/** (non-Javadoc)  
	 * Title: getAll
	 * Description:   
	 * @return  
	 * @see cn.dao.CommentDao#getAll()  
	 */

	@SuppressWarnings("unchecked")
	@Override
	public List<BuyComment> getAll() {
		String sql = "select * from bcomment";
		return JdbcUtils.getList(BuyComment.class, sql);
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
		String sql = "insert into bcomment(uid,buyid,bctime,bc_comment) values(?,?,?,?)";
		return JdbcUtils.executeSQL(sql, ((BuyComment) object).getUid(),((BuyComment) object).getBuyid(),((BuyComment) object).getBctime(),((BuyComment) object).getBc_comment());
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
		String sql = "delete from bcomment where uid = ? and bc_comment = ?";
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
		String sql = "update bcomment set bc_comment = ? where uid = ? and buyid = ? ";
		return JdbcUtils.executeSQL(sql, comment,uid,id);
	}

	@Override
	public List<BuyComment> getCommentListByID(Integer uid) throws Exception{
		// TODO Auto-generated method stub
	    ResultSet resultSet = null;
	    List<BuyComment> BCList =new ArrayList<BuyComment>();
		String sql = "select * from bcomment where uid = ?";
		Object[] params = {uid};
		resultSet = JdbcUtils.execute(sql, params);
		while(resultSet.next()){
		        BuyComment bc = new BuyComment();
		        bc.setBc_comment(resultSet.getString("bc_comment"));
		        bc.setBcid(resultSet.getInt("bcid"));
		        bc.setBctime(resultSet.getTimestamp("bctime"));
		        bc.setBuyid(resultSet.getInt("buyid"));
		        bc.setUid(resultSet.getInt("uid"));
				
				BCList.add(bc);
			}
		return BCList;
	}

	/*通过求购信息编号获得它的评论*/
	@Override
	public List<BuyComment> getCommentList(Integer buyid) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(buyid);
		ResultSet resultSet = null;
	    List<BuyComment> BCList =new ArrayList<BuyComment>();
		String sql = "select * from bcomment where buyid = ?";
		Object[] params = {buyid};
		resultSet = JdbcUtils.execute(sql, params);
		while(resultSet.next()){
		        BuyComment bc = new BuyComment();
		        bc.setBc_comment(resultSet.getString("bc_comment"));
		        bc.setBcid(resultSet.getInt("bcid"));
		        bc.setBctime(resultSet.getTimestamp("bctime"));
		        bc.setBuyid(resultSet.getInt("buyid"));
		        bc.setUid(resultSet.getInt("uid"));
				
				BCList.add(bc);
				System.out.println(bc);
			}
		return BCList;
	}

}
