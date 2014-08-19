package org.ligson.designmode.creation.abstractfactory;

public class Farm4Test {
	public static void test(int count1, int count2, int count3, int count4) {
		// 生产猪
		Farm4 farm1 = new Farm4Pig();
		Animal animal1 = farm1.produce();

		// 生产鸡
		Farm4 farm2 = new Farm4Chicken();
		Animal animal2 = farm2.produce();

		// 生产牛
		Farm4 farm3 = new Farm4Cattle();
		Animal animal3 = farm3.produce();

		// 生产羊
		Farm4 farm4 = new Farm4Sheep();
		Animal animal4 = farm4.produce();

		// 计算收入
		int money1 = animal1.sale() * count1;
		int money2 = animal2.sale() * count2;
		int money3 = animal3.sale() * count3;
		int money4 = animal4.sale() * count4;
		System.out.println("Fram4养猪收入：" + money1);
		System.out.println("Fram4养鸡收入：" + money2);
		System.out.println("Fram4养牛收入：" + money3);
		System.out.println("Fram4养羊收入：" + money4);

		// 计算总收入
		int sum = money1 + money2 + money3 + money4;
		System.out.println("Fram4总收入：" + sum);
	}

	public static void main(String[] args) {
		Farm4Test.test(20, 1000, 10, 50);
	}
}
