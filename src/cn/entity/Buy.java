/**  

* @Title: Buy.java  

* @Description:   

* @author 黄文 

* @date 2018年11月13日  

* @version 1.0  

*/  

package cn.entity;


import java.sql.Timestamp;

/**  

* @Title: Buy  

* @Description:  与数据库的buy表相对应 

* @author Hw 

* @date 2018年11月13日  

*/

public class Buy {
	
	/** 求购信息的ID*/
	private Integer buyid;
	/**用户的ID*/
	private Integer uid;
	/**求购信息的标题*/
	private String btitle;
	/**求购内容*/
	private String bcontent;
	/**求购日期*/
	private Timestamp  bdate;
	
	public Integer getBuyid() {
		return buyid;
	}
	public void setBuyid(Integer buyid) {
		this.buyid = buyid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public Timestamp getBdate() {
		return bdate;
	}
	public void setBdate(Timestamp bdate) {
		this.bdate = bdate;
	}
	@Override
	public String toString() {
		return "Buy [buyid=" + buyid + ", uid=" + uid + ", btitle=" + btitle + ", bcontent=" + bcontent + ", bdate="
				+ bdate + "]";
	}
	public Buy(Integer buyid, Integer uid, String btitle, String bcontent, Timestamp bdate) {
		super();
		this.buyid = buyid;
		this.uid = uid;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bdate = bdate;
	}
	
	/**  
	
	* @Title: 
	
	* @Description:  
	  
	
	*/

	public Buy() {
		
	}

}
