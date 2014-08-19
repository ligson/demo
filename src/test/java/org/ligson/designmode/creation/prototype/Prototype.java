package org.ligson.designmode.creation.prototype;

/**
 * @author liuzhongbing
 * 原型模式
 */
public class Prototype implements Cloneable{
	/**
	 * 浅复制
	 */
	public Object clone() throws CloneNotSupportedException {
		Prototype prototype = (Prototype) super.clone();
		return prototype;
	}
}