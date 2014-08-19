package org.ligson.designmode.creation.factorymethod;

/**
 * @author liuzhongbing
 * 多个工厂方法模式
 */
public class Farm2 {
	public Animal producePig() {
		return new Pig();
	}

	public Animal produceChicken() {
		return new Chicken();
	}

	public Animal produceCattle() {
		return new Cattle();
	}

	public Animal produceSheep() {
		return new Sheep();
	}
}
