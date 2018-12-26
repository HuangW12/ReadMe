/**  

* @Title: TransactionProxy.java  

* @Description:   

* @author 黄文 

* @date 2018年11月11日  

* @version 1.0  

*/  

package cn.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;

import cn.util.JdbcUtils;

/**  

* @Title: TransactionProxy  

* @Description: 传入需要被代理对象，返回一个代理对象

* @author Hw 

* @date 2018年11月11日  

*/

public class TransactionProxy {
	
	public static Object proxyFor(Object object) {
		return Proxy.newProxyInstance(object.getClass().getClassLoader(), 
										object.getClass().getInterfaces(), 
										new TransactionInvocationHandler(object)
				                      );
	}
}	
class TransactionInvocationHandler implements InvocationHandler{

	private Object porxy;
	
	/**  
	
	* @Title: 
	
	* @Description: 构造函数 
	  
	
	*/

	public TransactionInvocationHandler(Object object) {
		this.porxy = object;
	}
	
		/* (non-Javadoc)  
		 * <p>Title: invoke</p> 
		 * <p>Description: </P>  
		 * @param obj
		 * @param method 代理对象的方法
		 * @param aobj //代理对象的参数
		 * @return
		 * @throws Throwable  
		 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])  
		 */
		
		@Override
		public Object invoke(Object obj, Method method, Object[] aobj) throws Throwable {
			Connection con = JdbcUtils.getConn();
			con.setAutoCommit(false);
			Object result = null;
			try {
				//调用业务的方法
				result = method.invoke(porxy, aobj);
				con.commit();
			} catch (Exception e) {
				con.rollback();//事务回滚
			}finally {
				con.close();
			}
			return result;
		}
		
	}


