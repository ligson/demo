package org.ligson.designmode.structure.proxy;

/**
 * @author liuzhongbing
 * 代理模式
 */
public class Proxy implements Sourcable {
	private Source source;

	/**
	 * 创建代理对象
	 */
	public Proxy() {
		super();
		this.source = new Source();
	}

	/**
	 * 调用代理对象的方法
	 */
	public void operation() {
		before();
		source.operation();
		after();
	}
	
	public void before() {
		System.out.println("代理前");
	}
	
	public void after() {
		System.out.println("代理后");
	}
}
