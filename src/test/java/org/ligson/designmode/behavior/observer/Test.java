package org.ligson.designmode.behavior.observer;

public class Test {

	public static void main(String[] args) {
		Subject subject = new MySubject();
		// 增加观察者
		subject.attach(new Observer1());
		subject.attach(new Observer2());
		subject.operation();
	}
}
