/**  

* @Title: Report.java  

* @Description:   

* @author HW

* @date 2018年11月13日  

* @version 1.0  

*/  

package cn.entity;

/**  

* @Title: Report  

* @Description: 与数据库中举报表的对应  

* @author Hw 

* @date 2018年11月13日  

*/

public class Report {
	
	/**举报的编号*/
	private Integer rid;
	/**举报者的ID*/
	private Integer aid;
	/**被举报者的ID*/
	private Integer bid;
	/**举报的内容*/
	private String rcomment;
	/**未处理0 已处理1*/
	private Integer rstate;
	
	/**  
	
	* @Title: 
	
	* @Description:  无参构造函数
	  
	
	*/

	public Report() {
	}

	public Report(Integer rid, Integer aid, Integer bid, String rcomment, Integer rstate) {
		super();
		this.rid = rid;
		this.aid = aid;
		this.bid = bid;
		this.rcomment = rcomment;
		this.rstate = rstate;
	}

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public String getRcomment() {
		return rcomment;
	}

	public void setRcomment(String rcomment) {
		this.rcomment = rcomment;
	}

	public Integer getRstate() {
		return rstate;
	}

	public void setRstate(Integer rstate) {
		this.rstate = rstate;
	}

	@Override
	public String toString() {
		return "Report [rid=" + rid + ", aid=" + aid + ", bid=" + bid + ", rcomment=" + rcomment + ", rstate=" + rstate
				+ "]";
	}
	

}
