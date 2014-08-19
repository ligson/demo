package org.ligson.designmode.structure.decorator;

/**
 * @author liuzhongbing
 * 装饰器模式
 */
public class Decorator3 implements Sourcable {
	private Sourcable source;

	/**
	 * 取得源类对象
	 */
	public Decorator3(Sourcable source) {
		super();
		this.source = source;
	}

	/**
	 * 调用源类对象的方法
	 */
	public void operation() {
		System.out.println("第3个装饰器装饰前");
		source.operation();
		System.out.println("第3个装饰器装饰后");
	}
}
