package org.ligson.designmode.creation.factorymethod;

/**
 * @author liuzhongbing
 * 工厂方法模式
 */
public class Farm1 {
	public Animal produce(String type) {
		if (type == "pig") {
			return new Pig();
		} else if (type == "chicken") {
			return new Chicken();
		} else if (type == "cattle") {
			return new Cattle();
		} else if (type == "sheep") {
			return new Sheep();
		} else {
			return new Chicken();
		}
	}
}
