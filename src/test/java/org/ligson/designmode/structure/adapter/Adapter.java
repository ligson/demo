package org.ligson.designmode.structure.adapter;

/**
 * @author liuzhongbing
 * 适配器模式，继承源类，并实现目标接口
 */
public class Adapter extends Source implements Targetable {
	/**
	 * 实现目标类的新接口函数
	 */
	public void operation2() {
		System.out.println("适配目标类后的方法");
	}
}
