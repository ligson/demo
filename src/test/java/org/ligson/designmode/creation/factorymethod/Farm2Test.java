package org.ligson.designmode.creation.factorymethod;

public class Farm2Test {
	public static void test(int count1, int count2, int count3, int count4) {
		// 创建工厂实例
		Farm2 farm = new Farm2();

		// 生产对象
		Animal animal1 = farm.producePig();
		Animal animal2 = farm.produceChicken();
		Animal animal3 = farm.produceCattle();
		Animal animal4 = farm.produceSheep();

		// 计算收入
		int money1 = animal1.sale() * count1;
		int money2 = animal2.sale() * count2;
		int money3 = animal3.sale() * count3;
		int money4 = animal4.sale() * count4;
		System.out.println("Fram2养猪收入：" + money1);
		System.out.println("Fram2养鸡收入：" + money2);
		System.out.println("Fram2养牛收入：" + money3);
		System.out.println("Fram2养羊收入：" + money4);

		// 计算总收入
		int sum = money1 + money2 + money3 + money4;
		System.out.println("Fram2总收入：" + sum);
	}

	public static void main(String[] args) {
		Farm2Test.test(20, 1000, 10, 50);
	}
}
