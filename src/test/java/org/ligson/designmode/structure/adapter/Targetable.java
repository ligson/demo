package org.ligson.designmode.structure.adapter;

/**
 * @author liuzhongbing
 * 目标接口
 */
public interface Targetable {
	/**
	 * 与源类相同的接口函数
	 */
	public void operation1();
	
	/**
	 * 新的接口函数，源类中没有
	 */
	public void operation2();
}
