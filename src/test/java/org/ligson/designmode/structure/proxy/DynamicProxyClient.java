package org.ligson.designmode.structure.proxy;

import java.lang.reflect.InvocationHandler;

public class DynamicProxyClient {
	public static void main(String[] args) {
		// 创建原始类对象
		Sourcable source = new Source();
		// 创建代理实例
		InvocationHandler handler = new DynamicProxy(source);
		// 取得代理对象
		Sourcable proxy = (Sourcable) java.lang.reflect.Proxy.newProxyInstance(source.getClass()
		        .getClassLoader(), source.getClass().getInterfaces(), handler);
		proxy.operation();
	}
}
