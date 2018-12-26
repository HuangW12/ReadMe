/**  

* @Title: ReportDao.java  

* @Description:   

* @author HW

* @date 2018年11月15日  

* @version 1.0  

*/  

package cn.dao;

import java.util.List;

import cn.entity.Report;

/**  

* @Title: ReportDao  

* @Description:  对举报表的增删改查 

* @author Hw 

* @date 2018年11月15日  

*/

public interface ReportDao {
	/**
	 * 
	 * @Title: getAll 
	 * @Description: 获取举报表的所有数据  
	 * @return list
	 */
	public List<Report> getAll();
	/**
	 * 
	 * @Title: insertReport 
	 * @Description: 需要举报者id 被举报者的id 举报内容 处理默认为0  
	 * @param aid 举报者id
	 * @param bid 被举报者的id
	 * @param rcomment 举报内容
	 * @return 受影响的行数
	 */
	public int insertReport(Integer aid, Integer bid, String rcomment);
	/**
	 * 
	 * @Title: updateReport 
	 * @Description: 即为把处理把0变1  
	 * @param report 
	 * @return 受影响的行数
	 */
	public int updateReport(Report report);
	/**
	 * 
	 * @Title: deleteReport 
	 * @Description:  根据举报者和举报内容 被举报者id  
	 * @param aid 举报者id
	 * @param bid 被举报者的id
	 * @param rcomment  举报内容
	 * @return 受影响的行数
	 */
	public int deleteReport(Integer aid, Integer bid, String rcomment);
	
	public List<Report> getFList()throws Exception;//得到已处理的举报列表
	public List<Report> getNList()throws Exception;//得到未处理的举报列表

}
