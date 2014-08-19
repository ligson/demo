package org.ligson.designmode.structure.adapter;

/**
 * @author liuzhongbing
 * 按照目标接口来创建实例，并调用该接口的各个实现函数
 */
public class WrapperTest {
	public static void main(String[] args) {
		// 创建源类对象
		Source source = new Source();
		
		// 创建source的包装类对象
		Targetable obj = new Wrapper(source);
		
		// 调用目标类的方法
		obj.operation1();
		obj.operation2();
	}
}
