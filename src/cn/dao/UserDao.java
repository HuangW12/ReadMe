/**  

* Title: UserDao.java  

* Description:   

* @author 黄文 

* @date 2018年11月11日  

* @version 1.0  

*/  

package cn.dao;

import java.util.List;

import cn.entity.User;

/**  

* Title: UserDao  

* Description:   

* @author Hw

* @date 2018年11月11日  

*/

public interface UserDao {
    /**
     * 
     * Title: getAll 
     * Description: 求出User表中所有元素并存入List<User>中  
     * @return User表中所有元素
     */
	List<User> getAll();
	/**
	 * 
	 * Title: getById 
	 * Description: 通过ID在user表中查找元素  
	 * @param id
	 * @return 该元素
	 */
	User getById(Integer id);
	
	public boolean add(User user);//增加用户
	public boolean delUserById(Integer uid);//通过id删除user
	public boolean updateUser(User user);//更改用户信息
	public User getUser(Integer uid)throws Exception;//通过id获取User
	public boolean ucexist(Integer uid)throws Exception;//验证用户是否存在
	public boolean modifyType(User user);//修改用户类型
	public boolean modifyUserPassword(User user);//修改用户密码
	public boolean modifyUserState(User user);//修改用户状态
	public boolean modifyUserClass(User user);//修改用户等级积分

}
