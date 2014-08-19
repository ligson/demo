package org.ligson.designmode.creation.abstractfactory;

public class Chicken implements Animal {
	int price = 5;// 价格
	int weight = 5;// 重量
	int egg = 20;// 鸡蛋

	public int sale() {
		return price * weight + egg;
	}
}
