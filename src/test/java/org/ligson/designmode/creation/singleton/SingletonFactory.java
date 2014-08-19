package org.ligson.designmode.creation.singleton;

public class SingletonFactory {
	//(1)私有的防止外部引用
	private static SingletonFactory _instance = null;
	
	//(2)私有的默认构造函数，防止使用构造函数进行实例化
	private SingletonFactory() {
	}
	
	//(3)单例静态工厂方法，同步防止多线程环境同时执行
	synchronized public static SingletonFactory getInstance() {
		if (_instance == null) {
			_instance = new SingletonFactory();
		}
		return _instance;
	}
	
	//(4)重写该函数，默认的clone()函数会创建新的实例
	public SingletonFactory clone() {
		return getInstance();
	}
}
