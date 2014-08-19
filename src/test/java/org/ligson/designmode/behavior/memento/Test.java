package org.ligson.designmode.behavior.memento;

public class Test {

	public static void main(String[] args) {
		ClassA classa = new ClassA("小张");
		// 创建备忘录
		ClassB classb = new ClassB(classa.createMemento());
		// 修改自身状态
		classa.setValue("小李");
		// 回复备忘录
		classa.restoreMemento(classb.getMemento());
	}
}
