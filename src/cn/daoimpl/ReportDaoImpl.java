/**  

* @Title: ReportDaoImpl.java  

* @Description:   

* @author HW

* @date 2018年11月15日  

* @version 1.0  

*/  

package cn.daoimpl;

import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import cn.dao.ReportDao;
import cn.entity.Report;
import cn.util.JdbcUtils;

/**  

* @Title: ReportDaoImpl  

* @Description:   

* @author Hw 

* @date 2018年11月15日  

*/

public class ReportDaoImpl implements ReportDao {

	/** (non-Javadoc)  
	 * Title: getAll
	 * Description:   
	 * @return  
	 * @see cn.dao.ReportDao#getAll()  
	 */

	@SuppressWarnings("unchecked")
	@Override
	public List<Report> getAll() {
		String sql = "select * from report";
		return JdbcUtils.getList(Report.class, sql);
	}

	/** (non-Javadoc)  
	 * Title: insertReport
	 * Description:   
	 * @param aid
	 * @param bid
	 * @param rcomment
	 * @return  
	 * @see cn.dao.ReportDao#insertReport(java.lang.Integer, java.lang.Integer, java.lang.String)  
	 */

	@Override
	public int insertReport(Integer aid, Integer bid, String rcomment) {
		String sql = "insert into report(aid,bid,rcomment,rstate) values(?,?,?,?)";
		return JdbcUtils.executeSQL(sql, aid,bid,rcomment,0);
	}

	/** (non-Javadoc)  
	 * Title: updateReport
	 * Description:   
	 * @param report
	 * @return  
	 * @see cn.dao.ReportDao#updateReport(cn.entity.Report)  
	 */

	@Override
	public int updateReport(Report report) {
		String sql = "update report set rstate = ? where aid = ? and bid = ? and rcomment = ?";
		return JdbcUtils.executeSQL(sql, 1,report.getAid(),report.getBid(),report.getRcomment());
	}

	/** (non-Javadoc)  
	 * Title: deleteReport
	 * Description:   
	 * @param aid
	 * @param bid
	 * @param rcomment
	 * @return  
	 * @see cn.dao.ReportDao#deleteReport(java.lang.Integer, java.lang.Integer, java.lang.String)  
	 */

	@Override
	public int deleteReport(Integer aid, Integer bid, String rcomment) {
		String sql = "delete from report where aid = ? and bid = ? and rcomment = ?";
		return JdbcUtils.executeSQL(sql, aid,bid,rcomment);
	}

	@Override
	public List<Report> getFList() throws Exception {
		// TODO Auto-generated method stub
		ResultSet resultSet = null;
	    List<Report> RList =new ArrayList<Report>();
		String sql = "select * from report where rstate = ?";
		Object[] params = {1};
		resultSet = JdbcUtils.execute(sql, params);
		while(resultSet.next()){
			Report report = new Report();
			report.setAid(resultSet.getInt("aid"));
			report.setBid(resultSet.getInt("bid"));
			report.setRcomment(resultSet.getString("rcomment"));
			report.setRid(resultSet.getInt("rid"));
			report.setRstate(resultSet.getInt("rstate"));
			
			RList.add(report);
		}
	return RList;
	}

	@Override
	public List<Report> getNList() throws Exception {
		// TODO Auto-generated method stub
		ResultSet resultSet = null;
	    List<Report> RList =new ArrayList<Report>();
		String sql = "select * from report where rstate = ?";
		Object[] params = {0};
		resultSet = JdbcUtils.execute(sql, params);
		while(resultSet.next()){
			Report report = new Report();
			report.setAid(resultSet.getInt("aid"));
			report.setBid(resultSet.getInt("bid"));
			report.setRcomment(resultSet.getString("rcomment"));
			report.setRid(resultSet.getInt("rid"));
			report.setRstate(resultSet.getInt("rstate"));
			
			RList.add(report);
		}
	return RList;
	}

}
