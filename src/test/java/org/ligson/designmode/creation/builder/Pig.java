package org.ligson.designmode.creation.builder;

public class Pig implements Animal {
	int price = 10;// 价格
	int weight = 200;// 重量

	public int sale() {
		return price * weight;
	}
}
