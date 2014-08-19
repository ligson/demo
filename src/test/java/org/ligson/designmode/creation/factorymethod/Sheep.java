package org.ligson.designmode.creation.factorymethod;

public class Sheep implements Animal {
	int price = 10;// 价格
	int weight = 100;// 重量
	int wool = 50;// 羊毛
	
	public int sale() {
		return price * weight + wool;
	}
}
