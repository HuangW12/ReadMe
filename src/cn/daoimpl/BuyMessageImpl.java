/**  

* @Title: BuyMessageImpl.java  

* @Description:   

* @author 黄文 

* @date 2018年11月13日  

* @version 1.0  

*/  

package cn.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.dao.MessageDao;
import cn.entity.Book;
import cn.entity.Buy;
import cn.entity.Sell;
import cn.util.JdbcUtils;

/**  

* @Title: BuyMessageImpl  

* @Description: 对求购信息的查询，更新，删除操作  

* @author Hw 

* @date 2018年11月13日  

*/

public class BuyMessageImpl implements MessageDao {

	/** (non-Javadoc)  
	 * <p>Title: getAll</p> 
	 * <p>Description: </P>  
	 * @return  
	 * @see cn.dao.MessageDao#getAll()  
	 */
    @SuppressWarnings("unchecked")
	@Override
	public List<Buy> getAll() {
		String sql = "select * from buy";
		ResultSet resultSet = null;
		 List<Buy> BList =new ArrayList<Buy>();
		 Object[] params = {};
		 try {
			resultSet = JdbcUtils.execute(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while(resultSet.next()){
				Buy buy = new Buy();
				buy.setBcontent(resultSet.getString("bcontent"));
				buy.setBdate(resultSet.getTimestamp("bdate"));
				buy.setBtitle(resultSet.getString("btitle"));
				buy.setBuyid(resultSet.getInt("buyid"));
				buy.setUid(resultSet.getInt("uid"));
						
			    BList.add(buy);
					}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return BList;
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
	public int deleteMessage(Integer id, String title) {
		String sql = "delete from buy where uid = ? and btitle = ?";
		return JdbcUtils.executeSQL(sql, id,title);
	}

	/** (non-Javadoc)  
	 * <p>Title: updateMessage</p> 
	 * <p>Description: </P>  
	 * @param id
	 * @param title
	 * @return  
	 * @see cn.dao.MessageDao#updateMessage(java.lang.Integer, java.lang.String)  
	 */

    @Override
	public int updateMessage(Integer id, String title , String scontent) {
		String sql = "update buy set scontent = ? where uid = ? and btitle = ?";
		return JdbcUtils.executeSQL(sql, scontent,id,title);
	}

	/** (non-Javadoc)  
	 * Title: insertMessage
	 * Description:   
	 * @param num
	 * @return  
	 * @see cn.dao.MessageDao#insertMessage(java.lang.Object[])  
	 */
    @Override
	public int insertMessage(Object  object) {
		String sql = "insert into buy(uid,btitle,bcontent,bdate) values(?,?,?,?)";
		return JdbcUtils.executeSQL(sql,((Buy) object).getUid(),((Buy) object).getBtitle(),((Buy) object).getBcontent(),((Buy) object).getBdate() );
	}

	@Override
	public List<Buy> getListByID(Integer uid) throws Exception {
		// TODO Auto-generated method stub
		 ResultSet resultSet = null;
		 List<Buy> BList =new ArrayList<Buy>();
		 String sql = "select * from buy where uid = ?";
		 Object[] params = {uid};
		 resultSet = JdbcUtils.execute(sql, params);
		while(resultSet.next()){
			Buy buy = new Buy();
			buy.setBcontent(resultSet.getString("bcontent"));
			buy.setBdate(resultSet.getTimestamp("bdate"));
			buy.setBtitle(resultSet.getString("btitle"));
			buy.setBuyid(resultSet.getInt("buyid"));
			buy.setUid(resultSet.getInt("uid"));
					
		    BList.add(buy);
				}
		return BList;
	}
	
	/*通过书籍名查找求购信息*/
	public List<Buy> getListByTitle(String btitle) throws Exception
	{
		ResultSet resultSet = null;
		 List<Buy> BList =new ArrayList<Buy>();
		 String sql = "select * from buy where btitle = ?";
		 Object[] params = {btitle};
		 resultSet = JdbcUtils.execute(sql, params);
		while(resultSet.next()){
			Buy buy = new Buy();
			buy.setBcontent(resultSet.getString("bcontent"));
			buy.setBdate(resultSet.getTimestamp("bdate"));
			buy.setBtitle(resultSet.getString("btitle"));
			buy.setBuyid(resultSet.getInt("buyid"));
			buy.setUid(resultSet.getInt("uid"));
					
		    BList.add(buy);
				}
		return BList;
	}

	@Override
	public List<Sell> getListByBook(List<Book> bookList) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
