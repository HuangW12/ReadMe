/**  

* Title: User.java  

* Description:   

* @author 黄文 

* @date 2018年11月11日  

* @version 1.0  

*/  

package cn.entity;

/**  

* Title: User  

* Description: 建立与数据库Books中user表的联系  

* @author Hw

* @date 2018年11月11日  

*/

public class User {
	
	/** 用户ID*/
	private Integer uid;
	/**真实姓名*/
	private String tname;
	/**用户名*/
	private String uname;
	/**密码*/
	private String upass;
	/**是否是管理员 1 是 0 不是*/
	private Integer utype;
	/**默认0 冻结状态1*/
    private Integer ustate;
    /**用户等级积分 默认0**/
    private Integer uclass;
	
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	public Integer getUtype() {
		return utype;
	}
	public void setUtype(Integer utype) {
		this.utype = utype;
	}
	public Integer getUstate() {
		return ustate;
	}
	public void setUstate(Integer ustate) {
		this.ustate = ustate;
	}
	public Integer getUclass() {
		return uclass;
	}
	public void setUclass(Integer uclass) {
		this.uclass = uclass;
	}
	
	@Override
	public String toString() {
		return "User [uid=" + uid + ", tname=" + tname + ", uname=" + uname + ", upass=" + upass + ", utype=" + utype
				+ ", ustate=" + ustate + ",uclass="+uclass+"]";
	}
	
	/**  
	
	* Title: User无参构造函数
	
	* Description:  
	  
	
	*/

	public User() {
		
	}
	public User(Integer uid, String tname, String uname, String upass, Integer utype, Integer ustate,Integer uclass) {
		super();
		this.uid = uid;
		this.tname = tname;
		this.uname = uname;
		this.upass = upass;
		this.utype = utype;
		this.ustate = ustate;
		this.uclass = uclass;
	}
	
	
	
	

}
