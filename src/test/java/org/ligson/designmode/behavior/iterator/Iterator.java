package org.ligson.designmode.behavior.iterator;

/**
 * @author liuzhongbing
 * 迭代子接口
 */
public interface Iterator {
	// 前移
	public Object previous();
	public boolean hasPrevious();
	// 后移
	public Object next();
	public boolean hasNext();
	// 第一个
	public Object first();
	public boolean isFirst();
	// 最后一个
	public Object last();
	public boolean isLast();
}
