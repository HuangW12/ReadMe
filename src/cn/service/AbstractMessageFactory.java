/**  

* @Title: MessageFactory.java  

* @Description:   

* @author HW

* @date 2018年11月13日  

* @version 1.0  

*/  

package cn.service;

import cn.dao.MessageDao;

/**  

* @Title: MessageFactory  

* @Description:  信息的抽象工厂 

* @author Hw 

* @date 2018年11月13日  

*/

public abstract class AbstractMessageFactory {
	/**
	 * 
	 * @Title: getMessage 
	 * @Description:  原来获取出售/求购信息的对象 
	 * @return 求购或出售对象
	 */
	public abstract MessageDao getMessage();

}
