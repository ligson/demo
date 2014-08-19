package org.ligson.designmode.creation.builder;

public class Farm5Test {
	public static void test() {
		// 创建工厂
		Farm5 farm = new Farm5();
		farm.producePig(20);// 生产20头猪
		farm.produceChicken(1000);// 生产1000只鸡
		farm.produceCattle(10);// 生产10头牛
		farm.produceSheep(50);// 生产50只养

		// 计算总收入
		int sum = farm.sum();
		System.out.println("Fram5总收入：" + sum);
	}

	public static void main(String[] args) {
		Farm5Test.test();
	}
}
