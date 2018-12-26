/**  

* Title: UserDaoImpl.java  

* Description:   

* @author 黄文 

* @date 2018年11月11日  

* @version 1.0  

*/  

package cn.daoimpl;

import java.sql.ResultSet;

import java.util.List;


import cn.dao.UserDao;
import cn.entity.User;
import cn.util.JdbcUtils;

/**  

* Title: UserDaoImpl  

* Description:   

* @author Hw

* @date 2018年11月11日  

*/

public class UserDaoImpl implements UserDao {

	/** (non-Javadoc)  
	 * Title: getAll 
	 * Description:  获取表中所有元素 
	 * @return 返回表中所有元素 
	 * @see cn.Dao.UserDao#getAll()  
	 */
    @SuppressWarnings("unchecked")
	@Override
	public List<User> getAll() {
		String sql = "select * from user";
		return JdbcUtils.getList(User.class, sql);
	}

	/** (non-Javadoc)  
	 * Title: getById 
	 * Description:   
	 * @param id
	 * @return  
	 * @see cn.Dao.UserDao#getById(java.lang.Integer)  
	 */
    @Override
	public User getById(Integer uid) {
		String sql = "select * from user where uid = ?";
		return (User) JdbcUtils.getObjectById(User.class,sql , uid);
	}

	@Override
	public boolean add(User user) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "insert into user"+
		"(uid,tname,uname,upass,utype,ustate,uclass)"+
				"values(?,?,?,?,?,?,?);";		
		if(JdbcUtils.executeSQL(sql, user.getUid(),user.getTname(),user.getUname(),user.getUpass(),user.getUtype(),user.getUstate(),user.getUclass())>0)
			flag = true;
		return flag;
	}

	@Override
	public boolean delUserById(Integer uid)  {
		// TODO Auto-generated method stub
		boolean flag=false;
		String sql = "delete from user where uid=?";
		if(JdbcUtils.executeSQL(sql, uid)>0)
			flag=true;
		return flag;
	}

	@Override
	public boolean updateUser(User user)  {
		// TODO Auto-generated method stub
		boolean flag=false;
		String sql = "update user set tname=?,uname=?,upass=? where uid=?";
		System.out.println(user.getUpass());
		if(JdbcUtils.executeSQL(sql, user.getTname(),user.getUname(),user.getUpass(),user.getUid())>0)
			flag=true;
		return flag;
	}

	@Override
	public User getUser(Integer uid) throws Exception  {
		// TODO Auto-generated method stub
		User user = null;
		ResultSet resultSet = null;
		String sql="select * from user where uid=?";
		Object[] params= {uid};	
		resultSet = JdbcUtils.execute(sql, params);
		if(resultSet.next()){
			user = new User();
			user.setTname(resultSet.getString("tname"));
			user.setUclass(resultSet.findColumn("uclass"));
			user.setUid(resultSet.getInt("uid"));
			user.setUname(resultSet.getString("uname"));
			user.setUstate(resultSet.getInt("ustate"));
			user.setUpass(resultSet.getString("upass"));
			user.setUtype(resultSet.getInt("utype"));
		}
		return user;
	}

	@Override
	public boolean ucexist(Integer uid) throws Exception {
		// TODO Auto-generated method stub
		boolean flag=false;
		ResultSet resultSet = null;
		String sql = "select count(1) from user where uid=?";
		Object[] params= {uid};
		resultSet = JdbcUtils.execute(sql, params);
		if(resultSet.next()){
			if(resultSet.getInt("count(1)")>0){
				flag = true;
			}
		}
		return flag;
	}

	@Override
	public boolean modifyType(User user)  {
		// TODO Auto-generated method stub
		boolean flag=false;
		String sql = "update user set urtpe=? where uid=?";
		if(JdbcUtils.executeSQL(sql, user.getUtype(),user.getUid())>0)
			flag=true;
		return flag;
	}

	@Override
	public boolean modifyUserPassword(User user)  {
		// TODO Auto-generated method stub
		boolean flag=false;
		String sql = "update user set upass=? where uid=?";
		if(JdbcUtils.executeSQL(sql, user.getUpass(),user.getUid())>0)
			flag=true;
		return flag;
	}

	@Override
	public boolean modifyUserState(User user)  {
		// TODO Auto-generated method stub
		boolean flag=false;
		String sql = "update user set ustate=? where uid=?";
		if(JdbcUtils.executeSQL(sql, user.getUstate(),user.getUid())>0)
			flag=true;
		return flag;
	}

	@Override
	public boolean modifyUserClass(User user)  {
		// TODO Auto-generated method stub
		boolean flag=false;
		String sql = "update user set uclass=? where uid=?";
		if(JdbcUtils.executeSQL(sql, user.getUclass(),user.getUid())>0)
			flag=true;
		return flag;
	}

}
