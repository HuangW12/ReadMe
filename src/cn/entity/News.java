/**  

* @Title: News.java  

* @Description:   

* @author HW

* @date 2018年11月13日  

* @version 1.0  

*/  

package cn.entity;

/**  

* @Title: News  

* @Description: 对应数据库中news表  

* @author Hw 

* @date 2018年11月13日  

*/

public class News {
	
	/**新闻ID自增*/
	private Integer nid;
	/**用户ID*/
	private Integer uid;
	/**新闻的标题*/
	private String  ntitle;
	/**新闻的内容*/
	private String  ncontent;
	
	/**  
	
	* @Title: 
	
	* @Description:  
	  
	
	*/

	public News() {
		
	}
	

	public News(Integer nid, Integer uid, String ntitle, String ncontent) {
		super();
		this.nid = nid;
		this.uid = uid;
		this.ntitle = ntitle;
		this.ncontent = ncontent;
	}


	public Integer getNid() {
		return nid;
	}

	public void setNid(Integer nid) {
		this.nid = nid;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getNtitle() {
		return ntitle;
	}

	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}

	public String getNcontent() {
		return ncontent;
	}

	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}

	@Override
	public String toString() {
		return "News [nid=" + nid + ", uid=" + uid + ", ntitle=" + ntitle + ", ncontent=" + ncontent + "]";
	}
	

}
