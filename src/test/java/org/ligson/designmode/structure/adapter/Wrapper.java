package org.ligson.designmode.structure.adapter;

/**
 * @author liuzhongbing
 * 包装器模式
 */
public class Wrapper implements Targetable {
	private Source source;

	/**
	 * 取得源类对象
	 */
	public Wrapper(Source source) {
		super();
		this.source = source;
	}

	/**
	 * 调用源类对象的方法
	 */
	public void operation1() {
		source.operation1();
	}

	/**
	 * 实现目标类的新接口函数
	 */
	public void operation2() {
		System.out.println("包装目标类后的方法");
	}
}
