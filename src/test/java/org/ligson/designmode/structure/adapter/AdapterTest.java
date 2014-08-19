package org.ligson.designmode.structure.adapter;

/**
 * @author liuzhongbing
 * 按照目标接口来创建实例，并调用该接口的各个实现函数
 */
public class AdapterTest {
	public static void main(String[] args) {
		// 创建目标接口的类实例
		Targetable obj = new Adapter();
		// 调用目标类的方法
		obj.operation1();
		obj.operation2();
	}
}
