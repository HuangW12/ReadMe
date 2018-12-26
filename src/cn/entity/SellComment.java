/**  

* @Title: SellComment.java  

* @Description:   

* @author HW

* @date 2018年11月13日  

* @version 1.0  

*/  

package cn.entity;

import java.sql.Timestamp;

/**  

* @Title: SellComment  

* @Description:  对应出售信息评论表的属性 

* @author Hw 

* @date 2018年11月13日  

*/

public class SellComment {
	
	/**出售信息评论ID自增*/
	private Integer scid;
	/**评论用户ID*/
	private Integer uid;
	/**出售信息的ID*/
	private Integer sid;
	/**评论的时间*/
	private Timestamp sctime;
	/**评论的内容*/
	private String sc_content;
	
	/**  
	
	* @Title: 
	
	* @Description:  无参构造函数
	  
	
	*/

	public SellComment() {
		
	}

	public SellComment(Integer scid, Integer uid, Integer sid, Timestamp sctime, String sc_content) {
		super();
		this.scid = scid;
		this.uid = uid;
		this.sid = sid;
		this.sctime = sctime;
		this.sc_content = sc_content;
	}

	public Integer getScid() {
		return scid;
	}

	public void setScid(Integer scid) {
		this.scid = scid;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Timestamp getSctime() {
		return sctime;
	}

	public void setSctime(Timestamp sctime) {
		this.sctime = sctime;
	}

	public String getSc_content() {
		return sc_content;
	}

	public void setSc_content(String sc_content) {
		this.sc_content = sc_content;
	}

	@Override
	public String toString() {
		return "SellComment [scid=" + scid + ", uid=" + uid + ", sid=" + sid + ", sctime=" + sctime + ", sc_content="
				+ sc_content + "]";
	}
	

}
