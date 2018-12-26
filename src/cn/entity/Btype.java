/**  

* @Title: Btype.java  

* @Description:   

* @author HW

* @date 2018年11月13日  

* @version 1.0  

*/  

package cn.entity;

/**  

* @Title: Btype  

* @Description:  与数据库书籍类型表对应 

* @author Hw 

* @date 2018年11月13日  

*/

public class Btype {
	
	/**书籍类型的编号*/
	private Integer btid;
	/**书籍类型的名称*/
	private String  btname;
	
	/**  
	
	* @Title: 
	
	* @Description:  无参构造函数
	  
	
	*/

	public Btype() {
	}

	public Btype(Integer btid, String btname) {
		super();
		this.btid = btid;
		this.btname = btname;
	}

	public Integer getBtid() {
		return btid;
	}

	public void setBtid(Integer btid) {
		this.btid = btid;
	}

	public String getBtname() {
		return btname;
	}

	public void setBtname(String btname) {
		this.btname = btname;
	}

	@Override
	public String toString() {
		return "Btype [btid=" + btid + ", btname=" + btname + "]";
	}
	

}
