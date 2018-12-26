/**  

* @Title: GetMessageClass.java  

* @Description:   

* @author HW

* @date 2018年11月13日  

* @version 1.0  

*/  

package cn.service;

/**  

* @Title: GetMessageClass  

* @Description:   获取求购和出售的具体工厂对象

* @author Hw 

* @date 2018年11月13日  

*/

public class GetMessageClass {
    /**
     *   
     * @Title: getBuyMessageFactory 
     * @Description:  获取求购信息工厂的对象 
     * @return 求购信息工厂的对象 
     */
	public static AbstractMessageFactory getBuyMessageFactory() {
		return new BuyMessageFactory();
	}
	
	/**
	 * 
	 * @Title: getSellMessageFactory 
	 * @Description: 获取出售信息工厂的对象    
	 * @return 出售信息工厂的对象    
	 */
	public static AbstractMessageFactory getSellMessageFactory() {
		return new SellMessgaeFactory();
	}
}
