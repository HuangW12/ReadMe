package cn.tools;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
//读取配置文件的工具类---单例模式
public class ConfigManager {
	//类加载的时候，自行进行初始化操作
		private static ConfigManager configManager = new ConfigManager();
		private static Properties properties;
		
		//私有构造器-读取配置文件
		private ConfigManager(){
			String configFile = "database.properties";
			properties = new Properties();
			//通过classpath找资源
			InputStream is = ConfigManager.class.getClassLoader().getResourceAsStream(configFile);
			try {
				properties.load(is);
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		/*
		 * 线程不安全，在并发环境下，很有可能会出现多个configManager实例
		 * 需要考虑同步,可以采用synchronized
		 * 懒汉模式
		 */
		//全局访问点
		/*public static synchronized ConfigManager getInstance(){
			if(configManager == null){
				configManager = new ConfigManager();
			}
			return configManager;
		}*/
		
		//饿汉模式
		public static ConfigManager getInstance(){
			return configManager;
		}
		
		
		public String getValue(String key){
			return properties.getProperty(key);
		}
}
