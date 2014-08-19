package org.ligson.designmode.creation.singleton;

import java.util.Properties;
import java.io.FileInputStream;

public class PropertiesFactory {
	//(1)私有的防止外部引用
	private static PropertiesFactory _instance = null;
	private Properties properties = new Properties();
	
	//(2)私有的默认构造函数，防止使用构造函数进行实例化
	private PropertiesFactory() {
		try {
			properties.load(new FileInputStream("src/creation/singleton/user.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//(3)单例静态工厂方法，同步防止多线程环境同时执行
	synchronized public static PropertiesFactory getInstance() {
		if (_instance == null) {
			_instance = new PropertiesFactory();
		}
		return _instance;
	}
	
	//(4)重写该函数，默认的clone()函数会创建新的实例
	public PropertiesFactory clone() {
		return getInstance();
	}
	
	public String getConfig(String key) {
		return properties.getProperty(key);
	}
}
