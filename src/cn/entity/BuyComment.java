/**  

* @Title: BuyComment.java  

* @Description:   

* @author HW

* @date 2018年11月13日  

* @version 1.0  

*/  

package cn.entity;

import java.sql.Timestamp;

/**  

* @Title: BuyComment  

* @Description: 求购信息评论表的属性  

* @author Hw 

* @date 2018年11月13日  

*/

public class BuyComment {
	
	/**求购信息评论*/
	private Integer bcid;
	/**评论用户ID*/
	private Integer uid;
	/**求购信息ID*/
	private Integer buyid;
	/**评论的时间*/
	private Timestamp bctime;
	/**评论的内容*/
	private String bc_comment;
	
	/**  
	
	* @Title: 
	
	* @Description: 无参构造函数 
	  
	
	*/

	public BuyComment() {
		
	}

	public BuyComment(Integer bcid, Integer uid, Integer buyid, Timestamp bctime, String bc_comment) {
		super();
		this.bcid = bcid;
		this.uid = uid;
		this.buyid = buyid;
		this.bctime = bctime;
		this.bc_comment = bc_comment;
	}

	public Integer getBcid() {
		return bcid;
	}

	public void setBcid(Integer bcid) {
		this.bcid = bcid;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getBuyid() {
		return buyid;
	}

	public void setBuyid(Integer buyid) {
		this.buyid = buyid;
	}

	public Timestamp getBctime() {
		return bctime;
	}

	public void setBctime(Timestamp bctime) {
		this.bctime = bctime;
	}

	public String getBc_comment() {
		return bc_comment;
	}

	public void setBc_comment(String bc_comment) {
		this.bc_comment = bc_comment;
	}

	@Override
	public String toString() {
		return "BuyComment [bcid=" + bcid + ", uid=" + uid + ", buyid=" + buyid + ", bctime=" + bctime + ", bc_comment="
				+ bc_comment + "]";
	}
	

}
