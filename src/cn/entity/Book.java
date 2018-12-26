/**  

* @Title: Book.java  

* @Description:   

* @author HW

* @date 2018年11月13日  

* @version 1.0  

*/  

package cn.entity;

/**  

* @Title: Book  

* @Description: 与数据库中book表的对应  

* @author Hw 

* @date 2018年11月13日  

*/

public class Book {
	
	/**书籍ID*/
	private Integer bid;
	/**作者*/
	private String  author;
	/**用户ID*/
	private Integer uid;
	/**书籍名称*/
	private String bname;
	/**书籍类型*/
	private Integer btype;
	/**书籍的价格*/
	private Integer price;
	/**  
	
	* @Title: 
	
	* @Description:  
	  
	
	*/

	public Book() {
		
	}
	public Book(Integer bid, String author, Integer uid, String bname, Integer btype, Integer price, String content,
			byte[] cover) {
		super();
		this.bid = bid;
		this.author = author;
		this.uid = uid;
		this.bname = bname;
		this.btype = btype;
		this.price = price;
	}
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public Integer getBtype() {
		return btype;
	}
	public void setBtype(Integer btype) {
		this.btype = btype;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [bid=" + bid + ", author=" + author + ", uid=" + uid + ", bname=" + bname + ", btype=" + btype
				+ ", price=" + price +"]";
	}
	

}
