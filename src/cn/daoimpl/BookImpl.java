/**  

* @Title: BookImpl.java  

* @Description:   

* @author HW

* @date 2018年11月15日  

* @version 1.0  

*/  

package cn.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.dao.BookDao;
import cn.entity.Book;
import cn.util.JdbcUtils;

/**  

* @Title: BookImpl  

* @Description:   

* @author Hw 

* @date 2018年11月15日  

*/

public class BookImpl implements BookDao {

	/** (non-Javadoc)  
	 * Title: getAll
	 * Description:   
	 * @return  
	 * @see cn.dao.BookDao#getAll()  
	 */

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> getAll() {
		String sql = "select * from book";
		return JdbcUtils.getList(Book.class, sql);
	}

	/** (non-Javadoc)  
	 * Title: updateBook
	 * Description:   
	 * @param ID
	 * @param author
	 * @param name
	 * @param object
	 * @return  
	 * @see cn.dao.BookDao#updateBook(java.lang.Integer, java.lang.String, java.lang.String, java.lang.Object)  
	 */
    
	@Override
	public int updateBookType(Integer ID, String author, String name, Integer type) {
		String sql = "update book set btype = ? where author = ? and uid = ? and bname = ?";
		return JdbcUtils.executeSQL(sql, type,author,ID,name);
	}
	/** (non-Javadoc)  
	 * Title: deleteBook
	 * Description:   
	 * @param ID
	 * @param author
	 * @param name
	 * @return  
	 * @see cn.dao.BookDao#deleteBook(java.lang.Integer, java.lang.String, java.lang.String)  
	 */

	@Override
	public int deleteBook(Integer ID, String author, String name) {
		String sql = "delete from book where author = ? and uid = ? and bname = ?";
		return JdbcUtils.executeSQL(sql, author,ID,name);
	}

	/** (non-Javadoc)  
	 * Title: insertBook
	 * Description:   
	 * @param book
	 * @return  
	 * @see cn.dao.BookDao#insertBook(cn.entity.Book)  
	 */

	@Override
	public int insertBook(Book book) {
		String sql = "insert into book(author,uid,bname,btype,price) values(?,?,?,?,?)";
		return JdbcUtils.executeSQL(sql,book.getAuthor(),book.getUid(),book.getBname(),book.getBtype(),book.getPrice());
	}

	/** (non-Javadoc)  
	 * Title: updateBookPrice
	 * Description:   
	 * @param ID
	 * @param author
	 * @param name
	 * @param object
	 * @return  
	 * @see cn.dao.BookDao#updateBookPrice(java.lang.Integer, java.lang.String, java.lang.String, java.lang.Object)  
	 */
	
	@Override
	public int updateBookPrice(Integer ID, String author, String name, float price) {
		String sql = "update book set price = ? where author = ? and uid = ? and bname = ?";
		System.out.println(author+ID+name+price);
		return JdbcUtils.executeSQL(sql, price,author,ID,name);
	}

	@Override
	public List<Book> getListByTitle(String bname) throws Exception{
		// TODO Auto-generated method stub
		ResultSet resultSet = null;
		List<Book> BookList =new ArrayList<Book>();
		String sql = "select * from book where bname = ?";
		Object[] params = {bname};
		resultSet = JdbcUtils.execute(sql, params);
		while(resultSet.next()){
			Book book = new Book();
			book.setAuthor(resultSet.getString("author"));
			book.setBid(resultSet.getInt("bid"));
			book.setBname(resultSet.getString("bname"));
			book.setBtype(resultSet.getInt("btype"));
			book.setPrice(resultSet.getInt("price"));
			book.setUid(resultSet.getInt("uid"));
			
			BookList.add(book);
		}
		return BookList;
	}

	@Override
	public List<Book> getListByType(Integer btype) throws Exception{
		// TODO Auto-generated method stub
		ResultSet resultSet = null;
		List<Book> BookList =new ArrayList<Book>();
		String sql = "select * from book where btype = ?";
		Object[] params = {btype};
		resultSet = JdbcUtils.execute(sql, params);
		while(resultSet.next()){
			Book book = new Book();
			book.setAuthor(resultSet.getString("author"));
			book.setBid(resultSet.getInt("bid"));
			book.setBname(resultSet.getString("bname"));
			book.setBtype(resultSet.getInt("btype"));
			book.setPrice(resultSet.getInt("price"));
			book.setUid(resultSet.getInt("uid"));

			
			BookList.add(book);
		}
		return BookList;
	}

	@Override
	public Integer getbookid(Book book) throws Exception {
		// TODO Auto-generated method stub
		ResultSet resultSet = null;
		Integer bid = null;
		String sql = "select * from book where author = ? and uid =? and bname = ?and btype=? and price =?";
		Object[] params = {book.getAuthor(),book.getUid(),book.getBname(),book.getBtype(),book.getPrice()};
		resultSet = JdbcUtils.execute(sql, params);
		try {
			while(resultSet.next()){
				bid = resultSet.getInt("bid");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bid;
	}
	
	public Book getbookbybid(Book book) throws Exception {
		// TODO Auto-generated method stub
		ResultSet resultSet = null;
		Book bool = new Book();
		String sql = "select * from book where bid =?";
		Object[] params = {book.getBid()};
		resultSet = JdbcUtils.execute(sql, params);
		try {
			while(resultSet.next()){
				book.setAuthor(resultSet.getString("author"));
				book.setBid(resultSet.getInt("bid"));
				book.setBname(resultSet.getString("bname"));
				book.setBtype(resultSet.getInt("btype"));
				book.setPrice(resultSet.getInt("price"));
				book.setUid(resultSet.getInt("uid"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}

}
