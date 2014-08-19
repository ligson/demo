package org.ligson.designmode.structure.proxy;

/**
 * @author liuzhongbing
 */
public class Client {
	public static void main(String[] args) {
		// 创建代理对象
		Sourcable proxy = new Proxy();

		// 调用代理对象的方法
		proxy.operation();
	}
}
