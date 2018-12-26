/**  

* @Title: NewDaoImpl.java  

* @Description:   

* @author HW

* @date 2018年11月15日  

* @version 1.0  

*/  

package cn.daoimpl;

import java.util.List;

import cn.dao.NewDao;
import cn.entity.News;
import cn.util.JdbcUtils;

/**  

* @Title: NewDaoImpl  

* @Description:   

* @author Hw 

* @date 2018年11月15日  

*/

public class NewDaoImpl implements NewDao {

	/** (non-Javadoc)  
	 * Title: getAll
	 * Description:   
	 * @return  
	 * @see cn.dao.NewDao#getAll()  
	 */

	@SuppressWarnings("unchecked")
	@Override
	public List<News> getAll() {
		String sql = "select * from news";
		return JdbcUtils.getList(News.class, sql);
	}

	/** (non-Javadoc)  
	 * Title: insertNew
	 * Description:   
	 * @param uid
	 * @param ntitle
	 * @param ncontent
	 * @return  
	 * @see cn.dao.NewDao#insertNew(java.lang.Integer, java.lang.String, java.lang.String)  
	 */

	@Override
	public int insertNew(News news) {
		String sql = "insert into news(uid,ntitle,ncontent) values(?,?,?)";
		return JdbcUtils.executeSQL(sql, news.getUid(),news.getNtitle(),news.getNcontent());
	}

	/** (non-Javadoc)  
	 * Title: deleteNew
	 * Description:   
	 * @param uid
	 * @param ncontent
	 * @return  
	 * @see cn.dao.NewDao#deleteNew(java.lang.Integer, java.lang.String)  
	 */

	@Override
	public int deleteNew(News news) {
		String sql = "delete from news where nid = ? ";
		return JdbcUtils.executeSQL(sql, news.getNid());
	}

	/** (non-Javadoc)  
	 * Title: updateNewTitle
	 * Description:   
	 * @param uid
	 * @param ncontent
	 * @return  
	 * @see cn.dao.NewDao#updateNewTitle(java.lang.Integer, java.lang.String)  
	 */

	@Override
	public int updateNewTitle(News news) {
		String sql = "update news set ntitle = ? where nid = ?";
		return JdbcUtils.executeSQL(sql, news.getNtitle(),news.getNid());
	}

	/** (non-Javadoc)  
	 * Title: updateNewContent
	 * Description:   
	 * @param uid
	 * @param ntitle
	 * @return  
	 * @see cn.dao.NewDao#updateNewContent(java.lang.Integer, java.lang.String)  
	 */

	@Override
	public int updateNewContent(News news) {
		String sql = "update news set ncontent = ? where nid = ?";
		return JdbcUtils.executeSQL(sql,news.getNcontent(),news.getNid());
	}

}
