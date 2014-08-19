package org.ligson.designmode.behavior.iterator;

/**
 * @author liuzhongbing 集合接口
 */
public interface Collection {
	// 取得迭代子
	public Iterator iterator();

	// 取得集合元素
	public Object get(int i);

	// 取得集合大小
	public int size();
}
