package org.ligson.designmode.creation.factorymethod;

public class Cattle implements Animal {
	int price = 15;// 价格
	int weight = 500;// 重量
	int milk = 100;// 牛奶
	
	public int sale() {
		return price * weight + milk;
	}
}
