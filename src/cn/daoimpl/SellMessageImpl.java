/**  

* @Title: SellMessageImpl.java  

* @Description:   

* @author 黄文 

* @date 2018年11月13日  

* @version 1.0  

*/  

package cn.daoimpl;

import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import cn.dao.MessageDao;
import cn.entity.Book;
import cn.entity.Buy;
import cn.entity.Sell;
import cn.util.JdbcUtils;

/**  

* @Title: SellMessageImpl  

* @Description:   对出售信息的查询，更新，删除操作

* @author Hw

* @date 2018年11月13日  

*/

public class SellMessageImpl implements MessageDao {

	/** (non-Javadoc)  
	 * <p>Title: getAll</p> 
	 * <p>Description: </P>  
	 * @return  
	 * @see cn.dao.MessageDao#getAll()  
	 */

	@SuppressWarnings("unchecked")
	@Override
	public List<Sell> getAll() {
		String sql = "select * from sell";
		return JdbcUtils.getList(Sell.class, sql);
	}

	/** (non-Javadoc)  
	 * <p>Title: deleteMessage</p> 
	 * <p>Description: </P>  
	 * @param id
	 * @param str
	 * @return  
	 * @see cn.dao.MessageDao#deleteMessage(java.lang.Integer, java.lang.String)  
	 */

	@Override
	public int deleteMessage(Integer id, String str) {
		String sql = "delete from sell where uid = ? and scontent = ?";
		return JdbcUtils.executeSQL(sql, id,str);
	}

	/** (non-Javadoc)  
	 * <p>Title: updateMessage</p> 
	 * <p>Description: </P>  
	 * @param id
	 * @param title
	 * @param scontent
	 * @return  
	 * @see cn.dao.MessageDao#updateMessage(java.lang.Integer, java.lang.String, java.lang.String)  
	 */

	@Override
	public int updateMessage(Integer id, String title, String scontent) {
		String sql = "update sell set scontent = ? where uid = ? and stitle = ? ";
		System.out.println(scontent+title+id);
		return JdbcUtils.executeSQL(sql, scontent,id,title);
	}

	/** (non-Javadoc)  
	 * Title: insertMessage
	 * Description:   
	 * @param object
	 * @return  
	 * @see cn.dao.MessageDao#insertMessage(java.lang.Object)  
	 */
	
	@Override
	public int insertMessage(Object object) {
		String sql = "insert into sell(uid,bid,stitle,scontent,sdate) values(?,?,?,?,?)";
		return JdbcUtils.executeSQL(sql, ((Sell) object).getUid(),((Sell) object).getBid(),((Sell) object).getStitle(),((Sell) object).getScontent(),((Sell) object).getSdate());
	}

	@Override
	public List<Sell> getListByID(Integer uid) throws Exception {
		// TODO Auto-generated method stub
		ResultSet resultSet = null;
		List<Sell> SList =new ArrayList<Sell>();
		String sql = "select * from sell where uid = ?";
		Object[] params = {uid};
		resultSet = JdbcUtils.execute(sql, params);
		while(resultSet.next()){
			Sell sell = new Sell();
			sell.setBid(resultSet.getInt("bid"));
			sell.setScontent(resultSet.getString("scontent"));
			sell.setSdate(resultSet.getTimestamp("sdate"));
			sell.setSid(resultSet.getInt("sid"));
			sell.setStitle(resultSet.getString("stitle"));
			sell.setUid(resultSet.getInt("uid"));
						
			SList.add(sell);
					}
			return SList;
	}
	
	/*通过书籍查找到出售信息*/
	public List<Sell> getListByBook(List<Book> bookList) throws Exception
	{
		ResultSet resultSet = null;
		List<Sell> SList =new ArrayList<Sell>();
		String sql = "select * from sell where bid = ?";
		for(int i=0;i<bookList.size();i++) {
			Object[] params = {bookList.get(i).getBid()};
			resultSet = JdbcUtils.execute(sql, params);
			while(resultSet.next()){
				Sell sell = new Sell();
		    	sell.setBid(resultSet.getInt("bid"));
		       	sell.setScontent(resultSet.getString("scontent"));
			    sell.setSdate(resultSet.getTimestamp("sdate"));
			    sell.setSid(resultSet.getInt("sid"));
			    sell.setStitle(resultSet.getString("stitle"));
			    sell.setUid(resultSet.getInt("uid"));
			
			    SList.add(sell);
			}
		}
		return SList;
	}

	@Override
	public List<Buy> getListByTitle(String btitle) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
