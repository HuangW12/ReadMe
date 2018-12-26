/**  

* @Title: BuyMessageFactory.java  

* @Description:   

* @author HW

* @date 2018年11月13日  

* @version 1.0  

*/  

package cn.service;

import cn.dao.MessageDao;
import cn.daoimpl.BuyMessageImpl;

/**  

* @Title: BuyMessageFactory  

* @Description: 求购信息的具体工厂  

* @author Hw 

* @date 2018年11月13日  

*/

public class BuyMessageFactory extends AbstractMessageFactory {

	/** (non-Javadoc)  
	 * Title: getMessage
	 * Description:   
	 * @return  
	 * @see cn.service.AbstractMessageFactory#getMessage()  
	 */
    @Override
	public MessageDao getMessage() {
		return new BuyMessageImpl();
	}

}
