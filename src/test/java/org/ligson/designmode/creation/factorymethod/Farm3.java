package org.ligson.designmode.creation.factorymethod;

/**
 * @author liuzhongbing
 * 简单工厂模式 - 静态工厂方法模式
 */
public class Farm3 {
	public static Animal producePig() {
		return new Pig();
	}

	public static Animal produceChicken() {
		return new Chicken();
	}

	public static Animal produceCattle() {
		return new Cattle();
	}

	public static Animal produceSheep() {
		return new Sheep();
	}
}
