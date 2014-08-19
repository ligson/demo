package org.ligson.designmode.structure.decorator;

/**
 * @author liuzhongbing 按照目标接口来创建实例，并调用该接口的各个实现函数
 */
public class DecoratorTest {
	public static void main(String[] args) {
		// 创建源类对象
		Sourcable source = new Source();

		// 装饰类对象
		Sourcable obj = 
			new Decorator1(
				new Decorator2(
						new Decorator3(source)
				)
			);

		// 调用目标类的方法
		obj.operation();
	}
}
