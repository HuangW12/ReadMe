/**  

* @Title: Sell.java  

* @Description:   

* @author 黄文 

* @date 2018年11月13日  

* @version 1.0  

*/  

package cn.entity;

import java.sql.Timestamp;

/**  

* @Title: Sell  

* @Description: 出售信息表对应  

* @author Hw

* @date 2018年11月13日  

*/

public class Sell {
	
	/**出售信息的id */
	private Integer sid;
	/**用户id*/
	private Integer uid;
	/**书籍id*/
	private Integer bid;
	/** 出售信息标题*/
	private String  stitle;
	/** 出售内容*/
	private String  scontent;
	/**出售信息发布日期*/
	private Timestamp sdate;
	
	public Sell(Integer sid, Integer uid, Integer bid, String stitle, String scontent, Timestamp sdate) {
		super();
		this.sid = sid;
		this.uid = uid;
		this.bid = bid;
		this.stitle = stitle;
		this.scontent = scontent;
		this.sdate = sdate;
	}
	/**  
	
	* @Title: 
	
	* @Description:  
	  
	
	*/

	public Sell() {
		
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public String getStitle() {
		return stitle;
	}
	public void setStitle(String stitle) {
		this.stitle = stitle;
	}
	public String getScontent() {
		return scontent;
	}
	public void setScontent(String scontent) {
		this.scontent = scontent;
	}
	public Timestamp getSdate() {
		return sdate;
	}
	public void setSdate(Timestamp sdate) {
		this.sdate = sdate;
	}
	@Override
	public String toString() {
		return "Sell [sid=" + sid + ", uid=" + uid + ", bid=" + bid + ", stitle=" + stitle + ", scontent=" + scontent
				+ ", sdate=" + sdate + "]";
	}
	
	
	

}
